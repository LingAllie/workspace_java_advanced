package com.vti.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Convert;
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
	@Convert(converter = SalaryNameConverter.class)
	private SalaryName salaryName;
	
//	@PrePersist
//	@PreUpdate
//	public void validateSalaryName() {
//		if (salaryName != 600 && salaryName != 700 && salaryName != 1500 && salaryName != 2000) {
//            throw new IllegalArgumentException("Invalid Salary Name");
//        }
//	}

	public Salary() {
	}

	public Salary(short salaryId, SalaryName salaryName) {
		this.salaryId = salaryId;
		this.salaryName = salaryName;
	}

	public short getSalaryId() {
		return salaryId;
	}

	public void setSalaryId(short salaryId) {
		this.salaryId = salaryId;
	}

	public SalaryName getSalaryName() {
		return salaryName;
	}

	public void setSalaryName(SalaryName salaryName) {
		this.salaryName = salaryName;
	}

	@Override
	public String toString() {
		return "Salary [salaryId=" + salaryId + ", salaryName=" + salaryName + "]";
	}
	
	public enum SalaryName {
		DEV("600"), TEST("700"), SCRUMMASTER("1500"), PM("2000");
		
		private String salaryName;
		
		private SalaryName(String salaryName) {
			this.salaryName = salaryName;
		}
		
		public String getSalaryName() {
			return salaryName;
		}
		
		public static SalaryName toEnum(String sqlName) {
			for (SalaryName item: SalaryName.values()) {
				if (item.getSalaryName().equals(sqlName)) {
					return item;
				}
			}
			return null;
		}
	}

}
