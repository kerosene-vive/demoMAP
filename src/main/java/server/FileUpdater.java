/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server;

import filemanager.FileManager;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

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
    private static ArrayList<String> toDownload = new ArrayList();

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(5000)) {
            System.out.println("listening to port:5000");
            //resto in attesa di richiesta 
            Socket clientSocket = serverSocket.accept();
            System.out.println(clientSocket + " connected.");
            dataInputStream = new DataInputStream(clientSocket.getInputStream());
            dataOutputStream = new DataOutputStream(clientSocket.getOutputStream());

            //Sending all file in ToDownload
            toDownload = FileManager.getToDownlaod();
            sendFile(toDownload, clientSocket);

            dataInputStream.close();
            dataOutputStream.close();
            clientSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void sendFile(ArrayList<String> toDownlaod, Socket clientSocket) throws IOException {
        //metodo private che presi toDowload e toCheck, controlla le firme nei tocheck e quelli da aggiornare li inserisce nei toDownload
        //successivamente nel while vado a mandare nei thread per il download solo i toDownload
        //x PALLI parallelizzare toCheck-e-toDownload-mentre-carico-posso-controlalre-le firme e poi eventualmente aggiungerle alla coda di download
        try {
                for (int i = 0; i < toDownlaod.size(); i++) {
                    String serverPathFile = getServerPath(getNameFileByPath(toDownlaod.get(i)));
                    Thread t = new RequestThread(clientSocket, serverPathFile);
                    t.start();
                }
        } finally {
            clientSocket.close();
        }
    }

    /**
     * cause the client send the missing path, we have to know only the name of
     * file, to download it from the server local path
     *
     * @param path
     * @return name of file
     */
    private static String getNameFileByPath(String path) {
        StringTokenizer tokenizer = new StringTokenizer(path, "/");
        List<String> tokenList = new ArrayList<>();

        //append tokens in list 
        while (tokenizer.hasMoreTokens()) {
            tokenList.add(tokenizer.nextToken());

        }

        //System.out.println(tokenList.get(tokenList.size() - 1));
        return tokenList.get(tokenList.size() - 1);
    }

    private static List<String> getPathList() {
        List<String> pathList = new ArrayList<>();
        pathList.add(osservaPath);
        pathList.add(parlaPath);
        pathList.add(prendiPath);
        pathList.add(usaPath);
        pathList.add(vaiPath);
        
        return pathList;
    }

    /**
     * @param fileName 
     * search the corrispondent server path
     */
    private static String getServerPath(String fileName) {
       List<String> pathList = getPathList();
       String path;
       for (int i = 0; i < pathList.size(); i++) {
           
           if(pathList.get(i).contains(fileName)) {
               return pathList.get(i); 
           }           
       }
       return "-1";
    } 
    //metodo private che presi toDowload e toCheck, controlla le firme nei tocheck e quelli da aggiornare li inserisce nei toDownload
    //successivamente nel while vado a mandare nei thread per il download solo i toDownload
}
