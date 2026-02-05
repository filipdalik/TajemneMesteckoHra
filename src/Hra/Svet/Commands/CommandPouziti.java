package Hra.Svet.Commands;

import Hra.Svet.Hrac;
import Hra.Svet.Inventar;
import Hra.Svet.Lokace;
import Hra.Svet.SpravovaniLokaci;

public class CommandPouziti implements Command{

    private Hrac hrac;
    private SpravovaniLokaci spravovaniLokaci;

    public CommandPouziti(Hrac hrac, SpravovaniLokaci spravovaniLokaci) {
        this.hrac = hrac;
        this.spravovaniLokaci = spravovaniLokaci;
    }

    @Override
    public String execute(String[] args) {
        if (args.length < 2) {
            return "Musis napsat, co chces pouzit.";
        }

        String nazev = args[1].toLowerCase();
        Inventar inventar = hrac.getInventar();

        if (!inventar.obsahujePredmet(nazev)) {
            return "Tento predmet nemas.";
        }


        Lokace aktualni = null;
        for (int i = 0; i < spravovaniLokaci.getLokace().size(); i++) {
            Lokace lok = spravovaniLokaci.getLokace().get(i);
            if (lok.getId().equals(hrac.getiDMistnosti())) {
                aktualni = lok;
                break;
            }
        }

        if (aktualni == null) {
            return "Chyba: aktualni lokace nenalezena.";
        }

        if (nazev.equals("klic")) {

            if (!aktualni.isZamceno()) {
                return "Tato mistnost uz je odemcena.";
            }

            aktualni.setZamceno(false);
            inventar.odeberPredmet("klic");

            return "Odemkl jsi tuto mistnost klicem. Klic se rozpadl.";
        }

        if (nazev.equals("kladivo")) {

            String idNemocnice = "nemocnice";

            if (!aktualni.getId().equals(idNemocnice)) {
                return "Kladivo tady nelze pouzit.";
            }

            if (!aktualni.isZamceno()) {
                return "Nemocnice uz je odemcena.";
            }

            aktualni.setZamceno(false);
            inventar.odeberPredmet("kladivo");
            return "Silou jsi rozmlatil zamek kladivem. Nemocnice je odemcena.";
        }

        return "Tento predmet nelze pouzit.";
    }

    @Override
    public boolean exit() {
        return false;
    }
}