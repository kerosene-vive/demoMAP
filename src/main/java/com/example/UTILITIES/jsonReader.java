package com.example.UTILITIES;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.IOException;
import java.io.InputStream;
import com.example.GENERIC.Direction;
import com.example.GENERIC.GameStatus;
import com.example.GENERIC.Item;
import com.example.GENERIC.Npc;
import com.example.GENERIC.Room;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;

import org.apache.commons.io.IOUtils;

public class JsonReader {

    private static String roomPath = "src/main/java/com/example/RESOURCES/rooms.json";
    private static String directionPath = "src/main/java/com/example/RESOURCES/direction.json";
    private static String npcPath = "src/main/java/com/example/RESOURCES/npcs.json";
    private static String itemPath = "src/main/java/com/example/RESOURCES/items.json";

    public static void roomsInit() throws JSONException, IOException {
        JSONArray rooms = readFile(roomPath);
        Map<Integer, List<Integer>> roomsDirections = new HashMap<Integer, List<Integer>>();
        Set<Room> roomsSet = new java.util.HashSet<Room>();
        for (int i = 0; i < rooms.length(); i++) {
            JSONObject room = rooms.getJSONObject(i);
            int id = room.getInt("id");
            String name = room.getString("name");
            String description = room.getString("description");
            boolean isLocked = room.getBoolean("isLocked");
            String aliases = room.getString("aliases");

            int north = room.getInt("north");
            int south = room.getInt("south");
            int east = room.getInt("east");
            int west = room.getInt("west");

            List<Integer> directions = IntStream.of(north, south, east, west).boxed().collect(Collectors.toList());
            roomsDirections.put(id, directions);

            String[] aliasesArray = aliases.split(",");
            List<String> aliasesList;
            aliasesList = IntStream.range(0, aliasesArray.length).mapToObj(j -> aliasesArray[j]).collect(Collectors.toList());
            Room roomObj = new Room(id, name, description, isLocked, aliasesList);
            roomsSet.add(roomObj);
        }
        GameStatus.loadRooms(roomsSet);
        GameStatus.loadRoomsDirections(roomsDirections);
    }

    public static void directionInit() throws JSONException, IOException {
        JSONArray directions = readFile(directionPath);
        Set<Direction> directionsSet = new java.util.HashSet<Direction>();
        for (int i = 0; i < directions.length(); i++) {
            JSONObject direction = directions.getJSONObject(i);
            int id = direction.getInt("id");
            String name = direction.getString("name");
            String alias = direction.getString("alias");
            String[] aliasesArray = alias.split(",");
            List<String> aliasesList;
            aliasesList = IntStream.range(0, aliasesArray.length).mapToObj(j -> aliasesArray[j]).collect(Collectors.toList());
            Direction directionObj = new Direction(id, name, aliasesList);
            directionsSet.add(directionObj);
        }
        GameStatus.loadDirections(directionsSet);
    }

    public static void npcInit() throws JSONException, IOException {
        JSONArray npcs = readFile(npcPath);
        Set<Npc> npcsSet = new java.util.HashSet<Npc>();
        for (int i = 0; i < npcs.length(); i++) {
            JSONObject npc = npcs.getJSONObject(i);
            int id = npc.getInt("id");
            String name = npc.getString("name");
            String aliases = npc.getString("aliases");
            String description = npc.getString("fraseParla");
            Room npcRoom = GameStatus.getRoom(npc.getInt("room"));

            String[] aliasesArray = aliases.split(",");
            List<String> aliasesList;
            aliasesList = IntStream.range(0, aliasesArray.length).mapToObj(j -> aliasesArray[j]).collect(Collectors.toList());
            Map<List<String>, String> executeInputOutput = new HashMap<List<String>, String>();
            JSONArray execute = npc.getJSONArray("execute");
            for (int j = 0; j < execute.length(); j++) {
                JSONObject executeObj = execute.getJSONObject(j);
                String input = executeObj.getString("input");
                String output = executeObj.getString("output");
                String[] inputArray = input.split(",");
                List<String> inputList;
                inputList = IntStream.range(0, inputArray.length).mapToObj(k -> inputArray[k]).collect(Collectors.toList());
                executeInputOutput.put(inputList, output);
            }
            Npc npcObj = new Npc(id, name, description, aliasesList, executeInputOutput, npcRoom);
            npcsSet.add(npcObj);

        }
        GameStatus.loadNpcs(npcsSet);
    }

//item  init
    public static void itemInit() throws JSONException, IOException {
        JSONArray items = readFile(itemPath);
        Set<Item> itemsSet = new java.util.HashSet<Item>();
        for (int i = 0; i < items.length(); i++) {
            JSONObject item = items.getJSONObject(i);
            int id = item.getInt("id");
            String name = item.getString("name");
            String aliases = item.getString("aliases");
            Room itemRoom = GameStatus.getRoom(item.getInt("room"));
            Boolean isUsable = item.getBoolean("isUsable");
            String frasePrendi = item.getString("frasePrendi");
            String fraseUsa = item.getString("fraseUsa");
            String[] aliasesArray = aliases.split(",");
            List<String> aliasesList;
            aliasesList = IntStream.range(0, aliasesArray.length).mapToObj(j -> aliasesArray[j]).collect(Collectors.toList());
            Item itemObj = new Item(id, name, aliasesList, frasePrendi, fraseUsa, isUsable, itemRoom);
            itemsSet.add(itemObj);

        }
        GameStatus.loadItems(itemsSet);
    }

    public static JSONArray readFile(String path) throws JSONException, IOException {
        File f = new File(path);
        JSONArray jsonArray = null;
        if (f.exists()) {
            InputStream is = new FileInputStream(f);
            String jsonTxt = IOUtils.toString(is, "UTF-8");

            jsonArray = new JSONArray(jsonTxt);
        }
        return (jsonArray);
    }
}
