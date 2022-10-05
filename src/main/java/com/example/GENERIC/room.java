package com.example.GENERIC;
import com.example.FRONTEND.*;;


public class room {
    
    boolean isLocked;
    room north;
    room south;
    room east;
    room west;
    String Description;

    public  void execute  (String verb) {
      if (verb == "vai") {
      gameStatus.currentRoom = this;
      frontEnd.Description(this.Description);
      
      }
    }

    
    public room getRoom(direction whereDirection)
    {
      if(whereDirection.name.equals("north"))
      {
        return north;
      }
      if(whereDirection.name.equals("south"))
      {
        return south;
      }
      if(whereDirection.name.equals("east"))
      {
        return east;
      }
      if(whereDirection.name.equals("west"))
      {
        return west;
      }
      else{
        return null;
      }
    }

    }

