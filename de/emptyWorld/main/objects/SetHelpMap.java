package de.emptyWorld.main.objects;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import org.bukkit.Bukkit;
import org.bukkit.help.HelpTopic;

public class SetHelpMap
{
  public SetHelpMap() {}
  
  public static void setHelpMapVersionIndep(HelpTopic... topic) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException
  {
    Object s = Bukkit.getServer();
    String bukkitversion = Bukkit.getServer().getClass().getPackage()
      .getName().substring(23);
    Object simplehmap = Class.forName("org.bukkit.craftbukkit." + bukkitversion + ".help.SimpleHelpMap")
      .getDeclaredConstructor(new Class[] {s.getClass() }).newInstance(new Object[] { s });
    HelpTopic[] arrayOfHelpTopic = topic;int j = topic.length; for (int i = 0; i < j; i++) { HelpTopic t = arrayOfHelpTopic[i];
      simplehmap.getClass()
        .getDeclaredMethod("addTopic", new Class[] { HelpTopic.class })
        .invoke(simplehmap, new Object[] { t }); }
    Field f = s.getClass().getDeclaredField("helpMap");
    f.setAccessible(true);
    f.set(s, simplehmap);
  }
}
