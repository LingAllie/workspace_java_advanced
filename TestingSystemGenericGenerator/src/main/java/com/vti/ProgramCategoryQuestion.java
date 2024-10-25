package com.vti;

import java.util.List;

import com.vti.entity.CategoryQuestion;
import com.vti.repository.CategoryQuestionRepository;

public class ProgramCategoryQuestion {
	public static void main(String[] args) {
		CategoryQuestionRepository repository = new CategoryQuestionRepository();

		System.out.println("***********GET ALL CATEGORY QUESTIONS***********");

		List<CategoryQuestion> categoryQuestions = repository.getAllCategoryQuestions();

		for (CategoryQuestion categoryQuestion : categoryQuestions) {
			System.out.println(categoryQuestion);
		}

//		System.out.println("\n\n***********GET CATEGORY QUESTION BY ID***********");
//
//		CategoryQuestion categoryQuestionById = repository.getCategoryQuestionByID((short) 3);
//		System.out.println(categoryQuestionById);

//		System.out.println("\n\n***********GET CATEGORY QUESTION BY NAME***********");
//
//		CategoryQuestion categoryQuestionByName = repository.getCategoryQuestionByName("ADO.NET");
//		System.out.println(categoryQuestionByName);

//		System.out.println("\n\n***********CREATE CATEGORY QUESTION***********");
//
//		CategoryQuestion categoryQuestionCreate = new CategoryQuestion();
//		categoryQuestionCreate.setCategoryName("Java");
//		repository.createCategoryQuestion(categoryQuestionCreate);

//		System.out.println("\n\n***********UPDATE CATEGORY QUESTION 1***********");
//
//		repository.updateCategoryQuestion((short) 1, "Ruby");

//		System.out.println("\n\n***********UPDATE CATEGORY QUESTION 2***********");
//
//		CategoryQuestion categoryQuestionUpdate = new CategoryQuestion();
//		categoryQuestionUpdate.setCategoryId((short) 1);
//		categoryQuestionUpdate.setCategoryName("Java");
//		repository.updateCategoryQuestion(categoryQuestionUpdate);

//		System.out.println("\n\n***********DELETE CATEGORY QUESTION***********");
//		repository.deleteCategoryQuestion((short) 3);

//		System.out.println("***********CHECK CATEGORY QUESTION EXISTS BY ID***********");
//		System.out.println(repository.isCategoryQuestionExistsByID((short) 3));

//		System.out.println("***********CHECK CATEGORY QUESTION EXISTS BY NAME***********");
//		System.out.println(repository.isCategoryQuestionExistsByName("SQL"));

	}
}
