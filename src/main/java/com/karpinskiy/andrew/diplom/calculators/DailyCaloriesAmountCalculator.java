package com.karpinskiy.andrew.diplom.calculators;

public class DailyCaloriesAmountCalculator {

    public long calculate(String sex, double weight, double height, double age, int loadFactor) {
        double amountCalories = 0;
        if (sex.equals("Man")) {
            amountCalories = calculateDailyCaloriesForMen(weight, height, age);
        } else {
            amountCalories = calculateDailyCaloriesForWomen(weight, height, age);
        }
        return Math.round(multiplyByLoadFactor(amountCalories, loadFactor));
    }

    private double calculateDailyCaloriesForMen(double weight, double height, double age) {
        return (10 * weight) + (6.25 * height) - (5 * age) + 5;
    }

    private double calculateDailyCaloriesForWomen(double weight, double height, double age) {
        return (10 * weight) + (6.25 * height) - (5 * age) - 161;
    }

    private double multiplyByLoadFactor(double amountCalories, int loadFactor) {
        if (loadFactor == 0) {
            return amountCalories;
        } else if (loadFactor == 1) {
            return amountCalories * 1.2;
        } else if (loadFactor == 2) {
            return amountCalories * 1.375;
        } else if (loadFactor == 3) {
            return amountCalories * 1.55;
        } else if (loadFactor == 4) {
            return amountCalories * 1.725;
        } else {
            return amountCalories * 1.9;
        }
    }
}
