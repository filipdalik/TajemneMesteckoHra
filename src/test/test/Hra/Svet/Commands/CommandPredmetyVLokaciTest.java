package test.test.Hra.Svet.Commands;

import Hra.Svet.Commands.CommandPredmetyVLokaci;
import Hra.Svet.Hrac;
import Hra.Svet.Lokace;
import Hra.Svet.Predmet;
import Hra.Svet.SpravovaniLokaci;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CommandPredmetyVLokaciTest {

     Hrac hrac;
     SpravovaniLokaci spravovaniLokaci;
     CommandPredmetyVLokaci commandPredmetyVLokaci;

    @BeforeEach
    void setUp() {
        spravovaniLokaci = new SpravovaniLokaci();
        ArrayList<Lokace> seznamLokaci = new ArrayList<>();

        Lokace mistnost = new Lokace();
        mistnost.setId("test_id");
        mistnost.setJmeno("Testovaci Mistnost");
        mistnost.setPredmety(new ArrayList<>());

        Predmet p1 = new Predmet();
        p1.setNazev("klic");
        mistnost.getPredmety().add(p1);

        seznamLokaci.add(mistnost);
        spravovaniLokaci.setLokace(seznamLokaci);

        hrac = new Hra.Svet.Hrac("TestHrac", "test_id", spravovaniLokaci);
        commandPredmetyVLokaci = new CommandPredmetyVLokaci(spravovaniLokaci, hrac);
    }

    @Test
    void execute() {
        String vysledek = commandPredmetyVLokaci.execute(new String[]{});
        assertTrue(vysledek.contains("klic"), "Vypis by mel obsahovat predmet 'klic'.");
    }
}
