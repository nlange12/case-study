package com.casestudy.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.casestudy.model.Comment;
import com.casestudy.model.Event;
import com.casestudy.model.Member;
@Repository
public interface CommentRepository extends CrudRepository<Comment, String> {

	List<Comment> findByMember(Member member);
	List<Comment> findByEvent(Event event);
	Comment findById(long id);
	
}
