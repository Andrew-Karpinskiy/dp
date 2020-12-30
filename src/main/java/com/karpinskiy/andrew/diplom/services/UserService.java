package com.karpinskiy.andrew.diplom.services;

import com.karpinskiy.andrew.diplom.entitys.User;
import com.karpinskiy.andrew.diplom.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepo repository;

    public User getUserById (Long id){
        return repository.findUserById(id);
    }

}
