package Lokace;
import Charakters.Elektrikar;
import Charakters.Npc;
public class Elektrarna extends Lokace {
    private Npc npc;
    public Elektrarna() {
        super("Elektrárna",
                "Hlavní zdroj elektřiny města.");
        npc = new Elektrikar();
    }
}
