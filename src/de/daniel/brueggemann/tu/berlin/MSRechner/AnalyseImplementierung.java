/**
 *
 */
package de.daniel.brueggemann.tu.berlin.MSRechner;

import java.lang.management.MemoryNotificationInfo;
import java.util.ArrayList;

/**
 * The type Analyse implementierung.
 *
 * @author Daniel
 */
public class AnalyseImplementierung implements AnalyserInterface {
    private AnalysenObjekt rueckgabe = new AnalysenObjekt();
    private Tensid Tens = new Tensid();

    /*    *//* (non-Javadoc)
     * @see de.daniel.brueggemann.tu.berlin.MSRechner.AnalyserInterface#esikorrektur(double[], double[], int, int, boolean, boolean, boolean)
     *//*
    @Override
    public double[][][][][] esikorrektur(double[] mszahlen, double[] relativ, int einzelwerte, int ergebnisse,
                                         boolean laurin, boolean dodecanol, boolean eo) {
        // TODO Auto-generated method stub
        return null;
    }

    *//* (non-Javadoc)
     * @see de.daniel.brueggemann.tu.berlin.MSRechner.AnalyserInterface#esiNurkleinsteEO(double[], double[], int, int, int, int, boolean, boolean, boolean)
     *//*
    @Override
    public double[][][][][] esiNurkleinsteEO(double[] mszahlen, double[] relativ, int einzelwerte, int ergebnisse,
                                             int doppelwerte, int keinErgebnis, boolean laurin, boolean dodecanol, boolean eo) {
        // TODO Auto-generated method stub
        return null;
    }*/

    @Override
    public double[][][][][] esikorrektur(Messdaten messdaten, Treffer treffer, boolean laurin, boolean dodecanol, boolean eo) {
        return new double[0][][][][];
    }

    @Override
    public double[][][][][] esiNurkleinsteEO(Messdaten messdaten, Treffer treffer, boolean laurin, boolean dodecanol, boolean eo) {
        return new double[0][][][][];
    }

    /* (non-Javadoc)
     * @see de.daniel.brueggemann.tu.berlin.MSRechner.AnalyserInterface#artderkorrektur(int[])
     */
    @Override
    public String[] artderkorrektur(int[] korrektur) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * Rundet den übergebenen Wert auf die Anzahl der übergebenen Nachkommastellen
     *
     * @param value         ist der zu rundende Wert.
     * @param decimalPoints ist die Anzahl der Nachkommastellen, auf die gerundet werden soll.
     */
    private static double round(double value, int decimalPoints) {
        double d = Math.pow(10, decimalPoints);
        return Math.round(value * d) / d;
    }

