package com.karpinskiy.andrew.diplom.calculators;

public class IdealWeightCalculator {

    public double calculate(double height, String sex) {
        if (sex.equals("Man")) {
            return calculateIdealWeightForMen(height);
        } else {
            return calculateIdealWeightForWomen(height);
        }
    }

    private double calculateIdealWeightForMen(double height) {
        return 0.713 * height - 58.0;
    }

    private double calculateIdealWeightForWomen(double height) {
        return 0.624 * height - 48.9;
    }
}
