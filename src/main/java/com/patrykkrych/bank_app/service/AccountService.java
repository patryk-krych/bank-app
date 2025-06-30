package com.patrykkrych.bank_app.service;

import com.patrykkrych.bank_app.entity.Account;

import java.util.List;

public interface AccountService {

    List<Account> findAll();

    Account findById(String theId);

    Account save(Account theAccount);

    void deleteById(String theId);
}
