package com.example.FRONTEND;

import com.example.UTILITIES.*;import gui.GameFrame;
;





public class frontEnd {
    public static void lobby() {
        System.out.println("================================");
        System.out.println("*   IL SEGRETO DEL PIANO -2 *");
        System.out.println("================================");
        System.out.println("===PREMI====G====PER===GIOCARE");
        System.out.println("===PREMI====$====PER===USCIRE");
        System.out.println("===PREMI====C====PER===CARICARE==UNA==PARTITA");
        System.out.println("===PREMI====H====PER===HELP");
        GameFrame.getOutputText("segreto piano meno due");
    }
    public static void gameStart() {
        System.out.println("================================");
        System.out.println("*   WELCOME BACK  *");
        System.out.println("AL DIPARTIMENTO DI INFORMATICA CI SONO "+api.wheather()+" GRADI CORRENTEMENTE");
        System.out.println("================================");
        GameFrame.getOutputText("Bentornato, al dipartimento di informatica ci sono " + api.wheather() + "gradi");
    }
    public static void error() {
        System.out.println("================================");
        System.out.println("*   INPUT NON VALIDO  *");
        System.out.println("================================");
        GameFrame.getOutputText("Input non valido");
    }
    public static void description(String string)
    {
        System.out.println("================================");
        System.out.println("*   "+string+"  *");
        System.out.println("================================");
        GameFrame.getOutputText(string);
    }
    public static void help() {
        System.out.println("================================");
        System.out.println("*   QUA' METTEREMO UNA MINI GUIDA AL GIOCO..  *");
        System.out.println("================================");
    }
    public static void exit() {
        System.out.println("================================");
        System.out.println("*   GRAZIE PER AVER GIOCATO  *");
        System.out.println("================================");
        GameFrame.getOutputText("Grazie per aver giocato! Torna presto, il segreto ti aspetta");
    }
}
