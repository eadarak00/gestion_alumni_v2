package uasz.alumni.ms_gateway.security;

import lombok.RequiredArgsConstructor;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class GatewayConfig {

    private final JwtGatewayFilter jwtGatewayFilter;

    @Bean
    public GlobalFilter jwtGlobalFilter() {
        return (exchange, chain) -> jwtGatewayFilter.filter(exchange, chain);
    }
}
