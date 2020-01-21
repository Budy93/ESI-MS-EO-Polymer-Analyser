/**
 * 
 */
package de.daniel.brueggemann.tu.berlin.MSRechner;

/**
 * @author Daniel
 */

public final class KorrekturwerteDaten {
	private static double[] IonenPossitiv;
	private final static double[] IonenPossitivONatrium = {1.007276, 19.985217, 21.520550, 42.033823, 62.547097,
			1.007276, 33.033489, 38.963158, 42.033823, 76.919040, 83.060370, 1.007276, 28.02312, 38.963158};
	private final static double[] IonenPossitivWNatrium = {1.007276, 19.985217, 21.520550, 22.989218, 42.033823, 62.547097,
			1.007276, 22.989218, 33.033489, 38.963158, 42.033823, 44.971160, 64.015765, 76.919040, 83.060370, 1.007276,
			22.989218, 28.02312, 38.963158};
	private static int[] IonenLadung;
	private static int[] IonenLadungWN = {2, 2, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1};
	private static int[] IonenLadungON = {2, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1, 1, 2, 1};
	private static double[] IonenCharge;
	private static double[] IonenChargeWN = {0.5, 0.5, 0.5, 0.5, 0.5, 0.5, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2};
	private static double[] IonenChargeON = {0.5, 0.5, 0.5, 0.5, 0.5, 1, 1, 1, 1, 1, 1, 2, 2, 2};
	private static String[] IonName;
	private static String[] IonNameWN = {"M+2H", "M+H+K", "M+ACN+2H", "M+2Na", "M+2ACN+2H", "M+3ACN+2H", "M+H",
			"M+Na", "M+CH3OH+H", "M+K", "M+ACN+H", "M+2Na-H", "M+ACN+Na", "M+2K+H", "M+2ACN+H", "2M+H", "2M+Na",
			"2M+3H2O+2H", "2M+K"};
	private static String[] IonNameON = {"M+2H", "M+H+K", "M+ACN+2H", "M+2ACN+2H", "M+3ACN+2H", "M+H", "M+CH3OH+H", "M+K", "M+ACN+H", "M+2K+H", "M+2ACN+H", "2M+H", "2M+3H2O+2H", "2M+K"};
	/**
	 * 4,8,12,13,17
	 * {2, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1, 1, 2, 1};
	 * {0.5, 0.5, 0.5, 0.5, 0.5, 1, 1, 1, 1, 1, 1, 2, 2, 2};
	 * {"M+2H", "M+H+K", "M+ACN+2H", 4"M+2Na", "M+2ACN+2H", "M+3ACN+2H", "M+H",
	 * 8"M+Na", "M+CH3OH+H", "M+K", "M+ACN+H", 12"M+2Na-H", 13"M+ACN+Na", "M+2K+H", "M+2ACN+H", "2M+H", 17"2M+Na",
	 * "2M+3H2O+2H", "2M+K"}
	 */
	private static double MP2H = 1.007276;
	private static double MPHK = 19.985217;
	private boolean LaurinsauerePR;
	private boolean EOPR;
	private boolean DodecanolPR;

	private static boolean Natrium;

	/**
	 * @return the laurinsauerePR
	 */
	public boolean isLaurinsauerePR() {
		return LaurinsauerePR;
	}

	/**
	 * @param laurinsauerePR the laurinsauerePR to set
	 */
	public void setLaurinsauerePR(boolean laurinsauerePR) {
		LaurinsauerePR = laurinsauerePR;
	}

	/**
	 * @return the eOPR
	 */
	public boolean isEOPR() {
		return EOPR;
	}

	/**
	 * @param eOPR the eOPR to set
	 */
	public void setEOPR(boolean eOPR) {
		EOPR = eOPR;
	}

	/**
	 * @return the dodecanolPR
	 */
	public boolean isDodecanolPR() {
		return DodecanolPR;
	}

	/**
	 * @param dodecanolPR the dodecanolPR to set
	 */
	public void setDodecanolPR(boolean dodecanolPR) {
		DodecanolPR = dodecanolPR;
	}

