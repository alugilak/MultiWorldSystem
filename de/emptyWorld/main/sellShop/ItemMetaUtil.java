package de.emptyWorld.main.sellShop;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.EnchantmentStorageMeta;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import de.emptyWorld.main.sellShop.AllHandler;
import de.emptyWorld.main.sellShop.Phrases;

public class ItemMetaUtil {
    public ItemMetaUtil() {
    }

    public static Class<?> getNmsClass(String className) throws ClassNotFoundException {
        return Class.forName("net.minecraft.server." + de.emptyWorld.main.leerWelt.instance().getServer().getClass().getPackage().getName().replace(".", ",").split(",")[3] + "." + className);
    }

    public static Class<?> getCraftbukkitClass(String className) throws ClassNotFoundException {
        return Class.forName("org.bukkit.craftbukkit." + de.emptyWorld.main.leerWelt.instance().getServer().getClass().getPackage().getName().replace(".", ",").split(",")[3] + "." + className);
    }

    public static ItemMeta getFireworkMeta(String data, ItemStack item) {
        item = item.clone();
        if(item.getType() != Material.FIREWORK) {
            return item.getItemMeta();
        } else if(data == null) {
            return item.getItemMeta();
        } else if(data.isEmpty()) {
            return item.getItemMeta();
        } else {
            FireworkMeta fm = (FireworkMeta)item.getItemMeta();
            String[] var6;
            int var5 = (var6 = data.toLowerCase().split(" ")).length;

            for(int var4 = 0; var4 < var5; ++var4) {
                String s = var6[var4];
                if(s.startsWith("power:")) {
                    s = s.replace("power:", "");
                    if(SU.isNumeric(s)) {
                        fm.setPower(Integer.parseInt(s));
                    }
                }
            }

            return item.getItemMeta();
        }
    }

    public static ItemMeta getColorMeta(String data, ItemStack item) {
        item = item.clone();
        if(item.getType() != Material.LEATHER_BOOTS && item.getType() != Material.LEATHER_CHESTPLATE && item.getType() != Material.LEATHER_HELMET && item.getType() != Material.LEATHER_LEGGINGS) {
            return item.getItemMeta();
        } else if(data == null) {
            return item.getItemMeta();
        } else if(data.isEmpty()) {
            return item.getItemMeta();
        } else {
            LeatherArmorMeta meta;
            int red;
            int green;
            int blue;
            if(data.startsWith("#")) {
                data = data.substring(1).toUpperCase();
                if(data.length() != 3 && data.length() != 6) {
                    return item.getItemMeta();
                }

                if(data.length() == 3) {
                    meta = (LeatherArmorMeta)item.getItemMeta();
                    red = fromHEXtoRGB(data.substring(0, 0) + data.substring(0, 0));
                    green = fromHEXtoRGB(data.substring(1, 1) + data.substring(1, 1));
                    blue = fromHEXtoRGB(data.substring(2, 2) + data.substring(2, 2));
                    meta.setColor(Color.fromRGB(red, green, blue));
                    return meta;
                }

                if(data.length() == 6) {
                    meta = (LeatherArmorMeta)item.getItemMeta();
                    red = fromHEXtoRGB(data.substring(0, 1));
                    green = fromHEXtoRGB(data.substring(2, 3));
                    blue = fromHEXtoRGB(data.substring(4, 5));
                    meta.setColor(Color.fromRGB(red, green, blue));
                    return meta;
                }
            }

            if(data.split(",").length == 3) {
                meta = (LeatherArmorMeta)item.getItemMeta();
                if(SU.isNumeric(data.split(",")[0]) && SU.isNumeric(data.split(",")[1]) && SU.isNumeric(data.split(",")[2])) {
                    red = Integer.parseInt(data.split(",")[0]);
                    green = Integer.parseInt(data.split(",")[1]);
                    blue = Integer.parseInt(data.split(",")[2]);
                    meta.setColor(Color.fromRGB(red, green, blue));
                    return meta;
                } else {
                    return item.getItemMeta();
                }
            } else {
                return item.getItemMeta();
            }
        }
    }

