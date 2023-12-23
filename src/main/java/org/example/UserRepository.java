package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class UserRepository {
    private final SessionFactory sessionFactory = SessionFactoryDB.getSessionFactory();

    public void save(Users users) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(users);
        transaction.commit();
        session.close();
    }

    public Users findById(Long id) {
        Session session = sessionFactory.openSession();
        Users users = session.get(Users.class, id);
        session.close();
        return users;
    }

    public List<Users> findAll() {
        Session session = sessionFactory.openSession();
        List<Users> list1 = session.createQuery("select u from Users u", Users.class).getResultList();
        session.close();
        return list1;
    }

    public void deleteById(Long id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Users users = findById(id);
        session.delete(users);
        transaction.commit();
        session.close();
    }

    public void deleteAll() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query<?> query = session.createQuery("delete from Users u");
        query.executeUpdate();
        transaction.commit();
        session.close();
    }

    public void update(Long id, Users users) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Users users1 = findById(id);
        users1.setName(users.getName());
        users1.setAge(users.getAge());
        session.update(users1);
        transaction.commit();
        session.close();
    }
}