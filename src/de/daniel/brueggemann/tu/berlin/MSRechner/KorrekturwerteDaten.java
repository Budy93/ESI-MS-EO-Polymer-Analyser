/**
 * 
 */
package de.daniel.brueggemann.tu.berlin.MSRechner;

/**
 * The type Korrekturwerte daten.
 *
 * @author Daniel
 */
public final class KorrekturwerteDaten {
	private static double[] IonenPossitiv;
	private final static double[] IonenPossitivONatrium = {1.007276, 19.985217, 21.520550, 42.033823, 62.547097,
			1.007276, 33.033489, 38.963158, 42.033823, 76.919040, 83.060370, 1.007276, 28.02312, 38.963158, -1.007276, -1.007276, -19.01839, -1.007276, 36.948606, 59.013851, -1.007276, 59.013851, 1.007276};
	private final static double[] IonenPossitivWNatrium = {1.007276, 19.985217, 21.520550, 22.989218, 42.033823, 62.547097,
			1.007276, 22.989218, 33.033489, 38.963158, 42.033823, 44.971160, 64.015765, 76.919040, 83.060370, 1.007276,
			22.989218, 28.02312, 38.963158, -1.007276, -1.007276, -19.01839, -1.007276, 36.948606, 59.013851, -1.007276, 59.013851, 1.007276};
	private static int[] IonenLadung;
	private static int[] IonenLadungWN = {2, 2, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, -3, -2, -1, -1, -1, -1, -1, -1, -1};
	private static int[] IonenLadungON = {2, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1, 1, 2, 1, -3, -2, -1, -1, -1, -1, -1, -1, -1};
	private static double[] IonenCharge;
	private static double[] IonenChargeWN = {0.5, 0.5, 0.5, 0.5, 0.5, 0.5, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 0.333333333, 0.5, 1, 1, 1, 1, 2, 2, 3};
	private static double[] IonenChargeON = {0.5, 0.5, 0.5, 0.5, 0.5, 1, 1, 1, 1, 1, 1, 2, 2, 2, 0.333333333, 0.5, 1, 1, 1, 1, 2, 2, 3};
	private static String[] IonName;
	private static String[] IonNameWN = {"M+2H", "M+H+K", "M+ACN+2H", "M+2Na", "M+2ACN+2H", "M+3ACN+2H", "M+H",
			"M+Na", "M+CH3OH+H", "M+K", "M+ACN+H", "M+2Na-H", "M+ACN+Na", "M+2K+H", "M+2ACN+H", "2M+H", "2M+Na",
			"2M+3H2O+2H", "2M+K", "M-3H", "M-2H", "M-H2O-H", "M-H", "M+K-2H", "M+Hac-H", "2M-H", "2M+Hac-H", "3M-H"};
	private static String[] IonNameON = {"M+2H", "M+H+K", "M+ACN+2H", "M+2ACN+2H", "M+3ACN+2H", "M+H", "M+CH3OH+H", "M+K", "M+ACN+H", "M+2K+H", "M+2ACN+H", "2M+H", "2M+3H2O+2H", "2M+K", "M-3H", "M-2H", "M-H2O-H", "M-H", "M+K-2H", "M+Hac-H", "2M-H", "2M+Hac-H", "3M-H"};
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
     * Is laurinsauere pr boolean.
     *
     * @return the laurinsauerePR
     */
    public boolean isLaurinsauerePR() {
        return LaurinsauerePR;
    }

    /**
     * Sets laurinsauere pr.
     *
     * @param laurinsauerePR the laurinsauerePR to set
     */
    public void setLaurinsauerePR(boolean laurinsauerePR) {
        LaurinsauerePR = laurinsauerePR;
    }

    /**
     * Is eopr boolean.
     *
     * @return the eOPR
     */
    public boolean isEOPR() {
        return EOPR;
    }

    /**
     * Sets eopr.
     *
     * @param eOPR the eOPR to set
     */
    public void setEOPR(boolean eOPR) {
        EOPR = eOPR;
    }

    /**
     * Is dodecanol pr boolean.
     *
     * @return the dodecanolPR
     */
    public boolean isDodecanolPR() {
        return DodecanolPR;
    }

    /**
     * Sets dodecanol pr.
     *
     * @param dodecanolPR the dodecanolPR to set
     */
    public void setDodecanolPR(boolean dodecanolPR) {
        DodecanolPR = dodecanolPR;
    }

    /**
     * Get ionenpossitiv double [ ].
     *
     * @return the ionenpossitiv
     */
    public static double[] getIonenpossitiv() {
        return IonenPossitiv;
    }

    /**
     * Get ionenladung int [ ].
     *
     * @return the ionenladung
     */
    public static int[] getIonenladung() {
        return IonenLadung;
    }

    /**
     * Get ionencharge double [ ].
     *
     * @return the ionencharge
     */
    public static double[] getIonencharge() {
        return IonenCharge;
    }

    /**
     * Get ionname string [ ].
     *
     * @return the ionname
     */
    public static String[] getIonname() {
        return IonName;
    }

    /**
     * Gets mp 2 h.
     *
     * @return the mp2h
     */
    public static double getMp2h() {
        return MP2H;
    }

    /**
     * Gets mphk.
     *
     * @return the mphk
     */
    public static double getMphk() {
        return MPHK;
    }

    /**
     * Get ionen possitiv o natrium double [ ].
     *
     * @return the double [ ]
     */
    public static double[] getIonenPossitivONatrium() {
        return IonenPossitivONatrium;
    }

    /**
     * Get ionen possitiv w natrium double [ ].
     *
     * @return the double [ ]
     */
    public static double[] getIonenPossitivWNatrium() {
        return IonenPossitivWNatrium;
    }

