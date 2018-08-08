package narayan.remittance.authserver.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/resource/message")
	public String message() {
		return "this is protected message";
	}
}
