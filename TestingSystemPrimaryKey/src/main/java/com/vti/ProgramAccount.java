package com.vti;

import java.util.List;

import com.vti.entity.Account;
import com.vti.repository.AccountRepository;

public class ProgramAccount {
	public static void main(String[] args) {
		AccountRepository repository = new AccountRepository();

		System.out.println("***********GET ALL ACCOUNTS***********");

		List<Account> accounts = repository.getAllAccounts();

		for (Account account : accounts) {
			System.out.println(account);
		}

//		System.out.println("\n\n***********GET ACCOUNT BY ID***********");
//
//		Account accountById = repository.getAccountByID((short) 3);
//		System.out.println(accountById);

//		System.out.println("\n\n***********GET ACCOUNT BY NAME***********");
//
//		Account accountByName = repository.getAccountByName("Nguyen Van Anh");
//		System.out.println(accountByName);

//		System.out.println("\n\n***********CREATE ACCOUNT***********");
//
//		Account accountCreate = new Account();
//		accountCreate.setEmail("allie@gmail.com");
//		accountCreate.setUsername("Allie");
//		accountCreate.setFirstName("Allie");
//		accountCreate.setLastName("Rin");
//		repository.createAccount(accountCreate);
		
//		System.out.println("\n\n***********UPDATE ACCOUNT 1***********");
//
//		repository.updateAccount1((short) 3, "Khiem", "");
//		repository.updateAccount1((short) 4, "", "Le Nguyen");
//		repository.updateAccount1((short) 3, "Khiem", "Le Dinh");

//		System.out.println("\n\n***********UPDATE ACCOUNT 2***********");
//		
//		Account accountUpdate = new Account();
//		accountUpdate.setAccountId((short) 10);
//		accountUpdate.setFirstName("I");
//		repository.updateAccount(accountUpdate);

//		System.out.println("\n\n***********DELETE ACCOUNT***********");
//		repository.deleteAccount((short) 10);

//		System.out.println("***********CHECK ACCOUNT EXISTS BY ID***********");
//		System.out.println(repository.isAccountExistsByID((short) 10));

//		System.out.println("***********CHECK ACCOUNT EXISTS BY NAME***********");
//		System.out.println(repository.isAccountExistsByName("Ngo Ba Khien"));

	}
}
