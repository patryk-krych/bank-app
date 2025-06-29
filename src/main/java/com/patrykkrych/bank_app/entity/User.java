package com.patrykkrych.bank_app.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="password")
    private String password;

    @Column(name="first_name")
    private String firstName;

    @Column(name="second_name")
    private String secondName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="birthday")
    private LocalDate birthday;

    public User() {}

    public User(String password, String firstName, String secondName, String lastName, LocalDate birthday) {
        this.password = password;
        this.firstName = firstName;
        this.secondName = secondName;
        this.lastName = lastName;
        this.birthday = birthday;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }
}
