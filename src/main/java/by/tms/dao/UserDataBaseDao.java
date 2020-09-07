package by.tms.dao;

import by.tms.entity.User;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDataBaseDao implements UserDao {
    private Connection connection;
    private static final String CREATE_USER = "INSERT INTO users VALUES (default, ?, ?, ?)";
    private static final String GET_BY_ID = "SELECT * FROM users WHERE id = ?";
    private static final String GET_BY_LOGIN = "SELECT * FROM users WHERE login = ?";
    private static final String GET_ALL = "SELECT * FROM users";
    private static final String UPDATE_BY_ID = "UPDATE users SET login = ?, name  = ?, password = ? WHERE id = ?";
    private static final String DELETE_BY_ID = "DELETE FROM users WHERE id = ?";

    public UserDataBaseDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(User user) {
        try {
            PreparedStatement st = connection.prepareStatement(CREATE_USER);
            st.setString(1, user.getLogin());
            st.setString(2, user.getName());
            st.setString(3, user.getPassword());
            st.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public User getById(long id) {
        try {
            PreparedStatement st = connection.prepareStatement(GET_BY_ID);
            st.setLong(1, id);
            ResultSet resultSet = st.executeQuery();
            if (resultSet.next()) {
                return new User(
                        resultSet.getString("name"),
                        resultSet.getString("login"),
                        resultSet.getString("password")
                );
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        throw new UserNotFoundException();
    }

    @Override
    public User getByLogin(String login) {
        try {
            PreparedStatement st = connection.prepareStatement(GET_BY_LOGIN);
            st.setString(1, login);
            ResultSet resultSet = st.executeQuery();
            if (resultSet.next()) {
                return new User(
                        resultSet.getString("name"),
                        resultSet.getString("login"),
                        resultSet.getString("password")
                );
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        throw new UserNotFoundException();

    }

    @Override
    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        try {
            Statement st = connection.createStatement();
            ResultSet resultSet = st.executeQuery(GET_ALL);
            while (resultSet.next()) {
                users.add(new User(
                        resultSet.getString("name"),
                        resultSet.getString("login"),
                        resultSet.getString("password")
                ));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        if (users.isEmpty()) {
            throw new NoResultExceptions();
        }
        return users;
    }

    @Override
    public void updateById(User user) {
        try {
            PreparedStatement st = connection.prepareStatement(UPDATE_BY_ID);
            st.setString(1, user.getLogin());
            st.setString(2, user.getName());
            st.setString(3, user.getPassword());
            st.setLong(4, user.getId());
            st.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void deleteById(long id) {
        try {
            PreparedStatement st = connection.prepareStatement(DELETE_BY_ID);
            st.setLong(1, id);
            st.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public boolean containsById(long id) {
        try {
            PreparedStatement st = connection.prepareStatement(GET_BY_ID);
            st.setLong(1, id);

            return st.executeQuery().next();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean containsByLogin(String login) {
        try {
            PreparedStatement st = connection.prepareStatement(GET_BY_LOGIN);
            st.setString(1, login);
            return st.executeQuery().next();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }


    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/store?serverTimezone=UTC", "root", "Bthjybv19841030");
        UserDao userDao = new UserDataBaseDao(connection);
//        userDao.create(new User("Vasia@12", "Vasiliy", "13579"));
//        userDao.updateById(new User(1, "gfg", "fgf", "1234"));
//        userDao.deleteById(1);
//        System.out.println(userDao.getAll());
//        userDao.create(new User("Sasha@1", "Aleksandr", "1375"));
//        userDao.create(new User("Dima@15", "Dmitriy", "1377"));
        System.out.println(userDao.containsById(7));
        System.out.println(userDao.containsByLogin("gfg"));

    }
}
