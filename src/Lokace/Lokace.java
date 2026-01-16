package Lokace;
import java.util.HashMap;
public class Lokace {
    protected String nazev;
    protected String popis;
    protected HashMap<String,Lokace> lokaceHry;

    public Lokace(String nazev, String popis) {
        this.nazev = nazev;
        this.popis = popis;
        this.lokaceHry = new HashMap<>();
    }

}
