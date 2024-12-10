package com.vti.entity.converter;

import com.vti.entity.TypeQuestion;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class TypeNameConverter implements AttributeConverter<TypeQuestion.TypeName, String> {

    @Override
    public String convertToDatabaseColumn(TypeQuestion.TypeName name) {
        return name == null ? null : name.getName();
    }

    @Override
    public TypeQuestion.TypeName convertToEntityAttribute(String sqlName) {
        return sqlName == null ? null : TypeQuestion.TypeName.toEnum(sqlName);
    }
}
