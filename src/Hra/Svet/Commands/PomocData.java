package Hra.Svet.Commands;

import java.util.List;

/**
 * Trida, ktera spravuje data s pomoci z JSONu
 */

public class PomocData {
    private List<String> pomoci;

    public List<String> getPomoci() {
        return pomoci;
    }

    /**
     * Metoda, ktera z JSONu vypisuje pomoc pomoci stringBuilderu, jsou sepisovany pod sebe
     * @return vraci pomoc
     */
    public String vypsaniPomoci() {
        StringBuilder sb = new StringBuilder();
        sb.append("Dostupné prikazy:\n");

        for (int i = 0; i < pomoci.size(); i++) {
            sb.append("- ").append(pomoci.get(i)).append("\n");
        }
        return sb.toString();
    }
}
