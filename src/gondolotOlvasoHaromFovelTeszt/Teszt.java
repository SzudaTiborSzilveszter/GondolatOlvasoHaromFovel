package gondolotOlvasoHaromFovelTeszt;

import java.util.HashSet;
import java.util.Set;
import main.Lap;
import main.Pakli;

public class Teszt {
    public static void main(String[] args) {
        System.out.println("Pakli tesztek:");
        tesztLapokSzama();
        tesztNull();
        tesztAlahuzas();
        System.out.println("Lap tesztek:");
        System.out.println("Minden teszt sikeres.");
    }

    private static void tesztLapokSzama() {
        Pakli pakli = new Pakli();
        Lap[] lapok = pakli.getLapok();
        int db = 0;
        for (int i = 1; i < lapok.length; i++) {
            if (lapok[i] != null) {
                db++;
            }
        }
        assert db == 21 : "Nem 21 lap van a pakliban";
    }

    private static void tesztNull() {
        Pakli pakli = new Pakli();
        Lap[] lapok = pakli.getLapok();
        for (int i = 1; i < lapok.length; i++) {
            assert lapok[i] != null : "Null lap található a pakliban";
        }
    }

    private static void tesztAlahuzas() {
        Pakli pakli = new Pakli();
        Lap[] lapok = pakli.getLapok();
        for (int i = 1; i < lapok.length; i++) {
            assert lapok[i].megj().contains("_") : "A lap nevében nincs aláhúzás";
        }
    }    
}