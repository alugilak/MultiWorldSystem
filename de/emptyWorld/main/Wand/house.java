package de.emptyWorld.main.Wand;

import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.sk89q.worldedit.MaxChangedBlocksException;
import com.sk89q.worldedit.patterns.Pattern;

import de.emptyWorld.main.einstellungen;
import de.emptyWorld.main.leerWelt;

public class house implements CommandExecutor {	
	einstellungen settings = einstellungen.getInstance();
	  FileConfiguration mobdata;	
	  leerWelt plugin;  
	
	  
	  public house( leerWelt instance)
	  {

	  plugin = instance;
	  }
	  
	
	  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) 
		{
			Player player = (Player) sender;
			
			Location blockLocation = player.getLocation();
			double y = blockLocation.getBlockY();
			double x = blockLocation.getBlockX();
			double z = blockLocation.getBlockZ();
			x = x + 0;
			
			World currentWorld = player.getWorld();
			if (sender instanceof Player)
			{
			if(cmd.getName().equalsIgnoreCase("house"))
			{
				if (!player.hasPermission((String)this.settings.getpermData().get("mwshouse")))
				{
					  if (args.length <= 4) {
							player.sendMessage(ChatColor.GREEN + "/house <BlockID> <DataValue> <BlockID> <DataValue> <high> ");	
					  }
					  if (args.length >= 5) {
						  int id = Integer.parseInt(args[0]);
							int sid = Integer.parseInt(args[1]);
							int tid = Integer.parseInt(args[2]);
							int tsid = Integer.parseInt(args[3]);
							int high = Integer.parseInt(args[4]);
							
				boolean roof = true;
				boolean brickUp = true;
				
				while(brickUp == true)
				{
					int blockUp = high;
					int blockUp2 = high;
				while(blockUp <= 2)
				{
					int blockx1 = 1;
					int blockx2 = 1;
					int blockx3 = 1;
					int blockz1 = 1;
					int blockz2 = 1;
					while (blockx1 <= 3)
					{				
						x++;
						Location rightBlock = new Location(currentWorld, x, y, z);						
						rightBlock.getBlock().setTypeId(tid);
						rightBlock.getBlock().setData((byte)tsid);
						blockx1++;
					}
					while (blockz1 <= 4)
					{				
						z++;
						Location rightBlock = new Location(currentWorld, x, y, z);
						rightBlock.getBlock().setTypeId(tid);
						rightBlock.getBlock().setData((byte)tsid);
						blockz1++;
					}
					x = x - 3;
					z = z - 4;
					
					while (blockx2 <= 3)
					{				
						x = x-1;
						Location rightBlock = new Location(currentWorld, x, y, z);
						rightBlock.getBlock().setTypeId(tid);
						rightBlock.getBlock().setData((byte)tsid);
						blockx2++;
					}
					while (blockz2 <= 4)
					{				
						z++;
						Location rightBlock = new Location(currentWorld, x, y, z);
						rightBlock.getBlock().setTypeId(tid);
						rightBlock.getBlock().setData((byte)tsid);
						blockz2++;
					}
					while (blockx3 <= 5)
					{				
						x++;
						Location rightBlock = new Location(currentWorld, x, y, z);
						rightBlock.getBlock().setTypeId(tid);
						rightBlock.getBlock().setData((byte)tsid);
						blockx3++;
					}
					x = x - 2;
					z = z - 4;
					y++;
					blockUp++;
					}
				y = y-1;
				
				Location wrong2Block = new Location(currentWorld, x, y, z);
				wrong2Block.getBlock().setTypeId(tid);
				wrong2Block.getBlock().setData((byte)tsid);
				ItemStack droppedItemTorch = new ItemStack(Material.TORCH, 1);
				currentWorld.dropItem(wrong2Block, droppedItemTorch);
				
				y = y + 1;
				while(blockUp2 <= 0)
				{
					int blockx1 = 1;
					int blockx2 = 1;
					int blockx3 = 1;
					int blockz1 = 1;
					int blockz2 = 1;
					while (blockx1 <= 3)
					{				
						x++;
						Location rightBlock = new Location(currentWorld, x, y, z);
						rightBlock.getBlock().setTypeId(id);
						rightBlock.getBlock().setData((byte)sid);
						blockx1++;
					}
					while (blockz1 <= 4)
					{				
						z++;
						Location rightBlock = new Location(currentWorld, x, y, z);
						rightBlock.getBlock().setTypeId(id);
						rightBlock.getBlock().setData((byte)sid);
						blockz1++;
					}
					x = x - 2;
					z = z - 4;
					
					while (blockx2 <= 4)
					{				
						x = x-1;
						Location rightBlock = new Location(currentWorld, x, y, z);
						rightBlock.getBlock().setTypeId(id);
						rightBlock.getBlock().setData((byte)sid);
						blockx2++;
					}
					while (blockz2 <= 4)
					{				
						z++;
						Location rightBlock = new Location(currentWorld, x, y, z);
						rightBlock.getBlock().setTypeId(id);
						rightBlock.getBlock().setData((byte)sid);
						blockz2++;
					}
					while (blockx3 <= 5)
					{				
						x++;
						Location rightBlock = new Location(currentWorld, x, y, z);
						rightBlock.getBlock().setTypeId(id);
						rightBlock.getBlock().setData((byte)sid);
						blockx3++;
					}
					x = x - 2;
					z = z - 4;
					y++;
					blockUp2++;
					}
				brickUp = false;
				}
				while(roof == true)
				{
					y = y - 1;
					z = z + 1;
					x = x - 3;
					int blockx1 = 1;
					int blockx2 = 1;
					int blockx3 = 1;
					int blockz1 = 1;
					int blockz2 = 1;
					
					while (blockx1 <= 5)
					{				
						x++;
						Location rightBlock = new Location(currentWorld, x, y, z);
						rightBlock.getBlock().setTypeId(id);
						rightBlock.getBlock().setData((byte)sid);
						blockx1++;
					}
					while (blockz1 <= 2)
					{			
						z++;
						Location rightBlock = new Location(currentWorld, x, y, z);
						rightBlock.getBlock().setTypeId(id);
						rightBlock.getBlock().setData((byte)sid);
						blockz1++;
					}
					while (blockx2 <= 4)
					{				
						x = x-1;
						Location rightBlock = new Location(currentWorld, x, y, z);
						rightBlock.getBlock().setTypeId(id);
						rightBlock.getBlock().setData((byte)sid);
						blockx2++;
					}
					while (blockz2 <= 1)
					{				
						z = z - 1;
						Location rightBlock = new Location(currentWorld, x, y, z);
						rightBlock.getBlock().setTypeId(id);
						rightBlock.getBlock().setData((byte)sid);
						blockz2++;
					}
					while (blockx3 <= 3)
					{				
						x++;
						Location rightBlock = new Location(currentWorld, x, y, z);
						rightBlock.getBlock().setTypeId(tid);
						rightBlock.getBlock().setData((byte)tsid);
						blockx3++;
					}
					roof = false;				
				}
				player.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String) this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + ChatColor.AQUA +  player.getName() + ChatColor.GREEN +" has made a house.");
			}
				else
				{
					sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String) this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + ChatColor.BLUE + ((String) this.settings.getpermData().get("mwshouse")) + " " + ChatColor.GREEN + ((String)this.settings.getsysoData().get("permError")));
				}
				return true;
			}			
			
			else if(cmd.getName().equalsIgnoreCase("househelp"))
			{
				if (!player.hasPermission(this.settings.getpermData().getString("mwshouseHelp")));	
				sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String) this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + ChatColor.BLUE + ((String) this.settings.getpermData().get("mwshouseHelp")) + " " + ChatColor.GREEN + ((String)this.settings.getsysoData().get("permError")));
					
					return false;
				}}
				else
				{
					player.sendMessage(ChatColor.GREEN + "/househelp -shows this page.");
					player.sendMessage(ChatColor.GREEN + "/<house> <BlockID> <DataValue> <BlockID> <DataValue> <hight> -makes a house.");
					player.sendMessage(ChatColor.GREEN + "/house2 <BlockID> <DataValue> <WindowsID> <WindowsDataValue> -makes a house.");
					player.sendMessage(ChatColor.GREEN + "/house3 <BlockID> <DataValue> <roofBlockID> <roofDataValue> <groundBlockID> <groundDataValue> <windowBlockID> <windowsDataValue> -makes a house.");
					player.sendMessage(ChatColor.GREEN + "/house4 <BlockID> <DataValue> <poleBlockID> <poleDataValue> -makes a house.");
				return true;}
			}
			
			return false;
		}
			
			
	}