package main;

import java.util.Arrays;

public class Pakli {
    protected Lap[] lapok;
    public Pakli() {
        this(21);
    }
    public Pakli(int db) {
        this.lapok = new Lap[db + 1];
        feltolt();
    }
    private void feltolt() {
        String[] szinek = {"♠", "♣", "♥", "♦"};
        String[] ertekek = {"Ász", "Kir", "Fel", "X", "IX", "VIII"};
        int db = 0;
        for (String szin : szinek) {
            for (String ertek : ertekek) {
                if (db < 21) {
                    lapok[++db] = new Lap(szin, ertek);
                }
            }
        }
    }
    public Lap[] getLapok() {
        return Arrays.copyOf(lapok, lapok.length);
    }
    
    public Lap ezVolt() {
        return lapok[11];
    }
}