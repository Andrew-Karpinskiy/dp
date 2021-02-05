package com.karpinskiy.andrew.diplom.calculators;

public class DailyCaloriesAmountCalculator {

    public long calculate(String gender, double weight, double height, double age, String loadFactor) {
        double amountCalories;
        if (gender.equals("Man")) {
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

    private double multiplyByLoadFactor(double amountCalories, String loadFactor) {
        switch (loadFactor) {
            case "No coefficient":
                return amountCalories;
            case "Minimum":
                return amountCalories * 1.2;
            case "Low":
                return amountCalories * 1.375;
            case "Average":
                return amountCalories * 1.55;
            case "High":
                return amountCalories * 1.725;
            default:
                return amountCalories * 1.9;
        }
    }
}
