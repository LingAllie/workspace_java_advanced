package com.vti.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.vti.entity.Manager;
import com.vti.utils.HibernateUtils;

public class ManagerRepository {

    private HibernateUtils hibernateUtils;

    public ManagerRepository() {
        hibernateUtils = HibernateUtils.getInstance();
    }

    @SuppressWarnings("unchecked")
    public List<Manager> getAllManagers() {

        Session session = null;

        try {

            // get session
            session = hibernateUtils.openSession();

            // create hql query
            Query<Manager> query = session.createQuery("FROM Manager");

            return query.list();

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public Manager getManagerByAccountID(short id) {

        Session session = null;

        try {

            // get session
            session = hibernateUtils.openSession();

            Manager manager = session.get(Manager.class, id);

            return manager;

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @SuppressWarnings("unchecked")
    public List<Manager> getManagerByManagementNumberOfYear(short numberOfYear) {

        Session session = null;

        try {

            // get session
            session = hibernateUtils.openSession();

            // create HQL query with distinct parameters for first and last names
            Query<Manager> query = session.createQuery("FROM Manager WHERE 'ManagementNumberOfYear' = :year");

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

    public void createManager(Manager manager) {

        Session session = null;

        try {

            // get session
            session = hibernateUtils.openSession();

            // create
            session.save(manager);

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void updateManager1(short id, short numberOfYear) {

        Session session = null;

        try {

            // get session
            session = hibernateUtils.openSession();
            session.beginTransaction();

            Manager manager = (Manager) session.load(Manager.class, id);

            // update
            if (numberOfYear < 0) {
                manager.setManagementNumberOfYear(manager.getManagementNumberOfYear());
            } else {
                manager.setManagementNumberOfYear(numberOfYear);
            }

            session.getTransaction().commit();

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void updateManager2(Manager manager) {
        Session session = null;
        try {

            session = hibernateUtils.openSession();
            session.beginTransaction();

            session.update(manager);
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }


    public void deleteManager(short id) {

        Session session = null;

        try {

            // get session
            session = hibernateUtils.openSession();

            session.beginTransaction();

            Manager manager = (Manager) session.load(Manager.class, id);

            // delete
            session.delete(manager);

            session.getTransaction().commit();

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public boolean isAccountExistsByAccountID(short id) {

        Manager manager = getManagerByAccountID(id);

        // return result
        if (manager == null) {
            return false;
        }

        return true;
    }

    public boolean isAccountExistsByManagementNumberOfYear(short year) {
        if (getManagerByManagementNumberOfYear(year) == null) {
            return false;
        }

        return true;
    }

}
