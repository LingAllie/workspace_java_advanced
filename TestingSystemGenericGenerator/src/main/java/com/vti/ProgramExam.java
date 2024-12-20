package com.vti;

import java.util.List;

import com.vti.entity.Department;
import com.vti.entity.Exam;
import com.vti.repository.DepartmentRepository;
import com.vti.repository.ExamRepository;

public class ProgramExam {
	public static void main(String[] args) {
		ExamRepository repository = new ExamRepository();

//		System.out.println("***********GET ALL EXAMS***********");
//
//		List<Exam> exams = repository.getAllExams();
//
//		for (Exam exam : exams) {
//			System.out.println(exam);
//		}

//		System.out.println("\n\n***********GET EXAM BY ID***********");
//
//		Exam examById = repository.getExamByID((short) 3);
//		System.out.println(examById);

//		System.out.println("\n\n***********GET EXAM BY TITLE***********");
//
//		Exam examByName = repository.getExamByName("SQL");
//		System.out.println(examByName);

//		System.out.println("\n\n***********CREATE EXAM***********");

		Exam examCreate = new Exam();
		examCreate.setExamTitle("C##C");
		examCreate.setDuration((short) 160);
			repository.createExam(examCreate);

//		System.out.println("\n\n***********UPDATE EXAM 1***********");
//
//		repository.updateExam((short) 4, "C++", (short) 45);

//		System.out.println("\n\n***********UPDATE EXAM 2***********");
//
//		Exam examUpdate = new Exam();
//		examUpdate.setExamId((short) 2);
//		examUpdate.setExamTitle("C#");
//		repository.updateExam(examUpdate);

//		System.out.println("\n\n***********DELETE EXAM***********");
//		repository.deleteExam((short) 11);

//		System.out.println("***********CHECK EXAM EXISTS BY ID***********");
//		System.out.println(repository.isExamExistsByID((short) 1));

//		System.out.println("***********CHECK EXAM EXISTS BY TITLE***********");
//		System.out.println(repository.isExamExistsByTitle("Java"));

	}
}
