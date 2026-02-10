package test.test.Hra.Svet.Commands;
import Hra.Svet.*;
import Hra.Svet.Commands.CommandPohyb;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CommandPohybTest {

        CommandPohyb commandPohyb;
        Hrac hrac;
        SpravovaniLokaci spravovaniLokaci;

        @BeforeEach
        void setUp() {
            spravovaniLokaci = new SpravovaniLokaci();
            ArrayList<Lokace> seznamLokaci = new ArrayList<>();

            Lokace start = new Lokace();
            start.setId("start_id");
            start.setJmeno("Start");
            start.setZamceno(false);

            Lokace cil = new Lokace();
            cil.setId("cil_id");
            cil.setJmeno("Cil");
            cil.setZamceno(false);

            Pripojeni pripojeni = new Pripojeni();
            pripojeni.setRovne("cil_id");

            start.setPripojeni(pripojeni);
            seznamLokaci.add(start);
            seznamLokaci.add(cil);

            spravovaniLokaci.setLokace(seznamLokaci);
            hrac = new Hrac("TestHrac", "start_id", spravovaniLokaci);
            hrac.setiDMistnosti("start_id");
            commandPohyb = new CommandPohyb(hrac, spravovaniLokaci);
        }

        @Test
        void execute() {

            String[] parametry = {null, "rovne"};
            commandPohyb.execute(parametry);
            assertEquals("cil_id", hrac.getiDMistnosti(), "Hrac se mel presunout do cilove lokace.");
        }
    }