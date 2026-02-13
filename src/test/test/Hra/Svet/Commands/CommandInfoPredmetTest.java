package test.test.Hra.Svet.Commands;

import Hra.Svet.Commands.CommandInfoPredmet;
import Hra.Svet.Hrac;
import Hra.Svet.Lokace;
import Hra.Svet.Predmet;
import Hra.Svet.SpravovaniLokaci;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommandInfoPredmetTest {

    private Hrac hrac;
    private CommandInfoPredmet commandInfoPredmet;
    private SpravovaniLokaci spravovaniLokaci;

    @BeforeEach
    void setUp() {
        spravovaniLokaci = new SpravovaniLokaci();
        ArrayList<Lokace> seznamLokaci = new ArrayList<>();
        Lokace lokace = new Lokace();
        lokace.setId("start_id");
        lokace.setJmeno("Startovni mistnost");
        lokace.setZamceno(false);
        seznamLokaci.add(lokace);

        spravovaniLokaci.setLokace(seznamLokaci);
        hrac = new Hrac("TestHrac", "start_id", spravovaniLokaci);
        commandInfoPredmet = new CommandInfoPredmet(hrac);
    }

    @Test
    void execute() {
        String[] parametryBezNazvu = {"info"};
        String vysledekBezNazvu = commandInfoPredmet.execute(parametryBezNazvu);
        assertEquals("Musis napsat, o jaky predmet chces informace.", vysledekBezNazvu, "Spatna hlaska pri chybejicim parametru.");

        Predmet mec = new Predmet("mec_id", "Ostry zelezny mec", "Mec");
        hrac.getInventar().pridejPredmet(mec);

        String[] parametryMec = {"info", "Mec"};
        String vysledekMec = commandInfoPredmet.execute(parametryMec);

        String ocekavanyVystup = "Predmet: Mec Popis: Ostry zelezny mec";
        assertEquals(ocekavanyVystup, vysledekMec, "Informace o predmetu neodpovidaji.");

        String[] parametryNeexistuje = {"info", "Kamen"};
        String vysledekNeexistuje = commandInfoPredmet.execute(parametryNeexistuje);
        assertEquals("Tento predmet nemas v inventari.", vysledekNeexistuje, "Spatna hlaska pro neexistujici predmet.");
    }
}