	/**
	 * @return the ionenpossitiv
	 */
	public static double[] getIonenpossitiv() {
		return IonenPossitiv;
	}

	/**
	 * @return the ionenladung
	 */
	public static int[] getIonenladung() {
		return IonenLadung;
	}

	/**
	 * @return the ionencharge
	 */
	public static double[] getIonencharge() {
		return IonenCharge;
	}

	/**
	 * @return the ionname
	 */
	public static String[] getIonname() {
		return IonName;
	}

	/**
	 * @return the mp2h
	 */
	public static double getMp2h() {
		return MP2H;
	}

	/**
	 * @return the mphk
	 */
	public static double getMphk() {
		return MPHK;
	}

	public static double[] getIonenPossitivONatrium() {
		return IonenPossitivONatrium;
	}

	public static double[] getIonenPossitivWNatrium() {
		return IonenPossitivWNatrium;
	}

	public static void setIonenPossitiv(double[] ionenPossitiv) {
		IonenPossitiv = ionenPossitiv;
	}

	public boolean isNatrium() {
		return Natrium;
	}

	public static double[] getIonenPossitiv() {
		return IonenPossitiv;
	}

	public static int[] getIonenLadung() {
		return IonenLadung;
	}

	public static void setIonenLadung(int[] ionenLadung) {
		IonenLadung = ionenLadung;
	}

	public static int[] getIonenLadungWN() {
		return IonenLadungWN;
	}

	public static void setIonenLadungWN(int[] ionenLadungWN) {
		IonenLadungWN = ionenLadungWN;
	}

	public static int[] getIonenLadungON() {
		return IonenLadungON;
	}

	public static void setIonenLadungON(int[] ionenLadungON) {
		IonenLadungON = ionenLadungON;
	}

	public static double[] getIonenCharge() {
		return IonenCharge;
	}

	public static void setIonenCharge(double[] ionenCharge) {
		IonenCharge = ionenCharge;
	}

	public static double[] getIonenChargeWN() {
		return IonenChargeWN;
	}

	public static void setIonenChargeWN(double[] ionenChargeWN) {
		IonenChargeWN = ionenChargeWN;
	}

	public static double[] getIonenChargeON() {
		return IonenChargeON;
	}

	public static void setIonenChargeON(double[] ionenChargeON) {
		IonenChargeON = ionenChargeON;
	}

	public static String[] getIonName() {
		return IonName;
	}

	public static void setIonName(String[] ionName) {
		IonName = ionName;
	}

	public static String[] getIonNameWN() {
		return IonNameWN;
	}

	public static void setIonNameWN(String[] ionNameWN) {
		IonNameWN = ionNameWN;
	}

	public static String[] getIonNameON() {
		return IonNameON;
	}

	public static void setIonNameON(String[] ionNameON) {
		IonNameON = ionNameON;
	}

	public static double getMP2H() {
		return MP2H;
	}

	public static void setMP2H(double MP2H) {
		KorrekturwerteDaten.MP2H = MP2H;
	}

	public static double getMPHK() {
		return MPHK;
	}

	public static void setMPHK(double MPHK) {
		KorrekturwerteDaten.MPHK = MPHK;
	}

	public static void setNatrium(boolean natrium) {
		Natrium = natrium;
		if (natrium == true) {
			setIonenPossitiv(getIonenPossitivWNatrium());
			setIonenCharge(getIonenChargeWN());
			setIonenLadung(getIonenLadungWN());
			setIonName(getIonNameWN());
			//System.out.println(IonenPossitiv.length+" "+IonName.length+" "+ IonenCharge.length+" "+IonenLadung.length);
		} else {
			setIonenPossitiv(getIonenPossitivONatrium());
			setIonenCharge(getIonenChargeON());
			setIonenLadung(getIonenLadungON());
			setIonName(getIonNameON());
			//System.out.println(IonenPossitiv.length+" "+IonName.length+" "+ IonenCharge.length+" "+IonenLadung.length);
		}
	}


}
