package com.casestudy.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.casestudy.model.Chapter;
@Repository
public interface ChapterRepository extends CrudRepository<Chapter, String> {

	
	Chapter findByName(String name);
	 
}
