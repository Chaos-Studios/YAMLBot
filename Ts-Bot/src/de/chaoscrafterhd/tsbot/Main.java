package de.chaoscrafterhd.tsbot;

import java.util.Scanner;
import java.util.logging.Level;

//"[B]" + Config_Reader.ruhecom + "[/B]" + Config_Reader.ruhemsg
import com.github.theholywaffle.teamspeak3.TS3Api;
import com.github.theholywaffle.teamspeak3.TS3Config;
import com.github.theholywaffle.teamspeak3.TS3Query;
import com.github.theholywaffle.teamspeak3.api.wrapper.Client;
import com.github.theholywaffle.teamspeak3.api.exception.TS3ConnectionFailedException;

import java.util.InputMismatchException;


public class Main {
    public static Scanner scan = new Scanner(System.in);
    //File file1 = new File("config.json");

    public static TS3Config config = new TS3Config();
    public static TS3Query query = new TS3Query(config);
    public static TS3Api api = new TS3Api(query);
    public static String servername;
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
    public static String botloadingf;
    public static String banfertigmsg;
    public static String botloadings;
    public static String commands;
    public static String nolicense;
    public static String licensekey;
    public static String alertcmdcdesc;
    public static String updatebeta;
    public static String updatestable;
    public static String licensekeyy;
    public static String updatenointernet;
    public static String updatey;
    public static String csaved;
    public static String helpdesc;
    public static String stopdesc;
    public static String pokedesc;
    public static String kickdesc;
    public static String bandesc;
    public static String permabandesc;
    public static String reloaddesc;
    public static String setupdesc;
    public static String changelogdesc;



    public static void main(String[] args) {
        Language_Reader.read(args);
        Config_Reader.read(args);
        Connection_Reader.read(args);
    	Main.main2(args);
    	addWords();



    }
    public static void addWords(){
        TSEvents.words.add("hurensohn");
    }
    
