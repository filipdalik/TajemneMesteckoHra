package Hra.Svet.Commands;

import Hra.Svet.Hrac;
import Hra.Svet.SpravceUkolu;
import Hra.Svet.SpravovaniLokaci;
import Hra.Svet.Ukol;

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
        for (int i = 0; i < spravovaniLokaci.getLokace().size(); i++) {
            if (spravovaniLokaci.getLokace().get(i).getJmeno().equals(aktualniLokace) && spravovaniLokaci.getLokace().get(i).isSplneniUkolu()==false) {
                String jmenoUkolu = spravovaniLokaci.getLokace().get(i).getJmenoUkol();
                Ukol ukol = spravceUkolu.najdiUkol(jmenoUkolu);
                ukol.spust();
                return "Ukol se plni....";
            }else if (spravovaniLokaci.getLokace().get(i).isSplneniUkolu()== true){
                return "Tento ukol jiz byl splnen.";
            }else if (spravovaniLokaci.getLokace().get(i).getJmenoUkol() == null){
                return "V teto mistnosti neni ukol.";
            }
        }
        return "Nepodarilo se najit ukol.";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
