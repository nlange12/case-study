package com.casestudy.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "rsvp")
public class RSVP {
	@Id
	@Column(name = "rsvpId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "name")
	private String name;
	@Column(name = "email")
	private String email;
	@Column(name = "chapName")
	private String chapName;	
	@ManyToOne
	@JoinTable(name = "members_rsvps", joinColumns = @JoinColumn(name = "rsvpId"), inverseJoinColumns = @JoinColumn(name = "memberId"))
	private Member member;
	@ManyToOne
	@JoinTable(name = "events_rsvps", joinColumns = @JoinColumn(name = "rsvpId"), inverseJoinColumns = @JoinColumn(name = "eventId"))
	private Event event;
	
	
	public RSVP() {
		
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


	public String getChapName() {
		return chapName;
	}


	public void setChapName(String chapName) {
		this.chapName = chapName;
	}


	public Member getMember() {
		return member;
	}


	public void setMember(Member member) {
		this.member = member;
	}


	public Event getEvent() {
		return event;
	}


	public void setEvent(Event event) {
		this.event = event;
	}
	
	

}
