package com.example.GENERIC;

import java.util.Set;

public abstract class noun   {
    protected String name;
    protected Set<String> aliases;
    protected int id;
    protected String Description;


    public String getDescription() {
        return Description;
    }
   public int getId() {
       return id;
   }
    public String getName() {
        return name;
    }
    public Set<String> getAliases() {
        return aliases;
    }
    
   

    abstract public boolean execute(String verb);
    
    static public noun getNoun(String input) {
        String[] words = input.split(" ");
        for (String word : words) {
            for (noun noun : gameStatus.getNouns()) {
                for (String alias : noun.getAliases()) {
                    if (alias.equals(word)) {
                        return noun;
                    }
                }
            }
        }
        return null;
    }
  
}
