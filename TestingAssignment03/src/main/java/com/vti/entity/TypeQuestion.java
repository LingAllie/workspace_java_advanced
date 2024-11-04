package com.vti.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TypeQuestion")
public class TypeQuestion implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "TypeID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short typeId;

    @Column(name = "TypeName", nullable = false, unique = true)
    @Convert(converter = TypeNameConverter.class)
    private TypeName typeName;

    public TypeQuestion() {
    }

    public TypeQuestion(short typeId, TypeName typeName) {
        this.typeId = typeId;
        this.typeName = typeName;
    }

    public short getTypeId() {
        return typeId;
    }

    public void setTypeId(short typeId) {
        this.typeId = typeId;
    }

    public TypeName getTypeName() {
        return typeName;
    }

    public void setTypeName(TypeName typeName) {
        this.typeName = typeName;
    }

    @Override
    public String toString() {
        return "TypeQuestion{" +
                "typeId=" + typeId +
                ", typeName='" + typeName + '\'' +
                '}';
    }

    public enum TypeName {

        ESSAY("0"), MULTIPLECHOICE("1");

        private String name;

        private TypeName(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }

        public static TypeName toEnum(String name) {
            for (TypeName e : TypeName.values()) {
                if (e.name.equals(name)) {
                    return e;
                }
            }
            return null;
        }
    }
}
