package de.chaoscrafterhd.tsbot;

import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

public class AutobanSupport {

    public static String autobans;
    public static String supportins;


    public static void config(String[] args) {

        JSONObject obj = new JSONObject();
        obj.put("autoban", autobans);
        obj.put("supportin", supportins);



        try {
            Throwable throwable = null;
            Object var2_4 = null;
            try {
                FileWriter file = new FileWriter("stats.json");
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
        System.out.println("Erstellt");

    }


}