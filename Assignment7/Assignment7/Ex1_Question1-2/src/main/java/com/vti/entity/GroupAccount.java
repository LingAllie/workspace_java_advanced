package com.vti.entity;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "GroupAccount")
public class GroupAccount implements Serializable {
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private GroupAccountId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("groupId")
    @JoinColumn(name = "GroupID")
    private Group group;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("accountId")
    @JoinColumn(name = "AccountID")
    private Account account;

    @Column(name = "JoinDate")
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date joinDate;

    public GroupAccount() {
    }

    public GroupAccount(Group group, Account account) {
        this.group = group;
        this.account = account;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public GroupAccountId getId() {
        return id;
    }

    public void setId(GroupAccountId id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "GroupAccount{" +
                "group=" + group.getGroupId() +
                ", account=" + account.getAccountId() +
                ", createDate=" + joinDate +
                '}';
    }

    @Embeddable
    public static class GroupAccountId implements Serializable {
        private static final long serialVersionUID = 1L;

        @Column(name = "GroupID", nullable = false)
        private short groupId;

        @Column(name = "AccountID", nullable = false)
        private short accountId;

        public GroupAccountId() {
        }

        public short getGroupId() {
            return groupId;
        }

        public void setGroupId(short groupId) {
            this.groupId = groupId;
        }

        public short getAccountId() {
            return accountId;
        }

        public void setAccountId(short accountId) {
            this.accountId = accountId;
        }
    }
}
