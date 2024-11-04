package com.vti.repository;

import java.util.List;

import com.vti.entity.Address;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.vti.utils.HibernateUtils;
public class AddressRepository {

    private HibernateUtils hibernateUtils;

    public AddressRepository() {
        hibernateUtils = HibernateUtils.getInstance();
    }

    @SuppressWarnings("unchecked")
    public List<Address> getAllAddresses() {

        Session session = null;

        try {

            // get session
            session = hibernateUtils.openSession();

            // create hql query
            Query<Address> query = session.createQuery("FROM Address ");

            return query.list();

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public Address getAddressByID(short id) {

        Session session = null;

        try {

            // get session
            session = hibernateUtils.openSession();

            return session.get(Address.class, id);

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @SuppressWarnings("unchecked")
    public Address getAddressByName(String name) {

        Session session = null;

        try {

            // get session
            session = hibernateUtils.openSession();

            // create HQL query with distinct parameters for first and last names
            Query<Address> query = session.createQuery("FROM Address WHERE 'AddressName' = :addressName");

            // set parameters
            query.setParameter("addressName", name);

            // get result

            return query.uniqueResult();


        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void createAddress(Address address) {

        Session session = null;

        try {

            // get session
            session = hibernateUtils.openSession();

            // create
            session.save(address);

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void updateAddress1(short id, String newAddressName) {

        Session session = null;

        try {

            // get session
            session = hibernateUtils.openSession();
            session.beginTransaction();

            Address address = (Address) session.load(Address.class, id);

            // update
            if (newAddressName == "") {
                address.setAddressName(address.getAddressName());
            } else {
                address.setAddressName(newAddressName);
            }

            session.getTransaction().commit();

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void updateAddress2(Address address) {
        Session session = null;
        try {

            session = hibernateUtils.openSession();
            session.beginTransaction();

            session.update(address);
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }


    public void deleteAddress(short id) {

        Session session = null;

        try {

            // get session
            session = hibernateUtils.openSession();

            session.beginTransaction();

            Address address = (Address) session.load(Address.class, id);

            // delete
            session.delete(address);

            session.getTransaction().commit();

        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public boolean isAddressExistsByID(short id) {

        Address address = getAddressByID(id);

        // return result
        return address != null;
    }

    public boolean isAddressExistsByName(String name) {
        return getAddressByName(name) != null;
    }

}
