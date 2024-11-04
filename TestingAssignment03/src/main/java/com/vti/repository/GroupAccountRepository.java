package com.vti.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.vti.entity.GroupAccount;
import com.vti.utils.HibernateUtils;

public class GroupAccountRepository {

    private HibernateUtils hibernateUtils;

    public GroupAccountRepository() {
        hibernateUtils = HibernateUtils.getInstance();
    }

    @SuppressWarnings("unchecked")
    public List<GroupAccount> getAllGroupAccounts() {

        Session session = null;

        try {

            // get session
            session = hibernateUtils.openSession();

            // create hql query
            Query<GroupAccount> query = session.createQuery("FROM GroupAccount");

            return query.list();

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @SuppressWarnings("unchecked")
    public GroupAccount getGroupAccountByGroupId(short groupId) {

        Session session = null;

        try {

            // get session
            session = hibernateUtils.openSession();

            // create hql query
            Query<GroupAccount> query = session.createQuery("FROM Group WHERE 'GroupID' = :groupId");

            // set parameter
            query.setParameter("groupId", groupId);

            // get result
            GroupAccount group = query.uniqueResult();

            return group;

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void createGroup(GroupAccount group) {

        Session session = null;

        try {

            // get session
            session = hibernateUtils.openSession();

            // create
            session.save(group);

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

//    public void updateGroupAccount(short id, String newName) {
//
//        Session session = null;
//
//        try {
//
//            // get session
//            session = hibernateUtils.openSession();
//            session.beginTransaction();
//
//            // get group
//            Group group = (Group) session.load(Group.class, id);
//
//            // update
//            group.setGroupName(newName);
//
//            session.getTransaction().commit();
//
//        } finally {
//            if (session != null) {
//                session.close();
//            }
//        }
//    }
//
//    public void updateGroup(Group group) {
//
//        Session session = null;
//
//        try {
//
//            // get session
//            session = hibernateUtils.openSession();
//            session.beginTransaction();
//
//            // update
//            session.update(group);
//            session.getTransaction().commit();
//
//        } finally {
//            if (session != null) {
//                session.close();
//            }
//        }
//    }

    public void deleteGroupAccount(short id) {

        Session session = null;

        try {

            // get session
            session = hibernateUtils.openSession();

            session.beginTransaction();

            // get group
            GroupAccount group = (GroupAccount) session.load(GroupAccount.class, id);

            // delete
            session.delete(group);

            session.getTransaction().commit();

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public boolean isGroupAccountExistsByGroupID(short id) {

        GroupAccount group = getGroupAccountByGroupId(id);

        // return result
        if (group == null) {
            return false;
        }

        return true;
    }

}
