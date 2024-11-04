package com.vti.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.vti.entity.Answer;
import com.vti.utils.HibernateUtils;

public class AnswerRepository {

    private HibernateUtils hibernateUtils;

    public AnswerRepository() {
        hibernateUtils = HibernateUtils.getInstance();
    }

    @SuppressWarnings("unchecked")
    public List<Answer> getAllAnswers() {

        Session session = null;

        try {

            // get session
            session = hibernateUtils.openSession();

            // create hql query
            Query<Answer> query = session.createQuery("FROM Answer");

            return query.list();

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public Answer getAnswerByID(short id) {

        Session session = null;

        try {

            // get session
            session = hibernateUtils.openSession();

            // get answer by id

            return session.get(Answer.class, id);

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @SuppressWarnings("unchecked")
    public List<Answer> getAnswerByContent(String content) {

        Session session = null;

        try {

            // get session
            session = hibernateUtils.openSession();

            // create hql query
            Query<Answer> query = session.createQuery("FROM Answer WHERE 'Content' LIKE :content");

            // set parameter
            query.setParameter("content", "%" + content + "%");

            return query.list();

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void createAnswer(Answer answer) {

        Session session = null;

        try {

            // get session
            session = hibernateUtils.openSession();

            // create
            session.save(answer);

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void updateAnswer(short id, String newContent, boolean newStatus) {

        Session session = null;

        try {

            // get session
            session = hibernateUtils.openSession();
            session.beginTransaction();

            // get answer
            Answer answer = (Answer) session.load(Answer.class, id);

            // update
            if (newContent == "") {
                answer.setContent(answer.getContent());
            } else {
                answer.setContent(newContent);
            }

            answer.setCorrect(newStatus);

            session.getTransaction().commit();

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void updateAnswer(Answer answer) {

        Session session = null;

        try {

            // get session
            session = hibernateUtils.openSession();
            session.beginTransaction();

            // update
            session.update(answer);
            session.getTransaction().commit();

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void deleteAnswer(short id) {

        Session session = null;

        try {

            // get session
            session = hibernateUtils.openSession();

            session.beginTransaction();

            // get answer
            Answer answer = (Answer) session.load(Answer.class, id);

            // delete
            session.delete(answer);

            session.getTransaction().commit();

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public boolean isAnswerExistsByID(short id) {

        // get department
        Answer answer = getAnswerByID(id);

        // return result
        return answer != null;
    }

    public boolean isAnswerExistsByContent(String content) {
        List<Answer> answer = getAnswerByContent(content);

        return answer.size() != 0;
    }

}
