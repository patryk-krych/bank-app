package com.patrykkrych.bankapp.rest;

import com.patrykkrych.bankapp.entity.Transaction;
import com.patrykkrych.bankapp.service.TransactionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TransactionRestController {

    private TransactionService transactionService;

    public TransactionRestController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/transactions")
    public List<Transaction> findAll(){
        return transactionService.findAll();
    }

    @GetMapping("/transactions/{transactionId}")
    public Transaction findById(@PathVariable int transactionId){
        Transaction transaction = transactionService.findById(transactionId);

        return transaction;
    }

    @PostMapping("/transactions")
    public Transaction saveTransaction(@RequestBody Transaction theTransaction){

        theTransaction.setId(0);
        Transaction dbTransaction = transactionService.save(theTransaction);

        return dbTransaction;
    }

    @PutMapping("/transactions")
    public Transaction updateTransaction(@RequestBody Transaction theTransaction){

        Transaction dbTransaction = transactionService.save(theTransaction);

        return dbTransaction;
    }

    @DeleteMapping("/transaction/{transactionId}")
    public String deleteTransaction(@PathVariable int transactionId){

        Transaction tempTransaction = transactionService.findById(transactionId);

        transactionService.deleteById(transactionId);

        return "Deleted Transaction: " + transactionId;

    }
}
