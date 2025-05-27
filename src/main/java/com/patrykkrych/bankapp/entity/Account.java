package com.patrykkrych.bankapp.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name="account_number")
    private int accountNumber;

    @Column(name="balance")
    private Double balance;

    @Column(name="currency")
    private String currency;

    @Column(name="created_at")
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "fromAccount")
    private List<Transaction> sentTransactions = new ArrayList<>();

    @OneToMany(mappedBy = "toAccount")
    private List<Transaction> receivedTransactions = new ArrayList<>();

    public Account() {

    }


}
