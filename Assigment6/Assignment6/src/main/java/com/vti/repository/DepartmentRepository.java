package com.vti.repository;

import com.vti.entity.Department;
import com.vti.utils.HibernateUtils;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DepartmentRepository implements IDepartmentRepository {

    private final HibernateUtils instance;

    public DepartmentRepository() {
        instance = HibernateUtils.getInstance();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Department> getAllDepartments(String filter, int pageNumber, int pageSize, String sort) {

        List<Department> listResult;

        try (Session session = instance.openSession()) {

            Criteria criteria = session.createCriteria(Department.class);

            // 1. Fetch the list of DetailDepartment
            try {
                listResult = criteria.list();
            } catch (Exception e) {
                listResult = new ArrayList<>();
                System.err.println("Error fetching department list: " + e.getMessage());
            }

            // 2. Sort
            if (sort != null) {
                try {
                    String[] sortParams = sort.split(",");
                    String field = sortParams[0].trim();
                    String order = sortParams[1].trim().toLowerCase();

                    criteria.addOrder(order.equals("asc") ? Order.asc(field) : Order.desc(field));
                    listResult = criteria.list();
                } catch (Exception e) {
                    System.err.println("Error applying sort: " + e.getMessage());
                }
            }

            // 3. Paging
            if (pageNumber > 0 && pageSize > 0) {
                try {
                    criteria.setFirstResult((pageNumber - 1) * pageSize);
                    criteria.setMaxResults(pageSize);
                    listResult = criteria.list();
                } catch (Exception e) {
                    System.err.println("Error applying paging: " + e.getMessage());
                }
            }

            // 4. Filter
            if (filter != null) {
                try {
                    criteria.add(filter.matches("\\d+") ?
                            Restrictions.eq("totalMember", Integer.parseInt(filter))
                            : Restrictions.ilike("name", "%" + filter + "%"));
                    listResult = criteria.list();
                } catch (Exception e) {
                    System.err.println("Error applying filter: " + e.getMessage());
                }
            }

            return listResult;
        }
    }

}
