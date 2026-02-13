package Hra.Svet;

import java.util.ArrayList;
/**
 * Trida ktera obsahuje vsechny vlastnosti inventare
 */

public class Inventar {
    private int kapacitaBatohu = 2;
    private ArrayList <Predmet> predmety;


    public Inventar() {
        this.predmety = new ArrayList<>();
    }

    /**
     * Metoda ktera prida dany predmet do inventare
     * @param predmet
     * @return vraci true/false
     */

    public boolean pridejPredmet(Predmet predmet) {
        if (predmety.size() >= kapacitaBatohu) return false;
        predmety.add(predmet);
        return true;
    }
    /**
     * Metoda ktera odebere dany predmet z inventare
     * @param predmet
     */
    public void odeberPredmet(String predmet) {
        predmety.remove(predmet);
    }

    /**
     * Metoda, ktera zjisti, zda se nachazi v inventari dany predmet, vraci true/falce
     * @param nazev
     * @return vraci true/false
     */
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

    /**
     * Metoda, ktera vypise inventar hrace
     * @return vraci inventar
     */
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

    /**
     * Metoda, ktera zjisti, zda je inventar plny
     * @return vraci true/false zda je plny inventar
     */
    public boolean jePlny() {
        return predmety.size() >= kapacitaBatohu;
    }

    public ArrayList<Predmet> getPredmety() {
        return predmety;
    }
}