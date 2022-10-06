package com.example.PARSER;
import com.example.GENERIC.*;
import com.example.FRONTEND.*;
import java.util.Scanner;



public class Parser {
    public static void lobby() {
       //if the player press G, the game starts
       Scanner sc = new Scanner(System.in);
       while (true) {
           String input = sc.nextLine();
           if (input.equals("G")) {
               
               break;
           }
              else if (input.equals("$")) {
                System.exit(0);
              }
              else {
                frontEnd.error();
              }
        }
    }


    
    public static void parserGame() {
       Scanner sc = new Scanner(System.in);
         while (true) {
              String input = sc.nextLine();

                EventAriser(input);

              if (input.equals("$")) {
                
                break;
              }
          }
    }




    public static void EventAriser(String input) {
        String verb;
        String name;//for room ,npc,items,and directions
        if (verbs.getVerb(input).equals("vai")) {
            
            verb="vai";
        }
        else if (verbs.getVerb(input).equals("parla")) {
            
            verb="parla";
        }
        else if (verbs.getVerb(input).equals("osserva")) {
            
            verb="osserva";
        }
        else if (verbs.getVerb(input).equals("prendi")) {
           
            verb="prendi";
        }
        else if (verbs.getVerb(input).equals("usa")) {
            
            verb="usa";
        }
        else {
            frontEnd.error();
            verb="error";
        }

        noun myNoun=noun.getNoun(input);

        if(myNoun!=null)
        {
            myNoun.execute(verb);
        }
        else
        {
            frontEnd.error();
        }
       
      
       
    }



      

}