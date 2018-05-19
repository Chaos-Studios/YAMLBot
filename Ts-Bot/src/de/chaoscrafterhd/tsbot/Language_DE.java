package de.chaoscrafterhd.tsbot;

import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

public class Language_DE {


    public static void config(String[] args) {

        JSONObject obj = new JSONObject();
        obj.put("servername", "DeinServer");
        obj.put("ruhemsg", " um den Ruhe-Rang zu erhalten!");
        obj.put("verifymsg", " um dich zu verifizieren!");
        obj.put("welcomemsg", "Willkommen! Auf dem ");
        obj.put("welcomemessage", "-Teamspeak Server");
        obj.put("kicknickmsg", "Bitte trage hier den Usernamen ein:");
        obj.put("kickgrundmsg", "Bitte trage hier den Grund ein:");
        obj.put("kickfertigmsg", "Der User wurde erfolgreich gekickt!");
        obj.put("bannickmsg", "Bitte trage hier den Usernamen ein:");
        obj.put("bangrundmsg", "Bitte trage hier den Grund ein:");
        obj.put("bandauermsg", "Bitte trage hier die Bandauer (In Sekunden) ein (0 ist permanent!):");
        obj.put("banfertigmsg", "Der User wurde erfolgreich gebannt!");
        obj.put("bysqign", "von");
        obj.put("updatebeta", "Das verfügbare Update ist eine Beta Version, also werden nicht alle neuen Funktionen funktionieren");
        obj.put("updatestable", "Das verfügbare Update ist eine Stable Version, also werden alle neuen Funktionen funktionieren");
        obj.put("andsign", "und");
        obj.put("botloadingf", "Fertig!");
        obj.put("botloadings", "Lade Bot ...");
        obj.put("commands", "Befehle:");
        obj.put("helpdesc", "Zeigt alle Befehle an");
        obj.put("stopdesc", "Stoppt den Bot");
        obj.put("pokedesc", "Stupst einen User an");
        obj.put("alertcmdcdesc", "Stupst alle User an");
        obj.put("kickdesc", "Kickt einen User");
        obj.put("bandesc", "Bannt einen Spieler");
        obj.put("permabandesc", "Bannt einen User dauerhaft");
        obj.put("reloaddesc", "Lädt den Bot neu");
        obj.put("setupdesc", "Öffnet den Konfigurator");
        obj.put("changelogdesc", "Zeigt die letzten Änderungen an");
        obj.put("csaved", "Daten gespeichert!");
        obj.put("nolicense", "Es wurde kein Lizenzschlüssel gefunden!Bitte trage deinen hier ein:");
        obj.put("licensekey", "Bitte trage hier deinen Lizenzschlüssel ein");
        obj.put("licensekeyy", "Korrekt! Der Bot startet nun neu!");
        obj.put("updatenointernet", "Es wurde kein Update gefunden, oder es konnte keine Verbindung zu den Update Servern hergestellt werden");
        obj.put("updatey", "Es wurde ein Update gefunden, bitte lade es dir hier herunter: https://DOAMIN.ENDUNG/FOLDER1/FOLDER2/NAME.jar Achtung: Es kann sein, dass du deine Configs neumachen musst!");
//updatenointernet



        try {
            Throwable throwable = null;
            Object var2_4 = null;
            try {
                FileWriter file = new FileWriter("language.json");
                try {
                    file.write(obj.toJSONString());
                    file.flush();
                }
                finally {
                    if (file != null) {
                        file.close();
                    }
                }
            }
            catch (Throwable throwable2) {
                if (throwable == null) {
                    throwable = throwable2;
                } else if (throwable != throwable2) {
                    throwable.addSuppressed(throwable2);
                }
                throw throwable2;
            }
        }
        catch (IOException e) {
    
        }
        System.out.println(Language_Reader.csaved);

    }


}