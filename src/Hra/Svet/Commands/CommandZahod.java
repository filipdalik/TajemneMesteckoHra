package Hra.Svet.Commands;

import Hra.Svet.*;

public class CommandZahod implements Command{

    private Hrac hrac;
    private SpravovaniLokaci spravovaniLokaci;

    public CommandZahod(Hrac hrac, SpravovaniLokaci spravovaniLokaci) {
        this.hrac = hrac;
        this.spravovaniLokaci = spravovaniLokaci;
    }

    @Override
    public String execute(String[] args) {
        if (args.length < 2){
            return "Musis napsat, co chces zahodit.";
        }

        String nazev = args[1];
        Inventar inventar = hrac.getInventar();

        if (!inventar.obsahujePredmet(nazev)){
            return "Tento predmet nemas.";
        }

        Predmet predmet = inventar.getPredmet(nazev);
        inventar.odeberPredmet(predmet);

        Lokace lokace = null;
        for (int i = 0; i < spravovaniLokaci.getLokace().size(); i++) {
            if (spravovaniLokaci.getLokace().get(i).getId().equals(hrac.getiDMistnosti())) {
                lokace = spravovaniLokaci.getLokace().get(i);
                break;
            }
        }
        if (lokace == null){
            return "Mistnost nenalezena.";
        }
        lokace.getPredmety().add(predmet);
        return "Zahodil jsi " + nazev + ".";
    }

    @Override
    public boolean exit() { return false; }
}