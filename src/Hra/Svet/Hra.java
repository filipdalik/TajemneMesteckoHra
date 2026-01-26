package Hra.Svet;

import Hra.Svet.Commands.Konzole;

import java.util.Scanner;

public class Hra {

    Scanner scanner = new Scanner(System.in);

    public void ZacitHru(){
        NacteniMapy nacteniMapy = new NacteniMapy();
        nacteniMapy.nacteniMapy("resources/mapa.json");

        Konzole konzole = new Konzole();
        System.out.println("Jak se chcete jmenovat??");
        System.out.println("_______________________________");
        String jmenoHrace = scanner.next();
        Hrac hrac = new Hrac(jmenoHrace,"Okraj_mesta",nacteniMapy.getSpravovaniLokaci());
        Inventar inventar = new Inventar();
        konzole.start(hrac,nacteniMapy.getSpravovaniLokaci());
    }
}
