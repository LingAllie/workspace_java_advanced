package com.vti.repository;

import com.vti.entity.Answer;
import com.vti.utils.HibernateUtils;
import org.hibernate.Session;

import java.io.Serializable;
import java.util.List;

public class AnswerRepository {

    private HibernateUtils instance;

    public AnswerRepository() {
        instance = HibernateUtils.getInstance();
    }

    @SuppressWarnings("unchecked")
    public List<Answer> getAllAnswers() {
        try (Session session = instance.openSession()) {
            return session.createQuery("FROM Answer").list();
        }
    }

    public void createAnswer(Answer answer) {
        try (Session session = instance.openSession()) {
            session.beginTransaction();
            session.save(answer);
            session.getTransaction().commit();
            System.out.println("Successfully created answer");
        }
    }

    public Answer getAnswerById(short id) {
        try (Session session = instance.openSession()) {
            return session.get(Answer.class, id);
        }
    }

    public List<Answer> getAnswerByContent(String content) {
        try (Session session = instance.openSession()) {
            return session.createQuery("FROM Answer WHERE content LIKE :content", Answer.class)
                    .setParameter("content", "%" + content + "%")
                    .list();
        }
    }

    public List<Answer> getAnswerByQuestionId(short questionId) {
        try (Session session = instance.openSession()) {
            return session.createQuery("FROM Answer WHERE question.questionId =:questionId", Answer.class)
                    .setParameter("questionId", questionId)
                    .list();
        }
    }

    public List<Answer> getAnswerByCorrectStatus(boolean status) {
        try (Session session = instance.openSession()) {
            return session.createQuery("FROM Answer WHERE isCorrect =:status", Answer.class)
                    .setParameter("status", status)
                    .list();
        }
    }

    public void updateAnswer(Answer answer) {
        try (Session session = instance.openSession()) {
            session.beginTransaction();
            session.update(answer);
            session.getTransaction().commit();
            System.out.println("Successfully updated answer");
        }
    }

    public void deleteAnswer(short id) {
        try (Session session = instance.openSession()) {
            session.beginTransaction();
            session.delete(getAnswerById(id));
            session.getTransaction().commit();
            System.out.println("Successfully deleted answer");
        }
    }
}
