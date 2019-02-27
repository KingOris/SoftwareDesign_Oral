import java.util.Scanner;


/**
 * @author Yuhang CHen
 * @version 0.0.1 10/5/2018
 * This class is for calculating hamming distance
 */
public class Hamming_Distance {
    /**
     *A private variable for save the result distance in double
     */
    private double distance;

    /**
     * A constructor which need two string parameters and get the result saved in distance
     * @param first first string that urser input
     * @param sencond second string that urser input
     */
    public Hamming_Distance(String first, String sencond){

        String[] f = first.split("");

        String[] s = sencond.split("");

        if(s.length != f.length){
            throw new IllegalArgumentException("Different Length");
        }

        for(int i = 0; i<f.length; i++){
            if(Integer.parseInt(f[i]) !=0 && Integer.parseInt(f[i]) !=1 && Integer.parseInt(s[i]) !=0 && Integer.parseInt(s[i]) !=1){
                throw new IllegalArgumentException("Please enter only 1 and 0");
            }
        }

        int count = 0;
        for(int i = 0; i<f.length; i++){
            if(f[i].equals(s[i])){
                count++;
            }
        }

        distance = f.length - count;
        System.out.println("Distance : " + distance);
    }

    /**
     * A getter method for distance
     * @return double distance
     */
    public double getDistance() {
        return distance;
    }
}
