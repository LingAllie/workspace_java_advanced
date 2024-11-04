package com.vti.repository;

import com.vti.entity.Salary;
import com.vti.utils.HibernateUtils;
import org.hibernate.Session;

import java.util.List;

public class SalaryRepository {

    private HibernateUtils instance;

    public SalaryRepository() {
        instance = HibernateUtils.getInstance();
    }

    @SuppressWarnings("unchecked")
    public List<Salary> getAllSalaries() {
        try (Session session = instance.openSession()) {
            session.beginTransaction();
            List<Salary> salaries = session.createQuery("FROM Salary").list();
            session.getTransaction().commit();
            return salaries;
        }
    }

    public void createSalary(Salary salary) {
        try (Session session = instance.openSession()) {
            session.beginTransaction();
            session.save(salary);
            session.getTransaction().commit();
            System.out.println("Salary created successfully");
        }
    }

    public Salary getSalaryById(short id) {
        try (Session session = instance.openSession()) {
            session.beginTransaction();
            Salary salary = session.get(Salary.class, id);
            session.getTransaction().commit();
            return salary;
        }
    }

    private Salary getSalaryByName(Salary.SalaryName name) {
        try (Session session = instance.openSession()) {
            return (Salary) session.createQuery("FROM Salary WHERE salaryName = :name")
                    .setParameter("name", name)
                    .uniqueResult();
        }
    }

    public Salary getSalaryByName(short salaryIndex) {
        Salary.SalaryName name = getSalaryNameById(salaryIndex);
        return getSalaryByName(name);
    }

    public void updateSalary(short updatedSalaryId, short updatedSalary) {
        try (Session session = instance.openSession()) {
            session.beginTransaction();

            if (getSalaryById(updatedSalaryId) != null && getSalaryByName(getSalaryNameById(updatedSalary)) == null) {
                Salary salary = getSalaryById(updatedSalaryId);
                salary.setSalaryName(getSalaryNameById(updatedSalary));
                session.update(salary);
                System.out.println("Salary updated successfully");
            } else {
                System.out.println("Salary already exists");
            }
            session.getTransaction().commit();
        }
    }

    public Salary.SalaryName getSalaryNameById(short id) {
        switch (id) {
            case 2:
                return Salary.SalaryName.TEST;
            case 3:
                return Salary.SalaryName.SCRUMMASTER;
            case 4:
                return Salary.SalaryName.PM;
            default:
                return Salary.SalaryName.DEV;
        }
    }

    public void deleteSalary(short id) {
        try (Session session = instance.openSession()) {
            if (getSalaryById(id) != null) {
                session.beginTransaction();
                session.delete(getSalaryById(id));
                session.getTransaction().commit();
                System.out.println("Salary deleted successfully");
            } else {
                System.out.println("Salary not found.");
            }
        }
    }
}
