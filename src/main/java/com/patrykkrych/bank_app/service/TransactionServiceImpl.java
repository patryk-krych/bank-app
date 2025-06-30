package com.patrykkrych.bank_app.service;

import com.patrykkrych.bank_app.entity.Transaction;
import com.patrykkrych.bank_app.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionServiceImpl implements TransactionService {

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

        Optional<Transaction> result = transactionRepository.findById(theId);

        Transaction theTransaction = null;

        if (result.isPresent()) {
            theTransaction = result.get();
        }
        else {
            throw new RuntimeException("Did not find transaction id - " + theId);
        }

        return theTransaction;
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
