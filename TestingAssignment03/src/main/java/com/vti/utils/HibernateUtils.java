package com.vti.utils;


import com.vti.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtils {

    private static HibernateUtils instance;

    private Configuration configuration;
    private SessionFactory sessionFactory;

    public static HibernateUtils getInstance() {
        if (instance == null) {
            instance = new HibernateUtils();
        }
        return instance;
    }

    private HibernateUtils() {
        configure();
    }

    private void configure() {
        //load configuration
        configuration = new Configuration().configure("hibernate.cfg.xml");

        //add entity
        configuration.addAnnotatedClass(Account.class);
        configuration.addAnnotatedClass(Address.class);
        configuration.addAnnotatedClass(Answer.class);
        configuration.addAnnotatedClass(CategoryQuestion.class);
        configuration.addAnnotatedClass(Department.class);
        configuration.addAnnotatedClass(DetailDepartment.class);
        configuration.addAnnotatedClass(Employee.class);
        configuration.addAnnotatedClass(Exam.class);
        configuration.addAnnotatedClass(ExamQuestion.class);
        configuration.addAnnotatedClass(Group.class);
        configuration.addAnnotatedClass(GroupAccount.class);
        configuration.addAnnotatedClass(Manager.class);
        configuration.addAnnotatedClass(Position.class);
        configuration.addAnnotatedClass(Question.class);
        configuration.addAnnotatedClass(Salary.class);
        configuration.addAnnotatedClass(TypeQuestion.class);
    }

    private SessionFactory buildSessionFactory() {
        if (sessionFactory == null || sessionFactory.isClosed()) {
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(configuration.getProperties()).build();

            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        }
        return sessionFactory;
    }

    public void closeFactory() {
        if (sessionFactory != null && sessionFactory.isOpen()) {
            sessionFactory.close();
        }
    }

    public Session openSession() {
        buildSessionFactory();
        return sessionFactory.openSession();
    }

}
