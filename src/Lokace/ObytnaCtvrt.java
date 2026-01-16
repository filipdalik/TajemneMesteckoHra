package Lokace;
import Charakters.Npc;
import Charakters.Vesnican;
public class ObytnaCtvrt extends Lokace {
    private Npc npc;
    public ObytnaCtvr() {
        super("Obytná čtvrť", "Rozbité domy a opuštěné ulice.");
        npc = new Vesnican();
    }
}
