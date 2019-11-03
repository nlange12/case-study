package com.casestudy.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Entity
@Table(name= "Credentials")
public class Credentials {

	@Id
	@Email
	@Column(name = "Email", nullable = false)	
	private String username;	
	@Column(name = "Name", nullable= false)
	private String name;
	@Column(name = "Password", nullable= false)
	private String password;
	@Column(name = "Enabled", nullable= false)
	private boolean enabled;
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy= "credential")
	private Set<Authorities> authorities = new HashSet<>();
	@OneToOne(mappedBy="cred")
	private Member member;
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
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}
}


