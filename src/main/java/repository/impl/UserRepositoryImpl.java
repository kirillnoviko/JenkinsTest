package repository.impl;

import domain.Role;
import domain.User;
import org.hibernate.Transaction;
import util.DataSource;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import repository.UserRepository;
import util.HibernateSessionFactoryUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {


    @Override
    public List<User> findAll() {
        List<User> users = (List<User>)  HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("select u from User u").list();
        return users;
    }

    @Override
    public User findOne(Long id) {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(User.class, id);
    }

    @Override
    public User save(User entity) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();

        Transaction tx1 = session.beginTransaction();
        Role role=session.get(Role.class,2l);
        entity.addRole(role);
        session.persist(entity);
        tx1.commit();

        session.close();
        return entity;
    }

    @Override
    public User update(User entity) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(entity);
        tx1.commit();
        session.close();
        return entity;
    }

    @Override
    public void delete(Long id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();

        User user =session.get(User.class,id);
        user.remove();
        session.delete(user);
        tx1.commit();
        session.close();
    }

}
