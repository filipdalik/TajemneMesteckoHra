package Hra.Svet.Ukoly;

import Hra.Svet.Hrac;

import java.util.Random;
import java.util.Scanner;

public class HazeniMinciDoKasnyMiniHra extends Ukol{

    private boolean jeSplnen = false;
    private int potrebneTrefy = 2;
    private int maxPokusy = 5;


    public HazeniMinciDoKasnyMiniHra( Hrac hrac) {
        super("HazeniMinciDoKasnyMiniHra", hrac);
    }

    @Override
    public boolean spust() {
        if (jeSplnen) {
            System.out.println("Tento ukol jsi uz delal.");
            return false;
        }

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Stojis u kasny na namesti.");
        System.out.println("Hod mince tak, aby dopadly prímo do stredu kasny!");
        System.out.println("Zadavej silu hodu (1–100).");

        int trefy = 0;

        for (int pokus = 1; pokus <= maxPokusy; pokus++) {

            int idealniSila = 40 + random.nextInt(21);

            System.out.print("Pokus " + pokus + ": Zadej silu hodu: ");

            String vstup = scanner.nextLine();
            int sila;

            try {
                sila = Integer.parseInt(vstup.trim());
            } catch (Exception e) {
                System.out.println("Neplatne cislo, pokus propadl!");
                continue;
            }

            if (sila < 1 || sila > 100) {
                System.out.println("Sila musí byt mezi 1–100.");
                continue;
            }

            int rozdil = Math.abs(idealniSila - sila);

            if (rozdil <= 5) {
                System.out.println("Perfektni hod! Mince dopadla do stredu!");
                trefy++;
            } else if (sila < idealniSila) {
                System.out.println("Mince spadla tesne pred kasnu.");
            } else {
                System.out.println("Mince preletela pres kasnu!");
            }
            if (trefy >= potrebneTrefy) {
                System.out.println("Splnil jsi ukol! Trefil ses dostatecne presne!");
                System.out.println("Napoveda do radnice zni: U prvniho vyplneni dej lety.");
                jeSplnen = true;
                hrac.zvysitPocetUkolu();
                return true;
            }
        }

        System.out.println("Ukol nesplnen. Netrefil ses dostatecne.");
        jeSplnen = true;
        return false;
    }
}
