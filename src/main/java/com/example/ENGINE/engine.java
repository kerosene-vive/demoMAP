
package com.example.ENGINE;
import com.example.GENERIC.*;
import com.example.PARSER.*;
import com.example.UTILITIES.jsonReader;
import com.example.FRONTEND.*;
import java.io.IOException;


import org.json.JSONException;

//Gioco
public class engine {
    public static void main(String[] args) {
    frontEnd.lobby();
    Parser.lobby();
    frontEnd.gameStart();
    verbs.init();

    try {
        jsonReader.roomsInit();
        jsonReader.directionInit();
        jsonReader.npcInit();
        jsonReader.itemInit();

    } catch (JSONException | IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    gameStatus.init();
    Parser.parserGame();
    

    }
}