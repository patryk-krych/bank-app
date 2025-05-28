package com.patrykkrych.bankapp.repository;

import com.patrykkrych.bankapp.entity.Transaction;

import java.util.List;

public interface TransactionRepository {

    List<Transaction> findAll();

    Transaction findById(int theId);

    Transaction save(Transaction theTransaction);

    void deleteById(int theId);
}
