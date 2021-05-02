package com.karpinskiy.andrew.diplom.controllers;

import com.karpinskiy.andrew.diplom.controllers.requests.JournalsSaveRequest;
import com.karpinskiy.andrew.diplom.controllers.response.JournalResponse;
import com.karpinskiy.andrew.diplom.entitys.*;
import com.karpinskiy.andrew.diplom.services.JournalsService;
import com.karpinskiy.andrew.diplom.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class JournalsController {

    private static final String USER_EMAIL = "andrew_karpinskiy@gmail.com";
    @Autowired
    private UserService userService;
    @Autowired
    private JournalsService journalsService;

    @RequestMapping(value = "/journals/steps", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public JournalResponse saveStepsJournal(@RequestBody JournalsSaveRequest journalsSaveRequest) {
        StepsJournalEntity stepsJournalEntity = new StepsJournalEntity();
        UserEntity userEntity = userService.findByEmail(USER_EMAIL);
        Date date = new Date(journalsSaveRequest.getDate());
        stepsJournalEntity.setDate(date);
        stepsJournalEntity.setUserEntity(userEntity);
        stepsJournalEntity.setStepsAmount(Integer.parseInt(journalsSaveRequest.getAmount()));
        journalsService.saveNewStepsJournal(stepsJournalEntity);
        return new JournalResponse("OK");
    }

    @RequestMapping(value = "/journals/calories", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public JournalResponse saveCaloriesJournal(@RequestBody JournalsSaveRequest journalsSaveRequest) {
        CaloriesJournalEntity caloriesJournalEntity = new CaloriesJournalEntity();
        UserEntity userEntity = userService.findByEmail(USER_EMAIL);
        Date date = new Date(journalsSaveRequest.getDate());
        caloriesJournalEntity.setDate(date);
        caloriesJournalEntity.setUserEntity(userEntity);
        caloriesJournalEntity.setCaloriesAmount(Integer.parseInt(journalsSaveRequest.getAmount()));
        journalsService.saveNewCaloriesJournal(caloriesJournalEntity);
        return new JournalResponse("OK");
    }

    @RequestMapping(value = "/journals/distance", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public JournalResponse saveDistanceJournal(@RequestBody JournalsSaveRequest journalsSaveRequest) {
        DistanceJournalEntity distanceJournalEntity = new DistanceJournalEntity();
        UserEntity userEntity = userService.findByEmail(USER_EMAIL);
        Date date = new Date(journalsSaveRequest.getDate());
        distanceJournalEntity.setDate(date);
        distanceJournalEntity.setUserEntity(userEntity);
        distanceJournalEntity.setDistanceAmount(Integer.parseInt(journalsSaveRequest.getAmount()));
        journalsService.saveNewDistanceJournal(distanceJournalEntity);
        return new JournalResponse("OK");
    }

    @RequestMapping(value = "/journals/weight", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public JournalResponse saveWeightJournal(@RequestBody JournalsSaveRequest journalsSaveRequest) {
        WeightJournalEntity weightJournalEntity = new WeightJournalEntity();
        UserEntity userEntity = userService.findByEmail(USER_EMAIL);
        Date date = new Date(journalsSaveRequest.getDate());
        weightJournalEntity.setDate(date);
        weightJournalEntity.setUserEntity(userEntity);
        weightJournalEntity.setWeight(Double.parseDouble(journalsSaveRequest.getAmount()));
        journalsService.saveWeightJournal(weightJournalEntity);
        return new JournalResponse("OK");
    }

    @RequestMapping(value = "/journals/get/steps", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public JournalResponse getStepsJournal(@RequestBody JournalsSaveRequest journalsSaveRequest) {
        UserEntity userFromDb = userService.findByEmail(USER_EMAIL);
        Date date = new Date(journalsSaveRequest.getDate());
        System.out.println("DATE : " + date.toString());
        System.out.println("userFromDb : " + userFromDb.getEmail());
        List<StepsJournalEntity> stepsJournalEntities = journalsService.getStepsJournalLastWeek(userFromDb, date);
        System.out.println("stepsJournalEntities : " + stepsJournalEntities.toString());
        Map<String, String> journalMap = new HashMap<>();
        for (StepsJournalEntity sje : stepsJournalEntities) {
            journalMap.put(String.valueOf(sje.getDate()), String.valueOf(sje.getStepsAmount()));
        }
        System.out.println("journalMap : " + journalMap.toString());
        return new JournalResponse(journalMap);
    }

    @RequestMapping(value = "/journals/get/weight", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public JournalResponse getWeightJournal(@RequestBody JournalsSaveRequest journalsSaveRequest) {
        UserEntity userFromDb = userService.findByEmail(USER_EMAIL);
        Date date = new Date(journalsSaveRequest.getDate());
        List<WeightJournalEntity> weightJournalEntities = journalsService.getWeightJournalLastWeek(userFromDb, date);
        Map<String, String> journalMap = new HashMap<>();
        for (WeightJournalEntity sje : weightJournalEntities) {
            journalMap.put(String.valueOf(sje.getDate()), String.valueOf(sje.getWeight()));
        }
        return new JournalResponse(journalMap);
    }

    @RequestMapping(value = "/journals/get/calories", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public JournalResponse getCaloriesJournal(@RequestBody JournalsSaveRequest journalsSaveRequest) {
        UserEntity userFromDb = userService.findByEmail(USER_EMAIL);
        Date date = new Date(journalsSaveRequest.getDate());
        List<CaloriesJournalEntity> caloriesJournalEntities = journalsService.getCaloriesJournalLastWeek(userFromDb, date);
        Map<String, String> journalMap = new HashMap<>();
        for (CaloriesJournalEntity sje : caloriesJournalEntities) {
            journalMap.put(String.valueOf(sje.getDate()), String.valueOf(sje.getCaloriesAmount()));
        }
        return new JournalResponse(journalMap);
    }

    @RequestMapping(value = "/journals/get/distance", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public JournalResponse getDistanceJournal(@RequestBody JournalsSaveRequest journalsSaveRequest) {
        UserEntity userFromDb = userService.findByEmail(USER_EMAIL);
        Date date = new Date(journalsSaveRequest.getDate());
        List<DistanceJournalEntity> distanceJournalEntities = journalsService.getDistanceJournalLastWeek(userFromDb, date);
        Map<String, String> journalMap = new HashMap<>();
        for (DistanceJournalEntity sje : distanceJournalEntities) {
            journalMap.put(String.valueOf(sje.getDate()), String.valueOf(sje.getDistanceAmount()));
        }
        return new JournalResponse(journalMap);
    }
}
