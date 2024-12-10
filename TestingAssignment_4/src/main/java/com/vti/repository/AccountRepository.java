package com.vti.repository;

import com.vti.entity.Account;
import com.vti.utils.HibernateUtils;
import org.hibernate.Session;

import java.util.List;

public class AccountRepository {

    private HibernateUtils instance;

    public AccountRepository() {
        instance = HibernateUtils.getInstance();
    }

    @SuppressWarnings("unchecked")
    public List<Account> getAllAccounts() {
        try (Session session = instance.openSession()) {
            return session.createQuery("FROM Account").list();
        }
    }

    public void createAccount(Account account) {
        try (Session session = instance.openSession()) {
            session.beginTransaction();
            session.save(account);
            session.getTransaction().commit();
            System.out.println("Account created successfully");
        }
    }

    public Account getAccountById(short id) {
        try (Session session = instance.openSession()) {
            session.beginTransaction();
            Account account = session.get(Account.class, id);
            session.getTransaction().commit();
            return account;
        }
    }

    public Account getAccountByUsername(String username) {
        try (Session session = instance.openSession()) {
            return session.createQuery("FROM Account WHERE username = :username", Account.class)
                    .setParameter("username", username)
                    .uniqueResult();
        }
    }

    public void updateAccount(Account account) {
        try (Session session = instance.openSession()) {
            session.beginTransaction();
            session.update(account);
            session.getTransaction().commit();
            System.out.println("Account updated successfully");
        }
    }

    public void deleteAccount(short id) {
        try (Session session = instance.openSession()) {
            session.beginTransaction();
            Account account = session.get(Account.class, id);
            session.delete(account);
            session.getTransaction().commit();
            System.out.println("Account deleted successfully");
        }
    }
}
