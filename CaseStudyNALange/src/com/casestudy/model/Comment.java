package com.casestudy.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "comments")
public class Comment {
	@Id
	@Column(name = "commentId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotEmpty
	@Column(name = "commentContent", nullable = false)
	private String content;

	
	@Column(name = "commentTimeStamp")
	@Temporal(TemporalType.TIMESTAMP)
	private Date timestamp;
	

	@ManyToOne
	@JoinTable(name = "events_comments", joinColumns = @JoinColumn(name = "commentId"), inverseJoinColumns = @JoinColumn(name = "eventId"))
	private Event event;

	@ManyToOne
	@JoinTable(name = "member_comments", joinColumns = @JoinColumn(name = "commentId"), inverseJoinColumns = @JoinColumn(name = "memberId"))
	private Member member;

	public Comment() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}
	
	
}