    /**
     * Sets ionen possitiv.
     *
     * @param ionenPossitiv the ionen possitiv
     */
    public static void setIonenPossitiv(double[] ionenPossitiv) {
        IonenPossitiv = ionenPossitiv;
    }

    /**
     * Is natrium boolean.
     *
     * @return the boolean
     */
    public boolean isNatrium() {
        return Natrium;
    }

    /**
     * Get ionen possitiv double [ ].
     *
     * @return the double [ ]
     */
    public static double[] getIonenPossitiv() {
        return IonenPossitiv;
    }

    /**
     * Get ionen ladung int [ ].
     *
     * @return the int [ ]
     */
    public static int[] getIonenLadung() {
        return IonenLadung;
    }

    /**
     * Sets ionen ladung.
     *
     * @param ionenLadung the ionen ladung
     */
    public static void setIonenLadung(int[] ionenLadung) {
        IonenLadung = ionenLadung;
    }

    /**
     * Get ionen ladung wn int [ ].
     *
     * @return the int [ ]
     */
    public static int[] getIonenLadungWN() {
        return IonenLadungWN;
    }

    /**
     * Sets ionen ladung wn.
     *
     * @param ionenLadungWN the ionen ladung wn
     */
    public static void setIonenLadungWN(int[] ionenLadungWN) {
        IonenLadungWN = ionenLadungWN;
    }

    /**
     * Get ionen ladung on int [ ].
     *
     * @return the int [ ]
     */
    public static int[] getIonenLadungON() {
        return IonenLadungON;
    }

    /**
     * Sets ionen ladung on.
     *
     * @param ionenLadungON the ionen ladung on
     */
    public static void setIonenLadungON(int[] ionenLadungON) {
        IonenLadungON = ionenLadungON;
    }

    /**
     * Get ionen charge double [ ].
     *
     * @return the double [ ]
     */
    public static double[] getIonenCharge() {
        return IonenCharge;
    }

    /**
     * Sets ionen charge.
     *
     * @param ionenCharge the ionen charge
     */
    public static void setIonenCharge(double[] ionenCharge) {
        IonenCharge = ionenCharge;
    }

    /**
     * Get ionen charge wn double [ ].
     *
     * @return the double [ ]
     */
    public static double[] getIonenChargeWN() {
        return IonenChargeWN;
    }

    /**
     * Sets ionen charge wn.
     *
     * @param ionenChargeWN the ionen charge wn
     */
    public static void setIonenChargeWN(double[] ionenChargeWN) {
        IonenChargeWN = ionenChargeWN;
    }

    /**
     * Get ionen charge on double [ ].
     *
     * @return the double [ ]
     */
    public static double[] getIonenChargeON() {
        return IonenChargeON;
    }

    /**
     * Sets ionen charge on.
     *
     * @param ionenChargeON the ionen charge on
     */
    public static void setIonenChargeON(double[] ionenChargeON) {
        IonenChargeON = ionenChargeON;
    }

    /**
     * Get ion name string [ ].
     *
     * @return the string [ ]
     */
    public static String[] getIonName() {
        return IonName;
    }

    /**
     * Sets ion name.
     *
     * @param ionName the ion name
     */
    public static void setIonName(String[] ionName) {
        IonName = ionName;
    }

    /**
     * Get ion name wn string [ ].
     *
     * @return the string [ ]
     */
    public static String[] getIonNameWN() {
        return IonNameWN;
    }

    /**
     * Sets ion name wn.
     *
     * @param ionNameWN the ion name wn
     */
    public static void setIonNameWN(String[] ionNameWN) {
        IonNameWN = ionNameWN;
    }

    /**
     * Get ion name on string [ ].
     *
     * @return the string [ ]
     */
    public static String[] getIonNameON() {
        return IonNameON;
    }

    /**
     * Sets ion name on.
     *
     * @param ionNameON the ion name on
     */
    public static void setIonNameON(String[] ionNameON) {
        IonNameON = ionNameON;
    }

    /**
     * Gets mp 2 h.
     *
     * @return the mp 2 h
     */
    public static double getMP2H() {
        return MP2H;
    }

    /**
     * Sets mp 2 h.
     *
     * @param MP2H the mp 2 h
     */
    public static void setMP2H(double MP2H) {
        KorrekturwerteDaten.MP2H = MP2H;
    }

    /**
     * Gets mphk.
     *
     * @return the mphk
     */
    public static double getMPHK() {
        return MPHK;
    }

    /**
     * Sets mphk.
     *
     * @param MPHK the mphk
     */
    public static void setMPHK(double MPHK) {
        KorrekturwerteDaten.MPHK = MPHK;
    }

    /**
     * Sets natrium.
     *
     * @param natrium the natrium
     */
    public static void setNatrium(boolean natrium) {
        Natrium = natrium;
        if (natrium == true) {
            setIonenPossitiv(getIonenPossitivWNatrium());
            setIonenCharge(getIonenChargeWN());
            setIonenLadung(getIonenLadungWN());
            setIonName(getIonNameWN());
            System.out.println(IonenPossitiv.length + " " + IonName.length + " " + IonenCharge.length + " " + IonenLadung.length);
        } else {
            setIonenPossitiv(getIonenPossitivONatrium());
			setIonenCharge(getIonenChargeON());
			setIonenLadung(getIonenLadungON());
			setIonName(getIonNameON());
			System.out.println(IonenPossitiv.length + " " + IonName.length + " " + IonenCharge.length + " " + IonenLadung.length);
		}
	}


}
