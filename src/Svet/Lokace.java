package Svet;

import NPC.Npc;
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
    protected String id;
    protected String jmeno;
    protected String popis;
    protected Pripojeni pripojeni;
    private List<Npc> Npccka;






}
