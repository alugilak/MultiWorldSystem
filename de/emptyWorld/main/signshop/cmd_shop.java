package de.emptyWorld.main.signshop;

import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.craftbukkit.libs.jline.internal.Log;
import org.bukkit.inventory.Inventory;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.economy.EconomyResponse;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import de.emptyWorld.main.einstellungen;
import de.emptyWorld.main.leerWelt;
import de.emptyWorld.main.loadworld;
import java.util.ArrayList;
import java.util.UUID;
import java.util.logging.Logger;

public class cmd_shop implements org.bukkit.event.Listener
{
	  Inventory shopList;
	  loadworld loader;
		loadworld worldLoader;
		einstellungen settings = einstellungen.getInstance();
		  FileConfiguration data;
		  FileConfiguration wdata;
		  FileConfiguration pdata;
		  FileConfiguration dedata;
		  FileConfiguration endata;
		  FileConfiguration permdata;
		  FileConfiguration sysodata;
		  
	  leerWelt plugin;
	  World world;
	  
	  public cmd_shop(leerWelt instance)
	  {

	    plugin = instance;
	  }
	  
	  public static enum signState {
	    VALID,  NOT_VALID;
	  }
	  public UUID getUUID(String player) {			
			if(Bukkit.getServer().getPlayer(player) == null){
				return Bukkit.getServer().getOfflinePlayer(player).getPlayer().getUniqueId();
			} else {
				return Bukkit.getServer().getPlayer(player).getUniqueId(); 
			}
		}
	  @EventHandler
	  public void onInvClick(InventoryClickEvent e) {
	    Player player = (Player)e.getWhoClicked();
	    Inventory inventory = e.getInventory();
	    ItemStack item = e.getCurrentItem();
	    if (inventory.getName().contains("'s shop")) {
	      e.setCancelled(true);
	      player.closeInventory();
	      if (item.getType() != Material.AIR) {
	        String name = inventory.getName();
	        String[] split = name.split("'");
	        String seller_name = split[0].toString();
	        OfflinePlayer seller = Bukkit.getOfflinePlayer(seller_name);
	        if (item.hasItemMeta()) {
	          ItemMeta meta = item.getItemMeta();
	          if (!player.getInventory().contains(item)) {
	            String ID_str = meta.getDisplayName();
	            int ID = Integer.parseInt(ID_str);
	            if (seller.isOnline()) {
	              plugin.buyItem(player, seller, ID);
	            } else {
	            	plugin.buyItem(player, seller, ID);
	            }
	          }
	        }
	      }
	    }
	  }
	  
	  @EventHandler
	  public void onJoin(PlayerJoinEvent e)
	  {
	    if ((plugin.getConfig().getString("shops." + e.getPlayer().getName()) != null) && (plugin.getConfig().getString("shops." + e.getPlayer().getName() + ".level") == null) && (plugin.getConfig().getString("shops." + e.getPlayer().getName() + ".items_on_sale") == null)) {
	    	plugin.getConfig().set("shops." + e.getPlayer().getName() + ".level", Integer.valueOf(1));
	    	plugin.getConfig().set("shops." + e.getPlayer().getName() + ".items_on_sale", Integer.valueOf(0));
	    	plugin.saveConfig();
	    }
	  }
	  

