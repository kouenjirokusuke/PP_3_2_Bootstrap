package ru.kata.spring.boot_security.demo.service;

import ru.kata.spring.boot_security.demo.entity.Role;

import java.util.List;
import java.util.Set;

public interface RoleService {
    Role getRoleByName(String name);
    List<Role> getAllRoles();
    void addNewRole(String name);
}
