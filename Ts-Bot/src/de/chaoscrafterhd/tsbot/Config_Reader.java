package de.chaoscrafterhd.tsbot;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.*;

public class Config_Reader {



    public static String ruhecom;

    public static String supportchannelid;
    public static String afkchannelid;
    public static String supportgruppenid;
    public static String keinsupportid;
    public static String ruheid;
    public static String botruheid;
    public static String feedbacklink;
    public static String eingangshallenid;
    public static String statschannelid;
    public static String botgruppenid;
    public static String onlinechannelid;




    public static String ruhemsg;
    public static String verifymsg;
    public static String welcomemsg;
    public static String welcomemessage;
    public static String pokecmd;
    public static String verifycmd;
    public static String kicknickmsg;
    public static String kickgrundmsg;
    public static String kickfertigmsg;
    public static String kickcmd;
    public static String bancmd;
    public static String bannickmsg;
    public static String bangrundmsg;
    public static String bandauermsg;
    public static String banfertigmsg;
    public static String helpcmd;
    public static String stopcmd;
    public static String pokecmdc;
    public static String servername;
    public static String alertcmd;
    public static String qport;
    public static String permaban;
    public static String joinmsg1;
    public static String joinmsg2;
    public static String joinmsg3;
    public static String joinmsg4;
    public static String joinmsg5;
    public static String joinmsg8;

    public static String joinmsg6;
    public static String joinmsg7;
    public static String alertcmdc;


    public static void read(String[] args) {

        JSONParser parser = new JSONParser();

        try {

            Object obj = parser.parse(new FileReader("config.json"));


            JSONObject jsonObject = (JSONObject) obj;
            System.out.println(jsonObject);

            servername = (String) jsonObject.get("servername");



            qport = (String) jsonObject.get("qport");

            alertcmd = (String) jsonObject.get("alertcmd");
            alertcmdc = (String) jsonObject.get("alertcmdc");



            ruhecom = (String) jsonObject.get("ruhecom");

            joinmsg1 = (String) jsonObject.get("joinmsg1");

            joinmsg2 = (String) jsonObject.get("joinmsg2");

            joinmsg3 = (String) jsonObject.get("joinmsg3");

            joinmsg4 = (String) jsonObject.get("joinmsg4");

            joinmsg5 = (String) jsonObject.get("joinmsg5");

            joinmsg6 = (String) jsonObject.get("joinmsg6");
            joinmsg7 = (String) jsonObject.get("joinmsg7");
            joinmsg8 = (String) jsonObject.get("joinmsg8");


            ruheid = (String) jsonObject.get("ruheid");
            supportchannelid = (String) jsonObject.get("supportchannelid");
            supportgruppenid = (String) jsonObject.get("supportgruppenid");
            afkchannelid = (String) jsonObject.get("afkchannelid");
            keinsupportid = (String) jsonObject.get("keinsupportid");
            botruheid = (String) jsonObject.get("botruheid");
            feedbacklink = (String) jsonObject.get("feedbacklink");
            eingangshallenid = (String) jsonObject.get("eingangshallenid");
            statschannelid = (String) jsonObject.get("statschannelid");
            botgruppenid = (String) jsonObject.get("botgruppenid");
            onlinechannelid = (String) jsonObject.get("onlinechannelid");


            ruhemsg = (String) jsonObject.get("ruhemsg");

            verifymsg = (String) jsonObject.get("verifymsg");


            welcomemsg = (String) jsonObject.get("welcomemsg");

            welcomemessage = (String) jsonObject.get("welcomemessage");

            pokecmd = (String) jsonObject.get("pokecmd");

            verifycmd = (String) jsonObject.get("verifycmd");

            kicknickmsg = (String) jsonObject.get("kicknickmsg");

            kickgrundmsg = (String) jsonObject.get("kickgrundmsg");

            kickfertigmsg = (String) jsonObject.get("kickfertigmsg");

            kickcmd = (String) jsonObject.get("kickcmd");

            bancmd = (String) jsonObject.get("bancmd");

            bannickmsg = (String) jsonObject.get("bannickmsg");

            bangrundmsg = (String) jsonObject.get("bangrundmsg");

            bandauermsg = (String) jsonObject.get("bandauermsg");

            banfertigmsg = (String) jsonObject.get("banfertigmsg");

            helpcmd = (String) jsonObject.get("helpcmd");

            stopcmd = (String) jsonObject.get("stopcmd");

            pokecmdc = (String) jsonObject.get("pokecmdc");
            permaban = (String) jsonObject.get("permaban");





        }
        catch (FileNotFoundException e) {
            System.out.println("Keine Config Datei gefunden, es wird nun eine erstellt!");
            Config.config(args);
            Config_Reader.read(args);
            Main.main(args);
        }
        catch (IOException e) {
            
        }
        catch (ParseException e) {
            
        }
    }
    }



