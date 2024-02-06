package in.thiru.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

	@GetMapping(value = "/welcome")
	public String getWelcomeMsg() {
		return "welcome to ashokit";
	}

}
