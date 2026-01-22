package Svet;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class NacteniMapy {

    public SpravovaniLokaci getSpravovaniLokaci(){
        return SpravovaniLokaci;
    }
    private SpravovaniLokaci SpravovaniLokaci;
    public void nacteniMapy(String resourcePath){
        ObjectMapper parser = new ObjectMapper();
        try{
            InputStream input = new FileInputStream(resourcePath);
            SpravovaniLokaci = parser.readValue(input, SpravovaniLokaci.class);
        } catch (FileNotFoundException e) {
            System.out.println("Soubor nebyl nalezen. Chyba: " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}