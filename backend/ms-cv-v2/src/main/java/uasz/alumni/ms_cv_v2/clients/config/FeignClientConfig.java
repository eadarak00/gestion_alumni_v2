package uasz.alumni.ms_cv_v2.clients.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class FeignClientConfig {

    @Bean
    public RequestInterceptor requestInterceptor() {
        return new RequestInterceptor() {
            @Override
            public void apply(RequestTemplate template) {
                log.debug("Feign Interceptor - Préparation de la requête vers: {}", template.feignTarget().name());
                
                // Méthode 1: Récupérer le token du contexte de sécurité
                Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
                
                if (authentication != null) {
                    log.debug("Authentication trouvée: {}", authentication.getClass().getName());
                    
                    // Cas 1: Si l'authentification contient le token dans les détails
                    if (authentication instanceof UsernamePasswordAuthenticationToken) {
                        Object details = authentication.getDetails();
                        if (details instanceof String token) {
                            log.debug("Token trouvé dans authentication.details");
                            template.header("Authorization", "Bearer " + token);
                        }
                    }
                    
                    // Cas 2: Si le principal est un Long (userId), récupérer le token de la requête HTTP
                    if (authentication.getPrincipal() instanceof Long userId) {
                        log.debug("Principal est userId: {}", userId);
                        String token = getTokenFromCurrentRequest();
                        if (token != null) {
                            template.header("Authorization", "Bearer " + token);
                            log.debug("Token ajouté au header Feign");
                        }
                    }
                }
                
                // Méthode alternative: Récupérer directement de la requête HTTP actuelle
                String token = getTokenFromCurrentRequest();
                if (token != null) {
                    template.header("Authorization", "Bearer " + token);
                    log.debug("Token récupéré de la requête HTTP actuelle");
                }
                
                // Ajouter des headers pour les appels internes
                template.header("X-Internal-Request", "true");
                template.header("X-Service-Name", "ms-cv-v2");
                template.header("X-Requested-With", "XMLHttpRequest");
                
                log.debug("Headers Feign configurés");
            }
            
            private String getTokenFromCurrentRequest() {
                try {
                    ServletRequestAttributes attributes = 
                        (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
                    
                    if (attributes != null) {
                        HttpServletRequest request = attributes.getRequest();
                        String authHeader = request.getHeader("Authorization");
                        
                        if (authHeader != null && authHeader.startsWith("Bearer ")) {
                            return authHeader.substring(7);
                        }
                    }
                } catch (Exception e) {
                    log.warn("Impossible de récupérer le token de la requête: {}", e.getMessage());
                }
                return null;
            }
        };
    }
}