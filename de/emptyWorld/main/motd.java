package de.emptyWorld.main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import de.emptyWorld.main.einstellungen;
import de.emptyWorld.main.leerWelt;

public class motd implements CommandExecutor
{
	einstellungen settings = einstellungen.getInstance();
	  FileConfiguration data;
	  FileConfiguration wdata;
	  FileConfiguration pdata;
	  FileConfiguration dedata;
	  FileConfiguration endata;
	  FileConfiguration permdata;
	  FileConfiguration sysodata;
	  
  leerWelt plugin;
 
  
  public motd(leerWelt instance)
  {
    plugin = instance;
  }
  
  public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
  {
	  if (cmd.getName().equalsIgnoreCase("smotd")) {
	      if (!sender.hasPermission((String)this.settings.getpermData().get("mwsMotdSet"))) {
	        sender.sendMessage(ChatColor.RED + ((String) this.settings.getsysoData().get("permError")));
	        return false;
	      }
	      if (args.length == 0) {
	        sender.sendMessage(ChatColor.RED + ((String) this.settings.getsysoData().get("motderror1")));
	        return true;
	      }
	      StringBuilder str = new StringBuilder();
	      for (int i = 0; i < args.length; i++) {
	        str.append(args[i] + " ");
	      }
	      String motd = str.toString();
	      this.settings.getsysoData().set("Motd", motd);
	      this.settings.savesysoData();
	      String newmotd = (motd + (String) this.settings.getsysoData().get("Motd"));
	      motd = motd.replaceAll("&", "§");
	      sender.sendMessage(ChatColor.GREEN + "MOTD set to: "+ motd + newmotd);
	      return true;
	    }
	    if (cmd.getName().equalsIgnoreCase("sysmotd")) {
	      if (!sender.hasPermission((String)this.settings.getpermData().get("mwsSupportMotdSet"))) {
	        sender.sendMessage(ChatColor.RED + ((String) this.settings.getsysoData().get("permError")));
	        return false;
	      }
	      if (args.length == 0) {
	        sender.sendMessage(ChatColor.RED + ((String) this.settings.getsysoData().get("motderror1")));
	        return true;
	      }
	      StringBuilder str = new StringBuilder();
	      for (int i = 0; i < args.length; i++) {
	        str.append(args[i] + " ");
	      }
	      String motd = str.toString();
	      this.settings.getsysoData().set("Motdsys", motd);
	      this.settings.savesysoData();
	      String system = (motd + (String) this.settings.getsysoData().get("Motdsys"));
	      system = system.replaceAll("&", "§");	      
	      Bukkit.broadcastMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("MOTDS")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + system );
	      return true;
	    }
	    if (cmd.getName().equalsIgnoreCase("motdl1")) {
		      if (!sender.hasPermission((String)this.settings.getpermData().get("mwsMotdSet"))) {
		        sender.sendMessage(ChatColor.RED + ((String) this.settings.getsysoData().get("permError")));
		        return true;
		      }
		      if (args.length == 0) {
		        sender.sendMessage(ChatColor.RED + ((String) this.settings.getsysoData().get("motderror1")));
		        return true;
		      }
		      StringBuilder str = new StringBuilder();
		      for (int i = 0; i < args.length; i++) {
		        str.append(args[i] + " ");
		      }
		      String motdl1 = str.toString();
		      this.settings.getsysoData().set("Line1", motdl1);
		      this.settings.savesysoData();
		      String system = (motdl1 + (String) this.settings.getsysoData().get("Line1"));
		      system = system.replaceAll("&", "§");
		      sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getsysoData().get("motdsetto"))+ " "+ motdl1 + " " + system);
		      return true;
		    }
	    if (cmd.getName().equalsIgnoreCase("motdl2")) {
		      if (!sender.hasPermission((String)this.settings.getpermData().get("mwsMotdSet"))) {
		        sender.sendMessage(ChatColor.RED + ((String) this.settings.getsysoData().get("permError")));
		        return true;
		      }
		      if (args.length == 0) {
		        sender.sendMessage(ChatColor.RED + ((String) this.settings.getsysoData().get("motderror1")));
		        return true;
		      }
		      StringBuilder str = new StringBuilder();
		      for (int i = 0; i < args.length; i++) {
		        str.append(args[i] + " ");
		      }
		      String motdl2 = str.toString();
		      this.settings.getsysoData().set("Line2", motdl2);
		      this.settings.savesysoData();
		      String system = (motdl2 + (String) this.settings.getsysoData().get("Line2"));
		      system = system.replaceAll("&", "§");
		      sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getsysoData().get("motdsetto"))+ " "+ motdl2 + " " + system);
		      return true;
		    }
	    if (cmd.getName().equalsIgnoreCase("motdl3")) {
		      if (!sender.hasPermission((String)this.settings.getpermData().get("mwsMotdSet"))) {
		        sender.sendMessage(ChatColor.RED + ((String) this.settings.getsysoData().get("permError")));
		        return true;
		      }
		      if (args.length == 0) {
		        sender.sendMessage(ChatColor.RED + ((String) this.settings.getsysoData().get("motderror1")));
		        return true;
		      }
		      StringBuilder str = new StringBuilder();
		      for (int i = 0; i < args.length; i++) {
		        str.append(args[i] + " ");
		      }
		      String motdl3 = str.toString();
		      this.settings.getsysoData().set("Line3", motdl3);
		      this.settings.savesysoData();
		      String system = (motdl3 + (String) this.settings.getsysoData().get("Line3"));
		      system = system.replaceAll("&", "§");
		      sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getsysoData().get("motdsetto"))+ " "+ motdl3 + " " + system);
		      return true;
		    }
	    if (cmd.getName().equalsIgnoreCase("motdl4")) {
		      if (!sender.hasPermission((String)this.settings.getpermData().get("mwsMotdSet"))) {
		        sender.sendMessage(ChatColor.RED + ((String) this.settings.getsysoData().get("permError")));
		        return true;
		      }
		      if (args.length == 0) {
		        sender.sendMessage(ChatColor.RED + ((String) this.settings.getsysoData().get("motderror1")));
		        return true;
		      }
		      StringBuilder str = new StringBuilder();
		      for (int i = 0; i < args.length; i++) {
		        str.append(args[i] + " ");
		      }
		      String motdl4 = str.toString();
		      this.settings.getsysoData().set("Line4", motdl4);
		      this.settings.savesysoData();
		      String system = (motdl4 + (String) this.settings.getsysoData().get("Line4"));
		      system = system.replaceAll("&", "§");
		      sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getsysoData().get("motdsetto"))+ " "+ motdl4 + " " + system);
		      return true;
		    }
	    if (cmd.getName().equalsIgnoreCase("motdl5")) {
		      if (!sender.hasPermission((String)this.settings.getpermData().get("mwsMotdSet"))) {
		        sender.sendMessage(ChatColor.RED + ((String) this.settings.getsysoData().get("permError")));
		        return true;
		      }
		      if (args.length == 0) {
		        sender.sendMessage(ChatColor.RED + ((String) this.settings.getsysoData().get("motderror1")));
		        return true;
		      }
		      StringBuilder str = new StringBuilder();
		      for (int i = 0; i < args.length; i++) {
		        str.append(args[i] + " ");
		      }
		      String motdl5 = str.toString();
		      this.settings.getsysoData().set("Line5", motdl5);
		      this.settings.savesysoData();
		      String system = (motdl5 + " " + ((String) this.settings.getsysoData().get("Line5")));
		      system = system.replaceAll("&", "§");
		      sender.sendMessage(ChatColor.GREEN + ((String) this.settings.getsysoData().get("motdsetto"))+ " "+ motdl5 + " " + system);
		      return true;
		    }
	    return true;
	  }
	}
