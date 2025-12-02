package uasz.alumni.ms_user.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;


import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
@RequiredArgsConstructor
public class SecurityConfig {

    // Si tu as un UserDetailsService personnalisé ou un filtre JWT,
    // tu peux les injecter ici
    // private final UtilisateurDetailsService utilisateurDetailsService;
    // private final JwtFilter jwtFilter;

    /**
     * Configuration de la sécurité HTTP
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                // Désactivation CSRF car API stateless
                .csrf(csrf -> csrf.disable())

                // CORS configuration par défaut
                .cors(withDefaults())

                // Pas de session, stateless (JWT / token-based)
                .sessionManagement(sm -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS))

                // Définition des règles d'accès
                .authorizeHttpRequests(auth -> auth
                        // Endpoints publics
                        .requestMatchers(
                                "/api/v1/auth/**",
                                "/api/v1/validation/**",
                                "/uploads/**",
                                "/ms-user/**",
                                "/ms-cv/**",
                                "/ms-invitation/**",
                                "/swagger-ui.html",
                                "/webjars/**",
                                "/swagger-resources/**"
                        ).permitAll()

                        // Tous les autres endpoints nécessitent authentification
                        .anyRequest().authenticated()
                )

                // Pour ajouter un UserDetailsService ou JWTFilter :
                // .userDetailsService(utilisateurDetailsService)
                // .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)

                .build();
    }

    /**
     * Bean pour le hash des mots de passe
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
