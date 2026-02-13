package Hra.Svet;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
/**
 * Trida, ktera nacita soubor JSON a uklada jeho obsah do tridy SpravovaniLokaci
 */
public class NacteniMapy {
    public SpravovaniLokaci getSpravovaniLokaci(){
        return SpravovaniLokaci;
    }
    private SpravovaniLokaci SpravovaniLokaci;

    /**
     * Metoda, ktera nacita JSON pomoci jmena souboru
     * @param jmenoSouboru
     */
    public void nacteniMapy(String jmenoSouboru){
        ObjectMapper parser = new ObjectMapper();
        try{
            InputStream input = new FileInputStream(jmenoSouboru);
            SpravovaniLokaci = parser.readValue(input, SpravovaniLokaci.class);
            SpravovaniLokaci.init();
        } catch (FileNotFoundException e) {
            System.out.println("Soubor nebyl nalezen. Chyba: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}