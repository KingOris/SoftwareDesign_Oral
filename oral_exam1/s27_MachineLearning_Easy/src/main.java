import java.util.Scanner;

/**
 * @author Yuhang Chen
 * @version 0.0.1 10/5/2018
 * This class is to run three calculate method class
 */
public class main {
    /**
     * To run the program. It will ask user to choose which one need to be calculated and input two array stored in string form
     * @param args string
     */
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        System.out.println("Please choose which one you want to run: 1. Cosine Similarity 2.Euclidean Distance 3 Hamming distance");
        int choose = scan.nextInt();

        Scanner scanFirst = new Scanner(System.in);
        System.out.println("Please enter the first array.");
        String first = scanFirst.nextLine();

        Scanner scanSecond = new Scanner(System.in);
        System.out.println("Please enter the second array");
        String sencond = scanSecond.nextLine();

        if(choose == 1) {

            new Cosine_Similarity(first,sencond);
        }

        if(choose == 2){
            new Euclidean_Distance(first,sencond);
        }

        if(choose == 3){
           new Hamming_Distance(first,sencond);

        }
    }
}
