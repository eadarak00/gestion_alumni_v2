package uasz.alumni.ms_invitation.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import uasz.alumni.spi.model.AlumniResponseDTO;


@FeignClient(name = "ms-user", url = "${ms-user.url}")
public interface AlumniFeignClient {

    @GetMapping("/api/v1/users/{id}")
    AlumniResponseDTO getUserById(@PathVariable("id") String id);
}
