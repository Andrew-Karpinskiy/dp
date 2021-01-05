package com.karpinskiy.andrew.diplom.controllers;

import com.karpinskiy.andrew.diplom.entitys.User;
import com.karpinskiy.andrew.diplom.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @Autowired
    UserService service;

    @PostMapping("/getById")
    public String getUser(@RequestParam Long id, Model model) {
        model.addAttribute("id", id);
        return "result";
    }

    @GetMapping("/")
    public String main() {
        return "main";
    }
}
