package com.casestudy.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "member")
public class Member {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "memberId")
	private long id;
	
	@Column(name = "fullName")
	private String name;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "crossingYear")
	private String intiationYr;
	
	@ManyToOne
	@JoinTable(name = "chapters_member", joinColumns = @JoinColumn(name = "memberId"), inverseJoinColumns = @JoinColumn(name = "chapterId"))
	@JoinColumn(name = "chapterId")
	private Chapter chapter;
	
	@Column(name = "phoneNum")
	private String phoneNum;
	
	@OneToMany(targetEntity = Event.class, cascade = CascadeType.ALL, mappedBy = "member")
	private List<Event> events;
	
	@OneToMany(targetEntity = Comment.class, mappedBy = "member", cascade = CascadeType.ALL)
	private List<Comment> comments;
	
	
	private String chapName;
	
	@Transient
	private String chapSchool;
	@OneToOne(cascade = CascadeType.ALL)
	private Credentials credential;
	
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Chapter getChapter() {
		return chapter;
	}

	public void setChapter(Chapter chapter) {
		this.chapter = chapter;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public String getChapName() {
		return chapName;
	}

	public void setChapName(String chapName) {
		this.chapName = chapName;
	}

	public String getChapSchool() {
		return chapSchool;
	}

	public void setChapSchool(String chapSchool) {
		this.chapSchool = chapSchool;
	}

	public Credentials getCredential() {
		return credential;
	}

	public void setCredential(Credentials credential) {
		this.credential = credential;
	}
	
	
}
