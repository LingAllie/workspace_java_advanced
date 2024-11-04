package com.vti.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Question")
public class Question implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "QuestionID")
    private short questionId;

    @Column(name = "Content", nullable = false)
    private String content;

    @ManyToOne
    @JoinColumn(name = "CategoryID", nullable = false)
    private CategoryQuestion category;

    @ManyToOne
    @JoinColumn(name = "TypeID", nullable = false)
    private TypeQuestion type;

    @ManyToOne
    @JoinColumn(name = "CreatorID", nullable = false, updatable = false)
    private Account creator;

    @Column(name = "CreateDate", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date createDate;

    public Question() {
    }

    public Question(String content, CategoryQuestion category, TypeQuestion type, Account creator) {
        this.content = content;
        this.category = category;
        this.type = type;
        this.creator = creator;
    }

    public short getQuestionId() {
        return questionId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public CategoryQuestion getCategory() {
        return category;
    }

    public void setCategory(CategoryQuestion category) {
        this.category = category;
    }

    public TypeQuestion getType() {
        return type;
    }

    public void setType(TypeQuestion type) {
        this.type = type;
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

    @Override
    public String toString() {
        return "Question{" +
                "questionId=" + questionId +
                ", content='" + content + '\'' +
                ", category=" + category +
                ", type=" + type +
                ", creator=" + creator +
                ", createDate=" + createDate +
                '}';
    }
}
