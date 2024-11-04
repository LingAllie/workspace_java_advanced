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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "GroupID")
    private short groupId;

    @Column(name = "GroupName", length = 50, nullable = false, unique = true)
    private String groupName;

    @ManyToOne
    @JoinColumn(name = "CreatorID", nullable = false, updatable = false)
    private Account creator;  // Đổi kiểu từ short sang Account để tạo mối quan hệ

    @Column(name = "CreateDate", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date createDate;

    @OneToMany(mappedBy = "account", fetch = FetchType.EAGER)
    private List<GroupAccount> groupAccountList;

    public Group() {
    }

    public Group(short groupId, String groupName, Account creator, Date createDate) {
        this.groupId = groupId;
        this.groupName = groupName;
        this.creator = creator;
        this.createDate = createDate;
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

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public List<GroupAccount> getGroupAccountList() {
        return groupAccountList;
    }

    public void setGroupAccountList(List<GroupAccount> groupAccountList) {
        this.groupAccountList = groupAccountList;
    }

    @Override
    public String toString() {
        return "Group{" +
                "groupId=" + groupId +
                ", groupName='" + groupName + '\'' +
                ", creator=" + creator +
                ", createDate=" + createDate +
                '}';
    }
}
