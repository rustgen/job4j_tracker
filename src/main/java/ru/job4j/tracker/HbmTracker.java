package ru.job4j.tracker;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class HbmTracker implements Store, AutoCloseable {

    private static final Logger LOG = LoggerFactory.getLogger(HbmTracker.class.getName());

    private final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure().build();
    private final SessionFactory sf = new MetadataSources(registry)
            .buildMetadata().buildSessionFactory();
    private final Session session = sf.openSession();

    @Override
    public Item add(Item item) {
        try (sf) {
            session.beginTransaction();
            session.save(item);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            LOG.error(e.getMessage(), e);
        }
        return item;
    }

    @Override
    public boolean replace(int id, Item item) {
        boolean result = false;
        try (sf) {
            session.beginTransaction();
            Query query = sf.getCurrentSession()
                    .createQuery("UPDATE Item SET name = :fName WHERE id = :fId");
            result = query
                    .setParameter("fName", item.getName())
                    .setParameter("fId", id)
                    .executeUpdate() > 0;
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            LOG.error(e.getMessage(), e);
        }
        return result;
    }

    @Override
    public boolean delete(int id) {
        boolean result = false;
        try (sf) {
            session.beginTransaction();
            Query query = sf.getCurrentSession()
                    .createQuery("DELETE Item WHERE id = :fId");
            result = query.setParameter("fId", id).executeUpdate() > 0;
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            LOG.error(e.getMessage(), e);
        }
        return result;
    }

    @Override
    public List<Item> findAll() {
        List result = new ArrayList<>();
        try (sf) {
            session.beginTransaction();
            result = session.createQuery("FROM Item i ORDER BY i.id ASC, i.name ASC")
                    .list();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            LOG.error(e.getMessage(), e);
        }
        return result;
    }

    @Override
    public List<Item> findByName(String key) {
        List result = new ArrayList<>();
        try (sf) {
            session.beginTransaction();
            Query query = sf.getCurrentSession()
                    .createQuery("FROM Item i WHERE i.name = :fKey");
            result = query.setParameter("fKey", key).getResultList();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            LOG.error(e.getMessage(), e);
        }
        return result;
    }

    @Override
    public Item findById(int id) {
        Item result = null;
        try (sf) {
            session.beginTransaction();
            result = session.get(Item.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            LOG.error(e.getMessage(), e);
        }
        return result;
    }

    @Override
    public void close() throws Exception {
        StandardServiceRegistryBuilder.destroy(registry);
    }
}