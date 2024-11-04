package com.vti.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "TypeQuestion")
public class TypeQuestion implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "TypeID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short typeId;

    @Column(name = "TypeName", nullable = false, unique = true)
    @Enumerated(EnumType.ORDINAL)
    private TypeName typeName;

    @OneToMany(mappedBy = "type")
    private List<Question> question;

    public TypeQuestion() {}

    public TypeName getTypeName() {
        return typeName;
    }

    public void setTypeName(TypeName typeName) {
        this.typeName = typeName;
    }

    public List<Question> getQuestion() {
        return question;
    }

    public void setQuestion(List<Question> question) {
        this.question = question;
    }

    @Override
    public String toString() {
        return "TypeQuestion{" +
                "typeId=" + typeId +
                ", typeName=" + typeName +
                '}';
    }

    public enum TypeName {
        ESSAY("0"), MULTIPLECHOICE("1");

        private String name;

        TypeName(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public static TypeName toEnum(String sqlValue) {
            for (TypeName type : TypeName.values()) {
                if (type.name.equalsIgnoreCase(sqlValue)) {
                    return type;
                }
            }
            return null;
        }
    }
}
