/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.congnghephanmem.DAO;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vu
 */
public class DBConnection {
       public static Connection getConnection() {
        String driver = "com.mysql.cj.jdbc.Driver";
        String dbURL="jdbc:mysql://localhost:3306/cnpm?zeroDateTimeBehavior=CONVERT_TO_NULL";
        String username= "root";
        String password="qwerty";
        try {
            Class.forName(driver);
            return DriverManager.getConnection(dbURL, username, password);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
