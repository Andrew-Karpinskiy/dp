package com.karpinskiy.andrew.diplom.calculators;

public class BodyMassIndexCalculator {

    public double calculateBmi(double weight, double height) {
        if (height == 0) {
            return 0;
        }
        height = height / 100;
        return weight / Math.pow(height, 2);
    }

    public String evaluateBmiIndex(double index) {
        if (index <= 15) {
            return "Сильна недостатність";
        }
        if (index >= 16 && index < 18.5) {
            return "Недостатня вага";
        }
        if (index >= 18.5 && index < 25) {
            return "Норма";
        }
        if (index >= 25 && index < 30) {
            return "Надмірна вага";
        }
        if (index >= 30 && index < 35) {
            return "Ожиріння";
        }
        if (index >= 35 && index < 40) {
            return "Гостре ожиріння";
        }
        if (index >= 40) {
            return "Дуже важке ожиріння";
        }
        return null;
    }

}
