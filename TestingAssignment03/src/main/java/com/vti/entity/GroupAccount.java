package com.vti.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "GroupAccount")
public class GroupAccount implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private GroupAccountId id;

    @ManyToOne
    @MapsId("groupId") // Maps groupId in GroupAccountId
    @JoinColumn(name = "GroupID")
    private Group group;

    @ManyToOne
    @MapsId("accountId") // Maps accountId in GroupAccountId
    @JoinColumn(name = "AccountID")
    private Account account;

    @Column(name = "JoinDate")
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date joinDate;

    public GroupAccount() {
    }

    // Getters and setters for id, group, account, joinDate
    public GroupAccountId getId() {
        return id;
    }

    public void setId(GroupAccountId id) {
        this.id = id;
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

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    @Embeddable
    public static class GroupAccountId implements Serializable {
        private static final long serialVersionUID = 1L;

        @Column(name = "GroupID", nullable = false)
        private short groupId;

        @Column(name = "AccountID", nullable = false)
        private short accountId;

        public GroupAccountId() {}

        // Getters, setters, equals, and hashCode for groupId, accountId
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
