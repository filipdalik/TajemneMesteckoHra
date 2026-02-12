package Hra.Svet;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Trida, ktera obsahuje vsechny vlastnosti lokaci
 */
@Data
public class Lokace {
    private String id;
    private String jmeno;
    private String popis;
    private Pripojeni pripojeni;
    private String jmenoNpc;
    private String jmenoUkol;
    private boolean splneniUkolu;
    private boolean zamceno;
    private List<String> nazvyPredmetu;

    private List<Predmet> predmety = new ArrayList<>();
    private Npc npc;

}
