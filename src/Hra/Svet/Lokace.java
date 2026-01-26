package Hra.Svet;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@ToString
@Getter
@Setter
@NoArgsConstructor

public class Lokace {
    private String id;
    private String jmeno;
    private String popis;
    private Pripojeni pripojeni;
    private Npc npc;
    private List<Predmet> predmety;
}
