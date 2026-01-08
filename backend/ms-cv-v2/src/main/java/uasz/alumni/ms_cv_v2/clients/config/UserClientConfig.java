package uasz.alumni.ms_cv_v2.clients.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.RequestInterceptor;

@Configuration
public class UserClientConfig {
    @Bean
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> {
            String token = ""; // récupérer token courant
            requestTemplate.header("Authorization", "Bearer " + token);
        };
    }
}
