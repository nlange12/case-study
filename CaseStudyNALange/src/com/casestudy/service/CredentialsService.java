package com.casestudy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.casestudy.model.Credentials;
import com.casestudy.repository.CredentialsRepository;
@Service("credentialsService")
public class CredentialsService implements UserDetailsService {
	
	
	@Autowired
	CredentialsRepository cRepos;
	
	public void saveCred(Credentials cred) {
		cRepos.save(cred);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Credentials cred = cRepos.findByUsername(username);
		
		UserBuilder builder = null;
		
		if (cred != null) {
			builder = org.springframework.security.core.userdetails.User.withUsername(username);
			builder.password(cred.getPassword());
			builder.disabled(!cred.isEnabled());
			String[] authorities = cred.getAuthorities().stream().map(a -> a.getAuthority()).toArray(String[]::new);
			builder.authorities(authorities);
		}else {
			throw new UsernameNotFoundException("User Not Found!");
			
		}

		return builder.build();
	}

}