    @Override
    public AnalysenObjekt esikorrekturObject(Messdaten messdaten, Treffer treffer, boolean laurin, boolean dodecanol, boolean eo) {
        int pr = 0;
        int dr = 0;
        double[] relativ = messdaten.getRelativ();
        double[] intensitaet = messdaten.getIntensitaet();
        double[] MSwerte = messdaten.getMzZahl();
        double[] IonenPossitiv = KorrekturwerteDaten.getIonenpossitiv();
        double[] IonenCharge = KorrekturwerteDaten.getIonencharge();
        String[] IonName = KorrekturwerteDaten.getIonname();
        int[] IonenLadung = KorrekturwerteDaten.getIonenladung();
        AnalysenObjekt ana = new AnalysenObjekt();
        /// TODO: 21.01.2020
        int laenge = treffer.getTreffer() + treffer.getKeinTreffer();
        System.out.println(laenge);
        int[] trefferID = new int[laenge];
        double[] ANAmZahl = new double[laenge];
        double[] ANAmKorriergiert = new double[laenge];
        double[] ANArelativwert = new double[laenge];
        double[] ANAeoWert = new double[laenge];
        int[] ANAIonenLadung = new int[laenge];
        double[] ANAIonenCharge = new double[laenge];
        String[] ANAKorrektur = new String[laenge];
        int[] ANAkorrekturWertID = new int[laenge];
        int an = 0;

        for (int z = 0; z < MSwerte.length; z++) {
            dr = 0;
            pr = 0;
            double Eingabewert = MSwerte[z];
            if (laurin == true) {
                for (int b = 0; b < IonenPossitiv.length; b++) {
                    double Test = Eingabewert * IonenCharge[b] - IonenPossitiv[b];
                    double LaurinsaeureE = round(Test, 0) - 199;
                    double Laurinsaure = LaurinsaeureE / 44;
                    // System.out.println(Test+" "+LaurinsaeureE+" "+Laurinsaure);
                    if (Laurinsaure % 1 == 0) {
                        String text = Eingabewert + " Treffer auf Laurinsaurebasis " + "Das Ion ist " + IonName[b]
                                + " mit der Ionnen Masse ist: " + IonenPossitiv[b] + " Ladung ist " + IonenLadung[b]
                                + " Die Anzahl der EO Einheiten ist " + Laurinsaure;
                        System.out.println(text);
                        ANAmZahl[an] = MSwerte[z];
                        ANAmKorriergiert[an] = round(Test, 0);
                        ANArelativwert[an] = relativ[z];
                        ANAeoWert[an] = Laurinsaure;
                        ANAIonenLadung[an] = IonenLadung[b];
                        ANAIonenCharge[an] = IonenCharge[b];
                        ANAKorrektur[an] = text;
                        ANAkorrekturWertID[an] = b;
                        trefferID[an] = an;
                        an++;
                        pr++;
                        //System.out.println(pr);
                    }
                }
                if (pr == 0) {
                    // System.out.println("Die Masser "+Eingabewert+" Lieferte keine Ergebnisse.");
                } else if (pr > 0) {
                    dr = dr + pr;
                    //System.out.println(dr);
                }
            }
            pr = 0;
            if (dodecanol == true) {
                for (int b = 0; b < IonenPossitiv.length; b++) {
                    double Test = Eingabewert * IonenCharge[b] - IonenPossitiv[b];
                    double LaurinsaeureE = round(Test, 0) - 189;
                    double Laurinsaure = LaurinsaeureE / 44;
                    // System.out.println(Test+" "+LaurinsaeureE+" "+Laurinsaure);
                    if (Laurinsaure % 1 == 0) {
                        String text = Eingabewert + " Treffer auf Dodecanolbasis " + "Das Ion ist " + IonName[b]
                                + " mit der Ionnen Masse ist: " + IonenPossitiv[b] + " Ladung ist " + IonenLadung[b]
                                + " Die Anzahl der EO Einheiten ist " + Laurinsaure;
                        System.out.println(text);
                        ANAmZahl[an] = MSwerte[z];
                        ANAmKorriergiert[an] = round(Test, 0);
                        ANArelativwert[an] = relativ[z];
                        ANAeoWert[an] = Laurinsaure;
                        ANAIonenLadung[an] = IonenLadung[b];
                        ANAIonenCharge[an] = IonenCharge[b];
                        ANAKorrektur[an] = text;
                        ANAkorrekturWertID[an] = b;
                        trefferID[an] = an;
                        an++;
                        pr++;
                    }
                }
                if (pr == 0) {
                    // System.out.println("Die Masser "+Eingabewert+" Lieferte keine Ergebnisse.");
                } else if (pr > 0) {
                    dr = dr + pr;
                    // System.out.println("Die Masser "+Eingabewert+" Lieferte MEHRERE
                    // Ergebnisse.");
                }
            }
            pr = 0;
            if (eo == true) {
                for (int b = 0; b < IonenPossitiv.length; b++) {
                    double Test = Eingabewert * IonenCharge[b] - IonenPossitiv[b];
                    double LaurinsaeureE = round(Test, 0);
                    double Laurinsaure = LaurinsaeureE / 44;
                    // System.out.println(Test+" "+LaurinsaeureE+" "+Laurinsaure);
                    if (Laurinsaure % 1 == 0) {
                        String text = Eingabewert + " Treffer auf EO " + "Das Ion ist " + IonName[b]
                                + " mit der Ionnen Masse ist: " + IonenPossitiv[b] + " Ladung ist " + IonenLadung[b]
                                + " Die Anzahl der EO Einheiten ist " + Laurinsaure;
                        System.out.println(text);
                        ANAmZahl[an] = MSwerte[z];
                        ANAmKorriergiert[an] = round(Test, 0);
                        ANArelativwert[an] = relativ[z];
                        ANAeoWert[an] = Laurinsaure;
                        ANAIonenLadung[an] = IonenLadung[b];
                        ANAIonenCharge[an] = IonenCharge[b];
                        ANAKorrektur[an] = text;
                        ANAkorrekturWertID[an] = b;
                        trefferID[an] = an;
                        an++;
                        pr++;
                    }
                }
                if (pr == 0) {
                    // System.out.println("Die Masser "+Eingabewert+" Lieferte keine Ergebnisse.");
                } else if (pr > 0) {
                    dr = dr + pr;
                    // System.out.println("Die Masser "+Eingabewert+" Lieferte MEHRERE
                    // Ergebnisse.");
                }
            }
            if (dr == 0) {
                String text = "Die Masser " + Eingabewert + " Lieferte keine Ergebnisse.";
                System.out.println(text);
                ANAmZahl[an] = MSwerte[z];
                ANAmKorriergiert[an] = MSwerte[z];
                ANArelativwert[an] = relativ[z];
                ANAeoWert[an] = 0;
                ANAIonenLadung[an] = 0;
                ANAIonenCharge[an] = 0;
                ANAKorrektur[an] = text;
                ANAkorrekturWertID[an] = 99;
                trefferID[an] = an;
                an++;
            } else if (dr > 1) {
                //System.out.println(dr);
                System.out.println("Die Masser " + Eingabewert + " Lieferte MEHRERE Ergebnisse.");
            }
            dr = 0;
            pr = 0;
        }
        ana.setAnalysenObjekt(trefferID, ANAmZahl, ANAmKorriergiert, ANArelativwert, ANAeoWert, ANAIonenLadung, ANAIonenCharge, ANAKorrektur, ANAkorrekturWertID);
        return ana;
    }

    @Override
    public AnalysenObjekt esiNurkleinsteEOObject(Messdaten messdaten, Treffer treffer, boolean laurin, boolean dodecanol, boolean eo) {
        return null;
    }

