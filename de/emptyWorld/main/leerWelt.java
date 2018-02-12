package de.emptyWorld.main;

import java.util.logging.Logger;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityTargetEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import de.emptyWorld.main.commands.stormset;
import de.emptyWorld.main.commands.rainset;
import de.emptyWorld.main.commands.killmobs;
import de.emptyWorld.main.signshop.pshop;
import de.emptyWorld.main.commands.creeperexplodeblocker;
import de.emptyWorld.main.commands.HelpCommand;
import de.emptyWorld.main.signshop.cmd_shop;
import de.emptyWorld.main.commands.back;
import de.emptyWorld.main.poitions.jump;
import de.emptyWorld.main.poitions.levitation;
import de.emptyWorld.main.poitions.speed;
import net.milkbowl.vault.chat.Chat;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.economy.EconomyResponse;
import de.emptyWorld.main.poitions.regeneration;
import de.emptyWorld.main.poitions.poison;
import de.emptyWorld.main.poitions.invisibility;
import de.emptyWorld.main.enchants.waterbreathing;
import de.emptyWorld.main.poitions.glowing;
import de.emptyWorld.main.poitions.confusion;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import org.bukkit.Bukkit;
import org.bukkit.Difficulty;
import org.bukkit.Effect;
import org.bukkit.EntityEffect;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.WorldType;
import org.bukkit.block.Block;
import org.bukkit.block.PistonMoveReaction;
import org.bukkit.block.Sign;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Creeper;
import org.bukkit.event.EventPriority;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerTeleportEvent.TeleportCause;
import org.bukkit.event.weather.ThunderChangeEvent;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.generator.ChunkGenerator;
import org.bukkit.help.HelpTopic;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.permissions.PermissionAttachmentInfo;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.util.Vector;
import de.emptyWorld.main.Updatechecker;
import de.emptyWorld.main.pex.permGoupWorld;
import de.emptyWorld.main.pex.permslist;
import de.emptyWorld.main.pex.groupperms;
import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
import de.emptyWorld.main.pex.permGroup;
import de.emptyWorld.main.pex.defaultGroupset;
import de.emptyWorld.main.pex.permPlayer;
import de.emptyWorld.main.pex.permPlayerWorld;
import de.emptyWorld.main.enchants.lootBonusBlock;
import de.emptyWorld.main.enchants.lotBonusMob;
import de.emptyWorld.main.enchants.luck;
import de.emptyWorld.main.enchants.lure;
import de.emptyWorld.main.enchants.mending;
import de.emptyWorld.main.enchants.oxygen;
import de.emptyWorld.main.enchants.waterwalker;
import de.emptyWorld.main.listeners.InventoryClickListener;
import de.emptyWorld.main.objects.FakeCommandRegister;
import de.emptyWorld.main.objects.FakeCommandRegistry;
import de.emptyWorld.main.objects.GuiItem;
import de.emptyWorld.main.objects.SetHelpMap;
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
import de.emptyWorld.main.repair;
import de.emptyWorld.main.teleportxyz;
import de.emptyWorld.main.homepage;
import de.emptyWorld.main.colorChat;
import de.emptyWorld.main.dayset;
import de.emptyWorld.main.groupset;
import de.emptyWorld.main.playerWorlds;
import de.emptyWorld.main.bans;
import de.emptyWorld.main.peng;
import de.emptyWorld.main.bank.ChestBank;
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
import de.emptyWorld.main.commands.possave;
import de.emptyWorld.main.commands.posload;
import de.emptyWorld.main.Gui.GuiItemLoader;


@SuppressWarnings({ "unchecked", "rawtypes" })
public class leerWelt extends JavaPlugin implements Listener, Entity
{ 


	
	  private boolean display = false;
	    private static int SCALE = 30;
	    
	    @EventHandler(priority=EventPriority.HIGHEST)
	    public void onWeatherChange(WeatherChangeEvent event) {
	    	boolean sstorm = (getConfig().getBoolean("rain"));
	        boolean rain = event.toWeatherState();
	        if(rain)
	            event.setCancelled(sstorm);
	    }
	 
	    @EventHandler(priority=EventPriority.HIGHEST)
	    public void onThunderChange(ThunderChangeEvent event) {
	     boolean sstorm = (getConfig().getBoolean("thunder"));
	        boolean storm = event.toThunderState();
	        if(storm)
	            event.setCancelled(sstorm);	        
	    }
	   
	static leerWelt plugin = (leerWelt) Bukkit.getServer().getPluginManager().getPlugin("MultiWorldSystem");
    @EventHandler
    public void onEntityExplode(EntityExplodeEvent event) {
  	  boolean ntrue = (getConfig().getBoolean("creeper"));
        if (event.getEntity() instanceof Creeper){
        float explosionPower = 0F;
        event.setCancelled(ntrue);
        event.getLocation().getWorld().createExplosion(event.getLocation(), explosionPower);
        }}
	public static Inventory inv = null;
	public static Economy econ = null;
	public static Permission permission = null;
	public static Economy economy = null;
	public static Chat chat = null;
	  
	  String prefix = "[Shop]";	  
	  Inventory shopList = org.bukkit.Bukkit.createInventory(null, 54, ChatColor.GREEN + "Shop Items");

	  private boolean setupEconomy() {
		   if (!getServer().getPluginManager().getPlugin("Vault").isEnabled())
		    {
		      log.severe(this.prefix + "Fe is not found in this server!");
		      return false;
		    }
		    log.info(this.prefix + "Fe found in this server!");
		    
	    RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
	    if (rsp == null) {
	      return false;
	    }
	    econ = (Economy)rsp.getProvider();
	    
	    return econ != null;
	  }
	    

	  
	 private static HashMap<Player, Inventory> playerBank = new HashMap<Player, Inventory>();
	 private static HashMap<Player, Inventory> playerBank2 = new HashMap<Player, Inventory>();
	 private static HashMap<Player, Inventory> playerShop2 = new HashMap<Player, Inventory>();
	
