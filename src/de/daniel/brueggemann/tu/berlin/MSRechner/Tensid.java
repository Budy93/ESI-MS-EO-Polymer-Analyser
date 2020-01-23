package de.daniel.brueggemann.tu.berlin.MSRechner;

/**
 * The type Tensid.
 */
public class Tensid {

    private String Name;
    private double MW;
    private double MN;
    private double PDI;
    private double EO;
    private double CO2;
    private double CO2Gehalt;
    private double selectivitaet;

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return Name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        Name = name;
    }

    /**
     * Gets mw.
     *
     * @return the mw
     */
    public double getMW() {
        return MW;
    }

    /**
     * Sets mw.
     *
     * @param MW the mw
     */
    public void setMW(double MW) {
        this.MW = MW;
    }

    /**
     * Gets mn.
     *
     * @return the mn
     */
    public double getMN() {
        return MN;
    }

    /**
     * Sets mn.
     *
     * @param MN the mn
     */
    public void setMN(double MN) {
        this.MN = MN;
    }

    /**
     * Gets pdi.
     *
     * @return the pdi
     */
    public double getPDI() {
        return PDI;
    }

    /**
     * Sets pdi.
     *
     * @param PDI the pdi
     */
    public void setPDI(double PDI) {
        this.PDI = PDI;
    }

    /**
     * Gets eo.
     *
     * @return the eo
     */
    public double getEO() {
        return EO;
    }

    /**
     * Sets eo.
     *
     * @param EO the eo
     */
    public void setEO(double EO) {
        this.EO = EO;
    }

    /**
     * Gets co 2.
     *
     * @return the co 2
     */
    public double getCO2() {
        return CO2;
    }

    /**
     * Sets co 2.
     *
     * @param CO2 the co 2
     */
    public void setCO2(double CO2) {
        this.CO2 = CO2;
    }

    /**
     * Gets co 2 gehalt.
     *
     * @return the co 2 gehalt
     */
    public double getCO2Gehalt() {
        return CO2Gehalt;
    }

    /**
     * Sets co 2 gehalt.
     *
     * @param CO2Gehalt the co 2 gehalt
     */
    public void setCO2Gehalt(double CO2Gehalt) {
        this.CO2Gehalt = CO2Gehalt;
    }

    /**
     * Instantiates a new Tensid.
     *
     * @param name      the name
     * @param mw        the mw
     * @param mn        the mn
     * @param pdi       the pdi
     * @param eo        the eo
     * @param co2       the co 2
     * @param co2Gehalt the co 2 gehalt
     */
    public void Tenside(String name, double mw, double mn, double pdi, double eo, double co2, double co2Gehalt, double selectivitaet) {
        this.Name = name;
        this.MW = mw;
        this.MN = mn;
        this.PDI = pdi;
        this.EO = eo;
        this.CO2 = co2;
        this.CO2Gehalt = co2Gehalt;
        this.selectivitaet = selectivitaet;
    }

    public double getSelectivitaet() {
        return selectivitaet;
    }

    public void setSelectivitaet(double selectivitaet) {
        this.selectivitaet = selectivitaet;
    }
}
