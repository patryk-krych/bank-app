package com.patrykkrych.bank_app.repository;

import com.patrykkrych.bank_app.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction,Integer> {
}
