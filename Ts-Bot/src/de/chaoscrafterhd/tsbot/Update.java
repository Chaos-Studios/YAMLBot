package de.chaoscrafterhd.tsbot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.URL;

public class Update {


    public static void Updatecheck(String[] args) {
        String check = ReadURL("http://DOMAIN.ENDUNG/FOLDER/FOLDER2/FOLDER3/NAME.html");
        if (!check.contains("Version 1.4.2 STABLE")) {
            System.out.println(Language_Reader.updatey);

            if (check.contains("BETA")) {
                System.out.println(Language_Reader.updatebeta);


            } else {
                System.out.println(Language_Reader.updatestable);


            }

        }else{



        }


    }

    private static String ReadURL(String URL){
        String re = "";
        try
        {
            java.net.URL url = new URL(URL);
            Reader is = new InputStreamReader( url.openStream() );
            BufferedReader in = new BufferedReader( is );
            for ( String s; ( s = in.readLine() ) != null; )
                re = re + " " +s;

            in.close();
        }
        catch ( MalformedURLException e ) {
            System.out.println( "MalformedURLException: " + e );
        }
        catch ( IOException e ) {
            System.out.println( "IOException: " + e );
        }
        return re;
    }
}
