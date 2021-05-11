package com.karpinskiy.andrew.diplom.repositories;

import com.karpinskiy.andrew.diplom.entitys.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserEntityRepository extends CrudRepository<UserEntity, Long> {
    UserEntity findUserById(Long id);

    UserEntity findByEmail(String username);
}