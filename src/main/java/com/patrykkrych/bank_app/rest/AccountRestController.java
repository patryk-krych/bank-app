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

    private final UserService userService;
    private AccountService accountService;

    @Autowired
    public AccountRestController(AccountService accountService, UserService userService) {
        this.accountService = accountService;
        this.userService = userService;
    }

    @GetMapping("/accounts")
    public List<Account> findAll(){
        return accountService.findAll();
    }

    @GetMapping("/accounts/{accountId}")
    public Account getAccount(@PathVariable int accountId){
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

    @PutMapping("/users")
    public Account updateAccount(@RequestBody Account theAccount){
        Account dbAccount = accountService.save(theAccount);

        return dbAccount;
    }

    @DeleteMapping("/users/{userId}")
    public String deleteAccount(@PathVariable int userId){

        Account tempAccout = accountService.findById(userId);

        if(tempAccout==null){
            throw new RuntimeException("Account with id - " + userId + " not found");
        }

        userService.deleteById(userId);

        return "Account with id - " + userId + " deleted";
    }








}
