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

public class SpravovaniLokaci {
    private ArrayList<Lokace> lokace;
    private ArrayList<Npc> npccka;
    private ArrayList<Predmet> predmety;

    public void init() {
        for (Lokace lok : lokace) {
            for (String p : lok.getNazvyPredmetu()) {
                lok.getPredmety().add(getPredmet(p));
            }
            lok.setNpc(getNpc(lok.getJmenoNpc()));

        }
    }

    public Predmet getPredmet(String id) {
        for (Predmet predmet : predmety) {
            if (predmet.getId().equals(id)) {
                return predmet;
            }
        }
        return null;
    }

    public Npc getNpc(String jmeno) {
        for (Npc npc : npccka) {
            if (npc.getJmeno().equals(jmeno)) {
                return npc;
            }
        }
        return null;
    }
}
