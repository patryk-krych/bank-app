package com.patrykkrych.bankapp.service;

import com.patrykkrych.bankapp.entity.Transaction;
import com.patrykkrych.bankapp.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl  implements TransactionService{

    private TransactionRepository transactionRepository;

    @Autowired
    public TransactionServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }
    @Override
    public List<Transaction> findAll() {
        return transactionRepository.findAll();
    }

    @Override
    public Transaction findById(int theId) {
        return transactionRepository.findById(theId);
    }

    @Override
    public Transaction save(Transaction theTransaction) {
        return transactionRepository.save(theTransaction);
    }

    @Override
    public void deleteById(int theId) {
        transactionRepository.deleteById(theId);
    }
}
