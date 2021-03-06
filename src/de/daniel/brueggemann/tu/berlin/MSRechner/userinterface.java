/**
 *
 */
package de.daniel.brueggemann.tu.berlin.MSRechner;

import java.lang.Math;
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

/**
 * The type Userinterface.
 *
 * @author Daniel
 */
public class userinterface {

    /**
     * The Ionen possitiv.
     *
     * @param args
     */
    public final static double[] IonenPossitiv = {1.007276, 19.985217, 21.520550, 22.989218, 42.033823, 62.547097,
            1.007276, 22.989218, 33.033489, 38.963158, 42.033823, 44.971160, 64.015765, 76.919040, 83.060370, 1.007276,
            22.989218, 28.02312, 38.963158};
    /**
     * The Ionen ladung.
     */
    public final static int[] IonenLadung = {2, 2, 2, 2, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1};
    /**
     * The Ionen charge.
     */
    public final static double[] IonenCharge = {0.5, 0.5, 0.5, 0.5, 0.5, 0.5, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2};
    /**
     * The Ion name.
     */
    public final static String[] IonName = {"M+2H", "M+H+K", "M+ACN+2H", "M+2Na", "M+2ACN+2H", "M+3ACN+2H", "M+H",
            "M+Na", "M+CH3OH+H", "M+K", "M+ACN+H", "M+2Na-H", "M+ACN+Na", "M+2K+H", "M+2ACN+H", "2M+H", "2M+Na",
            "2M+3H2O+2H", "2M+K"};
    /**
     * The constant MP2H.
     */
    public final static double MP2H = 1.007276;
    /**
     * The constant MPHK.
     */
    public final static double MPHK = 19.985217;
    private boolean LaurinsauerePR = false;
    private boolean EOPR = true;
    private boolean DodecanolPR = true;
    private boolean Natrium = false;
    /**
     * The constant ana.
     */
    public static AnalysenObjekt ana = new AnalysenObjekt();
    /**
     * The constant messdaten.
     */
    public static Messdaten messdaten = new Messdaten();
    /**
     * The constant version.
     */
    public static final double version = 0.1;

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
//public final static String dateiName = "C:\\Users\\Daniel\\eclipse-workspace\\MS_EO_RECHNER\\src\\de\\daniel\\brueggemann\\tu\\berlin\\MSRechner\\test.txt";
    public static void main(String[] args) {
        Einleser ein = new EinleserImpl();
        Filewriter file = new FilewriterImpl();
        System.out.println("BITTE GEBEN SIE DEN PROBEN NAMEN AN:");
        String Probenname = ein.Stringeinleser();
        String Filename = Probenname + ".txt";
        String dateiName = System.getProperty("user.home") + "\\Desktop\\" + Filename;
        String AusgabeDatei = System.getProperty("user.home") + "\\Desktop\\" + Probenname;
        String Datei = AusgabeDatei + "\\" + Probenname;
        //+ Probenname+"\\"
        Boolean ordner = file.mkdir(AusgabeDatei + "\\");
        if (ordner != true) {
            System.out.println("FEHLER");
        }
        System.out.println("Wurde mit Natrium gearbeitet true or false?");
        Boolean natrium = ein.JaoderNein();
        KorrekturwerteDaten.setNatrium(natrium);
        System.out.println("Wie viel Co2 hat die Probe in Prozent?");
        double CO2GehaltinProzent = ein.doublereader();
        System.out.println("Wollen sie auf Dodecanol Pruefen? true or false");
        Boolean dode = ein.JaoderNein();
        System.out.println("Wollen sie auf Laurinsaeure Pruefen? true or false");
        Boolean lau = ein.JaoderNein();
        System.out.println("Wollen sie auf EO-Ketten alleine Pruefen? true or false");
        Boolean eoP = ein.JaoderNein();
        ///TO-DO


        startAnalyse(file, Probenname, dateiName, Datei, natrium, CO2GehaltinProzent, dode, lau, eoP);

    }

