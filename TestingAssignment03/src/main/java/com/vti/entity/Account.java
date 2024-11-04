package com.vti.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Formula;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "`Account`")
public class Account implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AccountID")
    private short accountId;

    @Column(name = "Email", length = 50, nullable = false, unique = true, updatable = false)
    private String email;

    @Column(name = "Username", length = 50, nullable = false, unique = true, updatable = false)
    private String username;

    @Column(name = "FirstName", length = 50, nullable = false)
    private String firstName;

    @Column(name = "LastName", length = 50, nullable = false)
    private String lastName;

    @ManyToOne
    @JoinColumn(name = "DepartmentID", nullable = false)
    private Department department;

    @ManyToOne
    @JoinColumn(name = "PositionID", nullable = false)
    private Position position;

    @ManyToOne
    @JoinColumn(name = "SalaryID", nullable = false)
    private Salary salary;

    @CreationTimestamp
    @Column(name = "CreateDate", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    @OneToMany(mappedBy = "account", fetch = FetchType.EAGER)
    private List<GroupAccount> groupAccountList;

    @Formula("concat(FirstName, ' ', LastName)")
    private String fullName;

    public Account() {
    }

    public Account(String email, String username, String firstName, String lastName, Department department, Position position, Salary salary) {
        this.email = email;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.position = position;
        this.salary = salary;
    }

    @PrePersist
    public void setDefaultValues() {
        this.department.setDepartmentId((short) 4);
        this.position.setPositionId((short) (Position.PositionName.DEV.ordinal() + 1));
        this.salary.setSalaryId((short) (Salary.SalaryName.DEV.ordinal() + 1));
    }

    public short getAccountId() {
        return accountId;
    }

    public void setAccountId(short accountId) {
        this.accountId = accountId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Salary getSalary() {
        return salary;
    }

    public void setSalary(Salary salary) {
        this.salary = salary;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public String getFullName() {
        return fullName;
    }

    public List<GroupAccount> getGroupAccountList() {
        return groupAccountList;
    }

    public void setGroupAccountList(List<GroupAccount> groupAccountList) {
        this.groupAccountList = groupAccountList;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", department=" + department +
                ", position=" + position +
                ", salary=" + salary +
                ", createDate=" + createDate +
                ", fullName='" + fullName + '\'' +
                '}';
    }
}
