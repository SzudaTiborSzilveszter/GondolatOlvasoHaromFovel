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
        tesztHaromOszlop();
        tesztOszlopErvenyes();
        tesztKeveres();
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
    
      private static void tesztHaromOszlop() {
        Pakli pakli = new Pakli();
        Lap[] lapok = pakli.getLapok();
        for (int sor = 0; sor < 7; sor++) {
            int db = 0;
            for (int oszlop = 1; oszlop <= 3; oszlop++) {
                int index = sor * 3 + oszlop;
                if (index < lapok.length && lapok[index] != null) {
                    db++;
                }
            }
            assert db == 3 : "Nem 3 lap van egy sorban";
        }
    }

    private static void tesztOszlopErvenyes() {
        assert oszlopErvenyes(1);
        assert oszlopErvenyes(2);
        assert oszlopErvenyes(3);
        assert !oszlopErvenyes(0);
        assert !oszlopErvenyes(4);
        assert !oszlopErvenyes(-1);
    }

    private static boolean oszlopErvenyes(int oszlop) {
        return oszlop >= 1 && oszlop <= 3;
    }

    private static void tesztKeveres() {
        Pakli pakli = new Pakli();
        Lap[] eredeti = pakli.getLapok().clone();
        pakli.kever(1);
        Lap[] kevert = pakli.getLapok();
        boolean megvaltozott = false;
        for (int i = 1; i < eredeti.length; i++) {
            if (eredeti[i] != kevert[i]) {
                megvaltozott = true;
            }
        }
        assert megvaltozott : "A keverés nem változtatta meg a sorrendet";
    }
}