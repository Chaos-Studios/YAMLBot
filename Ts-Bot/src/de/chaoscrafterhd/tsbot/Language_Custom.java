package de.chaoscrafterhd.tsbot;

import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

public class Language_Custom {

    public static void config(String[] args) {

        JSONObject obj = new JSONObject();
        obj.put("servername", Main.servername);
        obj.put("ruhemsg", Main.ruhemsg);
        obj.put("verifymsg", Main.verifymsg);
        obj.put("welcomemsg", Main.welcomemsg);
        obj.put("welcomemessage", Main.welcomemessage);
        obj.put("kicknickmsg", Main.kicknickmsg);
        obj.put("kickgrundmsg", Main.kickgrundmsg);
        obj.put("kickfertigmsg", Main.kickfertigmsg);
        obj.put("bannickmsg", Main.bannickmsg);
        obj.put("bangrundmsg", Main.bangrundmsg);
        obj.put("bandauermsg", Main.bandauermsg);
        obj.put("banfertigmsg", Main.banfertigmsg);
        obj.put("updatestable", Main.updatestable);
        obj.put("updatebeta", Main.updatebeta);
        obj.put("bysqign", "von");
        obj.put("andsign", "und");
        obj.put("helpdesc", Main.helpdesc);
        obj.put("stopdesc", Main.stopdesc);
        obj.put("pokedesc", Main.pokedesc);
        obj.put("kickdesc", Main.kickdesc);
        obj.put("alertcmdcdesc", Main.alertcmdcdesc);
        obj.put("bandesc", Main.bandesc);
        obj.put("permabandesc", Main.permabandesc);
        obj.put("reloaddesc", Main.reloaddesc);
        obj.put("setupdesc", Main.setupdesc);
        obj.put("changelogdesc", Main.changelogdesc);
        obj.put("botloadingf", Main.botloadingf);
        obj.put("botloadings", Main.botloadings);
        obj.put("commands", Main.commands);
        obj.put("nolicense", Main.nolicense);
        obj.put("licensekey", Main.licensekey);
        obj.put("licensekeyy", Main.licensekeyy);
        obj.put("updatenointernet", Main.updatenointernet);
        obj.put("updatey", Main.updatey);
        obj.put("csaved", Main.csaved);
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