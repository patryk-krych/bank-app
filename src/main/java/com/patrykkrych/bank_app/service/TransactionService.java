package com.patrykkrych.bank_app.service;

import com.patrykkrych.bank_app.entity.Transaction;

import java.util.List;

public interface TransactionService {

    List<Transaction> findAll();

    Transaction findById(int theId);

    Transaction save(Transaction theTransaction);

    void deleteById(int theId);

}
