package com.example.GENERIC;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.example.FRONTEND.FrontEnd;
import com.example.PARSER.Parser;

public class Npc extends Noun implements java.io.Serializable {

    Room currentRoom;
    private Map<List<String>, String> executeInputOutput;

    public Npc(int id, String name, String Description, List<String> inputAliases, Map<List<String>, String> executeInputOutput, Room currentRoom) {
        this.name = name;
        this.Description = Description;
        Set<String> aliases = new HashSet<String>(inputAliases);
        this.aliases = Collections.unmodifiableSet(aliases);
        this.id = id;
        this.executeInputOutput = executeInputOutput;
        this.currentRoom = currentRoom;
    }

    public String getDescription() {
        return Description;
    }

    public String getName() {
        return name;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    @Override
    public boolean execute(String verb) {
        if (this.getCurrentRoom() == GameStatus.currentRoom) {
            if (verb.equals("parla")) {
                FrontEnd.description("Ciao sono " + this.name);
                FrontEnd.description(this.Description);
                Parser.rememberMyName(this);
                return true;
            }
            for (List<String> input : executeInputOutput.keySet()) {
                FrontEnd.description(input.get(0));

                for (String word : input) {
                    FrontEnd.description(word);
                    //if word is contained in verb  
                    if (verb.contains(word)) {
                        FrontEnd.description(executeInputOutput.get(input));
                        return true;
                    }
                }
            }
            return false;
        }
        return false;
    }

}