    @Override
    public Treffer anzahlErgebnisse(Messdaten messdaten, boolean laurin, boolean dodecanol, boolean eo) {
        double[] MSwerte = messdaten.getMzZahl();
        double[] IonenPossitiv = KorrekturwerteDaten.getIonenpossitiv();
        double[] IonenCharge = KorrekturwerteDaten.getIonencharge();
        String[] IonName = KorrekturwerteDaten.getIonname();
        int[] IonenLadung = KorrekturwerteDaten.getIonenladung();
        Treffer treffer = new Treffer();

        int ergebnis = 0;
        int single = 0;
        int eindeutig = 0;
        int doppelt = 0;
        int nop = 0;
        int pr = 0;
        int dr = 0;
        for (int z = 0; z < MSwerte.length; z++) {
            dr = 0;
            pr = 0;
            double Eingabewert = MSwerte[z];
            if (laurin == true) {
                for (int b = 0; b < IonenPossitiv.length; b++) {
                    double Test = Eingabewert * IonenCharge[b] - IonenPossitiv[b];
                    double LaurinsaeureE = round(Test, 0) - 199;
                    double Laurinsaure = LaurinsaeureE / 44;
                    // System.out.println(Test+" "+LaurinsaeureE+" "+Laurinsaure);
                    if (Laurinsaure % 1 == 0) {
                        /*
                        System.out.println(Eingabewert + " Treffer auf Laurinsäurebasis " + "Das Ion ist " + IonName[b]
                                + " mit der Ionnen Masse ist: " + IonenPossitiv[b] + " Ladung ist " + IonenLadung[b]
                                + " Die Anzahl der EO Einheiten ist " + Laurinsaure);
                                */
                        ergebnis++;
                        pr++;
                    }
                }
                if (pr == 0) {
                    // System.out.println("Die Masser "+Eingabewert+" Lieferte keine Ergebnisse.");
                } else if (pr > 0) {
                    dr = dr + pr;
                }
                if (pr == 1) {
                    single++;
                }
            }
            pr = 0;
            if (dodecanol == true) {
                for (int b = 0; b < IonenPossitiv.length; b++) {
                    double Test = Eingabewert * IonenCharge[b] - IonenPossitiv[b];
                    double LaurinsaeureE = round(Test, 0) - 189;
                    double Laurinsaure = LaurinsaeureE / 44;
                    // System.out.println(Test+" "+LaurinsaeureE+" "+Laurinsaure);
                    if (Laurinsaure % 1 == 0) {
                        /*
                        System.out.println(Eingabewert + " Treffer auf Dodecanolbasis " + "Das Ion ist " + IonName[b]
                                + " mit der Ionnen Masse ist: " + IonenPossitiv[b] + " Ladung ist " + IonenLadung[b]
                                + " Die Anzahl der EO Einheiten ist " + Laurinsaure);
                                */
                        ergebnis++;
                        pr++;
                    }
                }
                if (pr == 0) {
                    // System.out.println("Die Masser "+Eingabewert+" Lieferte keine Ergebnisse.");
                } else if (pr > 0) {
                    dr = dr + pr;
                    // System.out.println("Die Masser "+Eingabewert+" Lieferte MEHRERE
                    // Ergebnisse.");
                }
                if (pr == 1) {
                    single++;
                }
            }
            pr = 0;
            if (eo == true) {
                for (int b = 0; b < IonenPossitiv.length; b++) {
                    double Test = Eingabewert * IonenCharge[b] - IonenPossitiv[b];
                    double LaurinsaeureE = round(Test, 0);
                    double Laurinsaure = LaurinsaeureE / 44;
                    // System.out.println(Test+" "+LaurinsaeureE+" "+Laurinsaure);
                    if (Laurinsaure % 1 == 0) {
                        /*
                        System.out.println(Eingabewert + " Treffer auf EO " + "Das Ion ist " + IonName[b]
                                + " mit der Ionnen Masse ist: " + IonenPossitiv[b] + " Ladung ist " + IonenLadung[b]
                                + " Die Anzahl der EO Einheiten ist " + Laurinsaure);
                                */
                        ergebnis++;
                        pr++;
                    }
                }
                if (pr == 0) {
                    // System.out.println("Die Masser "+Eingabewert+" Lieferte keine Ergebnisse.");
                } else if (pr > 0) {
                    dr = dr + pr;
                    // System.out.println("Die Masser "+Eingabewert+" Lieferte MEHRERE
                    // Ergebnisse.");
                }
                if (pr == 1) {
                    single++;
                }
            }
            if (dr == 0) {
                nop++;
                //System.out.println("Die Masser " + Eingabewert + " Lieferte keine Ergebnisse.");
            } else if (dr > 1) {
                //System.out.println("Die Masser " + Eingabewert + " Lieferte MEHRERE Ergebnisse.");
                doppelt = doppelt + dr;
                //System.out.println(doppelt);
            }
            if (dr == 1) {
                eindeutig++;
            }
            dr = 0;
            pr = 0;
        }
        treffer.setTreffer(ergebnis);
        treffer.setDoppelt(doppelt);
        treffer.setEindeutig(eindeutig);
        treffer.setKeinTreffer(nop);
        treffer.setMesswerte(MSwerte.length);
        return treffer;
    }

