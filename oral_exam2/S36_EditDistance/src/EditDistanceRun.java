import java.util.Scanner;

/**
 * The main function to run the program
 */
public class EditDistanceRun {
    public static void main(String[] args) {
        System.out.println("Please enter the first string : ");
        Scanner scanner1 = new Scanner(System.in);
        //To get the first user input string
        String str1 = scanner1.nextLine();
        System.out.println("Please enter the second string : ");
        //To get the second user input string
        String str2 = scanner1.nextLine();

        //To create the compare
        Algorithm compare = new Algorithm(str1, str2);
        //To build the matrix
        compare.createMatrix();
        //To run the needle man algorithm
        compare.needleAlgortithm();
        //To find the distance
        compare.trackBack();
    }
}
