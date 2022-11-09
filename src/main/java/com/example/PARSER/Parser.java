package com.example.PARSER;

import com.example.GENERIC.*;
import gui.Telefono;
import com.example.FRONTEND.*;
import java.util.Scanner;

public class Parser {

    static private Noun name = null;

    public static void lobby() {
        //if the player press G, the game starts
        Scanner sc = new Scanner(System.in);
        while (true) {
            String input = sc.nextLine();
            if (input.equals("G")) {

                break;
            } else if (input.equals("$")) {
                System.exit(0);
            } else if (input.equals("H")) {
                FrontEnd.help();
            } else if (input.equals("C")) {
                GameStatus.load();
            } else {
                FrontEnd.error();
            }
        }
    }

    public static void parserGame() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String input = sc.nextLine();

            eventAriser(input);

            if (input.equals("$")) {
                FrontEnd.exit();
                break;
            }
        }
    }

    public static void eventAriser(String input) {
        input = input.toLowerCase();
        if (input.equals("salva")) {
            GameStatus.save();
            return;
        }
        if (input.equals("osserva")) {
            FrontEnd.help();
            return;
        }
        if (input.equals("telefono")) {
            Telefono t = new Telefono();
            t.setVisible(true);
            return;
        }
        String verb;
        String name;//for room ,npc,items,and directions
        if (Verbs.getVerb(input).equals("vai")) {

            verb = "vai";
            rememberMyName(null);
        } else if (Verbs.getVerb(input).equals("parla")) {

            verb = "parla";
            rememberMyName(null);

        } else if (Verbs.getVerb(input).equals("osserva")) {

            verb = "osserva";
            rememberMyName(null);
        } else if (Verbs.getVerb(input).equals("prendi")) {

            verb = "prendi";
            rememberMyName(null);
        } else if (Verbs.getVerb(input).equals("usa")) {

            verb = "usa";
            rememberMyName(null);
        } else {

            verb = input;
        }

        Noun myNoun = Noun.getNoun(input);
        if (myNoun != null) {
            myNoun.execute(verb);
        } else {
            if (directionHelper(input) == false) {
                if (checkName(verb) == false) {
                    FrontEnd.error();
                }
            }
        }

    }

    public static boolean directionHelper(String input) {
        //if contains dove, or help

        if (input.contains("dove") || input.contains("help")) {
            FrontEnd.description(GameStatus.getCurrentRoom().getDescription());
            for (Direction direction : GameStatus.getDirection()) {
                if (GameStatus.getCurrentRoom().getRoom(direction) != null) {
                    FrontEnd.description("a  " + direction.getName() + " c'è " + GameStatus.getCurrentRoom().getRoom(direction).getName());
                }
            }
            return true;
        }
        return false;

    }

    public static void rememberMyName(Noun nome) {
        name = nome;
    }

    public static boolean checkName(String input) {
        if (name != null) {
            if (name.execute(input) == true) {
                return true;
            }
        }
        return false;
    }

}
