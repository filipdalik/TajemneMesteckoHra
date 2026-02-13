package Hra.Svet.Commands;

import Hra.Svet.*;

/**
 * Trida, ktera spravuje zahozeni predmetu z inventare pomoci commandu
 */

public class CommandZahod implements Command{

    private Hrac hrac;
    private SpravovaniLokaci spravovaniLokaci;

    public CommandZahod(Hrac hrac, SpravovaniLokaci spravovaniLokaci) {
        this.hrac = hrac;
        this.spravovaniLokaci = spravovaniLokaci;
    }

    /**
     * Metoda, kde se resi, zda tento predmet hrac ma a pak se tento predmet zahodi
     * @param args
     * @return vraci zahozeni predmetu
     */

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

        String predmet = inventar.getPredmet(nazev).getNazev();
        Predmet predmetObjekt = inventar.getPredmet(nazev);
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
        lokace.getPredmety().add(predmetObjekt);
        return "Zahodil jsi " + nazev + ".";
    }

    @Override
    public boolean exit() { return false; }
}