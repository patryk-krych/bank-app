package com.patrykkrych.bankapp.repository;

import com.patrykkrych.bankapp.entity.Account;

import java.util.List;

public interface AccountRepository {

    List<Account> findAll();

    Account findById(int theId);

    Account save(Account theAccount);

    void deleteById(int theId);
}
