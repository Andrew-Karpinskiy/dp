package com.karpinskiy.andrew.diplom.controllers;


import com.karpinskiy.andrew.diplom.config.jwt.JwtProvider;
import com.karpinskiy.andrew.diplom.controllers.requests.AuthRequest;
import com.karpinskiy.andrew.diplom.controllers.response.AuthResponse;
import com.karpinskiy.andrew.diplom.entitys.UserEntity;
import com.karpinskiy.andrew.diplom.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {

    @Autowired
    private UserService userService;
    @Autowired
    private JwtProvider jwtProvider;

    @RequestMapping(value = "/auth", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public AuthResponse auth(@RequestBody AuthRequest request) {
        UserEntity userEntity = userService.findByEmail(request.getEmail());
        if (userEntity == null) {
            return new AuthResponse("Invalid email");
        }
        if (!userService.cheekIfPasswordCorrect(userEntity, request.getPassword())) {
            return new AuthResponse("Invalid password");
        } else {
            userEntity = userService.findByEmailAndPassword(request.getEmail(), request.getPassword());
            String token = jwtProvider.generateToken(userEntity.getEmail());
            return new AuthResponse("Ok!", token);
        }
    }
}
