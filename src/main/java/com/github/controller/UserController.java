package com.github.controller;

import com.github.model.UserEntity;
import com.github.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "users")
    public String listUsers(Model model) {
        model.addAttribute("users", new UserEntity());
        model.addAttribute("listUsers", this.userService.listUsers());

        return "users";
    }

    @GetMapping("userData/{id}")
    public String userData(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", this.userService.getUserById(id));

        return "userData";
    }
}
