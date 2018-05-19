package de.chaoscrafterhd.tsbot;

import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.*;

public class Config {

    public static void config(String[] args) {

        JSONObject obj = new JSONObject();
        obj.put("servername", "DeinServer");
        obj.put("alertcmd", "!alert");
        obj.put("alertcmdc", "alert");
        obj.put("ruhecom", "!ruhe");
        obj.put("ruhemsg", " um den Ruhe-Rang zu erhalten!");
        obj.put("verifymsg", " um dich zu verifizieren!");
        obj.put("welcomemsg", "Willkommen! Auf dem ");
        obj.put("welcomemessage", "-Teamspeak Server");
        obj.put("pokecmd", "!poke");
        obj.put("verifycmd", "!verify");
        obj.put("kicknickmsg", "Bitte trage hier den Usernamen ein:");
        obj.put("kickgrundmsg", "Bitte trage hier den Grund ein:");
        obj.put("kickfertigmsg", "Der User wurde erfolgreich gekickt!");
        obj.put("kickcmd", "kick");
        obj.put("bancmd", "ban");
        obj.put("bannickmsg", "Bitte trage hier den Usernamen ein:");
        obj.put("bangrundmsg", "Bitte trage hier den Grund ein:");
        obj.put("bandauermsg", "Bitte trage hier die Bandauer (In Sekunden) ein (0 ist permanent!):");
        obj.put("banfertigmsg", "Der User wurde erfolgreich gebannt!");
        obj.put("helpcmd", "help");
        obj.put("qport", "10011");
        obj.put("stopcmd", "stop");
        obj.put("pokecmdc", "poke");
        obj.put("permaban", "permaban");


        obj.put("supportchannelid", "1");
        obj.put("afkchannelid", "1");
        obj.put("supportgruppenid", "1");
        obj.put("keinsupportid", "1");
        obj.put("ruheid", "1");
        obj.put("botruheid","1");
        obj.put("feedbacklink","https://sbodyhd.de/");
        obj.put("eingangshallenid","1");
        obj.put("statschannelid","1");
        obj.put("botgruppenid","1");
        obj.put("onlinechannelid","1");


        obj.put("joinmsg1", "Deine 1 Reihe der WIllkommensnachricht");
        obj.put("joinmsg2", "Deine 2 Reihe der WIllkommensnachricht");
        obj.put("joinmsg3", "Deine 3 Reihe der WIllkommensnachricht");
        obj.put("joinmsg4", "Deine 4 Reihe der WIllkommensnachricht");
        obj.put("joinmsg5", "Deine 5 Reihe der WIllkommensnachricht");
        obj.put("joinmsg6", "Deine 6 Reihe der WIllkommensnachricht");
        obj.put("joinmsg7", "Deine 7 Reihe der WIllkommensnachricht");
        obj.put("joinmsg8", "Deine 8 Reihe der WIllkommensnachricht");



        try {
            Throwable throwable = null;
            Object var2_4 = null;
            try {
                FileWriter file = new FileWriter("config.json");
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
            e.printStackTrace();
        }
        System.out.println(Language_Reader.csaved);
        System.out.println(obj);
    }


}