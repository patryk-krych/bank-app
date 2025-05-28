package com.patrykkrych.bankapp.repository;

import com.patrykkrych.bankapp.entity.Account;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AccountRepositoryImpl implements AccountRepository {

    private EntityManager entityManager;

    @Autowired
    public AccountRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Account> findAll() {
        TypedQuery<Account> query = entityManager.createQuery("FROM Account", Account.class);

        List<Account> accounts = query.getResultList();

        return accounts;
    }

    @Override
    public Account findById(int theId) {
        Account account = entityManager.find(Account.class, theId);

        return account;
    }

    @Override
    public Account save(Account theAccount) {
        Account dbAccount = entityManager.merge(theAccount);

        return dbAccount;
    }

    @Override
    public void deleteById(int theId) {
        Account theAccount = entityManager.find(Account.class, theId);

        entityManager.remove(theAccount);
    }
}
