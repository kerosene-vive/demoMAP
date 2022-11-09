package com.example.GENERIC;

import java.util.Set;

public abstract class Noun {

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

    static public Noun getNoun(String input) {
        String[] words = input.split(" ");
        for (String word : words) {
            for (Noun noun : GameStatus.getNouns()) {
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
