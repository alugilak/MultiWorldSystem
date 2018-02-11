package de.emptyWorld.main.objects;

import java.util.List;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public abstract class AbstractGuiItem
{
  public AbstractGuiItem() {}
  
  public abstract ItemStack getItem();
  
  public abstract int getAmmount();
  
  public abstract Material getType();
  
  public abstract String getItemName();
  
  public abstract short getDataValue();
  
  public abstract int getItemSlot();
  
  public abstract List<String> getDescription();
  
  public abstract List<String> getCommandsAssigned();
  
  public abstract short getItemDamage();
  
  public abstract void setItem(ItemStack paramItemStack);
  
  public abstract void setAmmount(int paramInt);
  
  public abstract void setType(Material paramMaterial);
  
  public abstract void setItemName(String paramString);
  
  public abstract void setDataValue(short paramShort);
  
  public abstract void setItemSlot(int paramInt);
  
  public abstract void setDescription(List<String> paramList);
  
  public abstract void setCommandsAssigned(List<String> paramList);
  
  public abstract void setItemDamage(short paramShort);
}
