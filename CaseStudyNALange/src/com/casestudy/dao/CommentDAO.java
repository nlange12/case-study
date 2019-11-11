package com.casestudy.dao;

import java.util.List;

import com.casestudy.model.Comment;
import com.casestudy.model.Event;

public interface CommentDAO {

	public boolean addComment(Comment comment);

	public List<Comment> getCommentByEvent(Event event);
	
	public Comment findCommentById(long id);
	
	public boolean updateComment(Comment comment);
	
	public void deleteComment(Comment comment);

}
