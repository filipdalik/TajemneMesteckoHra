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
    private boolean aktivni = false;
    private Npc aktualniPostava;

    public SpravceDialogu(boolean active, Npc aktualniPostava) {
        this.aktivni = active;
        this.aktualniPostava = aktualniPostava;
    }

    public void startDialog(Npc npc) {
        if (aktivni) {
            System.out.println("Uz jsi v dialogu.");
            return;
        }

        aktivni = true;
        aktualniPostava = npc;

        System.out.println(npc.getDialog().getDialogText());
        System.out.println("A) " + npc.getDialog().getVolbaA());
        System.out.println("B) " + npc.getDialog().getVolbaB());
    }

    public void odpovedet(String option) {
        if (!aktivni) {
            System.out.println("Nejsi v dialogu.");
            return;
        }

        if (option.equals("A")) {
            System.out.println(aktualniPostava.getDialog().getOdpovedA());
        } else {
            System.out.println(aktualniPostava.getDialog().getOdpovedB());
        }

        ukoncitDialog();
    }

    public void ukoncitDialog() {
        aktivni = false;
        aktualniPostava = null;
        System.out.println("Dialog ukoncen.");
    }

    public boolean jeAktivni() {
        return aktivni;
    }
}
