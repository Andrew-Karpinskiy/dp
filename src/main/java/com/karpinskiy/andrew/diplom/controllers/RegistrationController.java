package com.karpinskiy.andrew.diplom.controllers;

import com.karpinskiy.andrew.diplom.controllers.requests.RegistrationRequest;
import com.karpinskiy.andrew.diplom.entitys.UserEntity;
import com.karpinskiy.andrew.diplom.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collections;
import java.util.Map;

@RestController
public class RegistrationController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/register", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map registerUser(@RequestBody @Valid RegistrationRequest registrationRequest) {
        UserEntity u = new UserEntity();
        u.setPassword(registrationRequest.getPassword());
        u.setEmail(registrationRequest.getEmail());
        userService.saveUser(u);
        return Collections.singletonMap("response", "OK!");
    }
}
