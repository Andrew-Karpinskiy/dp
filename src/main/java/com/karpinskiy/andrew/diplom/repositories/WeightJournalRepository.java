package com.karpinskiy.andrew.diplom.repositories;

import com.karpinskiy.andrew.diplom.entitys.UserEntity;
import com.karpinskiy.andrew.diplom.entitys.WeightJournalEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface WeightJournalRepository extends CrudRepository<WeightJournalEntity, Long> {
    List<WeightJournalEntity> getAllByUserEntityAndDateIsGreaterThanEqualOrderByDateAsc(UserEntity userEntity, Date date);

}
