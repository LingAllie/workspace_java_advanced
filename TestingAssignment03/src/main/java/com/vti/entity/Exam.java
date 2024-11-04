package com.vti.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Exam")
public class Exam implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ExamID")
    private short examId;

    @Column(name = "`Code`", length = 10, nullable = false, updatable = false)
    private String code;

    @Column(name = "Title", length = 50, nullable = false)
    private String title;

    @ManyToOne
    @JoinColumn(name = "CategoryID", nullable = false)
    private CategoryQuestion category;

    @Column(name = "Duration", nullable = false)
    private short duration = 45;

    @ManyToOne
    @JoinColumn(name = "CreatorID", nullable = false, updatable = false)
    private Account creator;

    @Column(name = "CreateDate", updatable = false)
    @CreationTimestamp
    private Date createDate;

    public Exam() {
    }

    public Exam(String code, String title, CategoryQuestion category, short duration, Account creator) {
        this.code = code;
        this.title = title;
        this.category = category;
        this.duration = duration;
        this.creator = creator;
    }

    public void setExamId(short examId) {
        this.examId = examId;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCategory(CategoryQuestion category) {
        this.category = category;
    }

    public void setDuration(short duration) {
        this.duration = duration;
    }

    public void setCreator(Account creator) {
        this.creator = creator;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public short getExamId() {
        return examId;
    }

    public String getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public CategoryQuestion getCategory() {
        return category;
    }

    public short getDuration() {
        return duration;
    }

    public Account getCreator() {
        return creator;
    }

    public Date getCreateDate() {
        return createDate;
    }

    @Override
    public String toString() {
        return "Exam{" +
                "examId=" + examId +
                ", code='" + code + '\'' +
                ", title='" + title + '\'' +
                ", category=" + category +
                ", duration=" + duration +
                ", creator=" + creator +
                ", createDate=" + createDate +
                '}';
    }
}
