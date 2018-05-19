package de.chaoscrafterhd.tsbot;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Connection_Reader {


    public static String host;
    public static String user;
    public static String password;
    public static String nick;
    public static long port;





    public static void read(String[] args) {

        JSONParser parser = new JSONParser();

        try {

            Object obj = parser.parse(new FileReader("connection.json"));


            JSONObject jsonObject = (JSONObject) obj;
            System.out.println(jsonObject);



            port = (Long) jsonObject.get("port");



            host = (String)jsonObject.get("host");


            user = (String)jsonObject.get("user");

            password = (String)jsonObject.get("password");

            nick = (String) jsonObject.get("nick");







        }
        catch (FileNotFoundException e) {
            System.out.println("Keine Connections Datei gefunden, es wird nun eine erstellt!");
            Connection.config(args);
            Connection_Reader.read(args);
            Main.main(args);
        }
        catch (IOException e) {
            
        }
        catch (ParseException e) {
            
        }
    }
    }



