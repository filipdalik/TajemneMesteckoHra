package Hra.Svet.Ukoly;
import Hra.Svet.Hrac;

import java.sql.SQLOutput;
import java.util.Scanner;

import static Hra.Svet.Hra.*;

/**
 * Trida, ktera je ukolem do lokace Elektrarna a nasledne i pro konec cele hry
 */
public class ElektrarnaFinalniUkol extends Ukol{

    public ElektrarnaFinalniUkol(Hrac hrac) {
        super("ElektrarnaFinalniUkol", hrac);
    }

    /**
     * Metoda, ktera dokoncuje celou hru a pokud ma hrac vsechny ukoly splnene, tak ho to pouzti do ukolu a nasledne uz jen stiskne enter a zapoji pojistky a tim hra konci a vytezi.
     * @return
     */

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
            System.out.println();
            String vyhra = "____    ____ ____    ____  __    __  .______          ___      \n" +
                    "\\   \\  /   / \\   \\  /   / |  |  |  | |   _  \\        /   \\     \n" +
                    " \\   \\/   /   \\   \\/   /  |  |__|  | |  |_)  |      /  ^  \\    \n" +
                    "  \\      /     \\_    _/   |   __   | |      /      /  /_\\  \\   \n" +
                    "   \\    /        |  |     |  |  |  | |  |\\  \\----./  _____  \\  \n" +
                    "    \\__/         |__|     |__|  |__| | _| `._____/__/     \\__\\ \n" +
                    "                                                               ";
            System.out.println(BLUE+vyhra+RESET);
            System.out.println();
            System.out.println("GRATULACE! Dokoncil jsi vsechny ukoly ve vsech lokacich.");
            System.out.println("Tajemne mestecko je opet v poradku!");
            System.out.println("Tvoje dobrodruzstvi skoncilo uspesne.");
            System.out.println();
            String konec = " __  ___   ______   .__   __.  _______   ______ \n" +
                    "|  |/  /  /  __  \\  |  \\ |  | |   ____| /      |\n" +
                    "|  '  /  |  |  |  | |   \\|  | |  |__   |  ,----'\n" +
                    "|    <   |  |  |  | |  . `  | |   __|  |  |     \n" +
                    "|  .  \\  |  `--'  | |  |\\   | |  |____ |  `----.\n" +
                    "|__|\\__\\  \\______/  |__| \\__| |_______| \\______|\n" +
                    "                                                ";
            System.out.println(RED+konec+RESET);
            System.out.println();
            System.exit(0);
            return true;
        }
        System.out.println("Nejsou splneny vsechny ukoly ve vsech lokacich. Dokonci je a zkus to znovu.");
        return false;
    }
}
