package de.emptyWorld.main;

import java.io.File;
import java.io.IOException;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;





public class einstellungen
{
	
  static einstellungen instanz = new einstellungen();
  Plugin p;
  FileConfiguration data ;
  File dfile;
  FileConfiguration wdata ;
  File wfile;
  FileConfiguration pdata ;
  File pfile;
  FileConfiguration dedata ;
  File de;
  FileConfiguration endata ;
  File en;
  FileConfiguration permdata ;
  File perm;
  FileConfiguration sysodata ;
  File syso;
  
leerWelt plugin;
World world;

  
  public static einstellungen getInstance()
  {
    return instanz;
  }
  
  public void setup(Plugin p) 
  {
    if (!p.getDataFolder().exists()) {
      p.getDataFolder().mkdir();
      }

    this.en = new File(p.getDataFolder(), "en.yml");
    this.de = new File(p.getDataFolder(), "de.yml");
    this.dfile = new File(p.getDataFolder(), "warpsAndspawns.yml");
    this.wfile = new File(p.getDataFolder(), "worlds.yml");
    this.pfile = new File(p.getDataFolder(), "enchant.yml");
    this.perm = new File(p.getDataFolder(), "permsList.yml");
    this.syso = new File(p.getDataFolder(), "SystemOut.yml"); 
    if (!this.syso.exists()) {
        try
        {
          this.syso.createNewFile();
        }
        catch (IOException d)
        {
          Bukkit.getServer().getLogger().severe(ChatColor.RED + "Kann die datei nicht lesen System/SystemOut.yml!");
        }
      }
      this.sysodata = YamlConfiguration.loadConfiguration(this.syso);
      
      {
    if (!this.perm.exists()) {
        try
        {
          this.perm.createNewFile();
        }
        catch (IOException d)
        {
          Bukkit.getServer().getLogger().severe(ChatColor.RED + "Kann die datei nicht lesen System/permsList.yml!");
        }
      }
      this.permdata = YamlConfiguration.loadConfiguration(this.perm);

      {
    if (!this.de.exists()) {
        try
        {
          this.de.createNewFile();
          
        }
        catch (IOException d)
        {
          Bukkit.getServer().getLogger().severe(ChatColor.RED + "Kann die datei nicht lesen lang/de.yml!");
        }
      }
      this.dedata = YamlConfiguration.loadConfiguration(this.de);
      
      {
   if (!this.en.exists()) {
	   try
	{
	this.en.createNewFile();
		}
	   catch (IOException d)
	   {
		   Bukkit.getServer().getLogger().severe(ChatColor.RED + "Kann die datei nicht lesen lang/en.yml!");
    	        }
    	      }
	 this.endata = YamlConfiguration.loadConfiguration(this.en);
	 
	 {
		 

    if (!this.dfile.exists()) {
      try
      {
        this.dfile.createNewFile();
      }
      catch (IOException d)
      {
        Bukkit.getServer().getLogger().severe(ChatColor.RED + "Kann die datei nicht lesen warps_worlds/warpsAndspawns.yml!");
      }
    }
    this.data = YamlConfiguration.loadConfiguration(this.dfile);
  
    {
    	

  if (!this.wfile.exists()) {
      try
      {
        this.wfile.createNewFile();
      }
      catch (IOException d)
      {
        Bukkit.getServer().getLogger().severe(ChatColor.RED + "Kann die datei nicht lesen warps_worlds/worlds.yml!");
      }
    }
    this.wdata = YamlConfiguration.loadConfiguration(this.wfile);}
    {
    	
    
  if (!this.pfile.exists()) {
      try
      {
        this.pfile.createNewFile();
      }
      catch (IOException d)
      {
        Bukkit.getServer().getLogger().severe(ChatColor.RED + "Kann die datei nicht lesen Spieler/enchant.yml!");
      }
    }
    this.pdata = YamlConfiguration.loadConfiguration(this.pfile);}}}}}
    	      }public FileConfiguration getsysoData()
    	      {
    	          return this.sysodata;
    	        } 
      public FileConfiguration getpermData()
      {
        return this.permdata;
      } 
   public FileConfiguration getdeData()
      {
        return this.dedata;
      }
      public FileConfiguration getenData()
      {
        return this.endata;
      }
  public FileConfiguration getData()
  {
    return this.data;
  }
  public FileConfiguration getwData()
  {
    return this.wdata;
  }
  public FileConfiguration getpData()
  {
    return this.pdata;
  }
  public void savepermData()
  {
    try
    {
      this.permdata.save(this.perm);
    }
    catch (IOException d)
    {
      Bukkit.getServer().getLogger().severe(ChatColor.RED + "Kann Datei nicht speichern System/permsList.yml!");
    }}
  public void savesysoData()
  {
    try
    {
      this.sysodata.save(this.syso);
    }
    catch (IOException d)
    {
      Bukkit.getServer().getLogger().severe(ChatColor.RED + "Kann Datei nicht speichern System/SystemOut.yml!");
    }}
  public void saveenData()
  {
    try
    {
      this.endata.save(this.en);
    }
    catch (IOException d)
    {
      Bukkit.getServer().getLogger().severe(ChatColor.RED + "Kann Datei nicht speichern lang/en.yml!");
    }}
  public void savedeData()
  {
    try
    {
      this.dedata.save(this.de);
    }
    catch (IOException d)
    {
      Bukkit.getServer().getLogger().severe(ChatColor.RED + "Kann Datei nicht speichern lang/de.yml!");
    }}
  public void saveData()
  {
    try
    {
      this.data.save(this.dfile);
    }
    catch (IOException d)
    {
      Bukkit.getServer().getLogger().severe(ChatColor.RED + "Kann Datei nicht speichern warps_worlds/warpsAndspawns.yml!");
    }}
 
