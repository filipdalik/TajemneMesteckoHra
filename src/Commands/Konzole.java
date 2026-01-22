package Commands;

import Svet.Hrac;
import Svet.SpravovaniLokaci;

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
        seznamPrikazu.put("jdi", new CommandGO(hrac, spravovaniLokaci));
        seznamPrikazu.put("mapa",new CommandMapa());
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
            System.out.println("Příkaz neexistuje, zkus to znovu, případně si pročti seznam všech příkazů pomocí příkazu 'help'");
        }
    }

    public void start(Hrac hrac, SpravovaniLokaci spravovaniLokaci){
        inicialization(hrac,spravovaniLokaci);
        do{
            execute();
        }while(!isExit);
    }
}
