package com.vti.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "`Group`")
public class Group implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "GroupID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short groupId;

    @Column(name = "GroupName", length = 50, nullable = false, unique = true)
    private String groupName;

    @ManyToOne
    @JoinColumn(name = "CreatorID", referencedColumnName = "AccountID", updatable = false)
    private Account creator;

    @Column(name = "CreateDate", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date createDate;

    @OneToMany(mappedBy = "group")
    private List<GroupAccount> groupAccounts;

    public Group() {
    }

    public Group(String groupName, Account creator) {
        this.groupName = groupName;
        this.creator = creator;
    }

    public short getGroupId() {
        return groupId;
    }

    public void setGroupId(short groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Account getCreator() {
        return creator;
    }

    public void setCreator(Account creator) {
        this.creator = creator;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public List<GroupAccount> getGroupAccounts() {
        return groupAccounts;
    }

    public void setGroupAccounts(List<GroupAccount> groupAccounts) {
        this.groupAccounts = groupAccounts;
    }

    @Override
    public String toString() {
        return "Group{" +
                "groupId=" + groupId +
                ", groupName='" + groupName + '\'' +
                ", creatorId=" + creator +
                ", createDate=" + createDate +
                '}';
    }
}
