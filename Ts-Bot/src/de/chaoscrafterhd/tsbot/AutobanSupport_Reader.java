package de.chaoscrafterhd.tsbot;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class AutobanSupport_Reader {



    public static int autoban;
    public static int supportin;
    public static String autobans;
    public static String supportins;




    public static void read(String[] args) {

        JSONParser parser = new JSONParser();

        try {

            Object obj = parser.parse(new FileReader("stats.json"));


            JSONObject jsonObject = (JSONObject) obj;

            autobans = (String) jsonObject.get("autoban");
            supportins = (String) jsonObject.get("supportin");


            supportin = Integer.valueOf(supportins);

            autoban = Integer.valueOf(autobans);





        }
        catch (FileNotFoundException e) {
            System.out.println("Keine Stats Datei gefunden, es wird nun eine erstellt!");
            AutobanSupport1.config(args);
            AutobanSupport_Reader.read(args);
            Main.main(args);
        }
        catch (IOException e) {

        }
        catch (ParseException e) {

        }
    }
}