	  einstellungen settings = einstellungen.getInstance();
	  FileConfiguration data; 
	  FileConfiguration wdata; 
	  FileConfiguration pdata; 
	  FileConfiguration dedata; 
	  FileConfiguration endata;
	  FileConfiguration permdata;
	  FileConfiguration sysodata;
	  FileConfiguration cpdata;
	  FileConfiguration bdata;
	  FileConfiguration b2data;
	  FileConfiguration sdata;
	   public static Logger log = Logger.getLogger("ZauschCraft");
  File dfile;
  File wfile;
  File pfile;
  File de;
  File en;
  File perm;
  File syso;
  File cp;
  File b;
  File b2;
  File s;
  World world;
  
  
  List<String> wl = new ArrayList<String>();
  List<String> wll = new ArrayList<String>();
  List<String> wlu = new ArrayList<String>();

  
  
	  public void onDisable()
	  {
	    PluginDescriptionFile desc = getDescription();
	    
	    log.info(desc.getName() + " " + desc.getVersion() + "  " + " Wird ausgeschaltet!");
	    this.saveConfig();
	
	}


	  
	  
	  
	  
  public void onEnable()

  {		 
	  getServer().getPluginManager().registerEvents(new InventoryClickListener(this), this);
	  PluginDescriptionFile pla = getDescription();
	   
	    log.info(pla.getName() + " " + pla.getVersion() + " " + "https://www.spigotmc.org/resources/multiworldsystem-create-world-cleanroom.51764/" + " ist aktiviert!");
	  
	  plugin = this;		
	
		reloadConfig(); 
		
	
	  	InitComs();
	  	this.sdata = getConfig();
	  	this.b2data = getConfig();
	  	this.bdata = getConfig();
	    this.data = getConfig();
	    this.wdata = getConfig();
	    this.pdata = getConfig();
	    this.dedata = getConfig();
	    this.endata = getConfig();
	    this.permdata = getConfig();
	    this.sysodata = getConfig();
	    this.cpdata = getConfig();
	    this.sdata.options().copyDefaults(true);
	    this.b2data.options().copyDefaults(true);
	    this.bdata.options().copyDefaults(true);
	    this.pdata.options().copyDefaults(true);
	    this.wdata.options().copyDefaults(true);
	    this.data.options().copyDefaults(true);
	    this.dedata.options().copyDefaults(true);
	    this.endata.options().copyDefaults(true);
	    this.permdata.options().copyDefaults(true);
	    this.sysodata.options().copyDefaults(true);
	    this.cpdata.options().copyDefaults(true);
	    this.settings.setup(this);
	    this.settings.savesData();
	    this.settings.savebData();
	    this.settings.savecpData();
	    this.settings.saveData();
	    this.settings.savedeData();
	    this.settings.saveenData();
	    this.settings.savepermData();
	    this.settings.savesysoData();
	    this.settings.savewData();
	    this.settings.savepData();
	    this.settings.savebData();
	    this.settings.saveb2Data();	   
	    saveResource("enchant.yml", true);
	    saveResource("en.yml", true);
	    saveResource("de.yml", true);
	    saveResource("SystemOut.yml", true);
	    saveResource("permsList.yml", true);	    
	    saveResource("config.yml", true);	
	    saveResource("permcommands.yml", true);	
	    this.saveConfig();
	    saveConfig();	    
	    getConfig().options().copyDefaults(true);
	    this.getConfig().options().copyDefaults(true);
	    getServer().getPluginManager().registerEvents(this, this);  
	    getServer().getPluginManager().registerEvents(new de.emptyWorld.main.bans(), this);
	    getServer().getPluginManager().registerEvents(new de.emptyWorld.main.signshop.Shop(this), this);
	    getServer().getPluginManager().registerEvents(new cmd_shop(this), this);
	    Bukkit.getServer().getPluginManager().registerEvents(new creeperexplodeblocker(), this);	
	    	reloadConfig();
		  this.settings.reloaddeData();
		  this.settings.reloadenData();
		  this.settings.reloadpData();
		  this.settings.reloadpermData();
		  this.settings.reloadsysoData();
		  this.settings.reloadcpData();	
		  this.settings.reloadbData();	
		  this.settings.reloadb2Data();	
		  org.bukkit.plugin.PluginManager pm = org.bukkit.Bukkit.getPluginManager();
		  getServer().getPluginManager().registerEvents(new creeperexplodeblocker(), this);
		  pm.registerEvents(this, this); 
		  checkUpdate();
		  
		  try {
	           FakeCommandRegister.registerFakeCommand(new FakeCommandRegistry(this, "permission.to.command", "cmdname", "Command Description", "Usage Message", Arrays.asList("List","Of","Aliases")), this);
       } catch (NoSuchMethodException | SecurityException
               | IllegalAccessException | IllegalArgumentException
               | InvocationTargetException e) {
           e.printStackTrace();
       }{ 
   	    gui = Bukkit.createInventory(null, getConfig().getInt("GuiRows") * 9, ChatColor.translateAlternateColorCodes('&', getConfig().getString("GuiName")));
   	    new GuiItemLoader(getConfig(), items);
   	    command = getConfig().getString("GuiOpeningCommand");
   	    try {
   	      new FakeCommandRegister(new FakeCommandRegistry(this, "commandgui.viewgui", command, "Open CommandGui", 
   	        "Usage: /" + command, new ArrayList()), this);
   	    }
   	    catch (NoSuchMethodException|SecurityException|IllegalAccessException|IllegalArgumentException|InvocationTargetException eg)
   	    {
   	      eg.printStackTrace();
   	    }
   	    
   	    for (GuiItem i : items) {
   	      gui.setItem(i.getItemSlot(), i.getItem());
   	    }
   	    try {
   	      SetHelpMap.setHelpMapVersionIndep(new HelpTopic[] {new HelpTopic()
   	      {
   	        public String getName()
   	        {
   	          return "CommandGui";
   	        }
   	        
   	        public String getShortText()
   	        {
   	          return "Find the list of commands for Command Gui.";
   	        }
   	        
   	        public String getFullText(CommandSender sender)
   	        {
   	        	if (sender instanceof ConsoleCommandSender) 
   	            return ChatColor.DARK_GREEN + "Use /" + command + " to open Command Gui";
   	          if ((sender instanceof ConsoleCommandSender)) return "Unfortunately, you cannot open CommandGui from console.";
   	          return "To open Command Gui for a player type /" + command + " <playername>";   	     
   	        }
   	        public boolean canSee(CommandSender s) {
   	          return true;
   	        }
   	        
   	      } });}
   	    
   	    catch (NoSuchFieldException|SecurityException|IllegalArgumentException|IllegalAccessException|ClassNotFoundException|InvocationTargetException|NoSuchMethodException|InstantiationException eg)
   	    {
   	      eg.printStackTrace();
   	    } 
		  
   	 if (!setupEconomy())
     {
   	 log.severe(String.format("[%s] Disabled due to no Vault dependency found!", new Object[] { getDescription().getName() }));
     getServer().getPluginManager().disablePlugin(this);
     return;
       }
   if ((this.settings.getsData().get("shop_price") == null) && (this.settings.getsData().get("upgrade_price") == null))
   {
     this.settings.getsData().set("shop_price", Integer.valueOf(2500));
     this.settings.getsData().set("upgrade_price", Integer.valueOf(500));
     this.settings.savesData();
   }
   if (this.settings.getsData().get("lastTradeID") == null)
   {
     this.settings.getsData().set("lastTradeID", Integer.valueOf(0));
     this.settings.savesData();
   }
  log.info(this.prefix + "Enabled successfully!");}
 }

		    
		    
		


		
   
  





