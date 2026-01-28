package Hra.Svet;

import java.util.ArrayList;

public class Inventar {
    private int kapacitaBatohu = 2;
    private ArrayList <Predmet> predmety;


    public Inventar() {
        this.predmety = new ArrayList<>();
    }

    public boolean pridejPredmet(Predmet predmet) {
        if (predmety.size() >= kapacitaBatohu) return false;
        predmety.add(predmet);
        return true;
    }

    public void odeberPredmet(Predmet predmet) {
        predmety.remove(predmet);
    }

    public boolean obsahujePredmet(String nazev) {
        for (int i = 0; i < predmety.size(); i++) {
            if (predmety.get(i).getNazev().equalsIgnoreCase(nazev)) return true;
        }
        return false;
    }

    public Predmet getPredmet(String nazev) {
        for (int i = 0; i < predmety.size(); i++) {
            if (predmety.get(i).getNazev().equalsIgnoreCase(nazev)) return predmety.get(i);
        }
        return null;
    }

    public String vypisInventar() {
        if (predmety.isEmpty()) {
            return "Inventar je prazdny.";
        }

        StringBuilder sb = new StringBuilder("V inventari mas:\n");
        for (int i = 0; i < predmety.size(); i++) {
            sb.append("- ").append(predmety.get(i).getNazev()).append("\n");
        }
        return sb.toString();
    }

    public boolean jePlny() {
        return predmety.size() >= kapacitaBatohu;
    }
    public ArrayList<Predmet> getPredmety() {
        return predmety;
    }
}