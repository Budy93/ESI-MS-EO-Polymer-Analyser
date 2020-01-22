/**
 *
 */
package de.daniel.brueggemann.tu.berlin.MSRechner;

/**
 * The type Analyse implementierung.
 *
 * @author Daniel
 */
public class AnalyseImplementierung implements AnalyserInterface {
    private AnalysenObjekt rueckgabe = new AnalysenObjekt();

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

    @Override
    public Tensid charakteristikKorregiert(String probename, AnalysenObjekt analysenObjekt) {
        return null;
    }

    @Override
    public Tensid charakterisierung(String probenname, Messdaten messdaten) {
        return null;
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

}
