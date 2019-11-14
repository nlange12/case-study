package com.casestudy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casestudy.dao.RSVPDAO;
import com.casestudy.model.Member;
import com.casestudy.model.RSVP;
import com.casestudy.repository.RSVPRepository;

@Service
public class RSVPService implements RSVPDAO {
	@Autowired
	RSVPRepository rRepos;

	@Override
	public boolean addRSVP(RSVP rsvp) {
		return rRepos.save(rsvp) !=null;
	}

	@Override
	public RSVP findByName(String name) {
		return rRepos.findByName(name);
	}

	@Override
	public void deleteRSVP(RSVP rsvp) {
		rRepos.delete(rsvp);
	}

	@Override
	public RSVP findById(long id) {
		return rRepos.findById(id);
	}

}
