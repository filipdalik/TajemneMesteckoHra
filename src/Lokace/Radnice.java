package Lokace;
import Charakters.Npc;
import Charakters.Starostka;
public class Radnice extends Lokace {
    private Npc npc;

    public Radnice() {
        super("Radnice",
                "Budova, kde sídlí starostka.");
        npc = new Starostka();
    }
}