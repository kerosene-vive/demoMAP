package com.example.ENGINE;

import com.example.GENERIC.*;
import com.example.PARSER.*;
import com.example.UTILITIES.JsonReader;
import com.example.FRONTEND.*;
import java.io.IOException;
import org.json.JSONException;

//Gioco
public class Engine {

    public static void main(String[] args) {
        Verbs.init();

        try {
            JsonReader.roomsInit();
            JsonReader.directionInit();
            JsonReader.npcInit();
            JsonReader.itemInit();

        } catch (JSONException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        FrontEnd.lobby();
        Parser.lobby();
        FrontEnd.gameStart();
        if (!GameStatus.isGameRunning()) {
            GameStatus.init();
        }

        Parser.parserGame();

    }
}
