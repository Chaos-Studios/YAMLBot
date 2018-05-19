package de.chaoscrafterhd.tsbot;

import com.github.theholywaffle.teamspeak3.api.wrapper.Client;

import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;


public class afkmover {
    public static HashMap<String, Long> AFK = new HashMap<>();
    public static HashMap<String, Boolean> Moved = new HashMap<>();
    public static HashMap<String, Integer> Channel = new HashMap<>();
    public static int Away = 120000;
    public static int moved = 0;



    public static void start(){
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                for(Client c : Main.api.getClients()){
                    if(!c.isServerQueryClient()){
                        if(!c.isInServerGroup(221)){
                        if(c.isAway() || c.isInputMuted() || c.isOutputMuted()){
                            if(!(Moved.containsKey(c.getUniqueIdentifier()))){
                                if(!(AFK.containsKey(c.getUniqueIdentifier()))){
                                    AFK.put(c.getUniqueIdentifier(), System.currentTimeMillis());
                                }else{
                                    long current = AFK.get(c.getUniqueIdentifier());
                                    if((System.currentTimeMillis() - current) >= Away){
                                        Moved.put(c.getUniqueIdentifier(), true);
                                        moved++;
                                        Channel.put(c.getUniqueIdentifier(), c.getChannelId());
                                        AFK.remove(c.getUniqueIdentifier());
                                        Main.api.sendPrivateMessage(c.getId(), "[color=red][B]"+ Config_Reader.servername +"[/B][color=grey]»[color=blue]Du wurdest in den AFK-Channel vershoben");
                                        Main.api.moveClient(c.getId(), 592);

                                    }

                                }
                            }


                        }else{
                            if(AFK.containsKey(c.getUniqueIdentifier())){
                                AFK.remove(c.getUniqueIdentifier());
                            }
                            if(Moved.containsKey(c.getUniqueIdentifier())){
                                if(Moved.get(c.getUniqueIdentifier())){
                                    Main.api.sendPrivateMessage(c.getId(), "[color=red][B]"+ Config_Reader.servername +"[/B][color=grey]»[color=blue]Du wurdest zurück vershoben");
                                    Main.api.moveClient(c.getId(), Channel.get(c.getUniqueIdentifier()));
                                    Moved.remove(c.getUniqueIdentifier());
                                    Channel.remove(c.getUniqueIdentifier());
                                }
                            }
                        }
                    }}
                }

            }
        }, 1000, 5000);

    }



}
