package de.emptyWorld.main;


import de.emptyWorld.main.poitions.glowing;
import de.emptyWorld.main.poitions.confusion;
import java.util.ArrayList;
import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Difficulty;
import org.bukkit.Effect;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.WorldType;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.Scoreboard;
import de.emptyWorld.main.enchants.lootBonusBlock;
import de.emptyWorld.main.enchants.lotBonusMob;
import de.emptyWorld.main.enchants.luck;
import de.emptyWorld.main.enchants.lure;
import de.emptyWorld.main.enchants.mending;
import de.emptyWorld.main.enchants.oxygen;
import de.emptyWorld.main.enchants.waterwalker;
import de.emptyWorld.main.enchants.armor;
import de.emptyWorld.main.homes;
import de.emptyWorld.main.fly;
import de.emptyWorld.main.destroyworld;
import de.emptyWorld.main.poitions.nightvision;
import de.emptyWorld.main.poitions.removepoition;
import de.emptyWorld.main.poitions.damageresi;
import de.emptyWorld.main.poitions.fastdigging; 
import de.emptyWorld.main.poitions.fireresi;
import de.emptyWorld.main.poitions.absorption;
import de.emptyWorld.main.loadworld;
import de.emptyWorld.main.reload;
import de.emptyWorld.main.rename;
import de.emptyWorld.main.unloadworld;
import de.emptyWorld.main.world;
import de.emptyWorld.main.worlds;
import de.emptyWorld.main.worldcheck;
import de.emptyWorld.main.einstellungen;
import de.emptyWorld.main.warps;
import de.emptyWorld.main.motd;
import de.emptyWorld.main.giveitem;
import de.emptyWorld.main.warplist;
import de.emptyWorld.main.warpset;
import de.emptyWorld.main.worldlist;
import de.emptyWorld.main.delwarp;
import de.emptyWorld.main.showpermissions;
import de.emptyWorld.main.repair;
import de.emptyWorld.main.teleportxyz;
import de.emptyWorld.main.homepage;
import de.emptyWorld.main.colorChat;
import de.emptyWorld.main.dayset;
import de.emptyWorld.main.groupset;
import de.emptyWorld.main.playerWorlds;
import de.emptyWorld.main.bans;
import de.emptyWorld.main.peng;
import de.emptyWorld.main.enchants.frostwalker;
import de.emptyWorld.main.enchants.arrowdamage;
import de.emptyWorld.main.enchants.arrowfire;
import de.emptyWorld.main.enchants.arrowinfinite;
import de.emptyWorld.main.enchants.arrowknockback;
import de.emptyWorld.main.enchants.damagearthropod;
import de.emptyWorld.main.enchants.damageundead;
import de.emptyWorld.main.enchants.knockback;
import de.emptyWorld.main.enchants.damageall;
import de.emptyWorld.main.enchants.damagedeathstrider;
import de.emptyWorld.main.enchants.digspeed; 
import de.emptyWorld.main.enchants.durability;
import de.emptyWorld.main.enchants.attackspeed;
import de.emptyWorld.main.enchants.attackdamage;
import de.emptyWorld.main.enchants.atackkspeedanddamage;
import de.emptyWorld.main.enchants.armorattribut;
import de.emptyWorld.main.enchants.toughness;
import de.emptyWorld.main.enchants.cheastArmorToughness;
import de.emptyWorld.main.enchants.helmetArmorToughness;
import de.emptyWorld.main.enchants.legArmorToughness;
import de.emptyWorld.main.enchants.bootsArmorToughness;


public class leerWelt  extends JavaPlugin  implements Listener
{
	Scoreboard board;
	
	
	
	  einstellungen settings = einstellungen.getInstance();
	  FileConfiguration data; 
	  FileConfiguration wdata; 
	  FileConfiguration pdata; 
	  FileConfiguration dedata; 
	  FileConfiguration endata;
	  FileConfiguration permdata;
	  FileConfiguration sysodata;
	  
	   private static Logger log = Logger.getLogger("ZauschCraft");
  File dfile;
  File wfile;
  File pfile;
  File de;
  File en;
  File perm;
  File syso; 
 
  World world;
  

  List<String> wl = new ArrayList<String>();
  List<String> wll = new ArrayList<String>();
  List<String> wlu = new ArrayList<String>();
  
  
  
	  public void onDisable()
	  {
	    PluginDescriptionFile desc = getDescription();
	    
	    log.info(desc.getName() + " " + desc.getVersion() + "  " + " Wird ausgeschaltet!");
	    

	}


	  

	  
	  
  public void onEnable()

