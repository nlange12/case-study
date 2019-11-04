package com.casestudy.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name= "member")
public class Member {
@Id
@Column(name="member_id")
private long id;
@Column(name="full_name")
private String name;
@Column(name="email")
private String email;
@Column(name="crossing_year")
private String intiationYr;
@Column(name="phoneNum")
private String phoneNum;
@OneToMany(targetEntity = Event.class, cascade = CascadeType.ALL)
private List<Event> events;
@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy= "member")
private Set<Authorities> authorities = new HashSet<>();
//@OneToOne(cascade = CascadeType.ALL)
//@JoinColumn(name= "cred_id")
//private Credentials cred;


public Member(String name, String email, String intiationYr, String phoneNum) {
	super();
	this.name = name;
	this.email = email;
	this.intiationYr = intiationYr;
	this.phoneNum = phoneNum;
	
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

public List<Event> getEvents() {
	return events;
}


public void setEvents(List<Event> events) {
	this.events = events;
}
}
