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
        tesztKozepsoLap();
        tesztDuplikacio();
        System.out.println("\nLap tesztek:");
        tesztLapErtek();
        tesztLapSzin();
        tesztKulonbozoLapok();
        System.out.println("\nMinden teszt lefutott.");
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
        System.out.println("\tTeszt lapok száma: ✔");
    }

    private static void tesztNull() {
        Pakli pakli = new Pakli();
        Lap[] lapok = pakli.getLapok();
        for (int i = 1; i < lapok.length; i++) {
            assert lapok[i] != null : "Null lap található a pakliban";
        }
        System.out.println("\tTeszt null: ✔");
    }

    private static void tesztAlahuzas() {
        Pakli pakli = new Pakli();
        Lap[] lapok = pakli.getLapok();
        for (int i = 1; i < lapok.length; i++) {
            assert lapok[i].megj().contains("_") : "A lap nevében nincs aláhúzás";
        }
        System.out.println("\tTeszt aláhúzás: ✔");
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
        System.out.println("\tTeszt három oszlop: ✔");
    }

    private static void tesztOszlopErvenyes() {
        assert oszlopErvenyes(1);
        assert oszlopErvenyes(2);
        assert oszlopErvenyes(3);
        assert !oszlopErvenyes(0);
        assert !oszlopErvenyes(4);
        assert !oszlopErvenyes(-1);
        System.out.println("\tTeszt oszlopok száma: ✔");
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
        System.out.println("\tTeszt keverés: ✔");
    }
     private static void tesztKozepsoLap() {
        for (int oszlop = 1; oszlop <= 3; oszlop++) {
            Pakli pakli = new Pakli();
            Lap[] eredeti = pakli.getLapok();
            Set<Lap> valasztottOszlop = new HashSet<>();
            for (int sor = 0; sor < 7; sor++) {
                int index = sor * 3 + oszlop;
                valasztottOszlop.add(eredeti[index]);
            }
            pakli.kever(oszlop);
            assert valasztottOszlop.contains(pakli.ezVolt())
                    : "A kiválasztott oszlop nem került középre";
        }
        System.out.println("\tTeszt középső lap: ✔");
    }

    private static void tesztDuplikacio() {
        Pakli pakli = new Pakli();
        for (int kor = 1; kor <= 3; kor++) {
            pakli.kever(kor);
            Lap[] lapok = pakli.getLapok();
            Set<String> lapNevek = new HashSet<>();
            for (int i = 1; i < lapok.length; i++) {
                assert lapNevek.add(lapok[i].megj())
                        : "Duplikált lap található a pakliban";
            }
        }
        System.out.println("\tTeszt duplikáció: ✔");
    }

    private static void tesztLapErtek() {
        Lap lap = new Lap("P", "Ász");
        String eredeti = lap.getErtek();
        lap.megj();
        assert eredeti.equals(lap.getErtek())
                : "A Lap értéke megváltozott";
        System.out.println("\tTeszt lap értéke: ✔");
    }

    private static void tesztLapSzin() {
        Lap lap = new Lap("P", "Ász");
        String eredeti = lap.getSzin();
        lap.megj();
        assert eredeti.equals(lap.getSzin())
                : "A Lap színe megváltozott";
        System.out.println("\tTeszt lap színe: ✔");
    }

    private static void tesztKulonbozoLapok() {
        Lap lap1 = new Lap("🔔", "Ász");
        Lap lap2 = new Lap("🍁", "Ász");
        assert !lap1.megj().equals(lap2.megj())
                : "A különböző lapok neve megegyezik";
        System.out.println("\tTeszt különböző lapok: ✔");
    }
}