package test.test.Hra.Svet.Commands;
import Hra.Svet.Commands.CommandPouziti;
import Hra.Svet.Hrac;
import Hra.Svet.Lokace;
import Hra.Svet.Predmet;
import Hra.Svet.SpravovaniLokaci;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CommandPouzitiTest {

    CommandPouziti commandPouziti;
    Hrac hrac;
    SpravovaniLokaci spravovaniLokaci;

    @BeforeEach
    void setUp() {
        spravovaniLokaci = new SpravovaniLokaci();
        ArrayList<Lokace> seznamLokaci = new ArrayList<>();

        Lokace zamcenaMistnost = new Lokace();
        zamcenaMistnost.setId("zamceno_id");
        zamcenaMistnost.setJmeno("Zamcena Mistnost");
        zamcenaMistnost.setZamceno(true);

        seznamLokaci.add(zamcenaMistnost);
        spravovaniLokaci.setLokace(seznamLokaci);
        hrac = new Hrac("TestHrac", "zamceno_id", spravovaniLokaci);
        Predmet klic = new Predmet();
        klic.setId("klic");
        klic.setNazev("klic");
        hrac.getInventar().pridejPredmet(klic);
        commandPouziti = new CommandPouziti(hrac, spravovaniLokaci);
    }

    @Test
    void execute() {
        String[] parametry = {null, "klic"};
        commandPouziti.execute(parametry);
        Lokace lokace = spravovaniLokaci.getLokace("zamceno_id");
        assertEquals(false, lokace.isZamceno(), "Mistnost by mela byt po pouziti klice odemcena.");
    }


}
