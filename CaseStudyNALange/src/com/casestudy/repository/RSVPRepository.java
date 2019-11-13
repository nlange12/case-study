package com.casestudy.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.casestudy.model.Member;
import com.casestudy.model.RSVP;

@Repository
public interface RSVPRepository extends CrudRepository<RSVP, String> {

	RSVP findById(long id);
	RSVP findByName(String name);
}
