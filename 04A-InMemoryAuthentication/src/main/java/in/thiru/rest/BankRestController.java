package in.thiru.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BankRestController {

	@GetMapping("/login")
	public String loginPage() {
		return "LOGIN HERE";
	}

	@GetMapping("/transfer")
	public String transfer() {
		return "your tranfering amount is :: 5000RS";
	}

	@GetMapping("/balance")
	public String balance() {
		return "your balance is :: 60000RS";
	}

	@GetMapping("/aboutUs")
	public String aboutUs() {
		return "welcome to thiru it we are providing all software courses here";
	}

	@GetMapping("/contact")
	public String contactUs() {
		return "contact no ::91-9745645564";
	}

}
