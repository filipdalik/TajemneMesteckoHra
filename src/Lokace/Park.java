package Lokace;
import Charakters.Npc;
import Charakters.Zahradnice;
public class Park extends Lokace {
    private Npc npc;
    public Park() {
        super("Park",
                "Zarostlý a opuštěný park.");
        npc = new Zahradnice();
    }
}
