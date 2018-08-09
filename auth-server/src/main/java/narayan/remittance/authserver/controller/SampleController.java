package narayan.remittance.authserver.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {

	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/resource/message")
	public String message() {
		return "this is protected message";
	}
}
