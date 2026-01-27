package Hra.Svet.Commands;
import Hra.Svet.Hra;
import Hra.Svet.Npc;
import Hra.Svet.SpravceDialogu;

public class CommandDialog implements Command{

    @Override
    public String execute(String[] args) {
//
//        SpravceDialogu dm = hra.getSpravceDialogu();
//
//        switch (args[0]) {
//            case "spustit_dialog":
//                for (int i = 0; i < 7; i++) {
//                    if (hra.getAktualniLokace().equals()) {
//                }
//                Npc npc = hra.getAktualniLokace().equals()getNpc();
//                //TODO naimportovat NPC
//                if (npc == null) {
//                    System.out.println("Nikdo tu neni.");
//                } else {
//                    dm.startDialog(npc);
//                }
//                break;
//
//            case "odpovedet_a":
//                dm.odpovedet("A");
//                break;
//
//            case "odpovedet_b":
//                dm.odpovedet("B");
//                break;
//
//            case "ukoncit_dialog":
//                dm.ukoncitDialog();
//                break;
//        }
        return "null";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
