/**
 * 
 */
package de.daniel.brueggemann.tu.berlin.MSRechner;

/**
 * The type Analysen objekt.
 *
 * @author Daniel
 */
public class AnalysenObjekt
{
    /*
	 * private int zahl;
	private String wert;
	
	public MyObject(int zahl, String wert) 
	{
		this.zahl=zahl;
		this.wert=wert;
	}
	
	public int getZahl() {
		return zahl;
	}

	public String getWert() {
		return wert;
	}	
	 */
    /*
     * Brauchen:
     * MZ und Korrelierende MZ 2
     * relativit�t
     * EO anzahl korrektur(index 2
     */
    private int[] TrefferID;
    private double[] mZahl;
    private double[] mKorriergiert;
    private double[] relativwert;
    private double[] eoWert;
    private int[] IonenLadung;
    private double[] IonenCharge;
    private String[] Korrektur;
    private int[] korrekturWertID;

    /**
     * Getm zahl double [ ].
     *
     * @return the mZahl
     */
    public double[] getmZahl() {
        return mZahl;
    }

    /**
     * Sets analysen objekt.
     *
     * @param TrefferID       the treffer id
     * @param mZahl           the m zahl
     * @param mKorriergiert   the m korriergiert
     * @param relativwert     the relativwert
     * @param eoWert          the eo wert
     * @param IonenLadung     the ionen ladung
     * @param IonenCharge     the ionen charge
     * @param Korrektur       the korrektur
     * @param korrekturWertID the korrektur wert id
     */
    public void setAnalysenObjekt(int[] TrefferID, double[] mZahl, double[] mKorriergiert, double[] relativwert, double[] eoWert, int[] IonenLadung, double[] IonenCharge, String[] Korrektur, int[] korrekturWertID) {
        this.TrefferID = TrefferID;
        this.mZahl = mZahl;
        this.mKorriergiert = mKorriergiert;
        this.relativwert = relativwert;
        this.eoWert = eoWert;
        this.IonenLadung = IonenLadung;
        this.IonenCharge = IonenCharge;
        this.Korrektur = Korrektur;
        this.korrekturWertID = korrekturWertID;
    }

    /**
     * Sets zahl.
     *
     * @param mZahl the mZahl to set
     */
    public void setmZahl(double[] mZahl) {
        this.mZahl = mZahl;
    }

    /**
     * Getm korriergiert double [ ].
     *
     * @return the mKorriergiert
     */
    public double[] getmKorriergiert() {
        return mKorriergiert;
    }

    /**
     * Sets korriergiert.
     *
     * @param mKorriergiert the m korriergiert
     */
    public void setmKorriergiert(double[] mKorriergiert) {
        this.mKorriergiert = mKorriergiert;
    }

    /**
     * Get relativwert double [ ].
     *
     * @return the relativwert
     */
    public double[] getRelativwert() {
        return relativwert;
    }

    /**
     * Sets relativwert.
     *
     * @param relativwert the relativwert to set
     */
    public void setRelativwert(double[] relativwert) {
        this.relativwert = relativwert;
    }

    /**
     * Get eo wert double [ ].
     *
     * @return the eoWert
     */
    public double[] getEoWert() {
        return eoWert;
    }

    /**
     * Sets eo wert.
     *
     * @param eoWert the eoWert to set
     */
    public void setEoWert(double[] eoWert) {
        this.eoWert = eoWert;
    }

    /**
     * Get ionen ladung int [ ].
     *
     * @return the ionenLadung
     */
    public int[] getIonenLadung() {
        return IonenLadung;
    }

    /**
     * Sets ionen ladung.
     *
     * @param ionenLadung the ionenLadung to set
     */
    public void setIonenLadung(int[] ionenLadung) {
        IonenLadung = ionenLadung;
    }

    /**
     * Get ionen charge double [ ].
     *
     * @return the ionenCharge
     */
    public double[] getIonenCharge() {
        return IonenCharge;
    }

    /**
     * Sets ionen charge.
     *
     * @param ionenCharge the ionenCharge to set
     */
    public void setIonenCharge(double[] ionenCharge) {
        IonenCharge = ionenCharge;
    }

    /**
     * Get korrektur string [ ].
     *
     * @return the korrektur
     */
    public String[] getKorrektur() {
        return Korrektur;
    }

    /**
     * Sets korrektur.
     *
     * @param korrektur the korrektur to set
     */
    public void setKorrektur(String[] korrektur) {
        Korrektur = korrektur;
    }

    /**
     * Get korrektur wert id int [ ].
     *
     * @return the korrekturWertID
     */
    public int[] getKorrekturWertID() {
        return korrekturWertID;
    }

    /**
     * Sets korrektur wert id.
     *
     * @param korrekturWertID the korrekturWertID to set
     */
    public void setKorrekturWertID(int[] korrekturWertID) {
        this.korrekturWertID = korrekturWertID;
    }

    /**
     * Get treffer id int [ ].
     *
     * @return the trefferID
     */
    public int[] getTrefferID() {
        return TrefferID;
    }

    /**
     * Sets treffer id.
     *
     * @param trefferID the trefferID to set
     */
    public void setTrefferID(int[] trefferID) {
        TrefferID = trefferID;
    }

}
