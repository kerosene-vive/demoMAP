package com.example.GENERIC;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.example.FRONTEND.frontEnd;
import com.example.PARSER.Parser;

public class npc extends  noun  implements java.io.Serializable {
    room currentRoom;
    private Map<List<String>, String> executeInputOutput;
    

    public npc(int id,String name, String Description, List<String> inputAliases,Map<List<String>, String> executeInputOutput,room currentRoom) {
        this.name = name;
        this.Description = Description;
        Set<String> aliases = new HashSet<String>(inputAliases);
        this.aliases = Collections.unmodifiableSet(aliases);
        this.id=id;
        this.executeInputOutput=executeInputOutput;
        this.currentRoom=currentRoom;
    }
  
    
  
    public room getCurrentRoom() {
        return currentRoom;
    }
    public void setCurrentRoom(room currentRoom) {
        this.currentRoom = currentRoom;
    }

    @Override
    public boolean execute(String verb) {
        if(this.getCurrentRoom()==gameStatus.currentRoom)
        {
        if(verb.equals("parla"))
        {
            frontEnd.description("Ciao sono "+this.name);
            frontEnd.description(this.Description);
            Parser.rememberMyName(this);
            return true;
        }
        for(List<String> input : executeInputOutput.keySet())
        {
            frontEnd.description(input.get(0));

            for(String word : input)
            {
             frontEnd.description(word);
                //if word is contained in verb  
                if(verb.contains(word))
                {
                    frontEnd.description(executeInputOutput.get(input));
                    return true;
                }
            }
        }   
         return false;
        }
          return false;
        }
 

    

}
