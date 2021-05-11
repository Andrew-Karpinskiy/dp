package com.karpinskiy.andrew.diplom.controllers.response;

public class CalculatorsResponse {
    private double result;
    private String message;

    public CalculatorsResponse(double result) {
        this.result = result;
    }

    public CalculatorsResponse(double result, String message) {
        this.result = result;
        this.message = message;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
