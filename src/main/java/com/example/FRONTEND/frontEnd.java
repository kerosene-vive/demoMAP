package com.example.FRONTEND;

import com.example.UTILITIES.*;;





public class frontEnd {
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
        System.out.println("AL DIPARTIMENTO DI INFORMATICA CI SONO "+api.wheather()+" GRADI CORRENTEMENTE");
        System.out.println("================================");
    }
    public static void error() {
        System.out.println("================================");
        System.out.println("*   INPUT NON VALIDO  *");
        System.out.println("================================");
    }
    public static void Description(String string)
    {
        System.out.println("================================");
        System.out.println("*   "+string+"  *");
        System.out.println("================================");
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
    }
}
