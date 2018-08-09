package narayan.remittance.authclient.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.AccessTokenRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {
	
	@Autowired
	private OAuth2RestTemplate restTemplate;
	
	@GetMapping("/execute")
	public String execute(Principal principal) throws URISyntaxException {
		User user = (User) ((Authentication) principal).getPrincipal();
		URI uri = new URI("http://localhost:9090/resource/message");
		
		RequestEntity<String> req = new RequestEntity<>(HttpMethod.POST, uri);
		
		AccessTokenRequest atr = restTemplate.getOAuth2ClientContext().getAccessTokenRequest();
		atr.set("username", user.getUsername());
		atr.set("password", user.getPassword());
		
		return restTemplate.exchange(req, String.class).getBody();
	}
}
