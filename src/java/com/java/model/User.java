/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class User {

    /*
    NONSTATIC
    User userA = new User("user1", "pass"); <---- individual person
    User userB = new User("user2", "pass"); <---- individual din
    
    userA.getUsername(); = user1
    userB.getUsername(); = user2
    
    userB.setUserName("user3");
    
    userA.getUsername(); -> user1
    userB.getUsernae(); -> user3
     */
    private String username, password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    public User(ResultSet rs) throws SQLException {
        this (
                rs.getString("username"),
                rs.getString("password")
        );
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /*
    STATIC
    <classname>.<functionname>
    User.getBurat(); -> burat
    User.setBurat(); -> burat2
    get - > burat2
     */
 /*
    private static String burat = "burat";
    
    private static String getBurat() {
        return burat;
    }
    
    private static void setBurat(String burat) {
        User.burat = burat;
    }
     */
    public static User login(String username, String password) throws WrongPasswordException, WrongUsernameException {
        try (Connection con = Database.getConnection()) {
            try (PreparedStatement stmt = con.prepareStatement("SELECT * FROM accounts WHERE username = ?")) {
                stmt.setString(1, username);
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        if (rs.getString("password").equals(password)) {
                            //return new User(rs.getString("username"), rs.getString("password"));
                            User user = new User(rs);
                            return user;
                        } else {
                            throw new WrongPasswordException();
                        }
                    } else {
                        throw new WrongUsernameException();
                    }
                }
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
    
    public static List<User> listUsers() {
        List<User> results = new ArrayList<>();
        try (Connection con = Database.getConnection()) {
            try (PreparedStatement stmt = con.prepareStatement("SELECT * FROM accounts")) {
                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        results.add(new User(rs));
                    }
                }
                return results;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
}
