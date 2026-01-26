package Hra.Svet;

import java.util.ArrayList;

public class Inventar {
    private int kapacitaBatohu = 2;
    ArrayList <Predmet> predmety;

    public Inventar() {
        this.predmety = new ArrayList<>(kapacitaBatohu);
    }
    public void pridejPredmet(Predmet predmet) {
        predmety.add(predmet);
    }
    public void odeberPredmet(Predmet predmet) {
        predmety.remove(predmet);
    }

}
