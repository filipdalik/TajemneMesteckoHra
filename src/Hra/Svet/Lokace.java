package Hra.Svet;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Data
public class Lokace {
    private String id;
    private String jmeno;
    private String popis;
    private Pripojeni pripojeni;
    private String jmenoNpc;
    private List<String> nazvyPredmetu;

    private List<Predmet> predmety = new ArrayList<>();
    private Npc npc;
//    @JsonIgnore
//    private Ukol ukol;
//
//    public void setUkol(Ukol ukol) {
//        this.ukol = new Ukol;
//    }
}