  public WorldGuardPlugin getWorldGuard()
  {
    Plugin wplugin = getServer().getPluginManager().getPlugin("WorldGuard");
    if ((wplugin == null) || (!(wplugin instanceof WorldGuardPlugin))) {
      return null;
    }
    return (WorldGuardPlugin)wplugin;
  }




public void InitComs() {
	getCommand("rainset").setExecutor(new rainset(this));
	getCommand("stormset").setExecutor(new stormset(this));
	getCommand("mwscommands").setExecutor(new HelpCommand(this));
	getCommand("mwsupdate").setExecutor(new Updatechecker(this));
	getCommand("creeper").setExecutor(new creeperexplodeblocker(this));
	getCommand("mwsshoptp").setExecutor(new pshop(this));
	getCommand("mwsdelshoptp").setExecutor(new pshop(this));
	getCommand("mwssetshoptp").setExecutor(new pshop(this));
	getCommand("possave").setExecutor(new possave(this));
	getCommand("posload").setExecutor(new posload(this));
	getCommand("back").setExecutor(new back(this));
	getCommand("killmob").setExecutor(new killmobs(this));
	getCommand("breath").setExecutor(new waterbreathing(this));
	getCommand("speed").setExecutor(new speed(this));
	getCommand("regeneration").setExecutor(new regeneration(this));
	getCommand("levitation").setExecutor(new levitation(this));
	getCommand("jump").setExecutor(new jump(this));
	getCommand("invisible").setExecutor(new invisibility(this));
	getCommand("poison").setExecutor(new poison(this));
	getCommand("pgw-").setExecutor(new permGoupWorld(this));
	getCommand("pgw+").setExecutor(new permGoupWorld(this));
	getCommand("pg-").setExecutor(new groupperms(this));
	getCommand("pg+").setExecutor(new groupperms(this));
	getCommand("bank").setExecutor(new ChestBank(this));
	getCommand("setbank").setExecutor(new ChestBank(this));	
	getCommand("permsl").setExecutor(new permslist(this));
	getCommand("dgroup+").setExecutor(new defaultGroupset(this));
	getCommand("dgroupw+").setExecutor(new defaultGroupset(this));
	getCommand("group+").setExecutor(new permGroup(this));
	getCommand("group-").setExecutor(new permGroup(this));
	getCommand("ppw-").setExecutor(new permPlayerWorld(this));
	getCommand("ppw+").setExecutor(new permPlayerWorld(this));
	getCommand("pp-").setExecutor(new permPlayer(this));
	getCommand("pp+").setExecutor(new permPlayer(this));
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
	  getCommand("mwsgroups").setExecutor(new customcreates(this));
	  getCommand("mwsgroupsDe").setExecutor(new customcreates(this));
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
	  getCommand("mwshelp10").setExecutor(new customcreates(this));
	  getCommand("mwshelpDe1").setExecutor(new customcreates(this));
	  getCommand("mwshelpDe2").setExecutor(new customcreates(this));
	  getCommand("mwshelpDe3").setExecutor(new customcreates(this));
	  getCommand("mwshelpDe4").setExecutor(new customcreates(this));
	  getCommand("mwshelpDe5").setExecutor(new customcreates(this));
	  getCommand("mwshelpDe6").setExecutor(new customcreates(this));
	  getCommand("mwshelpDe7").setExecutor(new customcreates(this));
	  getCommand("mwshelpDe8").setExecutor(new customcreates(this));
	  getCommand("mwshelpDe9").setExecutor(new customcreates(this)); 	
	  getCommand("mwshelpDe10").setExecutor(new customcreates(this)); 
	  getCommand("mwsenchantDe").setExecutor(new customcreates(this));
	  getCommand("mwsenchantDe1").setExecutor(new customcreates(this));
	  getCommand("mwsenchantDe2").setExecutor(new customcreates(this));
	  getCommand("mwsenchantDe3").setExecutor(new customcreates(this));
	  getCommand("mwspoitionDe").setExecutor(new customcreates(this));
	  getCommand("mwspoitionDe1").setExecutor(new customcreates(this));
	  getCommand("pshelpDe").setExecutor(new customcreates(this));

	  getCommand("mwsenchant").setExecutor(new customcreates(this));
	  getCommand("mwsenchant1").setExecutor(new customcreates(this));
	  getCommand("mwsenchant2").setExecutor(new customcreates(this));
	  getCommand("mwsenchant3").setExecutor(new customcreates(this));
	  getCommand("mwspoition").setExecutor(new customcreates(this));
	  getCommand("mwspoition1").setExecutor(new customcreates(this));
	  getCommand("pshelp").setExecutor(new customcreates(this));
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
	  getCommand("owbuilder-").setExecutor(new playerWorlds(this));
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
	  getCommand("depthstrider").setExecutor(new damagedeathstrider(this));}

private String command;
public void openGui(Player who) { who.openInventory(gui); }

public GuiItem getGuiItem(ItemStack fromclick)
{
  for (GuiItem g : items)
    if (g.getItem().equals(fromclick)) return g;
  return null;
}

  
  
public void reload() {
	  Bukkit.getPluginManager().disablePlugin(plugin);
	  Bukkit.getPluginManager().enablePlugin(plugin);} 

