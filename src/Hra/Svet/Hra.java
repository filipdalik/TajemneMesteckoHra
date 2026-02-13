package Hra.Svet;

import Hra.Svet.Commands.Konzole;

import java.util.Scanner;

import Hra.Svet.Ukoly.SpravceUkolu;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@NoArgsConstructor
/**
 * Trida, ktera slouzi k vytvoreni hry a zde se vytvari vsechny nejdulezitejsi prvky hry
 */
public class Hra {
    private Scanner scanner = new Scanner(System.in);
    private SpravceDialogu spravceDialogu= new SpravceDialogu();
    private SpravceUkolu spravceUkolu;

    private String aktualniLokace = "Okraj_mesta";

    /**
     * Metoda, ktera slouzi k zacatku hry, vypisuje uvod a ziskava pomoci Scanneru jmeno hrace
     */
    public void ZacitHru(){
        NacteniMapy nacteniMapy = new NacteniMapy();
        nacteniMapy.nacteniMapy("Resources/mapa.json");
        Konzole konzole = new Konzole(spravceDialogu);
        String hraNadpis = "╦ ╦┬─┐┌─┐  ┌─┐  ╔╦╗┌─┐ ┬┌─┐┌┬┐┌┐┌┌─┐┌┬┐  ╔╦╗┌─┐┌─┐┌┬┐┌─┐┌─┐┬┌─┬ ┬\n" +
                "╠═╣├┬┘├─┤  │ │   ║ ├─┤ │├┤ ││││││├┤ │││  ║║║├┤ └─┐ │ ├┤ │  ├┴┐│ │\n" +
                "╩ ╩┴└─┴ ┴  └─┘   ╩ ┴ ┴└┘└─┘┴ ┴┘└┘└─┘┴ ┴  ╩ ╩└─┘└─┘ ┴ └─┘└─┘┴ ┴└─┘";
        System.out.println(PURPLE+"_________________________________________________________________"+RESET);
        System.out.println(YELLOW+hraNadpis+RESET);
        System.out.println(PURPLE+"_________________________________________________________________"+RESET);
        System.out.println();
        System.out.println(UNDERLINE+BLUE+"Jak se chcete jmenovat??"+RESET);
        System.out.print("VASE JMENO: ");
        String jmenoHrace = scanner.next();
        System.out.println("Super jdeme na to "+jmenoHrace+"!");
        Hrac hrac = new Hrac(jmenoHrace,"Okraj_mesta",nacteniMapy.getSpravovaniLokaci());
        aktualniLokace = hrac.getAktualniMistnost() ;
        spravceUkolu = new SpravceUkolu(hrac);
        System.out.println("Prave se nachazis v lokaci "+hrac.getAktualniMistnost()+".");
        System.out.println("Probudil ses u rozbité silnice poblíž zničeného auta. Pro vice informaci si spust dialog.");
        konzole.start(hrac,nacteniMapy.getSpravovaniLokaci(),spravceDialogu, spravceUkolu);
    }
    public static final String RESET = "\u001B[0m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String UNDERLINE = "\u001B[4m";
    public static final String RED = "\u001B[31m";


}
