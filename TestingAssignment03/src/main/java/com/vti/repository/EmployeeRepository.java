package com.vti.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.vti.entity.Employee;
import com.vti.utils.HibernateUtils;

public class EmployeeRepository {

    private HibernateUtils hibernateUtils;

    public EmployeeRepository() {
        hibernateUtils = HibernateUtils.getInstance();
    }

    @SuppressWarnings("unchecked")
    public List<Employee> getAllEmployees() {

        Session session = null;

        try {

            // get session
            session = hibernateUtils.openSession();

            // create hql query
            Query<Employee> query = session.createQuery("FROM Employee");

            return query.list();

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public Employee getEmployeeByID(short id) {

        Session session = null;

        try {

            // get session
            session = hibernateUtils.openSession();

            Employee employee = session.get(Employee.class, id);

            return employee;

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @SuppressWarnings("unchecked")
    public List<Employee> getEmployeeByWorkingNumberOfYear(short numberOfYear) {

        Session session = null;

        try {

            // get session
            session = hibernateUtils.openSession();

            // create HQL query with distinct parameters for first and last names
            Query<Employee> query = session.createQuery("FROM Employee WHERE 'WorkingNumberOfYear' = :year");

            // set parameters
            query.setParameter("year", numberOfYear);

            // get result
            return query.list();


        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void createEmployee(Employee employee) {

        Session session = null;

        try {

            // get session
            session = hibernateUtils.openSession();

            // create
            session.save(employee);

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void updateEmployee1(short id, short workingOfYear) {

        Session session = null;

        try {

            // get session
            session = hibernateUtils.openSession();
            session.beginTransaction();

            Employee account = (Employee) session.load(Employee.class, id);

            // update
            if (workingOfYear < 0) {
                account.setWorkingNumberOfYear(account.getWorkingNumberOfYear());
            } else {
                account.setWorkingNumberOfYear(workingOfYear);
            }

            session.getTransaction().commit();

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void updateEmployee2(Employee employee) {
        Session session = null;
        try {

            session = hibernateUtils.openSession();
            session.beginTransaction();

            session.update(employee);
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }


    public void deleteEmployee(short id) {

        Session session = null;

        try {

            // get session
            session = hibernateUtils.openSession();

            session.beginTransaction();

            Employee employee = (Employee) session.load(Employee.class, id);

            // delete
            session.delete(employee);

            session.getTransaction().commit();

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public boolean isEmployeeExistsByID(short id) {

        Employee employee = getEmployeeByID(id);

        // return result
        if (employee == null) {
            return false;
        }

        return true;
    }

    public boolean isAccountExistsByName(short year) {
        if (getEmployeeByWorkingNumberOfYear(year) == null) {
            return false;
        }

        return true;
    }

}