  {		 
	      
	  
	
	  	InitComs();
	
	    this.data = getConfig();
	    this.wdata = getConfig();
	    this.pdata = getConfig();
	    this.dedata = getConfig();
	    this.endata = getConfig();
	    this.permdata = getConfig();
	    this.sysodata = getConfig();	 
	    this.pdata.options().copyDefaults(true);
	    this.wdata.options().copyDefaults(true);
	    this.data.options().copyDefaults(true);
	    this.dedata.options().copyDefaults(true);
	    this.endata.options().copyDefaults(true);
	    this.permdata.options().copyDefaults(true);
	    this.sysodata.options().copyDefaults(true);
	    this.settings.setup(this);
	    this.saveConfig();
	    saveConfig();	    
	    getConfig().options().copyDefaults(true);  
	    this.getConfig().options().copyDefaults(true);
	    getServer().getPluginManager().registerEvents(this, this);  
	    getServer().getPluginManager().registerEvents(new de.emptyWorld.main.bans(), this);
	    reloadConfig();
		  this.settings.reloadData();
		  this.settings.reloaddeData();
		  this.settings.reloadenData();
		  this.settings.reloadwData();
		  this.settings.reloadpData();
		  this.settings.reloadpermData();
		  this.settings.reloadsysoData();


     
    PluginDescriptionFile pla = getDescription();
   
    log.info(pla.getName() + " " + pla.getVersion() + " " + "https://www.spigotmc.org/resources/multiworldsystem-create-world-cleanroom.51764/" + " ist aktiviert!");}











public void InitComs() {
	getCommand("lootbonusblock").setExecutor(new lootBonusBlock(this));	
	getCommand("lootbonusMob").setExecutor(new lotBonusMob(this));	
	getCommand("luck").setExecutor(new luck(this));	
	getCommand("lure").setExecutor(new lure(this));	
	getCommand("mending").setExecutor(new mending(this));	
	getCommand("oxygen").setExecutor(new oxygen(this));	
	getCommand("waterwalker").setExecutor(new waterwalker(this));	
	  getCommand("frostwalker").setExecutor(new frostwalker(this));	
	  getCommand("peng").setExecutor(new peng(this));
	  getCommand("glowing").setExecutor(new glowing(this));
	  getCommand("confusion").setExecutor(new confusion(this));	
	  getCommand("absorption").setExecutor(new absorption(this));	
	  getCommand("athelm+").setExecutor(new helmetArmorToughness(this));
	  getCommand("atleg+").setExecutor(new legArmorToughness(this));
	  getCommand("atboots+").setExecutor(new bootsArmorToughness(this));
	  getCommand("atchest+").setExecutor(new cheastArmorToughness(this));
	  getCommand("tough+").setExecutor(new toughness(this));
	  getCommand("armor+").setExecutor(new armorattribut(this));
	  getCommand("spdm+").setExecutor(new atackkspeedanddamage(this));
	  getCommand("speed+").setExecutor(new attackspeed(this));
	  getCommand("attack+").setExecutor(new attackdamage(this));
	  getCommand("durability").setExecutor(new durability(this));
	  getCommand("digspeed").setExecutor(new digspeed(this));
	  getCommand("wtp").setExecutor(new world(this));
	  getCommand("wdelete").setExecutor(new destroyworld(this));
	  getCommand("wunload").setExecutor(new unloadworld(this));
	  getCommand("wload").setExecutor(new loadworld(this));	
	  getCommand("wren").setExecutor(new rename(this));
	  getCommand("wstats").setExecutor(new worldcheck(this));
	  getCommand("warplist").setExecutor(new warplist(this));
	  getCommand("mwsr").setExecutor(new reload(this));
	  getCommand("shome").setExecutor(new homes(this));
	  getCommand("dhome").setExecutor(new homes(this));
	  getCommand("home").setExecutor(new homes(this));
	  getCommand("tophome").setExecutor(new homes(this));
	  getCommand("sspawn").setExecutor(new warps(this));
	  getCommand("spawn").setExecutor(new warps(this));
	  getCommand("swarp").setExecutor(new warpset(this));
	  getCommand("w").setExecutor(new warps(this));
	  getCommand("f").setExecutor(new fly(this));
	  getCommand("dwarp").setExecutor(new delwarp(this));
	  getCommand("mwshelp").setExecutor(new customcreates(this));
	  getCommand("mwshelp1").setExecutor(new customcreates(this));
	  getCommand("mwshelp2").setExecutor(new customcreates(this));
	  getCommand("mwshelp3").setExecutor(new customcreates(this));
	  getCommand("mwshelp4").setExecutor(new customcreates(this));
	  getCommand("mwshelp5").setExecutor(new customcreates(this));
	  getCommand("mwshelp6").setExecutor(new customcreates(this));
	  getCommand("mwshelp7").setExecutor(new customcreates(this));
	  getCommand("mwshelp8").setExecutor(new customcreates(this));
	  getCommand("mwshelp9").setExecutor(new customcreates(this));
	  getCommand("mwshelpDe1").setExecutor(new customcreates(this));
	  getCommand("mwshelpDe2").setExecutor(new customcreates(this));
	  getCommand("mwshelpDe3").setExecutor(new customcreates(this));
	  getCommand("mwshelpDe4").setExecutor(new customcreates(this));
	  getCommand("mwshelpDe5").setExecutor(new customcreates(this));
	  getCommand("mwshelpDe6").setExecutor(new customcreates(this));
	  getCommand("mwshelpDe7").setExecutor(new customcreates(this));
	  getCommand("mwshelpDe8").setExecutor(new customcreates(this));
	  getCommand("mwshelpDe9").setExecutor(new customcreates(this)); 	 
	  getCommand("mwsenchant").setExecutor(new customcreates(this));
	  getCommand("mwsenchant1").setExecutor(new customcreates(this));
	  getCommand("mwsenchant2").setExecutor(new customcreates(this));
	  getCommand("mwsenchant3").setExecutor(new customcreates(this));
	  getCommand("mwspoition").setExecutor(new customcreates(this));
	  getCommand("smotd").setExecutor(new motd(this));
	  getCommand("sysmotd").setExecutor(new motd(this));
	  getCommand("motdl1").setExecutor(new motd(this));
	  getCommand("motdl2").setExecutor(new motd(this));
	  getCommand("motdl3").setExecutor(new motd(this));
	  getCommand("motdl4").setExecutor(new motd(this));
	  getCommand("motdl5").setExecutor(new motd(this));
	  getCommand("wlist").setExecutor(new worlds(this));
	  getCommand("gi").setExecutor(new giveitem(this));
	  getCommand("wlistall").setExecutor(new worldlist(this));
	  getCommand("permlist").setExecutor(new showpermissions(this));
	  getCommand("mwsrepair").setExecutor(new repair(this));
	  getCommand("hub").setExecutor(new homes(this));
	  getCommand("discord").setExecutor(new homepage(this));
	  getCommand("homepage").setExecutor(new homepage(this));
	  getCommand("sdiscord").setExecutor(new homepage(this));
	  getCommand("shomepage").setExecutor(new homepage(this));
	  getCommand("xyz").setExecutor(new teleportxyz(this));	  
	  getCommand("chatcolor").setExecutor(new colorChat(this));
	  getCommand("day").setExecutor(new dayset(this));
	  getCommand("night").setExecutor(new dayset(this));
	  getCommand("gset").setExecutor(new groupset(this));
	  getCommand("cpworld").setExecutor(new playerWorlds(this));
	  getCommand("owbuilder+").setExecutor(new playerWorlds(this));
	  getCommand("kick").setExecutor(new bans(this));
	  getCommand("nightvision").setExecutor(new nightvision(this));
	  getCommand("poitionremove").setExecutor(new removepoition(this));
	  getCommand("damageresi").setExecutor(new damageresi(this));
	  getCommand("digging").setExecutor(new fastdigging(this));
	  getCommand("fireresi").setExecutor(new fireresi(this));
	  getCommand("fireaspect").setExecutor(new armor(this));
	  getCommand("arrowdamage").setExecutor(new arrowdamage(this));	 
	  getCommand("arrowfire").setExecutor(new arrowfire(this));
	  getCommand("arrowinfinite").setExecutor(new arrowinfinite(this));
	  getCommand("arrowknockback").setExecutor(new arrowknockback(this));
	  getCommand("arthropode").setExecutor(new damagearthropod(this));
	  getCommand("undead").setExecutor(new damageundead(this));
	  getCommand("knockback").setExecutor(new knockback(this));
	  getCommand("damageall").setExecutor(new damageall(this));
	  getCommand("depthstrider").setExecutor(new damagedeathstrider(this));

	 
} 