  public leerWelt() {}
  
  ConsoleCommandSender console = Bukkit.getConsoleSender();
  public ChunkGenerator getDefaultWorldGenerator(String worldName, String id)
  {
    return new AirWorldGenerator();
  }
 
  public static HashMap<Player, Inventory> getPlayerBank()
  {
    return playerBank;
  }
  public static HashMap<Player, Inventory> getPlayerBank2()
  {
    return playerBank2;
  }

  public static HashMap<Player, Inventory> getPlayerShop2()
  {
    return playerShop2;
  }
  private ArrayList<GuiItem> items = new ArrayList<GuiItem>();
  
  @EventHandler
  public void onInvClick(InventoryClickEvent e) {
    Player player = (Player)e.getWhoClicked();
    Inventory inventory = e.getInventory();
    if (inventory.getName().equals(shopList.getName())) {
      e.setCancelled(true);
      player.closeInventory();
      shopList.clear();
    }
  }
  
  @EventHandler
  public void onInvClose(InventoryCloseEvent e) {
    Inventory inventory = e.getInventory();
    if (inventory.getName().equals(shopList.getName())) {
      shopList.clear();
    }
  }
  
  public void showHealth(LivingEntity entity) {
	    if (!this.display) {
	        return;
	    }	    
	    @SuppressWarnings("deprecation")
		int maxHealth = (int)entity.getMaxHealth();
	    int currentHealth = (int)entity.getHealth();
	    String entityName = entity.getType().toString();
	    String text = this.makeBarGraph(currentHealth, maxHealth, entityName);
	    entity.setCustomName(text);
	}

	public String makeBarGraph(int x, int y, String prefix) {
	    int i;
	    int percent = (int)((float)x / (float)y * (float)SCALE);
	    StringBuilder output = new StringBuilder(12 + SCALE + prefix.length());
	    output.append((Object)ChatColor.GOLD);
	    output.append(prefix);
	    output.append(" [");
	    output.append((Object)ChatColor.GREEN);
	    if (percent > 0) {
	        for (i = 0; i < percent; ++i) {
	            output.append("|");
	        }
	    }
	    output.append((Object)ChatColor.DARK_GRAY);
	    if (percent < SCALE) {
	        for (i = 0; i < SCALE - percent; ++i) {
	            output.append("|");
	        }
	    }
	    output.append((Object)ChatColor.GOLD);
	    output.append("]");
	    return output.toString();
	}

	@EventHandler
	public void onEntityDamage(EntityDamageEvent event) {
	    if (event.getEntity() instanceof LivingEntity) {
	        LivingEntity entity = (LivingEntity)event.getEntity();
	        this.showHealth(entity);
	    }
	}

