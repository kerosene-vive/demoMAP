/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package dbmanager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DriverManager;
import java.util.Properties;
import java.util.Set;

import com.example.FRONTEND.frontEnd;
import com.example.GENERIC.direction;
import com.example.GENERIC.gameStatus;
import com.example.GENERIC.item;
import com.example.GENERIC.npc;
import com.example.GENERIC.room;
/**
 *
 * @author PPiC
 */
public class DBTest {

    /**
     * @param args the command line arguments
     */
    public static void save(room currentRoom,Set<room> rooms,Set<npc> npcs,Set<item> items) {
        //ConnectionDB.connectToDB();
        Connection conn =DBTest.connectToDB();
        if (conn != null) {
            deleteTables(conn);
            createTable(conn);
            saveGameStatus(conn, currentRoom, rooms, npcs, items);
            frontEnd.Description("Salvataggio completato, puoi continuare a giocare");
            try {
                conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
     
        } else {
            System.out.println("Failed to make connection!");
        }
    }









    private static void deleteTables(Connection conn) {
        try {
            Statement stmt = conn.createStatement();
            stmt.execute("DROP TABLE IF EXISTS room");
            stmt.execute("DROP TABLE IF EXISTS npc");
            stmt.execute("DROP TABLE IF EXISTS item");
            stmt.execute("DROP TABLE IF EXISTS save");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }









    public static void createTable(Connection conn) {
       //create a table for each type current room etc if they dont'exust already
       try{
        Statement stmt = conn.createStatement();
        String sql = "CREATE TABLE IF NOT EXISTS room " +
                     "(id INTEGER PRIMARY KEY ," +
                     " locked BOOLEAN)"; 
        stmt.executeUpdate(sql);
        stmt.close();
      
       }
         catch(SQLException e)
         {
              System.out.println(e.getMessage());
         }
         try{
        Statement stmt = conn.createStatement();
        String sql = "CREATE TABLE IF NOT EXISTS save " +
                     "(room INTEGER PRIMARY KEY )";
        stmt.executeUpdate(sql);
        stmt.close();
       
         }
            catch(SQLException e)
            {
                  System.out.println(e.getMessage());
            }
            try{ 
        Statement stmt = conn.createStatement();
        String sql = "CREATE TABLE IF NOT EXISTS item " +
                     "(id INTEGER PRIMARY KEY ," +
                     " isItemUsable BOOLEAN," +
                     " itemCurrentRoom INTEGER)";
        stmt.executeUpdate(sql);
        stmt.close();
      
            }
               catch(SQLException e)
               {
                  System.out.println(e.getMessage());
               }
        try{
        Statement stmt = conn.createStatement();
        String sql = "CREATE TABLE IF NOT EXISTS npc " +
                     "(id INTEGER PRIMARY KEY ," +
                     " npcCurrentRoom INTEGER)";
        stmt.executeUpdate(sql);
        stmt.close();
       
        }
           catch(SQLException e)
           {
                  System.out.println(e.getMessage());
           }
   
    }






    public static void saveGameStatus(Connection conn,room currentRoom,Set<room> rooms,Set<npc> npcs,Set<item> items) {

        try {
            Statement stm = conn.createStatement();
            stm.executeUpdate("INSERT INTO save (room) VALUES ('"+currentRoom.getId()+"')");
            stm.close();
           
        
        } catch (SQLException e) {
            e.printStackTrace();
        }

       for (room roomItem : rooms) {
        int roomId=roomItem.getId();
        boolean isLocked=roomItem.isLocked();
        try {
            Statement stm = conn.createStatement();
            stm.executeUpdate("INSERT INTO room (id,locked) VALUES ('"+roomId+"','"+isLocked+"')");
            stm.close();
          
          
        } catch (SQLException e) {
            e.printStackTrace();
        }}


        for (npc npcItem : npcs) {
            int npcId=npcItem.getId();
            int npcCurrentRoom=npcItem.getCurrentRoom().getId();
            try {
                Statement stm = conn.createStatement();
                stm.executeUpdate("INSERT INTO npc (id,npcCurrentRoom) VALUES ('"+npcId+"','"+npcCurrentRoom+"')");
                stm.close();
               
              
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        for (item itemItem : items) {
            int itemId=itemItem.getId();
           
            int itemCurrentRoom=itemItem.getCurrentRoom().getId();
            boolean isItemUsable=itemItem.isUsable();
            try {
                Statement stm = conn.createStatement();
                stm.executeUpdate("INSERT INTO item (id,itemCurrentRoom,isItemUsable) VALUES ('"+itemId+"','"+itemCurrentRoom+"','"+isItemUsable+"')");
                stm.close();
               
              
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
     
       
    }






        //save the game status to the DB
    public static void loadGameStatus(Connection conn) {
        //load current room
        try{
            Statement stm = conn.createStatement();
            stm.executeQuery("SELECT room FROM save");
            System.out.println("the current room is "+stm.toString());
            stm.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        //load rooms
        for(room roomItem : gameStatus.getRooms()){
            int roomId=roomItem.getId();
            try{
                Statement stm = conn.createStatement();
                stm.executeQuery("SELECT locked FROM room WHERE id='"+roomId+"'");
                System.out.println("the room "+roomId+" is locked? "+stm.toString());
                stm.close();
            }
            catch (SQLException e) { 
                e.printStackTrace();
            }
        }
        for(npc npcItem : gameStatus.getNpcs()){
            int npcId=npcItem.getId();
            try{
                Statement stm = conn.createStatement();
                stm.executeQuery("SELECT npcCurrentRoom FROM npc WHERE id='"+npcId+"'");
                System.out.println("the npc "+npcId+" is in room "+stm.toString());
                stm.close();
            }
            catch (SQLException e) { 
                e.printStackTrace();
            }
        }
        for(item itemItem : gameStatus.getItems()){
            int itemId=itemItem.getId();
            try{
                Statement stm = conn.createStatement();
                stm.executeQuery("SELECT itemCurrentRoom,isItemUsable FROM item WHERE id='"+itemId+"'");
                System.out.println("the item "+itemId+" is in room "+stm.toString());
                stm.close();
            }
            catch (SQLException e) { 
                e.printStackTrace();
            }
        }
    }









    public static Connection connectToDB() {
        Connection conn;
        try {
           
            Properties dbProps = new Properties();
            dbProps.setProperty("user", "user");
            dbProps.setProperty("password", "1234");
            conn = DriverManager.getConnection("jdbc:h2:./resources/db/oracle", dbProps);
            return conn;

        } catch (SQLException e) {
            e.printStackTrace();
        }
       return null;
    }


}
