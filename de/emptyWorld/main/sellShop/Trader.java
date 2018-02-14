package de.emptyWorld.main.sellShop;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import de.emptyWorld.main.sellShop.PlayerTradeEvent;
import de.emptyWorld.main.sellShop.Tab;
import de.emptyWorld.main.sellShop.ShopInventory.OperationType;
import de.emptyWorld.main.leerWelt;
import de.emptyWorld.main.sellShop.Lang;
import de.emptyWorld.main.sellShop.Phrases;
import de.emptyWorld.main.sellShop.Phrases.Vars;
import de.emptyWorld.main.sellShop.SU;

public class Trader {
    public Trader() {
    }

    public static void sellItem(Player p, ItemStack item, int amount, Tab tab) {
        item = item.clone();
        double sale = tab.getSale();
        sale = sale <= 0.0D?1.0D:sale / 100.0D;
        double price = getPrice(item);
        item = clearLore(item, "Sell");
        if(getItemsCount(p, item) == 0) {
            p.sendMessage(SU.genMessage(Phrases.NoItems.getMessage()));
        } else {
            amount = getItemsCount(p, item) >= amount?amount:getItemsCount(p, item);
            PlayerTradeEvent trade = new PlayerTradeEvent(p, item, OperationType.SELL, amount, sale, price);
            Bukkit.getPluginManager().callEvent(trade);
            String message;
            if(trade.isCancelled()) {
                message = trade.getMessage();
                if(message != null) {
                    if(!message.isEmpty()) {
                        p.sendMessage(message.replace("&", "§"));
                    }
                }
            } else {
                amount = trade.getAmount();
                price = trade.getPrice();
                sale = trade.getSale();
                amount = getItemsCount(p, item) >= amount?amount:getItemsCount(p, item);
                removeItemByAmount(p, item, amount);
                message = item.hasItemMeta()?(item.getItemMeta().hasDisplayName()?item.getItemMeta().getDisplayName() + "&r":item.getType().toString() + "(" + item.getDurability() + ")"):item.getType().toString() + "(" + item.getDurability() + ")";
                leerWelt.econ.depositPlayer(p, price * (double)amount * sale);
                p.sendMessage(SU.genMessage(Phrases.SuccesSold.builder().replaceVar(Vars.ITEM, message).replaceVar(Vars.COUNT, String.valueOf(amount)).replaceVar(Vars.COST, (new BigDecimal(price * (double)amount * sale)).setScale(0, RoundingMode.HALF_DOWN).toString()).buildMessage()));
                leerWelt.instance().log(Phrases.LogFormat.builder().replaceVar(Vars.ITEM, message).replaceVar(Vars.COUNT, String.valueOf(amount)).replaceVar(Vars.COST, (new BigDecimal(price * (double)amount * sale)).setScale(0, RoundingMode.HALF_DOWN).toString()).replaceVar(Vars.DISCOUNT, String.valueOf(tab.getSale())).replaceVar(Vars.REASON, tab.getSaleReason()).buildMessage().replace("{player}", p.getName()).replace("{operation}", Lang.getString("Sold")).replace("{tab}", tab.getName()));
            }
        }
    }

    public static void buyItem(Player p, ItemStack item, int amount, Tab tab) {
        item = item.clone();
        double sale = tab.getSale();
        sale = sale <= 0.0D?1.0D:sale / 100.0D;
        double price = getPrice(item);
        item = clearLore(item, "Buy");
        if(getFreeSpaceForItem(p, item) <= 0) {
            p.sendMessage(SU.genMessage(Phrases.NoPlace.getMessage()));
        } else {
            amount = getFreeSpaceForItem(p, item) < amount?getFreeSpaceForItem(p, item):amount;
            if(!leerWelt.econ.has(p, price * (double)amount * sale)) {
                p.sendMessage(SU.genMessage(Phrases.NoMoney.getMessage()));
            } else {
                PlayerTradeEvent trade = new PlayerTradeEvent(p, item, OperationType.BUY, amount, sale, price);
                Bukkit.getPluginManager().callEvent(trade);
                String message;
                if(trade.isCancelled()) {
                    message = trade.getMessage();
                    if(message != null) {
                        if(!message.isEmpty()) {
                            p.sendMessage(message.replace("&", "§"));
                        }
                    }
                } else {
                    amount = trade.getAmount();
                    price = trade.getPrice();
                    sale = trade.getSale();
                    amount = getFreeSpaceForItem(p, item) < amount?getFreeSpaceForItem(p, item):amount;
                    if(!leerWelt.econ.has(p, price * (double)amount * sale)) {
                        p.sendMessage(SU.genMessage(Phrases.NoMoney.getMessage()));
                    } else {
                        item.setAmount(amount);
                        message = item.hasItemMeta()?(item.getItemMeta().hasDisplayName()?item.getItemMeta().getDisplayName() + "&r":item.getType().toString() + "(" + item.getDurability() + ")"):item.getType().toString() + "(" + item.getDurability() + ")";
                        leerWelt.econ.withdrawPlayer(p, price * (double)amount * sale);
                        p.getInventory().addItem(new ItemStack[]{item});
                        p.sendMessage(SU.genMessage(Phrases.SuccesBought.builder().replaceVar(Vars.ITEM, message).replaceVar(Vars.COUNT, String.valueOf(amount)).replaceVar(Vars.COST, (new BigDecimal(price * (double)amount * sale)).setScale(0, RoundingMode.HALF_DOWN).toString()).buildMessage()));
                        leerWelt.instance().log(Phrases.LogFormat.builder().replaceVar(Vars.ITEM, message).replaceVar(Vars.COUNT, String.valueOf(amount)).replaceVar(Vars.COST, (new BigDecimal(price * (double)amount * sale)).setScale(0, RoundingMode.HALF_DOWN).toString()).replaceVar(Vars.DISCOUNT, String.valueOf(tab.getSale())).replaceVar(Vars.REASON, tab.getSaleReason()).buildMessage().replace("{player}", p.getName()).replace("{operation}", Lang.getString("Bought")).replace("{tab}", tab.getName()));
                    }
                }
            }
        }
    }

