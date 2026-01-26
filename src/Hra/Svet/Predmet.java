package Hra.Svet;

public class Predmet {
    private String id;
    private String nazev;
    private String popis;

    public Predmet(String id, String nazev, String popis) {
        this.nazev = nazev;
        this.popis = popis;
        this.id = id;
    }

    public String getNazev() {
        return nazev;
    }

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    public String getPopis() {
        return popis;
    }

    public void setPopis(String popis) {
        this.popis = popis;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

}
