package com.vti.entity;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class PositionNameConverter implements AttributeConverter<Position.PositionName, String> {
    @Override
    public String convertToDatabaseColumn(Position.PositionName name) {
        if (name == null) {
            return null;
        }
        return name.getName();
    }

    @Override
    public Position.PositionName convertToEntityAttribute(String sqlName) {
        if (sqlName == null) {
            return null;
        }
        return Position.PositionName.toEnum(sqlName);
    }
}
