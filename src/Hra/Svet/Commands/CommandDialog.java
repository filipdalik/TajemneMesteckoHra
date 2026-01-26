package Hra.Svet.Commands;
import Hra.Svet.Hra;
import Hra.Svet.Npc;
import Hra.Svet.SpravceDialogu;

public class CommandDialog implements Command{

    @Override
    public String execute(String[] args, Hra hra) {

        SpravceDialogu dm = hra.getSpravceDialogu();

        switch (args[0]) {
            case "spustit_dialog":
                Npc npc = hra.getAktualniLokace().getNpc();
                //TODO naimportovat NPC
                if (npc == null) {
                    System.out.println("Nikdo tu neni.");
                } else {
                    dm.startDialog(npc);
                }
                break;

            case "odpovedet_a":
                dm.odpovedet("A");
                break;

            case "odpovedet_b":
                dm.odpovedet("B");
                break;

            case "ukoncit_dialog":
                dm.ukoncitDialog();
                break;
        }
    }

    @Override
    public boolean exit() {
        return false;
    }
}
