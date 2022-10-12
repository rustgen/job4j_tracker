package ru.job4j.tracker;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.ArrayList;
import java.util.List;

public class HbmTracker implements Store, AutoCloseable {
    private final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure().build();
    private final SessionFactory sf = new MetadataSources(registry)
            .buildMetadata().buildSessionFactory();

    @Override
    public Item add(Item item) {
        Session session = sf.openSession();
        try {
            session.beginTransaction();
            session.save(item);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
        session.close();
        return item;
    }

    @Override
    public boolean replace(int id, Item item) {
        Session session = sf.openSession();
        boolean result = false;
        try {
            session.beginTransaction();
            session.createQuery("UPDATE Item SET name = :fName WHERE id = :fId")
                    .setParameter("fName", item.getName())
                    .setParameter("fId", id)
                    .executeUpdate();
            result = true;
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
        session.close();
        return result;
    }

    @Override
    public boolean delete(int id) {
        Session session = sf.openSession();
        boolean result = false;
        try {
            session.beginTransaction();
            session.createQuery("DELETE Item WHERE id = :fId")
                    .setParameter("fId", id)
                    .executeUpdate();
            result = true;
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
        session.close();
        return result;
    }

    @Override
    public List<Item> findAll() {
        Session session = sf.openSession();
        List result = new ArrayList<>();
        try {
            session.beginTransaction();
            result = session.createQuery("FROM Item i ORDER BY i.id ASC, i.name ASC")
                    .list();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
        session.close();
        return result;
    }

    @Override
    public List<Item> findByName(String key) {
        Session session = sf.openSession();
        List result = new ArrayList<>();
        try {
            session.beginTransaction();
            result = session.createQuery("FROM Item i WHERE i.name LIKE '%" + key + "%'")
                    .list();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
        session.close();
        return result;
    }

    @Override
    public Item findById(int id) {
        Session session = sf.openSession();
        Item result = null;
        try {
            session.beginTransaction();
            result = session.get(Item.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
        session.close();
        return result;
    }

    @Override
    public void close() throws Exception {
        StandardServiceRegistryBuilder.destroy(registry);
    }
}