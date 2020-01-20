package de.daniel.brueggemann.tu.berlin.MSRechner;

public class Treffer {
    public int getTreffer() {
        return Treffer;
    }

    public void setTreffer(int treffer) {
        Treffer = treffer;
    }

    public int getDoppelt() {
        return Doppelt;
    }

    public void setDoppelt(int doppelt) {
        Doppelt = doppelt;
    }

    public int getKeinTreffer() {
        return KeinTreffer;
    }

    public void setKeinTreffer(int keinTreffer) {
        KeinTreffer = keinTreffer;
    }

    public int getEindeutig() {
        return eindeutig;
    }

    public void setEindeutig(int eindeutig) {
        this.eindeutig = eindeutig;
    }

    /**
     * ausgabe[0] = ergebnis;
     * ausgabe[1] = doppelt;
     * ausgabe[2] = nop;
     * ausgabe[3] = eindeutig;
     */
    private int Treffer;
    private int Doppelt;
    private int KeinTreffer;
    private int eindeutig;
}
