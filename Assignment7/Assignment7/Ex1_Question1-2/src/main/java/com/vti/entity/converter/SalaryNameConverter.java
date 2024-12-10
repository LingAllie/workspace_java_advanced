package com.vti.entity.converter;

import com.vti.entity.Salary;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class SalaryNameConverter implements AttributeConverter<Salary.SalaryName, String> {
    @Override
    public String convertToDatabaseColumn(Salary.SalaryName name) {
        return name == null ? null : name.getName();
    }

    @Override
    public Salary.SalaryName convertToEntityAttribute(String sqlName) {
        return sqlName == null ? null : Salary.SalaryName.toEnum(sqlName);
    }
}
