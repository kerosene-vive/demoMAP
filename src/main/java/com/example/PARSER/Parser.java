package com.example.PARSER;
import com.example.GENERIC.*;
import com.example.FRONTEND.*;
import java.util.Scanner;



public class Parser {
    static private noun name=null;

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
              else if(input.equals("H")) {
                  frontEnd.help();
              }
              else  if(input.equals("C")) {
                  gameStatus.load();
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
                frontEnd.exit();
                break;
              }
          }
    }




    public static void EventAriser(String input) {
        input = input.toLowerCase();
        if(input.equals("salva"))
        {
            gameStatus.save();
            return;
        }
        if(input.equals("osserva"))
        {
            frontEnd.look();
            return;
        }
      
        String verb;
        String name;//for room ,npc,items,and directions
        if (verbs.getVerb(input).equals("vai")) {
            
            verb="vai";
            rememberMyName(null);
        }
        else if (verbs.getVerb(input).equals("parla")) {
            
            verb="parla";
            rememberMyName(null);
           
        }
        else if (verbs.getVerb(input).equals("osserva")) {
            
            verb="osserva";
            rememberMyName(null);
        }
        else if (verbs.getVerb(input).equals("prendi")) {
           
            verb="prendi";
            rememberMyName(null);
        }
        else if (verbs.getVerb(input).equals("usa")) {
            
            verb="usa";
            rememberMyName(null);
        }
        else {
           
            verb=input;
        }

        noun myNoun=noun.getNoun(input);
         if (myNoun!=null)
         {
            myNoun.execute(verb);
         }


        else{
            if(directionHelper(input)==false)
                if(checkName(verb)==false)
                    frontEnd.error();
        }

   
            
         
}           




public static boolean directionHelper(String input) {
    //if contains dove, or help

   if(input.contains("dove")||input.contains("help"))
   {
    frontEnd.Description(gameStatus.getCurrentRoom().getDescription());
  for(direction direction : gameStatus.getDirection())
  {
    if(gameStatus.getCurrentRoom().getRoom(direction)!=null)
    {
      frontEnd.Description("a  "+direction.getName()+ " c'è "+ gameStatus.getCurrentRoom().getRoom(direction).getName());
    }
  }
    return true;
   }
return false;
 
}



public static void rememberMyName(noun nome)
{
    name=nome;
}


public static boolean checkName(String input)
{
if (name!=null)
{
    if(name.execute(input)==true)
    {
        return true;
    }
}
return false;
}
 
}