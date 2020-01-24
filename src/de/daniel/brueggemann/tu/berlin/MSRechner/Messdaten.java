package de.daniel.brueggemann.tu.berlin.MSRechner;

/**
 * The type Messdaten.
 */
class Messdaten {
    private double[] MzZahl;
    private double[] Intensitaet;
    private double[] Relativ;

    /**
     * Messdaten.
     *
     * @param mzZahl      the mz zahl
     * @param intensitaet the intensitaet
     * @param relativ     the relativ
     */
    public void Messdaten(double[] mzZahl, double[] intensitaet, double[] relativ) {
        MzZahl = mzZahl;
        Intensitaet = intensitaet;
        Relativ = relativ;
    }

    /**
     * Get intensitaet double [ ].
     *
     * @return the double [ ]
     */
    public double[] getIntensitaet() {
        return Intensitaet;
    }

    /**
     * Sets intensitaet.
     *
     * @param intensitaet the intensitaet
     */
    public void setIntensitaet(double[] intensitaet) {
        Intensitaet = intensitaet;
    }

    /**
     * Get relativ double [ ].
     *
     * @return the double [ ]
     */
    public double[] getRelativ() {
        return Relativ;
    }

    /**
     * Sets relativ.
     *
     * @param relativ the relativ
     */
    public void setRelativ(double[] relativ) {
        Relativ = relativ;
    }

    /**
     * Get mz zahl double [ ].
     *
     * @return the double [ ]
     */
    public double[] getMzZahl() {
        return MzZahl;
    }

    /**
     * Sets mz zahl.
     *
     * @param mzZahl the mz zahl
     */
    public void setMzZahl(double[] mzZahl) {
        MzZahl = mzZahl;
    }
}
