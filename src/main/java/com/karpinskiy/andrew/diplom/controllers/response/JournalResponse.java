package com.karpinskiy.andrew.diplom.controllers.response;

public class JournalResponse {
    private String message;

    public JournalResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}