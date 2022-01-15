package repository.impl;

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
import java.util.List;

public class UserRepositoryImpl implements UserRepository {


    @Override
    public List<User> findAll() {


        List<User> result = new ArrayList<>();

        final String findAllQuery = "select * from users order by id desc";

        Statement statement;
        ResultSet rs;
        Connection connection;

        try {
            connection = DataSource.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(findAllQuery);

            //Row mapping
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getLong("id"));
                user.setName(rs.getString("name"));
                user.setSurname(rs.getString("surname"));

                result.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("SQL Issues!");
        }
        return result;
    }

    @Override
    public User findOne(Long id) {

        return HibernateSessionFactoryUtil.getSessionFactory().openSession().get(User.class, id);

    }

    @Override
    public User save(User entity) {

        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(entity);
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
        session.delete(findOne(id));
        tx1.commit();
        session.close();
    }

}
