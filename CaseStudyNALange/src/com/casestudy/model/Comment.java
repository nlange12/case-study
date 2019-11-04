package com.casestudy.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="comments")
public class Comment {
	@Id
private long id;
	
	@Column(name="comment Date")
private Date date;
	




public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}
public Comment() {
	
}
public long getId() {
	return id;
}

public void setId(long id) {
	this.id = id;
}
}
