package in.thiru.rest;

import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

@RestController
public class WelcomeRestController {

    @GetMapping("/get")
    public String getMessage() {
        String apiUrl = "http://localhost:1111/welcome";
        String username = "thiru";
        String password = "thiru@123";
        String combinedCredentials = username + ":" + password;
        String encodedCredentials = Base64.getEncoder().encodeToString(combinedCredentials.getBytes(StandardCharsets.UTF_8));

        return WebClient.create(apiUrl)
                .get()
                .header(HttpHeaders.AUTHORIZATION, "Basic " + encodedCredentials)
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }
}
