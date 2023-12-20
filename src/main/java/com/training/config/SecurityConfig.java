package com.training.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	private final JwtConfig jwtConfig;

	public SecurityConfig(JwtConfig jwtConfig) {
		this.jwtConfig = jwtConfig;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().antMatchers("/**").permitAll() // Permit all requests without
																					// authentication
				.and().addFilterBefore(jwtConfig, UsernamePasswordAuthenticationFilter.class);
	}

}
