package de.chaoscrafterhd.tsbot;

import com.github.theholywaffle.teamspeak3.api.ChannelProperty;
import com.github.theholywaffle.teamspeak3.api.event.ChannelCreateEvent;
import com.github.theholywaffle.teamspeak3.api.event.ChannelDeletedEvent;
import com.github.theholywaffle.teamspeak3.api.event.ChannelDescriptionEditedEvent;
import com.github.theholywaffle.teamspeak3.api.event.ChannelEditedEvent;
import com.github.theholywaffle.teamspeak3.api.event.ChannelMovedEvent;
import com.github.theholywaffle.teamspeak3.api.event.ChannelPasswordChangedEvent;
import com.github.theholywaffle.teamspeak3.api.event.ClientJoinEvent;
import com.github.theholywaffle.teamspeak3.api.event.ClientLeaveEvent;
import com.github.theholywaffle.teamspeak3.api.event.ClientMovedEvent;
import com.github.theholywaffle.teamspeak3.api.event.PrivilegeKeyUsedEvent;
import com.github.theholywaffle.teamspeak3.api.event.ServerEditedEvent;
import com.github.theholywaffle.teamspeak3.api.event.TS3Listener;
import com.github.theholywaffle.teamspeak3.api.event.TextMessageEvent;
import com.github.theholywaffle.teamspeak3.api.wrapper.Client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class TSEvents {
	public static int supportin = AutobanSupport_Reader.supportin;
	public static int autoban = AutobanSupport_Reader.autoban;
	public static Scanner scan = new Scanner(System.in);
	public static HashMap<String, Boolean> benachr = new HashMap<>();
	public static HashMap<String, Boolean> insupwait = new HashMap<>();
	public static HashMap<String, Integer> SUPID = new HashMap<>();


	public static ArrayList<String> words = new ArrayList<>();
	public static void load() {
		int WhoAmI = Main.api.whoAmI().getId();
		Main.api.registerAllEvents();
		Main.api.addTS3Listeners(new TS3Listener() {
			
			@Override
			public void onTextMessage(TextMessageEvent e) {
				if(e.getInvokerId() != WhoAmI) {
					if(e.getMessage().equalsIgnoreCase(Config_Reader.ruhecom)) {
						Client c = Main.api.getClientByUId(e.getInvokerUniqueId());
						if(c.isInServerGroup(Integer.parseInt(Config_Reader.ruheid))) {
							Main.api.removeClientFromServerGroup(Integer.parseInt(Config_Reader.ruheid), c.getDatabaseId());
							Main.api.sendPrivateMessage(e.getInvokerId(), "Du hast nun keinen Ruhe Rang mehr.");
						}else {
							Main.api.addClientToServerGroup(Integer.parseInt(Config_Reader.ruheid), c.getDatabaseId());
							Main.api.sendPrivateMessage(e.getInvokerId(), "Du hast nun den Ruhe Rang.");
						}
					}else
					if(e.getMessage().equalsIgnoreCase(Config_Reader.verifycmd)) {
						Client c = Main.api.getClientByUId(e.getInvokerUniqueId());
						if(c.isInServerGroup(0)) {
							Main.api.removeClientFromServerGroup(0, c.getDatabaseId());
							Main.api.sendPrivateMessage(e.getInvokerId(), "Aktuell deaktiviert!");
						}else {
							Main.api.addClientToServerGroup(0, c.getDatabaseId());
							Main.api.sendPrivateMessage(e.getInvokerId(), "Aktuell deaktiviert!");
						}
					}else
					if(e.getMessage().equalsIgnoreCase("!togglebot")) {
						Client c = Main.api.getClientByUId(e.getInvokerUniqueId());
						if(c.isInServerGroup(Integer.parseInt(Config_Reader.botruheid))) {
							Main.api.removeClientFromServerGroup(Integer.parseInt(Config_Reader.botruheid), c.getDatabaseId());
							Main.api.sendPrivateMessage(e.getInvokerId(), "Du hast den Bot entmuted!");
						}else {
							Main.api.addClientToServerGroup(Integer.parseInt(Config_Reader.botruheid), c.getDatabaseId());
							Main.api.sendPrivateMessage(e.getInvokerId(), "Du hast den Bot gemuted!");
						}

					}else {
						Main.api.sendPrivateMessage(e.getInvokerId(), "Bitte gib einen gültigen Befehl an!");
					}









				}
			}

			/*public void onAlert(TextMessageEvent e, String[] args) {
				if (e.getMessage().equalsIgnoreCase(Main.alertcmd)) {
					Client c = Main.api.getClientByUId(e.getInvokerUniqueId());

					if (c.isInServerGroup(6) || c.isInServerGroup(7) || c.isInServerGroup(9) || c.isInServerGroup(10) || c.isInServerGroup(11) || c.isInServerGroup(12) || c.isInServerGroup(42) || c.isInServerGroup(13) || c.isInServerGroup(14) || c.isInServerGroup(15)) {
						Main.api.sendPrivateMessage(e.getInvokerId(), "Rundruf:" + Main.alertmsg);
						Main.api.sendPrivateMessage(e.getInvokerId(), "Du hast deine Verifizierung aufgehoben!");
					} else {
						Main.api.addClientToServerGroup(23, c.getDatabaseId());
						Main.api.sendPrivateMessage(e.getInvokerId(), "Du hast dich nun als Mensch verifiziert!");
					}
				}
			}*/

			
			@Override
			public void onServerEdit(ServerEditedEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onPrivilegeKeyUsed(PrivilegeKeyUsedEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onClientMoved(ClientMovedEvent e) {


				if(e.getTargetChannelId() == Integer.parseInt(Config_Reader.supportchannelid)){
					Main.api.sendPrivateMessage(e.getClientId(), "[color=red][B]"+ Config_Reader.servername +"[/B][color=grey]»[color=blue] Hier kannst du unseren Support bewerten:");
					try
					{
						Thread.sleep(20);
					}
					catch(InterruptedException ex)
					{
						Thread.currentThread().interrupt();
					}
					Main.api.sendPrivateMessage(e.getClientId(), "[color=red][B]"+ Config_Reader.servername +"[/B][color=grey]» [color=blue]"+Config_Reader.feedbacklink);
				}

				int clientid = e.getClientId();

				if(!(e.getTargetChannelId() == Integer.parseInt(Config_Reader.supportchannelid))){
					if(insupwait.containsKey(e.getInvokerUniqueId())){
						Support.DelUser();
						insupwait.remove(e.getInvokerUniqueId());
					}
				}
				if(e.getTargetChannelId() == Integer.parseInt(Config_Reader.supportchannelid)){
					for(Client client : Main.api.getClients())
						if(client.getId() == clientid)
							if (client.isInServerGroup(Integer.parseInt(Config_Reader.supportgruppenid)) || client.isInServerGroup(Integer.parseInt(Config_Reader.keinsupportid))){

								Main.api.pokeClient(e.getClientId(), "[color=red][B]"+ Config_Reader.servername +"[/B][color=grey]»[color=blue]Du darfst den Support nicht nutzen.");
								Main.api.moveClient(e.getClientId(), Integer.parseInt(Config_Reader.eingangshallenid));
								return;
						}





					int i = 0;
					for(Client clients : Main.api.getClients()){
						if (clients.isInServerGroup(Integer.parseInt(Config_Reader.supportgruppenid))){
							Support.AddUser();
							insupwait.put(e.getInvokerUniqueId(), true);
							i++;
							Main.api.pokeClient(clients.getId(), "[color=red][B]"+ Config_Reader.servername +"[/B][color=grey]»[color=blue]Es wird Support benötigt");
						}
					}
					if(i == 0){
						Main.api.pokeClient(clientid, "[color=red][B]"+ Config_Reader.servername +"[/B][color=grey]»[color=blue]Zurzeit ist kein Supporter verfügbar");

					}else {
						Main.api.sendPrivateMessage(e.getClientId(), "\n" +
								"_____________________________________________________________\n\n" +
								"[color=#03a2ff]1[/color] [color=grey]»[/color] Es wurden Teammitglieder benachrichtigt\n" +
								"\n" + "_____________________________________________________________");
						benachr.put(e.getInvokerUniqueId(), true);



						/*	for(Client clients : Main.api.getClients()){
								if (clients.isInServerGroup(134)){
									Main.api.sendPrivateMessage(e.getClientId(), " \n" +
											"\n" +
											"»------------------------=======[» SupportAnfrage «]=======------------------------«\n" +
											"\n" +
											"     [color=grey]»[/color] Der User [color=red]" + e.getInvokerName() + "[/color] benötigt Support!\n" +
											"     [color=grey]»[/color] Supportanfrage: " + //Supportid + "!\n" +
											"     [color=grey]»[/color] Ihm hilfst du als " + "" + "!\n" +
											"\n" +
											"»------------------------=======[» SupportAnfrage «]=======------------------------«");
								}
							}*/

						supportin++;
						HashMap<ChannelProperty, String> optionsi = new HashMap<>();
						optionsi.put(ChannelProperty.CHANNEL_NAME, "[cspacer]Support: " + supportin + " Autoban: " + autoban + "");
						Main.api.editChannel(Integer.parseInt(Config_Reader.statschannelid), optionsi);

					}


				}
				
			}
			
			@Override
			public void onClientLeave(ClientLeaveEvent e) {

				int d = 0;
				for(Client clients : Main.api.getClients()){
					if (clients.isInServerGroup(Integer.parseInt(Config_Reader.botgruppenid)) || clients.isServerQueryClient()){
						d++;
					}
				}
				HashMap<ChannelProperty, String> options = new HashMap<>();
				options.put(ChannelProperty.CHANNEL_NAME, "[cspacer]Online: "+ (Main.api.getClients().size() -d) +  "");
				Main.api.editChannel(Integer.parseInt(Config_Reader.onlinechannelid), options);
				HashMap<ChannelProperty, String> optionsi = new HashMap<>();
				optionsi.put(ChannelProperty.CHANNEL_NAME, "[cspacer]Support: " + supportin + " Autoban: " + autoban + "");
				Main.api.editChannel(Integer.parseInt(Config_Reader.statschannelid), optionsi);


				
			}




			@Override
			public void onClientJoin(ClientJoinEvent e) {


				String name = e.getClientNickname().toLowerCase();
				if (name.contains("hurensohn") || name.contains("wix") || name.contains("arsch") || name.contains("huso") || name.contains("titt") || name.contains("doggy") || name.contains("sex") || name.contains("fick") || name.contains("spanc") || name.contains("nazi") || name.contains("hitl") || name.contains("hittl")){
					Main.api.banClient(e.getClientId(), 900, "Du wurdest vom Teamspeak gebannt. Grund: Nickname -- ControlBot");
					autoban++;
					HashMap<ChannelProperty, String> optionsi = new HashMap<>();
					optionsi.put(ChannelProperty.CHANNEL_NAME, "[cspacer]Support: " + supportin + " Autoban: " + autoban + "");
					Main.api.editChannel(Integer.parseInt(Config_Reader.statschannelid), optionsi);




				}



				int d = 0;
				for(Client clients : Main.api.getClients()){
					if (clients.isInServerGroup(Integer.parseInt(Config_Reader.botgruppenid)) || clients.isServerQueryClient()){
						d++;
					}
				}
				HashMap<ChannelProperty, String> options = new HashMap<>();
				options.put(ChannelProperty.CHANNEL_NAME, "[cspacer]Online: "+ (Main.api.getClients().size() -d) +  "");
				Main.api.editChannel(Integer.parseInt(Config_Reader.onlinechannelid), options);

				Main.api.sendPrivateMessage(e.getClientId(), " \n" +
						"\n" +
						"»------------------------=======[» "+ Config_Reader.servername +" «]=======------------------------«\n" +
						"\n" +
						"     [color=grey]»[/color] Willkommen [color=red]" + e.getClientNickname() + "[/color] auf "+ Config_Reader.servername +"!\n" +
						"     » Benutze !verify um dich zu verifizieren!\n" +
						"     » Benutze !ruhe für den Ruhe-Rang!\n" +
						"\n" +
						"»------------------------=======[» "+ Config_Reader.servername +" «]=======------------------------«");

				for(Client clients : Main.api.getClients()){
					if(clients.isInServerGroup(Integer.parseInt(Config_Reader.supportgruppenid))){
						try
						{
							Thread.sleep(1000);
						}
						catch(InterruptedException ex)
						{
							Thread.currentThread().interrupt();
						}
						Main.api.sendPrivateMessage(e.getClientId(), " \n" +
								"\n" +
								"»------------------------=======[» "+ Config_Reader.servername +" «]=======------------------------«\n" +
								"\n" +
								"     [color=grey]»[/color] Willkommen [color=red]" + e.getClientNickname() + "[/color] auf "+ Config_Reader.servername +"!\n" +
								"     » Benutze !verify um dich zu verifizieren!\n" +
								"     » Benutze !ruhe für den Ruhe-Rang!\n" +
								"\n" +
								"»------------------------=======[» "+ Config_Reader.servername +" «]=======------------------------«");
						return;
					}
				}

				//Main.api.sendPrivateMessage(e.getClientId(), Config_Reader.welcomemsg + "[B]" + Config_Reader.servername + "[/B]" + Config_Reader.welcomemessage);
			/*	try
				{
					Thread.sleep(1200);
				}
				catch(InterruptedException ex)
				{
					Thread.currentThread().interrupt();
				}
				Main.api.sendPrivateMessage(e.getClientId(), Config_Reader.joinmsg1);
				try
				{
					Thread.sleep(1200);
				}
				catch(InterruptedException ex)
				{
					Thread.currentThread().interrupt();
				}
				Main.api.sendPrivateMessage(e.getClientId(), Config_Reader.joinmsg2);
				try
				{
					Thread.sleep(1200);
				}
				catch(InterruptedException ex)
				{
					Thread.currentThread().interrupt();
				}
				Main.api.sendPrivateMessage(e.getClientId(), Config_Reader.joinmsg3);
				try
				{
					Thread.sleep(1200);
				}
				catch(InterruptedException ex)
				{
					Thread.currentThread().interrupt();
				}
				Main.api.sendPrivateMessage(e.getClientId(), Config_Reader.joinmsg4);
				try
				{
					Thread.sleep(1200);
				}
				catch(InterruptedException ex)
				{
					Thread.currentThread().interrupt();
				}
				Main.api.sendPrivateMessage(e.getClientId(), Config_Reader.joinmsg5);
				try
				{
					Thread.sleep(1200);
				}
				catch(InterruptedException ex)
				{
					Thread.currentThread().interrupt();
				}
				Main.api.sendPrivateMessage(e.getClientId(), Config_Reader.joinmsg6);
				try
				{
					Thread.sleep(1200);
				}
				catch(InterruptedException ex)
				{
					Thread.currentThread().interrupt();
				}
				Main.api.sendPrivateMessage(e.getClientId(), Config_Reader.joinmsg7);
				try
				{
					Thread.sleep(1200);
				}
				catch(InterruptedException ex)
				{
					Thread.currentThread().interrupt();
				}
				Main.api.sendPrivateMessage(e.getClientId(), Config_Reader.joinmsg8);*/

			}
			
			@Override
			public void onChannelPasswordChanged(ChannelPasswordChangedEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onChannelMoved(ChannelMovedEvent e) {
				Client c = Main.api.getClientByUId(e.getInvokerUniqueId());
				if(c.isInServerGroup(6)) {
					Main.api.sendPrivateMessage(e.getInvokerId(), "Mit !Musik den Channel zu einem Musik-Channel Machen. [B]BETA[/B]");
				}
			}
			
			@Override
			public void onChannelEdit(ChannelEditedEvent e) {
				int id = e.getInvokerId();
				int cid = e.getChannelId();
				String name = Main.api.getChannelInfo(e.getChannelId()).getName().toLowerCase();
				if(name.contains("hurensohn") || name.contains("wix") || name.contains("arsch") || name.contains("huso") || name.contains("titt") || name.contains("doggy") || name.contains("sex") || name.contains("fick") || name.contains("spanc") || name.contains("nazi") || name.contains("hitl") || name.contains("hittl")){
					Main.api.banClient(id, 900, "Du wurdest vom Teamspeak gebannt. Grund: Channel -- ControlBot");
					autoban++;
					HashMap<ChannelProperty, String> optionsi = new HashMap<>();
					optionsi.put(ChannelProperty.CHANNEL_NAME, "[cspacer}Support: " + supportin + " Autoban: " + autoban + "");
					Main.api.editChannel(Integer.parseInt(Config_Reader.statschannelid), optionsi);


				}

				if(e.getChannelId() == Integer.parseInt(Config_Reader.onlinechannelid)){
					int d = 0;
					for(Client clients : Main.api.getClients()){
						if (clients.isInServerGroup(Integer.parseInt(Config_Reader.botgruppenid)) || clients.isServerQueryClient()){
							d++;
						}
					}
					HashMap<ChannelProperty, String> options = new HashMap<>();
					options.put(ChannelProperty.CHANNEL_NAME, "[cspacer]Online: "+ (Main.api.getClients().size() -d) +  "");
					Main.api.editChannel(Integer.parseInt(Config_Reader.onlinechannelid), options);
				}
				// TODO Auto-generated method stub


			}
			
			@Override
			public void onChannelDescriptionChanged(ChannelDescriptionEditedEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onChannelDeleted(ChannelDeletedEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onChannelCreate(ChannelCreateEvent e) {
				int id = e.getInvokerId();
				int cid = e.getChannelId();
				String name = Main.api.getChannelInfo(e.getChannelId()).getName().toLowerCase();
				if(name.contains("hurensohn") || name.contains("wix") || name.contains("arsch") || name.contains("huso") || name.contains("titt") || name.contains("doggy") || name.contains("sex") || name.contains("fick") || name.contains("spanc") || name.contains("nazi") || name.contains("hitl") || name.contains("hittl")){
					Main.api.banClient(id, 900, "Du wurdest vom Teamspeak gebannt. Grund: Channel -- ControlBot");
					Main.api.deleteChannel(cid);
					autoban++;
					HashMap<ChannelProperty, String> optionsi = new HashMap<>();
					optionsi.put(ChannelProperty.CHANNEL_NAME, "[cspacer]Support: " + supportin + " Autoban: " + autoban + "");
					Main.api.editChannel(Integer.parseInt(Config_Reader.statschannelid), optionsi);




				}
				// TODO Auto-generated method stub

			}
		});
}
}
