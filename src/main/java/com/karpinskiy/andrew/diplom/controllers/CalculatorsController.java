package com.karpinskiy.andrew.diplom.controllers;

import com.karpinskiy.andrew.diplom.calculators.BodyMassIndexCalculator;
import com.karpinskiy.andrew.diplom.calculators.DailyCaloriesAmountCalculator;
import com.karpinskiy.andrew.diplom.calculators.DailyWaterAmountCalculator;
import com.karpinskiy.andrew.diplom.calculators.IdealWeightCalculator;
import com.karpinskiy.andrew.diplom.controllers.requests.CalculatorsRequest;
import com.karpinskiy.andrew.diplom.controllers.response.CalculatorsResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class CalculatorsController {

    @RequestMapping(value = "/calculators/bmi", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public CalculatorsResponse getBodyMassIndex(@RequestBody CalculatorsRequest calculatorsRequest) {
        BodyMassIndexCalculator bodyMassIndexCalculator = new BodyMassIndexCalculator();
        double index = bodyMassIndexCalculator.calculateBmi(calculatorsRequest.getWeight(), calculatorsRequest.getHeight());
        String evaluateBmiIndex = bodyMassIndexCalculator.evaluateBmiIndex(index);
        return new CalculatorsResponse(index, evaluateBmiIndex);
    }

    @RequestMapping(value = "/calculators/dwr", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public CalculatorsResponse getDailyWaterRequirement(@RequestBody CalculatorsRequest calculatorsRequest) {
        DailyWaterAmountCalculator dailyWaterAmountCalculator = new DailyWaterAmountCalculator();
        double amount = dailyWaterAmountCalculator.calculateDailyWaterRequirement(calculatorsRequest.getWeight());
        return new CalculatorsResponse(amount);
    }

    @RequestMapping(value = "/calculators/iw", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public CalculatorsResponse getIdealWeight(@RequestBody CalculatorsRequest calculatorsRequest) {
        IdealWeightCalculator idealWeightCalculator = new IdealWeightCalculator();
        double result = idealWeightCalculator.calculate(calculatorsRequest.getHeight(), calculatorsRequest.getGender());
        return new CalculatorsResponse(result);
    }

    @RequestMapping(value = "/calculators/dcm", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public CalculatorsResponse getDailyCaloriesAmount(@RequestBody CalculatorsRequest calculatorsRequest) {
        DailyCaloriesAmountCalculator dailyCaloriesAmountCalculator = new DailyCaloriesAmountCalculator();
        long amount = dailyCaloriesAmountCalculator.calculate(calculatorsRequest.getGender(), calculatorsRequest.getWeight(),
                calculatorsRequest.getHeight(), calculatorsRequest.getAge(), calculatorsRequest.getLoadFactor());
        return new CalculatorsResponse(amount);
    }

}
