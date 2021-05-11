package com.karpinskiy.andrew.diplom.calculators;

public class DailyCaloriesAmountCalculator {

    public long calculate(String gender, double weight, double height, double age, String loadFactor) {
        double amountCalories;
        if (gender.equals("Чоловіча")) {
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
            case "Відсутній":
                return amountCalories;
            case "Мінімальний":
                return amountCalories * 1.2;
            case "Низький":
                return amountCalories * 1.375;
            case "Середній":
                return amountCalories * 1.55;
            case "Високий":
                return amountCalories * 1.725;
            default:
                return amountCalories * 1.9;
        }
    }
}
