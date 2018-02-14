package de.emptyWorld.main.sellShop;

import java.util.HashMap;
import java.util.Iterator;
import de.emptyWorld.main.sellShop.Phrases.Vars;

public class PhraseBuilder {
    private Phrases phrase;
    private HashMap<Vars, String> vars = new HashMap<Vars, String>();

    public PhraseBuilder(Phrases phrase) {
        this.phrase = phrase;
    }

    public PhraseBuilder replaceVar(Vars var, String string) {
        this.vars.put(var, string);
        return this;
    }

    public String buildMessage() {
        return this.replaceVars(this.phrase.getMessage());
    }

    public String buildDefaultMessage() {
        return this.replaceVars(this.phrase.getDefaultMessage());
    }

    private String replaceVars(String s) {
        Vars var;
        for(Iterator<Vars> var3 = this.vars.keySet().iterator(); var3.hasNext(); s = Vars.replaceVar(s, var, (String)this.vars.get(var))) {
            var = (Vars)var3.next();
        }

        return s.replace("&", "§");
    }
}
