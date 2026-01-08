package uasz.alumni.ms_cv_v2.services;

import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfWriter;
import lombok.extern.slf4j.Slf4j;
import uasz.alumni.ms_cv_v2.dtos.CvResponseDTO;
import uasz.alumni.ms_cv_v2.dtos.ExperienceResponseDTO;
import uasz.alumni.ms_cv_v2.dtos.FormationResponseDTO;
import uasz.alumni.ms_cv_v2.dtos.InteretResponseDTO;

import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.util.List;

@Service
@Slf4j
public class CvPdfService{

    public ByteArrayOutputStream generatePdf(CvResponseDTO cv) {

        Document document = new Document(PageSize.A4, 36, 36, 36, 36);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        try {
            PdfWriter.getInstance(document, baos);
            document.open();

            // ================= HEADER =================
            Font titleFont = new Font(Font.HELVETICA, 20, Font.BOLD);
            Font sectionFont = new Font(Font.HELVETICA, 14, Font.BOLD);
            Font normalFont = new Font(Font.HELVETICA, 12, Font.NORMAL);

            // Nom + Titre Profil
            Paragraph header = new Paragraph(cv.getTitreProfil(), titleFont);
            header.setAlignment(Element.ALIGN_CENTER);
            document.add(header);

            // Coordonnées
            Paragraph coord = new Paragraph(
                    String.format("%s | %s | %s", cv.getEmail(), cv.getTelephone(), cv.getAdresse()),
                    normalFont);
            coord.setAlignment(Element.ALIGN_CENTER);
            coord.setSpacingAfter(20);
            document.add(coord);

            // ================= RESUME =================
            if (cv.getResumeProfil() != null) {
                Paragraph resume = new Paragraph("Résumé", sectionFont);
                resume.setSpacingBefore(10);
                document.add(resume);

                Paragraph resumeText = new Paragraph(cv.getResumeProfil(), normalFont);
                resumeText.setSpacingAfter(10);
                document.add(resumeText);
            }

            // ================= FORMATIONS =================
            if (!cv.getFormations().isEmpty()) {
                Paragraph section = new Paragraph("Formations", sectionFont);
                section.setSpacingBefore(10);
                document.add(section);

                for (FormationResponseDTO f : cv.getFormations()) {
                    Paragraph p = new Paragraph(
                            String.format("%s, %s (%s - %s)", f.getDiplome(), f.getEtablissement(), f.getAnneeDebut(), f.getAnneeFin()),
                            normalFont);
                    p.setSpacingAfter(5);
                    document.add(p);
                }
            }

            // ================= EXPERIENCES =================
            if (!cv.getExperiences().isEmpty()) {
                Paragraph section = new Paragraph("Expériences", sectionFont);
                section.setSpacingBefore(10);
                document.add(section);

                for (ExperienceResponseDTO e : cv.getExperiences()) {
                    Paragraph p = new Paragraph(
                            String.format("%s, %s (%s - %s)\n%s", e.getPoste(), e.getEntreprise(), e.getDateDebut(), e.getDateFin(), e.getDescription()),
                            normalFont);
                    p.setSpacingAfter(5);
                    document.add(p);
                }
            }

            // ================= COMPETENCES =================
            if (!cv.getCompetences().isEmpty()) {
                Paragraph section = new Paragraph("Compétences", sectionFont);
                section.setSpacingBefore(10);
                document.add(section);

                String competences = cv.getCompetences().stream()
                        .map(c -> c.getNom() + " (" + c.getNiveau() + ")")
                        .reduce((a, b) -> a + ", " + b)
                        .orElse("");
                document.add(new Paragraph(competences, normalFont));
            }

            // ================= LANGUES =================
            if (!cv.getLangues().isEmpty()) {
                Paragraph section = new Paragraph("Langues", sectionFont);
                section.setSpacingBefore(10);
                document.add(section);

                String langues = cv.getLangues().stream()
                        .map(l -> l.getNom() + " (" + l.getNiveau() + ")")
                        .reduce((a, b) -> a + ", " + b)
                        .orElse("");
                document.add(new Paragraph(langues, normalFont));
            }

            // ================= INTERETS =================
            if (!cv.getInterets().isEmpty()) {
                Paragraph section = new Paragraph("Centres d'intérêt", sectionFont);
                section.setSpacingBefore(10);
                document.add(section);

                String interets = cv.getInterets().stream()
                        .map(InteretResponseDTO::getLibelle)
                        .reduce((a, b) -> a + ", " + b)
                        .orElse("");
                document.add(new Paragraph(interets, normalFont));
            }

            document.close();

        } catch (DocumentException e) {
            log.error("Erreur génération PDF", e);
        }

        return baos;
    }
}
