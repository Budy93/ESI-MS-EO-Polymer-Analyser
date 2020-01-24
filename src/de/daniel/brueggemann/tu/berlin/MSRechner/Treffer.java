package de.daniel.brueggemann.tu.berlin.MSRechner;

/**
 * The type Treffer.
 */
public class Treffer {
    /**
     * Gets treffer.
     *
     * @return the treffer
     */
    public int getTreffer() {
        return Treffer;
    }

    /**
     * Sets treffer.
     *
     * @param treffer the treffer
     */
    public void setTreffer(int treffer) {
        Treffer = treffer;
    }

    /**
     * Gets doppelt.
     *
     * @return the doppelt
     */
    public int getDoppelt() {
        return Doppelt;
    }

    /**
     * Sets doppelt.
     *
     * @param doppelt the doppelt
     */
    public void setDoppelt(int doppelt) {
        Doppelt = doppelt;
    }

    /**
     * Gets kein treffer.
     *
     * @return the kein treffer
     */
    public int getKeinTreffer() {
        return KeinTreffer;
    }

    /**
     * Sets kein treffer.
     *
     * @param keinTreffer the kein treffer
     */
    public void setKeinTreffer(int keinTreffer) {
        KeinTreffer = keinTreffer;
    }

    /**
     * Gets eindeutig.
     *
     * @return the eindeutig
     */
    public int getEindeutig() {
        return eindeutig;
    }

    /**
     * Sets eindeutig.
     *
     * @param eindeutig the eindeutig
     */
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

    /**
     * Gets messwerte.
     *
     * @return the messwerte
     */
    public int getMesswerte() {
        return Messwerte;
    }

    /**
     * Sets messwerte.
     *
     * @param messwerte the messwerte
     */
    public void setMesswerte(int messwerte) {
        Messwerte = messwerte;
    }

    private int Messwerte;
}
