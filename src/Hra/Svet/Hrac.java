package Hra.Svet;


public class Hrac {
    private String jmeno;
    private int zivoty;
    private String iDMistnosti;
    Inventar inventar;
    private String aktualniMistnost;

    public Hrac(String jmeno, String zacatecniMistnost, SpravovaniLokaci spravovaniLokaci) {
        for (int i = 0; i < spravovaniLokaci.getLokace().size(); i++) {
            if (spravovaniLokaci.getLokace().get(i).getId().equals(zacatecniMistnost)) {
                aktualniMistnost = spravovaniLokaci.getLokace().get(i).getJmeno();
                iDMistnosti = spravovaniLokaci.getLokace().get(i).getId();
            }
        }
        this.jmeno = jmeno;
        this.zivoty = 2;
        inventar = new Inventar();
    }

    public String getJmeno() {
        return jmeno;
    }

    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

    public String getAktualniMistnost() {
        return aktualniMistnost;
    }

    public void setAktualniMistnost(String aktualniMistnost) {
        this.aktualniMistnost = aktualniMistnost;
    }

    public Inventar getInventar() {
        return inventar;
    }

    public void setInventar(Inventar inventar) {
        this.inventar = inventar;
    }

    public String getiDMistnosti() {
        return iDMistnosti;
    }

    public void setiDMistnosti(String iDMistnosti) {
        this.iDMistnosti = iDMistnosti;
    }

    public int getZivoty() {
        return zivoty;
    }

    public void setZivoty(int zivoty) {
        this.zivoty = zivoty;
    }
}
