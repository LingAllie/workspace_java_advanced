package com.vti.entity;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.vti.entity.Salary.SalaryName;

@Converter(autoApply = true)
public class SalaryNameConverter implements AttributeConverter<Salary.SalaryName, String> {

	@Override
	public String convertToDatabaseColumn(SalaryName name) {
		if (name == null) {
			return null;
		}
		return name.getSalaryName();
	}

	@Override
	public SalaryName convertToEntityAttribute(String sqlName) {
		if (sqlName == null) {
			return null;
		}
		return Salary.SalaryName.toEnum(sqlName);
	}
	
}
