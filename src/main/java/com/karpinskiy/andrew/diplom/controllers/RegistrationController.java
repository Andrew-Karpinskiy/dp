package com.karpinskiy.andrew.diplom.controllers;

import com.karpinskiy.andrew.diplom.entitys.Roles;
import com.karpinskiy.andrew.diplom.entitys.User;
import com.karpinskiy.andrew.diplom.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collections;
import java.util.Map;

@Controller
public class RegistrationController {
    private UserService service;

    @Autowired
    public void setService(UserService service) {
        this.service = service;
    }

//    @GetMapping("/registration")
//    public String registration() {
//        return "registration";
//    }
//

    @RequestMapping(value = "/registration/{em}/{pa}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map addUser(@PathVariable("em") String email, @PathVariable("pa") String password) {
        System.out.println("CONNECTED!!!!!!!!!!!!!!!");
        User user = new User(email, password);
        User userFromDb = service.getUserByEmail(user.getUsername());
        if (userFromDb != null) {
            return Collections.singletonMap("response", "exist");
        }
        user.setRoles(Collections.singleton(Roles.USER));
        service.saveUser(user);
        return Collections.singletonMap("response", "correct");
    }
}
