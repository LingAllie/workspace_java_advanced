package com.vti.repository;

import com.vti.entity.DetailDepartment;
import com.vti.utils.HibernateUtils;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

public class DetailDepartmentRepository {

    private HibernateUtils hibernateUtils;

    public DetailDepartmentRepository() {
        hibernateUtils = HibernateUtils.getInstance();
    }

    public void createDetailDepartment(short departmentId, short addressId, short point) {
        try (Session session = hibernateUtils.openSession()) {
            session.beginTransaction();
            DepartmentRepository departmentRepository = new DepartmentRepository();
            AddressRepository addressRepository = new AddressRepository();
            session.save(new DetailDepartment(point, departmentRepository.getDepartmentById(departmentId), addressRepository.getAddressById(addressId)));
            session.getTransaction().commit();
            System.out.println("Detail department created successfully");
        }
    }

    @SuppressWarnings("unchecked")
    public List<DetailDepartment> getAllDetailDepartment() {
        try (Session session = hibernateUtils.openSession()) {
            return session.createQuery("FROM DetailDepartment").list();
        }
    }

    public List<DetailDepartment> getDetailDepartmentByEmulationPoint(short point) {
        try (Session session = hibernateUtils.openSession()) {
            return session.createQuery("FROM DetailDepartment WHERE emulationPoint = :point", DetailDepartment.class)
                    .setParameter("point", point)
                    .list();
        }
    }

    public DetailDepartment getDetailDepartmentByDepartmentId(short id) {
        try (Session session = hibernateUtils.openSession()) {
            return session.createQuery("FROM DetailDepartment WHERE department.departmentId = :id", DetailDepartment.class)
                    .setParameter("id", id)
                    .uniqueResult();
        }
    }

    public List<DetailDepartment> getDetailDepartmentByAddressId(short id) {
        try (Session session = hibernateUtils.openSession()) {
            return session.createQuery("FROM DetailDepartment WHERE address.addressId = :id", DetailDepartment.class)
                    .setParameter("id", id)
                    .list();
        }
    }

    public void updateEmulationPointByDepartmentId(short departmentId, short point) {
        try (Session session = hibernateUtils.openSession()) {
            session.beginTransaction();
            DetailDepartment fetchDetailDepartment = getDetailDepartmentByDepartmentId(departmentId);
            fetchDetailDepartment.setEmulationPoint(point);
            session.update(fetchDetailDepartment);
            session.getTransaction().commit();
            System.out.println("Detail department updated successfully");
        }
    }

    public void deleteDetailDepartmentByDepartmentId(short departmentId) {
        try (Session session = hibernateUtils.openSession()) {
            session.beginTransaction();
            session.delete(getDetailDepartmentByDepartmentId(departmentId));
            session.getTransaction().commit();
            System.out.println("Detail department deleted successfully");
        }
    }

}
