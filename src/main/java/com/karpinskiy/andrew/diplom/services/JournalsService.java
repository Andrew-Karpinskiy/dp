package com.karpinskiy.andrew.diplom.services;

import com.karpinskiy.andrew.diplom.entitys.*;
import com.karpinskiy.andrew.diplom.repositories.CaloriesJournalRepository;
import com.karpinskiy.andrew.diplom.repositories.DistanceJournalRepository;
import com.karpinskiy.andrew.diplom.repositories.StepsJournalRepository;
import com.karpinskiy.andrew.diplom.repositories.WeightJournalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class JournalsService {
    @Autowired
    private CaloriesJournalRepository caloriesJournalRepository;

    @Autowired
    private DistanceJournalRepository distanceJournalRepository;

    @Autowired
    private StepsJournalRepository stepsJournalRepository;

    @Autowired
    private WeightJournalRepository weightJournalRepository;


    public List<CaloriesJournalEntity> getCaloriesJournalLastWeek(UserEntity userEntity, Date date) {
        return caloriesJournalRepository.getAllByUserEntityAndDateIsGreaterThanEqualOrderByDateAsc(userEntity, date);
    }

    public void saveNewCaloriesJournal(CaloriesJournalEntity caloriesJournalEntity) {
        caloriesJournalRepository.save(caloriesJournalEntity);
    }

    public List<DistanceJournalEntity> getDistanceJournalLastWeek(UserEntity userEntity, Date date) {
        return distanceJournalRepository.getAllByUserEntityAndDateIsGreaterThanEqualOrderByDateAsc(userEntity, date);
    }

    public void saveNewDistanceJournal(DistanceJournalEntity distanceJournalEntity) {
        distanceJournalRepository.save(distanceJournalEntity);
    }

    public List<StepsJournalEntity> getStepsJournalLastWeek(UserEntity userEntity, Date date) {
        return stepsJournalRepository.getAllByUserEntityAndDateIsGreaterThanEqualOrderByDateAsc(userEntity, date);
    }

    public void saveNewStepsJournal(StepsJournalEntity stepsJournalEntity) {
        stepsJournalRepository.save(stepsJournalEntity);
    }

    public List<WeightJournalEntity> getWeightJournalLastWeek(UserEntity userEntity, Date date) {
        return weightJournalRepository.getAllByUserEntityAndDateIsGreaterThanEqualOrderByDateAsc(userEntity, date);
    }

    public void saveWeightJournal(WeightJournalEntity weightJournalEntity) {
        weightJournalRepository.save(weightJournalEntity);
    }
}
