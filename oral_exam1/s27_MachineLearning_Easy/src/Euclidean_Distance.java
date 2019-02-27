import java.util.Scanner;

/**
 * @author Yuhang CHen
 * @version 0.0.1 10/5/2018
 * This class is for calculating euclidean distance
 */
public class Euclidean_Distance {
    /**
     *A private double that is the result of the class
     */
    private double distance;

    /**
     * A constructor which need 2 string parameters and calculate the euclidean distance which save in distance
     * @param first first string that urser input
     * @param sencond second string that urser input
     */
    public Euclidean_Distance(String first, String sencond){

        String[] f = first.split(" ");

        String[] s = sencond.split(" ");

        if(s.length != f.length){
            throw new IllegalArgumentException("Different Length");
        }

        double sum = 0.0;
        for(int i = 0; i<f.length; i++){
            double diff = Double.parseDouble(f[i]) - Double.parseDouble(s[i]);
            sum = sum + diff * diff;
        }

        distance =(double)Math.round(Math.sqrt(sum)*10000)/10000;

        System.out.println("Euclidean distance : " + distance);
    }

    /**
     * A getter method for distance
     * @return double distance
     */
    public double getDistance() {
        return distance;
    }
}
