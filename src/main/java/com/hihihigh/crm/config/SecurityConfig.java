package com.hihihigh.crm.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.hihihigh.crm.service.impl.MyUserDetailsServiceImp;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	@Autowired
	MyUserDetailsServiceImp myUserDetailsServiceImp;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(myUserDetailsServiceImp);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.formLogin()
		.and()
		.authorizeRequests()
		.antMatchers("/easyUi/workspace.jsp").authenticated()
		.anyRequest().permitAll()
		.and()
		.csrf().disable();
	}
}
