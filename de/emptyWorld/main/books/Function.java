package de.emptyWorld.main.books;

import java.io.File;

import org.bukkit.World;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Listener;

import de.emptyWorld.main.einstellungen;
import de.emptyWorld.main.leerWelt;


public class Function implements Listener{
	einstellungen settings = einstellungen.getInstance();

	  FileConfiguration permdata;
	  FileConfiguration sysodata;
	  World world;
	
	  leerWelt plugin;
	  File _file_newspaper;
	  public Function( leerWelt instance)
	  {

	    plugin = instance;
	    
	  }  
	  
	  public String c_prefix = plugin.c_prefix;
	  public String p_prefix = plugin.p_prefix;
	
	  public ConsoleCommandSender console = plugin.console;
	
	public static void initConfig(){
		//TODO set the default config if not set already
	}
	
	public static void verifyxmlVersion(){
		//TODO check if the version is equal to the current version, if not, add needed values, and remove unused
		
		/*List<String> outdatedValues = new ArrayList<String>();
		outdatedValues.add("<random_tag>");*/
	}
}