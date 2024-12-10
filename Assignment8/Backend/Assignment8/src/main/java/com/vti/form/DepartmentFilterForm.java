package com.vti.form;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.vti.entity.Department;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DepartmentFilterForm {
	
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date minCreatedDate;

	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date maxCreatedDate;

	private Integer minYear;

	private Integer maxYear;

	private Integer minId;
	
	private Integer maxId;
	
	private Integer minTotalMember;
	
	private Integer maxTotalMember;
	
	private Long minAccountQuantity;
	
	private Long maxAccountQuantity;
	
	private Department.Type type;
}
