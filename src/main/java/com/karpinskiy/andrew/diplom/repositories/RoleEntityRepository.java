package com.karpinskiy.andrew.diplom.repositories;

import com.karpinskiy.andrew.diplom.entitys.RoleEntity;
import org.springframework.data.repository.CrudRepository;

public interface RoleEntityRepository extends CrudRepository<RoleEntity, Long> {

    RoleEntity findByName(String name);
}
