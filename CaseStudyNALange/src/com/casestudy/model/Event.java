package com.casestudy.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="events")
public class Event {
@Id	
@Column(name = "Event ID")
private long id;
@Column(name= "Event Date")
private Date date;
@ManyToOne
private Member member;
@OneToMany(targetEntity = Comment.class)
private List<Comment> comments;


public Event() {
	
}
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}
public Member getMember() {
	return member;
}
public void setMember(Member member) {
	this.member = member;
}
public List<Comment> getComments() {
	return comments;
}
public void setComments(List<Comment> comments) {
	this.comments = comments;
}


}
