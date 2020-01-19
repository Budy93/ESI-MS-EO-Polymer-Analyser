package de.daniel.brueggemann.tu.berlin.MSRechner;


/**
 * The interface Filereader.
 */
public interface Filereader {

    /**
     * Readfile string [ ].
     *
     * @param Filename the filename
     * @return the string [ ]
     */
    String[] readfile(String Filename);

    /**
     * Dilereadertest.
     *
     * @param filename the filename
     */
    void dilereadertest(String filename);

    /**
     * Filelength int.
     *
     * @param filename the filename
     * @return the int
     */
    int filelength(String filename);


}