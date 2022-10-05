package com.example.GENERIC;
import java.util.Set;
import java.io.FileWriter;
import java.io.IOException;

 


public class gameStatus {
    static room currentRoom;
    static Set<room> rooms;
    

public static room getCurrentRoom() {
    return currentRoom;
}
public static void setCurrentRoom(room currentRoom) {
    gameStatus.currentRoom = currentRoom;
}
 public static void initRooms() {
    //read from a json file rooms and put them in the set
   
 }

}