    public static ItemMeta getEnchantmentsMeta(String data, ItemStack item) {
        item = item.clone();
        if(data == null) {
            return item.getItemMeta();
        } else if(data.isEmpty()) {
            return item.getItemMeta();
        } else {
            String[] var5;
            int var4 = (var5 = data.split(" ")).length;

            for(int var3 = 0; var3 < var4; ++var3) {
                String s = var5[var3];
                if(s != null && !s.isEmpty() && s.contains(",")) {
                    String[] enchAndLvl = s.split(",");
                    String enchantment = enchAndLvl[0].toUpperCase();
                    int lvl = SU.isNumeric(enchAndLvl[1])?Integer.parseInt(enchAndLvl[1]):1;

                    try {
                        if(item.getType() == Material.ENCHANTED_BOOK) {
                            EnchantmentStorageMeta enchStorageMeta = (EnchantmentStorageMeta)item.getItemMeta();
                            enchStorageMeta.addStoredEnchant(Enchantment.getByName(enchantment), lvl, false);
                            item.setItemMeta(enchStorageMeta);
                        } else if(Enchantment.getByName(enchantment) != null) {
                            item.addUnsafeEnchantment(Enchantment.getByName(enchantment), lvl);
                        } else {
                            List<String> lore = new ArrayList<String>();
                            if(item.hasItemMeta() && item.getItemMeta().hasLore()) {
                                lore.addAll(item.getItemMeta().getLore());
                            }

                            lore.add("§cEnchantment \"" + enchantment + "\" §cdoes not exist");
                            ItemMeta im = item.getItemMeta();
                            im.setLore(lore);
                            item.setItemMeta(im);
                        }
                    } catch (Exception var12) {
                        Bukkit.getConsoleSender().sendMessage("§cHay! There was an exception. Please report it!");
                        var12.printStackTrace();
                        List<String> lore = new ArrayList<String>();
                        if(item.hasItemMeta() && item.getItemMeta().hasLore()) {
                            lore.addAll(item.getItemMeta().getLore());
                        }

                        lore.add(SU.genStrng(Phrases.Error.getMessage()));
                        ItemMeta im = item.getItemMeta();
                        im.setLore(lore);
                        item.setItemMeta(im);
                    }
                }
            }

            return item.getItemMeta();
        }
    }

