package com.app.lexicographer.model;

import javax.persistence.*;

@Entity
@Table(name = "Category")
public class Category {
	@Id
	@GeneratedValue(generator = "categoriesSeq", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "categoriesSeq", sequenceName = "CATEGORY_TB_SEQ", allocationSize = 1)
	private Long Id;

	@Column(name = "CATEGORY", nullable = false)
	private String CATEGORY;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getCATEGORY() {
		return CATEGORY;
	}

	public void setCATEGORY(String CATEGORY) {
		this.CATEGORY = CATEGORY;
	}

}
