package com.vti.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ExamQuestion")
public class ExamQuestion implements Serializable {
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private ExamQuestionId id;

    @ManyToOne
    @MapsId("examID")
    @JoinColumn(name = "ExamID",referencedColumnName = "ExamID", nullable = false)
    private Exam exam;

    @ManyToOne
    @MapsId("questionID")
    @JoinColumn(name = "QuestionID", referencedColumnName = "QuestionID", nullable = false)
    private Question question;

    public ExamQuestion() {}

    public ExamQuestion(ExamQuestionId id, Exam exam, Question question) {
        this.id = id;
        this.exam = exam;
        this.question = question;
    }

    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public ExamQuestionId getId() {
        return id;
    }

    public void setId(ExamQuestionId id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ExamQuestion{" +
                "exam=" + exam +
                ", question=" + question +
                '}';
    }

    @Embeddable
    public static class ExamQuestionId implements Serializable {
        private static final long serialVersionUID = 1L;

        @Column(name = "ExamID", nullable = false)
        private short examID;

        @Column(name = "QuestionID", nullable = false)
        private short questionID;

        public ExamQuestionId() {}

        public ExamQuestionId(short examID, short questionID) {
            this.examID = examID;
            this.questionID = questionID;
        }

        public short getExamID() {
            return examID;
        }

        public void setExamID(short examID) {
            this.examID = examID;
        }

        public short getQuestionID() {
            return questionID;
        }

        public void setQuestionID(short questionID) {
            this.questionID = questionID;
        }
    }
}
