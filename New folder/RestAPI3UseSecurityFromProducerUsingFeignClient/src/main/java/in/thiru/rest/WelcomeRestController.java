package in.thiru.rest;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import in.thiru.config.WelcomeFeignClient;

@RestController
public class WelcomeRestController {

    private final WelcomeFeignClient welcomeFeignClient;

  
    @Autowired
    public WelcomeRestController(WelcomeFeignClient welcomeFeignClient) {
        this.welcomeFeignClient = welcomeFeignClient;
    }

    @GetMapping("/get")
    public String getMessage() {
        String username = "thiru";
        String password = "thiru@123";
        String combinedCredentials = username + ":" + password;
        String encodedCredentials = "Basic " + Base64.getEncoder().encodeToString(combinedCredentials.getBytes(StandardCharsets.UTF_8));

        return welcomeFeignClient.getMessage(encodedCredentials);
    }
}
