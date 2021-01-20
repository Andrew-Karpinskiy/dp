package com.karpinskiy.andrew.diplom.controllers;

import com.karpinskiy.andrew.diplom.calculators.BodyMassIndexCalculator;
import com.karpinskiy.andrew.diplom.calculators.DailyCaloriesAmountCalculator;
import com.karpinskiy.andrew.diplom.calculators.DailyWaterRequirementCalculator;
import com.karpinskiy.andrew.diplom.calculators.IdealWeightCalculator;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;

@RestController
public class CalculatorsController {


    @RequestMapping(value = "/calculators/bmi/{weight}/{height}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map getBodyMassIndex(@PathVariable("weight") double weight, @PathVariable("height") double height) {
        BodyMassIndexCalculator bodyMassIndexCalculator = new BodyMassIndexCalculator();
        double index = bodyMassIndexCalculator.calculateBmi(weight, height);
        String evaluateBmiIndex = bodyMassIndexCalculator.evaluateBmiIndex(index);
        return Collections.singletonMap("response", index + " " + evaluateBmiIndex);
    }

    @RequestMapping(value = "/calculators/dwr/{weight}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map getDailyWaterRequirement(@PathVariable("weight") double weight) {
        DailyWaterRequirementCalculator dailyWaterRequirementCalculator = new DailyWaterRequirementCalculator();
        double amount = dailyWaterRequirementCalculator.calculateDailyWaterRequirement(weight);
        return Collections.singletonMap("response", amount);
    }

    @RequestMapping(value = "/calculators/iw/{sex}/{height}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map getIdealWeight(@PathVariable("sex") String sex, @PathVariable("height") double height) {
        IdealWeightCalculator idealWeightCalculator = new IdealWeightCalculator();
        double result = idealWeightCalculator.calculate(height, sex);
        return Collections.singletonMap("response", result);
    }

    @RequestMapping(value = "/calculators/dcm/{sex}/{weight}/{height}/{age}/{load}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map getDailyCaloriesAmount(@PathVariable("sex") String sex, @PathVariable("weight") double weight,
                                      @PathVariable("height") double height, @PathVariable("age") double age,
                                      @PathVariable("load") int loadFactor) {
        DailyCaloriesAmountCalculator dailyCaloriesAmountCalculator = new DailyCaloriesAmountCalculator();
        long amount = dailyCaloriesAmountCalculator.calculate(sex, weight, height, age, loadFactor);
        return Collections.singletonMap("response", amount);
    }

}
