package Hra.Svet.Ukoly;

import Hra.Svet.Hrac;
import Hra.Svet.Predmet;

import java.util.Scanner;

public class LektvarMiniHra extends Ukol{

    private boolean jeSplnen = false;

    public LektvarMiniHra(Hrac hrac) {
        super("mixLektvaru", hrac);
    }

    @Override
    public boolean spust() {

        if (jeSplnen) {
            System.out.println("Tento ukol uz jsi delal.");
            return true;
        }

        if (!hrac.getInventar().obsahujePredmet("bylinky")) {
            System.out.println("Nemáš potrebny predmet 'bylinky'! Bez nej nemuzes lektvar namichat.");
            return false;
        }

        Scanner sc = new Scanner(System.in);

        System.out.println("V nemocnici se chystas smichat lektvar.");
        System.out.println("Dostupne ingredience: voda, cesnek, bylinky, koreni, zlatyPrasek, boruvky");
        System.out.println("Musis vybrat spravne ingredience pro lektvar.");

        String[] spravneIngredience = {"voda", "cesnek", "bylinky", "zlatyPrasek"};

        for (int pokus = 1; pokus <= 4; pokus++) {
            System.out.println("Pokus " + pokus + ": Zadej ingredience oddelene carkou:");
            String zadano = sc.nextLine().replaceAll("\\s+", "").toLowerCase();
            String[] zadaneIngredience = zadano.split(",");

            boolean spravne = true;

            for (int i = 0; i < spravneIngredience.length; i++) {
                String ingred = spravneIngredience[i];
                boolean obsahuje = false;
                for (int j = 0; j < zadaneIngredience.length; j++) {
                    if (ingred.equals(zadaneIngredience[j])) {
                        obsahuje = true;
                        break;
                    }
                }
                if (!obsahuje) {
                    spravne = false;
                    break;
                }
            }

            if (spravne) {
                System.out.println("Spravne! Smichal jsi lektvar.");
                hrac.getInventar().pridejPredmet(new Predmet("lektvar", "Silny lektvar z bylinek", "lektvar"));
                jeSplnen = true;
                return true;
            } else {
                System.out.println("Spatne! Tento pokus se nezdaril.");
                jeSplnen = true;
            }
        }

        System.out.println("Neuspel jsi namichat lektvar.");
        return false;
    }
}
