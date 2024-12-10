package com.vti.repository;

import com.vti.entity.Address;
import com.vti.utils.HibernateUtils;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

public class AddressRepository {

    private HibernateUtils hibernateUtils;

    public AddressRepository() {
        hibernateUtils = HibernateUtils.getInstance();
    }

    public void createAddress(Address address) {
        try (Session session = hibernateUtils.openSession()) {
            session.beginTransaction();
            session.save(address);
            session.getTransaction().commit();
            System.out.println("Address created successfully");
        }
    }

    @SuppressWarnings("unchecked")
    public List<Address> getAllAddresses() {
        try (Session session = hibernateUtils.openSession()) {
            return session.createQuery("FROM Address").list();
        }
    }

    public Address getAddressById(short id) {
        try (Session session = hibernateUtils.openSession()) {
            return session.get(Address.class, id);
        }
    }

    public Address getAddressByName(String name) {
        try (Session session = hibernateUtils.openSession()) {
            return session.createQuery("FROM Address WHERE addressName = :name", Address.class)
                    .setParameter("name", name)
                    .uniqueResult();
        }
    }

    public void updateAddressName(Address address) {
        try (Session session = hibernateUtils.openSession()) {
            if (getAddressById(address.getAddressId()) != null) {
                session.beginTransaction();
                session.update(address);
                session.getTransaction().commit();
                System.out.println("Address updated successfully");
            } else {
                System.out.println("No such address to update");
            }
        }
    }

    public void deleteAddress(short id) {
        try (Session session = hibernateUtils.openSession()) {
            if (getAddressById(id) != null) {
                session.beginTransaction();
                Address address = session.get(Address.class, id);
                session.delete(address);
                session.getTransaction().commit();
                System.out.println("Address deleted successfully");
            } else {
                System.out.println("No such address to delete");
            }

        }
    }
}
