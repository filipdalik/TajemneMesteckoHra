package Hra.Svet.Ukoly;
import Hra.Svet.Hrac;
import Hra.Svet.Predmet;
import java.util.Scanner;

/**
 * Trida, ktera je ukolem do lokace Park
 */
public class SekaniTravyVParkuMiniHra extends Ukol {

    private char[][] pole = new char[12][12];
    private int hracX = 0;
    private int hracY = 0;
    private boolean jeSplnen  = false;

    public SekaniTravyVParkuMiniHra(Hrac hrac) {
        super("sekaniUkol", hrac);
        inicializujPole();
    }

    /**
     * Metoda, ktera inicializuje pole, ve kterem se hraje
     */

    private void inicializujPole() {
        for (int y = 0; y < 12; y++) {
            for (int x = 0; x < 12; x++) {
                pole[y][x] = '*';
            }
        }
        pole[hracY][hracX] = '@';
    }

    /**
     * Metoda, ktera spousti ukol a vyhodnocuje, zda ma hrac dany predmet v inventari
     * @return
     */
    @Override
    public boolean spust() {
        Scanner scanner = new Scanner(System.in);
        if (hrac.getInventar().obsahujePredmet("sekacka")) {
            if (!jeSplnen) {
                while (true) {
                    vykresliPole();
                    if (jePosekano()) {
                        System.out.println("Vsechna trava je posekana a tento ukol je splnen! Ziskavas bylinky od zahradnice, budou se ti hodit.");
                        hrac.getInventar().pridejPredmet(new Predmet("bylinky", "Lecive rostliny na lektvar a uzdraveni nekoho.", "bylinky"));
                        hrac.zvysitPocetUkolu();
                        jeSplnen = true;
                        return true;
                    }
                    System.out.print("Pohyb (w/a/s/d): ");
                    String vstup = scanner.nextLine();
                    if (vstup.isEmpty()) continue;
                    pohniHracem(vstup.charAt(0));
                }
            }
            System.out.println("Tento ukol je jiz splnen.");
            return false;
        }
            System.out.println("K tomuto ukolu potrebujes sekacku");
        return false;
    }

    /**
     * Metoda, ktera pohybuje s hracem pomoci w/s/a/d a prepisuje policka s * na mezeru (prazdne misto)
      * @param smer
     */

    private void pohniHracem(char smer) {
        int noveX = hracX;
        int noveY = hracY;

        switch (smer) {
            case 'w':
                noveY--;
                break;
            case 's':
                noveY++;
                break;
            case 'a':
                noveX--;
                break;
            case 'd':
                noveX++;
                break;
            default:
                return;
        }
        if (noveX<0 || noveX>=12 || noveY<0 || noveY>=12) {
            return;
        }
        pole[hracY][hracX] = ' ';
        hracX = noveX;
        hracY = noveY;
        pole[hracY][hracX] = '@';
    }

    /**
     * Metoda, ktera kontroluje, zda je cele pole posekane
     * @return
     */

    private boolean jePosekano() {
        for (int y = 0; y < 12; y++) {
            for (int x = 0; x < 12; x++) {
                if (pole[y][x] == '*') {
                    return false;
                }
            }
        }
        return true;
    }
    /**
     * Metoda, ktera vykresli pole
     */
    private void vykresliPole() {
        System.out.println();
        for (int y = 0; y < 12; y++) {
            for (int x = 0; x < 12; x++) {
                System.out.print(pole[y][x] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
