package com.casestudy.dao;

import com.casestudy.model.Credentials;

public interface CredentialDAO {
	
	public boolean saveCred(Credentials cred);
	
	public boolean addCred(Credentials cred);
	
	 public void deleteCred(Credentials cred);
	 
	 public Credentials getCredByUsername(String username);
}
