package Lokace;

import Charakters.Npc;
import Charakters.Vodnik;

public class Namesti extends Lokace {
    private Npc npc;

    public Namesti() {
        super("Náměstí", "Zničené náměstí s rozbitou kašnou.");
        npc = new Vodnik();
    }
}
