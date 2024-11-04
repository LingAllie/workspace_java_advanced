package com.vti.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "`Employee`")
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "AccountID")
    @Id
    private short accountId;

    @Column(name = "WorkingNumberOfYear", nullable = false)
    private short workingNumberOfYear;

    public Employee() {
    }

    public Employee(short accountId, short workingNumberOfYear) {
        this.accountId = accountId;
        this.workingNumberOfYear = workingNumberOfYear;
    }

    public short getAccountId() {
        return accountId;
    }

    public void setAccountId(short accountId) {
        this.accountId = accountId;
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
                "accountId=" + accountId +
                ", WorkingNumberOfYear=" + workingNumberOfYear +
                '}';
    }
}
