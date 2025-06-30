package com.patrykkrych.bank_app.service;

import com.patrykkrych.bank_app.entity.Account;
import com.patrykkrych.bank_app.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService{

    private AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }


    @Override
    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    @Override
    public Account findById(String theId) {

        Optional<Account> result = accountRepository.findById(theId);

        Account theAccount = null;

        if(result.isPresent()){
            theAccount = result.get();
        }
        else {
            throw new RuntimeException("Did not find user id - " + theId);
        }

        return theAccount;
    }

    @Override
    public Account save(Account theAccount) {
        return accountRepository.save(theAccount);
    }

    @Override
    public void deleteById(String theId) {
        accountRepository.deleteById(theId);
    }
}
