package de.emptyWorld.main.sellShop;

import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.HumanEntity;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import de.emptyWorld.main.sellShop.ShopInventory.OperationType;
import de.emptyWorld.main.sellShop.Phrases;
import de.emptyWorld.main.sellShop.Phrases.Vars;
import de.emptyWorld.main.sellShop.ConfigUtil;
import de.emptyWorld.main.sellShop.ItemUtil;
import de.emptyWorld.main.sellShop.SU;

public class Tab {
    private static HashMap<Inventory, Tab> tabs = new HashMap<Inventory, Tab>();
    private static HashMap<String, Tab> tabsSections = new HashMap<String, Tab>();
    private String name = "";
    private String saleReason = "";
    private String configurationSection = "";
    private double sale = 0.0D;
    private boolean vip = false;
    private ItemStack iconItem;
    private String permission;
    private List<ItemStack> sellItems = new ArrayList<ItemStack>();
    private List<ItemStack> buyItems = new ArrayList<ItemStack>();
    private List<ShopInventory> sellPages = new ArrayList<ShopInventory>();
    private List<ShopInventory> buyPages = new ArrayList<ShopInventory>();

    private Tab(String name, String configurationSection, String saleReason, String permission, ItemStack iconItem, double sale, boolean vip, List<ItemStack> buyItems, List<ItemStack> sellItems) {
        this.name = name.replace("&", "§");
        this.saleReason = saleReason.replace("&", "§");
        this.permission = permission;
        this.configurationSection = configurationSection.replace("_", " ");
        this.iconItem = iconItem;
        this.sale = sale > 100.0D?1.0D:sale / 100.0D;
        this.vip = vip;
        this.sellItems = sellItems;
        this.buyItems = buyItems;
        if(!vip) {
            this.sellPages = this.generatePages(sellItems, OperationType.SELL);
        }

        this.buyPages = this.generatePages(buyItems, OperationType.BUY);
        tabsSections.put(configurationSection, this);
    }


	public static Tab createTab(String name, String configurationSection, String saleReason, String permission, ItemStack iconItem, double sale, boolean vip, List<ItemStack> buyItems, List<ItemStack> sellItems) {
        if(name == null) {
            name = "";
        }

        if(configurationSection == null) {
            return null;
        } else if(configurationSection.isEmpty()) {
            return null;
        } else {
            if(saleReason == null) {
                saleReason = "";
            }

            if(permission == null) {
                permission = "";
            }

            if(!permission.isEmpty()) {
                permission = "shop." + (vip?"vip.":"tab.") + permission;
            }

            if(iconItem == null) {
                iconItem = new ItemStack(Material.BEDROCK, 0);
            }

            if(buyItems == null) {
                buyItems = new ArrayList<ItemStack>();
            }

            if(sellItems == null) {
                sellItems = new ArrayList<ItemStack>();
            }

            return new Tab(name, configurationSection, saleReason, permission, iconItem, sale, vip, (List<ItemStack>)buyItems, (List<ItemStack>)sellItems);
        }
    }

    public static Tab loadTab(String configurationSection) {
        if(configurationSection == null) {
            return null;
        } else if(configurationSection.isEmpty()) {
            return null;
        } else {
            FileConfiguration config = de.emptyWorld.main.leerWelt.getTabs();
            String name = config.getString(configurationSection + ".Name");
            String saleReason = config.getString(configurationSection + ".SaleReason");
            String permission = config.getString(configurationSection + ".Permission");
            ItemStack iconItem = ItemUtil.load(config.getConfigurationSection(configurationSection));
            double sale = config.getDouble(configurationSection + ".Sale") * 100.0D;
            List<ItemStack> buyItems = loadItems(configurationSection, false, OperationType.BUY);
            List<ItemStack> sellItems = loadItems(configurationSection, false, OperationType.SELL);
            return createTab(name, configurationSection, saleReason, permission, iconItem, sale, false, buyItems, sellItems);
        }
    }


	public static Tab loadVipTab(int index) {
        if(index <= 3 && index >= 1) {
            FileConfiguration config = de.emptyWorld.main.leerWelt.getMain();
            String configurationSection = "vipmenu" + String.valueOf(index);
            String name = config.getString(configurationSection + ".Name");
            String saleReason = config.getString(configurationSection + ".SaleReason");
            String permission = config.getString(configurationSection + ".Permission");
            ItemStack iconItem = ItemUtil.load(config.getConfigurationSection(configurationSection));
            double sale = config.getDouble(configurationSection + ".Sale") * 100.0D;
            List<ItemStack> buyItems = loadItems(configurationSection, true, OperationType.BUY);
            return createTab(name, configurationSection, saleReason, permission, iconItem, sale, true, buyItems, (List<ItemStack>)null);
        } else {
            return null;
        }
    }

