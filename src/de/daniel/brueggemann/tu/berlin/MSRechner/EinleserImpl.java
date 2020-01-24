package de.daniel.brueggemann.tu.berlin.MSRechner;

import java.util.Scanner;

/**
 * The type Einleser.
 */
public class EinleserImpl implements Einleser {
    /**
     * Liest einen belibige Integerzahl ein.
     *
     * @return Integer
     */
    @Override
    public int Zahleinleser() {
        Scanner sc = new Scanner(System.in);
        int z;
        while (true) {
            try {
                String line = sc.next();
                sc.close();
                z = Integer.parseInt(line);
                break;
            } catch (java.lang.NumberFormatException e) {
                System.out.println("Fehler 06: Kein Integer! Nochmal versuchen");
            }
        }
        return z;
    }

    /**
     * Liest einen bliebigen String ein.
     *
     * @return String
     */
    @Override
    public String Stringeinleser() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    @Override
    public Boolean JaoderNein() {
        Scanner sc = new Scanner(System.in);
        return sc.nextBoolean();
    }

    public double doublereader() {
        Scanner sc = new Scanner(System.in);
        return sc.nextDouble();
    }
}
