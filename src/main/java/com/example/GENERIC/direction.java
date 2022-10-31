package com.example.GENERIC;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.example.FRONTEND.frontEnd;

public class direction extends noun implements java.io.Serializable {
   

    public direction(int id,String name, List<String> aliases) {
        this.name = name;
        Set<String> inputAliases=new HashSet<String>(aliases);
        this.aliases=Collections.unmodifiableSet(inputAliases);
        this.id=id;
    }
    
    @Override
    public boolean execute(String verb) {
       if(verb.equals("vai"))
       {
       room roomUpdated=gameStatus.getCurrentRoom();
       if(roomUpdated.getRoom(this)!=null)
       {
        roomUpdated=roomUpdated.getRoom(this);
        roomUpdated.execute(verb);
        return true;
       }
      
       }
        frontEnd.Description("Non puoi andare da quella parte");
         return false;
    }
    
}
