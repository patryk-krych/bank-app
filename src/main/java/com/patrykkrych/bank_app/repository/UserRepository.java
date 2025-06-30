package com.patrykkrych.bank_app.repository;

import com.patrykkrych.bank_app.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
