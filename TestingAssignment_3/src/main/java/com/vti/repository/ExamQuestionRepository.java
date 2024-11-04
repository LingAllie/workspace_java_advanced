package com.vti.repository;

import com.vti.entity.ExamQuestion;
import com.vti.utils.HibernateUtils;
import org.hibernate.Session;

import java.util.List;

public class ExamQuestionRepository {

    private HibernateUtils instance;

    public ExamQuestionRepository() {
        instance = HibernateUtils.getInstance();
    }

    @SuppressWarnings("unchecked")
    public List<ExamQuestion> getAllExamQuestions() {
        try (Session session = instance.openSession()) {
            return session.createQuery("FROM ExamQuestion").list();
        }
    }

    public void createExamQuestion(ExamQuestion examQuestion) {
        try (Session session = instance.openSession()) {
            session.beginTransaction();
            System.out.println(examQuestion);
            session.save(examQuestion);
            session.getTransaction().commit();
            System.out.println("Exam Question created successfully");
        }
    }

    public List<ExamQuestion> getExamQuestionByExamId(short id) {
        try (Session session = instance.openSession()) {
            return session.createQuery("FROM ExamQuestion WHERE exam.examId =:id", ExamQuestion.class)
                    .setParameter("id", id)
                    .list();
        }
    }

    public List<ExamQuestion> getExamQuestionByQuestionId(short id) {
        try (Session session = instance.openSession()) {
            return session.createQuery("FROM ExamQuestion WHERE question.questionId =:id", ExamQuestion.class)
                    .setParameter("id", id)
                    .list();
        }
    }

    public ExamQuestion getExamQuestionByExamIdAndQuestionId(short examId, short questionId) {
        try (Session session = instance.openSession()) {
            return session.createQuery("FROM ExamQuestion WHERE exam.examId =:examId AND question.questionId =:questionId", ExamQuestion.class)
                    .setParameter("examId", examId)
                    .setParameter("questionId", questionId)
                    .uniqueResult();
        }
    }

    public void deleteExamQuestionByExamId(short examId) {
        try (Session session = instance.openSession()) {
            session.beginTransaction();
            // HQL to delete all GroupAccount entries for the specified groupId
            session.createQuery("DELETE FROM ExamQuestion WHERE exam.examId = :examId")
                    .setParameter("examId", examId)
                    .executeUpdate();
            session.getTransaction().commit();
            System.out.println("All exams removed from exam ID " + examId + " successfully.");
        }
    }

    public void deleteQuestionFromExam(short examId, short questionId) {
        try (Session session = instance.openSession()) {
            session.beginTransaction();
            int result = session.createQuery("DELETE FROM ExamQuestion WHERE exam.examId = :examId AND question.questionId = :questionId")
                    .setParameter("examId", examId)
                    .setParameter("questionId", questionId)
                    .executeUpdate();

            if (result > 0) {
                System.out.println("Question ID " + questionId + " removed from exam ID " + examId + " successfully.");
            } else {
                System.out.println("No question found with ID " + questionId + " in exam ID " + examId + ".");
            }

            session.getTransaction().commit();
        }
    }
}
