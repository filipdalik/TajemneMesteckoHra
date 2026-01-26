package Hra.Svet;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString
@Getter
@Setter
@NoArgsConstructor

public class SpravovaniLokaci {
    private ArrayList<Lokace> lokace;
    private ArrayList<Npc> npccka;
    private ArrayList<Predmet> predmety;
}
