package com.karpinskiy.andrew.diplom.controllers;

import com.karpinskiy.andrew.diplom.entitys.Roles;
import com.karpinskiy.andrew.diplom.entitys.User;
import com.karpinskiy.andrew.diplom.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;

@Controller
public class RegistrationController {
    private UserService service;

    @Autowired
    public void setService(UserService service) {
        this.service = service;
    }

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/submit")
    public String addUser(User user) {
        User userFromDb = service.getUserByEmail(user.getUsername());
        if (userFromDb != null) {
            return "registration";
        }
        user.setRoles(Collections.singleton(Roles.USER));
        service.saveUser(user);
        return "redirect:/login";
    }
}
