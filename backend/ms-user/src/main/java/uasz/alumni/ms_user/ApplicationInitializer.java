package uasz.alumni.ms_user;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import uasz.alumni.ms_user.common.fixtures.RoleFixture;

@Component
@RequiredArgsConstructor
@Slf4j
public class ApplicationInitializer {

    private final RoleFixture roleFixture;

    /**
     * Initialise les données de l'application après le démarrage du contexte Spring
     */
    @PostConstruct
    public void init() {
        log.info("Initialisation des données de l'application...");

        try {
            roleFixture.init();
            log.info("Initialisation terminée avec succès.");
        } catch (Exception ex) {
            log.error("Erreur lors de l'initialisation des données de l'application", ex);
            // Selon la criticité, tu peux aussi relancer l'exception pour stopper l'application
            throw ex;
        }
    }
}
