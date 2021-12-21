/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mthree.cardealership.entity;

/**
 *
 * @author yond1
 */
public class User {
    /*
    create table `user`(
	userID int primary key,
	FirstName varchar(50),
    LastName varchar(50),
    `Role` int
    );
    */
    private int userId;
    private String firstName;
    private String lastName;
    private int role;

    public User() {
    }

    public User(int userId, String firstName, String lastName, int role) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
    
}
