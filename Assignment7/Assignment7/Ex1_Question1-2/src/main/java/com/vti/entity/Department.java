package com.vti.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Department")
@Inheritance(strategy = InheritanceType.JOINED)
public class Department implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "DepartmentID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short departmentId;

    @Column(name = "DepartmentName", length = 30, nullable = false, unique = true)
    private String departmentName;

    @OneToOne(mappedBy = "department")
//    @JsonManagedReference
    @JsonIgnoreProperties({"detailDepartment"})
    private DetailDepartment detailDepartment;

    @OneToMany(mappedBy = "department", fetch = FetchType.LAZY) // One salary to many accounts
    @JsonManagedReference
    private List<Account> accounts;

    public Department() {
    }

    public Department(String departmentName) {
        this.departmentName = departmentName;
    }

    public short getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(short departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public DetailDepartment getDetailDepartment() {
        return detailDepartment;
    }

    public void setDetailDepartment(DetailDepartment detailDepartment) {
        this.detailDepartment = detailDepartment;
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentId=" + departmentId +
                ", departmentName='" + departmentName + '\'' +
                '}';
    }
}
