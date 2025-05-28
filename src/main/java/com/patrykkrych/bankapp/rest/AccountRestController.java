package com.patrykkrych.bankapp.rest;

import com.patrykkrych.bankapp.entity.Account;
import com.patrykkrych.bankapp.service.AccountService;
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

    @GetMapping("/accounts/{id}")
    public Account findById(@PathVariable int id){
        Account account = accountService.findById(id);
        return account;
    }

    @PostMapping("/accounts")
    public Account addAccount(@RequestBody Account theAccount){

        theAccount.setId(0);
        Account dbAccount = accountService.save(theAccount);

        return dbAccount;
    }

    @PutMapping("/accounts")
    public Account updateAccount(@RequestBody Account theAccount){
        Account dbAccount = accountService.save(theAccount);

        return dbAccount;
    }

    @DeleteMapping("/accounts/{theId}")
    public String deleteAccount(@PathVariable int theId){

        Account tempAccout = accountService.findById(theId);

        accountService.deleteById(theId);

        return "Deleted account with id: " + theId;
    }

}
