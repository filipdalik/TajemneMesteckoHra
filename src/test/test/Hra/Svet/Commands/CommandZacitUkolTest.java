package test.test.Hra.Svet.Commands;

import Hra.Svet.Commands.CommandZacitUkol;
import Hra.Svet.Hrac;
import Hra.Svet.Lokace;
import Hra.Svet.SpravovaniLokaci;
import Hra.Svet.Ukoly.SpravceUkolu;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CommandZacitUkolTest {

    @Test
    void execute() {
        SpravovaniLokaci spravovaniLokaci = new SpravovaniLokaci();
        ArrayList<Lokace> seznamLokaci = new ArrayList<>();

        Lokace mistnost = new Lokace();
        mistnost.setId("test_id");
        mistnost.setJmeno("Testovaci Mistnost");
        mistnost.setJmenoUkol("testUkol");
        mistnost.setSplneniUkolu(false);
        mistnost.setPredmety(new ArrayList<>());

        seznamLokaci.add(mistnost);
        spravovaniLokaci.setLokace(seznamLokaci);
        spravovaniLokaci.setNpccka(new ArrayList<>());
        spravovaniLokaci.setPredmety(new ArrayList<>());

        Hrac hrac = new Hrac("TestHrac", "test_id", spravovaniLokaci);
        SpravceUkolu spravceUkolu = new SpravceUkolu(hrac);
        CommandZacitUkol command = new CommandZacitUkol(spravovaniLokaci,spravceUkolu,hrac);

        String vysledek = command.execute(new String[]{});
        assertNotNull(vysledek);
    }

}
