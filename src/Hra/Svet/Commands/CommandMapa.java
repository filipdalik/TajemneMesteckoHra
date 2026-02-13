package Hra.Svet.Commands;

import java.io.*;

/**
 * Trida, ktera slouzi k vypsani mapy
 */

public class CommandMapa implements Command{
    public CommandMapa() {
    }

    /**
     * Metoda vypisujici mapu pomoci BufferedReader ze souboru
     * @param args
     * @return vraci mapu
     */
    @Override
    public String execute(String[] args) {
        InputStream input = CommandMapa.class.getResourceAsStream("/celaMapa.txt");
        if(input == null) {
            throw new RuntimeException("Nelze nacist");
        }
        try (BufferedReader br = new BufferedReader(new InputStreamReader(input))){
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
