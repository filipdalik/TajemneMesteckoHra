package Hra.Svet;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@NoArgsConstructor

public class SpravceDialogu {

    private boolean dialogAktivni = false;
    private Npc aktualniNpc;

    public boolean jeDialogAktivni() {
        return dialogAktivni;
    }

    public String startDialog(Npc npc) {
        dialogAktivni = true;
        aktualniNpc = npc;
        return npc.getDialog().getDialogText() + "\nA) " + npc.getDialog().getVolbaA() + "\nB) " + npc.getDialog().getVolbaB() + "\n";
    }

    public String odpovedet(String volba) {
        if (!dialogAktivni){
            return "Zadny dialog nebezi.";
        }

        if (volba.equals("A")) {
            return aktualniNpc.getDialog().getOdpovedA();
        } else {
            return aktualniNpc.getDialog().getOdpovedB();
        }
    }

    public String ukoncitDialog() {
        dialogAktivni = false;
        aktualniNpc = null;
        return "Dialog ukoncen.";
    }
}







//    private boolean aktivni = false;
//    private Npc aktualniPostava;
//    private Lokace aktualniLokace;
//
//    public SpravceDialogu(Npc aktualniPostava, Lokace aktualniLokace) {
//        this.aktualniPostava = aktualniPostava;
//        this.aktualniLokace = aktualniLokace;
//    }
//
//    public void startDialog(Npc npc) {
//        if (aktivni) {
//            System.out.println("Uz jsi v dialogu.");
//        }
//
//        aktivni = true;
//        aktualniPostava = npc;
//
//        System.out.println(npc.getDialog().getDialogText());
//        System.out.println("A) " + npc.getDialog().getVolbaA());
//        System.out.println("B) " + npc.getDialog().getVolbaB());
//    }
//
//    public void odpovedet(String option) {
//        if (!aktivni) {
//            System.out.println("Nejsi v dialogu.");
//        }
//
//        if (option.equals("A")) {
//            System.out.println(aktualniPostava.getDialog().getOdpovedA());
//        } else {
//            System.out.println(aktualniPostava.getDialog().getOdpovedB());
//        }
//
//        ukoncitDialog();
//    }
//
//    public void ukoncitDialog() {
//        aktivni = false;
//        aktualniPostava = null;
//        System.out.println("Dialog ukoncen.");
//    }
//
//    public boolean jeAktivni() {
//        return aktivni;
//    }
//}
