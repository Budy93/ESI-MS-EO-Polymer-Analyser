package de.daniel.brueggemann.tu.berlin.MSRechner;

/**
 * The type Ergenissverwaltung.
 */
public class Ergenissverwaltung {
    private int[] TrefferID;
    private int EindeutigeEinzelwerte;
    private int Mehrfachtreffer;
    private int KeineTreffer;
    private int AnzahlMesswerte;
    private int TrefferGesamt;
    private int[][] Trefferart;
    private String[] Typen = new String[]{"Einzellergebnis", "Doppelergebnis", "Kein Ergebnis"};
    private int[][] TrefferIDMZzahl;

    /**
     * Get treffer id int [ ].
     *
     * @return int [ ]
     */
    public int[] getTrefferID() {
        return TrefferID;
    }

    /**
     * Sets treffer id.
     *
     * @param trefferID the treffer id
     */
    public void setTrefferID(int[] trefferID) {
        TrefferID = trefferID;
    }

    /**
     * Gets eindeutige einzelwerte.
     *
     * @return the eindeutige einzelwerte
     */
    public int getEindeutigeEinzelwerte() {
        return EindeutigeEinzelwerte;
    }

    /**
     * Sets eindeutige einzelwerte.
     *
     * @param eindeutigeEinzelwerte the eindeutige einzelwerte
     */
    public void setEindeutigeEinzelwerte(int eindeutigeEinzelwerte) {
        EindeutigeEinzelwerte = eindeutigeEinzelwerte;
    }

    /**
     * Gets mehrfachtreffer.
     *
     * @return the mehrfachtreffer
     */
    public int getMehrfachtreffer() {
        return Mehrfachtreffer;
    }

    /**
     * Sets mehrfachtreffer.
     *
     * @param mehrfachtreffer the mehrfachtreffer
     */
    public void setMehrfachtreffer(int mehrfachtreffer) {
        Mehrfachtreffer = mehrfachtreffer;
    }

    /**
     * Gets keine treffer.
     *
     * @return the keine treffer
     */
    public int getKeineTreffer() {
        return KeineTreffer;
    }

    /**
     * Sets keine treffer.
     *
     * @param keineTreffer the keine treffer
     */
    public void setKeineTreffer(int keineTreffer) {
        KeineTreffer = keineTreffer;
    }

    /**
     * Gets anzahl messwerte.
     *
     * @return the anzahl messwerte
     */
    public int getAnzahlMesswerte() {
        return AnzahlMesswerte;
    }

    /**
     * Sets anzahl messwerte.
     *
     * @param anzahlMesswerte the anzahl messwerte
     */
    public void setAnzahlMesswerte(int anzahlMesswerte) {
        AnzahlMesswerte = anzahlMesswerte;
    }

    /**
     * Gets treffer gesamt.
     *
     * @return the treffer gesamt
     */
    public int getTrefferGesamt() {
        return TrefferGesamt;
    }

    /**
     * Sets treffer gesamt.
     *
     * @param trefferGesamt the treffer gesamt
     */
    public void setTrefferGesamt(int trefferGesamt) {
        TrefferGesamt = trefferGesamt;
    }

    /**
     * Get trefferart int [ ] [ ].
     *
     * @return the int [ ] [ ]
     */
    public int[][] getTrefferart() {
        return Trefferart;
    }

    /**
     * Sets trefferart.
     *
     * @param trefferart the trefferart
     */
    public void setTrefferart(int[][] trefferart) {
        Trefferart = trefferart;
    }

    /**
     * Get typen string [ ].
     *
     * @return the string [ ]
     */
    public String[] getTypen() {
        return Typen;
    }

    /**
     * Sets typen.
     *
     * @param typen the typen
     */
    public void setTypen(String[] typen) {
        Typen = typen;
    }

    /**
     * Get treffer idm zzahl int [ ] [ ].
     *
     * @return the int [ ] [ ]
     */
    public int[][] getTrefferIDMZzahl() {
        return TrefferIDMZzahl;
    }

    /**
     * Sets treffer idm zzahl.
     *
     * @param trefferIDMZzahl the treffer idm zzahl
     */
    public void setTrefferIDMZzahl(int[][] trefferIDMZzahl) {
        TrefferIDMZzahl = trefferIDMZzahl;
    }
}
