package com.vti.entity;

import com.vti.entity.converter.SalaryNameConverter;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "`Salary`")
public class Salary implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "SalaryID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short salaryId;

    @Column(name = "SalaryName", nullable = false, unique = true)
    @Convert(converter = SalaryNameConverter.class)
    private SalaryName salaryName;

    @OneToMany(mappedBy = "salary", fetch = FetchType.LAZY) // One salary to many accounts
    private List<Account> accounts;

    public Salary() {
    }

    public Salary(SalaryName salaryName) {
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

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    @Override
    public String toString() {
        return "Salary{" +
                "salaryId=" + salaryId +
                ", salaryName=" + salaryName +
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
