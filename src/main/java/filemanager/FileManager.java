/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package filemanager;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileManager {

    private static final String RISORSE_FILE = "./src/resourceFiles";
    private static final String OSSERVA_PATH = "./src/resourceFiles/osserva.txt";
    private static final String PARLA_PATH = "./src/resourceFiles/parla.txt";
    private static final String PRENDI_PATH = "./src/resourceFiles/prendi.txt";
    private static final String USA_PATH = "./src/resourceFiles/usa.txt";
    private static final String VAI_PATH = "./src/resourceFiles/vai.txt";

    private static void directoryCreator() {
        File directory = new File(RISORSE_FILE);
        if (!directory.exists()) {
            directory.mkdir();
        }
    }

    private static void setOsserva(File osserva) {

        String aliasOsserva = "osserva guarda orriglia spia";

        try {
            osserva.createNewFile();
            FileWriter fw = new FileWriter(osserva);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(aliasOsserva);
            bw.flush();
            bw.close();
        } catch (IOException ex) {
            Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void fileCreator() {

        directoryCreator();

        File osserva = new File(OSSERVA_PATH);
        File parla = new File(PARLA_PATH);
        File prendi = new File(PRENDI_PATH);
        File usa = new File(USA_PATH);
        File vai = new File(VAI_PATH);

        try {
            if (!osserva.exists()) {
                setOsserva(osserva);
            }
            if (!parla.exists()) {
                parla.createNewFile();
            }
            if (!prendi.exists()) {
                prendi.createNewFile();
            }
            if (!usa.exists()) {
                usa.createNewFile();
            }
            if (!vai.exists()) {
                vai.createNewFile();
            }

        } catch (IOException ex) {
            Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
