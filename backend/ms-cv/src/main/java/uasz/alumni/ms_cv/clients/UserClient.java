package uasz.alumni.ms_cv.clients;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "ms-user", path = "/internal")
public interface UserClient {

    @GetMapping("/etudiants/etudiant-connecte")
    EtudiantResponseDTO getEtudiantConnecte();
}