    public static ItemMeta getMonsterMeta(String data, ItemStack item) {
        item = item.clone();
        if(data == null) {
            return item.getItemMeta();
        } else if(data.isEmpty()) {
            return item.getItemMeta();
        } else {
            Object nmsStack;
            Object tag;
            Object nested;
            if(item.getType() == Material.MONSTER_EGG) {
                try {
                    nmsStack = getCraftbukkitClass("inventory.CraftItemStack").getMethod("asNMSCopy", new Class[]{ItemStack.class}).invoke((Object)null, new Object[]{item});
                    tag = ((Boolean)nmsStack.getClass().getMethod("hasTag", new Class[0]).invoke(nmsStack, new Object[0])).booleanValue()?nmsStack.getClass().getMethod("getTag", new Class[0]).invoke(nmsStack, new Object[0]):getNmsClass("NBTTagCompound").newInstance();
                    nested = getNmsClass("NBTTagCompound").newInstance();
                    nested.getClass().getMethod("setString", new Class[]{String.class, String.class}).invoke(nested, new Object[]{"id", data});
                    tag.getClass().getMethod("set", new Class[]{String.class, getNmsClass("NBTBase")}).invoke(tag, new Object[]{"EntityTag", nested});
                    nmsStack.getClass().getMethod("setTag", new Class[]{getNmsClass("NBTTagCompound")}).invoke(nmsStack, new Object[]{tag});
                    item = (ItemStack)getCraftbukkitClass("inventory.CraftItemStack").getMethod("asBukkitCopy", new Class[]{getNmsClass("ItemStack")}).invoke((Object)null, new Object[]{nmsStack});
                    return item.getItemMeta();
                } catch (InvocationTargetException | InstantiationException | NoSuchMethodException | SecurityException | ClassNotFoundException | IllegalAccessException var6) {
                    de.emptyWorld.main.leerWelt.instance().getServer().getLogger().log(Level.SEVERE, "I don't want create a monster egg for you. sorry");
                    return item.getItemMeta();
                } catch (IllegalArgumentException var7) {
                    de.emptyWorld.main.leerWelt.instance().getServer().getLogger().log(Level.SEVERE, "Hey, There was an error while creating Monster Egg. check for monster type in config.");
                    de.emptyWorld.main.leerWelt.instance().getServer().getLogger().log(Level.INFO, "Printing monster type from config for You...");
                    de.emptyWorld.main.leerWelt.instance().getServer().getLogger().log(Level.INFO, data);
                    return item.getItemMeta();
                }
            } else if(item.getType() == Material.MOB_SPAWNER) {
                try {
                    nmsStack = getCraftbukkitClass("inventory.CraftItemStack").getMethod("asNMSCopy", new Class[]{ItemStack.class}).invoke((Object)null, new Object[]{item});
                    tag = ((Boolean)nmsStack.getClass().getMethod("hasTag", new Class[0]).invoke(nmsStack, new Object[0])).booleanValue()?nmsStack.getClass().getMethod("getTag", new Class[0]).invoke(nmsStack, new Object[0]):getNmsClass("NBTTagCompound").newInstance();
                    nested = getNmsClass("NBTTagCompound").newInstance();
                    nested.getClass().getMethod("setString", new Class[]{String.class, String.class}).invoke(nested, new Object[]{"Entity", data});
                    tag.getClass().getMethod("set", new Class[]{String.class, getNmsClass("NBTBase")}).invoke(tag, new Object[]{"BlcSpawnData", nested});
                    nmsStack.getClass().getMethod("setTag", new Class[]{getNmsClass("NBTTagCompound")}).invoke(nmsStack, new Object[]{tag});
                    item = (ItemStack)getCraftbukkitClass("inventory.CraftItemStack").getMethod("asBukkitCopy", new Class[]{getNmsClass("ItemStack")}).invoke((Object)null, new Object[]{nmsStack});
                    ItemMeta im = item.getItemMeta();
                    if(im.getDisplayName() == null) {
                        im.setDisplayName("§r" + AllHandler.getCreatureType(item) + " spawner");
                        item.setItemMeta(im);
                    }

                    return item.getItemMeta();
                } catch (InvocationTargetException | InstantiationException | NoSuchMethodException | SecurityException | ClassNotFoundException | IllegalAccessException var8) {
                    var8.printStackTrace();
                    de.emptyWorld.main.leerWelt.instance().getServer().getLogger().log(Level.SEVERE, "I don't want create a Mob Spawner for you. sorry");
                    return item.getItemMeta();
                } catch (IllegalArgumentException var9) {
                    de.emptyWorld.main.leerWelt.instance().getServer().getLogger().log(Level.SEVERE, "Hey, There was an error while creating Mob Spawner. check for monster type in config.");
                    de.emptyWorld.main.leerWelt.instance().getServer().getLogger().log(Level.INFO, "Printing monster type from config for You...");
                    de.emptyWorld.main.leerWelt.instance().getServer().getLogger().log(Level.INFO, data);
                    return item.getItemMeta();
                }
            } else {
                return item.getItemMeta();
            }
        }
    }

    private static int fromHEXtoRGB(String hex) {
        if(hex.length() != 2) {
            return 0;
        } else if(!hex.matches("[0-9A-Fa-f]")) {
            return 0;
        } else {
            int color = letterToInt(hex.toUpperCase().charAt(0)) * 16 + letterToInt(hex.toUpperCase().charAt(1));
            return color;
        }
    }

    private static int letterToInt(char a) {
        switch(a) {
            case 'A':
                return 10;
            case 'B':
                return 11;
            case 'C':
                return 12;
            case 'D':
                return 13;
            case 'E':
                return 14;
            case 'F':
                return 15;
            default:
                return -1;
        }
    }
}
