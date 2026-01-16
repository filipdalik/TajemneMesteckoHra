package Lokace;
import Charakters.Npc;
import Charakters.StaryDoktor;
public class Nemocnice extends Lokace {
    private Npc npc;
    public Nemocnice() {
        super("Nemocnice",
                "Staré nemocniční vybavení a ticho.");
        npc = new StaryDoktor();
    }
}
