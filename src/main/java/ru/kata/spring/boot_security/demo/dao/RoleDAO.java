package ru.kata.spring.boot_security.demo.dao;

import ru.kata.spring.boot_security.demo.entity.Role;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface RoleDAO {
    Role getRoleByName(String name);
    List<Role> getAllRoles();
    void addNewRole(String name);
}
