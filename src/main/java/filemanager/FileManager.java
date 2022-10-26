/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package filemanager;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


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

        String aliasOsserva = "osserva\nguarda\norriglia\nspia";

        try {
            osserva.createNewFile();
            FileWriter fw = new FileWriter(osserva);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(aliasOsserva);
            bw.flush();
            bw.close();
            fw.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void setParla(File parla) {

        String aliasParla = "parla\nchiedi\ndiscuti";

        try {
            parla.createNewFile();
            FileWriter fw = new FileWriter(parla);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(aliasParla);
            bw.flush();
            bw.close();
            fw.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void setPrendi(File prendi) {

        String aliasPrendi = "prendi\nraccogli";

        try {
            prendi.createNewFile();
            FileWriter fw = new FileWriter(prendi);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(aliasPrendi);
            bw.flush();
            bw.close();
            fw.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void setUsa(File usa) {

        String aliasUsa = "usa\nutilizza\nmetti\napri\nfai\nspingi";

        try {
            usa.createNewFile();
            FileWriter fw = new FileWriter(usa);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(aliasUsa);
            bw.flush();
            bw.close();
            fw.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void setVai(File vai) {

        String aliasVai = "vai\ndirigiti\nmuoviti\nentra\nsali";

        try {
            vai.createNewFile();
            FileWriter fw = new FileWriter(vai);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(aliasVai);
            bw.flush();
            bw.close();
            fw.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static Map fileCreator() {

        directoryCreator();

        File osserva = new File(OSSERVA_PATH);
        File parla = new File(PARLA_PATH);
        File prendi = new File(PRENDI_PATH);
        File usa = new File(USA_PATH);
        File vai = new File(VAI_PATH);

        if (!osserva.exists()) {
            setOsserva(osserva);
            //inserire get path e capire il ritorno se hash map o array list
        }
        if (!parla.exists()) {
            setParla(parla);
        }
        if (!prendi.exists()) {
            setPrendi(prendi);
        }
        if (!usa.exists()) {
            setUsa(usa);
        }
        if (!vai.exists()) {
            setVai(vai);
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
}
