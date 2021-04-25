package com.karpinskiy.andrew.diplom.controllers.requests;

import lombok.Data;

@Data
public class JournalsSaveRequest {
    private String amount;
    private String date;

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
