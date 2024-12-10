package com.vti.repository;

import com.vti.entity.CategoryQuestion;
import com.vti.entity.Department;
import com.vti.utils.HibernateUtils;
import org.hibernate.Session;

import java.util.List;

public class CategoryQuestionRepository {

    private HibernateUtils hibernateUtils;

    public CategoryQuestionRepository() {
        hibernateUtils = HibernateUtils.getInstance();
    }

    public void createCategoryQuestion(CategoryQuestion categoryQuestion) {
        try (Session session = hibernateUtils.openSession()) {
            session.beginTransaction();
            session.save(categoryQuestion);
            session.getTransaction().commit();
            System.out.println("Category Question created successfully");
        }
    }

    @SuppressWarnings("unchecked")
    public List<CategoryQuestion> getAllCategoryQuestions() {
        try (Session session = hibernateUtils.openSession()) {
            return session.createQuery("FROM CategoryQuestion").list();
        }
    }

    public CategoryQuestion getCategoryQuestionById(short id) {
        try (Session session = hibernateUtils.openSession()) {
            return session.get(CategoryQuestion.class, id);
        }
    }

    public List<CategoryQuestion> getCategoryQuestionByName(String name) {
        try (Session session = hibernateUtils.openSession()) {
            return session.createQuery("FROM CategoryQuestion WHERE categoryName LIKE :name", CategoryQuestion.class)
                    .setParameter("name", "%" + name + "%")
                    .list();
        }
    }

    public void updateCategoryQuestionName(CategoryQuestion categoryQuestion) {
        try (Session session = hibernateUtils.openSession()) {
            session.beginTransaction();
            session.update(categoryQuestion);
            session.getTransaction().commit();
            System.out.println("CategoryQuestion name updated successfully");
        }
    }

    public void deleteCategoryQuestion(short id) {
        try (Session session = hibernateUtils.openSession()) {
            session.beginTransaction();
            CategoryQuestion categoryQuestion = session.get(CategoryQuestion.class, id);
            session.delete(categoryQuestion);
            session.getTransaction().commit();
            System.out.println("CategoryQuestion deleted successfully");
        }
    }

    public boolean checkExistCategoryQuestionByName(String name) {
        try (Session session = hibernateUtils.openSession()) {
            CategoryQuestion categoryQuestion = session.createQuery("FROM CategoryQuestion WHERE categoryName = :name", CategoryQuestion.class)
                    .setParameter("name", name)
                    .uniqueResult();
            return categoryQuestion != null;
        }
    }
}
