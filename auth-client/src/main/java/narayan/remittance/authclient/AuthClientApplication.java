package narayan.remittance.authclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;

@EnableOAuth2Client
@SpringBootApplication
public class AuthClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthClientApplication.class, args);
	}
	
	
	@Bean
	public OAuth2RestTemplate restTemplate() {
		return new OAuth2RestTemplate(resource(), new DefaultOAuth2ClientContext());
	}
	
	@Bean
	public OAuth2ProtectedResourceDetails resource() {
		ResourceOwnerPasswordResourceDetails d = new ResourceOwnerPasswordResourceDetails();
		d.setAccessTokenUri("http://localhost:9090/oauth/token");
		d.setClientId("remittance");
		d.setClientSecret("secret");
		d.setGrantType("password");
		return d;
	}
	
}
