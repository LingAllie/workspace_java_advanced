package com.vti.entity.converter;

import com.vti.entity.Position;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class PositionNameConverter implements AttributeConverter<Position.PositionName, String> {
    @Override
    public String convertToDatabaseColumn(Position.PositionName name) {
        return name == null ? null : name.getName();
    }

    @Override
    public Position.PositionName convertToEntityAttribute(String sqlName) {
        return sqlName == null ? null : Position.PositionName.toEnum(sqlName);
    }
}
