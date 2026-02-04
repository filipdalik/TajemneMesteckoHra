package Hra.Svet.Ukoly;

import Hra.Svet.Hrac;

public class SoubojSPolicistouMiniHra extends Ukol {
    private boolean jeSplnen = false;

    public SoubojSPolicistouMiniHra(Hrac hrac) {
        super("soubojSPolicistou", hrac);
    }

    @Override
    public boolean spust() {
        return false;
    }
}
