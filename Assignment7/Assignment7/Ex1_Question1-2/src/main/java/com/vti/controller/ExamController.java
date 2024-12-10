package com.vti.controller;

import com.vti.entity.Account;
import com.vti.entity.CategoryQuestion;
import com.vti.entity.Department;
import com.vti.entity.Exam;
import com.vti.service.IAccountService;
import com.vti.service.ICategoryQuestionService;
import com.vti.service.IDepartmentService;
import com.vti.service.IExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/exams")
public class ExamController {

    @Autowired
    private IExamService service;

    @Autowired
    private IAccountService accountService;

    @Autowired
    private ICategoryQuestionService categoryQuestionService;



    @GetMapping
    public Page<Exam> getAllExams(Pageable pageable) {
        return service.getAllExams(pageable);
    }

    @GetMapping("/{id}")
    public Exam getExamById(@PathVariable(name = "id") short id) {
        return service.getExamByID(id);
    }

    @GetMapping("/code/{code}")
    public Exam getExamByCode(@PathVariable(name = "code") String code) {
        return service.getExamByCode(code);
    }

    @PostMapping("/create")
    public void createExam(@RequestBody Exam exam) {
        Account account = accountService.getAccountByID(exam.getCreator().getAccountId());
        CategoryQuestion categoryQuestion = categoryQuestionService.getCategoryQuestionByID(exam.getCategory().getCategoryId());
        service.createExam(new Exam(exam.getTitle(), categoryQuestion, exam.getDuration(), account));
    }

    @PutMapping("/updateTitle/{id}")
    public void updateExamTitle(@PathVariable(name = "id") short id, @RequestBody String newTitle) {
        service.updateExamTitle(id, newTitle);
    }

    @PutMapping("/updateCategory/{id}/{newCategoryId}")
    public void updateExamCategory(@PathVariable(name = "id") short id, @PathVariable(name = "newCategoryId") short newCategoryId) {
        service.updateExamCategory(id, newCategoryId);
    }

    @PutMapping("/updateTitle/{id}/{newDuration}")
    public void updateExamDuration(@PathVariable(name = "id") short id, @PathVariable(name = "newDuration") short newDuration) {
        service.updateExamDuration(id, newDuration);
    }

    @PutMapping("/update2")
    public void updateExam(@RequestBody Exam exam) {
        service.updateExam(exam);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteExam(@PathVariable(name = "id") short id) {
        service.deleteExam(id);
    }

    @GetMapping("/checkIdExist/{id}")
    public boolean isExamExistsByID(@PathVariable(name = "id") short id) {
        return service.isExamExistsByID(id);
    }

    @GetMapping("/checkCodeExist/{code}")
    public boolean isExamExistsByCode(@PathVariable(name = "code") String code) {
        return service.isExamExistsByCode(code);
    }
}
