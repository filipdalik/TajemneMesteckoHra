package Hra.Svet.Ukoly;
import Hra.Svet.Hrac;

/**
 * Abstraktni trida, ktera je hlavickou pro vsechny ukoly
 */
public abstract class Ukol {
    protected String jmenoUkolu;
    protected Hrac hrac;

    public Ukol(String jmenoUkolu, Hrac hrac) {
        this.jmenoUkolu = jmenoUkolu;
        this.hrac = hrac;
    }
    public String getJmenoUkolu() {
        return jmenoUkolu;
    }
    public Hrac getHrac() {
        return hrac;
    }
    public abstract boolean spust();
}