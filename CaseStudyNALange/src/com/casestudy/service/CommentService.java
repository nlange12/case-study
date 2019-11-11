package com.casestudy.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.casestudy.dao.CommentDAO;
import com.casestudy.model.Comment;
import com.casestudy.model.Event;
import com.casestudy.repository.CommentRepository;

@Service
public class CommentService implements CommentDAO {

	@Autowired
	CommentRepository comRepos;

	@Override
	public boolean addComment(Comment comment) {
		return comRepos.save(comment) != null;
	}

	@Override
	public List<Comment> getCommentByEvent(Event event) {
		List<Comment> list = new ArrayList<>();
		comRepos.findByEvent(event).forEach(list::add);
		return list;
	}

	@Override
	public Comment findCommentById(long id) {
		return comRepos.findById(id);
	}

	@Override
	public boolean updateComment(Comment comment) {
		return comRepos.save(comment) !=null;
	}

	@Override
	public void deleteComment(Comment comment) {
		comRepos.delete(comment);
	}

}
