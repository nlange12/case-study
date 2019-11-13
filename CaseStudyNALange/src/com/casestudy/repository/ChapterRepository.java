package com.casestudy.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.casestudy.model.Chapter;
import com.casestudy.model.Member;
@Repository
public interface ChapterRepository extends CrudRepository<Chapter, String> {

	
	Chapter findByName(String name);
	List<Member> findMemberByName(String name);
	Chapter findById(long id);
	}
