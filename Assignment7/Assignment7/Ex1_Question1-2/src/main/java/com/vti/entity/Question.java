package com.vti.entity;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Question")
public class Question implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "QuestionID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short questionId;

    @Column(name = "Content", length = 100, nullable = false)
    private String content;

    @ManyToOne
    @JoinColumn(name = "CategoryID", referencedColumnName = "CategoryID")
    private CategoryQuestion category;

    @ManyToOne
    @JoinColumn(name = "TypeID", referencedColumnName = "TypeID")
    private TypeQuestion type;

    @OneToOne
    @JoinColumn(name = "CreatorID", referencedColumnName = "AccountId", nullable = false, unique = true, updatable = false)
    private Account creator;

    @Column(name = "CreateDate", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date createDate;

    @OneToMany(mappedBy = "question")
    private List<Answer> answers;

    @ManyToMany(mappedBy = "questions", fetch = FetchType.EAGER)
    private List<Exam> exams;

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

    public void setQuestionId(short questionId) {
        this.questionId = questionId;
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

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public List<Exam> getExams() {
        return exams;
    }

    public void setExams(List<Exam> exams) {
        this.exams = exams;
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
