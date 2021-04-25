package com.karpinskiy.andrew.diplom.repositories;

import com.karpinskiy.andrew.diplom.entitys.StepsJournalEntity;
import com.karpinskiy.andrew.diplom.entitys.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface StepsJournalRepository extends CrudRepository<StepsJournalEntity, Long> {
    List<StepsJournalEntity> getAllByUserEntityAndDateIsGreaterThanEqualOrderByDateAsc(UserEntity userEntity, Date date);
}
