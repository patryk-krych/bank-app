package com.patrykkrych.bank_app.repository;

import com.patrykkrych.bank_app.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Integer> {
}
