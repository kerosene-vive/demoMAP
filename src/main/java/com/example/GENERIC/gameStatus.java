package com.example.GENERIC;
import java.util.List;
import java.util.Map;
import java.util.Set;

import dbmanager.*;
 


public class gameStatus {
    static room currentRoom;
    static Set<room> rooms;
    static Set<direction> directions;
    static Set<npc> npcs;
    static Set<item> items;
    static boolean isGameRunning;


public static room getCurrentRoom() {
    return currentRoom;
}
public static void setCurrentRoom(room currentRoom) {
    gameStatus.currentRoom = currentRoom;
}
public static Set<npc> getNpcs() {
    return npcs;
}
public static Set<item> getItems() {
    return items;
}

    public static Set<direction> getDirection() {
        return directions;
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
    noun[] nouns=new noun[rooms.size()+directions.size()+npcs.size()+items.size()];
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
    for(npc npc:npcs)
    {
        nouns[i]=npc;
        i++;
    }
    for(item item:items)
    {
        nouns[i]=item;
        i++;
    }
    return nouns;
}
public static void init() {
    setCurrentRoom(getRoom(1));
    isGameRunning=true;
}

public static void loadNpcs(Set<npc> npcsSet) {
    //read from a json file npcs and put them in the set
    gameStatus.npcs=npcsSet;
}
public static void loadItems(Set<item> itemsSet) {
    //read from a json file items and put them in the set
    gameStatus.items=itemsSet;
}
public static void save() {
 DBTest.save(currentRoom, rooms, npcs, items);
}

}

