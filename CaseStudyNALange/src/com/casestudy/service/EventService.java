package com.casestudy.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.casestudy.dao.EventDAO;
import com.casestudy.model.Event;
import com.casestudy.repository.EventRepository;

@Service
@Transactional
public class EventService implements EventDAO {
	
	@Autowired
	EventRepository eRepos;
	   
	
	@Override
	public boolean addEvent(Event event) {
		return eRepos.save(event) !=null;
	}
	@Override
	public Event findEventByTitle(String title) {
		return eRepos.findByTitle(title);
	}
	@Override
	public List<Event> getAllEvents(){
		List<Event> list = new ArrayList<>();
		eRepos.findAll().forEach(list::add);
		return list;
	}
	@Override
	@Transactional
	public boolean updateEvent(Event event) {
		return eRepos.save(event) !=null ;
	}
	@Override
	public Event findById(long id) {
		return eRepos.findById(id);
	}
	
	@Override
	public void deleteEvent(Event event) {
		eRepos.delete(event);
	}
	@Override
	public List<Event> getEventByDate(Date d1, Date d2) {
		List<Event> list = new ArrayList<>();
		eRepos.findByDateBetween(d1, d2).forEach(list::add);
		return list;
	}
}
