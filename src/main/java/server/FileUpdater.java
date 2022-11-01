/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author flava
 */
public class FileUpdater {

    private static DataOutputStream dataOutputStream = null;
    private static DataInputStream dataInputStream = null;
    private static final String osservaPath = "./src/main/java/server/resoruces/osserva.txt";
    private static final String parlaPath = "./src/main/java/server/resoruces/parla.txt";
    private static final String prendiPath = "./src/main/java/server/resoruces/prendi.txt";
    private static final String usaPath = "./src/main/java/server/resoruces/usa.txt";
    private static final String vaiPath = "./src/main/java/server/resoruces/vai.txt";

    public static void sendFile(ArrayList<File> toDownlaod, ArrayList<File> toCheck) throws IOException {
        ServerSocket s = new ServerSocket(5000);
        System.out.println("server online on the : " + s + "port");
        //metodo private che presi toDowload e toCheck, controlla le firme nei tocheck e quelli da aggiornare li inserisce nei toDownload
        //successivamente nel while vado a mandare nei thread per il download solo i toDownload
        //per PALLLI parallelizzare toCheck-e-toDownload-mentre-carico-posso-controlalre-le firem e poi eventualmente aggiungerle alla coda di download
        
        try {
            while (true) {
                Socket socket = s.accept();
                Thread t = new RequestThread(socket, "txt");
                t.start();
            }
        } finally {
            s.close();
        }
    }

}
