package uasz.alumni.ms_user.services;

import jakarta.annotation.PostConstruct;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmailService {

    private final JavaMailSender mailSender;

    @Value("${app.email.from}")
    private String fromEmail;

    @Value("${spring.mail.username}")
    private String mailUsername;

    @PostConstruct
    private void init() {
        Objects.requireNonNull(mailUsername, "La propriété spring.mail.username ne doit pas être null");
        Objects.requireNonNull(fromEmail, "La propriété app.email.from ne doit pas être null");
        log.info("EmailService initialisé avec fromEmail={} et mailUsername={}", fromEmail, mailUsername);
    }

    public void envoyerEmail(@NonNull String to, @NonNull String subject, @NonNull String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(fromEmail);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);

        mailSender.send(message);
        log.info("Email simple envoyé à {}", to);
    }

    public void envoyerHtml(String to, String subject, String htmlContent) throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");

        try {
            helper.setFrom(new InternetAddress("djibyf573@gmail.com", "Service de Gestion Alumni"));
        } catch (UnsupportedEncodingException e) {
            helper.setFrom("djibyf573@gmail.com"); // fallback sans nom
        }

        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(htmlContent, true);

        mailSender.send(mimeMessage);
    }
}