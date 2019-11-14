package com.casestudy.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Entity
@Table(name= "credentials")
public class Credentials {

	@Id
	@NotEmpty(message = "required")
	@Column(name = "username", nullable = false)	
	private String username;	
	@NotEmpty(message = "required")
	@Column(name = "name", nullable= false)
	private String name;
	@NotEmpty(message = "required")
	@Column(name = "password", nullable= false)
	private String password;
	@Column(name = "enabled", nullable= false)
	private boolean enabled;
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy= "credential")
	private Set<Authorities> authorities = new HashSet<>();
	@OneToOne(cascade = CascadeType.ALL, mappedBy= "credential")
	private Member member;
	
	
	public Credentials() {
		
	}
	
	
	
	public Credentials(String username, String name, String password) {
	super();
	this.username = username;
	this.name = name;
	this.password = password;
}



	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public Set<Authorities> getAuthorities() {
		return authorities;
	}
	public void setAuthorities(Set<Authorities> authorities) {
		this.authorities = authorities;
	}
	
	
	
	
	public Member getMember() {
		return member;
	}



	public void setMember(Member member) {
		this.member = member;
	}



	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}


