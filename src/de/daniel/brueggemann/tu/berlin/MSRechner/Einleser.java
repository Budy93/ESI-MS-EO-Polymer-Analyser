package de.daniel.brueggemann.tu.berlin.MSRechner;

public interface Einleser {

    /**
     * Liest einen belibige Integerzahl ein.
     *
     * @return Integer
     */
    int Zahleinleser();

    /**
     * Liest einen bliebigen String ein.
     *
     * @return String
     */
    String Stringeinleser();

    Boolean JaoderNein();

    double doublereader();
}
