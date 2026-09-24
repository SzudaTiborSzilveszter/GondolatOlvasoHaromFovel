package GondolotOlvasoHaromFovelTeszt;

import main.Lap;
import main.Pakli;

public class Teszt {
    public static void main(String[] args) {
        System.out.println("Pakli tesztek:");
        tesztLapokSzama();
        tesztNull();
        tesztAlahuzas();
        tesztHaromOszlop();
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
        ellenoriz(db == 21, "21 lap van a pakliban");
    }

    private static void tesztNull() {
        Pakli pakli = new Pakli();
        Lap[] lapok = pakli.getLapok();
        boolean nincsNull = true;
        for (int i = 1; i < lapok.length; i++) {
            if (lapok[i] == null) {
                nincsNull = false;
            }
        }
        ellenoriz(nincsNull, "Nincs null lap a pakliban");
    }

    private static void tesztAlahuzas() {
        Pakli pakli = new Pakli();
        Lap[] lapok = pakli.getLapok();
        boolean mindenbenVan = true;
        for (int i = 1; i < lapok.length; i++) {
            if (!lapok[i].megj().contains("_")) {
                mindenbenVan = false;
            }
        }
        ellenoriz(mindenbenVan, "Minden lap nevében van aláhúzás");
    }

    private static void tesztHaromOszlop() {
        Pakli pakli = new Pakli();
        Lap[] lapok = pakli.getLapok();
        boolean haromOszlop = true;
        for (int sor = 0; sor < 7; sor++) {
            int darab = 0;
            for (int oszlop = 1; oszlop <= 3; oszlop++) {
                int index = sor * 3 + oszlop;
                if (index < lapok.length && lapok[index] != null) {
                    darab++;
                }
            }
            if (darab != 3) {
                haromOszlop = false;
            }
        }
        ellenoriz(haromOszlop, "3 oszlop van");
    }
    
    private static void ellenoriz(boolean feltetel, String tesztNeve) {
        if (feltetel) {
            System.out.println(tesztNeve + " - OK");
        } else {
            System.out.println(tesztNeve + " - HIBA");
        }
    }
}