package Hra.Svet;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@NoArgsConstructor
/**
 * Trida, ktera slouzi ke spravovani dialogu
 */
public class SpravceDialogu {

    private boolean dialogAktivni = false;
    private Npc aktualniNpc;

    /**
     * Metoda, ktera nam vraci, jestli je dialog aktivni
     * @return vraci true/false zda je dialog aktivni
     */
    public boolean jeDialogAktivni() {
        return dialogAktivni;
    }

    /**
     * Metoda, ktera spusti dialog, ktery ma dane npc
     * @param npc
     * @return vraci dialog
     */
    public String startDialog(Npc npc) {
        dialogAktivni = true;
        aktualniNpc = npc;
        return npc.getDialog().getDialogText() + "\nA) " + npc.getDialog().getVolbaA() + "\nB) " + npc.getDialog().getVolbaB() + "\n";
    }

    /**
     * Metoda, ktera slouzi k odpovezeni na jednu nebo druhou volbu
     * @param volba
     * @return vraci odpoved
     */
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

    /**
     * Metoda, ktera ukonci dialog
     * @return vraci, ze je dialog ukoncen
     */
    public String ukoncitDialog() {
        dialogAktivni = false;
        aktualniNpc = null;
        return "Dialog ukoncen.";
    }
}