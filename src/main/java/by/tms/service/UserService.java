package by.tms.service;

import by.tms.entity.User;

import java.util.List;

public interface UserService {
    void createUser(User user);

    User getUserById(long id);

    User getUserByLogin(String login);

    List<User> getAllUsers();

    void remove(long id);

    void update(String name, long id);

    void update(User user);
}
