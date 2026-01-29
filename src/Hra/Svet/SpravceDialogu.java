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