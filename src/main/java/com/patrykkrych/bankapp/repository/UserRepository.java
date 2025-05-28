package com.patrykkrych.bankapp.repository;

import com.patrykkrych.bankapp.entity.User;

import java.util.List;

public interface UserRepository {

    List<User> findAll();

    User findById(int theId);

    User save(User theUser);

    void deleteById(int theId);
}