  public leerWelt() {}
  ConsoleCommandSender console = Bukkit.getConsoleSender();
  public ChunkGenerator getDefaultWorldGenerator(String worldName, String id)
  {
    return new AirWorldGenerator();
  }
  
 
	  @EventHandler
	  public void PlayerJoin(PlayerLoginEvent event) {
		  Player p = event.getPlayer();
		  p.setGameMode(GameMode.SURVIVAL);
  }
	  
	  
	    	
	  
  @EventHandler
  public void onJoin(PlayerJoinEvent e) {
	 
	  Player p = e.getPlayer();
	  p.setGameMode(GameMode.SURVIVAL); 
	  
  
  String motd = (String) this.settings.getsysoData().get("Motd"); 
  motd = motd.replaceAll("&", "Â§");  
  p.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("MOTDS")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + motd + " " + ChatColor.GOLD.toString() + p.getDisplayName());
  String l1 = ((String)this.settings.getsysoData().get("Line1"));
  l1 = l1.replaceAll("&", "Â§");
  p.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("MOTDS")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + l1 );
  String l2 = ((String)this.settings.getsysoData().get("Line2"));
  l2 = l2.replaceAll("&", "Â§");
  p.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("MOTDS"))+ ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + l2 );
  String l3 = ((String)this.settings.getsysoData().get("Line3"));
  l3 = l3.replaceAll("&", "Â§");
  p.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("MOTDS")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + l3 );
  String l4 = ((String)this.settings.getsysoData().get("Line4"));
  l4 = l4.replaceAll("&", "Â§");
  p.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("MOTDS")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + l4);
  String l5 = ((String)this.settings.getsysoData().get("Line5"));
  l5 = l5.replaceAll("&", "Â§");
  p.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("MOTDS")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + l5 );
 
  }

  
  String Line0 = getConfig().getString("Line0");
  String PermissionCreate = getConfig().getString("mwssigncreate");
  String PermissionDestroy = getConfig().getString("mwssigndel");
  String SetLine0Command = getConfig().getString("SetLine0Command");
  String PermissionUse = getConfig().getString("mwssignuse");
  String invalidline1 = getConfig().getString("invalidline1");
  String invalidline2 = getConfig().getString("invalidline2");
  String invalidline3 = getConfig().getString("invalidline3");
  String invalidLinePlayer = getConfig().getString("invalidLinePlayer");
  String MissingPermissonUse = getConfig().getString("MissingPermissonUse");
  String MissingPermissionCreateLine1 = getConfig().getString("MisPermCrLi1");
  String MissingPermissionCreateLine2 = getConfig().getString("MisPermCrLi2");
  String MissingPermissionCreateLine3 = getConfig().getString("MisPermCrLi3");
  String MissingPermissionCreateLine4 = getConfig().getString("MisPermCrLi4");
  String MissingPermissionCreatePlayer = getConfig().getString("MissingPermCrPl");
  String MissingPermissionDestoyPlayer = getConfig().getString("MissingPermnDelPl");
 	 

	@EventHandler	
		public void onPlayerChatEvent(AsyncPlayerChatEvent ew)
		{
		  
		  
		  String worldName = ew.getPlayer().getWorld().getName();
		  
		  List<Player> recipients = new LinkedList<Player>();
		  
		  for (Player recipient : org.bukkit.Bukkit.getServer().getOnlinePlayers()) {
		    if (recipient.getWorld().getName().equals(worldName)) {
		    	
		    	console.sendMessage(ChatColor.GREEN + recipient.getWorld().getName());
		      recipients.add(recipient);
		    } else {		    
		    	console.sendMessage(ChatColor.GREEN + recipient.getWorld().getName());
		    }
		  }
		  
		  ew.getRecipients().addAll(recipients);
		}
		

	
  @org.bukkit.event.EventHandler
  public void OnSignChange(SignChangeEvent event) {
    Player p = event.getPlayer();   
    {
      if (!p.hasPermission(PermissionCreate)) {
        if (event.getLine(0).equalsIgnoreCase(Line0)) {event.setLine(0, ChatColor.translateAlternateColorCodes('&', SetLine0Command));
          if (event.getLine(1).isEmpty()) {
            event.setLine(0, invalidline1);
            event.setLine(1, invalidline2);
            event.setLine(2, invalidline3);
            p.sendMessage(invalidLinePlayer);
          { 
            event.setLine(3, ChatColor.translateAlternateColorCodes('&',"&2" + event.getPlayer().getDisplayName()));
          }
        }  if (p.hasPermission(PermissionCreate)) {
        event.setLine(0, MissingPermissionCreateLine1);
        event.setLine(1, MissingPermissionCreateLine2);
        event.setLine(2, MissingPermissionCreateLine3);
        event.setLine(3, MissingPermissionCreateLine4);
        p.sendMessage(MissingPermissionCreatePlayer);
      }
    }  if
      (event.getLine(0).equalsIgnoreCase(Line0)) {
      event.setLine(0, ChatColor.translateAlternateColorCodes('&', SetLine0Command));
      if (event.getLine(1).isEmpty()) {
        event.setLine(0, invalidline1);
        event.setLine(1, invalidline2);
        event.setLine(2, invalidline3);
        p.sendMessage(invalidLinePlayer);
      } 
        event.setLine(3, ChatColor.translateAlternateColorCodes('&', "&2" + event.getPlayer().getDisplayName()));
      }
    }
  }}
  
  @org.bukkit.event.EventHandler
  public void OnPlayerInteractSign(PlayerInteractEvent event) {
    if (((event.getAction() == org.bukkit.event.block.Action.RIGHT_CLICK_BLOCK) && 
      (event.getClickedBlock().getType() == Material.WALL_SIGN)) || 
      ((event.getAction() == org.bukkit.event.block.Action.RIGHT_CLICK_BLOCK) && 
      (event.getClickedBlock().getType() == Material.SIGN_POST)) || (
      (event.getAction() == org.bukkit.event.block.Action.RIGHT_CLICK_BLOCK) && 
      (event.getClickedBlock().getType() == Material.SIGN))) {
      Player player = event.getPlayer();
      Sign sign = (Sign)event.getClickedBlock().getState();      
        if ((player.hasPermission(PermissionUse))) 
        {

          if (sign.getLine(0).equals(ChatColor.translateAlternateColorCodes('&', SetLine0Command))) {
            player.performCommand(sign.getLine(1) + " " + 
            sign.getLine(2) + " " + sign.getLine(3));
            
            return; } } 
          player.performCommand(sign.getLine(1) + " " + sign.getLine(2));

          {
         if (!player.hasPermission(PermissionUse)) {
          player.sendMessage((String)this.settings.getsysoData().get("permErrorSigns"));
        {
        if ((sign.getLine(0).equals(ChatColor.translateAlternateColorCodes('&', SetLine0Command))))
          {
          player.performCommand(sign.getLine(1) + " " + sign.getLine(2) + " " + sign.getLine(3));
      {
          player.performCommand( sign.getLine(1) + " " + sign.getLine(2));}}}}}}
    
  }
  
  @org.bukkit.event.EventHandler
  public void onBlockBreak(BlockBreakEvent event)
  {
    Player player = event.getPlayer();
    if (((event.getBlock().getType() == Material.WALL_SIGN) || 
      (event.getBlock().getType() == Material.SIGN_POST) || 
      (event.getBlock().getType() == Material.SIGN)) && 
      (player.hasPermission(PermissionDestroy))) {
      Sign sign = (Sign)event.getBlock().getState();
      if (sign.getLine(0) != Line0)
        return;      
      {

        if (ChatColor.stripColor(sign.getLine(3).replaceFirst(" ", "").replaceFirst("&2", "").trim()).equalsIgnoreCase(player.getDisplayName().trim()))
        	
        	return;
      }
      event.setCancelled(true);
      reloadConfig();      
      event.getPlayer().sendMessage(MissingPermissionDestoyPlayer);
    }
  }
  
  
  @EventHandler(priority=EventPriority.HIGHEST)
  public void onSignChange(SignChangeEvent e)
  {
  Player p = e.getPlayer(); 
  if ((p.isOp()) || (p.hasPermission((String)this.settings.getpermData().get("mwsChatColorSet")))) 
  {
  String line0 = e.getLine(0);
  String line1 = e.getLine(1);
  String line2 = e.getLine(2);
  String line3 = e.getLine(3);
  e.setLine(0, ChatColor.translateAlternateColorCodes('&', line0));
  e.setLine(1, ChatColor.translateAlternateColorCodes('&', line1));
  e.setLine(2, ChatColor.translateAlternateColorCodes('&', line2));
  e.setLine(3, ChatColor.translateAlternateColorCodes('&', line3));}}
  
  @EventHandler(priority=EventPriority.HIGHEST)
  public void onChat(AsyncPlayerChatEvent e)
  {
  Player p = e.getPlayer(); 
  if ((p.isOp()) || (p.hasPermission((String)this.settings.getpermData().get("mwsChatColorSet")))) // Wenn der Player Op oder die Permission "lobby.chatcolor" besitzt darf er diesen Befehl (/color) ausführen .
  {
  String msg = e.getMessage();
  e.setMessage(ChatColor.translateAlternateColorCodes('&', msg)); // Dafür das es so aus gegeben wird wie es oben angezeigt wird .
  }
  }

		






