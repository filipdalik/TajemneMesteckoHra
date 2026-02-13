package Hra.Svet.Ukoly;

import Hra.Svet.Hrac;

/**
 * Trida, ktera predstavuje ukol, ve kterem se nic nedeje
 */

public class ZadnyUkol extends Ukol{

    public ZadnyUkol(Hrac hrac) {
        super("ZadnyUkol", hrac);
    }

    /**
     * Metoda, ktera spusti tento ukol, ale nic nedela, pouze hracovi vraci, ze v lokaci, kde se nachazi, neni zadny ukol
     * @ vraci, ze v lokaci neni zadny ukol
     */

    @Override
    public boolean spust() {
        System.out.println("V teto mistnosti neni zadny ukol.");
        return false;
    }
}
