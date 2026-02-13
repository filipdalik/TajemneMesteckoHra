package Hra.Svet.Commands;
import Hra.Svet.*;

/**
 * Trida, ktera slouzi se spusteni dialogu ve hre pomoci commandu
 */
public class CommandDialog implements Command {

    private Hrac hrac;
    private SpravovaniLokaci spravovaniLokaci;
    private SpravceDialogu dialog;
    private int cislo;

    public CommandDialog(int cislo, Hrac hrac, SpravovaniLokaci spravovaniLokaci, SpravceDialogu dialog) {
        this.cislo = cislo;
        this.hrac = hrac;
        this.spravovaniLokaci = spravovaniLokaci;
        this.dialog = dialog;
    }

    /**
     * Metoda, ktera slouzi k spusteni dialogu ve hre, vzdy podle odpovedi vybere a nebo b a pak vypise danou vetu dialogu
     * @param args
     * @return vraci prubeh dialogu
     */
    @Override
    public String execute(String[] args) {

        if (args.length == 0) {
            return "Neplatny prikaz.";
        }
        if (cislo == 1) {
            if (dialog.jeDialogAktivni())
                return "Dialog uz probiha.";

            Npc npc = null;
            for (int i = 0; i < spravovaniLokaci.getLokace().size(); i++) {
                if (spravovaniLokaci.getLokace().get(i).getId().equals(hrac.getiDMistnosti())) {
                    npc = spravovaniLokaci.getLokace().get(i).getNpc();
                    break;
                }
            }

            if (npc == null) {
                return "Nikdo tu neni.";
            }

            return dialog.startDialog(npc);
        } else if (cislo == 2) {
            if (!dialog.jeDialogAktivni()) {
                return "Dialog momentalne neprobiha, nejprve ho musis spustit.";
            }
            return dialog.odpovedet("A");
        } else if (cislo == 3) {
            if (!dialog.jeDialogAktivni()) {
                return "Dialog momentalne neprobiha, nejprve ho musis spustit.";
            }
            return dialog.odpovedet("B");
        } else {
            if (!dialog.jeDialogAktivni()) {
                return "Dialog momentalne neprobiha, nejprve ho musis spustit.";
            }
            return dialog.ukoncitDialog();
        }
    }

    @Override
    public boolean exit() {
        return false;
    }
}
