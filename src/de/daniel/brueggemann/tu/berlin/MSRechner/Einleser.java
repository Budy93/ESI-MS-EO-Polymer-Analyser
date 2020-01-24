package de.daniel.brueggemann.tu.berlin.MSRechner;

/**
 * The interface Einleser.
 */
public interface Einleser {

    /**
     * Liest einen belibige Integerzahl ein.
     *
     * @return Integer int
     */
    int Zahleinleser();

    /**
     * Liest einen bliebigen String ein.
     *
     * @return String string
     */
    String Stringeinleser();

    /**
     * Jaoder nein boolean.
     *
     * @return the boolean
     */
    Boolean JaoderNein();

    /**
     * Doublereader double.
     *
     * @return the double
     */
    double doublereader();
}
