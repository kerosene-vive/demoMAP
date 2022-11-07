package com.example.GENERIC;

import com.example.FRONTEND.*;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//is a noun
public class room extends noun implements java.io.Serializable {

  boolean isLocked;
  room north;
  room south;
  room east;
  room west;

  String Description;

  public room(
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

 

  public boolean isLocked() {
    return isLocked;
  }

  public void setIsLocked(boolean isLocked) {
    this.isLocked = isLocked;
  }

  public void setDirection(int north, int south, int east, int west) {
    this.north = gameStatus.getRoom(north);
    this.south = gameStatus.getRoom(south);
    this.east = gameStatus.getRoom(east);
    this.west = gameStatus.getRoom(west);
  }

  public boolean execute(String verb) {
    if (verb == "vai") {
      if (!isLocked && gameStatus.getCurrentRoom().isNear(this)) {
        gameStatus.currentRoom = this;
        frontEnd.description(this.Description);
      } 
      
      
      else {
        if (isLocked == true && gameStatus.getCurrentRoom().isNear(this)) {
          frontEnd.description("la stanza è chiusa");
        } else {
          if (gameStatus.getCurrentRoom() == this) {
            frontEnd.description("sei già qui");
          } else {
            frontEnd.description("la stanza non è vicina");
          }
        }
      }

      return true;
    } else {
      frontEnd.description("Non puoi fare questo");
      return false;
    }
   
  }

  public boolean isNear(room room) {
    if (
      this.north == room ||
      this.south == room ||
      this.east == room ||
      this.west == room
    ) {
      return true;
    } else {
      return false;
    }
  }

  public room getRoom(direction whereDirection) {
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
