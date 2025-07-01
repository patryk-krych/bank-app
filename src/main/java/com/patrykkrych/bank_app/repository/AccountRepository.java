package com.patrykkrych.bank_app.repository;

import com.patrykkrych.bank_app.entity.Account;
import com.patrykkrych.bank_app.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, String> {
    List<Account> findByUser(User user);
}
