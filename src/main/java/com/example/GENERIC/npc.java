package com.example.GENERIC;

import com.example.FRONTEND.frontEnd;

public class npc extends  noun {
    room currentRoom;
    String name;
    String Description;
    String[] aliases;
    String[] dialogues;
    int id;
    public npc(int id,String name, String Description, String[] aliases,String[] dialogues) {
        this.name = name;
        this.Description = Description;
        this.aliases = aliases;
        this.dialogues=dialogues;
        this.id=id;
    }
  
    public String[] getDialogues() {
        return dialogues;
    }
  
    public room getCurrentRoom() {
        return currentRoom;
    }
    public void setCurrentRoom(room currentRoom) {
        this.currentRoom = currentRoom;
    }
    @Override
    public void execute(String verb) {
        if(verb.equals("parla"))
        {
            frontEnd.Description("Ciao sono "+this.name);
            frontEnd.Description(this.dialogues[0]);
        }
        else
        {
            frontEnd.Description("Non puoi fare questo");
        }
    }

}
