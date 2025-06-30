package com.patrykkrych.bank_app.rest;


import com.patrykkrych.bank_app.entity.Account;
import com.patrykkrych.bank_app.service.AccountService;
import com.patrykkrych.bank_app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AccountRestController {

    private AccountService accountService;

    @Autowired
    public AccountRestController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/accounts")
    public List<Account> findAll(){
        return accountService.findAll();
    }

    @GetMapping("/accounts/{accountId}")
    public Account getAccount(@PathVariable String accountId){
        Account theAccount= accountService.findById(accountId);

        if(theAccount==null){
            throw new RuntimeException("Account with id - " + accountId + " not found");
        }

        return theAccount;
    }

    @PostMapping("/accounts")
    public Account addAccount(@RequestBody Account theAccount){
        //need to update code with generating Id
        Account dbAccount = accountService.save(theAccount);

        return dbAccount;
    }

    @PutMapping("/accounts")
    public Account updateAccount(@RequestBody Account theAccount){
        Account dbAccount = accountService.save(theAccount);

        return dbAccount;
    }

    @DeleteMapping("/accounts/{accountId}")
    public String deleteAccount(@PathVariable String accountId){

        Account tempAccount = accountService.findById(accountId);

        if(tempAccount==null){
            throw new RuntimeException("Account with id - " + accountId + " not found");
        }

        accountService.deleteById(accountId);

        return "Account with id - " + accountId + " deleted";
    }




}