    public static List<ItemStack> loadItems(String configurationSection, boolean vip, OperationType oType) {
        String first = vip?"vipmenu":"tabs";
        FileConfiguration config = ConfigUtil.loadYaml(de.emptyWorld.main.leerWelt.instance(), first + File.separator + configurationSection);
        String sType = SU.firstUpperCase(oType.name());
        List<ItemStack> items = new ArrayList<ItemStack>();
        Iterator<?> var8 = config.getKeys(false).iterator();

        while(var8.hasNext()) {
            String s = (String)var8.next();
            if(config.getDouble(s + "." + (vip?"":sType) + "Price") >= 0.0D) {
                List<String> lore = new ArrayList<String>();
                ItemStack item = ItemUtil.load(config.getConfigurationSection(s));
                if(item.hasItemMeta() && item.getItemMeta().hasLore()) {
                    lore.addAll(item.getItemMeta().getLore());
                }

                lore.add(SU.genStrng(Phrases.valueOf("PressTo" + sType).getMessage()));
                if(!vip) {
                    lore.add("Item ID: " + s);
                    lore.add(SU.genStrng(Phrases.valueOf(sType + "Cost").builder().replaceVar(Vars.COST, Double.toString(config.getDouble(s + "." + sType + "Price"))).buildMessage()));
                    lore.add(SU.genStrng(Phrases.valueOf(sType + "Cost16").builder().replaceVar(Vars.COST, Double.toString(config.getDouble(s + "." + sType + "Price") * 16.0D)).buildMessage()));
                    lore.add(SU.genStrng(Phrases.valueOf(sType + "Cost64").builder().replaceVar(Vars.COST, Double.toString(config.getDouble(s + "." + sType + "Price") * 64.0D)).buildMessage()));
                } else {
                    lore.add(SU.genStrng(Phrases.valueOf(sType + "Cost").builder().replaceVar(Vars.COST, Double.toString(config.getDouble(s + ".Price"))).buildMessage()));
                }

                ItemMeta im = item.getItemMeta();
                if(im != null) {
                    im.setLore(lore);
                    item.setItemMeta(im);
                }

                items.add(item);
            }
        }

        return items;
    }

    private List<ShopInventory> generatePages(List<ItemStack> items, OperationType oType) {
        List<ShopInventory> pages = new ArrayList<ShopInventory>();
        if(items == null) {
            items = new ArrayList<ItemStack>();
        }

        if(((List<ItemStack>)items).isEmpty()) {
            ((List<ItemStack>)items).add(new ItemStack(Material.AIR));
        }

        boolean havepages = ((List<ItemStack>)items).size() > 42;

        for(int j = 0; (double)j < Math.ceil((double)((List<ItemStack>)items).size() / 42.0D); ++j) {
            boolean lastpage = (double)(j + 1) >= Math.ceil((double)((List<ItemStack>)items).size() / 42.0D);
            int strings = lastpage?((int)Math.ceil((double)(((List<ItemStack>)items).size() - j * 42) / 7.0D) < 4 && havepages?4:(int)Math.ceil((double)(((List<ItemStack>)items).size() - j * 42) / 7.0D)):6;
            ShopInventory sinv = new ShopInventory((InventoryHolder)null, strings * 9, this.name, oType);
            Inventory inv = sinv.getInventory();
            if(this.vip) {
                inv.setItem(0, ItemUtil.load(de.emptyWorld.main.leerWelt.getMain().getConfigurationSection("Main")));
            } else {
                inv.setItem(0, ItemUtil.load(de.emptyWorld.main.leerWelt.getMain().getConfigurationSection(oType.name().toLowerCase() + "item")));
            }

            int slot;
            if(havepages) {
                ItemStack item = this.iconItem.clone();
                slot = (double)(j + 2) > Math.ceil((double)((List<ItemStack>)items).size() / 42.0D)?(int)Math.ceil((double)((List<ItemStack>)items).size() / 42.0D):j + 2;
                int prevp = j == 0?1:j;
                item.setAmount(prevp);
                inv.setItem(18, item);
                item.setAmount(slot);
                inv.setItem(27, item);
            }

            for(int i = j * 42; i < (j + 1) * 42; ++i) {
                slot = i - j * 42 + 2 * ((int)Math.ceil((double)((i - j * 42) / 7)) + 1);
                ItemStack item = ((ItemStack)((List<ItemStack>)items).get(i)).clone();
                if(item.hasItemMeta()) {
                    ItemMeta im = item.getItemMeta();
                    im.setLore(this.editLore(im.getLore()));
                    item.setItemMeta(im);
                }

                inv.setItem(slot, item);
                if(i + 1 >= ((List<ItemStack>)items).size()) {
                    break;
                }
            }

            sinv.setInventory(inv);
            pages.add(sinv);
            GUI.registerInventory(inv, sinv);
            this.registerTabInventory(inv);
        }

        return pages;
    }