    //TODO DRINGEND ZU MACHEN
    @Override
    public Tensid charakteristikKorregiert(String probename, double CO2GehaltinProzent, AnalysenObjekt analysenObjekt, boolean laurin, boolean dodecanol) {
        Tensid tensid = new Tensid();
        double[] parken = analysenObjekt.getmZahl();
        double[] parkenRel = analysenObjekt.getRelativwert();
        ArrayList<Double> list = new ArrayList<Double>();
        ArrayList<Double> rel = new ArrayList<Double>();
        for (int i = 0; i < parken.length; i++) {
            if (parkenRel[i] >= 1) {
                list.add(parken[i]);
                rel.add(parkenRel[i]);
            }
        }
        double[] mzZhal = new double[list.size()];
        double[] relativ = new double[list.size()];
        for (int i = 0; i < list.size(); i++) {
            mzZhal[i] = list.get(i);
            relativ[i] = rel.get(i);
        }

        String[] ausgabe = new String[mzZhal.length + 4];
        double[] xi = new double[mzZhal.length];
        double[] xiMI = new double[mzZhal.length];
        //double[] niMI=new double[mzZhal.length];
        double[] wi = new double[mzZhal.length];
        double[] niMI = new double[mzZhal.length];
        double[] miWI = new double[mzZhal.length];
        double summeRelativitaet = 0;
        double summeMI = 0;
        double KotrolleXI = 0;
        double Mn = 0;
        double kontoleWI = 0;
        double Mw = 0;
        double PDI = 0;
        double selectiviteat = 0;
        for (int i = 0; i < relativ.length; i++) {
            summeRelativitaet += relativ[i];
        }
        for (int i = 0; i < relativ.length; i++) {
            xi[i] = relativ[i] / summeRelativitaet;
        }
        for (int i = 0; i < xi.length; i++) {
            xiMI[i] = xi[i] * mzZhal[i];
        }
        for (int i = 0; i < relativ.length; i++) {
            niMI[i] = mzZhal[i] * relativ[i];
        }
        for (int i = 0; i < niMI.length; i++) {
            summeMI += niMI[i];
        }
        for (int i = 0; i < niMI.length; i++) {
            wi[i] = niMI[i] / summeMI;
        }
        for (int i = 0; i < wi.length; i++) {
            miWI[i] = wi[i] * mzZhal[i];
        }
        for (int i = 0; i < xi.length; i++) {
            KotrolleXI += xi[i];
        }
        for (int i = 0; i < xiMI.length; i++) {
            Mn += xiMI[i];
        }
        for (int i = 0; i < wi.length; i++) {
            kontoleWI += wi[i];
        }
        for (int i = 0; i < miWI.length; i++) {
            Mw += miWI[i];
        }
        PDI = Mw / Mn;
        double EOpCO2 = 0;
        double EO = 0;
        double Co2 = 0;
        if (dodecanol == true) {
            EOpCO2 = (Mw - 169 - 17) / 44;
        } else if (laurin == true) {
            EOpCO2 = (Mw - 199 - 17) / 44;
        }
        Co2 = ((Mw * CO2GehaltinProzent) / 100) / 44;
        EO = EOpCO2 - Co2;
        tensid.Tenside(probename, Mw, Mn, PDI, EO, Co2, CO2GehaltinProzent, 0);
        double select = selectivität(tensid, laurin, dodecanol, false);
        tensid.Tenside(probename, Mw, Mn, PDI, EO, Co2, CO2GehaltinProzent, select);
        ausgabe[0] = "Tenside: " + probename + " Mn: " + Mn + " Mw: " + Mw + " PDI: " + PDI + " EOGruppen: " + EO + " CO2 Gruppen: " + Co2 + " CO2 Gehalt: " + CO2GehaltinProzent + " Selektivität CO2 ist: " + select;
        ausgabe[1] = "";
        ausgabe[2] = "Summe XI:" + KotrolleXI + " Summe WI" + KotrolleXI;
        ausgabe[3] = "M/Z Relativ xi xi*Mi ni*MI wi=(ni*Mi)/SUMME(ni*MI) mi*wi";
        int speicher = 4;
        for (int i = 0; i < mzZhal.length; i++) {
            ausgabe[speicher] = mzZhal[i] + " " + relativ[i] + " " + xi[i] + " " + xiMI[i] + " " + niMI[i] + " " + wi[i] + " " + miWI[i];
            speicher++;
        }
        Filewriter file = new FilewriterImpl();
        Boolean schreiben = file.writteDate(System.getProperty("user.home") + "\\Desktop\\" + probename + "_Charakter_Daten_relevante_EO.txt", ausgabe);
        //probename +"\\"+
        if (schreiben != true) {
            System.out.println("Fehler beim niederschreiben der Charakterdaten");
        }
        return tensid;
    }

    //TODO AUCH DRINGEND
    @Override
    public Tensid charakterisierung(String probenname, double CO2GehaltinProzent, Messdaten messdaten, boolean laurin, boolean dodecanol) {
        Tensid tensid = new Tensid();
        double[] mzZhal = messdaten.getMzZahl();
        double[] relativ = messdaten.getRelativ();
        String[] ausgabe = new String[mzZhal.length + 4];
        double[] xi = new double[mzZhal.length];
        double[] xiMI = new double[mzZhal.length];
        //double[] niMI=new double[mzZhal.length];
        double[] wi = new double[mzZhal.length];
        double[] niMI = new double[mzZhal.length];
        double[] miWI = new double[mzZhal.length];
        double summeRelativitaet = 0;
        double summeMI = 0;
        double KotrolleXI = 0;
        double Mn = 0;
        double kontoleWI = 0;
        double Mw = 0;
        double PDI = 0;
        double selectiviteat = 0;
        for (int i = 0; i < relativ.length; i++) {
            summeRelativitaet += relativ[i];
        }
        for (int i = 0; i < relativ.length; i++) {
            xi[i] = relativ[i] / summeRelativitaet;
        }
        for (int i = 0; i < xi.length; i++) {
            xiMI[i] = xi[i] * mzZhal[i];
        }
        for (int i = 0; i < relativ.length; i++) {
            niMI[i] = mzZhal[i] * relativ[i];
        }
        for (int i = 0; i < niMI.length; i++) {
            summeMI += niMI[i];
        }
        for (int i = 0; i < niMI.length; i++) {
            wi[i] = niMI[i] / summeMI;
        }
        for (int i = 0; i < wi.length; i++) {
            miWI[i] = wi[i] * mzZhal[i];
        }
        for (int i = 0; i < xi.length; i++) {
            KotrolleXI += xi[i];
        }
        for (int i = 0; i < xiMI.length; i++) {
            Mn += xiMI[i];
        }
        for (int i = 0; i < wi.length; i++) {
            kontoleWI += wi[i];
        }
        for (int i = 0; i < miWI.length; i++) {
            Mw += miWI[i];
        }
        PDI = Mw / Mn;
        double EOpCO2 = 0;
        double EO = 0;
        double Co2 = 0;
        if (dodecanol == true) {
            EOpCO2 = (Mw - 169 - 17) / 44;
        } else if (laurin == true) {
            EOpCO2 = (Mw - 199 - 17) / 44;
        }
        Co2 = ((Mw * CO2GehaltinProzent) / 100) / 44;
        EO = EOpCO2 - Co2;
        tensid.Tenside(probenname, Mw, Mn, PDI, EO, Co2, CO2GehaltinProzent, 0);
        double select = selectivität(tensid, laurin, dodecanol, false);
        tensid.Tenside(probenname, Mw, Mn, PDI, EO, Co2, CO2GehaltinProzent, select);
        ausgabe[0] = "Tenside: " + probenname + " Mn: " + Mn + " Mw: " + Mw + " PDI: " + PDI + " EOGruppen: " + EO + " CO2 Gruppen: " + Co2 + " CO2 Gehalt: " + CO2GehaltinProzent + " eine CO2 Selectivität von: " + select;
        System.out.println(ausgabe[0]);
        ausgabe[1] = "";
        ausgabe[2] = "Summe XI:" + KotrolleXI + " Summe WI" + KotrolleXI;
        ausgabe[3] = "M/Z Relativ xi xi*Mi ni*MI wi=(ni*Mi)/SUMME(ni*MI) mi*wi";
        int speicher = 4;
        for (int i = 0; i < mzZhal.length; i++) {
            ausgabe[speicher] = mzZhal[i] + " " + relativ[i] + " " + xi[i] + " " + xiMI[i] + " " + niMI[i] + " " + wi[i] + " " + miWI[i];
            speicher++;
        }
        Filewriter file = new FilewriterImpl();
        Boolean schreiben = file.writteDate(System.getProperty("user.home") + "\\Desktop\\" + probenname + "_Charakter_Daten_unkorrigiert.txt", ausgabe);
        // + probenname +"\\"
        if (schreiben != true) {
            System.out.println("Fehler beim niederschreiben der Charakterdaten");
        }
        return tensid;


        /*
        xi	xi*Mi		ni*MI	wi (ni*Mi)/SUMME(ni*MI)	mi*wi

        ausgabe string mit auswertung 0
        leerezeile1
        Zwischen summen
        struktur berechung 3
        ab 4 alle rechen zeilen
        *2 double arrys
         *5 double arrays
         * Summe Relativität
            Kontrole XI MUSS=1
            Mn
            Summe mi
            Kontrolle Wi Muss=1
            Mw
            PDI

         */
    }

