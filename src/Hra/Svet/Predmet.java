package Hra.Svet;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@NoArgsConstructor
/**
 * Trida ktera slouzi k vytvoreni predmetu
 */

public class Predmet {
    private String id;
    private String nazev;
    private String popis;


    public Predmet(String id, String popis, String nazev) {
        this.id = id;
        this.popis = popis;
        this.nazev = nazev;
    }
}
