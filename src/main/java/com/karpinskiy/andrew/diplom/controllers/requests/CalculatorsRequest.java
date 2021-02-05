package com.karpinskiy.andrew.diplom.controllers.requests;

import lombok.Data;

@Data
public class CalculatorsRequest {

    private double weight;
    private double height;
    private String gender;
    private double age;
    private String loadFactor;

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
    }

    public String getLoadFactor() {
        return loadFactor;
    }

    public void setLoadFactor(String loadFactor) {
        this.loadFactor = loadFactor;
    }
}