public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
  {

    Player p = (Player)sender; 
   
    
    if (cmd.getName().equalsIgnoreCase("ewca"))
    {
      if (!sender.hasPermission((String)this.settings.getpermData().get("mwsewca")))
      {
        sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >"  + ChatColor.BLUE + ((String)this.settings.getpermData().get("mwsewca")) + " " +  ((String)this.settings.getsysoData().get("permError")));
        p.getWorld().playEffect(p.getLocation(), Effect.GHAST_SHRIEK, 50);
        return false;
      }
      Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "mv create " + ((String)this.settings.getsysoData().get("mvEWGautoCreateName")) + " " + ((String)this.settings.getsysoData().get("mvEWGautoCreateType")) + " " + "-g MultiWorldSystem");
      sender.sendMessage(ChatColor.GREEN + ((String)this.settings.getsysoData().get("mvEWGautoCreateMessage")));
      if (((String)this.settings.getsysoData().get("SpawnParticle")) == "true")
      {
        p.getWorld().playEffect(p.getLocation(), Effect.GHAST_SHRIEK, 50);
        return true;
      }
    }
    if (cmd.getName().equalsIgnoreCase("block"))
    {
      if (!sender.hasPermission((String)this.settings.getpermData().get("mwsblock")))
      {
        sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + ((String)this.settings.getpermData().get("mwsblock")) + " " + ChatColor.BLUE + ((String)this.settings.getsysoData().get("permError")));
        p.getWorld().playEffect(p.getLocation(), Effect.GHAST_SHRIEK, 50);
        return false;
      }
      Bukkit.dispatchCommand(p, "setblock ~ ~ ~ stone variant=granite");
      sender.sendMessage(ChatColor.GREEN + ((String)this.settings.getsysoData().get("mwSetBlock")));
      
      return true;
    }
    
    if (cmd.getName().equalsIgnoreCase("ewua"))
    {
      if (!sender.hasPermission((String)this.settings.getpermData().get("mwsewua")))
      {
        sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + ChatColor.BLUE + ((String)this.settings.getpermData().get("mwsewua")));
        p.getWorld().playEffect(p.getLocation(), Effect.GHAST_SHRIEK, 50);
        return false;
      }
      Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "mv unload " + ((String)this.settings.getpermData().get("mvEWGautoCreateName")));
      
      return true;
    }
    if (cmd.getName().equalsIgnoreCase("ewra"))
    {
      if (!sender.hasPermission((String)this.settings.getpermData().get("mwsewra")))
      {
        sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + ChatColor.BLUE + ((String)this.settings.getpermData().get("mwsewra")));
        p.getWorld().playEffect(p.getLocation(), Effect.GHAST_SHRIEK, 50);
        return false;
      }
      Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "mv remove " + ((String)this.settings.getsysoData().get("mvEWGautoCreateName")));
      
      return true;
    }
    if (cmd.getName().equalsIgnoreCase("ewda"))
    {
      if (!sender.hasPermission((String)this.settings.getpermData().get("mwsewda")))
      {
        sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + ChatColor.BLUE + ((String)this.settings.getpermData().get("mwsewda")));
        p.getWorld().playEffect(p.getLocation(), Effect.GHAST_SHRIEK, 50);
        return false;
      }
      Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "mv delete " + ((String)this.settings.getsysoData().get("mvEWGautoCreateName")));
      Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "mvconfirm");
      
      return true;
    }
    if (cmd.getName().equalsIgnoreCase("g1"))
    {
      if (!sender.hasPermission((String)this.settings.getpermData().get("mwsgm1")))
      {
        sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + ChatColor.BLUE + ((String)this.settings.getpermData().get("mwsgm1")) + " " + ((String)this.settings.getsysoData().get("permError")));
        p.getWorld().playEffect(p.getLocation(), Effect.GHAST_SHRIEK, 50);
        
        return false;
      }
      if(args.length >= 0){
      p.setGameMode(GameMode.CREATIVE);
      p.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + ChatColor.BLUE + ((String)this.settings.getsysoData().get("gamemodeChange")));
      return true;
    } else {
    	p.setGameMode(GameMode.CREATIVE);
        p.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + ChatColor.BLUE + ((String)this.settings.getsysoData().get("gamemodeChange")));
  }}
    if (cmd.getName().equalsIgnoreCase("g0"))
    {
      if (!sender.hasPermission((String)this.settings.getpermData().get("mwsgm0")))
      {
        sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + ChatColor.BLUE + ((String)this.settings.getpermData().get("mwsgm0")) + " " + ((String)this.settings.getsysoData().get("permError")));
        p.getWorld().playEffect(p.getLocation(), Effect.GHAST_SHRIEK, 50);
        return false;
      }if(args.length >= 0){
      p.setGameMode(GameMode.SURVIVAL);
      p.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + ChatColor.BLUE + ((String)this.settings.getsysoData().get("gamemodeChange")));
      return true;
    }else {
    	p.setGameMode(GameMode.CREATIVE);
        p.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + ChatColor.BLUE + ((String)this.settings.getsysoData().get("gamemodeChange")));
    }}
        if (cmd.getName().equalsIgnoreCase("g2"))
    {
      if (!sender.hasPermission((String)this.settings.getpermData().get("mwsgm2")))
      {
        sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + ChatColor.BLUE + ((String)this.settings.getpermData().get("mwsgm2")) + " " + ((String)this.settings.getsysoData().get("permError")));
        p.getWorld().playEffect(p.getLocation(), Effect.GHAST_SHRIEK, 50);
        return false;
      }if(args.length >= 0){
      p.setGameMode(GameMode.SPECTATOR);      
      p.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + ChatColor.BLUE + ((String)this.settings.getsysoData().get("gamemodeChange")));
      return true;
    }else {
    	p.setGameMode(GameMode.CREATIVE);
        p.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + ChatColor.BLUE + ((String)this.settings.getsysoData().get("gamemodeChange")));
    }}
    if (cmd.getName().equalsIgnoreCase("cinv"))
    {
      if (!sender.hasPermission((String)this.settings.getpermData().get("mwsinvcl")))
      {
        sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + ChatColor.BLUE + ((String)this.settings.getpermData().get("mwsinvcl")) + " " + ((String)this.settings.getsysoData().get("permError")));
        p.getWorld().playEffect(p.getLocation(), Effect.GHAST_SHRIEK, 50);
        return false;
      }if(args.length >= 0){
      PlayerInventory inventory = p.getInventory();
      inventory.clear();
      sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + ChatColor.BLUE + ((String)this.settings.getsysoData().get("InvetoryCleanMessage") + p.getName()));
      p.getWorld().playEffect(p.getLocation(), Effect.GHAST_SHRIEK, 50);
        return true;
      }  }
    
    if (cmd.getName().equalsIgnoreCase("walk"))
    {
        if (!sender.hasPermission((String)this.settings.getpermData().get("mwswalk")))
        {
          sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + ChatColor.BLUE + ((String)this.settings.getpermData().get("mwswalk")) + " " + ((String)this.settings.getsysoData().get("permError")));
          p.getWorld().playEffect(p.getLocation(), Effect.GHAST_SHRIEK, 50);
          return false;
        }
        if (args.length >= 0)
        { 
      try
      {
        float speed = Float.parseFloat(args[0]) / 100.0F;
        if (speed > 1.0F) {
          speed = 1.0F;
        }
        if (speed < 0.0F) {
          speed = 0.0F;
        }
        p.setWalkSpeed(speed);
        p.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.BLUE + ((String)this.settings.getsysoData().get("PlaySpeedWalkSet1")));
      }
      catch (Exception e)
      {
        p.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.RED + ((String)this.settings.getsysoData().get("WalkPlayerCmd1")));
        
        return true;}}
       
  }    

    
  
    if (cmd.getName().equalsIgnoreCase("cflat"))
    {
      if (!sender.hasPermission((String)this.settings.getpermData().get("mwsfcreate")))
      {
        sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + ChatColor.BLUE + ((String)this.settings.getpermData().get("mwsfcreate")) + " " + ((String)this.settings.getsysoData().get("permError")));
        p.getWorld().playEffect(p.getLocation(), Effect.GHAST_SHRIEK, 50);
        return false;
      }
      if (args.length == 1)

      {
   	     sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " Â»" + ChatColor.BLUE + ((String)this.settings.getsysoData().get("CreateWait")));    	  
      WorldCreator b = new WorldCreator(args[0]).generateStructures(false);
      b.type(WorldType.FLAT);
      this.world = b.createWorld();      
      this.world.setSpawnFlags(false, false);
      this.world.setPVP(false);      
      this.world.setAmbientSpawnLimit(0);
      this.world.setMonsterSpawnLimit(0);
      this.world.setAnimalSpawnLimit(0);
      this.world.setStorm(false);
      this.world.setThundering(false);
      this.world.setKeepSpawnInMemory(false);
      this.world.setTicksPerAnimalSpawns(0);
      this.world.setTicksPerMonsterSpawns(0);
      this.world.setWaterAnimalSpawnLimit(0);
      this.world.setWeatherDuration(0);
      this.world.setAutoSave(true);
      this.world.setGameRuleValue("doFireTick", "false");
      this.world.setTime(6000L);
      this.settings.getwData().set("worlds." + args[0] + ".=="  , ((String)this.settings.getsysoData().get("SystemName")));
      this.settings.getwData().set("worlds." + args[0] + ".type", "FLATâ€‹");
      this.settings.getwData().set("worlds." + args[0] + ".environment", "NORMAL");
      this.settings.getwData().set("worlds." + args[0] + ".pvp", "false");
      this.settings.getwData().set("worlds." + args[0] + ".difficulty", "NORMAL");
      this.settings.getwData().set("worlds." + args[0] + ".seed", "");
      this.settings.getwData().set("worlds." + args[0] + ".generate-structures", "false");
      this.settings.getwData().set("worlds." + args[0] + ".spawn-animals", "false");
      this.settings.getwData().set("worlds." + args[0] + ".spawn-monsters", "false"); 
      this.settings.getwData().set("worlds." + args[0] + ".setSpawnFlags", "false" + "false");
      this.settings.getwData().set("worlds." + args[0] + ".setStorm", "false");
      this.settings.getwData().set("worlds." + args[0] + ".setThundering", "false");
      this.settings.getwData().set("worlds." + args[0] + ".setKeepSpawnInMemory", "false");
      this.settings.getwData().set("worlds." + args[0] + ".setTicksPerAnimalSpawns", "0");
      this.settings.getwData().set("worlds." + args[0] + ".setTicksPerMonsterSpawns", "0");
      this.settings.getwData().set("worlds." + args[0] + ".setWaterAnimalSpawnLimit", "0");
      this.settings.getwData().set("worlds." + args[0] + ".setGameRuleValue", "doFireTick" + "false");
      this.settings.getwData().set("worlds." + args[0] + ".setWeatherDuration", "0");
      this.settings.getwData().set("worlds." + args[0] + ".setAutoSave", "true");
      this.settings.getwData().set("worlds." + args[0] + ".setTime", "6000L");
      this.settings.getwData().set("worlds." + args[0] + ".setSpawnLocation", "150" + "0" + "150");
      this.settings.savewData();    
      wll.add(args[0]);	
      b.generateStructures(false);
      b.generateStructures(false);getCommand("cflat");
      World world = p.getWorld();
      Location loc = p.getLocation();
      world.setSpawnLocation(loc.getBlockX(), loc.getBlockY() + 1, loc.getBlockZ());
      this.settings.getData().set("warps." + args[0] + ".world", args[0]);
      this.settings.getData().set("warps." + args[0] + ".x", Double.valueOf(loc.getBlockX()));
      this.settings.getData().set("warps." + args[0] + ".y", Double.valueOf(loc.getBlockY()));
      this.settings.getData().set("warps." + args[0] + ".z", Double.valueOf(loc.getBlockZ()));
      this.settings.saveData();
      Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "mv import " + args[0] + " " + ((String)this.settings.getsysoData().get("mvEWGautoCreateType")));
      sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.BLUE + ((String)this.settings.getsysoData().get("Folder")) + " " + args[0] + " " + ((String)this.settings.getsysoData().get("foldercreate")));
      sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " Â»" + ChatColor.BLUE + ((String)this.settings.getsysoData().get("Warpcreate")) + " " + ChatColor.GOLD + args[0]);
      return true;
    }
    if (args.length == 0)

    {
  	  sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " Â»" + ChatColor.BLUE + ((String)this.settings.getsysoData().get("mwErrorWName")));
  	  
  	return false;
    }}
    if (cmd.getName().equalsIgnoreCase("clb"))
    {
      if (!sender.hasPermission((String)this.settings.getpermData().get("mwslbcreate")))
      {
        sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + ChatColor.BLUE + ((String)this.settings.getpermData().get("mwslbcreate")) + " " + ((String)this.settings.getsysoData().get("permError")));
        p.getWorld().playEffect(p.getLocation(), Effect.GHAST_SHRIEK, 50);
        return false;
      }
      if (args.length == 1)

      {
  	     sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " Â»" + ChatColor.BLUE + ((String)this.settings.getsysoData().get("CreateWait")));   	  
      WorldCreator b = new WorldCreator(args[0]);
      b.type(WorldType.LARGE_BIOMES);
      this.world = b.createWorld();
      this.world.setSpawnFlags(true, true);
      this.world.setPVP(isEnabled());
      this.world.setStorm(true);
      this.world.setThundering(true);
      this.world.setKeepSpawnInMemory(true);
      this.world.setTicksPerAnimalSpawns(5);
      this.world.setTicksPerMonsterSpawns(5);
      this.world.setWaterAnimalSpawnLimit(0);
      this.world.setWeatherDuration(2147483647);
      this.world.setAutoSave(true);
      this.world.setTime(6000L);
      this.world.setGameRuleValue("doDaylightCycle", "true");
      this.world.setDifficulty(Difficulty.NORMAL);
      this.world.setSpawnLocation(150, 0, 150);
      this.world.setGameRuleValue("doMobSpawning", "true");
      this.world.setGameRuleValue("mobGriefing", "true");
      this.world.setGameRuleValue("doFireTick", "true");
      this.world.setGameRuleValue("showDeathMessages", "true");
      this.settings.getwData().set("worlds." + args[0] + ".=="  , ((String)this.settings.getsysoData().get("SystemName")));
      this.settings.getwData().set("worlds." + args[0] + ".type", "LARGE_BIOMESâ€‹" + "'");
      this.settings.getwData().set("worlds." + args[0] + ".environment", "NORMAL");
      this.settings.getwData().set("worlds." + args[0] + ".seed", "");
      this.settings.getwData().set("worlds." + args[0] + ".pvp", "true");
      this.settings.getwData().set("worlds." + args[0] + ".difficulty", "NORMAL");      
      this.settings.getwData().set("worlds." + args[0] + ".generate-structures", "true");
      this.settings.getwData().set("worlds." + args[0] + ".spawn-animals", "true");
      this.settings.getwData().set("worlds." + args[0] + ".spawn-monsters", "true");
      this.settings.getwData().set("worlds." + args[0] + ".setSpawnFlags", "true" + "true");
      this.settings.getwData().set("worlds." + args[0] + ".setStorm", "true");
      this.settings.getwData().set("worlds." + args[0] + ".setThundering", "true");
      this.settings.getwData().set("worlds." + args[0] + ".setKeepSpawnInMemory", "true");
      this.settings.getwData().set("worlds." + args[0] + ".setTicksPerAnimalSpawns", "5");
      this.settings.getwData().set("worlds." + args[0] + ".setTicksPerMonsterSpawns", "5");
      this.settings.getwData().set("worlds." + args[0] + ".setWaterAnimalSpawnLimit", "0");
      this.settings.getwData().set("worlds." + args[0] + ".setGameRuleValue", "mobGriefing" + "true");
      this.settings.getwData().set("worlds." + args[0] + ".setGameRuleValue", "doDaylightCycle" + "true");
      this.settings.getwData().set("worlds." + args[0] + ".setGameRuleValue", "doMobSpawning" + "true");
      this.settings.getwData().set("worlds." + args[0] + ".setGameRuleValue", "doFireTick" + "true");
      this.settings.getwData().set("worlds." + args[0] + ".setGameRuleValue", "showDeathMessages" + "true");
      this.settings.getwData().set("worlds." + args[0] + ".setWeatherDuration", "2147483647");
      this.settings.getwData().set("worlds." + args[0] + ".setAutoSave", "true");
      this.settings.getwData().set("worlds." + args[0] + ".setTime", "6000L");
      this.settings.getwData().set("worlds." + args[0] + ".setSpawnLocation", "150" + "0" + "150");
      this.settings.savewData();
      wll.add(args[0]);	
      b.generateStructures(true);
      b.generateStructures(true);getCommand("clb");
      World world = p.getWorld();
      Location loc = p.getLocation();
      world.setSpawnLocation(loc.getBlockX(), loc.getBlockY() + 1, loc.getBlockZ());
      this.settings.getData().set("warps." + args[0] + ".world", args[0]);
      this.settings.getData().set("warps." + args[0] + ".x", Double.valueOf(loc.getBlockX()));
      this.settings.getData().set("warps." + args[0] + ".y", Double.valueOf(loc.getBlockY()));
      this.settings.getData().set("warps." + args[0] + ".z", Double.valueOf(loc.getBlockZ()));
      this.settings.saveData();
      Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "mv import " + args[0] + " " + ((String)this.settings.getsysoData().get("mvEWGautoCreateType")));
      sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.BLUE + "World & folder" + " " + args[0] + " " + "create");
      sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " Â»" + ChatColor.BLUE + ((String)this.settings.getsysoData().get("Warpcreate")) + " " + ChatColor.GOLD + args[0]);
      return true;
    }
    if (args.length == 0)

    {
  	  sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " Â»" + ChatColor.BLUE + ((String)this.settings.getsysoData().get("mwErrorWName")));
  	  
  	return false;
    }}
    if (cmd.getName().equalsIgnoreCase("cnormal"))
    {
      if (!sender.hasPermission((String)this.settings.getpermData().get("mwsncreate")))
      {
        sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + ChatColor.BLUE + ((String)this.settings.getpermData().get("mwsncreate")) + " " + ((String)this.settings.getsysoData().get("permError")));
        p.getWorld().playEffect(p.getLocation(), Effect.GHAST_SHRIEK, 50);
        return false;
      }
      if (args.length == 1)

      {
	     sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " Â»" + ChatColor.BLUE + ((String)this.settings.getsysoData().get("CreateWait")));   	  
      WorldCreator b = new WorldCreator(args[0]);
      b.type(WorldType.NORMAL);
      b.generateStructures(true);
      b.generateStructures(true);getCommand("cnormal");
      this.world = b.createWorld();
      this.settings.getwData().set("worlds." + args[0] + ".type", "NORMALâ€‹");
      this.settings.getwData().set("worlds." + args[0] + ".environment", "NORMAL");
      this.settings.getwData().set("worlds." + args[0] + ".pvp", "true");
      this.settings.getwData().set("worlds." + args[0] + ".difficulty", "NORMAL");
      this.settings.getwData().set("worlds." + args[0] + ".seed", "");
      this.settings.getwData().set("worlds." + args[0] + ".generate-structures", "true");
      this.settings.getwData().set("worlds." + args[0] + ".spawn-animals", "true");
      this.settings.getwData().set("worlds." + args[0] + ".spawn-monsters", "true");
      this.settings.savewData();      
      wll.add(args[0]);	
      World world = p.getWorld();
      Location loc = p.getLocation();
      world.setSpawnLocation(loc.getBlockX(), loc.getBlockY() + 1, loc.getBlockZ());
      this.settings.getData().set("warps." + args[0] + ".world", args[0]);
      this.settings.getData().set("warps." + args[0] + ".x", Double.valueOf(loc.getBlockX()));
      this.settings.getData().set("warps." + args[0] + ".y", Double.valueOf(loc.getBlockY()));
      this.settings.getData().set("warps." + args[0] + ".z", Double.valueOf(loc.getBlockZ()));
      this.settings.saveData();
      Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "mv import " + args[0] + " " + ((String)this.settings.getsysoData().get("mvEWGautoCreateType")));
      sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.BLUE + "World & folder" + " " + args[0] + " " + "create");
      sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " Â»" + ChatColor.BLUE + ((String)this.settings.getsysoData().get("Warpcreate")) + " " + ChatColor.GOLD + args[0]);
      return true;
    }
    if (args.length == 0)

    {
  	  sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " Â»" + ChatColor.BLUE + ((String)this.settings.getsysoData().get("mwErrorWName")));
  	  
  	return false;
    }}
    if (cmd.getName().equalsIgnoreCase("camp"))
    {
      if (!sender.hasPermission((String)this.settings.getpermData().get("mwsampcreate")))
      {
        sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + ChatColor.BLUE + ((String)this.settings.getpermData().get("mwsampcreate")) + " " + ((String)this.settings.getsysoData().get("permError")));
        p.getWorld().playEffect(p.getLocation(), Effect.GHAST_SHRIEK, 50);
        return false;
      }
      if (args.length == 1)

      {
	     sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " Â»" + ChatColor.BLUE + ((String)this.settings.getsysoData().get("CreateWait")));
      WorldCreator b = new WorldCreator(args[0]);
      b.type(WorldType.AMPLIFIED);
      b.generateStructures(true);
      b.generateStructures(true);getCommand("camp");
      this.world = b.createWorld();
      this.settings.getwData().set("worlds." + args[0] + ".type", "AMPLIFIEDâ€‹");
      this.settings.getwData().set("worlds." + args[0] + ".environment", "NORMAL");
      this.settings.getwData().set("worlds." + args[0] + ".pvp", "true");
      this.settings.getwData().set("worlds." + args[0] + ".difficulty", "NORMAL");
      this.settings.getwData().set("worlds." + args[0] + ".seed", "");
      this.settings.getwData().set("worlds." + args[0] + ".generate-structures", "true");
      this.settings.getwData().set("worlds." + args[0] + ".spawn-animals", "true");
      this.settings.getwData().set("worlds." + args[0] + ".spawn-monsters", "true");
      this.settings.savewData();
      wll.add(args[0]);	
      World world = p.getWorld();
      Location loc = p.getLocation();
      world.setSpawnLocation(loc.getBlockX(), loc.getBlockY() + 1, loc.getBlockZ());
      this.settings.getData().set("warps." + args[0] + ".world", args[0]);
      this.settings.getData().set("warps." + args[0] + ".x", Double.valueOf(loc.getBlockX()));
      this.settings.getData().set("warps." + args[0] + ".y", Double.valueOf(loc.getBlockY()));
      this.settings.getData().set("warps." + args[0] + ".z", Double.valueOf(loc.getBlockZ()));
      this.settings.saveData();
      Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "mv import " + args[0] + " " + ((String)this.settings.getsysoData().get("mvEWGautoCreateType")));
      sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.BLUE + "World & folder" + " " + args[0] + " " + "create");
      sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " Â»" + ChatColor.BLUE + ((String)this.settings.getsysoData().get("Warpcreate")) + " " + ChatColor.GOLD + args[0]);
      return true;
    }
  
  if (args.length == 0)

  {
	  sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " Â»" + ChatColor.BLUE + ((String)this.settings.getsysoData().get("mwErrorWName")));
	  
	return false;
  }}
    Location loc;
    if (cmd.getName().equalsIgnoreCase("cv1"))
    {
      if (!sender.hasPermission((String)this.settings.getpermData().get("mwsv1create")))
      {
        sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + ChatColor.BLUE + ((String)this.settings.getpermData().get("mwsv1create")) + " " + ((String)this.settings.getsysoData().get("permError")));
        p.getWorld().playEffect(p.getLocation(), Effect.GHAST_SHRIEK, 50);
        return false;
      }
      if (args.length == 1)
      {
    	     sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " Â»" + ChatColor.BLUE + ((String)this.settings.getsysoData().get("CreateWait")));
      WorldCreator b = new WorldCreator(args[0]);
      b.type(WorldType.VERSION_1_1);
      b.generateStructures(true);
      b.generateStructures(true);getCommand("cv1");
      this.world = b.createWorld();
      loc = p.getLocation();
      this.settings.getwData().set("worlds." + args[0] + ".type", "VERSION_1_1â€‹");
      this.settings.getwData().set("worlds." + args[0] + ".environment", "NORMAL");
      this.settings.getwData().set("worlds." + args[0] + ".pvp", "true");
      this.settings.getwData().set("worlds." + args[0] + ".difficulty", "NORMAL");
      this.settings.getwData().set("worlds." + args[0] + ".seed", "");
      this.settings.getwData().set("worlds." + args[0] + ".generate-structures", "true");
      this.settings.getwData().set("worlds." + args[0] + ".spawn-animals", "true");
      this.settings.getwData().set("worlds." + args[0] + ".spawn-monsters", "true");
      this.settings.savewData();     
      wll.add(args[0]);	
      this.world.setSpawnLocation(loc.getBlockX(), loc.getBlockY() + 1, loc.getBlockZ());
      this.settings.getData().set("warps." + args[0] + ".world", args[0]);
      this.settings.getData().set("warps." + args[0] + ".x", Double.valueOf(loc.getBlockX()));
      this.settings.getData().set("warps." + args[0] + ".y", Double.valueOf(loc.getBlockY()));
      this.settings.getData().set("warps." + args[0] + ".z", Double.valueOf(loc.getBlockZ()));
      this.settings.saveData();
      Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "mv import " + args[0] + " " + ((String)this.settings.getsysoData().get("mvEWGautoCreateType")));
      sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.BLUE + ((String)this.settings.getsysoData().get("Folder")) + " " + args[0] + " " + ((String)this.settings.getsysoData().get("foldercreate")));
      sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " Â»" + ChatColor.BLUE + ((String)this.settings.getsysoData().get("Warpcreate")) + " " + ChatColor.GOLD + args[0]);
      return true;
    }   
    
    if (args.length == 0)
  
    {
  	  sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " Â»" + ChatColor.BLUE + ((String)this.settings.getsysoData().get("mwErrorWName")));
  	  
  	return false;
    }}    
    
    if (cmd.getName().equalsIgnoreCase("csky"))
    {
      if (!sender.hasPermission((String)this.settings.getpermData().get("mwsskycreate")))
      {
        sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + ChatColor.BLUE + ((String)this.settings.getpermData().get("mwsskycreate")) + " " + ((String)this.settings.getsysoData().get("permError")));
        p.getWorld().playEffect(p.getLocation(), Effect.GHAST_SHRIEK, 50);
        return false;
      }
      if (args.length == 1)
      {
     sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " Â»" + ChatColor.BLUE + ((String)this.settings.getsysoData().get("CreateWait")));
      WorldCreator b = new WorldCreator(args[0]);
      b.type(WorldType.FLAT).generatorSettings("3;minecraft:air;2").generateStructures(false);
      b.generateStructures(false);getCommand("csky");       
      this.world = b.createWorld();
      this.world.setSpawnFlags(false, false);
      this.world.setPVP(false);
      this.world.setStorm(false);
      this.world.setThundering(false);
      this.world.setKeepSpawnInMemory(false);
      this.world.setTicksPerAnimalSpawns(0);
      this.world.setTicksPerMonsterSpawns(0);
      this.world.setWaterAnimalSpawnLimit(0);
      this.world.setWeatherDuration(0);
      this.world.setTime(6000L);
      this.world.setGameRuleValue("doDaylightCycle", "false");
      this.world.setDifficulty(Difficulty.EASY);
      this.world.setGameRuleValue("doMobSpawning", "false");
      this.world.setGameRuleValue("mobGriefing", "false");
      this.world.setGameRuleValue("doFireTick", "false");
      this.world.setGameRuleValue("showDeathMessages", "true");
      this.world.setGameRuleValue("doMobLoot", "true");
      this.world.setGameRuleValue("keepInventory", "true");
      this.world.setGameRuleValue("naturalRegeneration", "false");
      this.world.setGameRuleValue("randomTickSpeed", "0");
      this.world.setSpawnLocation(0, 64, 0);
      this.world.setAutoSave(true);
      this.world.save();
      loc = new Location(this.world, 0.0D, 64.0D, 0.0D);
      this.world = loc.getWorld();
      loc.setX(loc.getX() + 0);
      loc.setY(loc.getY() - 1);
      loc.setZ(loc.getZ() + 0);
      Block bl = this.world.getBlockAt(loc);
      bl.setType(Material.GLOWSTONE);
      this.settings.getwData().set("worlds." + args[0] + ".=="  , ((String)this.settings.getsysoData().get("SystemName")));
      this.settings.getwData().set("worlds." + args[0] + ".type", "flat");
      this.settings.getwData().set("worlds." + args[0] + ".environment", "NORMAL");
      this.settings.getwData().set("worlds." + args[0] + ".pvp", "false");
      this.settings.getwData().set("worlds." + args[0] + ".difficulty", "NORMAL");
      this.settings.getwData().set("worlds." + args[0] + ".seed", "");
      this.settings.getwData().set("worlds." + args[0] + ".generate-structures", "false");
      this.settings.getwData().set("worlds." + args[0] + ".spawn-animals", "false");
      this.settings.getwData().set("worlds." + args[0] + ".spawn-monsters", "false");
      this.settings.savewData();      
      this.settings.getData().set("warps." + args[0] + ".world", args[0]);
      this.settings.getData().set("warps." + args[0] + ".x", Double.valueOf(loc.getBlockX()));
      this.settings.getData().set("warps." + args[0] + ".y", Double.valueOf(loc.getBlockY()));
      this.settings.getData().set("warps." + args[0] + ".z", Double.valueOf(loc.getBlockZ()));
      this.settings.saveData();
      wll.add(args[0]);	
      sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " Â»" + ChatColor.BLUE + ((String)this.settings.getsysoData().get("Warpcreate")) + " " + ChatColor.GOLD + args[0]);            
      return true;
    }
      if (args.length == 0)
    
      {
    	  sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " Â»" + ChatColor.BLUE + ((String)this.settings.getsysoData().get("mwscerrorName")));
    	  
    	return false;
      }}
	 if (cmd.getName().equalsIgnoreCase("world")){					
		for(Player player : Bukkit.getOnlinePlayers())
		{ sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.BLUE + player.getWorld().getName() + " <<====>> " + ChatColor.GOLD + player.getName());
		 return true;}
		}
	    if (cmd.getName().equalsIgnoreCase("fs"))
	    {
	        if (!sender.hasPermission((String)this.settings.getpermData().get("mwsfs")))
	        {
	          sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + ChatColor.BLUE + ((String)this.settings.getpermData().get("mwsfs")) + " " + ((String)this.settings.getsysoData().get("permError")));
	          p.getWorld().playEffect(p.getLocation(), Effect.GHAST_SHRIEK, 50);
	          return false;
	        }
	        if (args.length >= 0)
	        {
	      try
	      {
	        float speed = Float.parseFloat(args[0]) / 100.0F;
	        if (speed > 1.0F) {
	          speed = 1.0F;
	        }
	        if (speed < 0.0F) {
	          speed = 0.0F;
	        }
	        p.setFlySpeed(speed);
	        p.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD + ((String)this.settings.getsysoData().get("PlaySpeedSet1")));
	        }
	      catch (Exception e)
	      {
	        p.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.RED + ChatColor.GOLD + ((String)this.settings.getsysoData().get("FlyPlayerCmd1")));
	        
	        return true;
	      }
	      }
		}

	    if (cmd.getName().equalsIgnoreCase("shub"))
	    {
	      if (!sender.hasPermission((String)this.settings.getpermData().get("mwshubs")))
	      {
	    	  sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + ChatColor.BLUE + ((String)this.settings.getpermData().get("mwshubs")) + " " + ChatColor.GREEN + ((String)this.settings.getsysoData().get("permError")));
	        p.getWorld().playEffect(p.getLocation(), Effect.GHAST_SHRIEK, 50);
	        return false;
	      }
	      this.settings.getData().set("hub.world", p.getLocation().getWorld().getName());
	      this.settings.getData().set("hub.x", Double.valueOf(p.getLocation().getX()));
	      this.settings.getData().set("hub.y", Double.valueOf(p.getLocation().getY()));
	      this.settings.getData().set("hub.z", Double.valueOf(p.getLocation().getZ()));
	      this.settings.saveData();
	      sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + ChatColor.BLUE + ((String)this.settings.getsysoData().get("Hubset")));
	      return true;
	    }

   

  
  if (cmd.getName().equalsIgnoreCase("heal"))  {
	    if (!sender.hasPermission((String)this.settings.getpermData().get("mwsheal")))
	    {
	  	  sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + ChatColor.BLUE + ((String)this.settings.getpermData().get("mwsheal")) + " " + ChatColor.GREEN + ((String)this.settings.getsysoData().get("permError")));
	      p.getWorld().playEffect(p.getLocation(), Effect.GHAST_SHRIEK, 50);
	      return false;}
         if (args.length >= 0) {        
                  p.setHealth(20.0);
                  p.setFoodLevel(20);
                  p.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.BLUE + ChatColor.BOLD + " >" + ChatColor.GREEN.toString() + ((String)this.settings.getsysoData().get("Healmsg")) + ChatColor.GOLD + p.getName() + "!");
                  
                  return true;        }}
       
  if (cmd.getName().equalsIgnoreCase("to")) {
	    if (!sender.hasPermission((String)this.settings.getpermData().get("mwstpto")))
	    {
	  	  sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + ChatColor.BLUE + ((String)this.settings.getpermData().get("mwstpto")) + " " + ChatColor.GREEN + ((String)this.settings.getsysoData().get("permError")));
	      p.getWorld().playEffect(p.getLocation(), Effect.GHAST_SHRIEK, 50);
	      return false;}
      if (args.length == 0) {
              p.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + " " + ChatColor.BLUE + ((String)this.settings.getsysoData().get("tptoError")));
              return true;
      }
      Player target = Bukkit.getServer().getPlayer(args[0]);
      if (target == null) {
              p.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + " " + ChatColor.BLUE + ((String)this.settings.getsysoData().get("tptoError")) + " " + args[0] + " " +"!");
             
              return true;
      }
      p.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + " " + ChatColor.BLUE + ((String)this.settings.getsysoData().get("tptoInfo")) + args[0] + "!");
      p.teleport(target.getLocation());
      return true;
}
  
  
  if (cmd.getName().equalsIgnoreCase("tome")) {
	    if (!sender.hasPermission((String)this.settings.getpermData().get("mwstptome")))
	    {
	  	  sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + ChatColor.BLUE + ((String)this.settings.getpermData().get("mwstptome")) + " " + ChatColor.GREEN + ((String)this.settings.getsysoData().get("permError")));
	      p.getWorld().playEffect(p.getLocation(), Effect.GHAST_SHRIEK, 50);
	      return false;}
      if (args.length == 0) {
              p.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + ((String)this.settings.getsysoData().get("tpmeError")));
              return true;
      }
      Player target = Bukkit.getServer().getPlayer(args[0]);
      if (target == null) {
              p.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + " " + ((String)this.settings.getsysoData().get("tpmeError")) + args[0] + "!");
              return true;
      }
      if (args.length > 0) {
      target.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + " " + ChatColor.BLUE + ((String)this.settings.getsysoData().get("tpmeInfo")) + args[0] + "!");
      target.teleport(p.getLocation());
      return true;}} 
  if (cmd.getName().equalsIgnoreCase("wclear")) {
	  Player player = (Player) sender;
	  World world = p.getWorld();
      if (!player.hasPermission((String)this.settings.getpermData().get("mwsweatherclear"))) {
    	  player.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + ChatColor.BLUE + ((String)this.settings.getpermData().get("mwsweatherclear")) + " " + ChatColor.GREEN + ((String)this.settings.getsysoData().get("permError")));
          return false;
      }
      world.setStorm(false);

      world.setThundering(false);

      Command.broadcastCommandMessage(sender, ((String)this.settings.getsysoData().get("weatherclear")));
      return true;}
  
  
  if (cmd.getName().equalsIgnoreCase("rain")) {
	  Player player = (Player) sender;
	  World world = p.getWorld();
      if (!player.hasPermission((String)this.settings.getpermData().get("mwsrain"))) {
    	  player.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + ChatColor.BLUE + ((String)this.settings.getpermData().get("mwsrain")) + " " + ChatColor.GREEN + ((String)this.settings.getsysoData().get("permError")));
          return false;
      }
      world.setStorm(true);

      world.setThundering(false);

      Command.broadcastCommandMessage(sender, ((String)this.settings.getsysoData().get("weatherrain")));
      return true;}
  
  if (cmd.getName().equalsIgnoreCase("storm")) {
	  Player player = (Player) sender;
	  World world = p.getWorld();
      if (!player.hasPermission((String)this.settings.getpermData().get("mwsstorm"))) {
    	  player.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + ChatColor.BLUE + ((String)this.settings.getpermData().get("mwsstorm")) + " " + ChatColor.GREEN + ((String)this.settings.getsysoData().get("permError")));
          return false;
      }
      world.setStorm(true);

      world.setThundering(true);

      Command.broadcastCommandMessage(sender, ((String)this.settings.getsysoData().get("weatherstorm")));
      return true;
      }
  		
		return false;}}


  	
  	
  		
 

	  







