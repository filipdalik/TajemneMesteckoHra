package Hra.Svet;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@NoArgsConstructor

public class Predmet {
    private String id;
    private String nazev;
    private String popis;

    public void pouzij(Hrac hrac) {
        System.out.println("Pouzil jsi " + nazev + ".");
    }
}
