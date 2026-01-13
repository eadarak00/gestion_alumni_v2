package uasz.alumni.ms_gateway.security;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class JwtGatewayFilter implements GlobalFilter, Ordered {

    private final JwtGatewayService jwtGatewayService;

    // Liste des endpoints publics (pas besoin de JWT)
    private static final List<String> PUBLIC_PATHS = List.of(
            "/api-users/v1/auth",
            "/api-users/v1/validation",
            "/actuator/health",
            "/api-ms-cv2/health",
            "/ms-user/health");

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String path = exchange.getRequest().getPath().toString();

        log.debug("Gateway filter processing request: {}", path);

        // Vérifier si c'est un endpoint public
        if (isPublicPath(path)) {
            log.debug("Public endpoint, skipping JWT validation: {}", path);
            return chain.filter(exchange);
        }

        // Récupérer le header Authorization
        String authHeader = exchange.getRequest().getHeaders().getFirst(HttpHeaders.AUTHORIZATION);

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            log.warn("Missing or invalid Authorization header for path: {}", path);
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();
        }

        String token = authHeader.substring(7);

        // Valider le token JWT
        if (!jwtGatewayService.isTokenValid(token)) {
            log.warn("Invalid JWT token for path: {}", path);
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();
        }

        log.debug("Valid JWT token, forwarding request to: {}", path);

        // Créer une nouvelle requête avec le header Authorization explicitement défini
        // (Même si le header est déjà là, cela garantit qu'il est préservé/propagé)
        org.springframework.http.server.reactive.ServerHttpRequest request = exchange.getRequest().mutate()
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + token)
                .build();

        // Continuer avec la nouvelle requête mutée
        return chain.filter(exchange.mutate().request(request).build());
    }

    private boolean isPublicPath(String path) {
        return PUBLIC_PATHS.stream().anyMatch(path::startsWith);
    }

    @Override
    public int getOrder() {
        // S'exécuter en premier (avant les autres filtres)
        return -1;
    }
}
