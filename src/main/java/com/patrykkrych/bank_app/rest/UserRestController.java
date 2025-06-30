package com.patrykkrych.bank_app.rest;


import com.patrykkrych.bank_app.entity.User;
import com.patrykkrych.bank_app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserRestController {

    private UserService userService;

    @Autowired
    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("/users/{userId}")
    public User getUser(@PathVariable int userId) {

        User theUser = userService.findById(userId);

        if (theUser == null) {
            throw new RuntimeException("Employee id not found - " + userId);
        }

        return theUser;
    }

    @PostMapping("/users")
    public User addUser(@RequestBody User theUser) {

        theUser.setId(0);
        User dbUser = userService.save(theUser);

        return dbUser;
    }

    @PutMapping("/users")
    public User updateUser(@RequestBody User theUser) {

        User dbUser = userService.save(theUser);

        return dbUser;
    }

    @DeleteMapping("/users/{userId}")
    public String deleteUser(@PathVariable int userId) {

        User tempUser = userService.findById(userId);

        if (tempUser == null) {
            throw new RuntimeException("User id not found - " + userId);
        }

        userService.deleteById(userId);

        return "Deleted user with id - " + userId;
    }

}
