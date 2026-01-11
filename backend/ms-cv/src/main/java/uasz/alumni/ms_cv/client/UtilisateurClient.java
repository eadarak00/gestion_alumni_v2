package uasz.alumni.ms_cv.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
    name = "utilisateur-service",
    url = "${http://localhost:8081/api/v1}"
    // url = "${application.config.utilisateur-url:http://localhost:8030/api/v1/utilisateur}"
)
public interface UtilisateurClient {
    
    @GetMapping("/{id}")
    UtilisateurResponseDTO findUtilisateurById(@PathVariable("id") Integer id);
}
