package de.chaoscrafterhd.tsbot;

import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

public class Language_EN {

    public static void config(String[] args) {

        JSONObject obj = new JSONObject();



        obj.put("servername", "YourServer");
        obj.put("ruhemsg", " to get the quiet-rank!");
        obj.put("verifymsg", " to verify as a human!");
        obj.put("welcomemsg", "Welcome to ");
        obj.put("welcomemessage", "-Teamspeak server");
        obj.put("kicknickmsg", "Please insert Username:");
        obj.put("kickgrundmsg", "Please insert reason:");
        obj.put("kickfertigmsg", "User succesfully kicked!");
        obj.put("bannickmsg", "Please insert Username:");
        obj.put("bangrundmsg", "Please insert reason:");
        obj.put("bandauermsg", "Please insert duration (in seconds) (0 = lifetime!):");
        obj.put("banfertigmsg", "User succesfully banned!");
        obj.put("bysign", "by");
        obj.put("andsign", "and");
        obj.put("helpdesc", "Show all commands");
        obj.put("stopdesc", "Stop the bot");
        obj.put("pokedesc", "Poke a user");
        obj.put("kickdesc", "Kick a user");
        obj.put("bandesc", "Ban a user");
        obj.put("permabandesc", "Ban a user permanently");
        obj.put("reloaddesc", "Reload bot");
        obj.put("setupdesc", "Open configuration");
        obj.put("changelogdesc", "Shows changes");
        obj.put("alertcmdcdesc", "Poke all users");
        obj.put("botloadingf", "finished!");
        obj.put("botloadings", "Loading Bot...");
        obj.put("commands", "commands:");
        obj.put("csaved", "Data saved successfully!");
        obj.put("nolicense", "No licensekey found!Please insert licensekey:");
        obj.put("licensekey", "Please insert licensekey:");
        obj.put("licensekeyy", "Correct! Restarting bot now!");
        obj.put("updatebeta", "The update, that found, is a beta version, that means, that not all features are working correctly!");
        obj.put("updatestable", "The update, that found, is a stable version, that means, that all features are working correctly!");
        obj.put("updatenointernet", "No update found, or no connection to update server!");
        obj.put("updatey", "Update found! Please download here: https://DOAMIN.ENDUNG/FOLDER1/FOLDER2/NAME.jar Attention: Updating your Bot can destroy your configuration-files!!");



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