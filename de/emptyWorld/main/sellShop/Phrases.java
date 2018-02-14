package de.emptyWorld.main.sellShop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public enum Phrases {
    NoPermission("&cSorry, but you have not permission to do that."),
    NoTabPermission("&cSorry, but you have not permission to open this tab."),
    CreativePermission("&c&cSorry, but you not permited to use shop in creative gamemode"),
    Error("&cSomething goes wrong. Check the console!"),
    Reloaded("&aReload completed"),
    SaleInstalled("&aFor tab &6{tab} &awas installed sale for &b{discount}% &adiscount. Reason:&r{reason}"),
    NotNomber("&cString &r{string} &cis not nomber, so it cannot be used as discount"),
    TabNotFound("&cTab not found"),
    AvalibleTabs("&aAvalible tabs: &6{tabs}"),
    InShop("&aYou are in shop"),
    PressToBuy("Press to buy"),
    PressToSell("Press to sell"),
    BuyCost("&fOne item cost: &6{cost}$"),
    BuyCost16("&f16 items cost: &6{cost}$"),
    BuyCost64("&f64 items cost: &6{cost}$"),
    SellCost("&fYou will get for one item: &6{cost}$"),
    SellCost16("&fYou will get for 16 items: &6{cost}$"),
    SellCost64("&fYou will get for 64 items: &6{cost}$"),
    Sale("&6Sale! &b{discount}% &6discount. &a{reason}"),
    NoItems("&cNot enough items!"),
    NoMoney("&cNot emough money!"),
    NoPlace("&cInventory full!"),
    SuccesBought("&aYou bought &6{item}&ax&6{count}&a and spend &6{cost}$"),
    SuccesSold("&aYou sold &6{item}&ax&6{count}&a and get &6{cost}$"),
    NextPage("Next page"),
    PreviosPage("Previos page"),
    LogFormat("The player {player} {operation} item \"{item}\"x{count} at tab \"{tab}\". Discount: {discount}%({reason}). Total price: {cost}."),
    Sold("sold"),
    Bought("bought");

    protected String DefaultText;
    protected String PhraseStr;

    private Phrases(String def) {
        this.DefaultText = def;
        this.PhraseStr = def;
    }

    public static void installPhrases() {
        Phrases ph;
        for(Iterator<Phrases> var1 = Arrays.asList(values()).iterator(); var1.hasNext(); ph.PhraseStr = Lang.getString(ph.toString())) {
            ph = (Phrases)var1.next();
        }

    }

    public static List<String> valuesAsString() {
        List<String> valS = new ArrayList<String>();
        Iterator<Phrases> var2 = Arrays.asList(values()).iterator();

        while(var2.hasNext()) {
            Phrases ph = (Phrases)var2.next();
            valS.add(ph.toString());
        }

        return valS;
    }

    public PhraseBuilder builder() {
        return new PhraseBuilder(this);
    }

    public String getMessage() {
        return !Lang.isDefault() && isCorrect(this.PhraseStr)?this.PhraseStr.replace("&", "§"):this.getDefaultMessage();
    }

    public String getDefaultMessage() {
        return this.DefaultText.replace("&", "§");
    }

    protected static boolean isCorrect(String phrS) {
        return phrS != null;
    }

    public static enum Vars {
        TAB("{tab}"),
        COST("{cost}"),
        DISCOUNT("{discount}"),
        REASON("{reason}"),
        STRING("{string}"),
        TABS("{tabs}"),
        COUNT("{count}"),
        ITEM("{item}");

        private String[] varsset;

        private Vars(String[] var) {
            this.varsset = var;
        }

        private Vars(String var) {
            this.varsset = new String[]{var};
        }

        public static String replaceVar(String s, Phrases.Vars var, String r) {
            String st;
            for(Iterator<?> var4 = var.getVars().iterator(); var4.hasNext(); s = s.replace(st, r)) {
                st = (String)var4.next();
            }

            return s;
        }

        public List<String> getVars() {
            List<String> varsL = new ArrayList<String>(Arrays.asList(this.varsset));
            return varsL;
        }
    }
}
