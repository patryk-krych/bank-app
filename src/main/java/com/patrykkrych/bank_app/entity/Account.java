package com.patrykkrych.bank_app.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name="accounts")
public class Account {

    @Id
    @Column(name="account_id")
    private String accountId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name="currency")
    private String currency;

    @Column(name="balance")
    private BigDecimal balance;

    @OneToMany(mappedBy = "fromAccount")
    private List<Transaction> outgoingTransactions;

    @OneToMany(mappedBy = "toAccount")
    private List<Transaction> incomingTransactions;


    public Account() {}

    public Account(String accountId, User user, String currency, BigDecimal balance) {
        this.accountId = accountId;
        this.user = user;
        this.currency = currency;
        this.balance = balance;
    }


    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public List<Transaction> getOutgoingTransactions() {
        return outgoingTransactions;
    }

    public void setOutgoingTransactions(List<Transaction> outgoingTransactions) {
        this.outgoingTransactions = outgoingTransactions;
    }

    public List<Transaction> getIncomingTransactions() {
        return incomingTransactions;
    }

    public void setIncomingTransactions(List<Transaction> incomingTransactions) {
        this.incomingTransactions = incomingTransactions;
    }
}
