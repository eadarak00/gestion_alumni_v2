package uasz.alumni.ms_cv_v2.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtService jwtService;

    // @Override
    // protected void doFilterInternal(HttpServletRequest req,
    //         HttpServletResponse res,
    //         FilterChain chain) throws ServletException, IOException {

    //     String authHeader = req.getHeader(HttpHeaders.AUTHORIZATION);

    //     // Le gateway a déjà validé le token, donc ici on peut juste extraire les infos
    //     if (authHeader != null && authHeader.startsWith("Bearer ")) {
    //         String token = authHeader.substring(7);

    //         try {
    //             if (jwtService.isTokenValid(token)) {
    //                 String username = jwtService.extractUsername(token);
    //                 Long userId = jwtService.extractUserId(token);
    //                 List<String> roles = jwtService.extractRoles(token);

    //                 var authorities = roles.stream()
    //                         .map(SimpleGrantedAuthority::new)
    //                         .toList();

    //                 // Créer l'authentication avec userId comme principal
    //                 UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(userId, null,
    //                         authorities);

    //                 // Stocker username dans details si nécessaire
    //                 auth.setDetails(username);

    //                 auth.setDetails(new WebAuthenticationDetailsSource().buildDetails(req));
    //                 SecurityContextHolder.getContext().setAuthentication(auth);
    //             }
    //         } catch (Exception e) {
    //             // Log l'erreur mais continue (le gateway a déjà validé)
    //             logger.warn("Erreur lors du parsing du JWT dans ms-cv-v2: " + e.getMessage());
    //         }
    //     }

    //     chain.doFilter(req, res);
    // }

    @Override
    protected void doFilterInternal(HttpServletRequest req,
            HttpServletResponse res,
            FilterChain chain) throws ServletException, IOException {

        log.info("=== DEBUT JwtAuthenticationFilter ===");
        log.info("URL: {}", req.getRequestURL());
        log.info("Method: {}", req.getMethod());

        String authHeader = req.getHeader(HttpHeaders.AUTHORIZATION);
        log.info("Authorization Header: {}", authHeader);

        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String token = authHeader.substring(7);
            log.info("Token reçu (premiers 20 chars): {}...", token.substring(0, Math.min(20, token.length())));

            try {
                if (jwtService.isTokenValid(token)) {
                    log.info("Token valide");
                    String username = jwtService.extractUsername(token);
                    Long userId = jwtService.extractUserId(token);
                    List<String> roles = jwtService.extractRoles(token);

                    log.info("Username extrait: {}", username);
                    log.info("User ID extrait: {}", userId);
                    log.info("Roles extraits: {}", roles);

                    var authorities = roles.stream()
                            .map(SimpleGrantedAuthority::new)
                            .toList();

                    UsernamePasswordAuthenticationToken auth = 
                        new UsernamePasswordAuthenticationToken(userId, null, authorities);

                    // Stocker username dans details
                    auth.setDetails(username);

                    auth.setDetails(new WebAuthenticationDetailsSource().buildDetails(req));
                    SecurityContextHolder.getContext().setAuthentication(auth);
                    
                    log.info("Authentication établie pour userId: {}", userId);
                } else {
                    log.warn("Token invalide");
                }
            } catch (Exception e) {
                log.error("Erreur lors du parsing du JWT: ", e);
            }
        } else {
            log.warn("Pas de token Bearer dans le header");
        }

        log.info("=== FIN JwtAuthenticationFilter ===");
        chain.doFilter(req, res);
    }
}
