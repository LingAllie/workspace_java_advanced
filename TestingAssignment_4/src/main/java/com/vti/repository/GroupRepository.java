package com.vti.repository;

import com.vti.entity.Group;
import com.vti.utils.HibernateUtils;
import org.hibernate.Session;

import java.util.List;

public class GroupRepository {

    private HibernateUtils instance;

    public GroupRepository() {
        instance = HibernateUtils.getInstance();
    }

    @SuppressWarnings("unchecked")
    public List<Group> getAllGroups() {
        try (Session session = instance.openSession()) {
            return session.createQuery("FROM Group").list();
        }
    }

    public void createGroup(Group group) {
        try (Session session = instance.openSession()) {
            session.beginTransaction();
            session.save(group);
            session.getTransaction().commit();
            System.out.println("Group created successfully");
        }
    }

    public Group getGroupById(short id) {
        try (Session session = instance.openSession()) {
            return session.get(Group.class, id);
        }
    }

    public Group getGroupByName(String name) {
        try (Session session = instance.openSession()) {
            return session.createQuery("FROM Group WHERE groupName =:name", Group.class)
                    .setParameter("name", name)
                    .uniqueResult();
        }
    }

    public void updateGroupName(Group group) {
        try (Session session = instance.openSession()) {
            session.beginTransaction();
            session.update(group);
            session.getTransaction().commit();
            System.out.println("Group updated successfully");
        }
    }

    public void deleteGroup(short id) {
        try (Session session = instance.openSession()) {
            session.beginTransaction();
            Group group = session.get(Group.class, id);
            session.delete(group);
            session.getTransaction().commit();
            System.out.println("Group deleted successfully");
        }
    }
}
