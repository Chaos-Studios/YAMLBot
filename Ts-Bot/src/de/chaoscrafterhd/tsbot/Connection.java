package de.chaoscrafterhd.tsbot;

import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;

public class Connection {

    public static void config(String[] args) {

        JSONObject obj = new JSONObject();
        obj.put("host", "localhost");
        obj.put("user", "serveradmin");
        obj.put("password", "password");
        obj.put("nick", "Server | Bot");
        obj.put("port", new Integer((int)9987));




        try {
            Throwable throwable = null;
            Object var2_4 = null;
            try {
                FileWriter file = new FileWriter("connection.json");
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