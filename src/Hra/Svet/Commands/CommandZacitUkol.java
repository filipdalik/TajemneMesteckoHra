package Hra.Svet.Commands;

import Hra.Svet.Hrac;
import Hra.Svet.Lokace;
import Hra.Svet.Ukoly.SpravceUkolu;
import Hra.Svet.SpravovaniLokaci;
import Hra.Svet.Ukoly.Ukol;

public class CommandZacitUkol implements Command {
    private SpravovaniLokaci spravovaniLokaci;
    private SpravceUkolu spravceUkolu;
    private Hrac hrac;

    public CommandZacitUkol(SpravovaniLokaci spravovaniLokaci, SpravceUkolu spravceUkolu, Hrac hrac) {
        this.spravovaniLokaci = spravovaniLokaci;
        this.spravceUkolu = spravceUkolu;
        this.hrac = hrac;
    }

    @Override
    public String execute(String[] args) {
        String aktualniLokace = hrac.getAktualniMistnost();
        if (aktualniLokace == null) {
            return"Nejsi v zadne mistnosti.";
        }
        Lokace lokace = spravovaniLokaci.getLokace(aktualniLokace);
        if (lokace == null) throw new IllegalArgumentException("neexistujici jmeno nebo spatny nazev: " + aktualniLokace);

        Ukol ukol = spravceUkolu.najdiUkol(lokace.getJmenoUkol());
        if (ukol != null) {
            ukol.spust();
        } else {
            System.err.println(lokace.getJmenoUkol());
        }

        return "Nepodarilo se najit ukol.";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
