package Hra.Svet.Ukoly;

import Hra.Svet.Hrac;
import lombok.Data;

import java.util.ArrayList;
@Data
public class SpravceUkolu {
    private  ArrayList<Ukol> ukoly = new ArrayList<>();
    private Hrac hrac;

    public SpravceUkolu(Hrac hrac) {
        this.hrac = hrac;
        pridej();
    }

    public void pridej() {
        ukoly.add(new SekaniTravyVParkuMiniHra(hrac));
        ukoly.add(new SoubojSPolicistouMiniHra(hrac));
        ukoly.add(new HazeniMinciDoKasnyMiniHra(hrac));
        ukoly.add(new UkolRadnice(hrac));
    }

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