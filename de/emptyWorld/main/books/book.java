package de.emptyWorld.main.books;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;
import org.bukkit.plugin.PluginDescriptionFile;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import de.emptyWorld.main.einstellungen;
import de.emptyWorld.main.leerWelt;

public class book implements CommandExecutor, Listener
{
	
	ConsoleCommandSender console = Bukkit.getConsoleSender();
	einstellungen settings = einstellungen.getInstance();

	  FileConfiguration permdata;
	  FileConfiguration sysodata;
	  World world;
	
	  leerWelt plugin;
	  File _file_newspaper;
String c_prefix = "/a/[/5/newspaper/a/] /f/";
		//Debug prefix
String d_prefix = "/a/[/5/newspaper Debug/a/] /f/";
		//Player prefix
String p_prefix = "/a/[/5/newspaper/a/] /f/";
String no_permission = "/4/You have no permission to perform this command.";
	
  public book( leerWelt instance)
  {

    plugin = instance;
    
  }  
  
  
  
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
		
		if(label.equalsIgnoreCase("np") || label.equalsIgnoreCase("newspaper")){
			
			if(sender instanceof Player){
				Player player = (Player) sender;
				newspaperCommand(player, args);
			}else{
				if(args.length == 0){
					sendMessage(replaceColors(c_prefix + "Help", true));
					sendMessage(replaceColors("/np list [join / normal] - get a list of newspaper"));
					sendMessage(replaceColors("/np give <player name / all> <newspaper name> - give a newspaper to a player or all players", true));
					sendMessage(replaceColors("/np reload - reload the config.xml", true));
					sendMessage(replaceColors("/np version - plugin info", true));
				}else if(args[0].equalsIgnoreCase("reload")){
					plugin.reloadConfig();
					plugin.debug = plugin.getConfig().getBoolean("debug");
					sendMessage(replaceColors(c_prefix + 
							"Reloaded plugin"));
				}else if(args[0].equalsIgnoreCase("list")){
					//List all newspaper
					if(args.length == 1 || !args[1].equalsIgnoreCase("join")){
						//List of normal newspaper
						sendMessage(null, replaceColors(c_prefix + "/6/Normal newspaper"));
						listnewspaper(null, "normal");
					}else{
						//List of join newspaper
						sendMessage(null, replaceColors(c_prefix + "/6/Join newspaper"));
						listnewspaper(null, "join");
					}
				}else if(args[0].equalsIgnoreCase("give")){
					//Give newspaper to player from console
					if(args.length >= 3){
						String args_str = "";
						for(int o = 2; o < args.length; o++){ args_str += args[o] + " "; }
						args_str = args_str.trim();
						if(args[1].equalsIgnoreCase("*") || args[1].equalsIgnoreCase("all")){
							//Give to all players
							giveBook("console", null, args_str);
						}else{
							//Give to specific player
							Player targetPlayer = Bukkit.getPlayerExact(args[1]);
							if(targetPlayer != null){
								giveBook("console", Bukkit.getPlayer(args[1]), args_str);
							}else{
								sendMessage(null, replaceColors("/4/No player by the name " + args[1] + " is online", true));
							}
						}
					}else{
						sendMessage(null, replaceColors("/np give <player/*> <newspaper>", true));
					}
				}else if(args[0].equalsIgnoreCase("version")){
					PluginDescriptionFile pdfFile = plugin.getDescription();
					List<String> authors = pdfFile.getAuthors();
					sendMessage(replaceColors(c_prefix + pdfFile.getName() + " version " + pdfFile.getVersion() + " by " + authors.get(0), true));
					sendMessage("Website: " + pdfFile.getWebsite());
				}else if(args[0].equalsIgnoreCase("debug")){
					if(plugin.getConfig().getBoolean("debug")){
						plugin.getConfig().set("debug", false);
						plugin.saveConfig();
						sendMessage(replaceColors(d_prefix + "Disabled", true));
					}else{
						plugin.getConfig().set("debug", true);
						plugin.saveConfig();
						sendMessage(replaceColors(d_prefix + "Enabled", true));
					}
				}else{
					//This is what happens if the command is forced trough console
					sendMessage(replaceColors(c_prefix + 
							"&4newspaper can not be given to console", true));
				}
			}
		}//End of the np commands
		
		
		return false;
	}
	
	//Moved to separate function in case it gets interesting to try to use /newspaper to override essentials
	private void newspaperCommand(Player p, String[] args){
		if(args.length == 0 || args[0].equalsIgnoreCase("help")){
			//List of commands
			List<String> commandos = new ArrayList<String>();
			commandos.add("np help - view this information");
			commandos.add("np list [join / normal] - get a list of newspaper");
			commandos.add("np <newspaper name> - receive a newspaper");
			commandos.add("np create <newspaper type> [command] - save the newspaper in your hand");
			
			p.sendMessage(replaceColors(p_prefix + "Help"));
			for(int e = 0; e < commandos.size(); e++){
				p.sendMessage(replaceColors("/" + commandos.get(e)));
			}
		}else if(args[0].equalsIgnoreCase("list")){
			if(args.length == 1 || !args[1].equalsIgnoreCase("join")){
				//List of normal newspaper
				p.sendMessage(replaceColors("/6/Normal newspaper"));
				listnewspaper(p, "normal");
			}else{
				//List of join newspaper
				p.sendMessage(replaceColors("/6/Join newspaper"));
				listnewspaper(p, "join");
			}
		}else if(args[0].equalsIgnoreCase("reload")){
			if(p.hasPermission("news.paper.reload") || p.hasPermission("news.paper.*")){
				plugin.reloadConfig();
				plugin.debug = plugin.getConfig().getBoolean("debug");
				p.sendMessage(replaceColors(p_prefix + 
						"Reloaded plugin"));
			}else{
				p.sendMessage(replaceColors(no_permission));
			}
		}else if(args[0].equalsIgnoreCase("give")){
			if(args.length >= 3){
				String args_str = "";
				for(int o = 2; o < args.length; o++){ args_str += args[o] + " "; }
				args_str = args_str.trim();
				if(args[1].equalsIgnoreCase("*") || args[1].equalsIgnoreCase("all")){
					//Give to all players
					giveBook(p, null, args_str, "news.paper.give");
				}else{
					//Give to specific player
					Player targetPlayer = Bukkit.getPlayerExact(args[1]);
					if(targetPlayer != null){
						giveBook(p, Bukkit.getPlayer(args[1]), args_str, "news.paper.give");
					}else{
						p.sendMessage(replaceColors("/4/No player by the name " + args[1] + " is online"));
					}
				}
			}else{
				p.sendMessage(replaceColors("/np give <player/*> <newspapername>"));
			}
		}else if(args[0].equalsIgnoreCase("version")){
			PluginDescriptionFile pdfFile = plugin.getDescription();
			List<String> authors = pdfFile.getAuthors();
			p.sendMessage(replaceColors(p_prefix + pdfFile.getName() + " version " + pdfFile.getVersion() + " by " + authors.get(0)));
			p.sendMessage("Website: " + pdfFile.getWebsite());
		}else if(args[0].equalsIgnoreCase("create")){
			//Command to fetch a newspaper from the players inventory and save it in the newspaper file
			createnewspaper(p, args);
		}else{
			//Convert command into a string, to enable multi-word commands
			String args_str = "";
			for(int i = 0; i < args.length; i++){ args_str += args[i] + " "; }
			args_str = args_str.trim();
			
			giveBook(p, args_str, "news.paper.normal");
		}
	}
	
	//Function to give book to a specific player or all players
	private void giveBook(String sender, Player tp, String args_str){
		giveBook(null, tp, args_str, "news.paper.give"); //Last argument just because I'm too lazy to make a function that doesn't need it
	}
	private void giveBook(Player p, String args_str, String permission){
		giveBook(p, p, args_str, permission);
	}
	private void giveBook(Player p, Player tp, String args_str, String permission){
		try{
    		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
    		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
    		Document doc = dBuilder.parse(_file_newspaper);
    				
    		//optional, but recommended
    		//read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
    		doc.getDocumentElement().normalize();
    		
    		boolean no_newspaper = true;
    		for(int i = 0; i < doc.getElementsByTagName("newspaper").getLength(); i++){
    			Node nNode = doc.getElementsByTagName("newspaper").item(i);
    					
    			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
    				Element newspaperData = (Element) nNode;
    				boolean isNormalnewspaper = false;
    				String[] types = newspaperData.getElementsByTagName("type").item(0).getTextContent().split(",");
    				for(int w = 0; w < types.length; w++){
    					if(types[w].trim().equalsIgnoreCase("normal"))
    						isNormalnewspaper = true;
    				}
    				if(isNormalnewspaper){
	    				if(newspaperData.getElementsByTagName("command").item(0).getTextContent()
	    						.equalsIgnoreCase(args_str)){
	    					no_newspaper = false;
				    		//TODO find config / permissions to see which custom permissions are required
				    		//Node config = newspaperData.getElementsByTagName("config").item(0);
				    		boolean hasPermission = false;
				    		if(p != null){
				    			String[] permissions = newspaperData.getElementsByTagName("permissions").item(0).getTextContent().split(",");
					    		for(int z = 0; z < permissions.length; z++){
					    			if(p.hasPermission(permission + permissions[z].trim())){
					    				hasPermission = true;
					    				z = permissions.length;
					    			}
					    		}
					    		if(p.hasPermission(permission + "*") || p.hasPermission("news.paper.*")){
					    			hasPermission = true;
					    		}
				    		}else{
				    			hasPermission = true;
				    		}
				    		if(hasPermission){
				    			String title = replaceColors(newspaperData.getElementsByTagName("title").item(0).getTextContent());
				    			String author = replaceColors(newspaperData.getElementsByTagName("author").item(0).getTextContent());
				    			List<String> lore = new ArrayList<>(newspaperData.getElementsByTagName("lore").getLength());
				    			for(int z = 0; z < newspaperData.getElementsByTagName("lore").getLength(); z++){
				    				lore.add(z, replaceColors(newspaperData.getElementsByTagName("lore").item(z).getTextContent()));
				    			}
				    			List<String> pages = new ArrayList<>(newspaperData.getElementsByTagName("page").getLength());
				    			for(int z = 0; z < newspaperData.getElementsByTagName("page").getLength(); z++){
				    				pages.add(z, replaceColors(newspaperData.getElementsByTagName("page").item(z).getTextContent()));
				    			}
				    			short durability = Short.parseShort(newspaperData.getElementsByTagName("durability").item(0).getTextContent());
				    			int amount = Integer.parseInt(newspaperData.getElementsByTagName("amount").item(0).getTextContent());
				    			
				    			//Give newspaper
				    			ItemStack newspaper = new ItemStack(Material.WRITTEN_BOOK);
								BookMeta meta = (BookMeta) newspaper.getItemMeta();
								meta.setTitle(title);
								meta.setAuthor(author);
								meta.setLore(lore);
								meta.setPages(pages);
								newspaper.setItemMeta(meta);
								newspaper.setAmount(amount);
								newspaper.setDurability(durability);
						        if(tp != null){
						        	tp.getInventory().addItem(newspaper);
						        	sendMessage(p, replaceColors("/a/newspaper \"" + title + "\" has been given to " + tp.getName()));
						        }else{
						        	for(Player player : Bukkit.getOnlinePlayers()){
						        		player.getInventory().addItem(newspaper);
						        	}
						        	sendMessage(p, replaceColors("/a/newspaper \"" + title + "\" has been given to all online players"));
						        }
				    		}
	    				}
    				}//ELSE is not a normal newspaper
	    		}else{
	    			//Element is of wrong type
	    			p.sendMessage(replaceColors("/4/Misconfigured newspaper"));
	    		}
	    		
    		}
    		//Check if no newspaper exists
    		if(no_newspaper){
    			p.sendMessage(replaceColors(p_prefix + "The newspaper '" + args_str + "/r//f/' does not exist"));
    		}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	private void listnewspaper(Player p, String type){
		File f = _file_newspaper;
		
		//Read the newspaper content
		try{
    		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
    		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
    		Document doc = dBuilder.parse(f);
    				
    		//optional, but recommended
    		//read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
    		doc.getDocumentElement().normalize();
    		
    		boolean displayed_newspaper = false;
    		boolean no_perm = false;
    		
    		for(int i = 0; i < doc.getElementsByTagName("newspaper").getLength(); i++){
    			Node nNode = doc.getElementsByTagName("newspaper").item(i);
    					
    			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
    				Element newspaperData = (Element) nNode;
    				boolean isRightType = false;
    				String[] types = newspaperData.getElementsByTagName("type").item(0).getTextContent().split(",");
    				for(int w = 0; w < types.length; w++){
    					if(plugin.debug){
    						sendMessage("newspaper type " + w + "of newspaper " + 
    								newspaperData.getElementsByTagName("title").item(0).getTextContent() + 
    								": " + types[w].trim());
    					}
    					if(type.equalsIgnoreCase("normal")){
    						if(types[w].trim().equalsIgnoreCase("normal")){
    							isRightType = true; 
    							//Quit the loop
    							w = types.length;
							}
    					}else if(type.equalsIgnoreCase("join")){
    						if(types[w].trim().equalsIgnoreCase("join") || 
    								types[w].trim().equalsIgnoreCase("firstjoin")){
    							isRightType = true;
    							//Quit the loop
    							w = types.length;
    						}
    					}
    				}
    				if(isRightType){
    					int permission_index = 0;
    					String permission_str = "news.paper.normal";
    					if(type.equalsIgnoreCase("join")){
    						permission_index = 1;
    						permission_str = "news.paper.join";
    					}
			    		boolean hasPermission = false;
			    		if(p != null){
			    			String[] permissions = newspaperData.getElementsByTagName("permissions").item(permission_index).getTextContent().split(",");
				    		for(int z = 0; z < permissions.length; z++){
				    			if(p.hasPermission(permission_str + permissions[z].trim())){
				    				hasPermission = true;
				    				z = permissions.length;
				    			}
				    		}
				    		if(p.hasPermission(permission_str + "*") || p.hasPermission("news.paper.*")){
				    			hasPermission = true;
				    		}
			    		}else{
			    			hasPermission = true;
			    		}
			    		
			    		if(hasPermission){
			    			String title = newspaperData.getElementsByTagName("title").item(0).getTextContent();
			    			String author = newspaperData.getElementsByTagName("author").item(0).getTextContent();
			    			if(type.equalsIgnoreCase("join")){
			    				sendMessage(p, replaceColors(title + "/r//f/ by " + author));
			    			}else{
			    				String command = newspaperData.getElementsByTagName("command").item(0).getTextContent();
			    				sendMessage(p, replaceColors("/np " + command + ": " + title + "/r//f/ by " + author));
			    			}
			    			displayed_newspaper = true;
			    		}else{
			    			//No permission to view newspaper
			    			no_perm = true;
			    		}
    				}//ELSE the newspaper is not of requested type
	    		}else{
	    			//Element is of wrong type
	    			if(plugin.debug){
	    				sendMessage(replaceColors("/4/Misconfigured newspaper"));
	    			}
	    		}
	    		
    		}
    		
    		if(!displayed_newspaper){
    			if(no_perm)
    				p.sendMessage(replaceColors("/4/You do not have permission to obtain any custom newspaper"));
    			else
    				p.sendMessage(replaceColors("There are no custom newspapers of the requested type"));
    		}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
  
  private void createnewspaper(Player p, String[] args){
		if(p.hasPermission("news.paper.create")){
			if(p.getInventory().getItemInMainHand().getItemMeta().equals(Material.WRITTEN_BOOK)){
				if(args.length >= 3){
					String args_str = "";
					for(int i = 1; i < args.length; i++){ args_str += args[i] + " "; }
					args_str = args_str.trim();
					/*
					 * Calculate how many of the arguments are defining the newspaper type
					 */
					String newspaper_type = "";
					String newspaper_command = "";
					String[] types = args_str.split(",");
					for(int i = 0; i < types.length; i++){
						//Maybe add some kind of check to see whether the types are accepted or not
						if(i == types.length - 1){
							//Last index
							newspaper_type += types[i].trim().split(" ")[0];
							newspaper_command = types[i].trim().split(" ", 2)[1];
						}else{
							newspaper_type += types[i].trim() + ", ";
						}
					}
					
					/*
					 * Get newspaper item and get the contents
					 */
					ItemStack newspaper = new ItemStack(p.getInventory().getItemInMainHand());
					BookMeta meta = (BookMeta) newspaper.getItemMeta();
					String newspaper_author = meta.getAuthor();
					String newspaper_title = meta.getTitle();
					String[] newspaper_lore = new String[meta.getLore().size()];
					for(int i = 0; i < newspaper_lore.length; i++){
						/* 
						 * Replace colors and new lines with the codes (/code/)
						 */
						newspaper_lore[i] = replaceColorsInverse(meta.getLore().get(i));
					}
					String[] newspaper_pages = new String[meta.getPages().size()];
					for(int i = 0; i < newspaper_pages.length; i++){
						/* 
						 * Replace colors and new lines with the codes (/code/)
						 * 
						 * Pages start with index 1 instead of normal 0, 
						 * but the result array will start at index 0
						 */
						newspaper_pages[i] = replaceColorsInverse(meta.getPage(i + 1));
					}
					
					/*
					 * Save the newspaper in the xml document (and take backup of old file in case anything goes wrong)
					 */
				}else{
					p.sendMessage("/np create <types> [command]");
					p.sendMessage("Example: /np create firstjoin,normal,join information");
				}
			}else{
				p.sendMessage(replaceColors("/4/You have to hold a written newspaper."));
			}
		}else{
			p.sendMessage(replaceColors(no_permission));
		}
	}
	
	private void sendMessage(String msg){
		sendMessage(null, msg);
	}
	private void sendMessage(Player p, String msg){
		if(p == null){
			console.sendMessage(msg);
		}else{
			p.sendMessage(msg);
		}
	}
	
	public static String replaceColorsInverse(String s){
		return replaceColors(s, false, true);
	}
	public static String replaceColors(String s){
		return replaceColors(s, false, false);
	}
	public static String replaceColors(String s, boolean console){
		return replaceColors(s, console, false);
	}
	public static String replaceColors(String s, boolean console, boolean inverse){
		String prefix = "/";
		String suffix = "/";
		
		String res = "";
		if(!inverse){
			res = s.replaceAll(prefix + "0" + suffix, ChatColor.BLACK + "").replaceAll(prefix + "1" + suffix, ChatColor.DARK_BLUE + "")
					.replaceAll(prefix + "2" + suffix, ChatColor.DARK_GREEN + "").replaceAll(prefix + "3" + suffix, ChatColor.DARK_AQUA + "")
					.replaceAll(prefix + "4" + suffix, ChatColor.DARK_RED + "").replaceAll(prefix + "5" + suffix, ChatColor.DARK_PURPLE + "")
					.replaceAll(prefix + "6" + suffix, ChatColor.GOLD + "").replaceAll(prefix + "7" + suffix, ChatColor.GRAY + "")
					.replaceAll(prefix + "8" + suffix, ChatColor.DARK_GRAY + "").replaceAll(prefix + "9" + suffix, ChatColor.BLUE + "")
					.replaceAll(prefix + "a" + suffix, ChatColor.GREEN + "").replaceAll(prefix + "b" + suffix, ChatColor.AQUA + "")
					.replaceAll(prefix + "c" + suffix, ChatColor.RED + "").replaceAll(prefix + "d" + suffix, ChatColor.LIGHT_PURPLE + "")
					.replaceAll(prefix + "e" + suffix, ChatColor.YELLOW + "").replaceAll(prefix + "f" + suffix, ChatColor.WHITE + "")
					.replaceAll(prefix + "m" + suffix, ChatColor.STRIKETHROUGH + "").replaceAll(prefix + "n" + suffix, ChatColor.UNDERLINE + "")
					.replaceAll(prefix + "l" + suffix, ChatColor.BOLD + "").replaceAll(prefix + "k" + suffix, ChatColor.MAGIC + "")
					.replaceAll(prefix + "o" + suffix, ChatColor.ITALIC + "").replaceAll(prefix + "r" + suffix, ChatColor.RESET + "")
					.replaceAll(prefix + "z" + suffix, "\n");
		}else{
			res = s.replaceAll(ChatColor.BLACK + "", prefix + "0" + suffix).replaceAll(ChatColor.DARK_BLUE + "", prefix + "1" + suffix)
					.replaceAll(ChatColor.DARK_GREEN + "", prefix + "2" + suffix).replaceAll(ChatColor.DARK_AQUA + "", prefix + "3" + suffix)
					.replaceAll(ChatColor.DARK_RED + "", prefix + "4" + suffix).replaceAll(ChatColor.DARK_PURPLE + "", prefix + "5" + suffix)
					.replaceAll(ChatColor.GOLD + "", prefix + "6" + suffix).replaceAll(ChatColor.GRAY + "", prefix + "7" + suffix)
					.replaceAll(ChatColor.DARK_GRAY + "", prefix + "8" + suffix).replaceAll(ChatColor.BLUE + "", prefix + "9" + suffix)
					.replaceAll(ChatColor.GREEN + "", prefix + "a" + suffix).replaceAll(ChatColor.AQUA + "", prefix + "b" + suffix)
					.replaceAll(ChatColor.RED + "", prefix + "c" + suffix).replaceAll(ChatColor.LIGHT_PURPLE + "", prefix + "d" + suffix)
					.replaceAll(ChatColor.YELLOW + "", prefix + "e" + suffix).replaceAll(ChatColor.WHITE + "", prefix + "f" + suffix)
					.replaceAll(ChatColor.STRIKETHROUGH + "", prefix + "m" + suffix).replaceAll(ChatColor.UNDERLINE + "", prefix + "n" + suffix)
					.replaceAll(ChatColor.BOLD + "", prefix + "l" + suffix).replaceAll(ChatColor.MAGIC + "", prefix + "k" + suffix)
					.replaceAll(ChatColor.ITALIC + "", prefix + "o" + suffix).replaceAll(ChatColor.RESET + "", prefix + "r" + suffix)
.replaceAll("\n", prefix + "z" + suffix);}
		return res;}

}