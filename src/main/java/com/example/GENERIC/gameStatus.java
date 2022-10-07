package com.example.GENERIC;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.io.FileWriter;
import java.io.IOException;

 


public class gameStatus {
    static room currentRoom;
    static Set<room> rooms;
    static Set<direction> directions;



public static room getCurrentRoom() {
    return currentRoom;
}
public static void setCurrentRoom(room currentRoom) {
    gameStatus.currentRoom = currentRoom;
}



 public static void loadRooms(Set<room> rooms) {
    //read from a json file rooms and put them in the set
   gameStatus.rooms=rooms;
 }
   public static Set<room> getRooms() {
    return rooms;
  }
public static room getRoom(int id) {
    for(room room:rooms)
    {
        if(room.getId()==id)
        {
            return room;
        }
    }
    return null;
}
public static void loadRoomsDirections(Map<Integer, List<Integer>> roomsDirections) {
    for (room  room: rooms) {
        int id=room.getId();
        List<Integer> directions=roomsDirections.get(id);
        room.setDirection(directions.get(0),directions.get(1),directions.get(2),directions.get(3));
        
    }
}


public static void loadDirections(Set<direction> directions) {
    //read from a json file directions and put them in the set
    gameStatus.directions=directions;
}


public static noun[] getNouns() {
    noun[] nouns=new noun[rooms.size()+directions.size()];
    int i=0;
    for(room room:rooms)
    {
        nouns[i]=room;
        i++;
    }
    for(direction direction:directions)
    {
        nouns[i]=direction;
        i++;
    }
    return nouns;
}
public static void init() {
    setCurrentRoom(getRoom(1));
}

}

