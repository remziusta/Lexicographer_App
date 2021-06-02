package com.app.lexicographer.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue(generator = "userSeq", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(sequenceName = "userSeq", name = "USER_TB_SEQ")
	private Long Id;
	
	@Column(name ="username", nullable = false)
	private String username;
	
	@Column(name = "password", nullable = false)
	private String password;
	
	@Column(name = "fullname", nullable = false)
	private String fullname;
	
	@Column(name = "email", nullable = false)
	private String email;
	
	@ManyToOne(
			fetch = FetchType.LAZY,
			optional = false
	)
	private Role role;
	
	@Column(name = "active", nullable = false, columnDefinition = "boolean default true")
	private boolean active;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
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

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	
	
}
