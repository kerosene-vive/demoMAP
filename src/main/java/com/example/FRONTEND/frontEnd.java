package com.example.FRONTEND;

import com.example.GENERIC.GameStatus;
import com.example.GENERIC.Item;
import com.example.GENERIC.Npc;
import com.example.UTILITIES.*;

public class FrontEnd {

    public static void lobby() {
        System.out.println("================================");
        System.out.println("*   IL SEGRETO DEL PIANO -2 *");
        System.out.println("================================");
        System.out.println("===PREMI====G====PER===GIOCARE");
        System.out.println("===PREMI====$====PER===USCIRE");
        System.out.println("===PREMI====C====PER===CARICARE==UNA==PARTITA");
        System.out.println("===PREMI====H====PER===HELP");
    }

    public static void gameStart() {
        System.out.println("================================");
        System.out.println("*   WELCOME BACK  *");
        System.out.println("AL DIPARTIMENTO DI INFORMATICA CI SONO " + Api.wheather() + " GRADI CORRENTEMENTE");
        System.out.println("================================");
    }

    public static void error() {
        System.out.println("================================");
        System.out.println("*   INPUT NON VALIDO  *");
        System.out.println("================================");
    }

    public static void description(String string) {
        System.out.println("================================");
        System.out.println("*   " + string + "  *");
        System.out.println("================================");
    }

    public static void help() {
        System.out.println("================================");
        System.out.println("*  USA vai e le direzioni o i nomi delle stanze per spostarti *");
        System.out.println("================================");
        System.out.println("*  USA osserva per capire cosa hai intorno *");
        System.out.println("================================");
        System.out.println("*  USA prendi e i nomi degli oggetti per raccoglierli *");
        System.out.println("================================");
        System.out.println("*  USA usa e i nomi degli oggetti per usarli *");
        System.out.println("================================");
        System.out.println("*  USA parla e i nomi degli npc per parlare con loro *");
        System.out.println("================================");
    }

    public static void exit() {
        System.out.println("================================");
        System.out.println("*   GRAZIE PER AVER GIOCATO  *");
        System.out.println("================================");
    }

    public static void look() {
        System.out.println("================================");

        System.out.println("*   " + GameStatus.getCurrentRoom().getDescription() + "  *");
        for (Npc personaggioNpc : GameStatus.getNpcs()) {
            if (personaggioNpc.getCurrentRoom().equals(GameStatus.getCurrentRoom())) {
                if (personaggioNpc.getDescription() != null) {
                    System.out.println("*   " + personaggioNpc.getDescription() + "  *");
                }

            }

        }
        for (Item oggetto : GameStatus.getItems()) {
            if (oggetto.getCurrentRoom().equals(GameStatus.getCurrentRoom())) {
                if (oggetto.getDescription() != null) {
                    System.out.println("*   " + oggetto.getDescription() + "  *");
                }

            }
        }

        System.out.println("*   " + GameStatus.getCurrentRoom().getDescription() + "  *");
        System.out.println("================================");
        System.out.println("================================");
        System.out.println("================================");
    }
}