	@EventHandler
	public void onEntityTarget(EntityTargetEvent event) {
	    if (event.getEntity() instanceof LivingEntity) {
	        LivingEntity entity = (LivingEntity)event.getEntity();
	        this.showHealth(entity);
	    }
	}
	
  
  @EventHandler
  public void entityDamageEvent(EntityDamageEvent event)
  {
    if (((event.getEntity() instanceof Player)) && (getPlayerBank().containsKey(event.getEntity()))) {
      if (getConfig().getBoolean("PlayerImmuneInBank")) {
        event.setCancelled(true);}}
    if (((event.getEntity() instanceof Player)) && (getPlayerBank2().containsKey(event.getEntity()))) {
        if (getConfig().getBoolean("PlayerImmuneInVipBank")) {
          event.setCancelled(true);}}
    if (((event.getEntity() instanceof Player)) && (getPlayerShop2().containsKey(event.getEntity()))) {
        if (getConfig().getBoolean("PlayerImmuneInShop2")) {
          event.setCancelled(true);}}
      }
	  @EventHandler
	  public void PlayerJoin(PlayerLoginEvent event) {		  
		int b1 = getConfig().getInt("Slots");		  
		  if (!this.settings.getbData().contains(event.getPlayer().getUniqueId().toString())) {
		      for (int slotIndex = 0; slotIndex != b1; slotIndex++)
		      {
		    	  this.settings.getbData().set(event.getPlayer().getUniqueId().toString() + ".item" + slotIndex, new ItemStack(Material.AIR));
		    	  this.settings.savebData();}
		    	  			  
			int b2 = getConfig().getInt("VipSlots");
		      if (!this.settings.getb2Data().contains(event.getPlayer().getUniqueId().toString())) {
			      for (int slotIndex1 = 0; slotIndex1 != b2; slotIndex1++)
			      {
			    	  this.settings.getb2Data().set(event.getPlayer().getUniqueId().toString() + ".item" + slotIndex1, new ItemStack(Material.AIR));
			        
			    	  this.settings.saveb2Data();}
			      
			      int shop2 = getConfig().getInt("ShopSlots");
			      if (!this.settings.getb2Data().contains(event.getPlayer().getUniqueId().toString())) {
				      for (int slotIndex2 = 0; slotIndex2 != shop2; slotIndex2++)
				      {
				    	  this.settings.getb2Data().set(event.getPlayer().getUniqueId().toString() + ".item" + slotIndex2, new ItemStack(Material.AIR));
				        
				    	  this.settings.saveb2Data();}
		      Player p = event.getPlayer();
			  p.setGameMode(GameMode.SURVIVAL);}}}}
  
	    
	  @EventHandler
	  public void inventoryCloseEvent(InventoryCloseEvent event)
	  {
	    if (((event.getPlayer() instanceof Player)) && 
	      (getPlayerBank().containsKey(event.getPlayer())))
	    {
		 int b1 = getConfig().getInt("Slots");
	      Inventory inventory = (Inventory)getPlayerBank().get(event.getPlayer());
	      for (int slotIndex = 0; slotIndex != b1; slotIndex++)
	      {
	        ItemStack itemStack;	        
	        if (inventory.getItem(slotIndex) == null) {
	          itemStack = new ItemStack(Material.AIR);
	        } else {
	          itemStack = new ItemStack(inventory.getItem(slotIndex));
	        }
	        this.settings.getbData().set(event.getPlayer().getUniqueId().toString() + ".item" + slotIndex, itemStack);
	        this.settings.savebData();
	      }
	      ((Player)event.getPlayer()).sendMessage(ChatColor.YELLOW + getConfig().getString("PlayerBankSaveMessageTitel") + ChatColor.AQUA + " " + event.getPlayer().getName() + ChatColor.GOLD + " " + getConfig().getString("PlayerBankSaveMesssageTitel2"));
	      
	      getPlayerBank().remove(event.getPlayer());
	    }
	    if (((event.getPlayer() instanceof Player)) && 
	  	      (getPlayerBank2().containsKey(event.getPlayer())))
	  	    {
			 int b2 = getConfig().getInt("VipSlots");
	  	      Inventory inventory1 = (Inventory)getPlayerBank2().get(event.getPlayer());
	  	      for (int slotIndex1 = 0; slotIndex1 != b2; slotIndex1++)
	  	      {
	  	        ItemStack itemStack1;	        
	  	        if (inventory1.getItem(slotIndex1) == null) {
	  	          itemStack1 = new ItemStack(Material.AIR);
	  	        } else {
	  	          itemStack1 = new ItemStack(inventory1.getItem(slotIndex1));
	  	        }
	  	        this.settings.getb2Data().set(event.getPlayer().getUniqueId().toString() + ".item" + slotIndex1, itemStack1);
	  	        this.settings.saveb2Data();
	  	      }
	  	      ((Player)event.getPlayer()).sendMessage(ChatColor.YELLOW + getConfig().getString("VipBankSaveMessageTitel") + ChatColor.AQUA + " " + event.getPlayer().getName() + ChatColor.GOLD + " " + getConfig().getString("VipBankSaveMesssageTitel2"));
	  	      
	  	      getPlayerBank2().remove(event.getPlayer());
	  	    }
	    if (((event.getPlayer() instanceof Player)) && 
		  	      (getPlayerShop2().containsKey(event.getPlayer())))
		  	    {
				 int shop2 = getConfig().getInt("ShopSlots");
		  	      Inventory inventory2 = (Inventory)getPlayerShop2().get(event.getPlayer());
		  	      for (int slotIndex2 = 0; slotIndex2 != shop2; slotIndex2++)
		  	      {
		  	        ItemStack itemStack2;	        
		  	        if (inventory2.getItem(slotIndex2) == null) {
		  	          itemStack2 = new ItemStack(Material.AIR);
		  	        } else {
		  	          itemStack2 = new ItemStack(inventory2.getItem(slotIndex2));
		  	        }
		  	        this.settings.getb2Data().set(event.getPlayer().getUniqueId().toString() + ".item" + slotIndex2, itemStack2);
		  	        this.settings.saveb2Data();
		  	      }
		  	      ((Player)event.getPlayer()).sendMessage(ChatColor.YELLOW + getConfig().getString("Shop2SaveMessageTitel") + ChatColor.AQUA + " " + event.getPlayer().getName() + ChatColor.GOLD + " " + getConfig().getString("Shop2SaveMesssageTitel2"));
		  	      
		  	      getPlayerShop2().remove(event.getPlayer());
		  	    }
	  }
	 

 	  public static String updater = "MultiWorldSystem";
	  public static int resource = 51764;
	  public void checkUpdate() {
	  	System.out.println(updater + "Checking for updates...");
	  	try {
	              HttpURLConnection con = (HttpURLConnection) new URL(
	                      "http://www.spigotmc.org/api/general.php").openConnection();
	              con.setDoOutput(true);
	              con.setRequestMethod("POST");
	              con.getOutputStream()
	                      .write(("key=98BE0FE67F88AB82B4C197FAF1DC3B69206EFDCC4D3B80FC83A00037510B99B4&resource=" + resource)
	                              .getBytes("UTF-8"));
	              String version = new BufferedReader(new InputStreamReader(con.getInputStream())).readLine();
	              if (!version.equalsIgnoreCase(this.getDescription().getVersion())) {
	                  System.err.println(updater + "A new update is aviable: version " + version);
	              } else {
	              	System.out.println(updater + "You're running the newest plugin version!");
	              }
	          } catch (Exception ex) {
	             System.err.println(updater + "Failed to check for updates on spigotmc.org");
	          }
	  }
  @EventHandler
  public void onJoin(PlayerJoinEvent e) {

	  Player p = e.getPlayer();
	  p.setGameMode(GameMode.SURVIVAL); 

	  
  
  String motd = (String) this.settings.getsysoData().get("Motd"); 
  motd = motd.replaceAll("&", "§");  
  p.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("MOTDS")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + motd + " " + ChatColor.GOLD.toString() + p.getDisplayName());
  String l1 = ((String)this.settings.getsysoData().get("Line1"));
  l1 = l1.replaceAll("&", "§");
  p.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("MOTDS")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + l1 );
  String l2 = ((String)this.settings.getsysoData().get("Line2"));
  l2 = l2.replaceAll("&", "§");
  p.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("MOTDS"))+ ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + l2 );
  String l3 = ((String)this.settings.getsysoData().get("Line3"));
  l3 = l3.replaceAll("&", "§");
  p.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("MOTDS")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + l3 );
  String l4 = ((String)this.settings.getsysoData().get("Line4"));
  l4 = l4.replaceAll("&", "§");
  p.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("MOTDS")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + l4);
  String l5 = ((String)this.settings.getsysoData().get("Line5"));
  l5 = l5.replaceAll("&", "§");
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
  
  public String version;
  
