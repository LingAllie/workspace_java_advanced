package com.vti;

import java.util.List;

import com.vti.entity.Question;
import com.vti.repository.QuestionRepository;

public class ProgramQuestion {
	public static void main(String[] args) {
		QuestionRepository repository = new QuestionRepository();

		System.out.println("***********GET ALL QUESTIONS***********");

		List<Question> questions = repository.getAllQuestions();

		for (Question question : questions) {
			System.out.println(question);
		}

//		System.out.println("\n\n***********GET QUESTION BY ID***********");
//
//		Question questionById = repository.getQuestionByID((short) 3);
//		System.out.println(questionById);

//		System.out.println("\n\n***********GET QUESTION BY CONTENT***********");
//
//		List<Question> questionByContents = repository.getQuestionByContent(".net");
//		for (Question question : questionByContents) {
//			System.out.println(question);
//		}

//		System.out.println("\n\n***********CREATE QUESTION***********");
//
//		Question questionCreate = new Question();
//		questionCreate.setContent("Câu hỏi về Java"); //question has existed
//		repository.createQuestion(questionCreate);

//		System.out.println("\n\n***********UPDATE QUESTION 1***********");
//
//		repository.updateQuestion((short) 4, "What is Ruby ?");

//		System.out.println("\n\n***********UPDATE QUESTION 2***********");
//
//		Question questionUpdate = new Question();
//		questionUpdate.setQuestionId((short) 4);
//		questionUpdate.setContent("Hỏi về Ruby");
//		repository.updateQuestion(questionUpdate);

//		System.out.println("\n\n***********DELETE QUESTION***********");
//		repository.deleteQuestion((short) 11);

//		System.out.println("***********CHECK QUESTION EXISTS BY ID***********");
//		System.out.println(repository.isQuestionExistsByID((short) 1));

//		System.out.println("***********CHECK QUESTION EXISTS BY CONTENT***********");
//		System.out.println(repository.isQuestionExistsByContent("Hibernate"));

	}
}
