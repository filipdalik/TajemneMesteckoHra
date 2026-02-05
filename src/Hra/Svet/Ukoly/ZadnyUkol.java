package Hra.Svet.Ukoly;

import Hra.Svet.Hrac;

public class ZadnyUkol extends Ukol{

    public ZadnyUkol(Hrac hrac) {
        super("ZadnyUkol", hrac);
    }

    @Override
    public boolean spust() {
        System.out.println("V teto mistnosti neni zadny ukol.");
        return false;
    }
}
