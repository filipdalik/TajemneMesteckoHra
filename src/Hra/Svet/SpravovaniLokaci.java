package Hra.Svet;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
@Getter
@Setter
@NoArgsConstructor
/**
 * Trida, ktera spravuje vsechny lokace
 */
public class SpravovaniLokaci {
    private ArrayList<Lokace> lokace;
    private ArrayList<Npc> npccka;
    private ArrayList<Predmet> predmety;

    /**
     * Metoda, ktera pridava Npc k dane lokaci podle jmena, ktere ma dana lokace jako vlastnost
     */
    public void init() {
        for (Lokace lok : lokace) {
            for (String p : lok.getNazvyPredmetu()) {
                lok.getPredmety().add(getPredmet(p));
            }
            lok.setNpc(getNpc(lok.getJmenoNpc()));

        }
    }

    /**
     * Metoda, ktera nam vraci predmet podle id
     * @param id
     * @return
     */
    public Predmet getPredmet(String id) {
        for (Predmet predmet : predmety) {
            if (predmet.getId().equals(id)) {
                return predmet;
            }
        }
        return null;
    }

    /**
     * Metoda, ktera nam vraci NPC podle jmena
     * @param jmeno
     * @return
     */

    public Npc getNpc(String jmeno) {
        for (Npc npc : npccka) {
            if (npc.getJmeno().equals(jmeno)) {
                return npc;
            }
        }
        return null;
    }

    /**
     * Metoda, ktera nam vraci lokaci podle jmena
     * @param jmeno
     * @return
     */
    public Lokace getLokace(String jmeno) {
        for (Lokace lokacce : lokace) {
            if (lokacce.getId().equalsIgnoreCase(jmeno)) return lokacce;
        }
        throw new IllegalArgumentException("neplatne jmeno: " + jmeno);
    }
}
