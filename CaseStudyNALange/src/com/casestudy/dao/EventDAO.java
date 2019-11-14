package com.casestudy.dao;

import java.util.Date;
import java.util.List;

import com.casestudy.model.Event;

public interface EventDAO {

	
	public boolean addEvent(Event event);
	
	public Event findEventByTitle(String title);
	
	public List<Event> getAllEvents();
	
	public boolean updateEvent(Event event);
	
	public Event findById(long id);
	
	public void deleteEvent(Event event);
	
	public List<Event> getEventByDate(Date d1, Date d2);
	
	public int getNumberOfEvents();
}
