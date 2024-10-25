package com.vti.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.vti.entity.Question;
import com.vti.utils.HibernateUtils;

public class QuestionRepository {

	private HibernateUtils hibernateUtils;

	public QuestionRepository() {
		hibernateUtils = HibernateUtils.getInstance();
	}

	@SuppressWarnings("unchecked")
	public List<Question> getAllQuestions() {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// create hql query
			Query<Question> query = session.createQuery("FROM Question");

			return query.list();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public Question getQuestionByID(short id) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// get question by id
			Question question = session.get(Question.class, id);

			return question;

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@SuppressWarnings("unchecked")
	public List<Question> getQuestionByContent(String content) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// create hql query
			Query<Question> query = session.createQuery("FROM Question WHERE Content LIKE :content", Question.class);
			
			// set parameter
			query.setParameter("content", "%" + content + "%");

			return query.list();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void createQuestion(Question question) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			
			Query<Question> query  = session.createQuery("FROM Question WHERE Content = :content", Question.class);
			query.setParameter("content", question.getContent());
			
			if (query.uniqueResult() != null) {
				System.out.println("Question has existed !");
			} else {
				// create
				session.save(question);
			}

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void updateQuestion(short id, String newContent) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// get question
			Question question = (Question) session.load(Question.class, id);

			// update
			question.setContent(newContent);
			
			session.getTransaction().commit();
			
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void updateQuestion(Question question) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();
			
			// update
			session.update(question);
			session.getTransaction().commit();
			
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void deleteQuestion(short id) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			session.beginTransaction();

			// get question
			Question question = (Question) session.load(Question.class, id);

			// delete
			session.delete(question);

			session.getTransaction().commit();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public boolean isQuestionExistsByID(short id) {

		// get question
		Question question = getQuestionByID(id);

		// return result
		if (question == null) {
			return false;
		}

		return true;
	}

	public boolean isQuestionExistsByContent(String content) {
		List<Question> questions = getQuestionByContent(content);

		if (questions.size() == 0) {
			return false;
		}
		return true;
	}

}
