package com.vti.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Salary")
public class Salary implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "SalaryID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short salaryId;

    @Column(name = "SalaryName", nullable = false, unique = true)
    @Convert(converter = SalaryNameConverter.class)
    private SalaryName salaryName;

    public Salary() {
    }

    public Salary(short salaryId, SalaryName salaryName) {
        this.salaryId = salaryId;
        this.salaryName = salaryName;
    }

    public short getSalaryId() {
        return salaryId;
    }

    public void setSalaryId(short salaryId) {
        this.salaryId = salaryId;
    }

    public SalaryName getSalaryName() {
        return salaryName;
    }

    public void setSalaryName(SalaryName salaryName) {
        this.salaryName = salaryName;
    }

    @Override
    public String toString() {
        return "Salary{" +
                "salaryId=" + salaryId +
                ", salaryName='" + salaryName + '\'' +
                '}';
    }

    public enum SalaryName {
        DEV("600"), TEST("700"), SCRUMMASTER("1500"), PM("2000");

        private String name;

        private SalaryName(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }

        public static SalaryName toEnum(String name) {
            for (SalaryName s : SalaryName.values()) {
                if (s.getName().equals(name)) {
                    return s;
                }
            }
            return null;
        }
    }
}

