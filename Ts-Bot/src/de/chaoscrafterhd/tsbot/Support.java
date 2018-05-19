package de.chaoscrafterhd.tsbot;

import com.github.theholywaffle.teamspeak3.api.wrapper.Client;

import java.util.HashMap;

public class Support {
    public static HashMap<String, Integer> NUMMER = new HashMap<>();
    public static int RANGL;


    public static void Supportbenachrichtigung(String User, Integer SupportID){

        for(Client clients : Main.api.getClients()){
            if (clients.isInServerGroup(219)){

        Main.api.sendPrivateMessage(clients.getId(), "" +
                "" +
                "»------------------------=======[» SupportAnfrage «]=======------------------------«\n" +
                "\n" +
                "     [color=grey]»[/color] Der User [color=red]" + User + "[/color] benötigt Support!\n" +
                "\n" +
                "»------------------------=======[» SupportAnfrage «]=======------------------------«");

    }}}





    public static void AddUser(){
        RANGL++;
    }


    public static void DelUser(){
        RANGL--;
    }
}
