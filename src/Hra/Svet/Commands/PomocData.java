package Hra.Svet.Commands;

import java.util.List;

public class PomocData {
    private List<String> pomoci;

    public List<String> getPomoci() {
        return pomoci;
    }


    public String vypsaniPomoci() {
        StringBuilder sb = new StringBuilder();
        sb.append("Dostupné prikazy:\n");

        for (int i = 0; i < pomoci.size(); i++) {
            sb.append("- ").append(pomoci.get(i)).append("\n");
        }
        return sb.toString();
    }
}
