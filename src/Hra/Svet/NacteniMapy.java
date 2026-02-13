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
        return spravovaniLokaci;
    }
    private SpravovaniLokaci spravovaniLokaci;

    /**
     * Metoda, ktera nacita JSON pomoci jmena souboru
     * @param jmenoSouboru
     */
    public void nacteniMapy(String jmenoSouboru){
        ObjectMapper parser = new ObjectMapper();
        InputStream input = NacteniMapy.class.getResourceAsStream(jmenoSouboru);

        try(input){
            spravovaniLokaci = parser.readValue(input, SpravovaniLokaci.class);
            spravovaniLokaci.init();
        } catch (FileNotFoundException e) {
            System.out.println("Soubor nebyl nalezen. Chyba:" + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();


        }
    }
}