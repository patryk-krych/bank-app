package com.patrykkrych.bank_app.entity;

import jakarta.persistence.*;

import java.time.OffsetDateTime;

@Entity
@Table(name="transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @ManyToOne
    @JoinColumn(name="from_account_id")
    private Account fromAccount;

    @ManyToOne
    @JoinColumn(name="to_account_id")
    private Account toAccount;

    @Column(name="amount")
    private double amount;

    @Column(name="currency")
    private String currency;

    @Column(name="date")
    private OffsetDateTime date;

    @Column(name="title")
    private String title;

    public Transaction() {}

    public Transaction(Account fromAccount, Account toAccount, double amount, String currency, OffsetDateTime date, String title) {
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.amount = amount;
        this.currency = currency;
        this.date = date;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Account getFromAccount() {
        return fromAccount;
    }

    public void setFromAccount(Account fromAccount) {
        this.fromAccount = fromAccount;
    }

    public Account getToAccount() {
        return toAccount;
    }

    public void setToAccount(Account toAccount) {
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


