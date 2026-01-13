package uasz.alumni.ms_cv_v2.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import uasz.alumni.ms_cv_v2.clients.dto.UtilisateurResponseDto;
import uasz.alumni.ms_cv_v2.clients.config.FeignClientConfig;

@FeignClient(
    name = "ms-user",
    configuration = FeignClientConfig.class  // <-- Ajoutez cette ligne
)
public interface UserClient {

    @GetMapping("/internal/users/{id}")
    UtilisateurResponseDto getUtilisateur(@PathVariable Long id);
}