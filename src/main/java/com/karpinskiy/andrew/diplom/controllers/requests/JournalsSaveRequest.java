package com.karpinskiy.andrew.diplom.controllers.requests;

import lombok.Data;

@Data
public class JournalsSaveRequest {
    private String amount;

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
