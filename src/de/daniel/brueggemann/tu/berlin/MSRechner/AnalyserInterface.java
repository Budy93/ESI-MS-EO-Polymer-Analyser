/**
 * 
 */
package de.daniel.brueggemann.tu.berlin.MSRechner;

/**
 * The interface Analyser interface.
 *
 * @author Daniel
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
	 * Esikorrektur double [ ] [ ] [ ] [ ] [ ].
	 *
	 * @param messdaten the messdaten
	 * @param treffer   the treffer
	 * @param laurin    the laurin
	 * @param dodecanol the dodecanol
	 * @param eo        the eo
	 * @return double [ ] [ ] [ ] [ ] [ ]
	 */
	double[][][][][] esikorrektur(Messdaten messdaten, Treffer treffer, boolean laurin, boolean dodecanol, boolean eo);
	
	/*
	 * Brauchen:
	 * MZ und Korrelierende MZ 2
	 * relativit�t
	 * EO anzahl korrektur(index 2
	 */

	/**
	 * Esi nurkleinste eo double [ ] [ ] [ ] [ ] [ ].
	 *
	 * @param messdaten the messdaten
	 * @param treffer   the treffer
	 * @param laurin    the laurin
	 * @param dodecanol the dodecanol
	 * @param eo        the eo
	 * @return double [ ] [ ] [ ] [ ] [ ]
	 */
	double[][][][][] esiNurkleinsteEO(Messdaten messdaten, Treffer treffer, boolean laurin, boolean dodecanol, boolean eo);

	/**
	 * Artderkorrektur string [ ].
	 *
	 * @param korrektur the korrektur
	 * @return the string [ ]
	 */
	String[] artderkorrektur(int[] korrektur);

	/**
	 * Esikorrektur object analysen objekt.
	 *
	 * @param messdaten the messdaten
	 * @param treffer   the treffer
	 * @param laurin    the laurin
	 * @param dodecanol the dodecanol
	 * @param eo        the eo
	 * @return analysen objekt
	 */
	AnalysenObjekt esikorrekturObject(Messdaten messdaten, Treffer treffer, boolean laurin, boolean dodecanol, boolean eo);

	/**
	 * Esi nurkleinste eo object analysen objekt.
	 *
	 * @param messdaten the messdaten
	 * @param treffer   the treffer
	 * @param laurin    the laurin
	 * @param dodecanol the dodecanol
	 * @param eo        the eo
	 * @return analysen objekt
	 */
	AnalysenObjekt esiNurkleinsteEOObject(Messdaten messdaten, Treffer treffer, boolean laurin, boolean dodecanol, boolean eo);

	/**
	 * Anzahl ergebnisse treffer.
	 *
	 * @param messdaten the messdaten
	 * @param laurin    the laurin
	 * @param dodecanol the dodecanol
	 * @param eo        the eo
	 * @return the treffer
	 */
	Treffer anzahlErgebnisse(Messdaten messdaten, boolean laurin, boolean dodecanol, boolean eo);

	/**
	 * Charakteristik korregiert tensid.
	 *
	 * @param probename      the probename
	 * @param analysenObjekt the analysen objekt
	 * @return the tensid
	 */
	Tensid charakteristikKorregiert(String probename, AnalysenObjekt analysenObjekt);

	/**
	 * Charakterisierung tensid.
	 *
	 * @param probenname the probenname
	 * @param messdaten  the messdaten
	 * @return the tensid
	 */
	Tensid charakterisierung(String probenname, Messdaten messdaten);

}