    private static void startAnalyse(Filewriter file, String probenname, String dateiName, String datei, Boolean natrium, double CO2GehaltinProzent, Boolean dode, Boolean lau, Boolean eoP) {
        String[] Hase = dateiToArray(dateiName);
        double[] mzZahl = new double[Hase.length];
        double[] intensitaet = new double[Hase.length];
        double[] relativ = new double[Hase.length];
        //Messdaten messdaten=new Messdaten();
        DatestreamDecoder data = new DatestreamDecoderImpl();
        try {
            messdaten = data.decodeToMessdaten(Hase);
            mzZahl = messdaten.getMzZahl();
            intensitaet = messdaten.getIntensitaet();
            relativ = messdaten.getRelativ();
        } catch (Exception e) {
            System.out.println("Ein Schwerer Fehler ist aufgetretten beim Umwandeln der daten in nutzbare Daten!!!");
            System.out.println();
            System.out.println(e);
        }


        //String[] dataidatenArray =Hase[0].trim().split("\\s+");
        //lineOfPhonesWithMultipleWhiteSpace.split("\\s+");
        //System.out.println("output string: " + Arrays.toString(phones));
		/*
		System.out.println("FELD TEST");
		for (int i=0;i<Hase.length;i++)
		{
			System.out.println(Hase[i]);
		}
		*/
        System.out.println(System.getProperty("user.home") + "\\Desktop");
        //ladeDatei(dateiName);
        double[] MSwerte = mzZahl;
        //{ 227.20, 289.24, 333.26, 355.25, 399.31, 443.34, 531.39, 575.41, 619.44, 663.47, 707.49,
        //	751.52, 795.55, 839.57, 883.60, 927.62, 971.65, 1059.70, 1103.73, 1191.78 };
        int[] ergebnisausdruck = new int[4];
        AnalyserInterface analy = new AnalyseImplementierung();
        Treffer treffer = new Treffer();
        treffer = analy.anzahlErgebnisse(messdaten, lau, dode, eoP);
        ergebnisausdruck[0] = treffer.getTreffer();
        ergebnisausdruck[1] = treffer.getDoppelt();
        ergebnisausdruck[2] = treffer.getKeinTreffer();
        ergebnisausdruck[3] = treffer.getEindeutig();
        String ausage = "Es wurden " + MSwerte.length + " ausgewerte dabei wurden " + ergebnisausdruck[0] + " Treffer gefunden, davon waren " + ergebnisausdruck[1] + " doppelt. Eindeutige einzelltreffer waren: " + ergebnisausdruck[3] + " Nichts wurde gefunden bei " + ergebnisausdruck[2];
        System.out.println(ausage);
        ana = analy.esikorrekturObject(messdaten, treffer, lau, dode, eoP);
        for (int i = 0; i < ana.getTrefferID().length; i++) {
            System.out.println(ana.getKorrektur()[i]);
        }
        //analyse(MSwerte);
        //double[] hf = ana.getmKorriergiert();
        //System.out.println(hf[2]);
        //int[][] doubleArray = new int[][]{{1, 6, 16, 20, 5, 6}, {1, 3, 2, 2, 9, 3}};
        //System.out.println(doubleArray[0][4]);
        //System.out.println(doubleArray[1][4]);
        //System.out.println(doubleArray[0].length);
//		for(int i=0;i<doubleArray[0].length;i++)
        //	{
       /* for (int z = 0; z < doubleArray[1].length; z++) {
            if (doubleArray[1][z] == 2) {
                System.out.println(doubleArray[0][z] + "	" + doubleArray[1][z]);
            }
        }*/
        //}
        Tensid tensid = new Tensid();
        //Gibt inkorrigiertes Tensid ohne ESI Korrektur zurück
        tensid = analy.charakterisierung(probenname, CO2GehaltinProzent, messdaten, lau, dode);
        Tensid tensidEORelevant = new Tensid();
        //Gibt Relevante EO Tensid aus
        tensidEORelevant = analy.charakteristikKorregiert(probenname, CO2GehaltinProzent, ana, lau, dode);
        boolean erfolg = file.writtereport(datei, tensid, treffer, ana);
        if (erfolg == true) {
            System.out.println("Datei Geschrieben");
        } else {
            System.out.println("Fehler beim Schreiben der Daten");
        }
        AnalysenObjekt ane = new AnalysenObjekt();
        ane = analy.esikorrekturEindeutig(messdaten, treffer, lau, dode, eoP);
        /*
        try{
            ane=analy.esikorrekturEindeutig(messdaten,treffer,true,false,true);
        }catch (Exception e) {
            System.out.println("Kann Eindeutige Objekte nicht bekommen");
            System.out.println();
            System.out.println(e);
        }
        */
        Tensid eindeutigesTensid = new Tensid();
        String[] eindeutigeReport = analy.CharalterAusgabe(probenname, CO2GehaltinProzent, ane, lau, dode);
        eindeutigesTensid = analy.getTens();
        Boolean eindeutigReo = file.writteDate(datei + "_EindeutigeCharckter.txt", eindeutigeReport);
        if (eindeutigReo != true) {
            System.out.println("Fehler beim Schreiben der Daten");
        }
        String[] eindeutigeReportRel = analy.CharalterAusgabeRel(probenname, CO2GehaltinProzent, ane, lau, dode);
        Tensid eindeutigesTensidRelevanteEO = new Tensid();
        eindeutigesTensidRelevanteEO = analy.getTens();
        Boolean eindeutigReoRL = file.writteDate(datei + "_EindeutigeCharckterRelativ.txt", eindeutigeReportRel);
        if (eindeutigReoRL != true) {
            System.out.println("Fehler beim Schreiben der Daten");
        }
        //eindeutigesTensid=analy.

        System.out.println("Es wurden " + MSwerte.length + " ausgewerte dabei wurden " + ergebnisausdruck[0] + " Treffer gefunden, davon waren " + ergebnisausdruck[1] + " doppelt. Eindeutige einzelltreffer waren: " + ergebnisausdruck[3] + " Nichts wurde gefunden bei " + ergebnisausdruck[2]);
        //ausage
        /*
        Probe
        Version
        Bolleans
        4 Tenside
        letzter satz
         */
        double EOmittel = 0;
        for (int i = 0; i < ana.getEoWert().length; i++) {
            EOmittel += ana.getEoWert()[i];
        }
        EOmittel = EOmittel / ana.getEoWert().length;
        double EOmittelREL = 0;
        for (int i = 0; i < ane.getEoWert().length; i++) {
            EOmittelREL += ane.getEoWert()[i];
        }
        EOmittelREL = EOmittelREL / ane.getEoWert().length;
        String[] abschlussbericht = new String[16];
        abschlussbericht[0] = "Ausgewertet wurde die Probe: " + probenname + " Mittlerer EO-Wert ist: " + EOmittel + " relevantes Mittel: " + EOmittelREL;
        abschlussbericht[2] = "Genutzte Programm Version: " + version;
        abschlussbericht[4] = "Gesetzte Optionen Natrium: " + natrium + " Dodecanol: " + dode + " Laurinsaeure: " + lau + " EO: " + eoP;
        abschlussbericht[6] = Tensidzusammenfassung("Wurde keine Korrektur beachtet", tensid);
        abschlussbericht[8] = Tensidzusammenfassung("Wurden nur Massenzahlen mit einer Relativitaet groesser 1 mit korrespondierender EO Zahl beachtet", tensidEORelevant);
        abschlussbericht[10] = Tensidzusammenfassung("Wurde nur daten Beachet die einen eindeutigen EO Wert haben und keine mehrfach bedeutung.", eindeutigesTensid);
        abschlussbericht[12] = Tensidzusammenfassung("Wurde nur daten Beachet die einen eindeutigen EO Wert haben und keine mehrfach bedeutung haben als auch Relativ mehr als 1 vorlagen.", eindeutigesTensidRelevanteEO);
        abschlussbericht[14] = ausage;
        Boolean lastreport = file.writteDate(datei + "_Abschluss.txt", abschlussbericht);
        if (eindeutigReo != true) {
            System.out.println("Fehler beim Schreiben der Daten");
        }
    }

