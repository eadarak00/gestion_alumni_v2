package uasz.alumni.ms_cv_v2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api-ms-cv2")
public class HealthController {

    @GetMapping("/health")
    public String health() {
        return "ms-cv is running";
    }
}