public Inventory gui;


 

  

  
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
  if ((p.isOp()) || (p.hasPermission((String)this.settings.getpermData().get("mwsChatColorSet")))) 
  {
  String msg = e.getMessage();
  e.setMessage(ChatColor.translateAlternateColorCodes('&', msg));
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
       
  }if (cmd.getName().equalsIgnoreCase("bankopen"))
  {
      if (!sender.hasPermission((String)this.settings.getpermData().get("mwsbanking")))
      {Player player = (Player)sender;
    	  sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + ChatColor.BLUE + ((String)this.settings.getpermData().get("mwsbanking")) + " " + ChatColor.GREEN + ((String)this.settings.getsysoData().get("permError")));
        player.getWorld().playEffect(player.getLocation(), Effect.GHAST_SHRIEK, 50);
        return false;
      }  else {  
	  int b1 = getConfig().getInt("Slots");
    	  Inventory inventory = Bukkit.createInventory(p, b1, getConfig().getString("BankName"));
      for (int slotIndex = 0; slotIndex != b1; slotIndex++)
        inventory.setItem(slotIndex, this.settings.getbData().getItemStack(p.getUniqueId().toString() + ".item" + slotIndex));      
      p.openInventory(inventory);
      playerBank.put(p, inventory);
    }
  
	return true;

  }
  if (cmd.getName().equalsIgnoreCase("vipbank"))
  {
      if (!sender.hasPermission((String)this.settings.getpermData().get("mwsvipbanking")))
      {Player player = (Player)sender;
    	  sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + ChatColor.BLUE + ((String)this.settings.getpermData().get("mwsvipbanking")) + " " + ChatColor.GREEN + ((String)this.settings.getsysoData().get("permError")));
        player.getWorld().playEffect(player.getLocation(), Effect.GHAST_SHRIEK, 50);
        return false;
      }  else { 
	 int b2 = getConfig().getInt("VipSlots");
    	  Inventory inventory1 = Bukkit.createInventory(p, b2, getConfig().getString("VipBankName"));
      for (int slotIndex1 = 0; slotIndex1 != b2; slotIndex1++)
        inventory1.setItem(slotIndex1, this.settings.getb2Data().getItemStack(p.getUniqueId().toString() + ".item" + slotIndex1));      
      p.openInventory(inventory1);
      playerBank2.put(p, inventory1);
    }  
	return true;

  }
  if (cmd.getName().equalsIgnoreCase("ps2"))
  {
      if (!sender.hasPermission((String)this.settings.getpermData().get("mwsshop2")))
      {Player player = (Player)sender;
    	  sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + ChatColor.BLUE + ((String)this.settings.getpermData().get("mwsshop2")) + " " + ChatColor.GREEN + ((String)this.settings.getsysoData().get("permError")));
        player.getWorld().playEffect(player.getLocation(), Effect.GHAST_SHRIEK, 50);
        return false;
      }  else { 
	 int shop2 = getConfig().getInt("Shop2Slots");
    	  Inventory inventory2 = Bukkit.createInventory(p, shop2, getConfig().getString("PlayerShopName"));
      for (int slotIndex2 = 0; slotIndex2 != shop2; slotIndex2++)
        inventory2.setItem(slotIndex2, this.settings.getb2Data().getItemStack(p.getUniqueId().toString() + ".item" + slotIndex2));      
      p.openInventory(inventory2);
      playerShop2.put(p, inventory2);
    }  
	return true;

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
   	     sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " »" + ChatColor.BLUE + ((String)this.settings.getsysoData().get("CreateWait")));    	  
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
      this.settings.getwData().set("worlds." + args[0] + ".type", "FLAT");
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
      sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " »" + ChatColor.BLUE + ((String)this.settings.getsysoData().get("Warpcreate")) + " " + ChatColor.GOLD + args[0]);
      return true;
    }
    if (args.length == 0)

    {
  	  sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " »" + ChatColor.BLUE + ((String)this.settings.getsysoData().get("mwErrorWName")));
  	  
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
  	     sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " »" + ChatColor.BLUE + ((String)this.settings.getsysoData().get("CreateWait")));   	  
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
      this.settings.getwData().set("worlds." + args[0] + ".type", "LARGE_BIOMES" + "'");
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
      sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " »" + ChatColor.BLUE + ((String)this.settings.getsysoData().get("Warpcreate")) + " " + ChatColor.GOLD + args[0]);
      return true;
    }
    if (args.length == 0)

    {
  	  sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " »" + ChatColor.BLUE + ((String)this.settings.getsysoData().get("mwErrorWName")));
  	  
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
	     sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " »" + ChatColor.BLUE + ((String)this.settings.getsysoData().get("CreateWait")));   	  
      WorldCreator b = new WorldCreator(args[0]);
      b.type(WorldType.NORMAL);
      b.generateStructures(true);
      b.generateStructures(true);getCommand("cnormal");
      this.world = b.createWorld();
      this.settings.getwData().set("worlds." + args[0] + ".type", "NORMAL");
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
      sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " »" + ChatColor.BLUE + ((String)this.settings.getsysoData().get("Warpcreate")) + " " + ChatColor.GOLD + args[0]);
      return true;
    }
    if (args.length == 0)

    {
  	  sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " »" + ChatColor.BLUE + ((String)this.settings.getsysoData().get("mwErrorWName")));
  	  
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
	     sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " »" + ChatColor.BLUE + ((String)this.settings.getsysoData().get("CreateWait")));
      WorldCreator b = new WorldCreator(args[0]);
      b.type(WorldType.AMPLIFIED);
      b.generateStructures(true);
      b.generateStructures(true);getCommand("camp");
      this.world = b.createWorld();
      this.settings.getwData().set("worlds." + args[0] + ".type", "AMPLIFIED");
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
      sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " »" + ChatColor.BLUE + ((String)this.settings.getsysoData().get("Warpcreate")) + " " + ChatColor.GOLD + args[0]);
      return true;
    }
  
  if (args.length == 0)

  {
	  sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " »" + ChatColor.BLUE + ((String)this.settings.getsysoData().get("mwErrorWName")));
	  
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
    	     sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " »" + ChatColor.BLUE + ((String)this.settings.getsysoData().get("CreateWait")));
      WorldCreator b = new WorldCreator(args[0]);
      b.type(WorldType.VERSION_1_1);
      b.generateStructures(true);
      b.generateStructures(true);getCommand("cv1");
      this.world = b.createWorld();
      loc = p.getLocation();
      this.settings.getwData().set("worlds." + args[0] + ".type", "VERSION_1_1");
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
      sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " »" + ChatColor.BLUE + ((String)this.settings.getsysoData().get("Warpcreate")) + " " + ChatColor.GOLD + args[0]);
      return true;
    }   
    
    if (args.length == 0)
  
    {
  	  sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " »" + ChatColor.BLUE + ((String)this.settings.getsysoData().get("mwErrorWName")));
  	  
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
     sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " »" + ChatColor.BLUE + ((String)this.settings.getsysoData().get("CreateWait")));
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
      sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " »" + ChatColor.BLUE + ((String)this.settings.getsysoData().get("Warpcreate")) + " " + ChatColor.GOLD + args[0]);            
      return true;
    }
      if (args.length == 0)
    
      {
    	  sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " »" + ChatColor.BLUE + ((String)this.settings.getsysoData().get("mwscerrorName")));
    	  
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
      }if (cmd.getName().equalsIgnoreCase("healthbar"))
	    {
	      if (!sender.hasPermission((String)this.settings.getpermData().get("mwshealthbar")))
	      {
	    	  sender.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + ChatColor.BLUE + ((String)this.settings.getpermData().get("mwshealthbar")) + " " + ChatColor.GREEN + ((String)this.settings.getsysoData().get("permError")));
	        p.getWorld().playEffect(p.getLocation(), Effect.GHAST_SHRIEK, 50);
	        return false;}
        if (args.length > 0) {
            if (args[0].equals("on")) {
                this.display = true;
                p.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + ChatColor.BLUE + ((String)this.settings.getsysoData().get("mwshealthbaron")));
            }
            if (args[0].equals("off")) {
                this.display = false;
                p.sendMessage(ChatColor.GOLD.toString() + ChatColor.BOLD + ((String)this.settings.getsysoData().get("SystemName")) + ChatColor.GOLD.toString() + ChatColor.BOLD + " >" + ChatColor.BLUE + ((String)this.settings.getsysoData().get("mwshealthbaroff")));
            }
        }
        return true;
    }
  if ((cmd.getName().equalsIgnoreCase("ps")) && ((sender instanceof Player))) {
      if ((args.length <= 0) || (args.length < 1)) {
        return false;
      }
      new cmd_shop(this).cmd(sender, cmd, commandLabel, args);
      return true; }
    if ((sender instanceof ConsoleCommandSender)) {
      sender.sendMessage(prefix + "Try this command as player!");
    }
    
    return true;}
 


	public void buyItem(Player buyer, OfflinePlayer seller, int ID)
	  {
	    Inventory inv = buyer.getInventory();
	    if ((this.settings.getsData().getItemStack("shops." + seller.getName() + "." + ID + ".item") != null) && (econ.getBalance(buyer) >= this.settings.getsData().getInt("shops." + seller.getName() + "." + ID + ".price")))
	    {
	      ItemStack buyItem = new ItemStack(this.settings.getsData().getItemStack("shops." + seller.getName() + "." + ID + ".item"));
	      inv.addItem(new ItemStack[] { buyItem });
	      buyer.sendMessage(ChatColor.GREEN + "You have successfully bought " + buyItem.getAmount() + " of " + buyItem.getType() + " from " + seller.getName() + "! Price: $" + this.settings.getsData().getInt(new StringBuilder("shops.").append(seller.getName()).append(".").append(ID).append(".price").toString()));
	      this.settings.savesData();	      
	      EconomyResponse r = econ.withdrawPlayer(buyer, this.settings.getsData().getInt("shops." + seller.getName() + "." + ID + ".price"));
	      EconomyResponse resp = econ.depositPlayer(seller, this.settings.getsData().getInt("shops." + seller.getName() + "." + ID + ".price"));
	      if ((r.transactionSuccess()) || (resp.transactionSuccess())) {
	        log.info("A PlayerShop transaction successfully completed!");
	      }
	      this.settings.getsData().set("shops." + seller.getName() + "." + ID, null);
	      this.settings.getsData().set("shops." + seller.getName() + ".items_on_sale", Integer.valueOf(this.settings.getsData().getInt("shops." + seller.getName() + ".items_on_sale") - 1));
	      this.settings.savesData();
	    }
	    else
	    {
	      buyer.sendMessage(ChatColor.RED + "This item has been sold or you have not enough money!");
	    }}
	  


    
	  
    









