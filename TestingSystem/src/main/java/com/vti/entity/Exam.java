package com.vti.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "Exam")
public class Exam implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Column(name = "ExamID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short examId;
	
	@Column(name = "`Code1`", length = 10, nullable = false, updatable = false)
	private String code1;
	
	@Column(name = "`Code2`", length = 10, nullable = false, updatable = false)
	private String code2;
	
	@Column(name = "Title", length = 50, nullable = false)
	private String examTitle;
	
	@Column(name = "Duration", nullable = false)
	private short duration;
	
	@Column(name = "CreateDate", updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date createDate;
	
	@PrePersist
	public void validateData() {
		if (this.duration == 0) {
			this.duration = 45;
		}
		
		if (this.duration >= 180) {
			this.code1 = "L-1";
			this.code2 = "L-1";
		}
		
		if (this.duration >= 90 && this.duration < 180) {
			this.code1 = "M-1";
			this.code2 = "M-1";
		}
		
		if (this.duration >= 45 && this.duration < 90) {
			this.code1 = "S-1";
			this.code2 = "S-1";
		}
	}

	public Exam() {
	}

	public Exam(short examId, String code1, String code2, String examTitle, short duration, Date createDate) {
		this.examId = examId;
		this.code1 = code1;
		this.code2 = code2;
		this.examTitle = examTitle;
		this.duration = duration;
		this.createDate = createDate;
	}

	public short getExamId() {
		return examId;
	}

	public void setExamId(short examId) {
		this.examId = examId;
	}

	public String getCode1() {
		return code1;
	}

	public void setCode1(String code1) {
		this.code1 = code1;
	}

	public String getCode2() {
		return code2;
	}

	public void setCode2(String code2) {
		this.code2 = code2;
	}

	public String getExamTitle() {
		return examTitle;
	}

	public void setExamTitle(String examTitle) {
		this.examTitle = examTitle;
	}

	public short getDuration() {
		return duration;
	}

	public void setDuration(short duration) {
		this.duration = duration;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "Exam [examId=" + examId + ", code1=" + code1 + ", code2=" + code2 + ", examTitle=" + examTitle
				+ ", duration=" + duration + ", createDate=" + createDate + "]";
	}
	
	
}