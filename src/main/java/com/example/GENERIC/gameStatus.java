package com.example.GENERIC;

import java.util.List;
import java.util.Map;
import java.util.Set;
import dbmanager.*;

public class GameStatus {

    public static Room currentRoom;
    static Set<Room> rooms;
    static Set<Direction> directions;
    static Set<Npc> npcs;
    static Set<Item> items;
    static boolean isGameRunning = false;

    public static Room getCurrentRoom() {
        return currentRoom;
    }

    public static Set<Npc> getNpcs() {
        return npcs;
    }

    public static Set<Item> getItems() {
        return items;
    }

    public static Set<Room> getRooms() {
        return rooms;
    }

    public static Set<Direction> getDirection() {
        return directions;
    }

    public static void setCurrentRoom(Room currentRoom) {
        GameStatus.currentRoom = currentRoom;
    }

    public static void loadRooms(Set<Room> rooms) {
        //read from a json file rooms and put them in the set
        GameStatus.rooms = rooms;
    }

    public static void loadNpcs(Set<Npc> npcsSet) {
        //read from a json file npcs and put them in the set
        GameStatus.npcs = npcsSet;
    }

    public static void loadItems(Set<Item> itemsSet) {
        //read from a json file items and put them in the set
        GameStatus.items = itemsSet;
    }

    public static boolean isGameRunning() {
        return isGameRunning;
    }

    public static Room getRoom(int id) {
        for (Room room : rooms) {
            if (room.getId() == id) {
                return room;
            }
        }
        return null;
    }

    public static void loadRoomsDirections(Map<Integer, List<Integer>> roomsDirections) {
        for (Room room : rooms) {
            int id = room.getId();
            List<Integer> directions = roomsDirections.get(id);
            room.setDirection(directions.get(0), directions.get(1), directions.get(2), directions.get(3));

        }
    }

    public static void loadDirections(Set<Direction> directions) {
        //read from a json file directions and put them in the set
        GameStatus.directions = directions;
    }

    public static Noun[] getNouns() {
        Noun[] nouns = new Noun[rooms.size() + directions.size() + npcs.size() + items.size()];
        int i = 0;
        for (Room room : rooms) {
            nouns[i] = room;
            i++;
        }
        for (Direction direction : directions) {
            nouns[i] = direction;
            i++;
        }
        for (Npc npc : npcs) {
            nouns[i] = npc;
            i++;
        }
        for (Item item : items) {
            nouns[i] = item;
            i++;
        }
        return nouns;
    }

    public static void init() {
        setCurrentRoom(getRoom(1));
        isGameRunning = true;
    }

    public static void save() {
        DBTest.save(currentRoom, rooms, npcs, items);
    }

    public static void load() {
        DBTest.load();
        isGameRunning = true;
    }

}
