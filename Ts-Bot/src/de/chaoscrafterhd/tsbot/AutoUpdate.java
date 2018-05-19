package de.chaoscrafterhd.tsbot;

import java.net.MalformedURLException;
import java.net.URL;
import java.io.*;
import java.io.InputStreamReader;
import java.lang.String;


public class AutoUpdate
{
    public static void Checkversion(){

        String check = ReadURL("http://DOMAIN.ENDUNG/FOLDER1/FOLDER2/NAME.html");

        if(!check.contains("Version 1.4.2")){
            System.out.print(Language_Reader.updatey);


        }else{

            System.out.print(Language_Reader.updatenointernet);
        }




    }

    private static String ReadURL(String URL){
        String re = "";
        try
        {
            URL url = new URL(URL);
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