    /**
     * Tensidzusammenfassung string.
     *
     * @param bedeutung the bedeutung
     * @param tensid    the tensid
     * @return the string
     */
    public static String Tensidzusammenfassung(String bedeutung, Tensid tensid) {
        String ausgabe = "Für die Auswertung " + bedeutung + " Ergaben sich folgende werte " + "Tenside: " + tensid.getName() + " Mn: " + tensid.getMN() + " Mw: " + tensid.getMW() + " PDI: " + tensid.getPDI() + " EOGruppen: " + tensid.getEO() + " CO2 Gruppen: " + tensid.getCO2() + " CO2 Gehalt: " + tensid.getCO2Gehalt() + " Selektivität CO2 ist: " + tensid.getSelectivitaet() + " Einsatzverhältnis waehre: 1/" + (tensid.getCO2() + tensid.getEO()) / 2;
        return ausgabe;
    }

    /*private static void analyse(double[] MSwerte) {
        int pr = 0;
        int dr = 0;
        for (int z = 0; z < MSwerte.length; z++) {
            dr = 0;
            pr = 0;
            double Eingabewert = MSwerte[z];
            for (int b = 0; b < IonenPossitiv.length; b++) {
                double Test = Eingabewert * IonenCharge[b] - IonenPossitiv[b];
                double LaurinsaeureE = round(Test, 0) - 199;
                double Laurinsaure = LaurinsaeureE / 44;
                // System.out.println(Test+" "+LaurinsaeureE+" "+Laurinsaure);
                if (Laurinsaure % 1 == 0) {
                    System.out.println(Eingabewert + " Treffer auf Laurinsäurebasis " + "Das Ion ist " + IonName[b]
                            + " mit der Ionnen Masse ist: " + IonenPossitiv[b] + " Ladung ist " + IonenLadung[b]
                            + " Die Anzahl der EO Einheiten ist " + Laurinsaure);
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
            pr = 0;
            for (int b = 0; b < IonenPossitiv.length; b++) {
                double Test = Eingabewert * IonenCharge[b] - IonenPossitiv[b];
                double LaurinsaeureE = round(Test, 0) - 189;
                double Laurinsaure = LaurinsaeureE / 44;
                // System.out.println(Test+" "+LaurinsaeureE+" "+Laurinsaure);
                if (Laurinsaure % 1 == 0) {
                    System.out.println(Eingabewert + " Treffer auf Dodecanolbasis " + "Das Ion ist " + IonName[b]
                            + " mit der Ionnen Masse ist: " + IonenPossitiv[b] + " Ladung ist " + IonenLadung[b]
                            + " Die Anzahl der EO Einheiten ist " + Laurinsaure);
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
            pr = 0;
            for (int b = 0; b < IonenPossitiv.length; b++) {
                double Test = Eingabewert * IonenCharge[b] - IonenPossitiv[b];
                double LaurinsaeureE = round(Test, 0);
                double Laurinsaure = LaurinsaeureE / 44;
                // System.out.println(Test+" "+LaurinsaeureE+" "+Laurinsaure);
                if (Laurinsaure % 1 == 0) {
                    System.out.println(Eingabewert + " Treffer auf EO " + "Das Ion ist " + IonName[b]
                            + " mit der Ionnen Masse ist: " + IonenPossitiv[b] + " Ladung ist " + IonenLadung[b]
                            + " Die Anzahl der EO Einheiten ist " + Laurinsaure);
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
            if (dr == 0) {
                System.out.println("Die Masser " + Eingabewert + " Lieferte keine Ergebnisse.");
            } else if (dr > 1) {
                //System.out.println(dr);
                System.out.println("Die Masser " + Eingabewert + " Lieferte MEHRERE Ergebnisse.");
            }
            dr = 0;
            pr = 0;
        }
    }

    private static int[] anzahlErgebnisse(double[] MSwerte) {
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
            for (int b = 0; b < IonenPossitiv.length; b++) {
                double Test = Eingabewert * IonenCharge[b] - IonenPossitiv[b];
                double LaurinsaeureE = round(Test, 0) - 199;
                double Laurinsaure = LaurinsaeureE / 44;
                // System.out.println(Test+" "+LaurinsaeureE+" "+Laurinsaure);
                if (Laurinsaure % 1 == 0) {
					*//*
					System.out.println(Eingabewert + " Treffer auf Laurinsäurebasis " + "Das Ion ist " + IonName[b]
							+ " mit der Ionnen Masse ist: " + IonenPossitiv[b] + " Ladung ist " + IonenLadung[b]
							+ " Die Anzahl der EO Einheiten ist " + Laurinsaure);
							*//*
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
            pr = 0;
            for (int b = 0; b < IonenPossitiv.length; b++) {
                double Test = Eingabewert * IonenCharge[b] - IonenPossitiv[b];
                double LaurinsaeureE = round(Test, 0) - 189;
                double Laurinsaure = LaurinsaeureE / 44;
                // System.out.println(Test+" "+LaurinsaeureE+" "+Laurinsaure);
                if (Laurinsaure % 1 == 0) {
					*//*
					System.out.println(Eingabewert + " Treffer auf Dodecanolbasis " + "Das Ion ist " + IonName[b]
							+ " mit der Ionnen Masse ist: " + IonenPossitiv[b] + " Ladung ist " + IonenLadung[b]
							+ " Die Anzahl der EO Einheiten ist " + Laurinsaure);
							*//*
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
            pr = 0;
            for (int b = 0; b < IonenPossitiv.length; b++) {
                double Test = Eingabewert * IonenCharge[b] - IonenPossitiv[b];
                double LaurinsaeureE = round(Test, 0);
                double Laurinsaure = LaurinsaeureE / 44;
                // System.out.println(Test+" "+LaurinsaeureE+" "+Laurinsaure);
                if (Laurinsaure % 1 == 0) {
					*//*
					System.out.println(Eingabewert + " Treffer auf EO " + "Das Ion ist " + IonName[b]
							+ " mit der Ionnen Masse ist: " + IonenPossitiv[b] + " Ladung ist " + IonenLadung[b]
							+ " Die Anzahl der EO Einheiten ist " + Laurinsaure);
							*//*
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
        int[] ausgabe = new int[4];

        return ausgabe;
    }*/

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

