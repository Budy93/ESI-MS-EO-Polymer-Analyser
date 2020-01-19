package de.daniel.brueggemann.tu.berlin.MSRechner;

/**
 * The type Datestream decoder.
 */
public class DatestreamDecoderImpl implements DatestreamDecoder {

    private Messdaten messdaten = new Messdaten();

    /**
     * Gets messdaten.
     *
     * @return the messdaten
     */
    public Messdaten getMessdaten() {
        return messdaten;
    }

    /**
     * Sets messdaten.
     *
     * @param messdaten the messdaten
     */
    public void setMessdaten(Messdaten messdaten) {
        this.messdaten = messdaten;
    }


    public Messdaten decodeToMessdaten(String[] datastream) {
        Messdaten ms = new Messdaten();
        int lenge = datastream.length;

        double[] dataidatenArray = new double[lenge * 3];
        double[] mzZahl = new double[lenge];
        double[] intensitaet = new double[lenge];
        double[] relativ = new double[lenge];
        int counter = 0;
        for (int a = 0; a < lenge; a++) {
            int zeiger = 0;
            String[] datenStringablage = datastream[a].trim().split("\\s+");
            mzZahl[a] = Double.parseDouble(datenStringablage[zeiger]);
            zeiger++;
            intensitaet[a] = Double.parseDouble(datenStringablage[zeiger]);
            zeiger++;
            relativ[a] = Double.parseDouble(datenStringablage[zeiger]);
            //System.out.println(datenStringablage.length);
            for (int b = 0; b < datenStringablage.length; b++) {
                dataidatenArray[counter] = Double.parseDouble(datenStringablage[b]);
                counter++;
            }
        }
        ms.Messdaten(mzZahl, intensitaet, relativ);
        setMessdaten(ms);
        return getMessdaten();
    }
}
