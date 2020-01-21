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
	 * @param messdaten
	 * @param treffer
	 * @param laurin
	 * @param dodecanol
	 * @param eo
	 * @return
	 */
	double[][][][][] esikorrektur(Messdaten messdaten, Treffer treffer, boolean laurin, boolean dodecanol, boolean eo);
	
	/*
	 * Brauchen:
	 * MZ und Korrelierende MZ 2
	 * relativit�t
	 * EO anzahl korrektur(index 2
	 */
	/**
	 * @param messdaten
	 * @param treffer
	 * @param laurin
	 * @param dodecanol
	 * @param eo
	 * @return
	 */
	double[][][][][] esiNurkleinsteEO(Messdaten messdaten, Treffer treffer, boolean laurin, boolean dodecanol, boolean eo);
	
	String[] artderkorrektur(int[] korrektur);
	
	/**
	 * @param messdaten
	 * @param treffer
	 * @param laurin
	 * @param dodecanol
	 * @param eo
	 * @return
	 */
	AnalysenObjekt esikorrekturObject(Messdaten messdaten, Treffer treffer, boolean laurin, boolean dodecanol, boolean eo);

	/**
	 * @param messdaten
	 * @param treffer
	 * @param laurin
	 * @param dodecanol
	 * @param eo
	 * @return
	 */
	AnalysenObjekt esiNurkleinsteEOObject(Messdaten messdaten, Treffer treffer, boolean laurin, boolean dodecanol, boolean eo);

	Treffer anzahlErgebnisse(Messdaten messdaten, boolean laurin, boolean dodecanol, boolean eo);

}
