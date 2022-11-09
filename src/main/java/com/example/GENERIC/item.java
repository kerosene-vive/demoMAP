package com.example.GENERIC;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.example.FRONTEND.FrontEnd;

public class Item extends Noun implements java.io.Serializable {

    Room currentRoom;
    String frasePrendi;
    String fraseUsa;
    boolean isUsable;

    //generate constructor
    public Item(int id, String name, List<String> inputAliases, String frasePrendi, String fraseUsa, boolean isUsable, Room currentRoom) {
        this.name = name;
        Set<String> aliases = new HashSet<String>(inputAliases);
        this.aliases = Collections.unmodifiableSet(aliases);
        this.id = id;
        this.frasePrendi = frasePrendi;
        this.fraseUsa = fraseUsa;
        this.Description = "";
        this.currentRoom = currentRoom;
    }
//get isUsable and currentRoom

    public boolean isUsable() {
        return isUsable;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    public void setUsable(boolean isUsable) {
        this.isUsable = isUsable;
    }

    public boolean execute(String verb) {

        if (verb.equals("prendi") && this.currentRoom == GameStatus.currentRoom) {
            FrontEnd.description(frasePrendi);
            isUsable = true;
            return true;
        }
        if (verb.equals("usa") && this.isUsable == true) {

            if (this.id == 1 && GameStatus.currentRoom.getId() == 9) {
                this.chiaveExecute();
                return true;
            }

        }
        return false;
    }

    public void chiaveExecute() {
        FrontEnd.description(fraseUsa);
        isUsable = false;
        GameStatus.getRoom(10).setIsLocked(false);

    }

    public String getDescription() {
        return Description;
    }

    public String getName() {
        return name;
    }

}