	  @EventHandler
	  public signState onPlace(SignChangeEvent e)
	  {
	    Player placer = e.getPlayer();
	    
	    if ((e.getBlock().getTypeId() == 63) || (e.getBlock().getTypeId() == 68)) {
	      String line1 = e.getLine(0);
	      String line2 = e.getLine(1);
	      String line3 = e.getLine(2);
	      String line4 = e.getLine(3);
	      
	      if ((line1.equals(plugin.getConfig().getString("ShopLine1")) && (placer.hasPermission("playershop.sign.place")))) {
	        if (line2.equals(plugin.getConfig().getString("visit"))) {
	          if (!line3.equals("")) {
	            if (plugin.getConfig().getString("shops." + line3) != null) {
	              String line1_new = ChatColor.DARK_AQUA + line1;
	              e.setLine(0, line1_new);
	              placer.sendMessage(ChatColor.GREEN + "s v sign successfully placed!");
	              return signState.VALID;
	            }
	            String line3_new = ChatColor.RED + "Doesn't exist";
	            e.setLine(2, line3_new);
	            placer.sendMessage(ChatColor.RED + "Shop doesn't exist!");
	            return signState.NOT_VALID;
	          }
	          
	          String line3_new = ChatColor.RED + "<player_name>";
	          e.setLine(2, line3_new);
	          placer.sendMessage(ChatColor.RED + "Player name is required!");
	          return signState.NOT_VALID;
	        }
	        if (line2.equals(plugin.getConfig().getString("buy"))) {
	          if (!line3.equals("")) {
	            if (plugin.getConfig().getString("shops." + line3) != null) {
	              if (!line4.equals("")) {
	                String line1_new = ChatColor.DARK_AQUA + line1;
	                e.setLine(0, line1_new);
	                placer.sendMessage(ChatColor.GREEN + "shop b sign successfully placed!");
	                return signState.VALID;
	              }
	              e.setLine(3, ChatColor.RED + "Invalid ID!");
	              placer.sendMessage(ChatColor.RED + "This item doesn't exist!");
	            }
	            else {
	              String line3_new = ChatColor.RED + "Doesn't exist";
	              e.setLine(2, line3_new);
	              placer.sendMessage(ChatColor.RED + "Shop doesn't exist!");
	              return signState.NOT_VALID;
	            }
	          } else {
	            String line3_new = ChatColor.RED + "<player_name>";
	            e.setLine(2, line3_new);
	            placer.sendMessage(ChatColor.RED + "Player name is required!");
	            return signState.NOT_VALID;
	          }
	        } else {
	          String line2_new = ChatColor.RED + "<v/b>?";
	          e.setLine(1, line2_new);
	          return signState.NOT_VALID;
	        }
	      }
	    }
	    return signState.VALID;
	  }
	  
	  @EventHandler
	  public void onInteract(PlayerInteractEvent e) {
	    if ((e.getAction() == org.bukkit.event.block.Action.RIGHT_CLICK_BLOCK) && (e.getPlayer().hasPermission("playershop.sign.use"))) {
	      Block block = e.getClickedBlock();
	      if ((block.getType() == Material.SIGN_POST) || (block.getType() == Material.WALL_SIGN)) {
	        Sign sign = (Sign)block.getState();
	        if (sign.getLine(0).equals(ChatColor.DARK_AQUA + plugin.getConfig().getString("shopLine1"))) {
	          if (sign.getLine(1).equals(plugin.getConfig().getString("visit"))) {
	            if (!sign.getLine(2).equals("")) {
	              Bukkit.getServer().dispatchCommand(e.getPlayer(), "s v " + sign.getLine(2));
	            }
	          } else if ((sign.getLine(1).equals(plugin.getConfig().getString("buy")) && 
	            (!sign.getLine(2).equals("")) && 
	            (!sign.getLine(3).equals("")))) {
	            plugin.buyItem(e.getPlayer(), Bukkit.getOfflinePlayer(sign.getLine(2)), Integer.parseInt(sign.getLine(3)));
	          }
	        }
	      }
	    }
	  }
	  


