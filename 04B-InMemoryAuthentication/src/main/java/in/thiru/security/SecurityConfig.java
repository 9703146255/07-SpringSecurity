package in.thiru.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@EnableWebSecurity
@Configuration
public class SecurityConfig {
	
	
	@Bean
	 SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
	{
		http.authorizeHttpRequests(authorize->authorize.requestMatchers("/login","/contactUs","/aboutUs")
											.permitAll()
											.anyRequest()
											.authenticated())
											.httpBasic(withDefaults())
											.formLogin(withDefaults());
		
		return http.build();
	}
	
	@Bean
	InMemoryUserDetailsManager inMemoryUsers()
	{
		@SuppressWarnings("deprecation")
		UserDetails thiruUser = User.withDefaultPasswordEncoder()
		.username("thiru")
		.password("thiru@123")
		.authorities("ADMIN")
		.build();
		
		@SuppressWarnings("deprecation")
		UserDetails kingUser = User.withDefaultPasswordEncoder()
		.username("king")
		.password("king@123")
		.authorities("USER")
		.build();
		
		@SuppressWarnings("deprecation")
		UserDetails vijayUser = User.withDefaultPasswordEncoder()
		.username("vijay")
		.password("vijay@123")
		.authorities("USER")
		.build();
		
		
		
		return new InMemoryUserDetailsManager(thiruUser,kingUser,vijayUser);
	}
	
	

}
