package Commands;

import Svet.Hrac;
import Svet.Lokace;
import Svet.Pripojeni;
import Svet.SpravovaniLokaci;

public class CommandPohyb implements Command{
    SpravovaniLokaci spravovaniLokaci;
    Hrac hrac;

    public CommandPohyb(Hrac hrac, SpravovaniLokaci spravovaniLokaci) {
        this.hrac = hrac;
        this.spravovaniLokaci = spravovaniLokaci;
    }

    @Override
    public String execute(String[] args) {
        if (args.length < 2) {
            return "Musíš zadat směr (rovne, zpet, doleva, doprava).";
        }
        String smer = args[1].toLowerCase();
        String id = hrac.getiDMistnosti();
        Lokace lokaceNasla = null;
        for (int i = 0; i < spravovaniLokaci.getLokace().size(); i++) {
            Lokace lokace = spravovaniLokaci.getLokace().get(i);

            if (lokace.getId().equals(id)) {
                lokaceNasla = lokace;
                break;
            }
        }
        if (lokaceNasla == null) {
            return "Chyba: aktuální lokace nebyla nalezena.";
        }

        Pripojeni pripojeni = lokaceNasla.getPripojeni();
        String noveID;
        switch (smer) {
            case "rovne" -> noveID = pripojeni.getRovne();
            case "zpet" -> noveID = pripojeni.getZpet();
            case "doleva" -> noveID = pripojeni.getDoleva();
            case "doprava" -> noveID = pripojeni.getDoprava();
            default -> {
                return "Neplatný směr. Použij: rovne, zpet, doleva, doprava.";
            }
        }
        Lokace nova = null;
        for (Lokace l : spravovaniLokaci.getLokace()) {
            if (l.getId().equals(noveID)) {
                nova = l;
                break;
            }
        }

        if (noveID == null) {
            return "Tímto směrem se jít nedá.";
        }

        hrac.setiDMistnosti(noveID);
        return "Přesunul jsi se do nové místnosti: "+ nova.getJmeno() + "\n"
                + nova.getPopis();
    }

    @Override
    public boolean exit() {
        return false;
    }
}
