package com.vti.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.vti.entity.Department;
import com.vti.entity.Exam;
import com.vti.utils.HibernateUtils;

public class ExamRepository {

	private HibernateUtils hibernateUtils;

	public ExamRepository() {
		hibernateUtils = HibernateUtils.getInstance();
	}

	@SuppressWarnings("unchecked")
	public List<Exam> getAllExams() {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// create hql query
			Query<Exam> query = session.createQuery("FROM Exam");

			return query.list();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public Exam getExamByID(short id) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// get exam by id
			Exam exam = session.get(Exam.class, id);

			return exam;

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@SuppressWarnings("unchecked")
	public List<Exam> getExamByTitle(String title) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// create hql query
			Query<Exam> query = session.createQuery("FROM Exam WHERE Title LIKE :title");

			// set parameter
			query.setParameter("title", "%" + title + "%");

			return query.list();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void createExam(Exam exam, short duration) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			
			int count = 0;
			
			if (duration >= 180) {
				count = getCountByType("L");
				exam.setCode1("L-" + (count + 1));
				exam.setCode2("L-" + (count + 1));
			}
			
			if (duration >= 90 && duration < 180) {
				count = getCountByType("M");
				exam.setCode1("M-" + (count + 1));
				exam.setCode2("M-" + (count + 1));
			}
			
			if (duration < 90) {
				count = getCountByType("S");
				exam.setCode1("S-" + (count + 1));
				exam.setCode2("S-" + (count + 1));
			}
			
//			exam.setExamId((short) (getCount() + 1));
			
			session.beginTransaction();

			// create
			session.save(exam);
			session.getTransaction().commit();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void updateExam(short id, String newTitle, short newDuration) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			// get exam
			Exam exam = (Exam) session.load(Exam.class, id);

			// update
			if (newTitle != null) {
				exam.setExamTitle(newTitle);
			} else {
				newTitle = exam.getExamTitle();
				exam.setExamTitle(newTitle);
			}
			
			if (newDuration >= 45 ) {
				exam.setDuration(newDuration);
			} else {
				newDuration = exam.getDuration();
				exam.setDuration(newDuration);
			}
			
			
			session.getTransaction().commit();
			
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void updateExam(Exam exam) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();
			
			// update
			session.update(exam);
			session.getTransaction().commit();
			
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void deleteExam(short id) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			session.beginTransaction();

			// get exam
			Exam exam = (Exam) session.load(Exam.class, id);

			// delete
			session.delete(exam);

			session.getTransaction().commit();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public boolean isExamExistsByID(short id) {

		// get exam
		Exam exam = getExamByID(id);

		// return result
		if (exam == null) {
			return false;
		}

		return true;
	}

	public boolean isExamExistsByTitle(String title) {
		List<Exam> exam = getExamByTitle(title);

		if (exam.size() == 0) {
			return false;
		}
		return true;
	}
	
	@SuppressWarnings({ "unchecked" })
	public int getCountByType(String type) {
	    Session session = null;
	    try {
	        session = hibernateUtils.openSession();
	               
	        // Create HQL query
	        Query<Long> query = session.createQuery("SELECT COUNT(1) FROM Exam WHERE Code1 LIKE :codeParameter", Long.class);
	        
	        // Set parameter
	        query.setParameter("codeParameter", type + "%");
	        
	        // get result
	        return query.uniqueResult().intValue();
	    } finally {
	        if (session != null) {
	            session.close();
	        }
	    }
	}
	
	@SuppressWarnings({ "unchecked" })
	public int getCount() {
	    Session session = null;
	    try {
	        session = hibernateUtils.openSession();
	               
	        // Create HQL query
	        Query<Long> query = session.createQuery("SELECT COUNT(*) FROM Exam ", Long.class);
	        
	        // get result
	        return query.uniqueResult().intValue();
	    } finally {
	        if (session != null) {
	            session.close();
	        }
	    }
	}

}
