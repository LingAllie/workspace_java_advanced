package com.vti.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "Question")
public class Question implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Column(name = "QuestionID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short questionId;
	
	@Column(name = "Content", length = 100, nullable = false)
	private String content;
	
	@Column(name = "CreateDate", updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date createDate;

	public Question() {
	}

	public Question(short questionId, String content, Date createDate) {
		this.questionId = questionId;
		this.content = content;
		this.createDate = createDate;
	}

	public short getQuestionId() {
		return questionId;
	}

	public void setQuestionId(short questionId) {
		this.questionId = questionId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "Question [questionId=" + questionId + ", content=" + content + ", createDate=" + createDate + "]";
	}
	
	

}
