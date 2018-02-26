package de.emptyWorld.main.enchants.util;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.inventory.ItemStack;

import de.emptyWorld.main.leerWelt;


public class DAMAGEALL extends Enchantment{
	
	  leerWelt plugin;


	  public DAMAGEALL(int id) {
		 
	      super(id);
	  }

	  @Override
	  public boolean canEnchantItem(ItemStack arg0) {
	      return false;
	  }

	  @Override
	  public boolean conflictsWith(Enchantment arg0) {
	      return false;
	  }

	  @Override
	  public EnchantmentTarget getItemTarget() {
	      return null;
	  }

	  @Override
	  public int getMaxLevel() {
	      return 0;
	  }

	  @Override
	  public String getName() {
	      return null;
	  }

	  @Override
	  public int getStartLevel() {
	      return 0;
	  }

	@Override
	public boolean isCursed() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isTreasure() {
		// TODO Auto-generated method stub
		return false;
	}}

	

