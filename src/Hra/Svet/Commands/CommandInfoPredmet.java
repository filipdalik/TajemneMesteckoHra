package Hra.Svet.Commands;
import Hra.Svet.Hrac;
import Hra.Svet.Inventar;
import Hra.Svet.Predmet;

/**
 * Trida, ktera pomoci commandu vypise informace o predmetu
 */

public class CommandInfoPredmet implements Command {

    private Hrac hrac;

    public CommandInfoPredmet(Hrac hrac) {
        this.hrac = hrac;
    }

    /**
     * Metoda, ktera slouzi k vypsani informaci o predmetu, o kterem to zrovna chce, musi ho mit v inventari
     * @param args
     * @return
     */
    @Override
    public String execute(String[] args) {
        if (args.length < 2) return "Musis napsat, o jaky predmet chces informace.";

        String nazev = args[1];
        Inventar inventar = hrac.getInventar();

        for (int i = 0; i < inventar.getPredmety().size(); i++) {
            Predmet predmet = inventar.getPredmety().get(i);
            if (predmet.getNazev().equalsIgnoreCase(nazev)) {
                return "Predmet: " + predmet.getNazev() + " Popis: " + predmet.getPopis();
            }
        }

        return "Tento predmet nemas v inventari.";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
