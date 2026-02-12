package Hra.Svet.Commands;

import Hra.Svet.Hrac;
import Hra.Svet.Lokace;
import Hra.Svet.Predmet;
import Hra.Svet.SpravovaniLokaci;

/**
 * Trida, ktera slouzi k vypsani predmetu v lokaci
 */

public class CommandPredmetyVLokaci implements Command{
    private Hrac hrac;
    private SpravovaniLokaci spravovaniLokaci;

    public CommandPredmetyVLokaci(SpravovaniLokaci spravovaniLokaci, Hrac hrac) {
        this.spravovaniLokaci = spravovaniLokaci;
        this.hrac = hrac;
    }

    /**
     * Metoda, ktera vypisuje predmety v dane lokaci, ve ktere se hrac nachazi
     * @param args
     * @return
     */

    @Override
    public String execute(String[] args) {
        Lokace lokace = null;

        for (int i = 0; i < spravovaniLokaci.getLokace().size(); i++) {
            Lokace l = spravovaniLokaci.getLokace().get(i);
            if (l.getId().equals(hrac.getiDMistnosti())) {
                lokace = l;
                break;
            }
        }
        if (lokace == null) {
            return "Aktuální místnost nebyla nalezena.";
        }
        if (lokace.getPredmety() != null || !lokace.getPredmety().isEmpty()) {
            String vypis = "V místnosti se nachází:\n";

            for (int i = 0; i < lokace.getPredmety().size(); i++) {
                Predmet p = lokace.getPredmety().get(i);
                vypis += "- " + p.getNazev() + "\n";
            }
            return vypis;
        }
        return "V této místnosti nejsou žádné předměty.";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
