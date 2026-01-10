package uasz.alumni.ms_cv_v2.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uasz.alumni.ms_cv_v2.dtos.CvResponseDTO;
import uasz.alumni.ms_cv_v2.entities.Template;
import uasz.alumni.ms_cv_v2.repository.TemplateRepository;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.StringJoiner;
import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class CvPdfService {

    private final TemplateRepository templateRepository;

    /**
     * Génère le PDF du CV à partir du template choisi
     */
    public byte[] generatePdf(CvResponseDTO cv) throws Exception {

        Template template = templateRepository.findById(cv.getTemplateId())
                .orElseThrow(() -> new RuntimeException("Template introuvable"));

        // Assembler toutes les sections
        StringBuilder htmlBuilder = new StringBuilder();
        template.getSections().forEach(section -> {
            String content = section.getHtmlContent();
            content = replacePlaceholders(content, cv);
            htmlBuilder.append(content);
        });

        // Ajouter une enveloppe HTML avec CSS global
        String finalHtml = wrapHtml(htmlBuilder.toString());

        // Convertir HTML -> PDF avec Flying Saucer
        try (ByteArrayOutputStream os = new ByteArrayOutputStream()) {
            ITextRenderer renderer = new ITextRenderer();
            renderer.setDocumentFromString(finalHtml);
            renderer.layout();
            renderer.createPDF(os);
            return os.toByteArray();
        }
    }

    /**
     * Remplace les placeholders du template par les valeurs du CV
     */
    private String replacePlaceholders(String html, CvResponseDTO cv) {
        html = html.replace("${cv.titreProfil}", safe(cv.getTitreProfil()));
        html = html.replace("${cv.email}", safe(cv.getEmail()));
        html = html.replace("${cv.telephone}", safe(cv.getTelephone()));
        html = html.replace("${cv.adresse}", safe(cv.getAdresse()));
        html = html.replace("${cv.resumeProfil}", safe(cv.getResumeProfil()));

        html = html.replace("${cv.formations}", toHtmlList(cv.getFormations(), f ->
                safe(f.getDiplome()) + " - " + safe(f.getEtablissement()) + " (" +
                safe(f.getAnneeDebut()) + " - " + safe(f.getAnneeFin()) + ")"
        ));

        html = html.replace("${cv.experiences}", toHtmlList(cv.getExperiences(), e ->
                safe(e.getPoste()) + " - " + safe(e.getEntreprise()) + " (" +
                safe(e.getDateDebut()) + " - " + safe(e.getDateFin()) + ")<p>" +
                safe(e.getDescription()) + "</p>"
        ));

        html = html.replace("${cv.competences}", toHtmlList(cv.getCompetences(),
                c -> safe(c.getNom()) + " (" + safe(c.getNiveau()) + ")"
        ));

        html = html.replace("${cv.langues}", toHtmlList(cv.getLangues(),
                l -> safe(l.getNom()) + " (" + safe(l.getNiveau()) + ")"
        ));

        html = html.replace("${cv.interets}", toHtmlList(cv.getInterets(),
                i -> safe(i.getLibelle())
        ));

        return html;
    }

    /**
     * Transforme une liste d'objets en <ul><li>...</li></ul>
     */
    private <T> String toHtmlList(List<T> items, Function<T, String> mapper) {
        if (items == null || items.isEmpty()) return "<ul></ul>";
        StringJoiner sj = new StringJoiner("", "<ul>", "</ul>");
        items.forEach(item -> sj.add("<li>" + mapper.apply(item) + "</li>"));
        return sj.toString();
    }

    /**
     * Sécurise une valeur null
     */
    private String safe(String value) {
        return value == null ? "" : value;
    }

    /**
     * Enveloppe HTML avec CSS global pour le PDF
     */
    private String wrapHtml(String bodyContent) {
        return "<html><head>"
                + "<style>"
                + "body {font-family: Arial, sans-serif; font-size: 12pt; line-height: 1.4;}"
                + "h1, h2, h3 {color: #333; margin-bottom: 4px;}"
                + "ul {margin: 0; padding-left: 20px;}"
                + "li {margin-bottom: 4px;}"
                + "p {margin: 0;}"
                + "</style>"
                + "</head><body>"
                + bodyContent
                + "</body></html>";
    }
}
