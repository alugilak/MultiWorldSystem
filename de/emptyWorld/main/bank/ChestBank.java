package de.emptyWorld.main.bank;

import org.bukkit.World;
import org.bukkit.command.CommandExecutor;
import org.bukkit.configuration.file.FileConfiguration;

import de.emptyWorld.main.einstellungen;
import de.emptyWorld.main.leerWelt;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
public class ChestBank implements CommandExecutor
{
	einstellungen settings = einstellungen.getInstance();
	  FileConfiguration data;
	  FileConfiguration wdata;
	  FileConfiguration pdata;
	  FileConfiguration dedata;	  
	  FileConfiguration endata;
	  FileConfiguration permdata;
	  FileConfiguration sysodata;
	  World world;
	
	  leerWelt plugin;   
  public ChestBank( leerWelt instance)
  {

    plugin = instance;
  }


  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
{
  if (!(sender instanceof Player))
  {
    sender.sendMessage(ChatColor.RED + "[] You must be a player");
    return false;
  }
  if (sender.hasPermission(((String)this.settings.getpermData().get("mwsbanking"))))
  {
    Player player = (Player)sender;
    if (args.length == 0)
    {
      sender.sendMessage(ChatColor.RED + "[MWS] Invalid arguments");
      return false;
    }
    if ((args.length == 1) && 
      (args[0].equals("setbank")))
    {
      Block block = player.getTargetBlock(null, 100);
      if (!block.getType().equals(Material.CHEST))
      {
        player.sendMessage(ChatColor.RED + "[MWS] That block is not a chest");
        return false;
      }
      Location blockLocation = block.getLocation();     
      this.settings.getbData().set("chest.x", Double.valueOf(blockLocation.getX()));
      this.settings.getbData().set("chest.y", Double.valueOf(blockLocation.getY()));
      this.settings.getbData().set("chest.z", Double.valueOf(blockLocation.getZ()));
      this.settings.getbData().set("chest.world", blockLocation.getWorld().getName());
      this.settings.savebData();
      
      player.sendMessage(ChatColor.GREEN + "[MWS] Bank chest set. x:" + block.getX() + " y:" + block.getY() + " z:" + block.getZ());
      return true;
    }
  }
  
return false;}}}

