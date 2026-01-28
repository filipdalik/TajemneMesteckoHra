package Hra.Svet.Commands;

import Hra.Svet.Hrac;
import Hra.Svet.SpravovaniLokaci;

import java.util.HashMap;
import java.util.Scanner;

public class Konzole {

    private HashMap<String,Command> seznamPrikazu;
    private boolean isExit;
    private Scanner scanner;

    public Konzole() {
        this.isExit = false;
        this.scanner = new Scanner(System.in);
        this.seznamPrikazu = new HashMap<>();
    }

    public void inicialization(Hrac hrac, SpravovaniLokaci spravovaniLokaci){
        seznamPrikazu.put("jdi", new CommandPohyb(hrac, spravovaniLokaci));
        seznamPrikazu.put("mapa",new CommandMapa());
        seznamPrikazu.put("pomoc",new CommandPomoc());
        seznamPrikazu.put("konec",new CommandExit());
        seznamPrikazu.put("pouzij",new CommandPouziti(hrac));
        seznamPrikazu.put("zahod", new CommandZahod(hrac, spravovaniLokaci));
        seznamPrikazu.put("seber", new CommandSeber(hrac, spravovaniLokaci));
        seznamPrikazu.put("info", new CommandInfoPredmet(hrac));
        seznamPrikazu.put("inventar", new CommandInventar(hrac));

    }

    public void execute(){
        System.out.print(">>");
        String prikaz = scanner.nextLine();
        prikaz = prikaz.trim().toLowerCase();
        String prikazy[] = prikaz.split(" ");
        if(seznamPrikazu.containsKey(prikazy[0])){
            System.out.println(seznamPrikazu.get(prikazy[0]).execute(prikazy));
            isExit = seznamPrikazu.get(prikazy[0]).exit();
        }else{
            System.out.println("Prikaz neexistuje, zkus to znovu, pripadne si procti seznam vsech prikazu pomoci prikazu 'pomoc'");
        }
    }

    public void start(Hrac hrac, SpravovaniLokaci spravovaniLokaci){
        inicialization(hrac,spravovaniLokaci);
        do{
            execute();
        }while(!isExit);
    }
}