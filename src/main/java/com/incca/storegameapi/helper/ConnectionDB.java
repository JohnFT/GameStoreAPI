/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.incca.storegameapi.helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Home
 */
public class ConnectionDB {

    private static final String HOST = "jdbc:postgresql://localhost:5432/storegames";
    private static final String USER = "jfonseca";
    private static final String PASS = "root";
    private Connection connection;

    public ConnectionDB() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Connection getConnection() {
        try {
            return connection = DriverManager.getConnection(HOST, USER, PASS);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public void close() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException ex) {
                Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
