package com.example.GENERIC;
import filemanager.FileManager;
import java.util.Set;
import java.util.HashSet;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class verbs {
   private static Set<String> vai;
   private static Set<String> parla;
   private static Set<String> osserva;
   private static Set<String> prendi;
   private static Set<String> usa;
   
   private static final String VAI_FILE = "vai.txt";
   private static final String PARLA_FILE = "parla.txt";
   private static final String  OSSERVA_FILE = "osserva.txt";
   private static final String PRENDI_FILE = "prendi.txt";
   private static final String USA_FILE = "usa.txt";
   

   

    public static void init() {
        // Initialize the verbs from txt files in RESOURCES and put them in the array
        // of verbs
        // TODO
        
        Map filePaths = FileManager.fileCreator();
        String vaiRelativePath = (String) filePaths.get(VAI_FILE);
        String parlaRelativePath = (String) filePaths.get(PARLA_FILE);
        String osservaRelativePath = (String) filePaths.get(OSSERVA_FILE);
        String prendiRelativePath = (String) filePaths.get(PRENDI_FILE);
        String usaRelativePath = (String) filePaths.get(USA_FILE);
        
       
        vai = new HashSet<String>(addFileintoList(vaiRelativePath));
        parla = new HashSet<String>(addFileintoList(parlaRelativePath));
        osserva = new HashSet<String>(addFileintoList(osservaRelativePath));
        prendi = new HashSet<String>(addFileintoList(prendiRelativePath));
        usa = new HashSet<String>(addFileintoList(usaRelativePath));
       

    }



public static ArrayList<String> addFileintoList(String filepath) {
    Scanner s;
    ArrayList<String> list = new ArrayList<String>();
    try {
        s = new Scanner(new File(filepath));
    
    while (s.hasNext()){
       list.add(s.next());
    }
    s.close();

    } catch (FileNotFoundException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    return list;
}

   

    public static String getVerb(String sentence) {
        // Check if the verb is in the array of verbs
        // TODO


        String[] words = sentence.split(" ");
        for (String string : words) {
            if (vai.contains(string)) {
                return "vai";
            }
            else if (parla.contains(string)) {
                return "parla";
            }
            else if (osserva.contains(string)) {
                return "osserva";
            }
            else if (prendi.contains(string)) {
                return "prendi";
            }
            else if (usa.contains(string)) {
                return "usa";
            }
        }
        return "null";
        }
       

   
}
