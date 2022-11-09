package com.example.GENERIC;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import com.example.FRONTEND.FrontEnd;

public class Direction extends Noun implements java.io.Serializable {

    public Direction(int id, String name, List<String> aliases) {
        this.name = name;
        Set<String> inputAliases = new HashSet<String>(aliases);
        this.aliases = Collections.unmodifiableSet(inputAliases);
        this.id = id;
    }

    @Override
    public boolean execute(String verb) {
        if (verb.equals("vai")) {
            Room roomUpdated = GameStatus.getCurrentRoom();
            if (roomUpdated.getRoom(this) != null) {
                roomUpdated = roomUpdated.getRoom(this);
                roomUpdated.execute(verb);
                return true;
            }

        }
        FrontEnd.description("Non puoi andare da quella parte");
        return false;
    }

}
