package uasz.alumni.ms_cv_v2.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;
import uasz.alumni.ms_cv_v2.entities.Template;
import uasz.alumni.ms_cv_v2.entities.TemplateSection;
import uasz.alumni.ms_cv_v2.exceptions.CvGenerationException;
import uasz.alumni.ms_cv_v2.repository.TemplateRepository;
import uasz.alumni.spi.model.CvResponseDTO;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.ByteArrayOutputStream;

@Service
@RequiredArgsConstructor
@Slf4j // Ajouter Lombok Slf4j pour les logs
public class CvPdfService {

    private final TemplateRepository templateRepository;

    public byte[] generatePdf(CvResponseDTO cv) {
        try {
            log.info("Génération PDF pour le CV ID: {}", cv.getId());

            Template template = templateRepository.findById(cv.getTemplateId())
                    .orElseThrow(() -> new RuntimeException("Template introuvable"));

            // Assembler toutes les sections
            StringBuilder htmlBuilder = new StringBuilder();
            template.getSections().stream()
                    .sorted(Comparator.comparing(TemplateSection::getOrdre))
                    .forEach(section -> {
                        String content = section.getHtmlContent();
                        content = replacePlaceholders(content, cv);
                        htmlBuilder.append(content);
                    });

            // Ajouter une enveloppe HTML avec CSS global
            String finalHtml = wrapHtml(htmlBuilder.toString());

            // VALIDATION : Afficher l'HTML généré pour debug
            log.debug("HTML généré pour PDF (premiers 500 caractères): {}",
                    finalHtml.substring(0, Math.min(finalHtml.length(), 500)));

            // CORRECTION IMPORTANTE : Utiliser setDocument avec StringReader
            try (ByteArrayOutputStream os = new ByteArrayOutputStream()) {
                ITextRenderer renderer = new ITextRenderer();

                // Utiliser setDocumentFromString pour le contenu HTML direct
                renderer.setDocumentFromString(finalHtml);

                renderer.layout();
                renderer.createPDF(os);

                byte[] pdfBytes = os.toByteArray();
                log.info("PDF généré avec succès, taille: {} bytes", pdfBytes.length);
                return pdfBytes;
            }

        } catch (Exception e) {
            log.error("Erreur lors de la génération du PDF pour le CV ID: {}", cv.getId(), e);
            throw new CvGenerationException("Erreur lors de la génération du PDF", e);
        }
    }

    private String replacePlaceholders(String html, CvResponseDTO cv) {
        // Vérifier que le HTML n'est pas null
        if (html == null)
            return "";

        String result = html;

        // Remplacements avec vérifications
        result = result.replace("${cv.titreProfil}", safe(cv.getTitreProfil()));
        result = result.replace("${cv.email}", safe(cv.getEmail()));
        result = result.replace("${cv.telephone}", safe(cv.getTelephone()));
        result = result.replace("${cv.adresse}", safe(cv.getAdresse()));
        result = result.replace("${cv.resumeProfil}", safe(cv.getResumeProfil()));

        // Remplacements des listes avec HTML valide
        result = result.replace("${cv.formations}",
                toHtmlList(cv.getFormations(), f -> safe(f.getDiplome()) + " - " + safe(f.getEtablissement()) +
                        " (" + safe(f.getAnneeDebut()) + " - " + safe(f.getAnneeFin()) + ")"));

        result = result.replace("${cv.experiences}",
                toHtmlList(cv.getExperiences(), e -> safe(e.getPoste()) + " - " + safe(e.getEntreprise()) +
                        " (" + safe(e.getDateDebut()) + " - " + safe(e.getDateFin()) + ")" +
                        (e.getDescription() != null ? "<br/><small>" + safe(e.getDescription()) + "</small>" : "")));

        result = result.replace("${cv.competences}",
                toHtmlList(cv.getCompetences(),
                        c -> safe(c.getNom()) + " (" + safe(c.getNiveau()) + ")"));

        result = result.replace("${cv.langues}",
                toHtmlList(cv.getLangues(),
                        l -> safe(l.getNom()) + " (" + safe(l.getNiveau()) + ")"));

        result = result.replace("${cv.interets}",
                toHtmlList(cv.getInterets(),
                        i -> safe(i.getLibelle())));

        return result;
    }

    private <T> String toHtmlList(List<T> items, Function<T, String> mapper) {
        if (items == null || items.isEmpty()) {
            return "<ul><li>Aucune information</li></ul>";
        }

        StringBuilder sb = new StringBuilder("<ul>");
        items.forEach(item -> {
            String content = mapper.apply(item);
            // Échapper les caractères HTML dangereux
            content = content.replace("<", "&lt;").replace(">", "&gt;");
            sb.append("<li>").append(content).append("</li>");
        });
        sb.append("</ul>");

        return sb.toString();
    }

    private String safe(String value) {
        if (value == null)
            return "";
        // Échapper les caractères spéciaux HTML
        return value
                .replace("&", "&amp;")
                .replace("<", "&lt;")
                .replace(">", "&gt;")
                .replace("\"", "&quot;")
                .replace("'", "&#39;");
    }

    private String wrapHtml(String bodyContent) {
        // CORRECTION: Utiliser /> pour fermer la balise meta
        return "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\" />\n" + // <- ICI: ajouter />
                "    <style>\n" +
                "        body { font-family: Arial, sans-serif; font-size: 11pt; line-height: 1.4; margin: 20px; }\n" +
                "        h1 { color: #2c3e50; font-size: 18pt; margin-bottom: 10px; }\n" +
                "        h2 { color: #34495e; font-size: 14pt; margin-top: 15px; margin-bottom: 8px; border-bottom: 1px solid #eee; padding-bottom: 4px; }\n"
                +
                "        h3 { color: #7f8c8d; font-size: 12pt; margin-bottom: 6px; }\n" +
                "        ul { margin: 5px 0; padding-left: 20px; }\n" +
                "        li { margin-bottom: 4px; }\n" +
                "        p { margin: 8px 0; }\n" +
                "        .section { margin-bottom: 15px; }\n" +
                "        .info-item { margin-bottom: 5px; }\n" +
                "    </style>\n" +
                "</head>\n" +
                "<body>\n" +
                bodyContent + "\n" +
                "</body>\n" +
                "</html>";
    }
}
