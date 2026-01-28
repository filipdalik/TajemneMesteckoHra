package Hra.Svet.Commands;

import Hra.Svet.Hrac;
import Hra.Svet.Inventar;
import Hra.Svet.Predmet;

public class CommandPouziti implements Command{

    private Hrac hrac;

    public CommandPouziti(Hrac hrac) {
        this.hrac = hrac;
    }

    @Override
    public String execute(String[] args) {
        if (args.length < 2){
            return "Musis napsat, co chces pouzit.";
        }

        String nazev = args[1];
        Inventar inventar = hrac.getInventar();

        if (!inventar.obsahujePredmet(nazev)){
            return "Tento predmet nemas.";
        }
        
        return "Pouzil jsi " + nazev + ".";
    }

    @Override
    public boolean exit() { return false; }
}