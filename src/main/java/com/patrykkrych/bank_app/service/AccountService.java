package com.patrykkrych.bank_app.service;

import com.patrykkrych.bank_app.entity.Account;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AccountService {

    List<Account> findAll();

    Account findById(int theId);

    Account save(Account theAccount);

    void deleteById(int theId);
}
