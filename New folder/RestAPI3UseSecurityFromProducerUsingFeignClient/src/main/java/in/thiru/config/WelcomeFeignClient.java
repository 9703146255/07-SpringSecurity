package in.thiru.config;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "welcomeController", url = "http://localhost:1111/")
public interface WelcomeFeignClient {

	@GetMapping("/welcome")
	String getMessage(@RequestHeader("Authorization") String authorizationHeader);

}
