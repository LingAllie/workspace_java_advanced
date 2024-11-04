package com.vti.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ExamQuestion")
@IdClass(ExamQuestionId.class)
public class ExamQuestion implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ExamID", nullable = false)
    private short examId;

    @Id
    @Column(name = "QuestionID", nullable = false)
    private short questionId;

    @ManyToOne
    @JoinColumn(name = "ExamID", insertable = false, updatable = false)
    private Exam exam;

    @ManyToOne
    @JoinColumn(name = "QuestionID", insertable = false, updatable = false)
    private Question question;

    public ExamQuestion() {
    }

    public ExamQuestion(short examId, short questionId) {
        this.examId = examId;
        this.questionId = questionId;
    }

    public short getExamId() {
        return examId;
    }

    public short getQuestionId() {
        return questionId;
    }

    public Exam getExam() {
        return exam;
    }

    public Question getQuestion() {
        return question;
    }

    @Override
    public String toString() {
        return "ExamQuestion{" +
                "examId=" + examId +
                ", questionId=" + questionId +
                '}';
    }
}

class ExamQuestionId implements Serializable {
    private short examId;
    private short questionId;

    public ExamQuestionId() {}

    public short getExamId() {
        return examId;
    }

    public void setExamId(short examId) {
        this.examId = examId;
    }

    public short getQuestionId() {
        return questionId;
    }

    public void setQuestionId(short questionId) {
        this.questionId = questionId;
    }
}
