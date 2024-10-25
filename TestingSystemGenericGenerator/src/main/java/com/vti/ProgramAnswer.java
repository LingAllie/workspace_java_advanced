package com.vti;

import java.util.List;

import com.vti.entity.Answer;
import com.vti.repository.AnswerRepository;

public class ProgramAnswer {
	public static void main(String[] args) {
		AnswerRepository repository = new AnswerRepository();

		System.out.println("***********GET ALL ANSWERS***********");

		List<Answer> answers = repository.getAllAnswers();

		for (Answer answer: answers) {
			System.out.println(answer);
		}

//		System.out.println("\n\n***********GET ANSWER BY ID***********");
//
//		Answer answerById = repository.getAnswerByID((short) 3);
//		System.out.println(answerById);

//		System.out.println("\n\n***********GET ANSWER BY CONTENT***********");
//
//		List<Answer> answerByContents = repository.getAnswerByContent("11");
//		for (Answer answer: answerByContents) {
//			System.out.println(answer);
//		}

//		System.out.println("\n\n***********CREATE ANSWER***********");
//
//		Answer answerCreate = new Answer();
//		answerCreate.setContent("Answer 11");
//		repository.createAnswer(answerCreate);

//		System.out.println("\n\n***********UPDATE CONTENT***********");
//
//		repository.updateAnswer((short) 4, "Answer of question 4", false);
//		repository.updateAnswer((short) 4, "", true);

//		System.out.println("\n\n***********UPDATE ANSWER 2***********");
//
//		Answer answerUpdate = new Answer();
//		answerUpdate.setAnswerId((short) 4);
//		answerUpdate.setContent("Trả lời 04");
//		answerUpdate.setCorrect(true);
//		repository.updateAnswer(answerUpdate);

//		System.out.println("\n\n***********DELETE ANSWER***********");
//		repository.deleteAnswer((short) 11);

//		System.out.println("***********CHECK ANSWER EXISTS BY ID***********");
//		System.out.println(repository.isAnswerExistsByID((short) 1));

//		System.out.println("***********CHECK ANSWER EXISTS BY CONTENT***********");
//		System.out.println(repository.isAnswerExistsByContent("11"));

	}
}
