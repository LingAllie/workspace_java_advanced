package com.vti.repository;

import com.vti.entity.Department;
import com.vti.utils.HibernateUtils;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

public class DepartmentRepository {

    private HibernateUtils hibernateUtils;

    public DepartmentRepository() {
        hibernateUtils = HibernateUtils.getInstance();
    }

    public void createDepartment(Department department) {
        try (Session session = hibernateUtils.openSession()) {
            session.beginTransaction();
            session.save(department);
            session.getTransaction().commit();
            System.out.println("Department created successfully");
        }
    }

    @SuppressWarnings("unchecked")
    public List<Department> getAllDepartments() {
        try (Session session = hibernateUtils.openSession()) {
            return session.createQuery("FROM Department").list();
        }
    }

    public Department getDepartmentById(short id) {
        try (Session session = hibernateUtils.openSession()) {
            return session.get(Department.class, id);
        }
    }

    public Department getDepartmentByName(String name) {
        try (Session session = hibernateUtils.openSession()) {
            return session.createQuery("FROM Department WHERE departmentName = :name", Department.class)
                    .setParameter("name", name)
                    .uniqueResult();
        }
    }

    public void updateDepartmentName(Department department) {
        try (Session session = hibernateUtils.openSession()) {
            session.beginTransaction();
            session.update(department);
            session.getTransaction().commit();
            System.out.println("Department name updated successfully");
        }
    }

    public void deleteDepartment(short id) {
        try (Session session = hibernateUtils.openSession()) {
            session.beginTransaction();
            Department department = session.get(Department.class, id);
            session.delete(department);
            session.getTransaction().commit();
            System.out.println("Department deleted successfully");
        }
    }
}