    //TODO Heute Abend machen
    @Override
    public double selectivität(Tensid tensid, boolean laurinsauere, boolean dodecanol, boolean eo) {
        double EO = round(tensid.getEO(), 0);
        double Sollselectiv = 1;
        double Istselectiv = tensid.getCO2() / tensid.getEO();
        double abweichung = Sollselectiv - Istselectiv;
        double Selectivitaet = 1 - abweichung;
        return Selectivitaet;
    }

    public AnalysenObjekt esikorrekturEindeutig(Messdaten messdaten, Treffer treffer, boolean laurin, boolean dodecanol, boolean eo) {
        int pr = 0;
        int dr = 0;
        double[] relativ = messdaten.getRelativ();
        double[] intensitaet = messdaten.getIntensitaet();
        double[] MSwerte = messdaten.getMzZahl();
        double[] IonenPossitiv = KorrekturwerteDaten.getIonenpossitiv();
        double[] IonenCharge = KorrekturwerteDaten.getIonencharge();
        String[] IonName = KorrekturwerteDaten.getIonname();
        int[] IonenLadung = KorrekturwerteDaten.getIonenladung();
        AnalysenObjekt ana = new AnalysenObjekt();
        /// TODO: 21.01.2020
        int laenge = treffer.getTreffer() + treffer.getKeinTreffer();
        System.out.println(laenge);
        int[] trefferID = new int[laenge];
        double[] ANAmZahl = new double[laenge];
        double[] ANAmKorriergiert = new double[laenge];
        double[] ANArelativwert = new double[laenge];
        double[] ANAeoWert = new double[laenge];
        int[] ANAIonenLadung = new int[laenge];
        double[] ANAIonenCharge = new double[laenge];
        String[] ANAKorrektur = new String[laenge];
        int[] ANAkorrekturWertID = new int[laenge];

        int[] trefferIDe = new int[treffer.getEindeutig()];
        double[] ANAmZahle = new double[treffer.getEindeutig()];
        double[] ANAmKorriergierte = new double[treffer.getEindeutig()];
        double[] ANArelativwerte = new double[treffer.getEindeutig()];
        double[] ANAeoWerte = new double[treffer.getEindeutig()];
        int[] ANAIonenLadunge = new int[treffer.getEindeutig()];
        double[] ANAIonenChargee = new double[treffer.getEindeutig()];
        String[] ANAKorrekture = new String[treffer.getEindeutig()];
        int[] ANAkorrekturWertIDe = new int[treffer.getEindeutig()];

        int an = 0;
        int ein = 0;
        AnalysenObjekt ane = new AnalysenObjekt();

        for (int z = 0; z < MSwerte.length; z++) {
            dr = 0;
            pr = 0;
            double Eingabewert = MSwerte[z];
            if (laurin == true) {
                for (int b = 0; b < IonenPossitiv.length; b++) {
                    double Test = Eingabewert * IonenCharge[b] - IonenPossitiv[b];
                    double LaurinsaeureE = round(Test, 0) - 199;
                    double Laurinsaure = LaurinsaeureE / 44;
                    // System.out.println(Test+" "+LaurinsaeureE+" "+Laurinsaure);
                    if (Laurinsaure % 1 == 0) {
                        String text = Eingabewert + " Treffer auf Laurinsaurebasis " + "Das Ion ist " + IonName[b]
                                + " mit der Ionnen Masse ist: " + IonenPossitiv[b] + " Ladung ist " + IonenLadung[b]
                                + " Die Anzahl der EO Einheiten ist " + Laurinsaure;
                        System.out.println(text);
                        ANAmZahl[an] = MSwerte[z];
                        ANAmKorriergiert[an] = round(Test, 0);
                        ANArelativwert[an] = relativ[z];
                        ANAeoWert[an] = Laurinsaure;
                        ANAIonenLadung[an] = IonenLadung[b];
                        ANAIonenCharge[an] = IonenCharge[b];
                        ANAKorrektur[an] = text;
                        ANAkorrekturWertID[an] = b;
                        trefferID[an] = an;
                        an++;
                        pr++;
                        //System.out.println(pr);
                    }
                }
                if (pr == 0) {
                    // System.out.println("Die Masser "+Eingabewert+" Lieferte keine Ergebnisse.");
                } else if (pr > 0) {
                    dr = dr + pr;
                    //System.out.println(dr);
                }
            }
            pr = 0;
            if (dodecanol == true) {
                for (int b = 0; b < IonenPossitiv.length; b++) {
                    double Test = Eingabewert * IonenCharge[b] - IonenPossitiv[b];
                    double LaurinsaeureE = round(Test, 0) - 189;
                    double Laurinsaure = LaurinsaeureE / 44;
                    // System.out.println(Test+" "+LaurinsaeureE+" "+Laurinsaure);
                    if (Laurinsaure % 1 == 0) {
                        String text = Eingabewert + " Treffer auf Dodecanolbasis " + "Das Ion ist " + IonName[b]
                                + " mit der Ionnen Masse ist: " + IonenPossitiv[b] + " Ladung ist " + IonenLadung[b]
                                + " Die Anzahl der EO Einheiten ist " + Laurinsaure;
                        System.out.println(text);
                        ANAmZahl[an] = MSwerte[z];
                        ANAmKorriergiert[an] = round(Test, 0);
                        ANArelativwert[an] = relativ[z];
                        ANAeoWert[an] = Laurinsaure;
                        ANAIonenLadung[an] = IonenLadung[b];
                        ANAIonenCharge[an] = IonenCharge[b];
                        ANAKorrektur[an] = text;
                        ANAkorrekturWertID[an] = b;
                        trefferID[an] = an;
                        an++;
                        pr++;
                    }
                }
                if (pr == 0) {
                    // System.out.println("Die Masser "+Eingabewert+" Lieferte keine Ergebnisse.");
                } else if (pr > 0) {
                    dr = dr + pr;
                    // System.out.println("Die Masser "+Eingabewert+" Lieferte MEHRERE
                    // Ergebnisse.");
                }
            }
            pr = 0;
            if (eo == true) {
                for (int b = 0; b < IonenPossitiv.length; b++) {
                    double Test = Eingabewert * IonenCharge[b] - IonenPossitiv[b];
                    double LaurinsaeureE = round(Test, 0);
                    double Laurinsaure = LaurinsaeureE / 44;
                    // System.out.println(Test+" "+LaurinsaeureE+" "+Laurinsaure);
                    if (Laurinsaure % 1 == 0) {
                        String text = Eingabewert + " Treffer auf EO " + "Das Ion ist " + IonName[b]
                                + " mit der Ionnen Masse ist: " + IonenPossitiv[b] + " Ladung ist " + IonenLadung[b]
                                + " Die Anzahl der EO Einheiten ist " + Laurinsaure;
                        System.out.println(text);
                        ANAmZahl[an] = MSwerte[z];
                        ANAmKorriergiert[an] = round(Test, 0);
                        ANArelativwert[an] = relativ[z];
                        ANAeoWert[an] = Laurinsaure;
                        ANAIonenLadung[an] = IonenLadung[b];
                        ANAIonenCharge[an] = IonenCharge[b];
                        ANAKorrektur[an] = text;
                        ANAkorrekturWertID[an] = b;
                        trefferID[an] = an;
                        an++;
                        pr++;
                    }
                }
                if (pr == 0) {
                    // System.out.println("Die Masser "+Eingabewert+" Lieferte keine Ergebnisse.");
                } else if (pr > 0) {
                    dr = dr + pr;
                    // System.out.println("Die Masser "+Eingabewert+" Lieferte MEHRERE
                    // Ergebnisse.");
                }
            }
            if (dr == 0) {
                String text = "Die Masser " + Eingabewert + " Lieferte keine Ergebnisse.";
                System.out.println(text);
                ANAmZahl[an] = MSwerte[z];
                ANAmKorriergiert[an] = MSwerte[z];
                ANArelativwert[an] = relativ[z];
                ANAeoWert[an] = 0;
                ANAIonenLadung[an] = 0;
                ANAIonenCharge[an] = 0;
                ANAKorrektur[an] = text;
                ANAkorrekturWertID[an] = 99;
                trefferID[an] = an;
                an++;
            } else if (dr > 1) {
                //System.out.println(dr);
                System.out.println("Die Masser " + Eingabewert + " Lieferte MEHRERE Ergebnisse.");
            } else if (dr == 1) {
                try {
                    ANAmZahle[ein] = ANAmZahl[an - 1];
                    ANAmKorriergierte[ein] = ANAmKorriergiert[an - 1];
                    ANArelativwerte[ein] = ANArelativwert[an - 1];
                    ANAeoWerte[ein] = ANAeoWert[an - 1];
                    ANAIonenLadunge[ein] = ANAIonenLadung[an - 1];
                    ANAIonenChargee[ein] = ANAIonenCharge[an - 1];
                    ANAKorrekture[ein] = ANAKorrektur[an - 1];
                    ANAkorrekturWertIDe[ein] = ANAkorrekturWertID[an - 1];
                    trefferIDe[ein] = an - 1;
                    ein++;
                } catch (Exception e) {
                    System.out.println("Kann Eindeutige Objekte nicht bekommen");
                    System.out.println();
                    System.out.println(e);
                }
            }
            dr = 0;
            pr = 0;
        }
        ane.setAnalysenObjekt(trefferIDe, ANAmZahle, ANAmKorriergierte, ANArelativwerte, ANAeoWerte, ANAIonenLadunge, ANAIonenChargee, ANAKorrekture, ANAkorrekturWertIDe);
        return ane;
    }

