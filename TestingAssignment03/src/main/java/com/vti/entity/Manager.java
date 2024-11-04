package com.vti.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "`Manager`")
public class Manager implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "AccountID")
    @Id
    private short accountId;

    @Column(name = "ManagementNumberOfYear", nullable = false)
    private short managementNumberOfYear;

    public Manager() {
    }

    public Manager(short accountId, short managementNumberOfYear) {
        this.accountId = accountId;
        this.managementNumberOfYear = managementNumberOfYear;
    }

    public short getAccountId() {
        return accountId;
    }

    public void setAccountId(short accountId) {
        this.accountId = accountId;
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
                "accountId=" + accountId +
                ", managementNumberOfYear=" + managementNumberOfYear +
                '}';
    }
}

