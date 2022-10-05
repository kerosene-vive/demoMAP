package com.example.GENERIC;
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

    public static void init() {
        // Initialize the verbs from txt files in RESOURCES and put them in the array
        // of verbs
        // TODO
        
        String vaiRelativePath = "src/main/java/com/example/RESOURCES/verbsAlias/vai.txt";
        String parlaRelativePath = "src/main/java/com/example/RESOURCES/verbsAlias/parla.txt";
        String osservaRelativePath = "src/main/java/com/example/RESOURCES/verbsAlias/osserva.txt";
        String prendiRelativePath = "src/main/java/com/example/RESOURCES/verbsAlias/prendi.txt";
        String usaRelativePath = "src/main/java/com/example/RESOURCES/verbsAlias/usa.txt";
        
        
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
