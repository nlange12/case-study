package com.casestudy.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "events")
public class Event {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "eventId")
	private long id;

	@NotEmpty
	@Column(name = "eventTitle", nullable = false)
	private String title;

	@NotEmpty
	@Column(name = "eventContent", nullable = false, length= 1000)
	private String content;
	
	
	@Future(message = "Date of event cannot be in the past!")
	@Column(name = "eventDate")
	private Date date;

	@Column(name = "DateOfPosting", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date timestamp;

	@OneToMany(targetEntity = Comment.class, mappedBy = "event", cascade = CascadeType.ALL)
	private List<Comment> comments;

	@ManyToOne
	@JoinTable(name = "member_events", joinColumns = @JoinColumn(name = "eventId"), inverseJoinColumns = @JoinColumn(name = "memberId"))
	private Member member;
	
	@OneToMany(targetEntity= RSVP.class, mappedBy="event", cascade = CascadeType.ALL)
	private List<RSVP> rsvp;
	


	public Event() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<RSVP> getRsvp() {
		return rsvp;
	}

	public void setRsvp(List<RSVP> rsvp) {
		this.rsvp = rsvp;
	}
	
	
	
	

}
