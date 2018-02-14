package de.emptyWorld.main.sellShop;

import java.io.File;
import java.util.Iterator;
import java.util.logging.Level;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import de.emptyWorld.main.sellShop.ConfigUtil;

public class Lang {
    protected static FileConfiguration lang;
    protected static boolean useDefault = true;

    public Lang() {
    }

    public static boolean installLanguage(String fileName) {
        FileConfiguration clang = ConfigUtil.loadYaml(de.emptyWorld.main.leerWelt.instance(), "lang" + File.separator + fileName);
        if(isCorrect(clang)) {
            lang = clang;
            Phrases.installPhrases();
            setDefault(false);
        } else {
            printErrors(clang, fileName);
            setDefault(true);
        }

        return !isDefault();
    }

    public static void installUnsafeLanguage(File file) {
        lang = YamlConfiguration.loadConfiguration(file);
        Phrases.installPhrases();
        setDefault(false);
    }

    public static void printErrors(FileConfiguration clang, String fileName) {
        Iterator<?> var3 = Phrases.valuesAsString().iterator();

        while(var3.hasNext()) {
            String s = (String)var3.next();
            if(!clang.getKeys(false).contains(s)) {
                de.emptyWorld.main.leerWelt.instance().getLogger().log(Level.INFO, "Missing phrase \"" + s + "\" at lang file \"" + fileName + "\"");
            }
        }

    }

    public static boolean isCorrect(FileConfiguration clang) {
        return clang.getKeys(false).containsAll(Phrases.valuesAsString());
    }

    public static String getString(String path) {
        return lang.getString(path);
    }

    protected static void setDefault(boolean b) {
        useDefault = b;
    }

    public static boolean isDefault() {
        return useDefault;
    }
}