	  public boolean cmd(CommandSender sender, Command cmd, String commandLabel, String[] args)
	  {
	    Player player = (Player)sender;
	    if (args.length >= 1) { Material m;
	      if ((args[0].equalsIgnoreCase("s")) && (player.hasPermission(((String) this.settings.getpermData().getString("mwsshopsell"))))) {
	        if (args.length >= 2) {
	          if (args.length >= 3) {
	            if (plugin.getConfig().getString("shops." + sender.getName() + ".level") != null) {
	              int level = plugin.getConfig().getInt("shops." + sender.getName() + ".level");
	              int max_items = 0;
	              if (level == 1) {
	                max_items = 27;
	              } else if (level == 2) {
	                max_items = 36;
	              } else if (level == 3) {
	                max_items = 45;
	              } else if (level == 4) {
	                max_items = 54;
	              }
	              if ((args.length >= 4) && (plugin.getConfig().getInt("shops." + sender.getName() + ".items_on_sale") < max_items)) {
	                Integer db = Integer.valueOf(Integer.parseInt(args[2]));
	                Integer price = Integer.valueOf(Integer.parseInt(args[3]));
	                m = Material.matchMaterial(args[1]);
	                Inventory inv = player.getInventory();
	                ItemStack item = new ItemStack(m, db.intValue());
	                if (player.getInventory().contains(m, db.intValue())) {
	                  Integer ID = Integer.valueOf(plugin.getConfig().getInt("Last ID"));
	                  Integer IDP = Integer.valueOf(ID.intValue() + 1);
	                  plugin.getConfig().set("Last ID", IDP);
	                  plugin.getConfig().set("shops." + sender.getName() + "." + IDP + ".item", item);
	                  plugin.getConfig().set("shops." + sender.getName() + "." + IDP + ".price", price);
	                  plugin.getConfig().set("shops." + sender.getName() + ".items_on_sale", Integer.valueOf(plugin.getConfig().getInt("shops." + sender.getName() + ".items_on_sale") + 1));
	                  inv.removeItem(new ItemStack[] { new ItemStack(m, db.intValue()) });
	                  player.updateInventory();
	                  plugin.saveConfig();
	                  player.sendMessage(ChatColor.GREEN + "You offered for sale at $" + price + " for " + db + " pieces of " + item.getType() + "! with ID: " + IDP);
	                  Bukkit.broadcastMessage(ChatColor.GOLD + player.getName() + " offered for sale at $" + price + " for " + db + " pieces of " + item.getType());
	                } else {
	                  player.sendMessage(ChatColor.RED + "No such item/block in your inventory!");
	                }
	              } else if (plugin.getConfig().getInt("shops." + sender.getName() + ".items_on_sale") == max_items) {
	                sender.sendMessage(ChatColor.RED + "You already reached maximum of number of sales, try upgrade you shop!");
	              }
	            } else if (plugin.getConfig().getString("shops." + sender.getName()) == null) {
	              sender.sendMessage(ChatColor.RED + "You don't have shop, buy a shop and try again!");
	            }
	          }
	        } else {
	          player.sendMessage(ChatColor.RED + "Usage: /ps s <item> <pieces> <price>");
	        }
	      }
	      
	      if ((args[0].equalsIgnoreCase("v")) && (player.hasPermission(((String) this.settings.getpermData().getString("mwsshop"))))) {
	        if (args.length == 2) {
	          if (plugin.getConfig().getString("shops." + args[1] + ".level") != null) {
	            int level = plugin.getConfig().getInt("shops." + sender.getName() + ".level");
	            int max_items = 0;
	            if (level == 1) {
	              max_items = 27;
	            } else if (level == 2) {
	              max_items = 36;
	            } else if (level == 3) {
	              max_items = 45;
	            } else if (level == 4) {
	              max_items = 54;
	            }
	            shopList = Bukkit.createInventory(null, max_items, args[1] + "'s shop");
	            org.bukkit.configuration.ConfigurationSection shop = plugin.getConfig().getConfigurationSection("shops." + args[1]);
	            for (String ID : shop.getKeys(false)) {
	              if (plugin.getConfig().getItemStack("shops." + args[1] + "." + ID + ".item") != null) {
	                ItemStack item = new ItemStack(plugin.getConfig().getItemStack("shops." + args[1] + "." + ID + ".item"));
	                Integer price = Integer.valueOf(plugin.getConfig().getInt("shops." + args[1] + "." + ID + ".price"));
	                ItemMeta meta = item.getItemMeta();
	                ArrayList<String> Lore = new ArrayList<String>();
	                
	                meta.setDisplayName(ID);
	                Lore.add(ChatColor.DARK_PURPLE + "Item: " + item.getType());
	                Lore.add(ChatColor.DARK_PURPLE + "Pieces: " + item.getAmount());
	                Lore.add(ChatColor.DARK_PURPLE + "Price: $" + price);
	                meta.setLore(Lore);
	                item.setItemMeta(meta);
	                shopList.addItem(new ItemStack[] { item });
	              }
	            }
	            

	            player.openInventory(shopList);
	          } else {
	            player.sendMessage(ChatColor.RED + "This shop doesn't exist!");
	          }
	        } else {
	          player.sendMessage(ChatColor.RED + "Usage: /shop v <player>");
	        }
	      }
	    }
	    

	    if ((args[0].equalsIgnoreCase("remove")) && (player.hasPermission(((String) this.settings.getpermData().getString("mwsshopremove"))))) {
	      if (args.length == 3) {
	        String seller = args[1].toString();
	        OfflinePlayer selller = Bukkit.getOfflinePlayer(seller);
	        Inventory inv = null;
	        if (selller.hasPlayedBefore()) {
	          inv = ((Player)selller).getInventory();
	        } else {
	          player.sendMessage("This player doesn't exist!");
	          return true;
	        }
	        
	        Integer ID = Integer.valueOf(Integer.parseInt(args[2]));
	        if (((plugin.getConfig().getItemStack("shops." + seller + "." + ID + ".item") != null) && (player.isOp())) || ((plugin.getConfig().getItemStack("shops." + seller + "." + ID + ".item") != null) && (selller.getName() == player.getName()))) {
	          ItemStack Item = new ItemStack(plugin.getConfig().getItemStack("shops." + seller + "." + ID + ".item"));
	          plugin.getConfig().set("shops." + seller + "." + ID, null);
	          plugin.getConfig().set("shops." + seller + ".items_on_sale", Integer.valueOf(plugin.getConfig().getInt("shops." + seller + ".items_on_sale") - 1));
	          inv.addItem(new ItemStack[] { Item });
	          plugin.saveConfig();
	          sender.sendMessage(ChatColor.RED + "You removed item with ID: " + ID);
	        } else if ((!player.isOp()) && (selller.getName() != player.getName())) {
	          player.sendMessage(ChatColor.RED + "You don't have permission to remove other player's item!");
	        } else if (plugin.getConfig().getItemStack("shops." + seller + "." + ID + ".item") == null) {
	          player.sendMessage(ChatColor.RED + "This item doesn't exist!");
	        }
	      } else if (args.length < 3) {
	        player.sendMessage(ChatColor.RED + "Usage: /ps remove <sellers_name> <ID>");
	      }
	    }
	    if ((args[0].equalsIgnoreCase("delete")) && (player.hasPermission(((String) this.settings.getpermData().getString("mwsshopdelete"))))) {
	      if (plugin.getConfig().getString("shops." + sender.getName() + ".level") != null) {
	        plugin.getConfig().set("shops." + sender.getName(), null);
	        sender.sendMessage(ChatColor.GREEN + "You successfully deleted your shop!");
	        plugin.saveConfig();
	      } else {
	        sender.sendMessage(ChatColor.RED + "You don't have a shop!");
	      }
	    }
	    
	    if ((args[0].equalsIgnoreCase("create")) && (player.hasPermission(((String) this.settings.getpermData().getString("mwsshopcreate"))))) {
	      if (plugin.getConfig().getString("shops." + sender.getName() + ".level") == null) {
	        if (leerWelt.econ.getBalance(player) > 0.0D) {
	          int shop_price = plugin.getConfig().getInt("shop_price");
	          EconomyResponse r = leerWelt.econ.withdrawPlayer(sender.getName(), shop_price);
	          if (r.transactionSuccess()) {
	            plugin.log.info("A PlayerShop transaction successfully completed!");
	          }
	          plugin.getConfig().set("shops." + sender.getName() + ".level", Integer.valueOf(1));
	          plugin.getConfig().set("shops." + sender.getName() + ".items_on_sale", Integer.valueOf(0));
	          sender.sendMessage(ChatColor.GREEN + "You successfully created a shop for " + shop_price + "$");
	          plugin.saveConfig();
	        } else {
	          player.sendMessage(ChatColor.RED + "You don't have enough money to create a shop!");
	        }
	      } else {
	        sender.sendMessage(ChatColor.RED + "You already have a shop!");
	      }
	    }
	    if (args[0].equals("upgrade")) {
	      if (plugin.getConfig().getString("shops." + sender.getName() + ".level") != null) {
	        int level = plugin.getConfig().getInt("shops." + sender.getName() + ".level");
	        int max_level = 4;
	        if (level != max_level) {
	          int upgrade_price = plugin.getConfig().getInt("upgrade_price");
	          EconomyResponse r = leerWelt.econ.withdrawPlayer(sender.getName(), upgrade_price);
	          if (r.transactionSuccess()) {
	            plugin.log.info("A PlayerShop transaction successfully completed!");
	          }
	          plugin.getConfig().set("shops." + sender.getName() + ".level", Integer.valueOf(level + 1));
	          plugin.saveConfig();
	          sender.sendMessage(ChatColor.GREEN + "You upgraded your shop successfully!");
	        } else {
	          sender.sendMessage(ChatColor.RED + "Your shop already reached max level!");
	        }
	      } else {
	        sender.sendMessage(ChatColor.RED + "You don't have shop!");
	      }
	    }
	    
	    return true;
	  }
	}