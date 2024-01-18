package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.kata.spring.boot_security.demo.entity.Roles;
import ru.kata.spring.boot_security.demo.entity.User;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.security.Principal;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @RequestMapping(value = {"/", "/login"})
    public String login() {
        return "login";
    }

    @RequestMapping("/user")
    public String user(Model model, Principal principal) {
        model.addAttribute("user", userService.loadUserByUsername(principal.getName()));

        return "user";
    }

    @RequestMapping("/admin")
    public String admin(Model model, Principal principal) {
        model.addAttribute("user", userService.loadUserByUsername(principal.getName()));
        model.addAttribute("users", userService.getAllUsers());
        model.addAttribute("allRoles", roleService.getAllRoles());

        System.out.println(userService.loadUserByUsername(principal.getName()));

        return "admin";
    }

    @RequestMapping("/add")
    public String addNewUser(Model model) {
        User user = new User();
        user.addRole(roleService.getRoleByName(Roles.USER.name()));

        model.addAttribute("user", user);

        return "redirect:/admin";
    }

    @RequestMapping("/save")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);

        return "redirect:/admin";
    }

    @RequestMapping("/updateInfo")
    public String updateUser (@ModelAttribute("user") User user) {
        userService.saveUser(user);

        return "redirect:/admin";
    }
    @RequestMapping("/deleteUser")
    public String deleteUser (@RequestParam("userId") long id) {
        userService.deleteUser(id);

        return "redirect:/admin";
    }

}
