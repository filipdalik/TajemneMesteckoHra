package Hra.Svet.Ukoly;

import Hra.Svet.Hrac;

import java.util.Scanner;

public class ElektrarnaFinalniUkol extends Ukol{

    public ElektrarnaFinalniUkol(Hrac hrac) {
        super("ElektrarnaFinalniUkol", hrac);
    }

    @Override
    public boolean spust() {
        if (!hrac.getInventar().obsahujePredmet("pojistky") || !hrac.getInventar().obsahujePredmet("kabel")) {
            System.out.println("Nemáš vsechny potrebne predmety (pojistky a kabel), abys mohl dokončit elektrarnu.");
            return false;
        }
        int pocetSplnenychUkolu = hrac.getPocetUkolu();
        if (pocetSplnenychUkolu == 6) {
            Scanner sc = new Scanner(System.in);

            System.out.println("=== FINALNI UKOL: Elektrárna ===");
            System.out.println("Musis spravne zapojit pojistky a kabely.");
            System.out.println("Stiskni Enter, az budes pripraven...");

            sc.nextLine();

            System.out.println("Zapojovani probiha...");
            try {
                Thread.sleep(2000);
            }catch (InterruptedException e) {
                System.out.println("Nastala chyba.");
            }
            System.out.println("Pojistky a kabely byly spravne zapojeny!");
            System.out.println();

            System.out.println("GRATULACE! Dokoncil jsi vsechny ukoly ve vsech lokacich.");
            System.out.println("Tajemne mestecko je opet v poradku!");
            System.out.println("Tvoje dobrodruzstvi skoncilo uspesne.");
            System.out.println("=== KONEC HRY ===");
            System.exit(0);
            return true;
        }
        System.out.println("Nejsou splneny vsechny ukoly ve vsech lokacich. Dokonc je a zkus to znovu.");
        return false;
    }
}
