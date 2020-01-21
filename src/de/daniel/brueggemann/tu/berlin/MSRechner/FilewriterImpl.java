package de.daniel.brueggemann.tu.berlin.MSRechner;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FilewriterImpl implements Filewriter {

    @Override
    public boolean writtereport(String filename, Tensid tensid, Treffer treffer, AnalysenObjekt analysenObjekt) {
        //Tensid tenside=new Tensid();
        //tensid=tensid;
        int[] ergebnisausdruck = new int[4];
        ergebnisausdruck[0] = treffer.getTreffer();
        ergebnisausdruck[1] = treffer.getDoppelt();
        ergebnisausdruck[2] = treffer.getKeinTreffer();
        ergebnisausdruck[3] = treffer.getEindeutig();
        String auswertungsatz = "Es wurden " + treffer.getMesswerte() + " ausgewerte dabei wurden " + ergebnisausdruck[0] + " Treffer gefunden, davon waren " + ergebnisausdruck[1] + " doppelt. Eindeutige einzelltreffer waren: " + ergebnisausdruck[3] + " Nichts wurde gefunden bei " + ergebnisausdruck[2];
        Boolean erfolg = false;

        PrintWriter pWriter = null;
        try {
            pWriter = new PrintWriter(new FileWriter(filename + "_mZKorrigiert.txt", true));
            pWriter.println("Auswertung für: " + filename);
            String Struktur = "TrefferID" + " " + "MZ" + " " + "MZ_Korriergiert" + " " + "Relativ" + " " + "EO" + " " + "Bemerkung";
            pWriter.println(Struktur);
            for (int i = 0; i < analysenObjekt.getTrefferID().length; i++) {
                String Ion;
                if (analysenObjekt.getKorrekturWertID()[i] != 99) {
                    Ion = KorrekturwerteDaten.getIonname()[analysenObjekt.getKorrekturWertID()[i]];
                } else {
                    Ion = "Keine_Korrektur_vorgenommen!!!!";
                }

                String ausgabe = analysenObjekt.getTrefferID()[i] + " " + analysenObjekt.getmZahl()[i] + " " + analysenObjekt.getmKorriergiert()[i] + " " + analysenObjekt.getRelativwert()[i] + " " + analysenObjekt.getEoWert()[i] + " " + Ion;
                pWriter.println(ausgabe);
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
            erfolg = false;
        } finally {
            //PrintWriter pWriter = null;
            if (pWriter != null) {
                pWriter.flush();
                pWriter.close();
                erfolg = true;
            }
        }
        PrintWriter pW = null;
        try {
            pW = new PrintWriter(new FileWriter(filename + "_Auswertungs.txt", true));

            pW.println("Auswertung für: " + filename);
            for (int i = 0; i < analysenObjekt.getTrefferID().length; i++) {
                String ausgabeZwei = analysenObjekt.getKorrektur()[i];
                pW.println(ausgabeZwei);
            }
            pW.println(auswertungsatz);

        } catch (IOException ioe) {
            ioe.printStackTrace();
            erfolg = false;
        } finally {
            //PrintWriter pWriter = null;
            if (pW != null) {
                pW.flush();
                pW.close();
                erfolg = true;
            }
        }
        PrintWriter pd = null;
        try {
            //pd = new PrintWriter(new FileWriter(filename, true));

            pd = new PrintWriter(new FileWriter(filename + "_nurMitEOWerten.txt", true));
            pd.println("Auswertung für: " + filename);
            String Struktur = "TrefferID" + " " + "MZ" + " " + "MZ_Korriergiert" + " " + "Relativ" + " " + "EO";
            pd.println(Struktur);
            for (int i = 0; i < analysenObjekt.getTrefferID().length; i++) {
                if (analysenObjekt.getKorrekturWertID()[i] != 99) {
                    String ausgabe = analysenObjekt.getTrefferID()[i] + " " + analysenObjekt.getmZahl()[i] + " " + analysenObjekt.getmKorriergiert()[i] + " " + analysenObjekt.getRelativwert()[i] + " " + analysenObjekt.getEoWert()[i];
                    pd.println(ausgabe);
                }
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
            erfolg = false;
        } finally {
            //PrintWriter pWriter = null;
            if (pd != null) {
                pd.flush();
                pd.close();
                erfolg = true;
            }
            return erfolg;
        }
    }
}
