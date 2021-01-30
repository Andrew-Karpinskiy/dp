package com.karpinskiy.andrew.diplom.calculators;

public class BodyMassIndexCalculator {

    public double calculateBmi(double bodyMass, double bodyGrowth) {
        if (bodyGrowth == 0) {
            return 0;
        }
        bodyGrowth = bodyGrowth / 100;
        return bodyMass / Math.pow(bodyGrowth, 2);
    }

    public String evaluateBmiIndex(double index) {
        if (index <= 15) {
            return "Severe underweight";
        }
        if (index >= 16 && index < 18.5) {
            return "Underweight";
        }
        if (index >= 18.5 && index < 25) {
            return "Norm";
        }
        if (index >= 25 && index < 30) {
            return "Overweight (pre obesity)";
        }
        if (index >= 30 && index < 35) {
            return "Obesity";
        }
        if (index >= 35 && index < 40) {
            return "Acute obesity";
        }
        if (index >= 40) {
            return "Very severe obesity";
        }
        return null;
    }

}
