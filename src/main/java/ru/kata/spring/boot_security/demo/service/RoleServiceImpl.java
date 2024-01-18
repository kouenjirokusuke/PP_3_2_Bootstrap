package ru.kata.spring.boot_security.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.dao.RoleDAO;
import ru.kata.spring.boot_security.demo.entity.Role;

import java.util.List;
import java.util.Set;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDAO roleDAO;

    @Override
    @Transactional
    public Role getRoleByName(String name) {
        return roleDAO.getRoleByName(name);
    }

    @Override
    @Transactional
    public List<Role> getAllRoles() {
        return roleDAO.getAllRoles();
    }

    @Override
    public void addNewRole(String name) {
        roleDAO.addNewRole(name);
    }

}
