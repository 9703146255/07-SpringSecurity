package in.thiru.service;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class WelcomeRestController {

	String apiUrl = "http://localhost:1111/welcome";
	String username = "thiru";
	String password = "thiru@123";

	@GetMapping("/welcome")
	public String getSecurity() {

		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();
		headers.setBasicAuth(username, password);

		HttpEntity<String> requestEntity = new HttpEntity<>(headers);

		// Make the HTTP GET request
		ResponseEntity<String> responseEntity = restTemplate.exchange(apiUrl, HttpMethod.GET, requestEntity,String.class);

		return responseEntity.getBody();
	}

}
