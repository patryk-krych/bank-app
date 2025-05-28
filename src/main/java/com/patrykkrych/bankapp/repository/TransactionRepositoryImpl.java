package com.patrykkrych.bankapp.repository;

import com.patrykkrych.bankapp.entity.Transaction;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TransactionRepositoryImpl implements TransactionRepository {

    private EntityManager entityManager;

    public TransactionRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Transaction> findAll() {
        TypedQuery<Transaction> query = entityManager.createQuery("FROM Transaction", Transaction.class);

        List<Transaction> transactions = query.getResultList();

        return transactions;
    }

    @Override
    public Transaction findById(int theId) {
        Transaction theTransaction = entityManager.find(Transaction.class, theId);

        return theTransaction;
    }

    @Override
    public Transaction save(Transaction theTransaction) {
        Transaction dbTransaction = entityManager.merge(theTransaction);

        return dbTransaction;
    }

    @Override
    public void deleteById(int theId) {
        Transaction theTransaction = entityManager.find(Transaction.class, theId);

        entityManager.remove(theTransaction);
    }
}
