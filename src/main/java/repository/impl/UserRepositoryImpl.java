package repository.impl;

import domain.User;
import hicari.DataSource;
import repository.UserRepository;

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
    public User save(User entity) {
        return null;
    }

    @Override
    public User update(User entity) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public User findOne(Long numberPassport) {
        return null;
    }
}