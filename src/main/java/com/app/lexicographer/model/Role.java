package com.app.lexicographer.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Role")
public class Role {
	
	@Id
	@GeneratedValue(generator = "roleSeq", strategy = GenerationType.SEQUENCE )
	@SequenceGenerator(sequenceName = "roleSeq", name = "ROLES_TB_SEQ")
	private Long id;
	
	@Column(name = "role")
	private String ROLE;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getROLE() {
		return ROLE;
	}

	public void setROLE(String rOLE) {
		ROLE = rOLE;
	}
	
	
}
