package com.vti.repository;

import com.vti.entity.Position;
import com.vti.utils.HibernateUtils;
import org.hibernate.Session;

import java.util.List;

public class PositionRepository {

    private HibernateUtils instance;

    public PositionRepository() {
        instance = HibernateUtils.getInstance();
    }

    // 1. Get all positions
    @SuppressWarnings("unchecked")
    public List<Position> getAllPositions() {
        try (Session session = instance.openSession()) {
            session.beginTransaction();
            List<Position> positions = session.createQuery("FROM Position").list();
            session.getTransaction().commit();
            return positions;
        }
    }

    // 2. Create position
    public void createPosition(Position position) {
        try (Session session = instance.openSession()) {
            session.beginTransaction();
            session.save(position);
            session.getTransaction().commit();
            System.out.println("Position created successfully");
        }
    }

    // 3. Get position by id
    public Position getPositionById(short id) {
        try (Session session = instance.openSession()) {
            session.beginTransaction();
            Position position = session.get(Position.class, id);
            session.getTransaction().commit();
            return position;
        }
    }

    // 4. Delete position
    public void deletePositionById(short id) {
        try (Session session = instance.openSession()) {
            if (getPositionById(id) != null) {
                session.beginTransaction();
                Position position = session.get(Position.class, id);
                session.delete(position);
                session.getTransaction().commit();
                System.out.println("Position deleted successfully");
            } else {
                System.out.println("Position not found");
            }
        }
    }
}
