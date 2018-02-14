package de.emptyWorld.main.sellShop;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import de.emptyWorld.main.sellShop.GUI;
import de.emptyWorld.main.sellShop.Tab;
import de.emptyWorld.main.sellShop.Phrases;
import de.emptyWorld.main.sellShop.Phrases.Vars;
import de.emptyWorld.main.leerWelt;
import de.emptyWorld.main.sellShop.ConfigUtil;
import de.emptyWorld.main.sellShop.SU;

public class Cmds implements CommandExecutor {
    public Cmds(leerWelt leerWelt) {
        
        de.emptyWorld.main.leerWelt.instance().getCommand("shop").setTabCompleter(new Cmds.CmdsTabCompleter(null));
    }

    public boolean onCommand(CommandSender sender, Command cmd, String str, String[] args) {
        switch(args.length) {
            case 0:
                if(sender.equals(Bukkit.getConsoleSender()) && args.length == 0) {
                    sender.sendMessage("§cOnly for players");
                    return true;
                } else {
                    Player p = (Player)sender;
                    if(!p.hasPermission("shop.use")) {
                        p.sendMessage(SU.genMessage(Phrases.NoPermission.getMessage()));
                        return true;
                    } else if(p.getGameMode() == GameMode.CREATIVE && !p.hasPermission("shop.gamemode")) {
                        p.sendMessage(SU.genMessage(Phrases.CreativePermission.getMessage()));
                        return true;
                    } else if(!p.hasPermission("shop.use")) {
                        p.sendMessage(SU.genMessage(Phrases.NoPermission.getMessage()));
                        return true;
                    } else {
                        GUI.openMain(p);
                        p.sendMessage(SU.genMessage(Phrases.InShop.getMessage()));
                        return true;
                    }
                }
            case 1:
                if(args[0].equalsIgnoreCase("help") || !args[0].equalsIgnoreCase("reload") && !args[0].equalsIgnoreCase("setsale")) {
                    break;
                }

                if(args[0].equalsIgnoreCase("setsale")) {
                    sender.sendMessage("§a/shop setsale <tab_name> <sale in percentages> [sale_Reason] §6use \"_\" instead \" \"");
                    return true;
                }

                if(!sender.hasPermission("shop.reload") && args.length == 1 && args[0].toLowerCase().equalsIgnoreCase("reload")) {
                    sender.sendMessage(SU.genMessage(Phrases.NoPermission.getMessage()));
                    return true;
                }

                leerWelt.instance().reloadPlugin();
                sender.sendMessage(SU.genMessage(Phrases.Reloaded.getMessage()));
                return true;
            case 2:
            default:
                if(args[0].equalsIgnoreCase("setsale")) {
                    sender.sendMessage("§a/shop setsale <tab_name> <sale in percentages> [sale_Reason] §6use \"_\" instead \" \"");
                    return true;
                }
                break;
            case 3:
                if(args[0].equalsIgnoreCase("setsale")) {
                    double sale = 0.0D;
                    if(!SU.isNumeric(args[2])) {
                        sender.sendMessage(SU.genMessage(Phrases.NotNomber.builder().replaceVar(Vars.STRING, args[2]).buildMessage()));
                        return true;
                    }

                    sale = Double.parseDouble(args[2]);
                    if(!args[1].equalsIgnoreCase("all")) {
                        Tab tab = Tab.getTab(args[1].replace("_", " "));
                        if(tab == null) {
                            sender.sendMessage(SU.genMessage(Phrases.TabNotFound.builder().replaceVar(Vars.TAB, args[1]).buildMessage()));
                            printTabs(sender);
                            return true;
                        }

                        tab.setSale(sale, "");
                        sender.sendMessage(SU.genMessage(Phrases.SaleInstalled.builder().replaceVar(Vars.TAB, args[1]).replaceVar(Vars.DISCOUNT, args[2]).replaceVar(Vars.REASON, "").buildMessage()));
                        return true;
                    }

                    Iterator<String> var14 = Tab.getTabsSections().keySet().iterator();

                    while(var14.hasNext()) {
                        String s = (String)var14.next();
                        Tab.getTab(s).setSale(sale, "");
                    }

                    sender.sendMessage(SU.genMessage(Phrases.SaleInstalled.builder().replaceVar(Vars.TAB, args[1]).replaceVar(Vars.DISCOUNT, args[2]).replaceVar(Vars.REASON, "").buildMessage()));
                    return true;
                }
                break;
            case 4:
                boolean found = false;
                if(args[0].equalsIgnoreCase("setprice")) {
                    if(!sender.hasPermission("shop.setprice")) {
                        sender.sendMessage(SU.genMessage(Phrases.NoPermission.getMessage()));
                        return true;
                    }
                    FileConfiguration rootLevel = ConfigUtil.loadYaml(leerWelt.instance(), "tabs");
                    Set<String> categoryList = rootLevel.getKeys(false);
                    for (String categoryElement : categoryList) {
                        FileConfiguration category = ConfigUtil.loadYaml(leerWelt.instance(), "tabs" + File.separator + categoryElement);
                        if (category != null) {
                            if (category.contains(args[1] + ".BuyPrice")) {
                                
								@SuppressWarnings("unused")
								double priceBuy = category.getDouble(args[1] + ".BuyPrice");
                                
								@SuppressWarnings("unused")
								double priceSell = category.getDouble(args[1] + ".SellPrice");
                                category.set(args[1] + ".BuyPrice", new Double(args[2]));
                                category.set(args[1] + ".SellPrice", new Double(args[3]));
                                try {
                                    PrintWriter out = new PrintWriter(leerWelt.getPluginDataFolder() + File.separator + "tabs" + File.separator + categoryElement + ".yml");
                                    out.println(category.saveToString());
                                    out.close();
                                    sender.sendMessage("§aUpdated " + args[1] + ": Buy $" + args[2] + ", Sell $" + args[3]);
                                    found = true;
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                break;
                            }
                        }
                    }
                    if (!found) {
                        sender.sendMessage("§aItem §6" + args[1] + " §anot found! Use §5Item ID §afrom /shop");
                    }
                    return true;
                }

                if(args[0].equalsIgnoreCase("setsale")) {
                    double sale1 = 0.0D;
                    if(!SU.isNumeric(args[2])) {
                        sender.sendMessage(SU.genMessage(Phrases.NotNomber.builder().replaceVar(Vars.STRING, args[2]).buildMessage()));
                        return true;
                    }

                    sale1 = Double.parseDouble(args[2]);
                    if(!args[1].equalsIgnoreCase("all")) {
                        Tab tab1 = Tab.getTab(args[1].replace("_", " "));
                        if(tab1 == null) {
                            sender.sendMessage(SU.genMessage(Phrases.TabNotFound.builder().replaceVar(Vars.TAB, args[1]).buildMessage()));
                            printTabs(sender);
                            return true;
                        }

                        tab1.setSale(sale1, args[3].replace("_", " "));
                        sender.sendMessage(SU.genMessage(Phrases.SaleInstalled.builder().replaceVar(Vars.TAB, args[1]).replaceVar(Vars.DISCOUNT, args[2]).replaceVar(Vars.REASON, args[3].replace("_", " ")).buildMessage()));
                        return true;
                    }

                    Iterator<String> var12 = Tab.getTabsSections().keySet().iterator();

                    while(var12.hasNext()) {
                        String s = (String)var12.next();
                        Tab.getTab(s).setSale(sale1, args[3].replace("_", " "));
                    }

                    sender.sendMessage(SU.genMessage(Phrases.SaleInstalled.builder().replaceVar(Vars.TAB, args[1]).replaceVar(Vars.DISCOUNT, args[2]).replaceVar(Vars.REASON, args[3].replace("_", " ")).buildMessage()));
                    return true;
                }
        }

        printUsage(sender);
        return true;
    }

    public static void printUsage(CommandSender sender) {
        sender.sendMessage("§a/shop");
        sender.sendMessage("§a/shop reload");
        sender.sendMessage("§a/shop setsale <tab_name> <sale in percentages> [sale_Reason] §6use \"_\" instead \" \"");
        sender.sendMessage("§a/shop setprice <item> <buy price> <sell price>");
        sender.sendMessage("  §a(Remember to do §6/shop reload §awhen finished.)");
    }

    public static void printTabs(CommandSender sender) {
        String tabs = "";

        String s;
        for(Iterator<String> var3 = Tab.getTabsSections().keySet().iterator(); var3.hasNext(); tabs = tabs + s.replace(" ", "_") + ", ") {
            s = (String)var3.next();
        }

        tabs = tabs.length() >= 2?tabs.substring(0, tabs.length() - 2):tabs;
        sender.sendMessage(SU.genMessage(Phrases.AvalibleTabs.builder().replaceVar(Vars.TABS, tabs).buildMessage()));
    }

    public class CmdsTabCompleter implements TabCompleter {
        public CmdsTabCompleter(leerWelt leerWelt) {
        }

        public List<String> onTabComplete(CommandSender sender, Command cmd, String str, String[] args) {
            HashSet<String> completers = new HashSet<String>();
            switch(args.length) {
                case 1:
                    if(!sender.hasPermission("shop.reload") && "reload".startsWith(args[0].toLowerCase())) {
                        completers.add("reload");
                    }

                    if(!sender.hasPermission("shop.setsale") && "setsale".startsWith(args[0].toLowerCase())) {
                        completers.add("setsale");
                    }
                    break;
                case 2:
                    if(args[0].equalsIgnoreCase("setsale") && sender.hasPermission("shop.setsale")) {
                        Iterator<String> var7 = Tab.getTabsSections().keySet().iterator();

                        while(var7.hasNext()) {
                            String s = (String)var7.next();
                            if(s.replace(" ", "_").toLowerCase().startsWith(args[1].toLowerCase())) {
                                completers.add(s.replace(" ", "_"));
                            }

                            if("all".startsWith(args[1].toLowerCase())) {
                                completers.add("all");
                            }
                        }
                    }
            }

            return new ArrayList<String>(completers);
        }
    }
}
