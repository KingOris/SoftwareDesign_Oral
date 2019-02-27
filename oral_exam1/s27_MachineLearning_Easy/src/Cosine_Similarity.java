import java.util.Scanner;

/**
 * @author Yuhang Chen
 * @version 0.0.1 10/5/2018
 * This class for calculating cosine similarity
 */
public class Cosine_Similarity {
    /**
     * A double private for the resuilt
     */
    private double similarity;

    /**
     * A constructor which needs two string parameter and calculate similarity
     * @param first first string that urser input
     * @param sencond second string that urser input
     */
    public  Cosine_Similarity(String first, String sencond) {

        String[] f = first.split(" ");


        String[] s = sencond.split(" ");

        if (s.length != f.length) {
            throw new IllegalArgumentException("Different Length");
        }

        double ab = 0.0;
        double sumA = 0.0;
        double sumB = 0.0;
        for (int i = 0; i < s.length; i++) {
            ab = ab + Double.parseDouble(s[i]) * Double.parseDouble(f[i]);
            sumA = sumA + Double.parseDouble(f[i]) * Double.parseDouble(f[i]);
            sumB = sumB + Double.parseDouble(s[i]) * Double.parseDouble(s[i]);
        }

        double sqr = Math.sqrt(sumA) * Math.sqrt(sumB);
        similarity = (double)Math.round((ab / sqr)*10000)/10000;

        System.out.println("Similarity =  " + similarity);
    }

    /**
     * A getter method for similarity
     * @return double similarity
     */
    public double getSimilarity() {
        return similarity;
    }
}
