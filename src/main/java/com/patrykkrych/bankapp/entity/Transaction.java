package com.patrykkrych.bankapp.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "from_account_id")
    private Account fromAccount;

    @ManyToOne
    @JoinColumn(name = "to_account_id")
    private Account toAccount;

    @Column(name="ammount")
    private Double amount;

    @Column(name="currency")
    private String currency;

    @Column(name="timestamp")
    private LocalDateTime timestamp;

    @Column(name="description")
    private String description;

    @Column(name="type")
    private String type;
}
