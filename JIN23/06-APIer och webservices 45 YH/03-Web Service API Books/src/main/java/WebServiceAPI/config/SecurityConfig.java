package WebServiceAPI.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
				.csrf(csrf -> csrf.disable()) // Inaktivera CSRF
				.authorizeRequests(authz -> authz
						.requestMatchers(HttpMethod.GET, "/books/**").permitAll() // Tillåt GET-förfrågningar för alla
						.requestMatchers(HttpMethod.POST, "/books").permitAll() // Tillåt POST-förfrågningar för alla
						.requestMatchers(HttpMethod.PUT, "/books/*").authenticated() // Kräv autentisering för PUT
						.requestMatchers(HttpMethod.DELETE, "/books/*").authenticated() // Kräv autentisering för DELETE
						.anyRequest().authenticated() // Kräv autentisering för alla andra förfrågningar
				)
				.httpBasic(httpBasic -> {}); // Använd Basic Authentication

		return http.build();
	}
}