    public static void main2(String[] args) {
        afkmover.start();
        AutobanSupport_Reader.read(args);
        // if (!File(file1).exists() {
        //    Config.config(args);
        // }


        System.out.println(" __    __  ______           __       ____            __      ");
        System.out.println("/\\ \\  /\\ \\/\\  _  \\  /'\\_/`\\/\\ \\     /\\  _`\\         /\\ \\__   ");
        System.out.println("\\ `\\`\\\\/'/\\ \\ \\ \\ \\/\\      \\ \\ \\    \\ \\ \\ \\ \\    ___\\ \\ ,_\\  ");
        System.out.println(" `\\ `\\ /'  \\ \\  __ \\ \\ \\__\\ \\ \\ \\  __\\ \\  _ <'  / __`\\ \\ \\/  ");
        System.out.println("   `\\ \\ \\   \\ \\ \\/\\ \\ \\ \\_/\\ \\ \\ \\ \\ \\\\ \\ \\ \\ \\/\\ \\ \\ \\ \\ \\_ ");
        System.out.println("     \\ \\_\\   \\ \\_\\ \\_\\ \\_\\\\ \\_\\ \\____/ \\ \\____/\\ \\____/\\ \\__\\");
        System.out.println("      \\/_/    \\/_/\\/_/\\/_/ \\/_/\\/___/   \\/___/  \\/___/  \\/__/");
        System.out.println("");
        System.out.println("FREE");
        System.out.println("");
        System.out.println("");
        System.out.println("Version 1.4.2 STABLE" + ":" + " BungeeYAML " + Language_Reader.andsign + " ChaoscrafterHD");
        System.out.println(Language_Reader.botloadings);
        System.out.println(Language_Reader.botloadingf);
        Main.connect();

        System.out.println(Language_Reader.commands);
        System.out.println(" - " + Config_Reader.helpcmd + " >> " + Language_Reader.helpdesc);
        System.out.println(" - " + Config_Reader.stopcmd + " >> " + Language_Reader.stopdesc);
        System.out.println(" - " + Config_Reader.pokecmdc + " >> " + Language_Reader.pokedesc);
        System.out.println(" - " + Config_Reader.kickcmd + " >> " + Language_Reader.kickdesc);
        System.out.println(" - " + Config_Reader.bancmd + " >> " + Language_Reader.bandesc);
        System.out.println(" - " + Config_Reader.alertcmdc + " >> " + Language_Reader.alertcmdcdesc);
        System.out.println(" - " + Config_Reader.permaban + " >> " + Language_Reader.permabandesc);
        System.out.println(" - " + "reload" + " >> " + Language_Reader.reloaddesc);
        System.out.println(" - " + "setup" + " >> " + Language_Reader.setupdesc);
        System.out.println(" - changelog >> " + Language_Reader.changelogdesc);


        Update.Updatecheck(args);
        while (true) {
            String cmd = scan.nextLine();
            if (cmd.equalsIgnoreCase(Config_Reader.stopcmd)) {
                AutobanSupport.supportins = Integer.toString(TSEvents.supportin);
                AutobanSupport.autobans = Integer.toString(TSEvents.autoban);
                AutobanSupport.config(args);
                System.out.println("Bot wird gestoppt...");
                try {
                    Thread.sleep(200);
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
                System.out.println("Disconnected");
                try {
                    Thread.sleep(20);
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
                System.exit(0);


            } else if (cmd.equalsIgnoreCase(Config_Reader.pokecmdc)) {
                System.out.println("Gib den Nicknamen vom Client ein");
                String targetclient = scan.nextLine();
                System.out.println("Gib den grund ein ein.");
                String grund = scan.nextLine();
                try {
                    Main.api.pokeClient(Main.api.getClientByNameExact(targetclient, true).getId(), grund);
                } catch (NullPointerException e) {
                    System.out.println("Es ist ein Fehler unterlaufen (Name muss ohne Sonderzeichen sein)");

                }
            } else if (cmd.equalsIgnoreCase("alert")) {
                System.out.println("Gib eine Nachricht an");
                String msg = scan.nextLine();
                for (Client clients : api.getClients()) {
                    if (clients.getType() != 0) continue;
                    api.sendPrivateMessage(clients.getId(), msg);
                }
                System.out.println("Nachricht wurde versand");

            } else if (cmd.equalsIgnoreCase("setup")) {
                System.out.println("Bitte wähle, welche Config generiert werden soll: languages");
                String setupw = scan.nextLine();

                if (setupw.contains("languages")) {

                    System.out.println("Wie heißt dein Server?");
                    servername = scan.nextLine();


                    System.out.println("Wie soll die Beschreibung des !ruhe-Befehls sein?");
                    ruhemsg = scan.nextLine();

                    System.out.println("Wie soll die Beschreibung des !verify-Befehls sein?");
                    verifymsg = scan.nextLine();

                    System.out.println("Wie soll die Willkommensnachricht vor dem Servernamen sein?");
                    welcomemsg = scan.nextLine();

                    System.out.println("Wie soll die Willkommensnachricht nach dem Servernamen sein?");
                    welcomemessage = scan.nextLine();

                    System.out.println("Wie soll die Frage nach dem Usernamen beim kicken sein?");
                    kicknickmsg = scan.nextLine();

                    System.out.println("Wie soll die Frage nach dem Grund beim kicken sein?");
                    kickgrundmsg = scan.nextLine();

                    System.out.println("Welche Nachricht soll angezeigt werden, wenn ein User erfolgreich gekickt wurde?");
                    kickfertigmsg = scan.nextLine();

                    /**/
                    System.out.println("Welche Nachricht soll angezeigt werden, wenn nach dem User der gebannt werden soll gefragt wird?");
                    bannickmsg = scan.nextLine();

                    System.out.println("Welche Nachricht soll angezeigt werden, wenn nach dem Bangrund gefragt wird?");
                    bangrundmsg = scan.nextLine();

                    System.out.println("Welche Nachricht soll angezeigt werden, wenn nach der Bandauer gefragt wird?");
                    bandauermsg = scan.nextLine();

                    System.out.println("Welche Nachricht soll angezeigt werden, wenn der Bot fertig ist mit laden?");
                    botloadingf = scan.nextLine();

                    System.out.println("Welche Nachricht soll angezeigt werden, wenn ein User erfolgreich gebannt wurde?");
                    banfertigmsg = scan.nextLine();

                    System.out.println("Welche Nachricht soll angezeigt werden, wenn der Bot anfängt zu laden?");
                    botloadings = scan.nextLine();

                    System.out.println("Wie sollen die Befehle heißen (z.B: Befehle: / commands:)?");
                    commands = scan.nextLine();

                    System.out.println("Welche Nachricht soll angezeigt werden, wenn ein user den falschen Lizenzschlüssel eingegeben hat?");
                    nolicense = scan.nextLine();

                    System.out.println("Welche Nachricht soll angezeigt werden, wenn ein User den Lizenzschlüssel eingeben soll?");
                    licensekey = scan.nextLine();

                    System.out.println("Welche Nachricht soll angezeigt werden, wenn das Update eine Beta Version ist?");
                    updatebeta = scan.nextLine();

                    System.out.println("Welche Nachricht soll angezeigt werden, wenn das Update eine Stable Version ist?");
                    updatestable = scan.nextLine();

                    System.out.println("Welche Nachricht soll angezeigt werden, wenn der Lizenzschlüssel korrekt war?");
                    licensekeyy = scan.nextLine();

                    System.out.println("Welche Nachricht soll angezeigt werden, wenn kein Update verfügbar ist?");
                    updatenointernet = scan.nextLine();

                    System.out.println("Welche Nachricht soll angezeigt werden, wenn ein Update verfügbar ist?");
                    updatey = scan.nextLine();

                    System.out.println("Welche Nachricht soll angezeigt werden, wenn eine Konfigurationsdatei gespeichert wurde?");
                    csaved = scan.nextLine();

                    /**/
                    System.out.println("Welche Beschreibung soll der help Befehl haben?");
                    helpdesc = scan.nextLine();

                    System.out.println("Welche Beschreibung soll der stop Befehl haben?");
                    stopdesc = scan.nextLine();

                    System.out.println("Welche Beschreibung soll der poke Befehl haben?");
                    pokedesc = scan.nextLine();

                    System.out.println("Welche Beschreibung soll der kick Befehl haben?");
                    kickdesc = scan.nextLine();

                    System.out.println("Welche Beschreibung soll der ban Befehl haben?");
                    bandesc = scan.nextLine();

                    System.out.println("Welche Beschreibung soll der permaban Befehl haben?");
                    permabandesc = scan.nextLine();

                    System.out.println("Welche Beschreibung soll der reload Befehl haben?");
                    reloaddesc = scan.nextLine();

                    System.out.println("Welche Beschreibung soll der setup Befehl haben?");
                    setupdesc = scan.nextLine();

                    System.out.println("Welche Beschreibung soll der changelog Befehl haben?");
                    changelogdesc = scan.nextLine();

                    System.out.println("Welche Beschreibung soll der alert Befehl haben?");
                    alertcmdcdesc = scan.nextLine();


                    System.out.println("Möchtest du die Einstellungen wirklich speichern, dies wird deine alte Sprachdatei löschen!(Ja/Nein)");
                    String wirklich = scan.nextLine();

                    if (wirklich.contains("Ja")) {
                        Language_Custom.config(args);
                        System.out.println("Um die Einstellungen zu übernehmen, musst du den Bot neustarten oder reloaden! Soll der Bot jetzt neugeladen werden (Ja/Nein)?");
                        String reloadq = scan.nextLine();

                        if (reloadq.contains("Ja")) {
                            Main.main(args);
                        }


                    }}





                    /*




















                     */


                } else if (cmd.equalsIgnoreCase(Config_Reader.helpcmd)) {
                    System.out.println(Language_Reader.commands);
                    System.out.println(" - " + Config_Reader.helpcmd + " >> " + Language_Reader.helpdesc);
                    System.out.println(" - " + Config_Reader.stopcmd + " >> " + Language_Reader.stopdesc);
                    System.out.println(" - " + Config_Reader.pokecmdc + " >> " + Language_Reader.pokedesc);
                    System.out.println(" - " + Config_Reader.kickcmd + " >> " + Language_Reader.kickdesc);
                    System.out.println(" - " + Config_Reader.bancmd + " >> " + Language_Reader.bandesc);
                    System.out.println(" - " + Config_Reader.permaban + " >> " + Language_Reader.permabandesc);
                    System.out.println(" - " + "reload" + " >> " + Language_Reader.reloaddesc);
                    System.out.println(" - " + "setup" + " >> " + Language_Reader.setupdesc);
                    System.out.println(" - changelog >> " + Language_Reader.changelogdesc);


                } else if (cmd.equalsIgnoreCase(Config_Reader.kickcmd)) {
                    System.out.println(Config_Reader.kicknickmsg);
                    String targetclient = scan.nextLine();
                    System.out.println(Config_Reader.kickgrundmsg);
                    String grund = scan.nextLine();
                    Main.api.kickClientFromServer(grund, Main.api.getClientByNameExact(targetclient, true));
                    System.out.println(Config_Reader.kickfertigmsg);


                } else if (cmd.equalsIgnoreCase("changelog")) {
                    System.out.println("Changelog des letzten Updates:");
                    System.out.println(" - Lizenzserver gelöscht");
                    System.out.println(" - Lizenzabfrage entfernt");
                    System.out.println(" - Sourcecode freigegeben");

                } else if (cmd.equalsIgnoreCase("reload")) {
                    Main.main(args);


                } else if (cmd.equalsIgnoreCase(Config_Reader.bancmd)) {
                    System.out.println(Config_Reader.bannickmsg);
                    String targetclient = scan.nextLine();
                    System.out.println(Config_Reader.bangrundmsg);
                    String grund = scan.nextLine();
                    System.out.println(Config_Reader.bandauermsg);
                    long dauer = scan.nextLong();


                    Main.api.banClient(Main.api.getClientByNameExact(targetclient, true).getId(), dauer, grund);
                    System.out.println(Config_Reader.banfertigmsg);


                } else if (cmd.equalsIgnoreCase(Config_Reader.permaban)) {
                    System.out.println(Config_Reader.bannickmsg);
                    String targetclient = scan.nextLine();
                    System.out.println(Config_Reader.bangrundmsg);
                    String grund = scan.nextLine();
                    System.out.println("Bist du dir sicher(Ja/Nein)?");
                    String rest1 = scan.nextLine();
                    if (rest1.contains("ja")) {
                        Main.api.banClient(Main.api.getClientByNameExact(targetclient, true).getId(), 0, grund);
                        System.out.println(Config_Reader.banfertigmsg);
                    } else {

                    }
                    if (rest1.contains("Ja")) {
                        Main.api.banClient(Main.api.getClientByNameExact(targetclient, true).getId(), 0, grund);
                        System.out.println(Config_Reader.banfertigmsg);
                    } else {

                    }
                    if (rest1.contains("j")) {
                        Main.api.banClient(Main.api.getClientByNameExact(targetclient, true).getId(), 0, grund);
                        System.out.println(Config_Reader.banfertigmsg);
                    } else {

                    }
                    if (rest1.contains("yes")) {
                        Main.api.banClient(Main.api.getClientByNameExact(targetclient, true).getId(), 0, grund);
                        System.out.println(Config_Reader.banfertigmsg);
                    } else {

                    }
                    if (rest1.contains("y")) {
                        Main.api.banClient(Main.api.getClientByNameExact(targetclient, true).getId(), 0, grund);
                        System.out.println(Config_Reader.banfertigmsg);
                    } else {

                    }
                } else {
                    System.out.println("Bitte gib einen gültigen Befehl an");


                }
            }
        }


        public static void connect () {
            try {
                config.setHost(Connection_Reader.host);
                config.setFloodRate(TS3Query.FloodRate.UNLIMITED);
                config.setDebugLevel(Level.ALL);
                query.connect();
                api.selectVirtualServerByPort((int) Connection_Reader.port);
                api.login(Connection_Reader.user, Connection_Reader.password);
                api.setNickname(Connection_Reader.nick);
                System.out.println("Bot Verbunden");
                TSEvents.load();
            } catch (InputMismatchException e) {
                System.out.println("Konnte keine Verbindung zum Teamspeak 3 Server herstellen, bitte erneut versuchen!");
            } catch (TS3ConnectionFailedException e) {
                System.out.println("Die verbindung zum Teamspeak 3 Server konnte nicht hergestellt werden!");
            }
        }
    }

