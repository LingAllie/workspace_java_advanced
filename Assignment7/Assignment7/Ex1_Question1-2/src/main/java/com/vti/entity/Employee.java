package com.vti.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "`Employee`")
@PrimaryKeyJoinColumn(name = "AccountID")
public class Employee extends Account {
    private static final long serialVersionUID = 1L;

//    @Id
//    private short accountId;

    @OneToOne(fetch = FetchType.EAGER)
    @MapsId
    @JoinColumn(name = "AccountID", referencedColumnName = "AccountID")
    private Account account;

    @Column(name = "WorkingNumberOfYear", nullable = false)
    private short workingNumberOfYear;

    public Employee() {
    }

    public Employee(short accountId, Account account, short workingNumberOfYear) {
//        this.accountId = account.getAccountId();
        this.account = account;
        this.workingNumberOfYear = workingNumberOfYear;
    }

//    public short getAccountId() {
//        return accountId;
//    }
//
//    public void setAccountId(short accountId) {
//        this.accountId = accountId;
//    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public short getWorkingNumberOfYear() {
        return workingNumberOfYear;
    }

    public void setWorkingNumberOfYear(short workingNumberOfYear) {
        this.workingNumberOfYear = workingNumberOfYear;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "accountId=" + getAccountId() +
                ",username=" + getUsername() +
                ",email=" + getEmail() +
                ",department=" + getDepartment().getDepartmentName() +
                ",position=" + getPosition().getPositionName() +
                ",salary=" + getSalary().getSalaryName() +
                ",workingNumberOfYear=" + workingNumberOfYear +
                '}';
    }
}