    public void savewData()
    {
      try
      {
        this.wdata.save(this.wfile);
      }
      catch (IOException d)
      {
        Bukkit.getServer().getLogger().severe(ChatColor.RED + "Kann Datei nicht speichern warps_worlds/worlds.yml!");
      }
  }
    public void savepData()
    {
      try
      {
        this.pdata.save(this.pfile);
      }
      catch (IOException d)
      {
        Bukkit.getServer().getLogger().severe(ChatColor.RED + "Kann Datei nicht speichern Spieler/enchant.yml!");
      }
   }
  public PluginDescriptionFile getDesc()
  {
    return this.p.getDescription();
  }
  public void reloadsysoData()
  {
    this.sysodata = YamlConfiguration.loadConfiguration(this.syso);
  }
  public void reloadpermData()
  {
    this.permdata = YamlConfiguration.loadConfiguration(this.perm);
  }
  public void reloadenData()
  {
    this.endata = YamlConfiguration.loadConfiguration(this.en);
  }
  public void reloaddeData()
  {
    this.dedata = YamlConfiguration.loadConfiguration(this.de);
  }
  public void reloadData()
  {
    this.data = YamlConfiguration.loadConfiguration(this.dfile);
  }
  public void reloadwData()
  {
    this.wdata = YamlConfiguration.loadConfiguration(this.wfile);
  }
  public void reloadpData()
  {
    this.pdata = YamlConfiguration.loadConfiguration(this.pfile);
  }
  public void savedeDefaultConfig() {
	
	  this.dedata = YamlConfiguration.loadConfiguration(this.de);
  }
  public void saveDefaultConfig() {
		
	  this.data = YamlConfiguration.loadConfiguration(this.dfile);
  }
  public void savepermDefaultConfig() {
		
	  this.permdata = YamlConfiguration.loadConfiguration(this.perm);
  }
  public void savesysoDefaultConfig() {
		
	  this.sysodata = YamlConfiguration.loadConfiguration(this.syso);
  }

}


