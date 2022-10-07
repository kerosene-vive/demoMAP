/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dbmanager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author PPiC
 */
public class ConnectionDB {
    
    private static Connection conn;
    
    /**
     * connection to the game DB, return the connection obj
     * @return conn
     */
    public static Connection connectToDB() {
        try {
            Properties dbProps = new Properties();
            dbProps.setProperty("user", "user");
            dbProps.setProperty("password", "1234");
            conn = DriverManager.getConnection("jdbc:h2:./resources/db/oracle", dbProps);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

}
