package de.emptyWorld.main.objects;

import java.util.List;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class GuiItem
  extends AbstractGuiItem
{
  ItemStack itm;
  int ammount;
  Material type;
  String itmname;
  short datavalue;
  int itemslot;
  List<String> cmds;
  List<String> desc;
  short damage;
  
  @SuppressWarnings("deprecation")
public GuiItem(int ammount, Material type, String itmname, short datavalue, int itemslot, List<String> cmds, List<String> desc, short damage)
  {
    itm = new ItemStack(type, ammount, damage, Byte.valueOf((byte)datavalue));
    ItemMeta im = itm.getItemMeta();
    im.setDisplayName(itmname);
    im.setLore(desc);
    itm.setItemMeta(im);
    this.ammount = ammount;
    this.type = type;
    this.itmname = itmname;
    this.datavalue = datavalue;
    this.itemslot = itemslot;
    this.cmds = cmds;
    this.desc = desc;
    this.damage = damage;
  }
  
  public ItemStack getItem()
  {
    return itm;
  }
  

  public short getItemDamage()
  {
    return damage;
  }
  
  public int getAmmount()
  {
    return ammount;
  }
  
  public Material getType()
  {
    return type;
  }
  
  public String getItemName()
  {
    return itmname;
  }
  
  public short getDataValue()
  {
    return datavalue;
  }
  
  public int getItemSlot()
  {
    return itemslot;
  }
  
  public List<String> getDescription()
  {
    return desc;
  }
  
  public List<String> getCommandsAssigned()
  {
    return cmds;
  }
  
  public void setItem(ItemStack itm)
  {
    this.itm = itm;
  }
  
  public void setAmmount(int ammount)
  {
    this.ammount = ammount;
  }
  
  public void setType(Material type)
  {
    this.type = type;
  }
  
  public void setItemName(String itmname)
  {
    this.itmname = itmname;
  }
  
  public void setDataValue(short datavalue)
  {
    this.datavalue = datavalue;
  }
  
  public void setItemSlot(int itemslot)
  {
    this.itemslot = itemslot;
  }
  
  public void setCommandsAssigned(List<String> cmds)
  {
    this.cmds = cmds;
  }
  
  public void setDescription(List<String> desc)
  {
    this.desc = desc;
  }
  
  public void setItemDamage(short damage)
  {
    this.damage = damage;
  }
  
  public void executeCommands(Player forwho) {
    for (String s : cmds) {
    	forwho.performCommand(s); 
        s.replace("{player}", forwho.getName());
    }
  }
}
