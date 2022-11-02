/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package filemanager;

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileManager {

    private static final String RISORSE_FILE = "./src/resourceFiles";
    private static final String OSSERVA_PATH = "./src/resourceFiles/osserva.txt";
    private static final String PARLA_PATH = "./src/resourceFiles/parla.txt";
    private static final String PRENDI_PATH = "./src/resourceFiles/prendi.txt";
    private static final String USA_PATH = "./src/resourceFiles/usa.txt";
    private static final String VAI_PATH = "./src/resourceFiles/vai.txt";

    private static ArrayList<String> toDownload = new ArrayList();
    private static ArrayList<String> toCheck = new ArrayList();

    private static DataOutputStream dataOutputStream = null;
    private static DataInputStream dataInputStream = null;

    private static void directoryCreator() {
        File directory = new File(RISORSE_FILE);
        if (!directory.exists()) {
            directory.mkdir();
        }
    }

    /**
     * Checking for the presence of files in the game local repo, in case of
     * absence they are downloaded from the server.
     *
     * @return map<filename, path>
     */
    public static Map fileCheck() {

        directoryCreator();

        File osserva = new File(OSSERVA_PATH);
        File parla = new File(PARLA_PATH);
        File prendi = new File(PRENDI_PATH);
        File usa = new File(USA_PATH);
        File vai = new File(VAI_PATH);

        if (!osserva.exists()) {
            toDownload.add(osserva.getName());
            System.out.println("file > osserva not found");
        } else {
            toCheck.add(OSSERVA_PATH);
        }
        if (!parla.exists()) {
            toDownload.add(parla.getName());
        } else {
            toCheck.add(PARLA_PATH);
        }
        if (!prendi.exists()) {
            toDownload.add(prendi.getName());
        } else {
            toCheck.add(PRENDI_PATH);
        }
        if (!usa.exists()) {
            toDownload.add(usa.getName());
        } else {
            toCheck.add(USA_PATH);
        }
        if (!vai.exists()) {
            toDownload.add(vai.getName());
        } else {
            toCheck.add(VAI_PATH);
        }

        if (toDownload.size() > 0) {
            System.out.println("file mancati o corrotti, rigenerazione in corso...");
            //connection to server
            try (Socket socket = new Socket("localhost", 5000)) {
                dataInputStream = new DataInputStream(socket.getInputStream());
                dataOutputStream = new DataOutputStream(socket.getOutputStream());

                for (int i = 0; i < toDownload.size(); i++) {
                    receiveFile(toDownload.get(i));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        //creation Map <nameFile, path>
        Map filePahts = new HashMap();
        filePahts.put(osserva.getName(), osserva.getPath());
        filePahts.put(parla.getName(), parla.getPath());
        filePahts.put(prendi.getName(), prendi.getPath());
        filePahts.put(usa.getName(), usa.getPath());
        filePahts.put(vai.getName(), vai.getPath());

        return filePahts;
    }

    private static void receiveFile(String filePath) throws Exception {
        int bytes = 0;
        FileOutputStream fileOutputStream = new FileOutputStream(filePath);
        // read file size
        long size = dataInputStream.readLong();
        byte[] buffer = new byte[4 * 1024];
        while (size > 0 && (bytes = dataInputStream.read(buffer, 0, (int) Math.min(buffer.length, size))) != -1) {
            fileOutputStream.write(buffer, 0, bytes);
            // read upto file size
            size -= bytes;
        }
        fileOutputStream.close();

    }

    public static ArrayList<String> getToDownlaod() {
        return toDownload;
    }
}
