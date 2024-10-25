package com.vti.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

@Entity
@Table(name = "Answer")
public class Answer implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Column(name = "Answers")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short answerId;
	
	@Column(name = "Content", length = 100, nullable = false)
	private String content;
	
	@Column(name = "isCorrect")
	private boolean isCorrect;

	@PrePersist
	public void setDefaultIsCorrect() {
		if (this.isCorrect == false) {
			this.isCorrect = true;
		}
	}
	
	public Answer() {
	}

	public Answer(short answerId, String content, boolean isCorrect) {
		this.answerId = answerId;
		this.content = content;
		this.isCorrect = isCorrect;
	}

	public short getAnswerId() {
		return answerId;
	}

	public void setAnswerId(short answerId) {
		this.answerId = answerId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public boolean isCorrect() {
		return isCorrect;
	}

	public void setCorrect(boolean isCorrect) {
		this.isCorrect = isCorrect;
	}

	@Override
	public String toString() {
		return "Answer [answerId=" + answerId + ", content=" + content + ", isCorrect=" + isCorrect + "]";
	}
	
	
}
