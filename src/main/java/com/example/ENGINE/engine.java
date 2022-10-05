
package com.example.ENGINE;
import com.example.GENERIC.*;
import com.example.PARSER.*;
import com.example.FRONTEND.*;;

public class engine {
    public static void main(String[] args) {
    frontEnd.lobby();
    Parser.lobby();
    frontEnd.gameStart();
    verbs.init();
    Parser.parserGame();
    

    }
}