package Lokace;

import Charakters.Npc;
import Charakters.Policista;

public class PolicejniStanice extends Lokace {
private Npc npc;
    public PolicejniStanice() {
        super("Policejní stanice",
                "Plná starých záznamů.");
        npc = new Policista();
    }
}
