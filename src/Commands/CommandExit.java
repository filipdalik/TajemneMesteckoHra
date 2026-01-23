package Commands;

import java.util.Scanner;

public class CommandExit implements Command{
    private Scanner sc = new Scanner(System.in);
    private boolean konec = false;
    @Override
    public String execute(String[] args) {
        System.out.println("Opravdu chcete hru ukoncit??");
        String odpoved = sc.next();
        switch (odpoved) {
            case "ano" -> {
                konec = true;
                return "Hra se ukoncila.....";
            }
            case "ne" -> {
                return "Hra pokracuje.......";
            }
            default -> {
                return "Neplatna odpoved. Napis 'ano' nebo 'ne'.";
            }
        }
    }

    @Override
    public boolean exit() {
        return konec;
    }
}
