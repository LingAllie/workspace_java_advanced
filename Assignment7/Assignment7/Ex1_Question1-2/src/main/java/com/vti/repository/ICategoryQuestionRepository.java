package com.vti.repository;

import com.vti.entity.CategoryQuestion;
import com.vti.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryQuestionRepository extends JpaRepository<CategoryQuestion, Integer> {

    public CategoryQuestion findByCategoryName(String name);
    public boolean existsByCategoryName(String name);
}
