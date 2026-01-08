package uasz.alumni.ms_cv_v2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MsCvV2Application {

	public static void main(String[] args) {
		SpringApplication.run(MsCvV2Application.class, args);
	}

}