    private static String[] dateiToArray(String datName) {
        int zeilen = zeilen(datName);
        //System.out.println(zeilen);
        String[] feld = new String[zeilen];
        int feldzeiger = 0;
        File file = new File(datName);

        if (!file.canRead() || !file.isFile()) System.exit(0);

        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader(datName));
            String zeile = null;
            while ((zeile = in.readLine()) != null) {
                //System.out.println("Gelesene Zeile: " + zeile);
                feld[feldzeiger] = zeile;
                feldzeiger++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) try {
                in.close();
            } catch (IOException e) {
                System.out.println("FAIL");
                return null;
            }
        }
        return feld;
    }

    private static void ladeDatei(String datName) {
        int zeilen = zeilen(datName);
        //System.out.println(zeilen);
        String[] feld = new String[zeilen];
        int feldzeiger = 0;
        File file = new File(datName);

        if (!file.canRead() || !file.isFile()) System.exit(0);

        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader(datName));
            String zeile = null;
            while ((zeile = in.readLine()) != null) {
                //System.out.println("Gelesene Zeile: " + zeile);
                feld[feldzeiger] = zeile;
                feldzeiger++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) try {
                in.close();
            } catch (IOException e) {
                //System.out.println("FAIL");
            }
        }
    }

    private static int zeilen(String datName) {

        File file = new File(datName);

        if (!file.canRead() || !file.isFile()) System.exit(0);

        BufferedReader in = null;
        int test = 0;
        try {
            in = new BufferedReader(new FileReader(datName));
            while ((in.readLine()) != null) {
                test++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) try {
                in.close();
            } catch (IOException e) {
                System.out.println("FAIL");
            }
        }
        return test;
    }

    /**
     * @return the laurinsauerePR
     */
    private boolean isLaurinsauerePR() {
        return LaurinsauerePR;
    }

    /**
     * @param laurinsauerePR the laurinsauerePR to set
     */
    private void setLaurinsauerePR(boolean laurinsauerePR) {
        LaurinsauerePR = laurinsauerePR;
    }

    /**
     * @return the eOPR
     */
    private boolean isEOPR() {
        return EOPR;
    }

    /**
     * @param eOPR the eOPR to set
     */
    private void setEOPR(boolean eOPR) {
        EOPR = eOPR;
    }

    /**
     * @return the dodecanolPR
     */
    private boolean isDodecanolPR() {
        return DodecanolPR;
    }

    /**
     * @param dodecanolPR the dodecanolPR to set
     */
    private void setDodecanolPR(boolean dodecanolPR) {
        DodecanolPR = dodecanolPR;
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
     * Sets natrium.
     *
     * @param natrium the natrium
     */
    public void setNatrium(boolean natrium) {
        Natrium = natrium;
    }

}
