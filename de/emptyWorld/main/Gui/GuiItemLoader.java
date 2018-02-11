package de.emptyWorld.main.Gui;

import de.emptyWorld.main.objects.GuiItem;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.Inventory;

public class GuiItemLoader
{
  @SuppressWarnings("deprecation")
public GuiItemLoader(FileConfiguration config, List<GuiItem> wheretoadd)
  {
    for (String s : config.getConfigurationSection("Items").getKeys(false)) {
      int itemID = (int)getNumber(config.getString("Items." + s + ".ItemID"));
      short itemDatavalue = (short)(int)getNumber(config.getString("Items." + s + ".ItemDataValue"));
      short itemdamage = (short)(int)getNumber(config.getString("Items." + s + ".ItemDamage"));
      int itemslot = (int)getNumber(config.getString("Items." + s + ".ItemSlot"));
      int itemammount = (int)getNumber(config.getString("Items." + s + ".ItemAmmount"));
      List<String> desc = translateListColorCodes(Arrays.asList(config.getString("Items." + s + ".Description").split("/n")));
      String itmname = colorise(s);
      List<String> cmd = config.getStringList("Items." + s + ".Commands");
      if (itemslot > 54) itemslot = 54;
      if (itemammount > 64) itemammount = 64;
      wheretoadd.add(new GuiItem(itemammount, Material.getMaterial(itemID), itmname, itemDatavalue, itemslot, cmd, desc, itemdamage));
    }
  }
  
  private String colorise(String s) {
    return ChatColor.translateAlternateColorCodes('&', s);
  }
  
  private List<String> translateListColorCodes(List<String> t) {
    List<String> list = new ArrayList<String>();
    for (String s : t)
      list.add(colorise(s));
    return list;
  }
  
  private double getNumber(String num)
  {
    return Double.parseDouble(num.replaceAll("[^\\d.]", ""));
  }



public Inventory servers1 = Bukkit.createInventory(null, 9, ChatColor.DARK_BLUE + "Server List");
 


}