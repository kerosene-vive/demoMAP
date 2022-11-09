package com.example.UTILITIES;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import netscape.javascript.JSObject;

public class Api {

    public static String wheather() {
        //call this wheather api https://api.open-meteo.com/v1/forecast?latitude=41.14&longitude=16.81&hourly=temperature_2m,rain
        //and return the wheather
        try {
            URL url = new URL("https://api.open-meteo.com/v1/forecast?latitude=41.14&longitude=16.81&hourly=temperature_2m,rain&current_weather=true");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("current_weather", "true");
            con.setDoOutput(true);
            con.setDoInput(true);
            con.connect();
            int status = con.getResponseCode();
            if (status == 200) {
                //SAVE THE RESPONSE AS A JSON OBJECT

                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String inputLine;
                StringBuffer content = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                    content.append(inputLine);
                }
                in.close();
                con.disconnect();
                ///take the substring after the first instance of "temperature" anbd before the first instance of "rain"
                String temp = content.substring(content.indexOf("temperature") + 12, content.indexOf("windspeed") - 2);

                return temp;
            } else {
                con.disconnect();
                return "";
            }
        } catch (Exception e) {
            return "";
        }

    }
}
