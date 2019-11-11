package com.casestudy.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.casestudy.service.CredentialsService;

@Configuration
@EnableWebSecurity
@ComponentScan("com.casestudy")
public class WebSecuityConfig extends WebSecurityConfigurerAdapter{// if you want to use spring securitys login form extend WebSecurityConfiguration

	
	
	
	@Autowired
	private CredentialsService cServ;	
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(cServ).passwordEncoder(passwordEncoder());
		
	}
	
	public void configure(WebSecurity web) {
		web.ignoring().antMatchers("/js/**", "/images/**", "/css/**", "/resources/**", "/scripts/**"); //ignoring those url patterns (lets what users see things like images and css on log in page without loggin in)
	}
	

	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests().antMatchers("/processCredential").permitAll();
		http.authorizeRequests().antMatchers("/chapters").permitAll();
		http.authorizeRequests().antMatchers("/register").permitAll();
		http.authorizeRequests().antMatchers("/contactus").permitAll();//do not need to be authenticated to veiw contacts us page
		http.authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN");//needs to be an admin to view admin page
		http.authorizeRequests().antMatchers("/member/**").hasRole("USER");// needs to be user authenticated to view page
		http.authorizeRequests().antMatchers("/all/**").hasAnyRole("ADMIN", "USER");// needs to be 
		http.authorizeRequests().anyRequest().authenticated();
		http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");
		
		
		
		http.authorizeRequests()
		.and()
		.formLogin()
		.loginPage("/login").loginProcessingUrl("/loginAction").defaultSuccessUrl("/", true).permitAll()// when you log in you get forcible sent to the home page
		.and()
		.logout().logoutSuccessUrl("/login").permitAll()// after successfull logout tak back to login page
		.and()
		.csrf().disable();
	}
}
