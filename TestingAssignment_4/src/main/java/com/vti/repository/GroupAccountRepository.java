package com.vti.repository;

import com.vti.entity.Account;
import com.vti.entity.GroupAccount;
import com.vti.utils.HibernateUtils;
import org.hibernate.Session;

import java.util.List;

public class GroupAccountRepository {

    private HibernateUtils instance;

    public GroupAccountRepository() {
        instance = HibernateUtils.getInstance();
    }

    @SuppressWarnings("unchecked")
    public List<GroupAccount> getAllGroupAccounts() {
        try (Session session = instance.openSession()) {
            return session.createQuery("FROM GroupAccount").list();
        }
    }

    public void createGroupAccount(GroupAccount groupAccount) {
        try (Session session = instance.openSession()) {
            session.beginTransaction();
            session.save(groupAccount);
            session.getTransaction().commit();
            System.out.println("Group Account added successfully");
        }
    }

    public List<GroupAccount> getGroupAccountByGroupId(short groupId) {
        try (Session session = instance.openSession()) {
            return session.createQuery("FROM GroupAccount WHERE group.groupId = :groupId", GroupAccount.class)
                    .setParameter("groupId", groupId)
                    .list();
        }
    }

    public List<GroupAccount> getGroupAccountByAccountId(short accountId) {
        try (Session session = instance.openSession()) {
            return session.createQuery("FROM GroupAccount WHERE account.accountId = :accountId", GroupAccount.class)
                    .setParameter("accountId", accountId)
                    .list();
        }
    }

    public GroupAccount getGroupAccountByGroupIdAndAccountId(short groupId, short accountId) {
        try (Session session = instance.openSession()) {
            return session.createQuery("FROM GroupAccount WHERE group.groupId = :groupId AND account.accountId = :accountId", GroupAccount.class)
                    .setParameter("groupId", groupId)
                    .setParameter("accountId", accountId)
                    .uniqueResult();
        }
    }

    public void deleteGroupAccountByGroupId(short groupId) {
        try (Session session = instance.openSession()) {
            session.beginTransaction();
            // HQL to delete all GroupAccount entries for the specified groupId
            session.createQuery("DELETE FROM GroupAccount WHERE group.groupId = :groupId")
                    .setParameter("groupId", groupId)
                    .executeUpdate();
            session.getTransaction().commit();
            System.out.println("All accounts removed from group ID " + groupId + " successfully.");
        }
    }

    public void deleteAccountFromGroup(short groupId, short accountId) {
        try (Session session = instance.openSession()) {
            session.beginTransaction();
            // HQL to delete the specified account from the specified group
            int result = session.createQuery("DELETE FROM GroupAccount WHERE group.groupId = :groupId AND account.accountId = :accountId")
                    .setParameter("groupId", groupId)
                    .setParameter("accountId", accountId)
                    .executeUpdate();

            if (result > 0) {
                System.out.println("Account ID " + accountId + " removed from group ID " + groupId + " successfully.");
            } else {
                System.out.println("No account found with ID " + accountId + " in group ID " + groupId + ".");
            }

            session.getTransaction().commit();
        }
    }


}