@Override
public List<MetadataValue> getMetadata(String arg0) {
	// TODO Auto-generated method stub
	return null;
}






@Override
public boolean hasMetadata(String arg0) {
	// TODO Auto-generated method stub
	return false;
}






@Override
public void removeMetadata(String arg0, Plugin arg1) {
	// TODO Auto-generated method stub
	
}






@Override
public void setMetadata(String arg0, MetadataValue arg1) {
	// TODO Auto-generated method stub
	
}






@Override
public void sendMessage(String arg0) {
	// TODO Auto-generated method stub
	
}






@Override
public void sendMessage(String[] arg0) {
	// TODO Auto-generated method stub
	
}






@Override
public PermissionAttachment addAttachment(Plugin arg0) {
	// TODO Auto-generated method stub
	return null;
}






@Override
public PermissionAttachment addAttachment(Plugin arg0, int arg1) {
	// TODO Auto-generated method stub
	return null;
}






@Override
public PermissionAttachment addAttachment(Plugin arg0, String arg1, boolean arg2) {
	// TODO Auto-generated method stub
	return null;
}






@Override
public PermissionAttachment addAttachment(Plugin arg0, String arg1, boolean arg2, int arg3) {
	// TODO Auto-generated method stub
	return null;
}






@Override
public Set<PermissionAttachmentInfo> getEffectivePermissions() {
	// TODO Auto-generated method stub
	return null;
}






@Override
public boolean hasPermission(String arg0) {
	// TODO Auto-generated method stub
	return false;
}






@Override
public boolean hasPermission(Permission arg0) {
	// TODO Auto-generated method stub
	return false;
}






@Override
public boolean isPermissionSet(String arg0) {
	// TODO Auto-generated method stub
	return false;
}






@Override
public boolean isPermissionSet(Permission arg0) {
	// TODO Auto-generated method stub
	return false;
}






@Override
public void recalculatePermissions() {
	// TODO Auto-generated method stub
	
}






