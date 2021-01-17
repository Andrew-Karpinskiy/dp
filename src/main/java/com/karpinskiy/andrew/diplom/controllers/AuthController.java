package com.karpinskiy.andrew.diplom.controllers;


import com.karpinskiy.andrew.diplom.config.jwt.JwtProvider;
import com.karpinskiy.andrew.diplom.controllers.requests.AuthRequest;
import com.karpinskiy.andrew.diplom.entitys.UserEntity;
import com.karpinskiy.andrew.diplom.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;

@RestController
public class AuthController {

    @Autowired
    private UserService userService;
    @Autowired
    private JwtProvider jwtProvider;


    @RequestMapping(value = "/auth", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map auth(@RequestBody AuthRequest request) {
        UserEntity userEntity = userService.findByEmail(request.getEmail());
        if (userEntity == null) {
            return Collections.singletonMap("response", "Invalid email");
        }
        if (!userService.cheekIfPasswordCorrect(userEntity, request.getPassword())) {
            return Collections.singletonMap("response", "Invalid password");
        } else {
            userEntity = userService.findByEmailAndPassword(request.getEmail(), request.getPassword());
            String token = jwtProvider.generateToken(userEntity.getEmail());
            return Collections.singletonMap("response", token);
        }
    }
}
