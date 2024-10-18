package com.tnl.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Department")
public class Department implements Serializable{
	
	private static final long serialVersionUID = 1;

	@Column(name = "DepartmentID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short departmentId;
	private String departmentName;
	
	public Department() {
		
	}

	public Department(short departmentId, String departmentName) {
		this.departmentId = departmentId;
		this.departmentName = departmentName;
	}

	public short getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(short departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	@Override
	public String toString() {
		return "Department [departmentId=" + departmentId + ", departmentName=" + departmentName + "]";
	}
	
	
	
	
}
