package uasz.alumni.ms_user;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableAsync;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@EnableDiscoveryClient
@EnableJpaAuditing
@EnableAsync
@ComponentScan(basePackages = {"uasz.alumni.ms_user"})
@RequiredArgsConstructor
@Slf4j
public class MsUserApplication implements CommandLineRunner {

    private final ApplicationInitializer appInit;

    public static void main(String[] args) {
        SpringApplication.run(MsUserApplication.class, args);
    }

    /**
     * Point d'entrée après le démarrage du contexte Spring
     */
    @Override
    public void run(String... args) {
        log.info("Démarrage de l'application MS-User...");

        try {
            appInit.init();
            log.info("Initialisation des données terminée avec succès.");
        } catch (Exception ex) {
            log.error("Erreur lors de l'initialisation des données", ex);
            // Relancer si l'application ne peut pas fonctionner sans ces données
            throw ex;
        }

        log.info("Application MS-User prête.");
    }
}
