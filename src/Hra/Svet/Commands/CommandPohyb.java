package Hra.Svet.Commands;

import Hra.Svet.Hrac;
import Hra.Svet.Lokace;
import Hra.Svet.Pripojeni;
import Hra.Svet.SpravovaniLokaci;

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
            return "Musis zadat smer (rovne, zpet, doleva, doprava).";
        }
        String smer = args[1].toLowerCase();
        String id = hrac.getiDMistnosti();
        Lokace lokaceNasla = null;

        for (int i = 0; i < spravovaniLokaci.getLokace().size(); i++) {
            Lokace l = spravovaniLokaci.getLokace().get(i);
            if (l.getId().equals(id)) {
                lokaceNasla = l;
                break;
            }
        }

        if (lokaceNasla == null) {
            return "Chyba: aktualni lokace nebyla nalezena.";
        }

        Pripojeni pripojeni = lokaceNasla.getPripojeni();
        String noveID;

        switch (smer) {
            case "rovne" -> noveID = pripojeni.getRovne();
            case "zpet" -> noveID = pripojeni.getZpet();
            case "doleva" -> noveID = pripojeni.getDoleva();
            case "doprava" -> noveID = pripojeni.getDoprava();
            default -> {
                return "Neplatny smer. Pouzij: rovne, zpet, doleva, doprava.";
            }
        }

        if (noveID == null) {
            return "Timto smerem se jit neda.";
        }

        Lokace nova = null;
        for (int i = 0; i < spravovaniLokaci.getLokace().size(); i++) {
            Lokace l = spravovaniLokaci.getLokace().get(i);
            if (l.getId().equals(noveID)) {
                nova = l;
                break;
            }
        }

        if (nova != null && nova.isZamceno()) {
            return "Tato mistnost je zamcena. Musis ji nejdrive odemknout. Pouzij bud klic a nebo kladivo.";
        }

        hrac.setiDMistnosti(noveID);
        hrac.setAktualniMistnost(nova.getJmeno());
        return "Presunul jsi se do nove mistnosti: " + nova.getJmeno() + "\n" + nova.getPopis();

    }

    @Override
    public boolean exit() {
        return false;
    }
}
