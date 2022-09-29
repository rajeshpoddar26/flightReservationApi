package com.bharath.flightReservation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
//	 public void configure(WebSecurity web) throws Exception {
//	        web.ignoring().antMatchers("/v3/api-docs",
//	                "/configuration/ui",
//	                "/swagger-resources/*",
//	                "/configuration/security",
//	                "/swagger-ui.html",
//	                "/webjars/*");
//	    }
	 
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity  http) throws Exception {
		
		http
		.authorizeRequests()
		.antMatchers("/showReg","/", "/register","/login","/login/*","/reservation", "/api/v1/user/*").permitAll()
		.antMatchers("/v3/api-docs/*").permitAll()
		.antMatchers("/swagger-ui/*").permitAll()
		.antMatchers("/swagger-resources/*").permitAll()
		.antMatchers("/swagger-ui.html").permitAll()
		.antMatchers("/webjars/*").permitAll()
		.antMatchers("/admin/*").hasAnyAuthority("ADMIN").anyRequest().authenticated().and().csrf().disable();
		
		return http.build();
	}
	
	@Bean(name = BeanIds.AUTHENTICATION_MANAGER)
	public AuthenticationManager authenticationManagerBean(AuthenticationConfiguration authenticationConfiguration) throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
	}

}
