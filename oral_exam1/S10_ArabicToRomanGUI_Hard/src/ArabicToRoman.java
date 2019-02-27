/**
 *This class is to change arabic number to Roman number
 * @version 0.0.1
 */
public class ArabicToRoman {
    /**
     *A private string which save the arabic number
     */
    private String rNum;

    /**
     * Change the arabic number to roman number and return the result
     * @param a  User input integer
     * @return A string which is roman number
     */

    public  String a2r(int a) {

        String rNum = "";
        int i = 0;
        int n ;
        //Transfer number on each digit to roman number
        while(a>0){
            n = a%10;
            a = a/10;
            //Call the a2r method and add into rNum
            rNum = a2r(n,i).concat(rNum);
            i++;
        }
        return this.rNum = rNum;
    }

    /**
     *The method will convert arabic number to roman number with 2 parameters
     * @param n n is the number on the last digit
     * @param i i is which digit n was located
     * @return a string for n in roman number
     */
    public  String a2r(int n, int i){

        String one;
        String five;
        String ten;

        if(i == 0){
            one = "I";
            five = "V";
            ten = "X";
        }else if(i == 1){
            one = "X";
            five = "L";
            ten = "C";
        }else if(i == 2){
            one = "C";
            five = "D";
            ten = "M";
        }else {
            one = "M";
            five = "";
            ten = "";
        }

        String rString="";
        switch (n){
            case 0 :
                break;
            case 1:
                rString = one;
                break;
            case 2:
                rString = one + one;
                break;
            case 3:
                rString = one + one + one;
                break;
            case 4:
                rString = one + five;
                break;
            case 5:
                rString = five;
                break;
            case 6:
                rString = five + one;
                break;
            case 7:
                rString = five + one + one;
                break;
            case 8:
                rString = five + one + one + one;
                break;
            case 9:
                rString = one + ten;
                break;
        }

        return rString;

    }
}
