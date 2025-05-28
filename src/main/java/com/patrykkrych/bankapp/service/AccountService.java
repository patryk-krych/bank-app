package com.patrykkrych.bankapp.service;

import com.patrykkrych.bankapp.entity.Account;

import java.util.List;

public interface AccountService {
    List<Account> findAll();

    Account findById(int theId);

    Account save(Account theAccount);

    void deleteById(int theId);
}
