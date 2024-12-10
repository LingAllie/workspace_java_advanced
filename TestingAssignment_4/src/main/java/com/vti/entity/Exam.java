package com.vti.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Exam")
public class Exam implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "ExamID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short examId;

    @Column(name = "Code", length = 10, nullable = false, updatable = false)
    private String code;

    @Column(name = "Title", length = 50, nullable = false)
    private String title;

    @ManyToOne
    @JoinColumn(name = "CategoryID", referencedColumnName = "CategoryID", nullable = false)
    private CategoryQuestion category;

    @Column(name = "Duration", nullable = false)
    private short duration;

    @ManyToOne
    @JoinColumn(name = "CreatorID", referencedColumnName = "AccountId", nullable = false, updatable = false)
    private Account creator;

    @Column(name = "CreateDate", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date createDate;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "ExamQuestion",
            joinColumns = { @JoinColumn(name = "ExamID") },
            inverseJoinColumns = { @JoinColumn(name = "QuestionID") }
    )
    private List<Question> questions;

    @PrePersist
    public void prePersist() {
        if(this.duration <= 0) {
            this.duration = 45;
        }
        ExamCodeGenerator generator = new ExamCodeGenerator();
        this.code = generator.generate(duration);
    }

    public Exam() {
    }

    public Exam(String title, CategoryQuestion category, short duration, Account creator) {
        this.title = title;
        this.category = category;
        this.duration = duration;
        this.creator = creator;
    }

    public short getExamId() {
        return examId;
    }

    public void setExamId(short examId) {
        this.examId = examId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public CategoryQuestion getCategory() {
        return category;
    }

    public void setCategory(CategoryQuestion category) {
        this.category = category;
    }

    public short getDuration() {
        return duration;
    }

    public void setDuration(short duration) {
        this.duration = duration;
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

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
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