    public String[] CharalterAusgabeRel(String probename, double CO2GehaltinProzent, AnalysenObjekt analysenObjekt, boolean laurin, boolean dodecanol) {
        Tensid tensid = new Tensid();
        double[] parken = analysenObjekt.getmZahl();
        double[] parkenRel = analysenObjekt.getRelativwert();
        ArrayList<Double> list = new ArrayList<Double>();
        ArrayList<Double> rel = new ArrayList<Double>();
        for (int i = 0; i < parken.length; i++) {
            if (parkenRel[i] >= 1) {
                list.add(parken[i]);
                rel.add(parkenRel[i]);
            }
        }
        double[] mzZhal = new double[list.size()];
        double[] relativ = new double[list.size()];
        for (int i = 0; i < list.size(); i++) {
            mzZhal[i] = list.get(i);
            relativ[i] = rel.get(i);
        }
        String[] ausgabe = new String[mzZhal.length + 4];
        double[] xi = new double[mzZhal.length];
        double[] xiMI = new double[mzZhal.length];
        //double[] niMI=new double[mzZhal.length];
        double[] wi = new double[mzZhal.length];
        double[] niMI = new double[mzZhal.length];
        double[] miWI = new double[mzZhal.length];
        double summeRelativitaet = 0;
        double summeMI = 0;
        double KotrolleXI = 0;
        double Mn = 0;
        double kontoleWI = 0;
        double Mw = 0;
        double PDI = 0;
        double selectiviteat = 0;
        for (int i = 0; i < relativ.length; i++) {
            summeRelativitaet += relativ[i];
        }
        for (int i = 0; i < relativ.length; i++) {
            xi[i] = relativ[i] / summeRelativitaet;
        }
        for (int i = 0; i < xi.length; i++) {
            xiMI[i] = xi[i] * mzZhal[i];
        }
        for (int i = 0; i < relativ.length; i++) {
            niMI[i] = mzZhal[i] * relativ[i];
        }
        for (int i = 0; i < niMI.length; i++) {
            summeMI += niMI[i];
        }
        for (int i = 0; i < niMI.length; i++) {
            wi[i] = niMI[i] / summeMI;
        }
        for (int i = 0; i < wi.length; i++) {
            miWI[i] = wi[i] * mzZhal[i];
        }
        for (int i = 0; i < xi.length; i++) {
            KotrolleXI += xi[i];
        }
        for (int i = 0; i < xiMI.length; i++) {
            Mn += xiMI[i];
        }
        for (int i = 0; i < wi.length; i++) {
            kontoleWI += wi[i];
        }
        for (int i = 0; i < miWI.length; i++) {
            Mw += miWI[i];
        }
        PDI = Mw / Mn;
        double EOpCO2 = 0;
        double EO = 0;
        double Co2 = 0;
        if (dodecanol == true) {
            EOpCO2 = (Mw - 169 - 17) / 44;
        } else if (laurin == true) {
            EOpCO2 = (Mw - 199 - 17) / 44;
        }
        Co2 = ((Mw * CO2GehaltinProzent) / 100) / 44;
        EO = EOpCO2 - Co2;
        tensid.Tenside(probename, Mw, Mn, PDI, EO, Co2, CO2GehaltinProzent, 0);
        double select = selectivität(tensid, laurin, dodecanol, false);
        ausgabe[0] = "Tenside: " + probename + " Mn: " + Mn + " Mw: " + Mw + " PDI: " + PDI + " EOGruppen: " + EO + " CO2 Gruppen: " + Co2 + " CO2 Gehalt: " + CO2GehaltinProzent + " Selektivität CO2 ist: " + select;
        ausgabe[1] = "";
        ausgabe[2] = "Summe XI:" + KotrolleXI + " Summe WI" + KotrolleXI;
        ausgabe[3] = "M/Z Relativ xi xi*Mi ni*MI wi=(ni*Mi)/SUMME(ni*MI) mi*wi";
        int speicher = 4;
        for (int i = 0; i < mzZhal.length; i++) {
            ausgabe[speicher] = mzZhal[i] + " " + relativ[i] + " " + xi[i] + " " + xiMI[i] + " " + niMI[i] + " " + wi[i] + " " + miWI[i];
            speicher++;
        }
        //Filewriter file = new FilewriterImpl();
        //Boolean schreiben = file.writteDate(System.getProperty("user.home") + "\\Desktop\\" + probename + "_Charakter_Daten_Kleinste_EO.txt", ausgabe);
        //probename +"\\"+
        //if (schreiben != true) {
        //  System.out.println("Fehler beim niederschreiben der Charakterdaten");
        //}
        tensid.Tenside(probename, Mw, Mn, PDI, EO, Co2, CO2GehaltinProzent, select);
        setTens(tensid);
        return ausgabe;
    }

