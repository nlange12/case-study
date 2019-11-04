package com.casestudy.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="chapters")
public class Chapter {

	@Id
	@Column(name="id")
	private long id;
	@Column(name="chapter_name")
	private String name;
	@Column(name="school")
	private String school;
	
	
	@OneToMany(targetEntity= Member.class, cascade = CascadeType.ALL)
	private List<Member> members;
	
	
	public Chapter() {
		
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
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public List<Member> getMembers() {
		return members;
	}
	public void setMembers(List<Member> members) {
		this.members = members;
	}
}
