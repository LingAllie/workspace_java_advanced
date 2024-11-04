package com.vti.repository;

import com.vti.entity.Question;
import com.vti.utils.HibernateUtils;
import org.hibernate.Session;

import java.util.List;

public class QuestionRepository {

    private HibernateUtils instance;

    public QuestionRepository() {
        instance = HibernateUtils.getInstance();
    }

    @SuppressWarnings("unchecked")
    public List<Question> getAllQuestions() {
        try (Session session = instance.openSession()) {
            return session.createQuery("FROM Question").list();
        }
    }

    public void createQuestion(Question question) {
        try (Session session = instance.openSession()) {
            session.beginTransaction();
            session.save(question);
            session.getTransaction().commit();
            System.out.println("Question created successfully");
        }
    }

    public Question getQuestionById(short id) {
        try (Session session = instance.openSession()) {
            return session.get(Question.class, id);
        }
    }

    public List<Question> getQuestionByContent(String content) {
        try (Session session = instance.openSession()) {
            return session.createQuery("FROM Question WHERE content LIKE :content", Question.class)
                    .setParameter("content", "%" + content + "%")
                    .list();
        }
    }

    public List<Question> getQuestionByCategory(short categoryId) {
        try (Session session = instance.openSession()) {
            return session.createQuery("FROM Question WHERE category.categoryId = :id", Question.class)
                    .setParameter("id", categoryId)
                    .list();
        }
    }

    public List<Question> getQuestionByType(short typeId) {
        try (Session session = instance.openSession()) {
            return session.createQuery("FROM Question WHERE type.typeId = :id", Question.class)
                    .setParameter("id", typeId)
                    .list();
        }
    }

    public List<Question> getQuestionByCreator(short creatorId) {
        try (Session session = instance.openSession()) {
            return session.createQuery("FROM Question WHERE creator.accountId = :id", Question.class)
                    .setParameter("id", creatorId)
                    .list();
        }
    }

    public void updateQuestion(Question question) {
        try (Session session = instance.openSession()) {
            session.beginTransaction();
            session.update(question);
            session.getTransaction().commit();
            System.out.println("Question updated successfully");
        }
    }

    public void deleteQuestion(short id) {
        try (Session session = instance.openSession()) {
            session.beginTransaction();
            Question question = session.get(Question.class, id);
            session.delete(question);
            session.getTransaction().commit();
            System.out.println("Question deleted successfully");
        }
    }
}
