
package com.example.ENGINE;
import com.example.GENERIC.*;
import com.example.PARSER.*;
import com.example.UTILITIES.jsonReader;

import java.io.IOException;
import java.io.ObjectInputStream.GetField;

import org.json.JSONException;

import com.example.FRONTEND.*;;
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

    } catch (JSONException | IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    gameStatus.init();
    Parser.parserGame();
    

    }
}