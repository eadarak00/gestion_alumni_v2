package uasz.alumni.ms_cv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MsCvApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsCvApplication.class, args);
	}

}
