package ru.kata.spring.boot_security.demo.dao;

import ru.kata.spring.boot_security.demo.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserDAO {
    List<User> getAllUsers();
    void saveUser(User user);

    User getUser(long id);

    void deleteUser(long id);

    Optional<User> findUserByName(String email);
}
