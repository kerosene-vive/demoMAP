package com.example.GENERIC;

import com.example.FRONTEND.*;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//is a noun
public class Room extends Noun implements java.io.Serializable {

    boolean isLocked;
    Room north;
    Room south;
    Room east;
    Room west;

    String Description;

    public Room(
            int id,
            String name,
            String Description,
            boolean isLocked,
            List<String> inputAliases
    ) {
        this.name = name;
        this.Description = Description;
        this.isLocked = isLocked;
        Set<String> aliases = new HashSet<String>(inputAliases);
        this.aliases = Collections.unmodifiableSet(aliases);

        this.id = id;
    }

    public String getDescription() {
        return Description;
    }

    public String getName() {
        return name;
    }

    public boolean isLocked() {
        return isLocked;
    }

    public void setIsLocked(boolean isLocked) {
        this.isLocked = isLocked;
    }

    public void setDirection(int north, int south, int east, int west) {
        this.north = GameStatus.getRoom(north);
        this.south = GameStatus.getRoom(south);
        this.east = GameStatus.getRoom(east);
        this.west = GameStatus.getRoom(west);
    }

    public boolean execute(String verb) {
        if (verb == "vai") {
            if (!isLocked && GameStatus.getCurrentRoom().isNear(this)) {
                GameStatus.currentRoom = this;
                FrontEnd.description(this.Description);
            } else {
                if (isLocked == true && GameStatus.getCurrentRoom().isNear(this)) {
                    FrontEnd.description("la stanza è chiusa");
                } else {
                    if (GameStatus.getCurrentRoom() == this) {
                        FrontEnd.description("sei già qui");
                    } else {
                        FrontEnd.description("la stanza non è vicina");
                    }
                }
            }

            return true;
        } else {
            FrontEnd.description("Non puoi fare questo");
            return false;
        }

    }

    public boolean isNear(Room room) {
        if (this.north == room
                || this.south == room
                || this.east == room
                || this.west == room) {
            return true;
        } else {
            return false;
        }
    }

    public Room getRoom(Direction whereDirection) {
        if (whereDirection.name.equals("north")) {
            return north;
        }
        if (whereDirection.name.equals("south")) {
            return south;
        }
        if (whereDirection.name.equals("east")) {
            return east;
        }
        if (whereDirection.name.equals("west")) {
            return west;
        } else {
            return null;
        }
    }

}
