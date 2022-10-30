package com.example.GENERIC;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
       roomUpdated=roomUpdated.getRoom(this);
       roomUpdated.execute(verb);
       return true;
       }
         return false;
    }
    
}
