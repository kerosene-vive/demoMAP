package com.example.GENERIC;


public class direction extends noun {

    @Override
    public void execute(String verb) {
       if(verb.equals("vai"))
       {
       room roomUpdated=gameStatus.getCurrentRoom();
       roomUpdated=roomUpdated.getRoom(this);
       roomUpdated.execute(verb);
       }
    }
    
}
