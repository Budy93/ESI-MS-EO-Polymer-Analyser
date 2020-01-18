/**
 * 
 */
package de.daniel.brueggemann.tu.berlin.MSRechner;

/**
 * @author Daniel
 *
 */

public final class KorrekturwerteDaten
{
    private final static double[] IonenPossitiv = {1.007276, 19.985217, 21.520550, 22.989218, 42.033823, 62.547097,
            1.007276, 22.989218, 33.033489, 38.963158, 42.033823, 44.971160, 64.015765, 76.919040, 83.060370, 1.007276,
            22.989218, 28.02312, 38.963158};
    private final static int[] IonenLadung = {2, 2, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1};
    private final static double[] IonenCharge = {0.5, 0.5, 0.5, 0.5, 0.5, 0.5, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2};
    private final static String[] IonName = {"M+2H", "M+H+K", "M+ACN+2H", "M+2Na", "M+2ACN+2H", "M+3ACN+2H", "M+H",
            "M+Na", "M+CH3OH+H", "M+K", "M+ACN+H", "M+2Na-H", "M+ACN+Na", "M+2K+H", "M+2ACN+H", "2M+H", "2M+Na",
            "2M+3H2O+2H", "2M+K"};
	private final static double MP2H = 1.007276;
	private final static double MPHK = 19.985217;
	private boolean LaurinsauerePR;
	private boolean EOPR;
	private boolean DodecanolPR;
	/**
	 * @return the laurinsauerePR
	 */
	private boolean isLaurinsauerePR()
	{
		return LaurinsauerePR;
	}
	/**
	 * @param laurinsauerePR the laurinsauerePR to set
	 */
	private void setLaurinsauerePR(boolean laurinsauerePR)
	{
		LaurinsauerePR = laurinsauerePR;
	}
	/**
	 * @return the eOPR
	 */
	private boolean isEOPR()
	{
		return EOPR;
	}
	/**
	 * @param eOPR the eOPR to set
	 */
	private void setEOPR(boolean eOPR)
	{
		EOPR = eOPR;
	}
	/**
	 * @return the dodecanolPR
	 */
	private boolean isDodecanolPR()
	{
		return DodecanolPR;
	}
	/**
	 * @param dodecanolPR the dodecanolPR to set
	 */
	private void setDodecanolPR(boolean dodecanolPR)
	{
		DodecanolPR = dodecanolPR;
	}
	/**
	 * @return the ionenpossitiv
	 */
	private static double[] getIonenpossitiv()
	{
		return IonenPossitiv;
	}
	/**
	 * @return the ionenladung
	 */
	private static int[] getIonenladung()
	{
		return IonenLadung;
	}
	/**
	 * @return the ionencharge
	 */
	private static double[] getIonencharge()
	{
		return IonenCharge;
	}
	/**
	 * @return the ionname
	 */
	private static String[] getIonname()
	{
		return IonName;
	}
	/**
	 * @return the mp2h
	 */
	private static double getMp2h()
	{
		return MP2H;
	}
	/**
	 * @return the mphk
	 */
	private static double getMphk()
	{
		return MPHK;
	}

	

}
