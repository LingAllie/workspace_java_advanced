package com.vti.repository;

import com.vti.entity.Employee;
import com.vti.entity.Manager;
import com.vti.utils.HibernateUtils;
import org.hibernate.Session;

import java.util.List;

public class ManagerRepository {
    private HibernateUtils instance;

    public ManagerRepository() {
        instance = HibernateUtils.getInstance();
    }

    @SuppressWarnings("unchecked")
    public List<Manager> getAllManagers() {
        try (Session session = instance.openSession()) {
            return session.createQuery("FROM Manager ").list();
        }
    }

    public void createManager(Manager manager) {
        try (Session session = instance.openSession()) {
            session.beginTransaction();
            session.save(manager);
            session.getTransaction().commit();
            System.out.println("Manager added successfully");
        }
    }

    public Manager getManagerById(short id) {
        try (Session session = instance.openSession()) {
            session.beginTransaction();
            Manager manager = session.get(Manager.class, id);
            session.getTransaction().commit();
            return manager;
        }
    }

    public List<Manager> getManagerByManageExperience(short year) {
        try (Session session = instance.openSession()) {
            session.beginTransaction();
            return session.createQuery("FROM Manager WHERE managementNumberOfYear = :year", Manager.class)
                    .setParameter("year", year).list();
        }
    }

    public void updateManagerManageExperience(Manager manager) {
        try (Session session = instance.openSession()) {
            session.beginTransaction();
            session.update(manager);
            session.getTransaction().commit();
            System.out.println("Manager updated successfully");
        }
    }

    public void deleteManager(short id) {
        try (Session session = instance.openSession()) {
            session.beginTransaction();
            session.delete(getManagerById(id));
            session.getTransaction().commit();
            System.out.println("Manager deleted successfully");
        }
    }
}
