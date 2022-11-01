/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package filemanager;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FileManager {

    private static final String RISORSE_FILE = "./src/resourceFiles";
    private static final String OSSERVA_PATH = "./src/resourceFiles/osserva.txt";
    private static final String PARLA_PATH = "./src/resourceFiles/parla.txt";
    private static final String PRENDI_PATH = "./src/resourceFiles/prendi.txt";
    private static final String USA_PATH = "./src/resourceFiles/usa.txt";
    private static final String VAI_PATH = "./src/resourceFiles/vai.txt";
    private static ArrayList<String> toDownload = null;
    private static ArrayList<String> toCheck = null;

    private static void directoryCreator() {
        File directory = new File(RISORSE_FILE);
        if (!directory.exists()) {
            directory.mkdir();
        }
    }

    public static Map fileCheck() {

        directoryCreator();

        File osserva = new File(OSSERVA_PATH);
        File parla = new File(PARLA_PATH);
        File prendi = new File(PRENDI_PATH);
        File usa = new File(USA_PATH);
        File vai = new File(VAI_PATH);

        if (!osserva.exists()) {
            toDownload.add(osserva.getName());
        } else {
            toCheck.add(osserva.getName());
        }
        if (!parla.exists()) {
            toDownload.add(parla.getName());
        } else {
            toCheck.add(osserva.getName());
        }
        if (!prendi.exists()) {
            toDownload.add(prendi.getName());
        } else {
            toCheck.add(osserva.getName());
        }
        if (!usa.exists()) {
            toDownload.add(usa.getName());
        } else {
            toCheck.add(osserva.getName());
        }
        if (!vai.exists()) {
            toDownload.add(vai.getName());
        } else {
            toCheck.add(osserva.getName());
        }

        //chiamo server x scaricare i file assenti e per gli altri controllo l'aggiornamento
        
        //creation Map <nameFile, path>
        Map filePahts = new HashMap();
        filePahts.put(osserva.getName(), osserva.getPath());
        filePahts.put(parla.getName(), parla.getPath());
        filePahts.put(prendi.getName(), prendi.getPath());
        filePahts.put(usa.getName(), usa.getPath());
        filePahts.put(vai.getName(), vai.getPath());

        return filePahts;
    }
}
