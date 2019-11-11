package com.casestudy.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.casestudy.model.Event;

@Repository
public interface EventRepository extends CrudRepository<Event, String> {

	Event findByTitle(String title);
	Event findById(long id);
}
