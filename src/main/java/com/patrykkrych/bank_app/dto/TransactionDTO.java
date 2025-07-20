package com.patrykkrych.bank_app.dto;

import com.patrykkrych.bank_app.entity.Account;
import jakarta.persistence.*;

import java.time.OffsetDateTime;

public class TransactionDTO {

    private String fromAccount;
    private String toAccount;
    private double amount;
    private String currency;
    private OffsetDateTime date;
    private String title;

    public TransactionDTO() {}

    public TransactionDTO(String fromAccount, String toAccount, double amount, String currency, OffsetDateTime date, String title) {
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.amount = amount;
        this.currency = currency;
        this.date = date;
        this.title = title;
    }

    public String getFromAccount() {
        return fromAccount;
    }

    public void setFromAccount(String fromAccount) {
        this.fromAccount = fromAccount;
    }

    public String getToAccount() {
        return toAccount;
    }

    public void setToAccount(String toAccount) {
        this.toAccount = toAccount;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public OffsetDateTime getDate() {
        return date;
    }

    public void setDate(OffsetDateTime date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
