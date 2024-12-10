package com.vti.service;

import com.vti.entity.CategoryQuestion;
import com.vti.entity.Department;
import com.vti.entity.Exam;
import com.vti.repository.ICategoryQuestionRepository;
import com.vti.repository.IDepartmentRepository;
import com.vti.repository.IExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ExamService implements IExamService {

    @Autowired
    private IExamRepository repository;

    @Autowired
    private ICategoryQuestionRepository categoryQuestionRepository;



    @Override
    public Page<Exam> getAllExams(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Exam getExamByID(short id) {
        return repository.findById((int) id).get();
    }

    @Override
    public Exam getExamByCode(String code) {
        return repository.findByCode(code);
    }

    @Override
    public void createExam(Exam exam) {
        repository.save(exam);
    }

    @Override
    public void updateExamTitle(short id, String newTitle) {
        Exam updateExam = getExamByID(id);
        updateExam.setTitle(newTitle);
        repository.save(updateExam);
    }

    @Override
    public void updateExamCategory(short id, short newCategoryId) {
        Exam updateExam = getExamByID(id);
        CategoryQuestion categoryQuestion = categoryQuestionRepository.findById((int) newCategoryId).get();
        updateExam.setCategory(categoryQuestion);
        repository.save(updateExam);
    }

    @Override
    public void updateExamDuration(short id, short newDuration) {
        Exam updateExam = getExamByID(id);
        updateExam.setDuration(newDuration);
        repository.save(updateExam);
    }

    @Override
    public void updateExam(Exam exam) {
        repository.save(exam);
    }

    @Override
    public void deleteExam(short id) {
        repository.deleteById((int) id);
    }

    @Override
    public boolean isExamExistsByID(short id) {
        return repository.existsById((int) id);
    }

    @Override
    public boolean isExamExistsByCode(String code) {
        return repository.existsByCode(code);
    }

    @Override
    public int countByCode(String code) {
        return repository.countByCode(code);
    }


}
