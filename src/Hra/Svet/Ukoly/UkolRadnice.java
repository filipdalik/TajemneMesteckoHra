package Hra.Svet.Ukoly;

import Hra.Svet.Hrac;
import Hra.Svet.Predmet;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class UkolRadnice extends Ukol{

    private boolean jeSplnen = false;
    private Hrac hrac;

    public UkolRadnice( Hrac hrac) {
        super("ukolRadnice", hrac);
    }

    @Override
    public boolean spust() {

        if (jeSplnen) {
            System.out.println("Tento ukol jsi uz delal.");
            return true;
        }
        if (!hrac.getInventar().obsahujePredmet("stare_dokumenty")) {
            System.out.println("Nemáš potrebny predmet 'stare_dokumenty'! Bez nich nemuzes pokracovat.");
            return false;
        }

        Scanner sc = new Scanner(System.in);

        System.out.println("Starosta ti chce ukazat historii mesta.");
        System.out.println("Tvym ukolem je doplnit spravna slova do textu.");
        System.out.println();

        String[] napovedy = {
                "1) Mesto vzniklo pred vice nez 300 ____.",
                "2) Drive bylo znamou ____ oblasti.",
                "3) Nejvetsi rozvoj nastal diky mistni ____."
        };

        String[] spravne = { "lety", "rybarskou", "tovarne" };

        for (int i = 0; i < napovedy.length; i++) {
            System.out.println(napovedy[i]);
            System.out.print("Doplneni: ");
            String odpoved = sc.nextLine().trim().toLowerCase();

            if (!odpoved.equals(spravne[i])) {
                System.out.println("Spatne! Mas smulu, ukol nesplnen.");
                jeSplnen = true;
                return false;
            }
            System.out.println("Spravne!");
            System.out.println("-----------------------");
        }
        System.out.println();
        System.out.println("Odhalujes historii mesta...");
        System.out.println();
        try (BufferedReader br = new BufferedReader(new FileReader("resources/historie.txt"))) {
            String radek;
            while ((radek = br.readLine()) != null) {
                System.out.println(radek);
                sc.nextLine();
            }
        } catch (IOException e) {
            System.out.println("Chyba pri nacitani historie ze souboru.");
        }
        System.out.println();
        System.out.println("Starosta ti dekuje za pomoc. A dava ti kladivo.");
        hrac.getInventar().pridejPredmet(new Predmet("kladivo", "Predmet pro odemceni nemocnice.", "kladivo"));
        hrac.zvysitPocetUkolu();
        jeSplnen = true;
        return true;
    }
}