    public static ItemStack clearLore(ItemStack item, String operationtype) {
        operationtype = SU.firstUpperCase(operationtype);
        if(item == null) {
            return item;
        } else if(item.getType() == Material.AIR) {
            return item;
        } else if(item.getItemMeta() == null) {
            return item;
        } else if(item.getItemMeta().getLore() == null) {
            return item;
        } else if(item.getItemMeta().getLore().isEmpty()) {
            return item;
        } else {
            List<String> lore = new ArrayList<String>();

            for(int i = 0; i < item.getItemMeta().getLore().size(); ++i) {
                String s = (String)item.getItemMeta().getLore().get(i);
                if(s.equals(SU.genStrng(Phrases.valueOf("PressTo" + operationtype).getMessage()))) {
                    break;
                }

                lore.add(s);
            }

            ItemMeta im = item.getItemMeta();
            im.setLore(lore);
            item.setItemMeta(im);
            return item;
        }
    }

    public static double getPrice(ItemStack item) {
        if(item == null) {
            return -1.0D;
        } else if(item.getType() == Material.AIR) {
            return -1.0D;
        } else if(item.getItemMeta() == null) {
            return -1.0D;
        } else if(item.getItemMeta().getLore() == null) {
            return -1.0D;
        } else if(item.getItemMeta().getLore().isEmpty()) {
            return -1.0D;
        } else {
            for(int i = item.getItemMeta().getLore().size() - 5 > 0?item.getItemMeta().getLore().size() - 5:0; i < item.getItemMeta().getLore().size(); ++i) {
                String s = (String)item.getItemMeta().getLore().get(i);
                String sub = Phrases.SellCost.getMessage().substring(0, Phrases.SellCost.getMessage().indexOf("{cost}"));
                if(s.startsWith(sub)) {
                    s = s.substring(Phrases.SellCost.getMessage().indexOf("{cost}"));
                } else {
                    sub = Phrases.BuyCost.getMessage().substring(0, Phrases.BuyCost.getMessage().indexOf("{cost}"));
                    if(s.startsWith(sub)) {
                        s = s.substring(Phrases.BuyCost.getMessage().indexOf("{cost}"));
                    }
                }

                s = ChatColor.stripColor(s);
                Pattern pt = Pattern.compile("^(\\d+\\.\\d+)(.*)");
                Matcher ma = pt.matcher(s);
                if(ma.matches()) {
                    double price = Double.parseDouble(ma.group(1));
                    return price;
                }
            }

            return -1.0D;
        }
    }

    public static void removeItemByAmount(Player p, ItemStack item, int amount) {
        for(int a = 0; a < p.getInventory().getSize(); ++a) {
            if(amount == 0) {
                return;
            }

            if(
                    p.getInventory().getItem(a) != null &&
                    p.getInventory().getItem(a).getType() != Material.AIR &&
                    p.getInventory().getItem(a).getData().equals(item.getData()) &&
                    p.getInventory().getItem(a).getItemMeta().equals(item.getItemMeta())) {

                if(p.getInventory().getItem(a).getAmount() > amount) {
                    p.getInventory().getItem(a).setAmount(p.getInventory().getItem(a).getAmount() - amount);
                    //fixme:
                    //int amount = false;
                    return;
                }

                if(p.getInventory().getItem(a).getAmount() <= amount) {
                    amount -= p.getInventory().getItem(a).getAmount();
                    p.getInventory().setItem(a, new ItemStack(Material.AIR));
                    if(amount == 0) {
                        return;
                    }
                }
            }
        }

    }

    public static int getFreeSpaceForItem(Player p, ItemStack item) {
        int freespace = 0;
        Inventory inv = p.getInventory();

        for(int i = 0; i < inv.getSize() - 5; ++i) {
            if(inv.getItem(i) == null) {
                freespace += item.getMaxStackSize();
            } else if(inv.getItem(i).getType() == Material.AIR) {
                freespace += item.getMaxStackSize();
            } else if(inv.getItem(i).getData().equals(item.getData()) && inv.getItem(i).getItemMeta().equals(item.getItemMeta())) {
                freespace += inv.getItem(i).getMaxStackSize() - inv.getItem(i).getAmount();
            }
        }

        return freespace;
    }

    public static int getItemsCount(Player p, ItemStack item) {
        int totalam = 0;

        for(int a = 0; a < p.getInventory().getSize(); ++a) {
            if(p.getInventory().getItem(a) != null && p.getInventory().getItem(a).getData().equals(item.getData()) && p.getInventory().getItem(a).getItemMeta().equals(item.getItemMeta())) {
                totalam += p.getInventory().getItem(a).getAmount();
            }
        }

        return totalam;
    }
}
