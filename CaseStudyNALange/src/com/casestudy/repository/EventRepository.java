package com.casestudy.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.casestudy.model.Event;

@Repository
public interface EventRepository extends CrudRepository<Event, String> {

	Event findByTitle(String title);
	Event findById(long id);
	List<Event> findByDateBetween(Date d1, Date d2);
	Page<Event> findAll(Pageable pageable);
}
