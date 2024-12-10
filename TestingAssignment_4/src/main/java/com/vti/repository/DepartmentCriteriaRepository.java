package com.vti.repository;

import com.vti.entity.Department;
import com.vti.entity.DepartmentDTO;
import com.vti.entity.DetailDepartment;
import com.vti.utils.HibernateUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.*;
import java.util.ArrayList;
import java.util.List;

public class DepartmentCriteriaRepository {

    private HibernateUtils instance;

    public DepartmentCriteriaRepository() {
        instance = HibernateUtils.getInstance();
    }

    @SuppressWarnings("unchecked")
    public List<DepartmentDTO> getAllDepartments(String ord, int pageNumber, int pageSize, String name, short point) {

        List<DepartmentDTO> listResult = new ArrayList<>();

        try (Session session = instance.openSession()) {

            Criteria criteria = session.createCriteria(DetailDepartment.class);

            // 1. Fetch the list of DetailDepartment
            List<DetailDepartment> list = criteria.list();
            DepartmentDTO departmentDTO;

            // Convert DetailDepartment to DepartmentDTO
            for (DetailDepartment department : list) {
                departmentDTO = new DepartmentDTO(
                        department.getDepartmentId(),
                        department.getDepartmentName(),
                        department.getAddress().getAddressName()
                );
                listResult.add(departmentDTO);
            }

            // 2. Sort by name if specified
            if (ord != null && (ord.equals("asc") || ord.equals("desc"))) {
                criteria.addOrder(
                        ord.equals("asc")
                                ? Order.asc("departmentName")
                                        : Order.desc("departmentName")
                );

                listResult = new ArrayList<>();
                List<DetailDepartment> sortedList = criteria.list();
                for (DetailDepartment department : sortedList) {
                    departmentDTO = new DepartmentDTO(
                            department.getDepartmentId(),
                            department.getDepartmentName(),
                            department.getAddress().getAddressName()
                    );
                    listResult.add(departmentDTO);
                }

                // 3. Paging
                if (pageNumber >= 0 && pageSize >= 0) {
                    criteria.setFirstResult((pageNumber - 1) * pageSize);
                    criteria.setMaxResults(pageSize);
                    listResult = new ArrayList<>(); // Reset listResult to hold paged results
                    List<DetailDepartment> pagedList = criteria.list();
                    for (DetailDepartment department : pagedList) {
                        departmentDTO = new DepartmentDTO(
                                department.getDepartmentId(),
                                department.getDepartmentName(),
                                department.getAddress().getAddressName()
                        );
                        listResult.add(departmentDTO);
                    }
                }
            } else // 3. Paging
                if (pageNumber >= 0 && pageSize >= 0) {
                    criteria.setFirstResult((pageNumber - 1) * pageSize);
                    criteria.setMaxResults(pageSize);
                    listResult = new ArrayList<>(); // Reset listResult to hold paged results
                    List<DetailDepartment> pagedList = criteria.list();
                    for (DetailDepartment department : pagedList) {
                        departmentDTO = new DepartmentDTO(
                                department.getDepartmentId(),
                                department.getDepartmentName(),
                                department.getAddress().getAddressName()
                        );
                        listResult.add(departmentDTO);
                    }
                }

            // 4. Search by field name if provided
            if (name != null) {
                criteria.add(Restrictions.ilike("departmentName", "%" + name + "%"));
                listResult = new ArrayList<>();
                List<DetailDepartment> nameList = criteria.list();
                for (DetailDepartment department : nameList) {
                    departmentDTO = new DepartmentDTO(
                            department.getDepartmentId(),
                            department.getDepartmentName(),
                            department.getAddress().getAddressName()
                    );
                    listResult.add(departmentDTO);
                }
            }

            // 5. Filter departments with emulation points greater than the specified value
            if (point > 0) {
                criteria.add(Restrictions.gt("emulationPoint", point));
                listResult = new ArrayList<>();
                List<DetailDepartment> pointList = criteria.list();
                for (DetailDepartment department : pointList) {
                    departmentDTO = new DepartmentDTO(
                            department.getDepartmentId(),
                            department.getDepartmentName(),
                            department.getAddress().getAddressName()
                    );
                    listResult.add(departmentDTO);
                }
            }

            return listResult;
        }
    }

    @SuppressWarnings("unchecked")
    public Long getTotalCount(String name, short point) {

        try (Session session = instance.openSession()) {

            Criteria criteria = session.createCriteria(Department.class);

            Criterion nameQuery = Restrictions.ilike("departmentName", "%" + name + "%");
            Criterion pointQuery = Restrictions.gt("emulationPoint", point);

            if (name != null && point > 0) {
                LogicalExpression orExp = Restrictions.or(nameQuery, pointQuery);
                criteria.add(orExp);
            } else if (name != null && point < 0) {
                criteria.add(nameQuery);
            } else if (name == null && point > 0) {
                criteria.add(pointQuery);
            }

            criteria.setProjection(Projections.rowCount());

            return (long) criteria.uniqueResult();
        }
    }

    @SuppressWarnings("unchecked")
    public Department getDepartmentByID(short id) {
        try (Session session = instance.openSession()) {
            Criteria criteria = session.createCriteria(Department.class);
            return (Department) criteria.add(Restrictions.eq("departmentId", id)).uniqueResult();
        }
    }

    @SuppressWarnings("unchecked")
    public List<Department> getDepartmentByName(String name) {
        try (Session session = instance.openSession()) {
            Criteria criteria = session.createCriteria(Department.class);
            return criteria.add(Restrictions.ilike("departmentName", "%" + name + "%")).list();
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

}
