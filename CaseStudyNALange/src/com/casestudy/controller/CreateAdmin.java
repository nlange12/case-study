package com.casestudy.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.casestudy.dao.CredentialDAO;
import com.casestudy.model.Authorities;
import com.casestudy.model.Credentials;
import com.casestudy.repository.CredentialsRepository;
import com.casestudy.service.CredentialsService;


@Controller
@Transactional
public class CreateAdmin {

	@Autowired
	CredentialDAO cDAO;
	
	@Autowired
	CredentialsRepository cRepos;

public void initAdmin() {
		
		
		Credentials cred = cRepos.findByUsername("Nick");
		
		if(cred == null) {
		System.out.println("creating admin...");
		Credentials adminUser = new Credentials();
		adminUser.setName("Nick");
		adminUser.setUsername("Nick");
		String encoded = new BCryptPasswordEncoder().encode("123456"); 
		adminUser.setPassword(encoded);
		adminUser.setEnabled(true);
		
		Authorities role = new Authorities();
		role.setCredentials(adminUser);
		role.setAuthority("ROLE_ADMIN");
		adminUser.getAuthorities().add(role);
		
		
		cDAO.addCred(adminUser);
		
		
		

		
		}
		
	}
}
