/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dbmanager;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author PPiC
 */
public class DBManager {

    private static final String CREATE_TABLE = "CREATE TABLE IF NOT EXISTS save (cod int auto_increment primary key, room Varchar(20) )";
    private static Connection conn;

    public static void createTable() {
        try {
            conn = ConnectionDB.connectToDB();
            Statement stm = conn.createStatement();
            stm.executeUpdate(CREATE_TABLE);
            stm.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
