package by.tms.service;

import by.tms.dao.UserDao;
import by.tms.dao.UserDataBaseDao;
import by.tms.entity.User;
import by.tms.service.exceptions.DuplicateUserException;
import by.tms.service.exceptions.NotUserFoundException;

import java.sql.Connection;
import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    private static UserService instance = null;

    public static UserService getInstance(Connection connection) {
        if (instance == null) {
            return new UserServiceImpl(UserDataBaseDao.getInstance(connection));
        } else {
            return instance;
        }
    }

    @Override
    public void createUser(User user) {
        if (userDao.containsByLogin(user.getLogin())) {
            throw new DuplicateUserException();
        }
        userDao.create(user);
    }

    @Override
    public User getUserById(long id) {
        if (userDao.containsById(id)) {
            return userDao.getById(id);
        }
        throw new NotUserFoundException();
    }

    @Override
    public User getUserByLogin(String login) {
        if (userDao.containsByLogin(login)) {
            return userDao.getByLogin(login);
        }
        throw new NotUserFoundException();
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAll();
    }

    @Override
    public void remove(long id) {
        if (userDao.containsById(id)) {
            userDao.deleteById(id);
        }
    }

    @Override
    public void update(String name, long id) {
    }

    @Override
    public void update(User user) {
        if (userDao.containsById(user.getId())) {
            userDao.updateById(user);
        }
    }
}
