package com.karpinskiy.andrew.diplom.repositories;

import com.karpinskiy.andrew.diplom.entitys.CaloriesJournalEntity;
import com.karpinskiy.andrew.diplom.entitys.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface CaloriesJournalRepository extends CrudRepository<CaloriesJournalEntity, Long> {
    List<CaloriesJournalEntity> getAllByUserEntityAndDateIsGreaterThanEqualOrderByDateAsc(UserEntity userEntity, Date date);
}
