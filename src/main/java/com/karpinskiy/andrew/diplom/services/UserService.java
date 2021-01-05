package com.karpinskiy.andrew.diplom.services;

import com.karpinskiy.andrew.diplom.entitys.User;
import com.karpinskiy.andrew.diplom.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepo repository;


    @Autowired
    private PasswordEncoder passwordEncoder;


    public void saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        repository.save(user);
    }

    public List<User> qetAllUser() {
        return (List<User>) repository.findAll();
    }

    public User getUserById(Long id) {
        return repository.findUserById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByEmail(username);
    }

    public User getUserByEmail(String name) {
        return repository.findByEmail(name);
    }
}
