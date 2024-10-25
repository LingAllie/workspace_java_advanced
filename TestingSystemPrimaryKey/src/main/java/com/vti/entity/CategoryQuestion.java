package com.vti.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CategoryQuestion")
public class CategoryQuestion implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Column(name = "CategoryID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short categoryId;
	
	@Column(name = "CategoryName", length = 50, nullable = false, unique = true)
	private String categoryName;

	public CategoryQuestion() {
	}

	public CategoryQuestion(short categoryId, String categoryName) {
		this.categoryId = categoryId;
		this.categoryName = categoryName;
	}

	public short getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(short categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@Override
	public String toString() {
		return "CategoryQuestion [categoryId=" + categoryId + ", categoryName=" + categoryName + "]";
	}
	
	

}
