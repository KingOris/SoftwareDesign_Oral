import java.util.ArrayList;
import java.util.Arrays;

/**
 * The algorithm class to find the least distance of 2 string
 */
public class Algorithm {
    /**
     * A private string arraylist
     */
    private ArrayList<String> list1;
    /**
     * A private string arraylist
     */
    private ArrayList<String> list2;
    /**
     * A private integer to count the distance
     */
    private int dis;
    /**
     * A private 2D integer matrix to run the algorithm
     */
    private int[][] matrix;
    /**
     * A private integer contain the match score
     */
    private int mis;
    /**
     * A private integer contain the match score
     */
    private int match;
    /**
     * A private integer contain the gap score
     */
    private int gap;
    /**
     * A private 2D integer matrix to store the dirction
     */
    private int[][] dir;
    /**
     * A private 2D integer matrix to store if the score was from match or mismatch
     */
    private int[][] diss;

    /**
     * The constructor of Algorithem class which put two string into two arraylist and creat three 2D matrix
     * Also it initialized the dis and three score
     *
     * @param string1 The first string that user input
     * @param string2 The second string that user input
     */
    public Algorithm(String string1, String string2) {
        //Put 2 string into 2 arraylist
        list1 = new ArrayList<>(Arrays.asList(string1.split("")));
        list2 = new ArrayList<>(Arrays.asList(string2.split("")));
        //Initialized the distance is zero
        dis = 0;
        //Create 3 matrix
        matrix = new int[list1.size() + 1][list2.size() + 1];
        dir = new int[list1.size() + 1][list2.size() + 1];
        diss = new int[list1.size() + 1][list2.size() + 1];
        matrix[0][0] = 0;
        //Set the score of 3 situation
        mis = -1;
        match = 1;
        gap = -2;

    }

    /**
     * The creatMatrix funtion is to set up the first column and the first raw score
     */
    public void createMatrix() {
        for (int i = 0; i <= list1.size(); i++) {
            matrix[i][0] = gap * i;
            if (i > 0) {
                dir[i][0] = 2;
            }
        }
        for (int j = 0; j <= list2.size(); j++) {
            matrix[0][j] = gap * j;
            if (j > 0) {
                dir[0][j] = 1;
            }
        }
    }

    /**
     * The trackBack function is to track the way passed by to find the shortest distance
     */
    public void trackBack() {
        int i = list1.size();
        int j = list2.size();

        while (dir[i][j] != 0) {
            if (dir[i][j] == 1) {
                j = j - 1;
                dis++;
                System.out.println("edit distance : " + dis + "--> add '" + list2.get(j) + "' to str1");
            } else if (dir[i][j] == 2) {
                i = i - 1;
                dis++;
                System.out.println("edit distance : " + dis + "--> remove '" + list1.get(i) + "' from str1");
            } else if (dir[i][j] == 3) {
                if (diss[i][j] == 1) {
                    dis++;
                    System.out.println("edit distance : " + dis + "--> replace '" + list1.get(i - 1) + "' in str1 with a '" + list2.get(j - 1));
                }
                j--;
                i--;
            }
        }
    }

    /**
     * The needleAlgorithm is to calculate all the score in the matrix and record the way in diss and dir
     */
    public void needleAlgortithm() {
        int score;
        for (int i = 1; i <= list1.size(); i++) {
            for (int j = 1; j <= list2.size(); j++) {
                String char1 = list1.get(i - 1);
                String char2 = list2.get(j - 1);

                if (char1.equals(char2)) {
                    score = matrix[i - 1][j - 1] + match;
                } else {
                    score = matrix[i - 1][j - 1] + mis;
                    diss[i][j] = 1;
                }

                int scoreup = matrix[i][j - 1] + gap;
                int scoreleft = matrix[i - 1][j] + gap;

                if (scoreup >= scoreleft && scoreup >= score) {
                    matrix[i][j] = scoreup;
                    dir[i][j] = 1;
                } else if (scoreleft >= scoreup && scoreleft >= score) {
                    matrix[i][j] = scoreleft;
                    dir[i][j] = 2;
                } else if (score >= scoreup && score >= scoreleft) {
                    matrix[i][j] = score;
                    dir[i][j] = 3;
                }
            }
        }
    }

}
