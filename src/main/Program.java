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
    
    private static int melyik() {
        System.out.println("Válassza ki a kártya oszlopát! (1-3):");
        int valasztas = sc.nextInt();
        while (valasztas < 1 || valasztas > 3) {
            System.out.println("Nem megfelelő a szám!");
            System.out.println("Válassza ki a kártya oszlopát! (1-3):");
            valasztas = sc.nextInt();
        }
        return valasztas;
    }
}