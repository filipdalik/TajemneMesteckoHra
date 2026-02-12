package Hra.Svet.Ukoly;

import Hra.Svet.Hrac;
import Hra.Svet.Predmet;
import java.util.Scanner;

/**
 * Trida, ktera je ukolem do lokace ObytnaCtvrt
 */
public class UkolObytnaCtvrt extends Ukol{

    private boolean jeSplnen = false;

    public UkolObytnaCtvrt(Hrac hrac) {
        super("ukolObytnaCtvrt", hrac);
    }

    /**
     * Metoda, ve ktere se odehrava cely ukol, hrac musi mit v inventari predmet prkna a pak pomoci matematickeho ukolu opravuje dum
     * Ma na to dva pokusy, po jeho splneni se prida novy predmet a naopak po nesplneni se ubira zivot
     * @return
     */

    @Override
    public boolean spust() {

        if (jeSplnen) {
            System.out.println("Tento ukol uz jsi delal.");
            return true;
        }
        if (!hrac.getInventar().obsahujePredmet("prkna")) {
            System.out.println("Nemáš potrebny predmet 'prkna'! Bez nich nemuzes opravit dum.");
            return false;
        }

        Scanner sc = new Scanner(System.in);

        System.out.println("Musis opravit dum. Strecha ma 20 m2, jedno prkno ma 4 m2.");
        System.out.println("Kolik prken bude potreba na opravu strechy? Mas na to 2 pokusy");

        int spravnaOdpoved = 5;

        for (int pokus = 1; pokus <= 2; pokus++) {
            System.out.print("Pokus " + pokus + ": ");
            String odpovedHrace = sc.nextLine().trim();

            try {
                int odpoved = Integer.parseInt(odpovedHrace);

                if (odpoved == spravnaOdpoved) {
                    System.out.println("Spravne! Dum je opravena.");
                    hrac.getInventar().odeberPredmet("prkna");
                    hrac.getInventar().pridejPredmet(new Predmet("stare_dokumenty", "Tyto dokumenty potrebujes do radnice.", "stare_dokumenty"));
                    hrac.zvysitPocetUkolu();
                    jeSplnen = true;
                    return true;
                } else {
                    System.out.println("Spatne. Zkus to znovu.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Musis zadat cislo!");
            }
        }

        System.out.println("Nepodarilo se ti dum opravit. Odecita se ti zivot.");
        hrac.ubratZivoty(1);
        jeSplnen = true;
        return false;
    }
}
