package Hra.Svet.Commands;

import Hra.Svet.Hrac;

/**
 * Trida, ktera slouzi k vypsani inventare hrace ve hre pomoci commandu
 */

public class CommandInventar implements Command {

    private Hrac hrac;

    public CommandInventar(Hrac hrac) {
        this.hrac = hrac;
    }

    /**
     * Metoda, ktera pomoci metody ve tride Inventar vypisuje inventar hrace
     * @param args
     * @return
     */
    @Override
    public String execute(String[] args) {
        String inventar = hrac.getInventar().vypisInventar();
        return inventar;
    }

    @Override
    public boolean exit() {
        return false;
    }
}
