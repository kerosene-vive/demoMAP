package com.example.GENERIC;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.example.FRONTEND.frontEnd;

public class item extends noun {
    
    room currentRoom;
    String frasePrendi;
    String fraseUsa;
    boolean isUsable;
    
    //generate constructor
public item(int id,String name, List<String> inputAliases,String frasePrendi,String fraseUsa, boolean isUsable,room currentRoom) {
    this.name = name;
    Set<String> aliases = new HashSet<String>(inputAliases);
    this.aliases = Collections.unmodifiableSet(aliases);
    this.id=id;
    this.frasePrendi=frasePrendi;
    this.fraseUsa=fraseUsa;
    this.Description="";
}

    public boolean execute(String verb) {

        if(verb.equals("prendi") && this.currentRoom==gameStatus.currentRoom)
        {
            frontEnd.Description(frasePrendi);
            isUsable=true;
            return true;
        }
        if(verb.equals("usa") && this.isUsable==true)
        {

        if(this.id==1 && gameStatus.currentRoom.getId()==9)
        {
       this.chiaveExecute();
        return true;
        }




        }
        return false;
    }
   

    public void chiaveExecute() {
        frontEnd.Description(fraseUsa);
        isUsable=false;
        gameStatus.getRoom(10).setIsLocked(false);
       
    }




    }


