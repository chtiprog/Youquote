/*
 * Classe trouvée sur "mesexemples.com"
 */
package atonix.youquote.BusinessLogic;

import java.io.BufferedReader;
import java.io.FileReader;

public class CSVFile {

    public static String[] data;

    public static void parseCSV() throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("/home/ankat/testTelechargement.csv"));
        String ligne = null;
        while ((ligne = br.readLine()) != null) {
            // Retourner la ligne dans un tableau
            data = ligne.split(",");

            // Afficher le contenu du tableau
            for (String val : data) {
                System.out.println(val);
            }
        }
        br.close();
    }

    public static Double variation(String open, String close) {
        Double var, openDouble, closeDouble;
        openDouble = Double.valueOf(open);
        closeDouble = Double.valueOf(close);
        var = ((closeDouble / openDouble) - 1) * 100;
        return arrondi(var);
    }

    public static double arrondi(double val) {
        return (Math.floor(val * 100 + 0.5)) / 100;
    }
}