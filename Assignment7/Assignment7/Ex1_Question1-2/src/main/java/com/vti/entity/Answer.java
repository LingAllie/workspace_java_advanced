package com.vti.entity;

import jakarta.persistence.Entity;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Answer")
public class Answer implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "Answers")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short answerId;

    @Column(name = "Content", length = 100, nullable = false)
    private String content;

    @ManyToOne
    @JoinColumn(name = "QuestionID", referencedColumnName = "QuestionID", nullable = false)
    private Question question;

    @Column(name = "isCorrect")
    private boolean isCorrect = true;

    public Answer() {
    }

    public Answer(String content, Question question, boolean isCorrect) {
        this.content = content;
        this.question = question;
        this.isCorrect = isCorrect;
    }

    public short getAnswerId() {
        return answerId;
    }

    public void setAnswerId(short answerId) {
        this.answerId = answerId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "answerId=" + answerId +
                ", content='" + content + '\'' +
                ", question=" + question +
                ", isCorrect=" + isCorrect +
                '}';
    }
}
