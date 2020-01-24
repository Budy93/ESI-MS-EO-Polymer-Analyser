package de.daniel.brueggemann.tu.berlin.MSRechner;

/**
 * The interface Filewriter.
 */
public interface Filewriter {
    /**
     * Writtereport boolean.
     *
     * @param filename       the filename
     * @param tensid         the tensid
     * @param treffer        the treffer
     * @param analysenObjekt the analysen objekt
     * @return the boolean
     */
    public boolean writtereport(String filename, Tensid tensid, Treffer treffer, AnalysenObjekt analysenObjekt);

    /**
     * Writte date boolean.
     *
     * @param filename the filename
     * @param daten    the daten
     * @return the boolean
     */
    public boolean writteDate(String filename, String[] daten);
}