    public String[] CharalterAusgabe(String probename, double CO2GehaltinProzent, AnalysenObjekt analysenObjekt, boolean laurin, boolean dodecanol) {
        Tensid tensid = new Tensid();
        double[] mzZhal = analysenObjekt.getmZahl();
        double[] relativ = analysenObjekt.getRelativwert();
        String[] ausgabe = new String[mzZhal.length + 4];
        double[] xi = new double[mzZhal.length];
        double[] xiMI = new double[mzZhal.length];
        //double[] niMI=new double[mzZhal.length];
        double[] wi = new double[mzZhal.length];
        double[] niMI = new double[mzZhal.length];
        double[] miWI = new double[mzZhal.length];
        double summeRelativitaet = 0;
        double summeMI = 0;
        double KotrolleXI = 0;
        double Mn = 0;
        double kontoleWI = 0;
        double Mw = 0;
        double PDI = 0;
        double selectiviteat = 0;
        for (int i = 0; i < relativ.length; i++) {
            summeRelativitaet += relativ[i];
        }
        for (int i = 0; i < relativ.length; i++) {
            xi[i] = relativ[i] / summeRelativitaet;
        }
        for (int i = 0; i < xi.length; i++) {
            xiMI[i] = xi[i] * mzZhal[i];
        }
        for (int i = 0; i < relativ.length; i++) {
            niMI[i] = mzZhal[i] * relativ[i];
        }
        for (int i = 0; i < niMI.length; i++) {
            summeMI += niMI[i];
        }
        for (int i = 0; i < niMI.length; i++) {
            wi[i] = niMI[i] / summeMI;
        }
        for (int i = 0; i < wi.length; i++) {
            miWI[i] = wi[i] * mzZhal[i];
        }
        for (int i = 0; i < xi.length; i++) {
            KotrolleXI += xi[i];
        }
        for (int i = 0; i < xiMI.length; i++) {
            Mn += xiMI[i];
        }
        for (int i = 0; i < wi.length; i++) {
            kontoleWI += wi[i];
        }
        for (int i = 0; i < miWI.length; i++) {
            Mw += miWI[i];
        }
        PDI = Mw / Mn;
        double EOpCO2 = 0;
        double EO = 0;
        double Co2 = 0;
        if (dodecanol == true) {
            EOpCO2 = (Mw - 169 - 17) / 44;
        } else if (laurin == true) {
            EOpCO2 = (Mw - 199 - 17) / 44;
        }
        Co2 = ((Mw * CO2GehaltinProzent) / 100) / 44;
        EO = EOpCO2 - Co2;
        tensid.Tenside(probename, Mw, Mn, PDI, EO, Co2, CO2GehaltinProzent, 0);
        double select = selectivität(tensid, laurin, dodecanol, false);
        tensid.Tenside(probename, Mw, Mn, PDI, EO, Co2, CO2GehaltinProzent, select);
        ausgabe[0] = "Tenside: " + probename + " Mn: " + Mn + " Mw: " + Mw + " PDI: " + PDI + " EOGruppen: " + EO + " CO2 Gruppen: " + Co2 + " CO2 Gehalt: " + CO2GehaltinProzent + " Selektivität CO2 ist: " + select;
        ausgabe[1] = "";
        ausgabe[2] = "Summe XI:" + KotrolleXI + " Summe WI" + KotrolleXI;
        ausgabe[3] = "M/Z Relativ xi xi*Mi ni*MI wi=(ni*Mi)/SUMME(ni*MI) mi*wi";
        int speicher = 4;
        for (int i = 0; i < mzZhal.length; i++) {
            ausgabe[speicher] = mzZhal[i] + " " + relativ[i] + " " + xi[i] + " " + xiMI[i] + " " + niMI[i] + " " + wi[i] + " " + miWI[i];
            speicher++;
        }
        //Filewriter file = new FilewriterImpl();
        //Boolean schreiben = file.writteDate(System.getProperty("user.home") + "\\Desktop\\" + probename + "_Charakter_Daten_Kleinste_EO.txt", ausgabe);
        //probename +"\\"+
        //if (schreiben != true) {
        //  System.out.println("Fehler beim niederschreiben der Charakterdaten");
        //}
        setTens(tensid);
        return ausgabe;
    }



