package main;

import java.util.Scanner;

public class Program {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        Pakli pakli = new Pakli();
    }
    private static void kirak(Pakli pakli) {
        Lap[] lapok = pakli.getLapok();
        for (int i = 0; i < 7; i++) {
            System.out.printf(
                    "%-12s %-12s %-12s%n",
                    lapok[i * 3 + 1].megj(),
                    lapok[i * 3 + 2].megj(),
                    lapok[i * 3 + 3].megj()
            );
        }
    }
}