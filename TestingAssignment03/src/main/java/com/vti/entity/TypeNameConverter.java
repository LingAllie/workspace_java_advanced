package com.vti.entity;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class TypeNameConverter implements AttributeConverter<TypeQuestion.TypeName, String> {

    @Override
    public String convertToDatabaseColumn(TypeQuestion.TypeName name) {
        if (name == null) {
            return null;
        }
        return name.getName();
    }

    @Override
    public TypeQuestion.TypeName convertToEntityAttribute(String sqlName) {
        if (sqlName == null) {
            return null;
        }
        return TypeQuestion.TypeName.toEnum(sqlName);
    }
}