    /* (non-Javadoc)
     * @see de.daniel.brueggemann.tu.berlin.MSRechner.AnalyserInterface#esikorrekturObject(double[], double[], int, int, boolean, boolean, boolean)
    @Override
    public AnalysenObjekt esikorrekturObject(double[] mszahlen, double[] relativ, int einzelwerte, int ergebnisse,
                                             boolean laurin, boolean dodecanol, boolean eo) {
        // TODO Auto-generated method stub
        return null;
    }

     (non-Javadoc)
     * @see de.daniel.brueggemann.tu.berlin.MSRechner.AnalyserInterface#esiNurkleinsteEOObject(double[], double[], int, int, int, int, boolean, boolean, boolean)
    @Override
    public AnalysenObjekt esiNurkleinsteEOObject(double[] mszahlen, double[] relativ, int einzelwerte, int ergebnisse,
                                                 int doppelwerte, int keinErgebnis, boolean laurin, boolean dodecanol, boolean eo) {
        AnalysenObjekt ana = new AnalysenObjekt();
        //test.setAnalysenObjekt(mZahl, mKorriergiert, relativwert, eoWert, IonenLadung, IonenCharge, Korrektur, korrekturWertID);
        setRueckgabe(ana);
        return getRueckgabe();
    }
    **/

    /**
     * Gets rueckgabe.
     *
     * @return the rueckgabe
     */
    public AnalysenObjekt getRueckgabe() {
        return rueckgabe;
    }

    /**
     * Sets rueckgabe.
     *
     * @param rueckgabe the rueckgabe to set
     */
    public void setRueckgabe(AnalysenObjekt rueckgabe) {
        this.rueckgabe = rueckgabe;
    }

    public Tensid getTens() {
        return Tens;
    }

    /**
     * Sets tens.
     *
     * @param tens the tens
     */
    public void setTens(Tensid tens) {
        Tens = tens;
    }
}
