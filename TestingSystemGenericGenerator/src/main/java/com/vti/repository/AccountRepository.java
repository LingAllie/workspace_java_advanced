package com.vti.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.vti.entity.Account;
import com.vti.utils.HibernateUtils;

public class AccountRepository {

	private HibernateUtils hibernateUtils;

	public AccountRepository() {
		hibernateUtils = HibernateUtils.getInstance();
	}

	@SuppressWarnings("unchecked")
	public List<Account> getAllAccounts() {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// create hql query
			Query<Account> query = session.createQuery("FROM Account");

			return query.list();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public Account getAccountByID(short id) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			Account account = session.get(Account.class, id);

			return account;

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	@SuppressWarnings("unchecked")
	public Account getAccountByName(String name) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// create HQL query with distinct parameters for first and last names
			Query<Account> query = session.createQuery("FROM Account WHERE FirstName = :firstName AND LastName = :lastName");

			// Split the name string
			String[] names = name.split(" ");

			String firstName = names[names.length - 1];
			String lastName = "";

			// If there are more than one part of the name, concatenate the rest for the last name
			for (int i = 0; i < names.length - 1; i++) {
				lastName += names[i];
			    if (names[i] != null) {
			        lastName += " "; // Add space between parts of the last name
			    }
			}

			// set parameters
			query.setParameter("firstName", firstName);
			query.setParameter("lastName", lastName);

			// get result
			Account account = query.uniqueResult();

			return account;


		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void createAccount(Account account) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			// create
			session.save(account);

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void updateAccount1(short id, String newFirstName, String newLastName) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();
			session.beginTransaction();

			Account account = (Account) session.load(Account.class, id);

			// update
			if (newFirstName == "") {
				account.setFirstName(account.getFirstName());
			} else {
				account.setFirstName(newFirstName);
			}
			
			if (newLastName == "") {
				account.setLastName(account.getLastName());
			} else {
				account.setLastName(newLastName);
			}
			
			session.getTransaction().commit();
			
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	public void updateAccount2(Account account) {
		Session session = null;
		try {
			
			session = hibernateUtils.openSession();
			session.beginTransaction();
			
			session.update(account);
			session.getTransaction().commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}


	public void deleteAccount(short id) {

		Session session = null;

		try {

			// get session
			session = hibernateUtils.openSession();

			session.beginTransaction();

			Account account = (Account) session.load(Account.class, id);

			// delete
			session.delete(account);

			session.getTransaction().commit();

		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public boolean isAccountExistsByID(short id) {

		Account account = getAccountByID(id);

		// return result
		if (account == null) {
			return false;
		}

		return true;
	}

	public boolean isAccountExistsByName(String name) {
		if (getAccountByName(name) == null) {
			return false;
		}
		
		return true;
	}

}
