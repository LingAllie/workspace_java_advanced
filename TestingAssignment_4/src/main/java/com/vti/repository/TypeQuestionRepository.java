package com.vti.repository;

import com.vti.entity.Position;
import com.vti.entity.TypeQuestion;
import com.vti.utils.HibernateUtils;
import org.hibernate.Session;

import java.util.List;

public class TypeQuestionRepository {

    private HibernateUtils instance;

    public TypeQuestionRepository() {
        instance = HibernateUtils.getInstance();
    }

    // 1. Get all type questions
    @SuppressWarnings("unchecked")
    public List<TypeQuestion> getAllTypeQuestions() {
        try (Session session = instance.openSession()) {
            session.beginTransaction();
            List<TypeQuestion> typeQuestions = session.createQuery("FROM TypeQuestion").list();
            session.getTransaction().commit();
            return typeQuestions;
        }
    }

    // 2. Get typeQuestion by id
    public TypeQuestion getTypeQuestionById(short id) {
        try (Session session = instance.openSession()) {
            session.beginTransaction();
            TypeQuestion typeQuestion = session.get(TypeQuestion.class, id);
            session.getTransaction().commit();
            return typeQuestion;
        }
    }

}
