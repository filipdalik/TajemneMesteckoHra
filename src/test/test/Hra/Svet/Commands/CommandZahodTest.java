package test.test.Hra.Svet.Commands;

import Hra.Svet.Commands.CommandZahod;
import Hra.Svet.Hrac;
import Hra.Svet.Lokace;
import Hra.Svet.Predmet;
import Hra.Svet.SpravovaniLokaci;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommandZahodTest {

    Hrac hrac;
    SpravovaniLokaci spravovaniLokaci;
    CommandZahod commandZahod;

    @BeforeEach
    void setUp() {
        spravovaniLokaci = new SpravovaniLokaci();
        ArrayList<Lokace> seznamLokaci = new ArrayList<>();
        Lokace mistnost = new Lokace();

        mistnost.setId("test_id");
        mistnost.setJmeno("Testovaci Mistnost");
        mistnost.setZamceno(false);
        mistnost.setPredmety(new ArrayList<>());
        seznamLokaci.add(mistnost);
        spravovaniLokaci.setLokace(seznamLokaci);
        hrac = new Hrac("TestHrac", "test_id", spravovaniLokaci);

        Predmet predmet = new Predmet();
        predmet.setId("test_predmet");
        predmet.setNazev("test_predmet");
        predmet.setPopis("Testovaci predmet");
        hrac.getInventar().pridejPredmet(predmet);
        commandZahod = new CommandZahod(hrac, spravovaniLokaci);
    }

    @Test
    void execute() {
        String[] parametry = {null, "test_predmet"};
        commandZahod.execute(parametry);
        assertEquals(1, hrac.getInventar().getPredmety().size(), "Inventar by mel byt prazdny.");
        Lokace lokace = spravovaniLokaci.getLokace("test_id");
        assertEquals(1, lokace.getPredmety().size(), "Predmet by se mel nachazet v lokaci.");
        assertEquals("test_predmet", lokace.getPredmety().get(0).getId());
    }
}