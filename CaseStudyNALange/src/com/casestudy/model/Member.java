package com.casestudy.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name= "member")
public class Member {
@Id
@Column(name="Member Id")
private long id;
@Column(name="Full Name")
private String name;
@Column(name="Email")
private String email;
@Column(name="Crossing Year")
private String intiationYr;
@Column(name="Phone #")
private String phoneNum;
@ManyToOne
@Column(name="Chapter_Id")
private Chapter chapter;
@OneToMany(targetEntity = Event.class, cascade = CascadeType.ALL, mappedBy="member")
private List<Event> events;
@OneToOne
@JoinColumn(name= "Cred_Id")
private Credentials cred;


public Member(String name, String email, String intiationYr, String phoneNum, Chapter chapter) {
	super();
	this.name = name;
	this.email = email;
	this.intiationYr = intiationYr;
	this.phoneNum = phoneNum;
	this.chapter = chapter;
}


public Member() {
	
}


public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getIntiationYr() {
	return intiationYr;
}
public void setIntiationYr(String intiationYr) {
	this.intiationYr = intiationYr;
}
public String getPhoneNum() {
	return phoneNum;
}
public void setPhoneNum(String phoneNum) {
	this.phoneNum = phoneNum;
}
public Chapter getChapter() {
	return chapter;
}
public void setChapter(Chapter chapter) {
	this.chapter = chapter;
}
public List<Event> getEvents() {
	return events;
}


public void setEvents(List<Event> events) {
	this.events = events;
}
}
