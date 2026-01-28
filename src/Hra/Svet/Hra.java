package Hra.Svet;

import Hra.Svet.Commands.Konzole;
import java.util.Scanner;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@NoArgsConstructor

public class Hra {

    Scanner scanner = new Scanner(System.in);
    private SpravceDialogu spravceDialogu= new SpravceDialogu();
    private String aktualniLokace = "Okraj_mesta";
    public void ZacitHru(){
        NacteniMapy nacteniMapy = new NacteniMapy();
        nacteniMapy.nacteniMapy("resources/mapa.json");

        Konzole konzole = new Konzole(spravceDialogu);
        System.out.println("Jak se chcete jmenovat??");
        System.out.println("_______________________________");
        String jmenoHrace = scanner.next();
        Hrac hrac = new Hrac(jmenoHrace,"Okraj_mesta",nacteniMapy.getSpravovaniLokaci());
        aktualniLokace = hrac.getAktualniMistnost() ;
        Inventar inventar = new Inventar();
        konzole.start(hrac,nacteniMapy.getSpravovaniLokaci(),spravceDialogu);
    }
}
