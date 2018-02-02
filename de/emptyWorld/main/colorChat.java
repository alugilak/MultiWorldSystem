package de.emptyWorld.main;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class colorChat implements CommandExecutor
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
 
  
  public colorChat(leerWelt instance)
  {
    plugin = instance;
  }
  
  public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
  {Player player = (Player)sender; 
	  if (cmd.getName().equalsIgnoreCase("chatcolor")) {
	      if (!sender.hasPermission((String)this.settings.getpermData().get("mwsChatColorSet"))) {
	        sender.sendMessage(ChatColor.RED + ((String) this.settings.getsysoData().get("permError")));
	        return true;
	      }
	      if (args.length == 0) {
    player.sendMessage(ChatColor.RED + "Error: Not enough args! Try /chatcolor help");
  }
  if (args.length == 1) {
    boolean cor = false; 
    	if (args[0].equalsIgnoreCase("reset")) {
      cor = true;
      player.sendMessage(ChatColor.GREEN + args[1].replace("%default", new StringBuilder("§").append(getDefaultColor()).append("default§2").toString()));
      String playerN = player.getName();
      player.setDisplayName("§" + getDefaultColor() + playerN);
    }
    if (args[0].equalsIgnoreCase("help")) {
      cor = true;
      player.sendMessage(ChatColor.GREEN + "/chatcolor reset <- Reset to white.");
      player.sendMessage(ChatColor.GREEN + "/chatcolor <COLOR> <- Change to color.");
      player.sendMessage(ChatColor.WHITE + "Colors: " + ChatColor.AQUA + "Aqua, " + 
        ChatColor.BLACK + "Black, " + ChatColor.BLUE + "Blue, " + 
        ChatColor.GOLD + "Gold, " + ChatColor.GRAY + "Gray, " + 
        ChatColor.GREEN + "Green, " + ChatColor.RED + "Red, " + 
        ChatColor.YELLOW + "Yellow, " + ChatColor.WHITE + "White, " + 
        ChatColor.LIGHT_PURPLE + "Light_Purple, " + ChatColor.DARK_AQUA + "Dark_aqua, " + 
        ChatColor.DARK_BLUE + "Dark_blue, " + ChatColor.DARK_GRAY + "Dark_gray, " + 
        ChatColor.DARK_GREEN + "Dark_green, " + ChatColor.DARK_PURPLE + "Dark_purple, " + 
        ChatColor.DARK_RED + "Dark_red, " + ChatColor.DARK_RED + "R" + ChatColor.RED + "a" + ChatColor.YELLOW + "i" + ChatColor.GREEN + "n" + ChatColor.BLUE + "b" + ChatColor.LIGHT_PURPLE + "o" + ChatColor.DARK_PURPLE + "w");
    }
    if (args[0].equalsIgnoreCase("AQUA")) {
      cor = true;
      String playerN = player.getName();
      player.sendMessage(ChatColor.GREEN + args[0].replace("%color", "§bAQUA"));
      player.setDisplayName(ChatColor.AQUA + playerN + ChatColor.WHITE);
    }
    if (args[0].equalsIgnoreCase("RAINBOW")) {
      try {
        cor = true;
        player.sendMessage(ChatColor.GREEN + args[0].replace("%color", "§4R§6I§eN§aB§1O§dW§2"));
        String name = player.getName();
        String display = "";
        int ColorLoop = 0;
        for (int loop = 0; loop < name.length(); loop++) {
          if (ColorLoop == 0) {
            display = display + ChatColor.DARK_RED + name.charAt(loop);
          }
          if (ColorLoop == 1) {
            display = display + ChatColor.RED + name.charAt(loop);
          }
          if (ColorLoop == 2) {
            display = display + ChatColor.YELLOW + name.charAt(loop);
          }
          if (ColorLoop == 3) {
            display = display + ChatColor.GREEN + name.charAt(loop);
          }
          if (ColorLoop == 4) {
            display = display + ChatColor.BLUE + name.charAt(loop);
          }
          if (ColorLoop == 5) {
            display = display + ChatColor.LIGHT_PURPLE + name.charAt(loop);
          }
          if (ColorLoop == 6) {
            display = display + ChatColor.DARK_PURPLE + name.charAt(loop);
          }
          ColorLoop++;
          if (ColorLoop > 6) {
            ColorLoop = 0;
          }
          player.setDisplayName(display + "§r");
        }
      } catch (Exception e) {
        Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_RED + "[ColorName] " + ChatColor.RED + "Error on setting rainbow.  Please report on the colorName plugin page.");
      }
    }
    
    if (args[0].equalsIgnoreCase("BLACK")) {
      cor = true;
      String playerN = player.getName();
      player.sendMessage(ChatColor.GREEN + args[0].replace("%color", "§0BLACK§2"));
      player.setDisplayName(ChatColor.BLACK + playerN + ChatColor.WHITE);
    }
    if (args[0].equalsIgnoreCase("BLUE")) {
      cor = true;
      String playerN = player.getName();
      player.sendMessage(ChatColor.GREEN + args[0].replace("%color", "§9BLUE§2"));
      player.setDisplayName(ChatColor.BLUE + playerN + ChatColor.WHITE);
    }
    if (args[0].equalsIgnoreCase("GOLD")) {
      cor = true;
      String playerN = player.getName();
      player.sendMessage(ChatColor.GREEN + args[0].replace("%color", "§6GOLD§2"));
      player.setDisplayName(ChatColor.GOLD + playerN + ChatColor.WHITE);
    }
    if (args[0].equalsIgnoreCase("GRAY")) {
      cor = true;
      String playerN = player.getName();
      player.sendMessage(ChatColor.GREEN + args[0].replace("%color", "§7GRAY§2"));
      player.setDisplayName(ChatColor.GRAY + playerN + ChatColor.WHITE);
    }
    if (args[0].equalsIgnoreCase("GREEN")) {
      cor = true;
      String playerN = player.getName();
      player.sendMessage(ChatColor.GREEN + args[0].replace("%color", "§aGREEN§2"));
      player.setDisplayName(ChatColor.GREEN + playerN + ChatColor.WHITE);
    }
    if (args[0].equalsIgnoreCase("RED")) {
      cor = true;
      String playerN = player.getName();
      player.sendMessage(ChatColor.GREEN + args[0].replace("%color", "§cRED§2"));
      player.setDisplayName(ChatColor.RED + playerN + ChatColor.WHITE);
    }
    if (args[0].equalsIgnoreCase("YELLOW")) {
      cor = true;
      String playerN = player.getName();
      player.sendMessage(ChatColor.GREEN + args[0].replace("%color", "§eYELLOW§2"));
      player.setDisplayName(ChatColor.YELLOW + playerN + ChatColor.WHITE);
    }
    if (args[0].equalsIgnoreCase("WHITE")) {
      cor = true;
      String playerN = player.getName();
      player.sendMessage(ChatColor.GREEN + args[0].replace("%color", "§fWHITE§2"));
      player.setDisplayName(ChatColor.WHITE + playerN + ChatColor.WHITE);
    }
    if (args[0].equalsIgnoreCase("LIGHT_PURPLE")) {
      cor = true;
      String playerN = player.getName();
      player.sendMessage(ChatColor.GREEN + args[0].replace("%color", "§dLIGHT PURPLE§2"));
      player.setDisplayName(ChatColor.LIGHT_PURPLE + playerN + ChatColor.WHITE);
    }
    if (args[0].equalsIgnoreCase("DARK_AQUA")) {
      cor = true;
      String playerN = player.getName();
      player.sendMessage(ChatColor.GREEN + args[0].replace("%color", "§3DARK AQUA§2"));
      player.setDisplayName(ChatColor.DARK_AQUA + playerN + ChatColor.WHITE);
    }
    if (args[0].equalsIgnoreCase("DARK_BLUE")) {
      cor = true;
      String playerN = player.getName();
      player.sendMessage(ChatColor.GREEN + args[0].replace("%color", "§1DARK BLUE§2"));
      player.setDisplayName(ChatColor.DARK_BLUE + playerN + ChatColor.WHITE);
    }
    if (args[0].equalsIgnoreCase("DARK_GRAY")) {
      cor = true;
      String playerN = player.getName();
      player.sendMessage(ChatColor.GREEN + args[0].replace("%color", "§8DARK GRAY§2"));
      player.setDisplayName(ChatColor.DARK_GRAY + playerN + ChatColor.WHITE);
    }
    if (args[0].equalsIgnoreCase("DARK_GREEN")) {
      cor = true;
      String playerN = player.getName();
      player.sendMessage(ChatColor.GREEN + args[0].replace("%color", "§2DARK GREEN§2"));
      player.setDisplayName(ChatColor.DARK_GREEN + playerN + ChatColor.WHITE);
    }
    if (args[0].equalsIgnoreCase("DARK_PURPLE")) {
      cor = true;
      String playerN = player.getName();
      player.sendMessage(ChatColor.GREEN + args[0].replace("%color", "§5DARK PURPLE§2"));
      player.setDisplayName(ChatColor.DARK_PURPLE + playerN + ChatColor.WHITE);
    }
    if (args[0].equalsIgnoreCase("DARK_RED")) {
      cor = true;
      String playerN = player.getName();
      player.sendMessage(ChatColor.GREEN + args[0].replace("%color", "§4DARK RED§2"));
      player.setDisplayName(ChatColor.DARK_RED + playerN + ChatColor.WHITE);
    }
    if (!cor) {
      player.sendMessage(ChatColor.RED + "Error!" + ChatColor.WHITE + " Try: /color help");
    }
  }
  if (args.length == 2) {
    boolean cor = false;
    if (player.hasPermission("colorname.admin")) {
      Player targetPlayer = player.getServer().getPlayer(args[0]);
      if (targetPlayer.isOnline()) {
        if (args[1].equalsIgnoreCase("reset")) {
          cor = true;
          targetPlayer.sendMessage(ChatColor.GREEN + args[5].replace("%default", new StringBuilder("§").append(getDefaultColor()).append("default§2").toString()));
          player.sendMessage(ChatColor.GREEN + args[4].replace("%default", new StringBuilder("§").append(getDefaultColor()).append("default§2").toString()).replace("%player", new StringBuilder("§7").append(targetPlayer.getName()).append("§2").toString()));
          String playerN = targetPlayer.getName();
          targetPlayer.setDisplayName("§" + getDefaultColor() + playerN);
        }
        


        if (args[1].equalsIgnoreCase("AQUA")) {
          cor = true;
          String playerN = targetPlayer.getName();
          player.sendMessage(ChatColor.GREEN + args[2].replace("player", new StringBuilder("§7").append(playerN).append("§2").toString()).replace("color", new StringBuilder().append(ChatColor.getByChar(args[1].toUpperCase())).append(args[1].toUpperCase()).toString()));
          targetPlayer.sendMessage(ChatColor.GREEN + args[3].replace("color", new StringBuilder().append(ChatColor.getByChar(args[1].toUpperCase())).append(args[1].toUpperCase()).toString()));
          targetPlayer.setDisplayName(ChatColor.AQUA + playerN + ChatColor.WHITE);
        }
        if (args[0].equalsIgnoreCase("RAINBOW")) {
          try {
            cor = true;
            player.sendMessage(ChatColor.GREEN + args[2].replace("player", new StringBuilder("§7").append(targetPlayer.getName()).append("§2").toString()).replace("color", "§4R§6I§eN§aB§1O§dW§2"));
            targetPlayer.sendMessage(ChatColor.GREEN + args[3].replace("color", "§4R§6I§eN§aB§1O§dW§2"));
            String name = targetPlayer.getName();
            String display = "";
            int ColorLoop = 0;
            for (int loop = 0; loop < name.length(); loop++) {
              if (ColorLoop == 0) {
                display = display + ChatColor.DARK_RED + name.charAt(loop);
              }
              if (ColorLoop == 1) {
                display = display + ChatColor.RED + name.charAt(loop);
              }
              if (ColorLoop == 2) {
                display = display + ChatColor.YELLOW + name.charAt(loop);
              }
              if (ColorLoop == 3) {
                display = display + ChatColor.GREEN + name.charAt(loop);
              }
              if (ColorLoop == 4) {
                display = display + ChatColor.BLUE + name.charAt(loop);
              }
              if (ColorLoop == 5) {
                display = display + ChatColor.LIGHT_PURPLE + name.charAt(loop);
              }
              if (ColorLoop == 6) {
                display = display + ChatColor.DARK_PURPLE + name.charAt(loop);
              }
              ColorLoop++;
              if (ColorLoop > 6) {
                ColorLoop = 0;
              }
            }
            targetPlayer.setDisplayName(display + "§r");
          } catch (Exception e) {
            Bukkit.getConsoleSender().sendMessage(ChatColor.DARK_RED + "[ColorName] " + ChatColor.RED + "Error on setting rainbow.  Please report on the colorName plugin page.");
          }
        }
        
        if (args[1].equalsIgnoreCase("BLACK")) {
          cor = true;
          String playerN = targetPlayer.getName();
          player.sendMessage(ChatColor.GREEN + args[2].replace("player", new StringBuilder("§7").append(playerN).append("§2").toString()).replace("color", new StringBuilder().append(ChatColor.getByChar(args[1].toUpperCase())).append(args[1].toUpperCase()).toString()));
          targetPlayer.sendMessage(ChatColor.GREEN + args[3].replace("color", new StringBuilder().append(ChatColor.getByChar(args[1].toUpperCase())).append(args[1].toUpperCase()).toString()));
          targetPlayer.setDisplayName(ChatColor.BLACK + playerN + ChatColor.WHITE);
        }
        if (args[1].equalsIgnoreCase("BLUE")) {
          cor = true;
          String playerN = targetPlayer.getName();
          player.sendMessage(ChatColor.GREEN + args[2].replace("player", new StringBuilder("§7").append(playerN).append("§2").toString()).replace("color", new StringBuilder().append(ChatColor.getByChar(args[1].toUpperCase())).append(args[1].toUpperCase()).toString()));
          targetPlayer.sendMessage(ChatColor.GREEN + args[3].replace("color", new StringBuilder().append(ChatColor.getByChar(args[1].toUpperCase())).append(args[1].toUpperCase()).toString()));
          targetPlayer.setDisplayName(ChatColor.BLUE + playerN + ChatColor.WHITE);
        }
        if (args[1].equalsIgnoreCase("GOLD")) {
          cor = true;
          String playerN = targetPlayer.getName();
          player.sendMessage(ChatColor.GREEN + args[2].replace("player", new StringBuilder("§7").append(playerN).append("§2").toString()).replace("color", new StringBuilder().append(ChatColor.getByChar(args[1].toUpperCase())).append(args[1].toUpperCase()).toString()));
          targetPlayer.sendMessage(ChatColor.GREEN + args[3].replace("color", new StringBuilder().append(ChatColor.getByChar(args[1].toUpperCase())).append(args[1].toUpperCase()).toString()));
          targetPlayer.setDisplayName(ChatColor.GOLD + playerN + ChatColor.WHITE);
        }
        if (args[1].equalsIgnoreCase("GRAY")) {
          cor = true;
          String playerN = targetPlayer.getName();
          player.sendMessage(ChatColor.GREEN + args[2].replace("player", new StringBuilder("§7").append(playerN).append("§2").toString()).replace("color", new StringBuilder().append(ChatColor.getByChar(args[1].toUpperCase())).append(args[1].toUpperCase()).toString()));
          targetPlayer.sendMessage(ChatColor.GREEN + args[3].replace("color", new StringBuilder().append(ChatColor.getByChar(args[1].toUpperCase())).append(args[1].toUpperCase()).toString()));
          targetPlayer.setDisplayName(ChatColor.GRAY + playerN + ChatColor.WHITE);
        }
        if (args[1].equalsIgnoreCase("GREEN")) {
          cor = true;
          String playerN = targetPlayer.getName();
          player.sendMessage(ChatColor.GREEN + args[2].replace("player", new StringBuilder("§7").append(playerN).append("§2").toString()).replace("color", new StringBuilder().append(ChatColor.getByChar(args[1].toUpperCase())).append(args[1].toUpperCase()).toString()));
          targetPlayer.sendMessage(ChatColor.GREEN + args[3].replace("color", new StringBuilder().append(ChatColor.getByChar(args[1].toUpperCase())).append(args[1].toUpperCase()).toString()));
          targetPlayer.setDisplayName(ChatColor.GREEN + playerN + ChatColor.WHITE);
        }
        if (args[1].equalsIgnoreCase("RED")) {
          cor = true;
          String playerN = targetPlayer.getName();
          player.sendMessage(ChatColor.GREEN + args[2].replace("player", new StringBuilder("§7").append(playerN).append("§2").toString()).replace("color", new StringBuilder().append(ChatColor.getByChar(args[1].toUpperCase())).append(args[1].toUpperCase()).toString()));
          targetPlayer.sendMessage(ChatColor.GREEN + args[3].replace("color", new StringBuilder().append(ChatColor.getByChar(args[1].toUpperCase())).append(args[1].toUpperCase()).toString()));
          targetPlayer.setDisplayName(ChatColor.RED + playerN + ChatColor.WHITE);
        }
        if (args[1].equalsIgnoreCase("YELLOW")) {
          cor = true;
          String playerN = targetPlayer.getName();
          player.sendMessage(ChatColor.GREEN + args[2].replace("player", new StringBuilder("§7").append(playerN).append("§2").toString()).replace("color", new StringBuilder().append(ChatColor.getByChar(args[1].toUpperCase())).append(args[1].toUpperCase()).toString()));
          targetPlayer.sendMessage(ChatColor.GREEN + args[3].replace("color", new StringBuilder().append(ChatColor.getByChar(args[1].toUpperCase())).append(args[1].toUpperCase()).toString()));
          targetPlayer.setDisplayName(ChatColor.YELLOW + playerN + ChatColor.WHITE);
        }
        if (args[1].equalsIgnoreCase("WHITE")) {
          cor = true;
          String playerN = targetPlayer.getName();
          player.sendMessage(ChatColor.GREEN + args[2].replace("player", new StringBuilder("§7").append(playerN).append("§2").toString()).replace("color", new StringBuilder().append(ChatColor.getByChar(args[1].toUpperCase())).append(args[1].toUpperCase()).toString()));
          targetPlayer.sendMessage(ChatColor.GREEN + args[3].replace("color", new StringBuilder().append(ChatColor.getByChar(args[1].toUpperCase())).append(args[1].toUpperCase()).toString()));
          targetPlayer.setDisplayName(ChatColor.WHITE + playerN + ChatColor.WHITE);
        }
        if (args[1].equalsIgnoreCase("LIGHT_PURPLE")) {
          cor = true;
          String playerN = targetPlayer.getName();
          player.sendMessage(ChatColor.GREEN + args[2].replace("player", new StringBuilder("§7").append(playerN).append("§2").toString()).replace("color", new StringBuilder().append(ChatColor.getByChar(args[1].toUpperCase())).append(args[1].toUpperCase()).toString()));
          targetPlayer.sendMessage(ChatColor.GREEN + args[3].replace("color", new StringBuilder().append(ChatColor.getByChar(args[1].toUpperCase())).append(args[1].toUpperCase()).toString()));
          targetPlayer.setDisplayName(ChatColor.LIGHT_PURPLE + playerN + ChatColor.WHITE);
        }
        if (args[1].equalsIgnoreCase("DARK_AQUA")) {
          cor = true;
          String playerN = targetPlayer.getName();
          player.sendMessage(ChatColor.GREEN + args[2].replace("player", new StringBuilder("§7").append(playerN).append("§2").toString()).replace("color", new StringBuilder().append(ChatColor.getByChar(args[1].toUpperCase())).append(args[1].toUpperCase()).toString()));
          targetPlayer.sendMessage(ChatColor.GREEN + args[3].replace("color", new StringBuilder().append(ChatColor.getByChar(args[1].toUpperCase())).append(args[1].toUpperCase()).toString()));
          targetPlayer.setDisplayName(ChatColor.DARK_AQUA + playerN + ChatColor.WHITE);
        }
        if (args[1].equalsIgnoreCase("DARK_BLUE")) {
          cor = true;
          String playerN = targetPlayer.getName();
          player.sendMessage(ChatColor.GREEN + args[2].replace("player", new StringBuilder("§7").append(playerN).append("§2").toString()).replace("color", new StringBuilder().append(ChatColor.getByChar(args[1].toUpperCase())).append(args[1].toUpperCase()).toString()));
          targetPlayer.sendMessage(ChatColor.GREEN + args[3].replace("color", new StringBuilder().append(ChatColor.getByChar(args[1].toUpperCase())).append(args[1].toUpperCase()).toString()));
          targetPlayer.setDisplayName(ChatColor.DARK_BLUE + playerN + ChatColor.WHITE);
        }
        if (args[1].equalsIgnoreCase("DARK_GRAY")) {
          cor = true;
          String playerN = targetPlayer.getName();
          player.sendMessage(ChatColor.GREEN + args[2].replace("player", new StringBuilder("§7").append(playerN).append("§2").toString()).replace("color", new StringBuilder().append(ChatColor.getByChar(args[1].toUpperCase())).append(args[1].toUpperCase()).toString()));
          targetPlayer.sendMessage(ChatColor.GREEN + args[3].replace("color", new StringBuilder().append(ChatColor.getByChar(args[1].toUpperCase())).append(args[1].toUpperCase()).toString()));
          targetPlayer.setDisplayName(ChatColor.DARK_GRAY + playerN + ChatColor.WHITE);
        }
        if (args[1].equalsIgnoreCase("DARK_GREEN")) {
          cor = true;
          String playerN = targetPlayer.getName();
          player.sendMessage(ChatColor.GREEN + args[2].replace("player", new StringBuilder("§7").append(playerN).append("§2").toString()).replace("color", new StringBuilder().append(ChatColor.getByChar(args[1].toUpperCase())).append(args[1].toUpperCase()).toString()));
          targetPlayer.sendMessage(ChatColor.GREEN + args[3].replace("color", new StringBuilder().append(ChatColor.getByChar(args[1].toUpperCase())).append(args[1].toUpperCase()).toString()));
          targetPlayer.setDisplayName(ChatColor.DARK_GREEN + playerN + ChatColor.WHITE);
        }
        if (args[1].equalsIgnoreCase("DARK_PURPLE")) {
          cor = true;
          String playerN = targetPlayer.getName();
          player.sendMessage(ChatColor.GREEN + args[2].replace("player", new StringBuilder("§7").append(playerN).append("§2").toString()).replace("color", new StringBuilder().append(ChatColor.getByChar(args[1].toUpperCase())).append(args[1].toUpperCase()).toString()));
          targetPlayer.sendMessage(ChatColor.GREEN + args[3].replace("color", new StringBuilder().append(ChatColor.getByChar(args[1].toUpperCase())).append(args[1].toUpperCase()).toString()));
          targetPlayer.setDisplayName(ChatColor.DARK_PURPLE + playerN + ChatColor.WHITE);
        }
        if (args[1].equalsIgnoreCase("DARK_RED")) {
          cor = true;
          String playerN = targetPlayer.getName();
          player.sendMessage(ChatColor.GREEN + args[2].replace("player", new StringBuilder("§7").append(playerN).append("§2").toString()).replace("color", new StringBuilder().append(ChatColor.getByChar(args[1].toUpperCase())).append(args[1].toUpperCase()).toString()));
          targetPlayer.sendMessage(ChatColor.GREEN + args[3].replace("color", new StringBuilder().append(ChatColor.getByChar(args[1].toUpperCase())).append(args[1].toUpperCase()).toString()));
          targetPlayer.setDisplayName(ChatColor.DARK_RED + playerN + ChatColor.WHITE);
        }
      }
      else {
        player.sendMessage(ChatColor.RED + "Error: " + " is not online!");
      }
      if (!cor) {
        player.sendMessage(ChatColor.RED + "Error: args[1] is invalid.");
      }
    }
    else
    {
      player.sendMessage(ChatColor.RED + "Error: You don't have permission!");
    }
  }
  if (args.length >= 3) {
    player.sendMessage(ChatColor.RED + "Error: Too many args!");
  }
}

return false;
}



public static String getDefaultColor() {
return getDefaultColor();
}


}
