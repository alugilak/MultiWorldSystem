package de.emptyWorld.main.objects;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.bukkit.command.Command;
import org.bukkit.plugin.Plugin;



public class FakeCommandRegister
{
  public FakeCommandRegister(Command whatCommand, Plugin plugin)
    throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
  {
    Method commandMap = plugin.getServer().getClass().getMethod("getCommandMap", null);
    
    Object cmdmap = commandMap.invoke(plugin.getServer(), null);
    
    Method register = cmdmap.getClass().getMethod("register", new Class[] { String.class, Command.class });
    
    register.invoke(cmdmap, new Object[] { whatCommand.getName(), whatCommand });
  }
  



  public static void registerFakeCommand(Command whatCommand, Plugin plugin)
    throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
  {
    Method commandMap = plugin.getServer().getClass().getMethod("getCommandMap", null);
    
    Object cmdmap = commandMap.invoke(plugin.getServer(), null);
    
    Method register = cmdmap.getClass().getMethod("register", new Class[] { String.class, Command.class });
    
    register.invoke(cmdmap, new Object[] { whatCommand.getName(), whatCommand });
  }
}