@Override
public void removeAttachment(PermissionAttachment arg0) {
	// TODO Auto-generated method stub
	
}






@Override
public boolean isOp() {
	// TODO Auto-generated method stub
	return false;
}






@Override
public void setOp(boolean arg0) {
	// TODO Auto-generated method stub
	
}






@Override
public String getCustomName() {
	// TODO Auto-generated method stub
	return null;
}






@Override
public void setCustomName(String arg0) {
	// TODO Auto-generated method stub
	
}






@Override
public boolean addPassenger(Entity arg0) {
	// TODO Auto-generated method stub
	return false;
}






@Override
public boolean addScoreboardTag(String arg0) {
	// TODO Auto-generated method stub
	return false;
}






@Override
public boolean eject() {
	// TODO Auto-generated method stub
	return false;
}






@Override
public int getEntityId() {
	// TODO Auto-generated method stub
	return 0;
}






@Override
public float getFallDistance() {
	// TODO Auto-generated method stub
	return 0;
}






@Override
public int getFireTicks() {
	// TODO Auto-generated method stub
	return 0;
}






@Override
public double getHeight() {
	// TODO Auto-generated method stub
	return 0;
}






@Override
public EntityDamageEvent getLastDamageCause() {
	// TODO Auto-generated method stub
	return null;
}






@Override
public Location getLocation() {
	// TODO Auto-generated method stub
	return null;
}






@Override
public Location getLocation(Location arg0) {
	// TODO Auto-generated method stub
	return null;
}






@Override
public int getMaxFireTicks() {
	// TODO Auto-generated method stub
	return 0;
}






@Override
public List<Entity> getNearbyEntities(double arg0, double arg1, double arg2) {
	// TODO Auto-generated method stub
	return null;
}






@Override
public Entity getPassenger() {
	// TODO Auto-generated method stub
	return null;
}






@Override
public List<Entity> getPassengers() {
	// TODO Auto-generated method stub
	return null;
}






@Override
public PistonMoveReaction getPistonMoveReaction() {
	// TODO Auto-generated method stub
	return null;
}






@Override
public int getPortalCooldown() {
	// TODO Auto-generated method stub
	return 0;
}






@Override
public Set<String> getScoreboardTags() {
	// TODO Auto-generated method stub
	return null;
}






@Override
public int getTicksLived() {
	// TODO Auto-generated method stub
	return 0;
}






@Override
public EntityType getType() {
	// TODO Auto-generated method stub
	return null;
}






@Override
public UUID getUniqueId() {
	// TODO Auto-generated method stub
	return null;
}






@Override
public Entity getVehicle() {
	// TODO Auto-generated method stub
	return null;
}






@Override
public Vector getVelocity() {
	// TODO Auto-generated method stub
	return null;
}






@Override
public double getWidth() {
	// TODO Auto-generated method stub
	return 0;
}






@Override
public World getWorld() {
	// TODO Auto-generated method stub
	return null;
}






@Override
public boolean hasGravity() {
	// TODO Auto-generated method stub
	return false;
}






@Override
public boolean isCustomNameVisible() {
	// TODO Auto-generated method stub
	return false;
}






@Override
public boolean isDead() {
	// TODO Auto-generated method stub
	return false;
}






@Override
public boolean isEmpty() {
	// TODO Auto-generated method stub
	return false;
}






@Override
public boolean isGlowing() {
	// TODO Auto-generated method stub
	return false;
}






@Override
public boolean isInsideVehicle() {
	// TODO Auto-generated method stub
	return false;
}






@Override
public boolean isInvulnerable() {
	// TODO Auto-generated method stub
	return false;
}






@Override
public boolean isOnGround() {
	// TODO Auto-generated method stub
	return false;
}






@Override
public boolean isSilent() {
	// TODO Auto-generated method stub
	return false;
}






@Override
public boolean isValid() {
	// TODO Auto-generated method stub
	return false;
}






@Override
public boolean leaveVehicle() {
	// TODO Auto-generated method stub
	return false;
}






@Override
public void playEffect(EntityEffect arg0) {
	// TODO Auto-generated method stub
	
}






@Override
public void remove() {
	// TODO Auto-generated method stub
	
}






@Override
public boolean removePassenger(Entity arg0) {
	// TODO Auto-generated method stub
	return false;
}






@Override
public boolean removeScoreboardTag(String arg0) {
	// TODO Auto-generated method stub
	return false;
}






@Override
public void setCustomNameVisible(boolean arg0) {
	// TODO Auto-generated method stub
	
}






@Override
public void setFallDistance(float arg0) {
	// TODO Auto-generated method stub
	
}






@Override
public void setFireTicks(int arg0) {
	// TODO Auto-generated method stub
	
}






@Override
public void setGlowing(boolean arg0) {
	// TODO Auto-generated method stub
	
}






@Override
public void setGravity(boolean arg0) {
	// TODO Auto-generated method stub
	
}






@Override
public void setInvulnerable(boolean arg0) {
	// TODO Auto-generated method stub
	
}






@Override
public void setLastDamageCause(EntityDamageEvent arg0) {
	// TODO Auto-generated method stub
	
}






@Override
public boolean setPassenger(Entity arg0) {
	// TODO Auto-generated method stub
	return false;
}






@Override
public void setPortalCooldown(int arg0) {
	// TODO Auto-generated method stub
	
}






@Override
public void setSilent(boolean arg0) {
	// TODO Auto-generated method stub
	
}






@Override
public void setTicksLived(int arg0) {
	// TODO Auto-generated method stub
	
}






@Override
public void setVelocity(Vector arg0) {
	// TODO Auto-generated method stub
	
}






@Override
public Spigot spigot() {
	// TODO Auto-generated method stub
	return null;
}






@Override
public boolean teleport(Location arg0) {
	// TODO Auto-generated method stub
	return false;
}






@Override
public boolean teleport(Entity arg0) {
	// TODO Auto-generated method stub
	return false;
}






@Override
public boolean teleport(Location arg0, TeleportCause arg1) {
	// TODO Auto-generated method stub
	return false;
}






@Override
public boolean teleport(Entity arg0, TeleportCause arg1) {
	// TODO Auto-generated method stub
	return false;
}

}





 
  	
  		
 

	  







