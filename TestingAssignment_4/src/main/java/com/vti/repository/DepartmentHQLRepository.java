package com.vti.repository;

import com.vti.entity.Address;
import com.vti.entity.Department;
import com.vti.entity.DepartmentDTO;
import com.vti.entity.DetailDepartment;
import com.vti.utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class DepartmentHQLRepository {

    private HibernateUtils instance;

    public DepartmentHQLRepository() {
        instance = HibernateUtils.getInstance();
    }

    public void createDepartment(Department department) {

        Session session = null;

        try {

            // get session
            session = instance.openSession();
            session.beginTransaction();

            // create
            session.save(department);
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
        }
    }

    @SuppressWarnings("unchecked")
    public List<DepartmentDTO> getAllDepartments(String ord, int pageNumber, int pageSize, String name, int point) {
        try (Session session = instance.openSession()) {
            session.beginTransaction();

            String hql_1 = "SELECT new com.vti.entity.DepartmentDTO(d.departmentId, d.departmentName, a.addressName) " +
                    "FROM DetailDepartment de " +
                    "LEFT JOIN Department d ON de.departmentId = d.departmentId " +
                    "LEFT JOIN Address a ON de.address.addressId = a.addressId ";

            String hql_2 = "ORDER BY d.departmentName " + ord;

            // 1: Return object DepartmentDTO with just 3 field: id, name, address of that department
            Query<DepartmentDTO> query = session.createQuery(hql_1, DepartmentDTO.class);

            // 2. Sort by name
            if (ord != null) {
                query = session.createQuery((hql_1 + hql_2), DepartmentDTO.class);
            }

            // 3. Paging
            if (pageNumber >= 0 && pageSize >= 0) {
                query = session.createQuery((ord != null ? (hql_1 + hql_2) : hql_1), DepartmentDTO.class);

                query.setFirstResult((pageNumber - 1) * pageSize);
                query.setMaxResults(pageSize);
            }

            // 4. Search by field name
            if (name != null) {
                query = session.createQuery(hql_1 + "WHERE d.departmentName LIKE :name", DepartmentDTO.class)
                        .setParameter("name", "%" + name + "%");
            }

            // 5. Filter department has emulation point greater than given point
            if (point > 0) {
                query = session.createQuery(hql_1 + "WHERE de.emulationPoint > :point", DepartmentDTO.class)
                        .setParameter("point", (short) point);
            }

            return query.list();
        }
    }

    @SuppressWarnings("unchecked")
    public Long getTotalCount(String name, int point) {

        try (Session session = instance.openSession()) {

            String hql = "SELECT COUNT(1) FROM Department ";

            Query<Long> query = session.createQuery(hql, Long.class);

            if (name != null && point > 0) {
                query = session.createQuery(hql +
                                "d LEFT JOIN DetailDepartment de " +
                                "ON d.departmentId = de.departmentId " +
                                "WHERE d.departmentName LIKE :name " +
                                "OR de.emulationPoint > :point ", Long.class)
                        .setParameter("name", "%" + name + "%")
                        .setParameter("point", (short) point);
            } else if (name != null && point < 0) {
                query = session.createQuery(hql + "WHERE departmentName LIKE :name", Long.class).setParameter("name", "%" + name + "%");
            } else if (name == null && point > 0) {
                query = session.createQuery(hql +
                        "d LEFT JOIN DetailDepartment de " +
                        "ON d.departmentId = de.departmentId " +
                        "WHERE de.emulationPoint > :point ", Long.class)
                        .setParameter("point", (short) point);
            }

            // get result
            Long count = query.uniqueResult();

            return count;

        }
    }

    @SuppressWarnings("unchecked")
    public Department getDepartmentByID(short id) {
        try (Session session = instance.openSession()) {
            session.beginTransaction();
            Department department = session.createQuery("FROM Department WHERE departmentId = :id", Department.class)
                    .setParameter("id", id).uniqueResult();
            session.getTransaction().commit();
            return department;
        }
    }

    @SuppressWarnings("unchecked")
    public List<Department> getDepartmentByName(String name) {
        try (Session session = instance.openSession()) {
            return session.createQuery("FROM Department WHERE departmentName LIKE :name", Department.class)
                    .setParameter("name", "%" + name + "%").list();
        }
    }

    public boolean isDepartmentExistById(short id) {
        try (Session session = instance.openSession()) {
            return getDepartmentByID(id) != null;
        }
    }

    public boolean isDepartmentExistByName(String name) {
        try (Session session = instance.openSession()) {
            return getDepartmentByName(name) != null;
        }
    }

    public void updateDepartment(short departmentId, String departmentName, short addressId, String addressName, short point) {
        Transaction transaction = null;
        try (Session session = instance.openSession()) {
            transaction = session.beginTransaction();

            String hql = "UPDATE DetailDepartment " +
                    "SET departmentName = :d_name, " +
                    "address = :address, " +
                    "emulationPoint = :emulationPoint " +
                    "WHERE department.departmentId = :departmentId";

            DetailDepartment existingDetail = getDepartmentByID(departmentId).getDetailDepartment();
            if (addressName == null) {
                addressName = existingDetail.getAddress().getAddressName();
            }
            if (point < 0) {
                point = existingDetail.getEmulationPoint();
            }
            if (departmentName == null) {
                departmentName = existingDetail.getDepartment().getDepartmentName();
            }

            Query query = session.createQuery(hql);
            query.setParameter("d_name", departmentName);
            query.setParameter("address", new Address(addressId, addressName));
            query.setParameter("emulationPoint", point);
            query.setParameter("departmentId", departmentId);
            int result = query.executeUpdate();

            if (result > 0) {
                transaction.commit();
                System.out.println("Department/Address has been updated");
            }

        } catch (Exception e) {
            if (transaction != null) {
                System.out.println("Department/Address can not be updated");
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }


    public void deleteDepartment(short departmentId) {
        Transaction transaction = null;
        try (Session session = instance.openSession()) {
            transaction = session.beginTransaction();

            String hql = "DELETE FROM DetailDepartment WHERE departmentId = :departmentId";
            Query query = session.createQuery(hql);
            query.setParameter("departmentId", departmentId);
            int result = query.executeUpdate();
            if (result > 0) {
                transaction.commit();
                System.out.println("Department has been deleted");
            }
        } catch (Exception e) {
            if (transaction != null) {
                System.out.println("Department/Address can not be deleted");
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
