package com.vti.repository;

import com.vti.entity.Exam;
import com.vti.utils.HibernateUtils;
import org.hibernate.Session;

import java.util.List;

public class ExamRepository {

    private HibernateUtils instance;

    public ExamRepository() {
        instance = HibernateUtils.getInstance();
    }

    @SuppressWarnings("unchecked")
    public List<Exam> getAllExams() {
        try (Session session = instance.openSession()) {
            return session.createQuery("FROM Exam").list();
        }
    }

    public void createExam(Exam exam) {
        try (Session session = instance.openSession()) {
            session.beginTransaction();
            session.save(exam);
            session.getTransaction().commit();
            System.out.println("Exam created successfully");
        }
    }

    public Exam getExamById(short id) {
        try (Session session = instance.openSession()) {
            return session.createQuery("FROM Exam WHERE examId =:id", Exam.class)
                    .setParameter("id", id)
                    .uniqueResult();
        }
    }

    public List<Exam> getExamsByCode(String code) {
        try (Session session = instance.openSession()) {
            return session.createQuery("FROM Exam WHERE code LIKE :code", Exam.class)
                    .setParameter("code", "%" + code + "%")
                    .list();
        }
    }

    public List<Exam> getExamByTitle(String title) {
        try (Session session = instance.openSession()) {
            return session.createQuery("FROM Exam WHERE title LIKE :title", Exam.class)
                    .setParameter("title", "%" + title + "%")
                    .list();
        }
    }

    public List<Exam> getExamByCategory(short categoryId) {
        try (Session session = instance.openSession()) {
            return session.createQuery("FROM Exam WHERE category.categoryId =:id", Exam.class)
                    .setParameter("id", categoryId)
                    .list();
        }
    }

    public List<Exam> getExamByDuration(short duration) {
        try (Session session = instance.openSession()) {
            return session.createQuery("FROM Exam WHERE duration =:duration", Exam.class)
                    .setParameter("duration", duration)
                    .list();
        }
    }

    public List<Exam> getExamByCreator(short creatorId) {
        try (Session session = instance.openSession()) {
            return session.createQuery("FROM Exam WHERE creator.accountId =:id", Exam.class)
                    .setParameter("id", creatorId)
                    .list();
        }
    }

    public void updateExam(Exam exam) {
        try (Session session = instance.openSession()) {
            session.beginTransaction();
            session.update(exam);
            session.getTransaction().commit();
            System.out.println("Exam updated successfully");
        }
    }

    public void deleteExam(Exam exam) {
        try (Session session = instance.openSession()) {
            session.beginTransaction();
            session.delete(exam);
            session.getTransaction().commit();
            System.out.println("Exam deleted successfully");
        }
    }

    public int getCountByType(String type) {
        try (Session session = instance.openSession()) {
            return session.createQuery("SELECT COUNT(*) FROM Exam WHERE code LIKE :code", Long.class)
                    .setParameter("code", type + "%")
                    .uniqueResult().intValue();
        }
    }
}
