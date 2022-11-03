/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author flava
 */
public class RequestThread extends Thread {

    private final Socket socket;
    private final String path;
    private static DataInputStream dataInputStream = null;
    private static DataOutputStream dataOutputStream = null;

    public RequestThread(Socket socket, String path, DataOutputStream dataOutputStream) {
        this.socket = socket;
        this.path = path;
        this.dataOutputStream = dataOutputStream;

    }

    /**
     * run send the request file.
     */
    @Override
    public void run() {
        try {
            int bytes = 0;
            File file = new File(path);
            FileInputStream fileInputStream = new FileInputStream(file);

            // send file size
            dataOutputStream.writeLong(file.length());
            // break file into chunks
            byte[] buffer = new byte[4 * 1024];
            while ((bytes = fileInputStream.read(buffer)) != -1) {
                dataOutputStream.write(buffer, 0, bytes);
                dataOutputStream.flush();
            }
            fileInputStream.close();
        } catch (IOException ex) {
            System.out.println("catch thread");
            System.err.println(ex);
        }

    }

}
