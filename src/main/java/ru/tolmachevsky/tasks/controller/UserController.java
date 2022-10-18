package ru.tolmachevsky.tasks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.tolmachevsky.tasks.model.User;
import ru.tolmachevsky.tasks.service.UserService;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(path = "/all")
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.findAll());
        return "users_table";
    }

    @GetMapping(path = "/add")
    public String crateUserForm(User user) {
        return "add_user";
    }

    @PostMapping(path = "/add")
    public String addUser(User user) {
        userService.save(user);
        return "redirect:/all";
    }

    @GetMapping(path = "/update/{id}")
    public String updateUserForm(@PathVariable("id") Integer id, Model model) {
        User user = userService.findById(id);
        model.addAttribute("user", user);
        return "update_user";
    }

    @PostMapping(path = "/update")
    public String updateUser(User user) {
        userService.save(user);
        return "redirect:/all";
    }

    @GetMapping(path = "delete/{id}")
    public String deleteUserById(@PathVariable("id") Integer id) {
        userService.deleteUserById(id);
        return "redirect:/all";
    }
}