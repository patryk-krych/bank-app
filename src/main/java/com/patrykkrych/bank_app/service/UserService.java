package com.patrykkrych.bank_app.service;

import com.patrykkrych.bank_app.entity.User;

import java.util.List;

public interface UserService {

    List<User> findAll();

    User findById(int theId);

    User save(User theUser);

    void deleteById(int theId);
}
