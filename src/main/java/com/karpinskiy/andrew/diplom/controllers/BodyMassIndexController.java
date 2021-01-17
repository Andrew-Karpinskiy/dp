package com.karpinskiy.andrew.diplom.controllers;

import com.karpinskiy.andrew.diplom.calculators.BodyMassIndexCalculator;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
public class BodyMassIndexController {


    @RequestMapping(value = "/bmi", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Map auth() {
        BodyMassIndexCalculator bodyMassIndexCalculator = new BodyMassIndexCalculator();
        double res = bodyMassIndexCalculator.calculateBmi(77, 1.70);
        String ress = bodyMassIndexCalculator.evaluateBmiIndex(res);
        return Collections.singletonMap("response", res + " " + ress);
    }
}
