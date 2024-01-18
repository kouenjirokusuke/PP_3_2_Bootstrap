package ru.kata.spring.boot_security.demo.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.dao.UserDAO;
import ru.kata.spring.boot_security.demo.entity.Roles;
import ru.kata.spring.boot_security.demo.entity.User;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private RoleService roleService;

    @Override
    @Transactional
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        if (user.getRoles().isEmpty()) {
            user.setRoles(new ArrayList<>() {{
                add(roleService.getRoleByName(Roles.USER.name()));
            }});
        }

        userDAO.saveUser(user);
    }

    @Override
    @Transactional
    public User getUser(long id) {
        return userDAO.getUser(id);
    }

    @Override
    @Transactional
    public void deleteUser(long id) {
        userDAO.deleteUser(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userDAO.findUserByName(username).orElseThrow(() -> new UsernameNotFoundException("User not found."));
    }
}
