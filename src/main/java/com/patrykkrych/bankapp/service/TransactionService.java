package com.patrykkrych.bankapp.service;

import com.patrykkrych.bankapp.entity.Transaction;

import java.util.List;

public interface TransactionService {

    List<Transaction> findAll();

    Transaction findById(int theId);

    Transaction save(Transaction theTransaction);

    void deleteById(int theId);
}
