package com.vti.service;

import com.vti.entity.CategoryQuestion;
import com.vti.entity.Department;
import com.vti.repository.ICategoryQuestionRepository;
import com.vti.repository.IDepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CategoryQuestionService implements ICategoryQuestionService {

    @Autowired
    private ICategoryQuestionRepository repository;

    @Override
    public Page<CategoryQuestion> getAllCategoryQuestions(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public CategoryQuestion getCategoryQuestionByID(short id) {
        return repository.findById((int) id).get();
    }

    @Override
    public CategoryQuestion getCategoryQuestionByName(String name) {
        return repository.findByCategoryName(name);
    }

    @Override
    public void createCategoryQuestion(CategoryQuestion categoryQuestion) {
        repository.save(categoryQuestion);
    }

    @Override
    public void updateCategoryQuestion(short id, String newName) {
        CategoryQuestion updateCategoryQuestion = getCategoryQuestionByID(id);
        updateCategoryQuestion.setCategoryName(newName);
        repository.save(updateCategoryQuestion);
    }

    @Override
    public void updateCategoryQuestion(CategoryQuestion categoryQuestion) {
        repository.save(categoryQuestion);
    }

    @Override
    public void deleteCategoryQuestion(short id) {
        repository.deleteById((int) id);
    }

    @Override
    public boolean isCategoryQuestionExistsByID(short id) {
        return repository.existsById((int) id);
    }

    @Override
    public boolean isCategoryQuestionExistsByName(String name) {
        return repository.existsByCategoryName(name);
    }
}
