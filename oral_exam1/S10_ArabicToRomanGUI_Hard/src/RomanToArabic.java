/**
 * @author Yuhang CHen
 * @version 0.0.1 10/5/2018
 * This class transfer roman number to arabic number,
 */
public class RomanToArabic {
    /**
     * Privat integer variable to keep arabic number the method got
     */
    private int aNum;

    /**
     * The method r2a which need a string parameters and tranfer the roman number to arabic number
     * @param r the string for user input roman number
     * @return the integer for result of arabic number
     */
    public int r2a(String r) {
        int n = 0;
        int[] a = new int[r.length()];
        char[] b = r.toCharArray();
        //Transfer each character in b to its value in arabic number and add into a
        for (int i = 0; i < b.length; i++) {
            switch (b[i]) {
                //73
                case 'I':
                    a[i] = 1;
                    break;
                //86
                case 'V':
                    a[i] = 5;
                    break;
                //88
                case 'X':
                    a[i] = 10;
                    break;
                //76
                case 'L':
                    a[i] = 50;
                    break;
                //67
                case 'C':
                    a[i] = 100;
                    break;
                //68
                case 'D':
                    a[i] = 500;
                    break;
                //77
                case 'M':
                    a[i] = 1000;
                    break;
            }
        }
        //Calculate the arabic number
        for (int m = 0; m < a.length; m++) {
            //if it is the last number in the array a, just add it to the n
            if (m == a.length - 1) {
                n += a[m];
            } else {
                //if the number a[m] is on the left of a larger number, n - a[m]
                if (a[m] < a[m + 1]) {
                    n -= a[m];
                } else {
                    //if the number a[m] is on the right of a larger number, n + a[m]
                    n += a[m];
                }
            }
        }
            return aNum = n;

    }
}
