package de.emptyWorld.main.mob;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.EntityType;
import org.bukkit.event.Listener;

import de.emptyWorld.main.einstellungen;
import de.emptyWorld.main.leerWelt;

public class Config implements Listener
{einstellungen settings = einstellungen.getInstance();
FileConfiguration data;
FileConfiguration wdata;
FileConfiguration pdata;
FileConfiguration dedata;	  
FileConfiguration endata;
FileConfiguration permdata;
FileConfiguration sysodata;

leerWelt plugin; 

	  public static Map<EntityType, Loot> lootByEntity = new HashMap<EntityType, Loot>();
	  public static FileConfiguration configuration;
	  public static boolean enabled;
	  public static Logger log = Logger.getLogger("ZauschCraft");
	  public Config(leerWelt instance)
			  {

		  plugin = instance;
		  
	    if (!leerWelt.instance.getDataFolder().exists()) {
	      leerWelt.instance.getDataFolder().mkdir();
	    }
	    File config = new File(leerWelt.instance.getDataFolder(), "MobLoot.yml");
	    try
	    {
	      if (!config.exists()) {
	        config.createNewFile();}
	        log('a', "The MobLoot.yml has been created.");
	    }
	    catch (Exception e)
	    {
	      e.printStackTrace();
	    }
	    configuration = YamlConfiguration.loadConfiguration(config);
	    


	    configuration.options().header("This (mob-loot-enabled) represents if the plugin is enabled in server.\nIf the plugin configuration is disabled the loading configuration is cancelled. \n\nHowTo setup loot  \nDIAMOND-1-%100 (or) 265-1-%100\nCan add more items: DIAMOND-1-%100;GOLD_INGOT-1-%58\nKey 1: Represents the item by name or id.\nKey 2: amount.\nKey 3: Chance of drop.\n");
	    











	    addDefault(configuration, "mob-loot-enabled", Boolean.valueOf(true));
	    enabled = configuration.getBoolean("mob-loot-enabled");
	    


	    addDefault(configuration, "mob-loot.player", "");
	    

	    addDefault(configuration, "mob-loot.bat", "");
	    addDefault(configuration, "mob-loot.chicken", "");
	    addDefault(configuration, "mob-loot.cow", "");
	    addDefault(configuration, "mob-loot.cow-mushroom", "");
	    addDefault(configuration, "mob-loot.pig", "");
	    addDefault(configuration, "mob-loot.rabbit", "");
	    addDefault(configuration, "mob-loot.sheep", "");
	    addDefault(configuration, "mob-loot.squid", "");
	    addDefault(configuration, "mob-loot.villager", "");
	    addDefault(configuration, "mob-loot.ocelot", "");
	    

	    addDefault(configuration, "mob-loot.cave-spider", "");
	    addDefault(configuration, "mob-loot.enderman", "");
	    addDefault(configuration, "mob-loot.spider", "");
	    addDefault(configuration, "mob-loot.zombie-pigman", "");
	    

	    addDefault(configuration, "mob-loot.blaze", "");
	    addDefault(configuration, "mob-loot.creeper", "");
	    addDefault(configuration, "mob-loot.ghast", "");
	    addDefault(configuration, "mob-loot.guardian", "");
	    addDefault(configuration, "mob-loot.magma-cube", "");
	    addDefault(configuration, "mob-loot.silverfish", "");
	    addDefault(configuration, "mob-loot.skeleton", "");
	    addDefault(configuration, "mob-loot.slime", "");
	    addDefault(configuration, "mob-loot.witch", "");
	    addDefault(configuration, "mob-loot.zombie", "");
	    

	    addDefault(configuration, "mob-loot.iron-golem", "");
	    addDefault(configuration, "mob-loot.snow-golem", "");
	    

	    addDefault(configuration, "mob-loot.ender-dragon", "");
	    addDefault(configuration, "mob-loot.wither", "");
	    addDefault(configuration, "mob-loot.ocelot", "");
	    

	    addDefault(configuration, "cancel-default-mob-loot.bat", Boolean.valueOf(false));
	    addDefault(configuration, "cancel-default-mob-loot.chicken", Boolean.valueOf(false));
	    addDefault(configuration, "cancel-default-mob-loot.cow", Boolean.valueOf(false));
	    addDefault(configuration, "cancel-default-mob-loot.cow-mushroom", Boolean.valueOf(false));
	    addDefault(configuration, "cancel-default-mob-loot.pig", Boolean.valueOf(false));
	    addDefault(configuration, "cancel-default-mob-loot.rabbit", Boolean.valueOf(false));
	    addDefault(configuration, "cancel-default-mob-loot.sheep", Boolean.valueOf(false));
	    addDefault(configuration, "cancel-default-mob-loot.squid", Boolean.valueOf(false));
	    addDefault(configuration, "cancel-default-mob-loot.villager", Boolean.valueOf(false));
	    addDefault(configuration, "cancel-default-mob-loot.ocelot", Boolean.valueOf(false));
	    

	    addDefault(configuration, "cancel-default-mob-loot.cave-spider", Boolean.valueOf(false));
	    addDefault(configuration, "cancel-default-mob-loot.enderman", Boolean.valueOf(false));
	    addDefault(configuration, "cancel-default-mob-loot.spider", Boolean.valueOf(false));
	    addDefault(configuration, "cancel-default-mob-loot.zombie-pigman", Boolean.valueOf(false));
	    

	    addDefault(configuration, "cancel-default-mob-loot.blaze", Boolean.valueOf(false));
	    addDefault(configuration, "cancel-default-mob-loot.creeper", Boolean.valueOf(false));
	    addDefault(configuration, "cancel-default-mob-loot.ghast", Boolean.valueOf(false));
	    addDefault(configuration, "cancel-default-mob-loot.guardian", Boolean.valueOf(false));
	    addDefault(configuration, "cancel-default-mob-loot.magma-cube", Boolean.valueOf(false));
	    addDefault(configuration, "cancel-default-mob-loot.silverfish", Boolean.valueOf(false));
	    addDefault(configuration, "cancel-default-mob-loot.skeleton", Boolean.valueOf(false));
	    addDefault(configuration, "cancel-default-mob-loot.slime", Boolean.valueOf(false));
	    addDefault(configuration, "cancel-default-mob-loot.witch", Boolean.valueOf(false));
	    addDefault(configuration, "cancel-default-mob-loot.zombie", Boolean.valueOf(false));
	    

	    addDefault(configuration, "cancel-default-mob-loot.iron-golem", Boolean.valueOf(false));
	    addDefault(configuration, "cancel-default-mob-loot.snow-golem", Boolean.valueOf(false));
	    

	    addDefault(configuration, "cancel-default-mob-loot.ender-dragon", Boolean.valueOf(false));
	    addDefault(configuration, "cancel-default-mob-loot.wither", Boolean.valueOf(false));
	    addDefault(configuration, "cancel-default-mob-loot.ocelot", Boolean.valueOf(false));
	    try
	    {
	      configuration.save(config);
	    }
	    catch (IOException e)
	    {
	      e.printStackTrace();
	    }
	   
	    
	    lootByEntity.put(EntityType.valueOf("PLAYER"), Loot.deserialize(configuration.getString("mob-loot.player"), false));
	    lootByEntity.put(EntityType.valueOf("BAT"), Loot.deserialize(configuration.getString("mob-loot.bat"), configuration.getBoolean("cancel-default-mob-loot.bat")));
	    lootByEntity.put(EntityType.valueOf("CHICKEN"), Loot.deserialize(configuration.getString("mob-loot.chicken"), configuration.getBoolean("cancel-default-mob-loot.chicken")));
	    lootByEntity.put(EntityType.valueOf("COW"), Loot.deserialize(configuration.getString("mob-loot.cow"), configuration.getBoolean("cancel-default-mob-loot.cow")));
	    lootByEntity.put(EntityType.valueOf("MUSHROOM_COW"), Loot.deserialize(configuration.getString("mob-loot.cow-mushroom"), configuration.getBoolean("cancel-default-mob-loot.cow-mushroom")));
	    lootByEntity.put(EntityType.valueOf("PIG"), Loot.deserialize(configuration.getString("mob-loot.pig"), configuration.getBoolean("cancel-default-mob-loot.pig")));
	    lootByEntity.put(EntityType.valueOf("RABBIT"), Loot.deserialize(configuration.getString("mob-loot.rabbit"), configuration.getBoolean("cancel-default-mob-loot.rabbit")));
	    lootByEntity.put(EntityType.valueOf("SHEEP"), Loot.deserialize(configuration.getString("mob-loot.sheep"), configuration.getBoolean("cancel-default-mob-loot.sheep")));
	    lootByEntity.put(EntityType.valueOf("SQUID"), Loot.deserialize(configuration.getString("mob-loot.squid"), configuration.getBoolean("cancel-default-mob-loot.squid")));
	    lootByEntity.put(EntityType.valueOf("VILLAGER"), Loot.deserialize(configuration.getString("mob-loot.villager"), configuration.getBoolean("cancel-default-mob-loot.villager")));
	    lootByEntity.put(EntityType.valueOf("CAVE_SPIDER"), Loot.deserialize(configuration.getString("mob-loot.cave-spider"), configuration.getBoolean("cancel-default-mob-loot.cave-spider")));
	    lootByEntity.put(EntityType.valueOf("PIG_ZOMBIE"), Loot.deserialize(configuration.getString("mob-loot.zombie-pigman"), configuration.getBoolean("cancel-default-mob-loot.zombie-pigman")));
	    lootByEntity.put(EntityType.valueOf("BLAZE"), Loot.deserialize(configuration.getString("mob-loot.blaze"), configuration.getBoolean("cancel-default-mob-loot.blaze")));
	    lootByEntity.put(EntityType.valueOf("CREEPER"), Loot.deserialize(configuration.getString("mob-loot.creeper"), configuration.getBoolean("cancel-default-mob-loot.creeper")));
	    lootByEntity.put(EntityType.valueOf("GHAST"), Loot.deserialize(configuration.getString("mob-loot.ghast"), configuration.getBoolean("cancel-default-mob-loot.ghast")));
	    lootByEntity.put(EntityType.valueOf("GUARDIAN"), Loot.deserialize(configuration.getString("mob-loot.guardian"), configuration.getBoolean("cancel-default-mob-loot.guardian")));
	    lootByEntity.put(EntityType.valueOf("MAGMA_CUBE"), Loot.deserialize(configuration.getString("mob-loot.magma_cube"), configuration.getBoolean("cancel-default-mob-loot.magma-cube")));
	    lootByEntity.put(EntityType.valueOf("SILVERFISH"), Loot.deserialize(configuration.getString("mob-loot.silverfish"), configuration.getBoolean("cancel-default-mob-loot.silverfish")));
	    lootByEntity.put(EntityType.valueOf("SKELETON"), Loot.deserialize(configuration.getString("mob-loot.skeleton"), configuration.getBoolean("cancel-default-mob-loot.skeleton")));
	    lootByEntity.put(EntityType.valueOf("SLIME"), Loot.deserialize(configuration.getString("mob-loot.slime"), configuration.getBoolean("cancel-default-mob-loot.slime")));
	    lootByEntity.put(EntityType.valueOf("WITCH"), Loot.deserialize(configuration.getString("mob-loot.witch"), configuration.getBoolean("cancel-default-mob-loot.witch")));
	    lootByEntity.put(EntityType.valueOf("ZOMBIE"), Loot.deserialize(configuration.getString("mob-loot.zombie"), configuration.getBoolean("cancel-default-mob-loot.zombie")));
	    lootByEntity.put(EntityType.valueOf("IRON_GOLEM"), Loot.deserialize(configuration.getString("mob-loot.iron-golem"), configuration.getBoolean("cancel-default-mob-loot.iron-golem")));
	    lootByEntity.put(EntityType.valueOf("ENDER_DRAGON"), Loot.deserialize(configuration.getString("mob-loot.ender-dragon"), configuration.getBoolean("cancel-default-mob-loot.ender-dragon")));
	    lootByEntity.put(EntityType.valueOf("WITHER"), Loot.deserialize(configuration.getString("mob-loot.wither"), configuration.getBoolean("cancel-default-mob-loot.wither")));
	    lootByEntity.put(EntityType.valueOf("OCELOT"), Loot.deserialize(configuration.getString("mob-loot.ocelot"), configuration.getBoolean("cancel-default-mob-loot.ocelot")));
	 
	  }
	  
	  private static void log(char c, String string) {
		// TODO Auto-generated method stub
		
	}

	private static void addDefault(FileConfiguration configuration, String path, Object value)
	  {
	    if (!configuration.contains(path)) {
	      configuration.set(path, value);
	    }
	  }
	}
