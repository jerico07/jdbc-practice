/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.java.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author User
 */
public class Database {
    
    //Integer.parseInt("ada") -> 1 thorws NFE
    /*
    functionA () {
        try catch
    }
    */
    
    static {
        try {
            config("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/practice?zeroDateTimeBehavior=convertToNull", "root", "password");
        } catch (ClassNotFoundException ex) {
            
        }
    }
    
    private static String url; 
    
    //jdbc:<db vendor>://<db ip address>:<port>/<db name> <-- format
    //jdbc:mysql:localhost:3306/practice <-- yung gagamitin natin
    
    /*
    private static Properties prop;
    
    public static void config(String driverName, String url, String username, String password) throws ClassNotFoundException {
        Class.forName(driverName);
        Database.url = url;
        Properties prop = new Properties();
        prop.setProperty("user", username); //kailangan 'user' lagi yung string para marecognize ng jdbc as username
        prop.setProperty("password", password); //kailangan 'password' para marecognize din as password
        //pag iba kahit isa lang, matatanga yung jdbc
    }
    */
    
    private static String username, password;
    
    public static void config(String driverName, String url, String username, String password) throws ClassNotFoundException {
        Class.forName(driverName);
        Database.url = url;
        Database.username = username;
        Database.password = password;
        //pag iba kahit isa lang, matatanga yung jdbc
    }
    
    public static Connection getConnection() throws SQLException {
        //return DriverManager.getConnection(url, prop);
        return DriverManager.getConnection(url, username, password);
    }
    
}
