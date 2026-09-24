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
    public void kever(int valasztottOszlop) {
        Lap[] ujPakli = new Lap[22];
        switch (valasztottOszlop) {
            case 1 -> {
                for (int i = 1; i <= 7; i++) {
                    ujPakli[i] = lapok[20 - (i - 1) * 3];
                    ujPakli[i + 7] = lapok[19 - (i - 1) * 3];
                    ujPakli[i + 14] = lapok[21 - (i - 1) * 3];
                }
            }
            case 2 -> {
                for (int i = 1; i <= 7; i++) {
                    ujPakli[i] = lapok[19 - (i - 1) * 3];
                    ujPakli[i + 7] = lapok[20 - (i - 1) * 3];
                    ujPakli[i + 14] = lapok[21 - (i - 1) * 3];
                }
            }
            case 3 -> {
                for (int i = 1; i <= 7; i++) {
                    ujPakli[i] = lapok[19 - (i - 1) * 3];
                    ujPakli[i + 7] = lapok[21 - (i - 1) * 3];
                    ujPakli[i + 14] = lapok[20 - (i - 1) * 3];
                }
            }
        }
        this.lapok = ujPakli;
    }
    public Lap ezVolt() {
        return lapok[11];
    }
}