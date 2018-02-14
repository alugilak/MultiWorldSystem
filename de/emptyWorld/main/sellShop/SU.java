package de.emptyWorld.main.sellShop;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class SU {
    public SU() {
    }

    public static String genMessage(String message) {
        if(de.emptyWorld.main.leerWelt.instance().getConfig().getBoolean("UseMessagePrefix")) {
            message = de.emptyWorld.main.leerWelt.instance().getConfig().getString("Prefix") + " " + message;
        }

        return message == null?"":message.replace("&", "§");
    }

    public static String genStrng(String s) {
        return s == null?"":s.replace("&", "§");
    }

    public static String genName(String name) {
        if(de.emptyWorld.main.leerWelt.instance().getConfig().getBoolean("UseTabPrefix")) {
            name = de.emptyWorld.main.leerWelt.instance().getConfig().getString("TabPrefix") + " " + name;
        }

        return name.replace("&", "§");
    }

    public static boolean isNumeric(String s) {
        if(s == null) {
            return false;
        } else {
            if(s.startsWith("-")) {
                s = s.substring(1);
            }

            Pattern p = Pattern.compile("(\\d+)(\\.\\d+)?");
            Matcher m = p.matcher(s);
            return m.matches();
        }
    }

    public static String firstUpperCase(String word) {
        return word != null && !word.isEmpty()?word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase():"";
    }
}
