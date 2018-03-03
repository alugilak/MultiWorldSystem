package de.emptyWorld.main.mob;


import java.util.HashMap;
import java.util.Map;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import de.emptyWorld.main.leerWelt;

public class Loot
{
  public boolean cancelDefaultLoot;
  public Map<Byte, ItemStack> loot = new HashMap<Byte, ItemStack>();
  
  public static Loot deserialize(String serializedLootString, boolean defaultLoot)
  {
    if ((serializedLootString == null) || (serializedLootString.length() == 0)) {
      return null;
    }
    Loot loot = new Loot();
    

    loot.cancelDefaultLoot = defaultLoot;
    

    Material material = null;
    

    String[] split = serializedLootString.split(";");
    for (String lootString : split)
    {
      String[] key = lootString.split("-");
      if (key[0].length() != 0)
      {
        if (!Character.isDigit(key[0].charAt(0))) {
          material = Material.getMaterial(key[0]);
        } else {
          material = Material.getMaterial(Integer.parseInt(key[0]));
        }
        if (material == null) {
          throw new IllegalArgumentException("The name from material is wrong, check your config.yml.");
        }
        loot.loot.put(Byte.valueOf(Byte.parseByte(key[2].substring(1))), new ItemStack(material, Integer.parseInt(key[1])));
        
        key = null;
      }
    }
    split = null;
    

    return loot;
  }
}
