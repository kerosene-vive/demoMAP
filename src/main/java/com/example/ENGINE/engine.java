package com.example.ENGINE;

import com.example.GENERIC.*;
import com.example.PARSER.*;
import com.example.UTILITIES.jsonReader;
import com.example.FRONTEND.*;
import gui.GameFrame;
import gui.MenuFrame;
import java.io.IOException;

import org.json.JSONException;

//Gioco
public class engine {

    public static void main(String[] args) {
        GameFrame gameGui = new GameFrame();
        gameGui.setVisible(true);
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

        frontEnd.lobby();
        Parser.lobby();
        frontEnd.gameStart();
        openMenu();
        if (!gameStatus.isGameRunning()) {
            gameStatus.init();
        }

        Parser.parserGame();

    }

    private static void openMenu() {
        MenuFrame menu = new MenuFrame();
        menu.setVisible(true);
    }
}
