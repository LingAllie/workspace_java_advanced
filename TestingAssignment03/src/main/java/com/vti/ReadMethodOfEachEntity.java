package com.vti;

import com.vti.entity.*;
import com.vti.repository.*;

import java.util.List;

/**
 * Hello world!
 *
 */
public class ReadMethodOfEachEntity
{
    public static void main( String[] args )
    {
        AccountRepository accountRepository = new AccountRepository();
        AddressRepository addressRepository = new AddressRepository();
        AnswerRepository answerRepository = new AnswerRepository();
        CategoryQuestionRepository categoryQuestionRepository = new CategoryQuestionRepository();
        DepartmentRepository departmentRepository = new DepartmentRepository();
        DetailDepartmentRepository detailDepartmentRepository = new DetailDepartmentRepository();
        EmployeeRepository employeeRepository = new EmployeeRepository();
        ExamQuestionRepository examQuestionRepository = new ExamQuestionRepository();
        ExamRepository examRepository = new ExamRepository();
        GroupAccountRepository groupAccountRepository = new GroupAccountRepository();
        GroupRepository groupRepository = new GroupRepository();
        ManagerRepository managerRepository = new ManagerRepository();
        PositionRepository positionRepository = new PositionRepository();
        QuestionRepository questionRepository = new QuestionRepository();
        SalaryRepository salaryRepository = new SalaryRepository();
        TypeQuestionRepository typeQuestionRepository = new TypeQuestionRepository();

//        System.out.println("***********GET ALL ACCOUNTS***********");
//
//        List<Account> accounts = accountRepository.getAllAccounts();
//
//        for (Account account : accounts) {
//            System.out.println("Account: " +account.getAccountId() + " - Username: " + account.getUsername());
//            for (GroupAccount groupAccount : account.getGroupAccountList()) {
//                Group group = groupAccount.getGroup();
//                System.out.println("Group: " + group.getGroupId() + " - " + group.getGroupName() + " - " + group.getCreator());
//                System.out.println("Registered at: " + groupAccount.getJoinDate() + "\n");
//            }
//            System.out.println("-----------------\n");
//        }
//
//        System.out.println("***********GET ALL ADDRESSES***********");
//
//        List<Address> addresses = addressRepository.getAllAddresses();
//
//        for (Address address : addresses) {
//            System.out.println("Address " + address.getAddressId() + " - Name: " + address.getAddressName() + "\n");
//            System.out.println("-------------------------");
//        }
//
//        System.out.println("***********GET ALL ANSWERS***********");
//
//        List<Answer> answers = answerRepository.getAllAnswers();
//
//        for (Answer answer : answers) {
//            System.out.println(answer.toString() + "\n");
//        }


//        System.out.println("***********GET ALL CATEGORY QUESTIONS***********");
//
//        List<CategoryQuestion> categoryQuestions = categoryQuestionRepository.getAllCategoryQuestions();
//
//        for (CategoryQuestion categoryQuestion : categoryQuestions) {
//            System.out.println(categoryQuestion + "\n");
//        }

//        System.out.println("***********GET ALL DEPARTMENTS***********");
//
//        List<Department> departments = departmentRepository.getAllDepartments();
//
//        for (Department department : departments) {
//            System.out.println(department + "\n");
//        }

//        System.out.println("***********GET ALL DETAIL DEPARTMENTS***********");
//
//        List<DetailDepartment> detailDepartments = detailDepartmentRepository.getAllDetailDepartments();
//
//        for (DetailDepartment detailDepartment : detailDepartments) {
//            System.out.println(detailDepartment + "\n");
//        }

//        System.out.println("***********GET ALL EMPLOYEES***********");
//
//        List<Employee> employees = employeeRepository.getAllEmployees();
//
//        for (Employee employee : employees) {
//            System.out.println(employee + "\n");
//        }

//        System.out.println("***********GET ALL EXAM QUESTIONS***********");


//        System.out.println("***********GET ALL EXAMS***********");
//
//        List<Exam> exams = examRepository.getAllExams();
//
//        for (Exam exam : exams) {
//            System.out.println(exam + "\n");
//        }

//        System.out.println("***********GET ALL EXAM GROUPS***********");
//
//        List<Group> groups = groupRepository.getAllGroups();
//
//        for (Group group : groups) {
//            System.out.println(group);
//        }

    }
}
