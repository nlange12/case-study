package com.casestudy.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity 
@IdClass(value = AuthoritiesID.class)
@Table(name = "authorities")
public class Authorities {
	@Id
	@Column(name = "authority")
	private String authority;
	
	@Id
	@ManyToOne
	@JoinColumn(name= "email")
	private Credentials credential;

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public Credentials getCredentials() {
		return credential;
	}

	public void setCredentials(Credentials credential) {
		this.credential = credential;
	}

	
	
}
class AuthoritiesID implements Serializable{
	private static final long serialVersionUID = 1L;
	
	

	@Id
	@Column(name = "authority")
	private String authority;
	
	
	@Id
	@ManyToOne
	@JoinColumn(name= "username")
	private Credentials credential;

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public Credentials getCredentials() {
		return credential;
	}

	public void setCredentials(Credentials credential) {
		this.credential = credential;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

}
