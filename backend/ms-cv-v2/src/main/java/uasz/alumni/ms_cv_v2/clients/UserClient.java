package uasz.alumni.ms_cv_v2.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import uasz.alumni.ms_cv_v2.clients.dto.UtilisateurResponseDto;

@FeignClient(name = "ms-user", url = "http://localhost:8081")
public interface UserClient {

    @GetMapping("/internal/users/{id}")
    public UtilisateurResponseDto getUtilisateur(@PathVariable Long id);

}
