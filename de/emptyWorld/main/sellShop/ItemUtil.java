package de.emptyWorld.main.sellShop;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemUtil {
    public ItemUtil() {
    }

    public static ItemStack create(Material material, int ammount, short data, String dname, List<String> lore) {
        if(material == null) {
            material = Material.BEDROCK;
        }

        ItemStack item = new ItemStack(material, ammount, data);
        ItemMeta meta = item.getItemMeta();
        if(meta == null) {
            return item;
        } else {
            if(dname != null && !dname.isEmpty()) {
                meta.setDisplayName(dname.replace("&", "§"));
            }

            if(lore != null) {
                int k = 0;

                for(Iterator<String> var9 = lore.iterator(); var9.hasNext(); ++k) {
                    String s = (String)var9.next();
                    s = s.replace("&", "§");
                    lore.set(k, s);
                }
            }

            meta.setLore(lore);
            item.setItemMeta(meta);
            return item;
        }
    }

    public static ItemStack load(ConfigurationSection key) {
        String name = key.getString("Name");
        String itemtype = key.getString("ID");
        int data = 0;
        int ammount = key.getInt("Ammount") < 1?1:key.getInt("Ammount");
        if(SU.isNumeric(key.getString("Data"))) {
            data = key.getInt("Data");
        } else {
            data = 0;
        }

        Material material = Material.matchMaterial(itemtype);
        List<String> lore = new ArrayList<String>(key.getStringList("Lore"));
        ItemStack item = create(material, ammount, (short)data, name, lore);
        item.setItemMeta(getSpecialMeta(item, key));
        return item;
    }

    public static ItemMeta getSpecialMeta(ItemStack item, ConfigurationSection key) {
        item = item.clone();
        if(key.getKeys(false).contains("Monster")) {
            item.setItemMeta(ItemMetaUtil.getMonsterMeta(key.getString("Monster"), item));
        }

        if(key.getKeys(false).contains("Enchantments")) {
            item.setItemMeta(ItemMetaUtil.getEnchantmentsMeta(key.getString("Enchantments"), item));
        }

        if(key.getKeys(false).contains("Color")) {
            item.setItemMeta(ItemMetaUtil.getColorMeta(key.getString("Color"), item));
        }

        return item.getItemMeta();
    }
}
