package com.vti.specification.department;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.persistence.criteria.Subquery;

import java.util.Date;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import com.vti.entity.Department;
import com.vti.form.DepartmentFilterForm;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

public class DepartmentSpecification {

	@SuppressWarnings("deprecation")
	public static Specification<Department> buildWhere(String search, DepartmentFilterForm filterForm) {
		
		Specification<Department> where = null;
		
		if (!StringUtils.isEmpty(search)) {
			search = search.trim();
			CustomSpecification departmentName = new CustomSpecification("departmentName", search);
			where = Specification.where(departmentName);
		}
		
		// if there is filter by min id
		if (filterForm != null && filterForm.getMinId() != null) {
			CustomSpecification minId = new CustomSpecification("minId", filterForm.getMinId());
			if (where == null) {
				where = minId;
			} else {
				where = where.and(minId);
			}
		}
				
		// if there is filter by max id
		if (filterForm != null && filterForm.getMaxId() != null) {
			CustomSpecification maxId = new CustomSpecification("maxId", filterForm.getMaxId());
			if (where == null) {
				where = maxId;
			} else {
				where = where.and(maxId);
			}
		}
		
		// if there is filter by min total member
		if (filterForm != null && filterForm.getMinTotalMember() != null) {
			CustomSpecification minTotalMember = new CustomSpecification("minTotalMember", filterForm.getMinTotalMember());
			if (where == null) {
				where = minTotalMember;
			} else {
				where = where.and(minTotalMember);
			}
		}
						
		// if there is filter by max total member
		if (filterForm != null && filterForm.getMaxTotalMember() != null) {
			CustomSpecification maxTotalMember = new CustomSpecification("maxTotalMember", filterForm.getMaxTotalMember());
			if (where == null) {
				where = maxTotalMember;
			} else {
				where = where.and(maxTotalMember);
			}
		}

						
		// if there is filter by min created date
		if (filterForm != null && filterForm.getMinCreatedDate() != null) {
			CustomSpecification minCreatedDate = new CustomSpecification("minCreatedDate", filterForm.getMinCreatedDate());
			if (where == null) {
				where = minCreatedDate;
			} else {
				where = where.and(minCreatedDate);
			}
		}		
						
		// if there is filter by max created date
		if (filterForm != null && filterForm.getMaxCreatedDate() != null) {
			CustomSpecification maxCreatedDate = new CustomSpecification("maxCreatedDate", filterForm.getMaxCreatedDate());
			if (where == null) {
				where = maxCreatedDate;
			} else {
				where = where.and(maxCreatedDate);
			}
		}
						
		// if there is filter by min year
		if (filterForm != null && filterForm.getMinYear() != null) {
			CustomSpecification minYear = new CustomSpecification("minYear", filterForm.getMinYear());
			if (where == null) {
				where = minYear;
			} else {
				where = where.and(minYear);
			}
		}
				
		// if there is filter by max year
		if (filterForm != null && filterForm.getMaxYear() != null) {
			CustomSpecification maxYear = new CustomSpecification("maxYear", filterForm.getMaxYear());
			if (where == null) {
				where = maxYear;
			} else {
				where = where.and(maxYear);
			}
		}
		
		// if there is filter by type
		if (filterForm != null && filterForm.getType() != null) {
			CustomSpecification type = new CustomSpecification("type", filterForm.getType());
			if (where == null) {
				where = type;
			} else {
				where = where.and(type);
			}
		}
		
		// if there is filter by min account quantity
		if (filterForm != null && filterForm.getMinAccountQuantity() != null) {
		CustomSpecification minQuantity = new CustomSpecification("minQuantity", filterForm.getMinAccountQuantity());
			if (where == null) {
				where = minQuantity;
			} else {
				where = where.and(minQuantity);
			}
		}
						
		// if there is filter by max account quantity
		if (filterForm != null && filterForm.getMaxAccountQuantity() != null) {
			CustomSpecification maxQuantity = new CustomSpecification("maxQuantity", filterForm.getMaxAccountQuantity());
			if (where == null) {
				where = maxQuantity;
			} else {
				where = where.and(maxQuantity);
			}
		}
		
		return where;
	}
}

@SuppressWarnings("serial")
@RequiredArgsConstructor
class CustomSpecification implements Specification<Department> {

	@NonNull
	private String field;
	@NonNull
	private Object value;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public Predicate toPredicate(
			Root<Department> root, 
			CriteriaQuery<?> query, 
			CriteriaBuilder criteriaBuilder) {

		if (field.equalsIgnoreCase("departmentName")) {
			return criteriaBuilder.like(root.get("name"), "%" + value.toString() + "%");
		}
		
		if (field.equalsIgnoreCase("minId")) {
			return criteriaBuilder.greaterThanOrEqualTo(root.get("id"), value.toString());
		}
		
		if (field.equalsIgnoreCase("maxId")) {
			return criteriaBuilder.lessThanOrEqualTo(root.get("id"), value.toString());
		}
		
		if (field.equalsIgnoreCase("minTotalMember")) {
			return criteriaBuilder.greaterThanOrEqualTo(root.get("totalMember"), value.toString());
		}
		
		if (field.equalsIgnoreCase("maxTotalMember")) {
			return criteriaBuilder.lessThanOrEqualTo(root.get("totalMember"), value.toString());
		}
	
		if (field.equalsIgnoreCase("minCreatedDate")) {
			return criteriaBuilder.greaterThanOrEqualTo(
					root.get("createdDate").as(java.sql.Date.class),
					(Date) value);
		}
	
		if (field.equalsIgnoreCase("maxCreatedDate")) {
			return criteriaBuilder.lessThanOrEqualTo(
					root.get("createdDate").as(java.sql.Date.class),
					(Date) value);
		}
		
		if (field.equalsIgnoreCase("minYear")) {
			return criteriaBuilder.greaterThanOrEqualTo(
					criteriaBuilder.function("YEAR", Integer.class, root.get("createdDate")),
					(Integer) value);
		}
		
		if (field.equalsIgnoreCase("maxYear")) {
			return criteriaBuilder.lessThanOrEqualTo(
					criteriaBuilder.function("YEAR", Integer.class, root.get("createdDate")),
					(Integer) value);
		}
		
		if (field.equalsIgnoreCase("type")) {
			return criteriaBuilder.equal(root.get("type"), value);
		}
		
		if (field.equalsIgnoreCase("minQuantity")) {
		    Join join = root.join("accounts", JoinType.LEFT);
		    // Create subquery for counting
		    Subquery<Long> subquery = query.subquery(Long.class);
		    Root<Department> subRoot = subquery.from(Department.class);
		    Join subJoin = subRoot.join("accounts", JoinType.LEFT);
		    subquery.select(criteriaBuilder.count(subJoin))
		            .where(criteriaBuilder.equal(subRoot.get("id"), root.get("id")));
		    return criteriaBuilder.greaterThanOrEqualTo(subquery, (Long) value);
		}

		if (field.equalsIgnoreCase("maxQuantity")) {
		    Join join = root.join("accounts", JoinType.LEFT);
		    // Create subquery for counting
		    Subquery<Long> subquery = query.subquery(Long.class);
		    Root<Department> subRoot = subquery.from(Department.class);
		    Join subJoin = subRoot.join("accounts", JoinType.LEFT);
		    subquery.select(criteriaBuilder.count(subJoin))
		            .where(criteriaBuilder.equal(subRoot.get("id"), root.get("id")));
		    return criteriaBuilder.lessThanOrEqualTo(subquery, (Long) value);
		}


		
		return null;
	}
}

