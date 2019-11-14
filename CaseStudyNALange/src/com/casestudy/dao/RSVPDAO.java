package com.casestudy.dao;

import com.casestudy.model.Member;
import com.casestudy.model.RSVP;

public interface RSVPDAO {
	
	public boolean addRSVP(RSVP rsvp);
	
	public RSVP findByName(String name);
	
	public void deleteRSVP(RSVP rsvp);
	
	public RSVP findById(long id);

}
