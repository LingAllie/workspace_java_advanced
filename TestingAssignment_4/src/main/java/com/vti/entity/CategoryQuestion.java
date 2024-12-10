package com.vti.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "CategoryQuestion")
public class CategoryQuestion implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "CategoryID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short categoryId;

    @Column(name = "CategoryName", length = 50, nullable = false, unique = true)
    private String categoryName;

    @OneToMany(mappedBy = "category")
    private List<Question> question;

    @OneToMany(mappedBy = "category")
    private List<Exam> exams;

    public CategoryQuestion() {
    }

    public short getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(short categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<Question> getQuestion() {
        return question;
    }

    public void setQuestion(List<Question> question) {
        this.question = question;
    }

    public List<Exam> getExams() {
        return exams;
    }

    public void setExams(List<Exam> exams) {
        this.exams = exams;
    }

    @Override
    public String toString() {
        return "CategoryQuestion{" +
                "categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }
}
