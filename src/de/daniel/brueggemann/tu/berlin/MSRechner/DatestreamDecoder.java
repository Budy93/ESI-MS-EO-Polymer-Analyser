package de.daniel.brueggemann.tu.berlin.MSRechner;

/**
 * The interface Datestream decoder.
 */
public interface DatestreamDecoder {

    /**
     * Decode to messdaten messdaten.
     *
     * @param datastream the datastream
     * @return the messdaten
     */
    Messdaten decodeToMessdaten(String[] datastream);
}
