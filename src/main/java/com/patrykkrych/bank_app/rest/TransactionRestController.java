package com.patrykkrych.bank_app.rest;


import com.patrykkrych.bank_app.entity.Transaction;
import com.patrykkrych.bank_app.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TransactionRestController {

    private TransactionService transactionService;

    @Autowired
    public TransactionRestController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/transactions")
    public List<Transaction> findAll() {
        return transactionService.findAll();
    }

    @GetMapping("/transactions/{transactionId}")
    public Transaction findById(@PathVariable int  transactionId) {

        Transaction theTransaction = transactionService.findById(transactionId);

        if (theTransaction == null) {
            throw new RuntimeException("Transaction with id - " + transactionId + " not found");
        }

        return theTransaction;
    }

    @PostMapping("/transactions")
    public Transaction addTransaction(@RequestBody Transaction theTransaction) {

        theTransaction.setId(0);
        Transaction dbTransaction =  transactionService.save(theTransaction);

        return dbTransaction;
    }

    @PutMapping("/transactions")
    public Transaction updateTransaction(@RequestBody Transaction theTransaction) {

        Transaction dbTransaction =  transactionService.save(theTransaction);
        return dbTransaction;
    }

    @DeleteMapping("/transactions/{transactionId}")
    public String deleteTransaction(@PathVariable int  transactionId) {

        Transaction dbTransaction  =  transactionService.findById(transactionId);

        if (dbTransaction == null) {
            throw new RuntimeException("Transaction with id - " + transactionId + " not found");
        }

        transactionService.deleteById(transactionId);

        return "Deleted transaction with id - " + transactionId;
    }

}
