package com.vti.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "`Manager`")
@PrimaryKeyJoinColumn(name = "AccountID")
public class Manager extends Account {
    private static final long serialVersionUID = 1L;

//    @Id
//    private short accountId;

    @OneToOne(fetch = FetchType.EAGER)
    @MapsId
    @JoinColumn(name = "AccountID", referencedColumnName = "AccountID")
    private Account account;

    @Column(name = "ManagementNumberOfYear", nullable = false)
    private short managementNumberOfYear;

    public Manager() {
    }

    public Manager(short accountId, Account account, short managementNumberOfYear) {
//        this.accountId = account.getAccountId();
        this.account = account;
        this.managementNumberOfYear = managementNumberOfYear;
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

    public short getManagementNumberOfYear() {
        return managementNumberOfYear;
    }

    public void setManagementNumberOfYear(short managementNumberOfYear) {
        this.managementNumberOfYear = managementNumberOfYear;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "accountId=" + getAccountId() +
                ",username=" + getUsername() +
                ",email=" + getEmail() +
                ",department=" + getDepartment().getDepartmentName() +
                ",position=" + getPosition().getPositionName() +
                ",salary=" + getSalary().getSalaryName() +
                ",manageNumberOfYear=" + managementNumberOfYear +
                '}';
    }
}
