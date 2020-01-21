package de.daniel.brueggemann.tu.berlin.MSRechner;

public interface Einleser {

    /**
     * Liest einen belibige Integerzahl ein.
     *
     * @return Integer
     */
    public int Zahleinleser();

    /**
     * Liest einen bliebigen String ein.
     *
     * @return String
     */
    public String Stringeinleser();

    public Boolean JaoderNein();
}
