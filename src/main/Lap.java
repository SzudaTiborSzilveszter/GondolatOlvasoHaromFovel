package main;

public class Lap {
    private String ertek;
    private String szin;

    public Lap(String ertek, String szin) {
        this.ertek = ertek;
        this.szin = szin;
    }

    public String getErtek() {
        return ertek;
    }

    public String getSzin() {
        return szin;
    }
    public String megj() {
        return szin + "_" + ertek;
    }
}
