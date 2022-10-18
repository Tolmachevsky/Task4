package ru.tolmachevsky.tasks.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.tolmachevsky.tasks.model.User;
import ru.tolmachevsky.tasks.repository.UserRepository;

import java.util.Date;

@Controller
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping(path = "/all")
    public String getAllUsers(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "users_table";
    }

    @GetMapping(path = "/add")
    public String crateUserForm(User user) {
        return "add_user";
    }

    @PostMapping(path = "/add")
    public String addUser(User user) {
        userRepository.save(user);
        return "redirect:/all";
    }

    @GetMapping(path = "/update/{id}")
    public String updateUserForm(@PathVariable("id") Integer id, Model model) {
        User user = userRepository.findById(id).get();
        model.addAttribute("user", user);
        return "update_user";
    }

    @PostMapping(path = "/update")
    public String updateUser(User user) {
        userRepository.save(user);
        return "redirect:/all";
    }

    @GetMapping(path = "delete/{id}")
    public String deleteUserById(@PathVariable("id") Integer id) {
        userRepository.deleteById(id);
        return "redirect:/all";
    }
}