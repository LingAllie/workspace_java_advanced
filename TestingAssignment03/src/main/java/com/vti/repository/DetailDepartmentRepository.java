package com.vti.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.vti.entity.DetailDepartment;
import com.vti.utils.HibernateUtils;

public class DetailDepartmentRepository {

    private HibernateUtils hibernateUtils;

    public DetailDepartmentRepository() {
        hibernateUtils = HibernateUtils.getInstance();
    }

    @SuppressWarnings("unchecked")
    public List<DetailDepartment> getAllDetailDepartments() {
        Session session = null;
        try {
            session = hibernateUtils.openSession();
            Query<DetailDepartment> query = session.createQuery("FROM DetailDepartment");
            return query.list();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public DetailDepartment getDetailDepartmentByID(short departmentId) {
        Session session = null;
        try {
            session = hibernateUtils.openSession();
            return session.get(DetailDepartment.class, departmentId);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @SuppressWarnings("unchecked")
    public List<DetailDepartment> getDetailDepartmentByEmulationPoint(short point) {
        Session session = null;
        try {
            session = hibernateUtils.openSession();
            Query<DetailDepartment> query = session.createQuery("FROM DetailDepartment WHERE 'EmulationPoint' = :nameParameter"); // Corrected query
            query.setParameter("nameParameter", point);
            return query.list();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void createDetailDepartment(DetailDepartment detailDepartment) {
        Session session = null;
        try {
            session = hibernateUtils.openSession();
            session.beginTransaction(); // Start transaction
            session.save(detailDepartment);
            session.getTransaction().commit(); // Commit transaction
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void updateDetailDepartment(short id, short emulationPoint) {
        Session session = null;
        try {
            session = hibernateUtils.openSession();
            session.beginTransaction();
            DetailDepartment detailDepartment = session.get(DetailDepartment.class, id);
            if (detailDepartment != null) {
                detailDepartment.setEmulationPoint(emulationPoint);
                session.getTransaction().commit();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void updateDetailDepartment(DetailDepartment detailDepartment) {
        Session session = null;
        try {
            session = hibernateUtils.openSession();
            session.beginTransaction();
            session.update(detailDepartment);
            session.getTransaction().commit();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void deleteDetailDepartment(short id) {
        Session session = null;
        try {
            session = hibernateUtils.openSession();
            session.beginTransaction();
            DetailDepartment detailDepartment = session.get(DetailDepartment.class, id);
            if (detailDepartment != null) {
                session.delete(detailDepartment);
                session.getTransaction().commit();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public boolean isDetailDepartmentExistsByID(short id) {
        return getDetailDepartmentByID(id) != null; // Simplified
    }
}
