/**
 * 
 */
package de.daniel.brueggemann.tu.berlin.MSRechner;

/**
 * @author Daniel
 *
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
	 * @return the mZahl
	 */
	public double[] getmZahl()
	{
		return mZahl;
	}
	
	/**
	 * @param TrefferID
	 * @param mZahl
	 * @param mKorriergiert
	 * @param relativwert
	 * @param eoWert
	 * @param IonenLadung
	 * @param IonenCharge
	 * @param Korrektur
	 * @param korrekturWertID
	 */
	public void setAnalysenObjekt(int[] TrefferID, double[] mZahl, double[] mKorriergiert, double[] relativwert, double[] eoWert, int[] IonenLadung, double[] IonenCharge, String[] Korrektur, int[] korrekturWertID)
	{
		this.mZahl = mZahl;
		this.mKorriergiert = mKorriergiert;
		this.relativwert = relativwert;
		this.eoWert = eoWert;
		this.IonenLadung=IonenLadung;
		this.IonenCharge=IonenCharge;
		this.Korrektur=Korrektur;
		this.korrekturWertID=korrekturWertID;
	}
	/**
	 * @param mZahl the mZahl to set
	 */
	public void setmZahl(double[] mZahl)
	{
		this.mZahl = mZahl;
	}
	/**
	 * @return the mKorriergiert
	 */
	public double[] getmKorriergiert()
	{
		return mKorriergiert;
	}
	/**
	 * @param set the correctet MZ after ESI correction.
	 */
	public void setmKorriergiert(double[] mKorriergiert)
	{
		this.mKorriergiert = mKorriergiert;
	}
	/**
	 * @return the relativwert
	 */
	public double[] getRelativwert()
	{
		return relativwert;
	}
	/**
	 * @param relativwert the relativwert to set
	 */
	public void setRelativwert(double[] relativwert)
	{
		this.relativwert = relativwert;
	}
	/**
	 * @return the eoWert
	 */
	public double[] getEoWert()
	{
		return eoWert;
	}
	/**
	 * @param eoWert the eoWert to set
	 */
	public void setEoWert(double[] eoWert)
	{
		this.eoWert = eoWert;
	}
	/**
	 * @return the ionenLadung
	 */
	public int[] getIonenLadung()
	{
		return IonenLadung;
	}
	/**
	 * @param ionenLadung the ionenLadung to set
	 */
	public void setIonenLadung(int[] ionenLadung)
	{
		IonenLadung = ionenLadung;
	}
	/**
	 * @return the ionenCharge
	 */
	public double[] getIonenCharge()
	{
		return IonenCharge;
	}
	/**
	 * @param ionenCharge the ionenCharge to set
	 */
	public void setIonenCharge(double[] ionenCharge)
	{
		IonenCharge = ionenCharge;
	}
	/**
	 * @return the korrektur
	 */
	public String[] getKorrektur()
	{
		return Korrektur;
	}
	/**
	 * @param korrektur the korrektur to set
	 */
	public void setKorrektur(String[] korrektur)
	{
		Korrektur = korrektur;
	}
	/**
	 * @return the korrekturWertID
	 */
	public int[] getKorrekturWertID()
	{
		return korrekturWertID;
	}
	/**
	 * @param korrekturWertID the korrekturWertID to set
	 */
	public void setKorrekturWertID(int[] korrekturWertID)
	{
		this.korrekturWertID = korrekturWertID;
	}

	/**
	 * @return the trefferID
	 */
	public int[] getTrefferID()
	{
		return TrefferID;
	}

	/**
	 * @param trefferID the trefferID to set
	 */
	public void setTrefferID(int[] trefferID)
	{
		TrefferID = trefferID;
	}

}