    private List<String> editLore(List<String> lore) {
        if(this.sale <= 0.0D) {
            return lore;
        } else {
            List<String> strings = new ArrayList<String>();
            int stringcount = this.vip?1:3;
            int count = lore.size() - stringcount;

            for(int i = lore.size() - 1; i >= count; --i) {
                String s = (String)lore.get(i);
                Pattern pt = Pattern.compile("(.*) ([&§][0-9a-fklmnor])?(\\d+\\.?\\d+)(\\$)$");
                Matcher ma = pt.matcher(s);
                if(ma.matches()) {
                    double price = Double.parseDouble(ma.group(3));
                    String sprice = (new DecimalFormat("#0.00")).format(price - price * this.sale).replace(",", ".");
                    String text = ma.group(2) + ChatColor.STRIKETHROUGH + ma.group(3) + ma.group(4) + ChatColor.RESET + " " + ma.group(2) + sprice + ma.group(4);
                    s = s.replace(ma.group(3) + ma.group(4), text);
                    strings.add(s);
                    lore.remove(i);
                }
            }

            Collections.reverse(strings);
            strings.add(Phrases.Sale.builder().replaceVar(Vars.DISCOUNT, Double.toString(this.sale * 100.0D)).replaceVar(Vars.REASON, this.saleReason).buildMessage());
            lore.addAll(strings);
            return lore;
        }
    }

    public void closeTab() {
        List<ShopInventory> sinvs = new ArrayList<ShopInventory>();
        sinvs.addAll(this.getBuyPages());
        sinvs.addAll(this.getSellPages());
        Iterator<ShopInventory> var3 = sinvs.iterator();

        while(var3.hasNext()) {
            ShopInventory sinv = (ShopInventory)var3.next();
            Iterator<?> var5 = sinv.getInventory().getViewers().iterator();

            while(var5.hasNext()) {
                HumanEntity h = (HumanEntity)var5.next();
                h.closeInventory();
            }
        }

    }

    public void unregisterTab() {
        List<ShopInventory> sinvs = new ArrayList<ShopInventory>();
        sinvs.addAll(this.getBuyPages());
        sinvs.addAll(this.getSellPages());
        Iterator<ShopInventory> var3 = sinvs.iterator();

        while(var3.hasNext()) {
            ShopInventory sinv = (ShopInventory)var3.next();
            tabs.remove(sinv.getInventory());
            GUI.unregisterInventory(sinv.getInventory());
        }

    }

    private void registerTabInventory(Inventory inventory) {
        tabs.put(inventory, this);
    }

    public Inventory getPage(int page, OperationType oType) {
        page = page - 1 < 0?1:page;
        return oType != OperationType.BUY && !this.vip?(oType == OperationType.SELL?((ShopInventory)this.getSellPages().get(page - 1 >= this.getSellPages().size()?this.getSellPages().size():page - 1)).getInventory():null):((ShopInventory)this.getBuyPages().get(page - 1 >= this.getBuyPages().size()?this.getBuyPages().size() - 1:page - 1)).getInventory();
    }

    public void setSale(double sale, String saleReason) {
        this.sale = sale > 100.0D?1.0D:sale / 100.0D;
        this.saleReason = saleReason.replace("&", "§");
        FileConfiguration config = this.vip?de.emptyWorld.main.leerWelt.getMain():de.emptyWorld.main.leerWelt.getTabs();
        if(sale == 0.0D) {
            config.set(this.configurationSection + ".Sale", (Object)null);
            config.set(this.configurationSection + ".SaleReason", (Object)null);
        } else {
            config.set(this.configurationSection + ".Sale", Double.valueOf(this.sale));
            config.set(this.configurationSection + ".SaleReason", this.saleReason.replace("§", "&"));
        }

        String path = this.vip?"main.yml":"tabs.yml";
        File file = new File(de.emptyWorld.main.leerWelt.instance().getDataFolder(), path);
        de.emptyWorld.main.leerWelt.instance().save(config, file);
        this.unregisterTab();
        this.getBuyPages().clear();
        this.getBuyPages().addAll(this.generatePages(this.getBuyItems(), OperationType.BUY));
        if(!this.vip) {
            this.getSellPages().clear();
            this.getSellPages().addAll(this.generatePages(this.getSellItems(), OperationType.SELL));
        }

    }

    public static HashMap<Inventory, Tab> getTabs() {
        return tabs;
    }

    public static HashMap<String, Tab> getTabsSections() {
        return tabsSections;
    }

    public static Tab getTab(String cofigurationSection) {
        return (Tab)tabsSections.get(cofigurationSection.replace("_", " "));
    }

    public static Tab getTab(Inventory inventory) {
        return (Tab)tabs.get(inventory);
    }

    public String getName() {
        return this.name;
    }

    public String getSaleReason() {
        return this.saleReason;
    }

    public String getConfigurationSection() {
        return this.configurationSection;
    }

    public double getSale() {
        return this.sale * 100.0D;
    }

    public boolean isVip() {
        return this.vip;
    }

    public ItemStack getIconItem() {
        return this.iconItem;
    }

    public String getPermission() {
        return this.permission;
    }

    public List<ItemStack> getSellItems() {
        return this.sellItems;
    }

    public List<ItemStack> getBuyItems() {
        return this.buyItems;
    }

    public List<ShopInventory> getSellPages() {
        return this.sellPages;
    }

    public List<ShopInventory> getBuyPages() {
        return this.buyPages;
    }
}
