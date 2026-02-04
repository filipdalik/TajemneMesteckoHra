package Hra.Svet.Ukoly;

import Hra.Svet.Hrac;
import Hra.Svet.Predmet;
import Hra.Svet.SpravovaniLokaci;

import java.util.Random;
import java.util.Scanner;


public class SoubojSPolicistouMiniHra extends Ukol {
    private boolean jeSplnen = false;
    private int zivotyPolicisty = 3;

    public SoubojSPolicistouMiniHra(Hrac hrac) {
        super("soubojSPolicistou", hrac);
    }

    @Override
    public boolean spust() {
        if (!hrac.getInventar().jePlny()) {
        if (jeSplnen) {
            System.out.println("Tento ukol uz jsi splnil.");
            return true;
        }

        Scanner sc = new Scanner(System.in);
        Random rnd = new Random();

        System.out.println("Zacina souboj s policistou!");
        System.out.println("Mas 2 zivoty, policista ma 3 zivoty.");
        System.out.println("Souboj ma 5 kol.");
        System.out.println();

        for (int kolo = 1; kolo <= 5; kolo++) {

            System.out.println("=== KOLO " + kolo + " ===");
            System.out.println("Tve zivoty: " + hrac.getZivoty());
            System.out.println("Zivoty policisty: " + zivotyPolicisty);
            System.out.print("Zadej akci (utok / obrana / jed): ");
            String hracAkce = sc.nextLine();

            if (!hracAkce.equals("utok") && !hracAkce.equals("obrana") && !hracAkce.equals("jed")) {
                System.out.println("Neplatna akce! Ztracis kolo.");
                hracAkce = "nic";
            }

            String[] moznosti = {"utok", "obrana", "nic"};
            String policistaAkce = moznosti[rnd.nextInt(3)];

            System.out.println("Policista zvolil: " + policistaAkce);

            if (hracAkce.equals("utok")) {
                if (policistaAkce.equals("utok")) {
                    System.out.println("Oba ztracite zivot.");
                    hrac.ubratZivoty(1);
                    zivotyPolicisty = zivotyPolicisty- 1;
                } else if (policistaAkce.equals("obrana")) {
                    System.out.println("Policista utok ubranil.");
                } else if (policistaAkce.equals("nic")) {
                    System.out.println("Policista nic neudelal a tim jsi mu ubral 2 zivoty.");
                    zivotyPolicisty = zivotyPolicisty - 2;
                }
            }else if (hracAkce.equals("obrana")) {
                if (policistaAkce.equals("utok")) {
                    System.out.println("Hezky jsi se ubranil a neztratil zivot.");
                }

            }else if (hracAkce.equals("jed")) {
                if (!hrac.getInventar().obsahujePredmet("jed")) {
                    System.out.println("Nemas jed, akce ztracena!");
                } else {
                    hrac.getInventar().odeberPredmet("jed");
                    if (policistaAkce.equals("utok")) {
                        System.out.println("Pouzil jsi jed a timjsi ubral policistovi 2 zivoty, ten ale zautocil a tobe take jeden ubral.");
                        hrac.ubratZivoty(1);
                        zivotyPolicisty = zivotyPolicisty - 2;
                    } else if (policistaAkce.equals("obrana")) {
                        System.out.println("Policistovi jsi ubral jeden zivot, protoze se stihl ubranit.");
                        zivotyPolicisty = zivotyPolicisty - 1;
                    } else if (policistaAkce.equals("nic")) {
                        System.out.println("Policista nic neudelal a ta jsi ho dodelal. Gratulujeme");
                        zivotyPolicisty = zivotyPolicisty - 3;
                    }
                }
            }



            if (hrac.getZivoty() <= 0) {
                System.out.println("Umrel jsi! Konec hry!");
                System.exit(0);
            }

            if (zivotyPolicisty <= 0) {
                System.out.println("Policista je porazen!");
                System.out.println("Ziskal jsi klic! Ukol jsi splnil, pokracuj dal.....");
                hrac.getInventar().pridejPredmet(new Predmet("klic", "Slouzi k otevreni elektrarny.", "Klic"));
                jeSplnen = true;
            }
            }
        }
        System.out.println("Zahod jeden predmet, at mas misto minimalne na jeden predmet.");
        return false;
    }
}