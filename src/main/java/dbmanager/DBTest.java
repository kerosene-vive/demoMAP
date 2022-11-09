/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package dbmanager;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;
import com.example.FRONTEND.FrontEnd;
import com.example.GENERIC.Direction;
import com.example.GENERIC.GameStatus;
import com.example.GENERIC.Item;
import com.example.GENERIC.Npc;
import com.example.GENERIC.Room;

/**
 *
 * @author PPiC
 */
public class DBTest {

    /**
     * @param args the command line arguments
     */
    public static void save(Room currentRoom, Set<Room> rooms, Set<Npc> npcs, Set<Item> items) {
        //ConnectionDB.connectToDB();
        Connection conn = DBTest.connectToDB();
        if (conn != null) {
            deleteTables(conn);
            createTable(conn);
            saveGameStatus(conn, currentRoom, rooms, npcs, items);
            FrontEnd.description("Salvataggio completato, puoi continuare a giocare");
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

    public static void load() {
        Connection conn = DBTest.connectToDB();
        if (conn != null) {
            if (checkIfDatabaseEmpty(conn)) {
                loadGameStatus(conn);
                FrontEnd.description("Caricamento completato, puoi continuare a giocare");
            } else {

                FrontEnd.description("Non hai salvato nessuna partita, non posso caricare");
            }

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

    private static boolean checkIfDatabaseEmpty(Connection conn) {

        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM room");
            if (!rs.next()) {

                return false;
            } else {

                return true;
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            return false;
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
        try {
            Statement stmt = conn.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS room "
                    + "(id INTEGER PRIMARY KEY ,"
                    + " locked BOOLEAN)";
            stmt.executeUpdate(sql);
            stmt.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        try {
            Statement stmt = conn.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS save "
                    + "(room INTEGER PRIMARY KEY )";
            stmt.executeUpdate(sql);
            stmt.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        try {
            Statement stmt = conn.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS item "
                    + "(id INTEGER PRIMARY KEY ,"
                    + " isItemUsable BOOLEAN,"
                    + " itemCurrentRoom INTEGER)";
            stmt.executeUpdate(sql);
            stmt.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        try {
            Statement stmt = conn.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS npc "
                    + "(id INTEGER PRIMARY KEY ,"
                    + " npcCurrentRoom INTEGER)";
            stmt.executeUpdate(sql);
            stmt.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void saveGameStatus(Connection conn, Room currentRoom, Set<Room> rooms, Set<Npc> npcs, Set<Item> items) {

        try {
            Statement stm = conn.createStatement();
            stm.executeUpdate("INSERT INTO save (room) VALUES ('" + currentRoom.getId() + "')");
            stm.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        for (Room roomItem : rooms) {
            int roomId = roomItem.getId();
            boolean isLocked = roomItem.isLocked();
            try {
                Statement stm = conn.createStatement();
                stm.executeUpdate("INSERT INTO room (id,locked) VALUES ('" + roomId + "','" + isLocked + "')");
                stm.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        for (Npc npcItem : npcs) {
            int npcId = npcItem.getId();
            int npcCurrentRoom = npcItem.getCurrentRoom().getId();
            try {
                Statement stm = conn.createStatement();
                stm.executeUpdate("INSERT INTO npc (id,npcCurrentRoom) VALUES ('" + npcId + "','" + npcCurrentRoom + "')");
                stm.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        for (Item itemItem : items) {
            int itemId = itemItem.getId();

            int itemCurrentRoom = itemItem.getCurrentRoom().getId();
            boolean isItemUsable = itemItem.isUsable();
            try {
                Statement stm = conn.createStatement();
                stm.executeUpdate("INSERT INTO item (id,itemCurrentRoom,isItemUsable) VALUES ('" + itemId + "','" + itemCurrentRoom + "','" + isItemUsable + "')");
                stm.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    //save the game status to the DB
    public static void loadGameStatus(Connection conn) {
        //load current room

        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT room FROM save");
            while (rs.next()) {
                GameStatus.setCurrentRoom(GameStatus.getRoom(rs.getInt("room")));
            }

            stm.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //load rooms

        Set<Room> rooms = new HashSet<Room>();
        for (Room roomItem : GameStatus.getRooms()) {
            int roomId = roomItem.getId();
            try {
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery("SELECT locked FROM room WHERE id='" + roomId + "'");
                while (rs.next()) {
                    roomItem.setIsLocked(rs.getBoolean("locked"));
                }

                stm.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            rooms.add(roomItem);
        }

        Set<Npc> npcsToLoad = new HashSet<Npc>();
        for (Npc npcItem : GameStatus.getNpcs()) {
            int npcId = npcItem.getId();
            try {
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery("SELECT npcCurrentRoom FROM npc WHERE id='" + npcId + "'");
                while (rs.next()) {
                    npcItem.setCurrentRoom(GameStatus.getRoom(rs.getInt("npcCurrentRoom")));

                }

                stm.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            npcsToLoad.add(npcItem);
        }

        Set<Item> itemstoLoad = new HashSet<Item>();
        for (Item itemItem : GameStatus.getItems()) {
            int itemId = itemItem.getId();
            try {
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery("SELECT itemCurrentRoom,isItemUsable FROM item WHERE id='" + itemId + "'");
                while (rs.next()) {
                    itemItem.setCurrentRoom(GameStatus.getRoom(rs.getInt("itemCurrentRoom")));
                    itemItem.setUsable(rs.getBoolean("isItemUsable"));

                }
                stm.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            itemstoLoad.add(itemItem);

        }

        GameStatus.loadRooms(rooms);
        GameStatus.loadNpcs(npcsToLoad);
        GameStatus.loadItems(itemstoLoad);

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
