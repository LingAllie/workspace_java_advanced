package com.vti.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Answer")
public class Answer implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Answers")
    private short answers;

    @Column(name = "Content", length = 100, nullable = false)
    private String content;

    @ManyToOne
    @JoinColumn(name = "QuestionID", nullable = false)
    private Question question;

    @Column(name = "isCorrect", nullable = false)
    private boolean isCorrect = true;

    public Answer() {
    }

    public Answer(String content, Question question, boolean isCorrect) {
        this.content = content;
        this.question = question;
        this.isCorrect = isCorrect;
    }

    public short getAnswers() {
        return answers;
    }

    public void setAnswers(short answers) {
        this.answers = answers;
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
                "answers=" + answers +
                ", content='" + content + '\'' +
                ", question=" + question +
                ", isCorrect=" + isCorrect +
                '}';
    }
}
