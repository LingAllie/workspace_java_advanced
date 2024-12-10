package com.vti.service;

import com.vti.entity.CategoryQuestion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICategoryQuestionService {

    public Page<CategoryQuestion> getAllCategoryQuestions(Pageable pageable);
    public CategoryQuestion getCategoryQuestionByID(short id);
    public CategoryQuestion getCategoryQuestionByName(String name);
    public void createCategoryQuestion(CategoryQuestion categoryQuestion);
    public void updateCategoryQuestion(short id, String newName);
    public void updateCategoryQuestion(CategoryQuestion categoryQuestion);
    public void deleteCategoryQuestion(short id);
    public boolean isCategoryQuestionExistsByID(short id);
    public boolean isCategoryQuestionExistsByName(String name);
}
