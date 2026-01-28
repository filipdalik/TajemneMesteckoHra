package Hra.Svet.Commands;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileInputStream;
import java.io.InputStream;

public class CommandPomoc implements Command{
    @Override
    public String execute(String[] args) {
            ObjectMapper mapper = new ObjectMapper();
            try (InputStream input = new FileInputStream("resources/pomoc.json")) {

                PomocData data = mapper.readValue(input, PomocData.class);
                return data.vypsaniPomoci();

            } catch (Exception e) {
                return "Nepodarilo se nacíst pomoc.";
        }
    }
    @Override
    public boolean exit() {
        return false;
    }
}
