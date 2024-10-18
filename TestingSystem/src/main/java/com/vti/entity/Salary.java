package com.vti.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name = "`Salary`")
public class Salary implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Column(name = "SalaryID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short salaryId;
	
	@Column(name = "SalaryName", nullable = false, unique = true)
	private int salaryName;
	
	@PrePersist
	@PreUpdate
	public void validateSalaryName() {
		if (salaryName != 600 && salaryName != 700 && salaryName != 1500 && salaryName != 2000) {
            throw new IllegalArgumentException("Invalid Salary Name");
        }
	}

	public Salary() {
	}

	public Salary(short salaryId, int salaryName) {
		this.salaryId = salaryId;
		this.salaryName = salaryName;
	}

	public short getSalaryId() {
		return salaryId;
	}

	public void setSalaryId(short salaryId) {
		this.salaryId = salaryId;
	}

	public int getSalaryName() {
		return salaryName;
	}

	public void setSalaryName(int salaryName) {
		this.salaryName = salaryName;
	}

	@Override
	public String toString() {
		return "Salary [salaryId=" + salaryId + ", salaryName=" + salaryName + "]";
	}
	
	

}