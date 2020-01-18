/**
 * 
 */
package de.daniel.brueggemann.tu.berlin.MSRechner;

/**
 * @author Daniel
 *
 */
public class AnalyseImplementierung implements AnalyserInterface
{
	private AnalysenObjekt rueckgabe=new AnalysenObjekt();

	/* (non-Javadoc)
	 * @see de.daniel.brueggemann.tu.berlin.MSRechner.AnalyserInterface#esikorrektur(double[], double[], int, int, boolean, boolean, boolean)
	 */
	@Override
	public double[][][][][] esikorrektur(double[] mszahlen, double[] relativ, int einzelwerte, int ergebnisse,
			boolean laurin, boolean dodecanol, boolean eo)
	{
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see de.daniel.brueggemann.tu.berlin.MSRechner.AnalyserInterface#esiNurkleinsteEO(double[], double[], int, int, int, int, boolean, boolean, boolean)
	 */
	@Override
	public double[][][][][] esiNurkleinsteEO(double[] mszahlen, double[] relativ, int einzelwerte, int ergebnisse,
			int doppelwerte, int keinErgebnis, boolean laurin, boolean dodecanol, boolean eo)
	{
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see de.daniel.brueggemann.tu.berlin.MSRechner.AnalyserInterface#artderkorrektur(int[])
	 */
	@Override
	public String[] artderkorrektur(int[] korrektur)
	{
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see de.daniel.brueggemann.tu.berlin.MSRechner.AnalyserInterface#esikorrekturObject(double[], double[], int, int, boolean, boolean, boolean)
	 */
	@Override
	public AnalysenObjekt esikorrekturObject(double[] mszahlen, double[] relativ, int einzelwerte, int ergebnisse,
			boolean laurin, boolean dodecanol, boolean eo)
	{
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see de.daniel.brueggemann.tu.berlin.MSRechner.AnalyserInterface#esiNurkleinsteEOObject(double[], double[], int, int, int, int, boolean, boolean, boolean)
	 */
	@Override
	public AnalysenObjekt esiNurkleinsteEOObject(double[] mszahlen, double[] relativ, int einzelwerte, int ergebnisse,
			int doppelwerte, int keinErgebnis, boolean laurin, boolean dodecanol, boolean eo)
	{
		AnalysenObjekt test=new AnalysenObjekt();
		//test.setAnalysenObjekt(mZahl, mKorriergiert, relativwert, eoWert, IonenLadung, IonenCharge, Korrektur, korrekturWertID);
		setRueckgabe(test);
		// TODO Auto-generated method stub
		return getRueckgabe();
	}

	/**
	 * @return the rueckgabe
	 */
	public AnalysenObjekt getRueckgabe()
	{
		return rueckgabe;
	}

	/**
	 * @param rueckgabe the rueckgabe to set
	 */
	public void setRueckgabe(AnalysenObjekt rueckgabe)
	{
		this.rueckgabe = rueckgabe;
	}

}
