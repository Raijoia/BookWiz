/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bookwiz.bookwiz;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author rai
 */
public class ConnectionFactory {
    private static String host;
    private static String port;
    private static String user;
    private static String password;
    private static String db;
    
    public static Connection conectar() throws IOException, Exception, SQLException {
        Properties prop = new Properties();
        FileInputStream file = new FileInputStream("./properties/db.properties");
        prop.load(file);
        
        host = prop.getProperty("db.host");
        port = prop.getProperty("db.port");
        user = prop.getProperty("db.user");
        password = prop.getProperty("db.password");
        db = prop.getProperty("db.db");
        
        String connection = String.format(
            "jdbc:mysql://%s:%s/%s", host, port, db
        );
        
        Connection c = DriverManager.getConnection(connection, user, password);
        return c;
    }
}
