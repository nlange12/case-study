package com.casestudy.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.casestudy.model.Credentials;
@Repository
public interface CredentialsRepository extends CrudRepository<Credentials, String> {

	Credentials findByUsername(String username);
}
