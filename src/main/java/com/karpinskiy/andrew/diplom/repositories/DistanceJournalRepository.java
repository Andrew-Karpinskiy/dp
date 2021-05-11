package com.karpinskiy.andrew.diplom.repositories;

import com.karpinskiy.andrew.diplom.entitys.DistanceJournalEntity;
import com.karpinskiy.andrew.diplom.entitys.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface DistanceJournalRepository extends CrudRepository<DistanceJournalEntity, Long> {
    List<DistanceJournalEntity> getAllByUserEntityAndDateIsGreaterThanEqualOrderByDateAsc(UserEntity userEntity, Date date);
}
