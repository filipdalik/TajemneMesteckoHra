package Hra.Svet.Commands;

import Hra.Svet.Hrac;
import Hra.Svet.Predmet;

import java.util.ArrayList;

public class CommandInventar implements Command {

    private Hrac hrac;

    public CommandInventar(Hrac hrac) {
        this.hrac = hrac;
    }

    @Override
    public String execute(String[] args) {
        ArrayList<Predmet> predmety = hrac.getInventar().getPredmety();

        if (predmety.isEmpty()) return "Inventar je prazdny.";

        String obsah = "V inventari mas:\n";

        for (int i = 0; i < predmety.size(); i++) {
            Predmet p = predmety.get(i);
            obsah += "- " + p.getNazev() + "\n";
        }
        return obsah;
    }

    @Override
    public boolean exit() {
        return false;
    }
}
