/**
 * 
 */
package de.daniel.brueggemann.tu.berlin.MSRechner;

/**
 * @author Daniel
 *
 */
public interface AnalyserInterface
{
	/*
	 * Brauchen:
	 * MZ und Korrelierende MZ 2
	 * relativit�t
	 * EO anzahl korrektur(index 2
	 */
	/**
	 * @param mszahlen
	 * @param relativ
	 * @param einzelwerte
	 * @param ergebnisse
	 * @param laurin
	 * @param dodecanol
	 * @param eo
	 * @return
	 */
	double[][][][][] esikorrektur(double[] mszahlen, double[] relativ, int einzelwerte, int ergebnisse, boolean laurin, boolean dodecanol, boolean eo);
	
	/*
	 * Brauchen:
	 * MZ und Korrelierende MZ 2
	 * relativit�t
	 * EO anzahl korrektur(index 2
	 */
	/**
	 * @param mszahlen
	 * @param relativ
	 * @param einzelwerte
	 * @param ergebnisse
	 * @param doppelwerte
	 * @param keinErgebnis
	 * @param laurin
	 * @param dodecanol
	 * @param eo
	 * @return
	 */
	double[][][][][] esiNurkleinsteEO(double[] mszahlen, double[] relativ, int einzelwerte, int ergebnisse, int doppelwerte, int keinErgebnis, boolean laurin, boolean dodecanol, boolean eo);
	
	String[] artderkorrektur(int[] korrektur);
	
	/**
	 * @param mszahlen
	 * @param relativ
	 * @param einzelwerte
	 * @param ergebnisse
	 * @param laurin
	 * @param dodecanol
	 * @param eo
	 * @return
	 */
	AnalysenObjekt esikorrekturObject(double[] mszahlen, double[] relativ, int einzelwerte, int ergebnisse, boolean laurin, boolean dodecanol, boolean eo);
	
	/**
	 * @param mszahlen
	 * @param relativ
	 * @param einzelwerte
	 * @param ergebnisse
	 * @param doppelwerte
	 * @param keinErgebnis
	 * @param laurin
	 * @param dodecanol
	 * @param eo
	 * @return
	 */
	AnalysenObjekt esiNurkleinsteEOObject(double[] mszahlen, double[] relativ, int einzelwerte, int ergebnisse, int doppelwerte, int keinErgebnis, boolean laurin, boolean dodecanol, boolean eo);

}
