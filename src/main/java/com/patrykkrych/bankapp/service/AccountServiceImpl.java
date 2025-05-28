package com.patrykkrych.bankapp.service;

import com.patrykkrych.bankapp.entity.Account;
import com.patrykkrych.bankapp.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

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
    public Account findById(int theId) {
        return accountRepository.findById(theId);
    }

    @Override
    public Account save(Account theAccount) {
        return accountRepository.save(theAccount);
    }

    @Override
    public void deleteById(int theId) {
        accountRepository.deleteById(theId);
    }
}
