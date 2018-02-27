package de.emptyWorld.main;

import java.io.File;
import java.io.IOException;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.configuration.MemorySection;
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
  FileConfiguration cpdata ;
  File cp;
  FileConfiguration bdata ;
  File b;
  FileConfiguration b2data ;
  File b2;
  FileConfiguration sdata ;
  File s;
  FileConfiguration blockdata ;
  File block;
  FileConfiguration mobdata ;
  File mob;  
  FileConfiguration portaldata ;
  File portal; 
  FileConfiguration kitdata ;
  File kit; 
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
    this.kit = new File(p.getDataFolder(), "kits.yml");
    this.block = new File(p.getDataFolder(), "WeaponEnchant.yml");
    this.mob = new File(p.getDataFolder(), "WandTool.yml");
    this.cp = new File(p.getDataFolder(), "permcommands.yml");
    this.en = new File(p.getDataFolder(), "en.yml");
    this.de = new File(p.getDataFolder(), "de.yml");
    this.dfile = new File(p.getDataFolder(), "warpsAndspawns.yml");
    this.wfile = new File(p.getDataFolder(), "worlds.yml");
    this.pfile = new File(p.getDataFolder(), "enchant.yml");
    this.perm = new File(p.getDataFolder(), "permsList.yml");
    this.syso = new File(p.getDataFolder(), "SystemOut.yml");
    this.b = new File(p.getDataFolder(), "bank.yml"); 
    this.b2 = new File(p.getDataFolder(), "vipbank.yml");
    this.s = new File(p.getDataFolder(), "shops.yml");
    this.portal = new File(p.getDataFolder(), "portals.yml");
    
    if (!this.kit.exists()) {
        try
        {
          this.kit.createNewFile();
        }
        catch (IOException d)
        {
          Bukkit.getServer().getLogger().severe(ChatColor.RED + "Kann die datei nicht lesen kits.yml!");
        }
      }
      this.kitdata = YamlConfiguration.loadConfiguration(this.kit);
      
      {
    if (!this.block.exists()) {
        try
        {
          this.block.createNewFile();
        }
        catch (IOException d)
        {
          Bukkit.getServer().getLogger().severe(ChatColor.RED + "Kann die datei nicht lesen block-drops.yml!");
        }
      }
      this.blockdata = YamlConfiguration.loadConfiguration(this.block);
      
      {
    	  if (!this.portal.exists()) {
    	        try
    	        {
    	          this.portal.createNewFile();
    	        }
    	        catch (IOException d)
    	        {
    	          Bukkit.getServer().getLogger().severe(ChatColor.RED + "Kann die datei nicht lesen portal.yml!");
    	        }
    	      }
    	      this.portaldata = YamlConfiguration.loadConfiguration(this.portal);
    	      
    	      {
    	  if (!this.mob.exists()) {
    	        try
    	        {
    	          this.mob.createNewFile();
    	        }
    	        catch (IOException d)
    	        {
    	          Bukkit.getServer().getLogger().severe(ChatColor.RED + "Kann die datei nicht lesen mob-drops.yml!");
    	        }
    	      }
    	      this.mobdata = YamlConfiguration.loadConfiguration(this.mob);
    	      
    	      {
    
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
    	  if (!this.s.exists()) {
              try
              {
                this.s.createNewFile();
              }
              catch (IOException d)
              {
                Bukkit.getServer().getLogger().severe(ChatColor.RED + "Kann die datei nicht lesen shops.yml!");
              }
            }
            this.sdata = YamlConfiguration.loadConfiguration(this.s);
            
            {
    	  
    	  if (!this.b.exists()) {
          try
          {
            this.b.createNewFile();
          }
          catch (IOException d)
          {
            Bukkit.getServer().getLogger().severe(ChatColor.RED + "Kann die datei nicht lesen bank.yml!");
          }
        }
        this.b2data = YamlConfiguration.loadConfiguration(this.b2);
        
        {
        	if (!this.b2.exists()) {
                try
                {
                  this.b2.createNewFile();
                }
                catch (IOException d)
                {
                  Bukkit.getServer().getLogger().severe(ChatColor.RED + "Kann die datei nicht lesen bank2.yml!");
                }
              }
              this.bdata = YamlConfiguration.loadConfiguration(this.b);
              
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
    	  if (!this.cp.exists()) {
    	        try
    	        {
    	          this.cp.createNewFile();
    	        }
    	        catch (IOException d)
    	        {
    	          Bukkit.getServer().getLogger().severe(ChatColor.RED + "Kann die datei nicht lesen System/permsList.yml!");
    	        }
    	      }
    	      this.cpdata = YamlConfiguration.loadConfiguration(this.cp);
    	      
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
    this.pdata = YamlConfiguration.loadConfiguration(this.pfile);}}}}}}}}}}}}}
    	      }
  public FileConfiguration getkitData()
    	      {
    	          return this.kitdata;
    	        } 
  public FileConfiguration getportalData()
    	      {
    	          return this.portaldata;
    	        } 
  public FileConfiguration getblockData()
  {
      return this.blockdata;
    } 
  public FileConfiguration getmobData()
  {
      return this.mobdata;
    }
  public FileConfiguration getcpData()
    	      {
    	          return this.cpdata;
    	        } 
  public FileConfiguration getsysoData()
    	      {
    	          return this.sysodata;
    	        } 
  public FileConfiguration getsData()
  {
      return this.sdata;
    } 
  public FileConfiguration getbData()
  {
      return this.bdata;
    } 
  public FileConfiguration getb2Data()
  {
      return this.b2data;
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
  public void saveportalData()
  {
	    try
	    {
	      this.portaldata.save(this.portal);
	    }
	    catch (IOException d)
	    {
	      Bukkit.getServer().getLogger().severe(ChatColor.RED + "Kann Datei nicht speichern portal.yml!");
	    }}
  public void savekitData()
	    {
	  	    try
	  	    {
	  	      this.kitdata.save(this.kit);
	  	    }
	  	    catch (IOException d)
	  	    {
	  	      Bukkit.getServer().getLogger().severe(ChatColor.RED + "Kann Datei nicht speichern kits.yml!");
	  	    }}
  public void saveblockData()
  {
    try
    {
      this.blockdata.save(this.block);
    }
    catch (IOException d)
    {
      Bukkit.getServer().getLogger().severe(ChatColor.RED + "Kann Datei nicht speichern block-drops.yml!");
    }}
  
  public void savemobData()
  {
    try
    {
      this.mobdata.save(this.mob);
    }
    catch (IOException d)
    {
      Bukkit.getServer().getLogger().severe(ChatColor.RED + "Kann Datei nicht speichern mob-drops.yml.yml!");
    }}
  
  public void savecpData()
  {
    try
    {
      this.cpdata.save(this.cp);
    }
    catch (IOException d)
    {
      Bukkit.getServer().getLogger().severe(ChatColor.RED + "Kann Datei nicht speichern System/permsList.yml!");
    }}
  public void savesData()
  {
    try
    {
      this.sdata.save(this.s);
    }
    catch (IOException d)
    {
      Bukkit.getServer().getLogger().severe(ChatColor.RED + "Kann Datei nicht speichern shops.yml!");
    }}
  public void saveb2Data()
  {
    try
    {
      this.b2data.save(this.b2);
    }
    catch (IOException d)
    {
      Bukkit.getServer().getLogger().severe(ChatColor.RED + "Kann Datei nicht speichern bank2.yml!");
    }}
  public void savebData()
  {
    try
    {
      this.bdata.save(this.b);
    }
    catch (IOException d)
    {
      Bukkit.getServer().getLogger().severe(ChatColor.RED + "Kann Datei nicht speichern bank.yml!");
    }}
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
  public void reloadkitData()
  {
    this.kitdata = YamlConfiguration.loadConfiguration(this.kit);
  }
  public void reloadportalData()
  {
    this.portaldata = YamlConfiguration.loadConfiguration(this.portal);
  }
  public void reloadblockData()
  {
    this.blockdata = YamlConfiguration.loadConfiguration(this.block);
  } public void reloadmobData()
  {
	    this.mobdata = YamlConfiguration.loadConfiguration(this.mob);
	  }
  public void reloadcpData()
  {
    this.cpdata = YamlConfiguration.loadConfiguration(this.cp);
  }
  public void reloadsData()
  {
    this.sdata = YamlConfiguration.loadConfiguration(this.s);
  }
  public void reloadbData()
  {
    this.bdata = YamlConfiguration.loadConfiguration(this.b);
  }
  public void reloadb2Data()
  {
    this.b2data = YamlConfiguration.loadConfiguration(this.b2);
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
  public void savekitDefaultConfig() {
		
	  this.kitdata = YamlConfiguration.loadConfiguration(this.kit);
  }
  public void saveportalDefaultConfig() {
		
	  this.portaldata = YamlConfiguration.loadConfiguration(this.portal);
  }
  public void savedeDefaultConfig() {
		
	  this.dedata = YamlConfiguration.loadConfiguration(this.de);
  }
  public void savebDefaultConfig() {
		
	  this.bdata = YamlConfiguration.loadConfiguration(this.b);
  }
  public void saveb2DefaultConfig() {
		
	  this.b2data = YamlConfiguration.loadConfiguration(this.b2);
  }
  public void savesDefaultConfig() {
		
	  this.sdata = YamlConfiguration.loadConfiguration(this.s);
  }
  public void savecpDefaultConfig() {
	
	  this.cpdata = YamlConfiguration.loadConfiguration(this.cp);
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
  public void copykitDefaults() {
		
	  this.kitdata = YamlConfiguration.loadConfiguration(this.kit);
  }
  public void copyportalDefaults() {
		
	  this.portaldata = YamlConfiguration.loadConfiguration(this.portal);
  }
  public void copycpDefaults() {
		
	  this.cpdata = YamlConfiguration.loadConfiguration(this.cp);
  }
  public void savemobDefaultConfig() {
		
	  this.mobdata = YamlConfiguration.loadConfiguration(this.mob);
  }
  public void saveblockDefaultConfig() {
		
	  this.blockdata = YamlConfiguration.loadConfiguration(this.block);
  }



}


