package Hra.Svet.Ukoly;

import Hra.Svet.Hrac;
import lombok.Data;

import java.util.ArrayList;
@Data
/**
 * Trida, ktera spravuje vsechny ukoly
 */
public class SpravceUkolu {
    private  ArrayList<Ukol> ukoly = new ArrayList<>();
    private Hrac hrac;

    public SpravceUkolu(Hrac hrac) {
        this.hrac = hrac;
        pridej();
    }

    /**
     * Metoda, ve ktere se vytvari vsechny ukoly a pridavaji se do ArrayListu s ukoly
     */
    public void pridej() {
        ukoly.add(new SekaniTravyVParkuMiniHra(hrac));
        ukoly.add(new SoubojSPolicistouMiniHra(hrac));
        ukoly.add(new HazeniMinciDoKasnyMiniHra(hrac));
        ukoly.add(new UkolRadnice(hrac));
        ukoly.add(new LektvarMiniHra(hrac));
        ukoly.add(new UkolObytnaCtvrt(hrac));
        ukoly.add(new ZadnyUkol(hrac));
        ukoly.add(new ElektrarnaFinalniUkol(hrac));
    }

    /**
     * Metoda, ktera pomoci jmena hleda dany ukol
     * @param jmeno
     * @return
     */
    public Ukol najdiUkol(String jmeno) {
        for (int i = 0; i < ukoly.size(); i++) {
            Ukol ukol = ukoly.get(i);
            if (ukol.getJmenoUkolu().equalsIgnoreCase(jmeno)) {
                return ukol;
            }
        }
        return null;
    }
}