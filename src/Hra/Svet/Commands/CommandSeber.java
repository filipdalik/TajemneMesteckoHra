package Hra.Svet.Commands;

import Hra.Svet.Hrac;
import Hra.Svet.Lokace;
import Hra.Svet.Predmet;
import Hra.Svet.SpravovaniLokaci;

public class CommandSeber implements Command{

    private Hrac hrac;
    private SpravovaniLokaci spravovaniLokaci;

    public CommandSeber(Hrac hrac, SpravovaniLokaci spravovaniLokaci) {
        this.hrac = hrac;
        this.spravovaniLokaci = spravovaniLokaci;
    }

    @Override
    public String execute(String[] args) {
        if (args.length < 2){
            return "Musis napsat, co chces sebrat.";
        }
        if (hrac.getInventar().jePlny()){
            return "Inventar je plny.";
        }

        String nazev = args[1];
        Lokace lokace = new Lokace();

        for (int i = 0; i < spravovaniLokaci.getLokace().size(); i++) {
            if (spravovaniLokaci.getLokace().get(i).getId().equals(hrac.getiDMistnosti())) {
                lokace = spravovaniLokaci.getLokace().get(i);
                break;
            }
        }

        if (lokace == null){
            return "Mistnost nenalezena.";
        }

        Predmet predmet = null;
        for (int i = 0; i < lokace.getPredmety().size(); i++) {
            if (lokace.getPredmety().get(i).getNazev().equalsIgnoreCase(nazev)) {
                predmet = lokace.getPredmety().get(i);
                break;
            }
        }

        if (predmet == null){
            return "Tento predmet tu neni.";
        }

        hrac.getInventar().pridejPredmet(predmet);
        lokace.getPredmety().remove(predmet);

        return "Sebral jsi " + nazev + ".";
    }

    @Override
    public boolean exit() {
        return false;
    }
}