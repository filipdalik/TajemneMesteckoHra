package Hra.Svet.Commands;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Trida, ktera slouzi k vypsani mapy
 */

public class CommandMapa implements Command{
    public CommandMapa() {
    }

    /**
     * Metoda vypisujici mapu pomoci BufferedReader ze souboru
     * @param args
     * @return
     */
    @Override
    public String execute(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("resources/celaMapa.txt"))){
            String radek;
            while ((radek = br.readLine()) != null){
                System.out.println(radek);
            }
        } catch (IOException e) {
            return "Chyba s načítáním mapy.";
        }
        return "";
    }

    @Override
    public boolean exit() {
        return false;
    }

}
