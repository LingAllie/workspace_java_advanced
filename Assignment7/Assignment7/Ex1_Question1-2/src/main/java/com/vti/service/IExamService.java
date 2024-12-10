package com.vti.service;

import com.vti.entity.CategoryQuestion;
import com.vti.entity.Exam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IExamService {

    public Page<Exam> getAllExams(Pageable pageable);
    public Exam getExamByID(short id);
    public Exam getExamByCode(String code);
    public void createExam(Exam exam);
    public void updateExamTitle(short id, String newTitle);
    public void updateExamCategory(short id, short newCategoryQuestion);
    public void updateExamDuration(short id, short newDuration);
    public void updateExam(Exam exam);
    public void deleteExam(short id);
    public boolean isExamExistsByID(short id);
    public boolean isExamExistsByCode(String code);
    public int countByCode(String code);
}
