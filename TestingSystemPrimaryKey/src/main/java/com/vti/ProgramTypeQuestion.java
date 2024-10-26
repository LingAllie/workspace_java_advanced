package com.vti;

import java.util.List;

import com.vti.entity.TypeQuestion;
import com.vti.repository.TypeQuestionRepository;

public class ProgramTypeQuestion {
	public static void main(String[] args) {
		TypeQuestionRepository repository = new TypeQuestionRepository();

		System.out.println("***********GET ALL TYPE QUESTIONS***********");

		List<TypeQuestion> typeQuestions = repository.getAllTypeQuestions();

		for (TypeQuestion typeQuestion : typeQuestions) {
			System.out.println(typeQuestion);
		}

//		System.out.println("\n\n***********GET TYPE QUESTION BY ID***********");
//
//		TypeQuestion typeQuestionById = repository.getTypeQuestionByID((short) 2);
//		System.out.println(typeQuestionById);

//		System.out.println("\n\n***********GET TYPE QUESTION BY NAME***********");
//
//		TypeQuestion typeQuestionByName = repository.getTypeQuestionByName(true);
//		System.out.println(typeQuestionByName);

//		System.out.println("\n\n***********CREATE TYPE QUESTION***********");
//
//		TypeQuestion typeQuestionCreate = new TypeQuestion();
//		typeQuestionCreate.setTypeName(TypeQuestion.TypeName.MULTIPLECHOICE);
//		repository.createTypeQuestion(typeQuestionCreate);

//		System.out.println("\n\n***********UPDATE TYPE QUESTION 1***********");
//
//		repository.updateTypeQuestion((short) 1, true);

//		System.out.println("\n\n***********UPDATE TYPE QUESTION 2***********");
//
//		TypeQuestion typeQuestionUpdate = new TypeQuestion();
//		typeQuestionUpdate.setTypeId((short) 11);
//		typeQuestionUpdate.setTypeName(false);
//		repository.updateTypeQuestion(typeQuestionUpdate);

//		System.out.println("\n\n***********DELETE TYPE QUESTION***********");
//		repository.deleteTypeQuestion((short) 2);

//		System.out.println("***********CHECK TYPE QUESTION EXISTS BY ID***********");
//		System.out.println(repository.isTypeQuestionExistsByID((short) 3));

//		System.out.println("***********CHECK TYPE QUESTION EXISTS BY NAME***********");
//		System.out.println(repository.isTypeQuestionExistsByName(false));

	}
}
