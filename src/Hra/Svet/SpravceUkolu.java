package Hra.Svet;

import lombok.Data;

import java.util.ArrayList;
@Data
public class SpravceUkolu {
    private static ArrayList<Ukol> ukoly = new ArrayList<>();

    public SpravceUkolu() {
        pridej();
    }

    public void pridej() {
        ukoly.add(new SekaniTravyVParkuMiniHra());
    }

    public static Ukol najdiUkol(String jmeno) {
        for (int i = 0; i < ukoly.size(); i++) {
            Ukol ukol = ukoly.get(i);

            if (ukol.getJmenoUkolu().equals(jmeno)) {
                return ukol;
            }
        }
        return null;
    }
}
