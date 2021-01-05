package com.karpinskiy.andrew.diplom.repositories;

import com.karpinskiy.andrew.diplom.entitys.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends CrudRepository<User, Long> {
    User findUserById(Long id);

    User findByEmail(String username);
}