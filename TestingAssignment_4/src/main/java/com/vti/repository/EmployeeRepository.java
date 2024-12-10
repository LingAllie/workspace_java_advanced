package com.vti.repository;

import com.vti.entity.Employee;
import com.vti.utils.HibernateUtils;
import org.hibernate.Session;

import java.util.List;

public class EmployeeRepository {
    private HibernateUtils instance;

    public EmployeeRepository() {
        instance = HibernateUtils.getInstance();
    }

    @SuppressWarnings("unchecked")
    public List<Employee> getAllEmployees() {
        try (Session session = instance.openSession()) {
            return session.createQuery("FROM Employee").list();
        }
    }

    public void createEmployee(Employee employee) {
        try (Session session = instance.openSession()) {
            session.beginTransaction();
            session.save(employee);
            session.getTransaction().commit();
            System.out.println("Employee added successfully");
        }
    }

    public Employee getEmployeeById(short id) {
        try (Session session = instance.openSession()) {
            session.beginTransaction();
            Employee employee = session.get(Employee.class, id);
            session.getTransaction().commit();
            return employee;
        }
    }

    public List<Employee> getEmployeeByWorkingExperience(short year) {
        try (Session session = instance.openSession()) {
            session.beginTransaction();
            return session.createQuery("FROM Employee WHERE workingNumberOfYear = :year", Employee.class)
                    .setParameter("year", year).list();
        }
    }

    public void updateEmployeeWorkingExperience(Employee employee) {
        try (Session session = instance.openSession()) {
            session.beginTransaction();
            session.update(employee);
            session.getTransaction().commit();
            System.out.println("Employee updated successfully");
        }
    }

    public void deleteEmployee(short id) {
        try (Session session = instance.openSession()) {
            session.beginTransaction();
            session.delete(getEmployeeById(id));
            session.getTransaction().commit();
            System.out.println("Employee deleted successfully");
        }
    }
}
