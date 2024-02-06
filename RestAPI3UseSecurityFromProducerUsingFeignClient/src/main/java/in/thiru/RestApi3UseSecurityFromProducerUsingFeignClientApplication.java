package in.thiru;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class RestApi3UseSecurityFromProducerUsingFeignClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestApi3UseSecurityFromProducerUsingFeignClientApplication.class, args);
	}

}
