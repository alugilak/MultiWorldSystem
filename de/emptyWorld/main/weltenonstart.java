package de.emptyWorld.main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import de.emptyWorld.main.loadworld;
import static java.nio.file.StandardCopyOption.*;

public class weltenonstart implements CommandExecutor
{
	
	einstellungen settings = einstellungen.getInstance();

	  FileConfiguration permdata;
	  FileConfiguration sysodata;
	  World world;
	
	  leerWelt plugin;
	  loadworld worldLoader;
	
  public weltenonstart( leerWelt instance)
  {

    plugin = instance;
  }  
  


	
  public boolean onCommand(CommandSender sender, Command cmd, String label, Path[] args)
  {
    Player player = (Player)sender;
    if ((player.hasPermission(((String) this.settings.getpermData().get("mwsworldrename"))) && 
      (cmd.getName().equalsIgnoreCase("test")))) { 
          	
        try {
			Files.copy(args[0], args[1], REPLACE_EXISTING);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    return false;
  }
  
  public void CopyFile(Path target,Path dest) throws IOException {
	 
	    Files.copy(dest, target, REPLACE_EXISTING);
	     
	      
  }




@Override
public boolean onCommand(CommandSender arg0, Command arg1, String arg2, String[] arg3) {
	// TODO Auto-generated method stub
	return false;
}

	}
