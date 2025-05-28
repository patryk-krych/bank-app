package com.patrykkrych.bankapp.repository;

import com.patrykkrych.bankapp.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private EntityManager entityManager;

    public UserRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<User> findAll() {
        TypedQuery<User> query = entityManager.createQuery("FROM User", User.class);

        List<User> users = query.getResultList();

        return users;
    }

    @Override
    public User findById(int theId) {
        User theUser = entityManager.find(User.class, theId);

        return theUser;
    }

    @Override
    public User save(User theUser) {
        User dbUser = entityManager.merge(theUser);

        return dbUser;
    }

    @Override
    public void deleteById(int theId) {
        User theUser = entityManager.find(User.class, theId);

        entityManager.remove(theUser);
    }
}
