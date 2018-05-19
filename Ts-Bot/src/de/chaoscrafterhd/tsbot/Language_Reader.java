package de.chaoscrafterhd.tsbot;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Language_Reader {



    public static String ruhemsg;
    public static String verifymsg;
    public static String welcomemsg;
    public static String welcomemessage;
    public static String kicknickmsg;
    public static String kickgrundmsg;
    public static String kickfertigmsg;
    public static String bannickmsg;
    public static String bangrundmsg;
    public static String bandauermsg;
    public static String banfertigmsg;
    public static String bysign;
    public static String updatebeta;
    public static String updatestable;
    public static String servername;
    public static String andsign;
    public static String botloadings;
    public static String botloadingf;
    public static String commands;
    public static String nolicense;
    public static String licensekey;
    public static String licensekeyy;
    public static String updatenointernet;
    public static String updatey;
    public static String csaved;
    public static String alertcmdcdesc;

    //gg
    public static String helpdesc;
    public static String reloaddesc;
    public static String setupdesc;
    public static String pokedesc;
    public static String stopdesc;
    public static String kickdesc;
    public static String bandesc;
    public static String permabandesc;
    public static String changelogdesc;
//updatenointernet
    //updatey


    public static Scanner scan = new Scanner(System.in);

    public static void read(String[] args) {

        JSONParser parser = new JSONParser();

        try {

            Object obj = parser.parse(new FileReader("language.json"));


            JSONObject jsonObject = (JSONObject) obj;
            System.out.println(jsonObject);

            servername = (String) jsonObject.get("servername");
            updatey = (String) jsonObject.get("updatey");




            botloadingf = (String) jsonObject.get("botloadingf");

            botloadings = (String) jsonObject.get("botloadings");
            alertcmdcdesc = (String) jsonObject.get("alertcmdcdesc");
            commands = (String) jsonObject.get("commands");
            nolicense = (String) jsonObject.get("nolicense");
            licensekey = (String) jsonObject.get("licensekey");
            licensekeyy = (String) jsonObject.get("licensekeyy");
            updatenointernet = (String) jsonObject.get("updatenointernet");
            updatenointernet = (String) jsonObject.get("alertcmdcdesc");

            updatebeta = (String) jsonObject.get("updatebeta");

            updatestable = (String) jsonObject.get("updatestable");

            csaved = (String) jsonObject.get("csaved");
            helpdesc = (String) jsonObject.get("helpdesc");
            stopdesc = (String) jsonObject.get("stopdesc");
            reloaddesc = (String) jsonObject.get("reloaddesc");
            bandesc = (String) jsonObject.get("bandesc");
            permabandesc = (String) jsonObject.get("permabandesc");
            kickdesc = (String) jsonObject.get("kickdesc");
            setupdesc = (String) jsonObject.get("setupdesc");
            changelogdesc = (String) jsonObject.get("changelogdesc");
            pokedesc = (String) jsonObject.get("pokedesc");








            ruhemsg = (String) jsonObject.get("ruhemsg");

            verifymsg = (String) jsonObject.get("verifymsg");


            welcomemsg = (String) jsonObject.get("welcomemsg");

            welcomemessage = (String) jsonObject.get("welcomemessage");


            kicknickmsg = (String) jsonObject.get("kicknickmsg");

            kickgrundmsg = (String) jsonObject.get("kickgrundmsg");

            kickfertigmsg = (String) jsonObject.get("kickfertigmsg");


            bannickmsg = (String) jsonObject.get("bannickmsg");

            bangrundmsg = (String) jsonObject.get("bangrundmsg");

            bandauermsg = (String) jsonObject.get("bandauermsg");

            banfertigmsg = (String) jsonObject.get("banfertigmsg");


            bysign = (String) jsonObject.get("bysign");

            andsign = (String) jsonObject.get("andsign");





        }
        catch (FileNotFoundException e) {
            System.out.println("Bitte wähle eine Sprache/Please choose a language(Deutsch,Englisch/German,English)!");
            String lang = scan.nextLine();

            if(lang.contains("german")){
                System.out.println("Deutsche Sprachdatei wird heruntergeladen!");
                Language_DE.config(args);
                System.out.println("Sprachdatei erfolgreich heruntergeladen!");
                Language_Reader.read(args);
                Main.main(args);
            }
            if(lang.contains("German")){
                System.out.println("Deutsche Sprachdatei wird heruntergeladen!");
                Language_DE.config(args);
                System.out.println("Sprachdatei erfolgreich heruntergeladen!");
                Language_Reader.read(args);
                Main.main(args);
            }
            if(lang.contains("deutsch")){
                System.out.println("Deutsche Sprachdatei wird heruntergeladen!");
                Language_DE.config(args);
                System.out.println("Sprachdatei erfolgreich heruntergeladen!");
                Language_Reader.read(args);
                Main.main(args);
            }
            if(lang.contains("Deutsch")){
                System.out.println("Deutsche Sprachdatei wird heruntergeladen!");
                Language_DE.config(args);
                System.out.println("Sprachdatei erfolgreich heruntergeladen!");
                Language_Reader.read(args);
                Main.main(args);
            }
            if(lang.contains("Englisch")){
                System.out.println("English language is downloading!");
                Language_EN.config(args);
                System.out.println("Englisch language succesfully downloaded!");
                Language_Reader.read(args);
                Main.main(args);
            }
            if(lang.contains("englisch")){
                System.out.println("English language is downloading!");
                Language_EN.config(args);
                System.out.println("Englisch language succesfully downloaded!");
                Language_Reader.read(args);
                Main.main(args);
            }
            if(lang.contains("English")){
                System.out.println("English language is downloading!");
                Language_EN.config(args);
                System.out.println("Englisch language succesfully downloaded!");
                Language_Reader.read(args);
                Main.main(args);
            }
            if(lang.contains("english")){
                System.out.println("English language is downloading!");
                Language_EN.config(args);
                System.out.println("Englisch language succesfully downloaded!");
                Language_Reader.read(args);
                Main.main(args);
            }
            if(lang.contains("d")){
                System.out.println("Deutsche Sprachdatei wird heruntergeladen!");
                Language_DE.config(args);
                System.out.println("Sprachdatei erfolgreich heruntergeladen!");
                Language_Reader.read(args);
                Main.main(args);
            }
            if(lang.contains("g")){
                System.out.println("Deutsche Sprachdatei wird heruntergeladen!");
                Language_DE.config(args);
                System.out.println("Sprachdatei erfolgreich heruntergeladen!");
                Language_Reader.read(args);
                Main.main(args);
            }
            if(lang.contains("e")){
                System.out.println("English language is downloading!");
                Language_EN.config(args);
                System.out.println("Englisch language succesfully downloaded!");
                Language_Reader.read(args);
                Main.main(args);
            }

        }
        catch (IOException e) {
            
        }
        catch (ParseException e) {
            
        }
    }
    }



