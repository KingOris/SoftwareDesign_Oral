import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * A GUI to set up. It has two JTextFeild and one Jpanel
 * @see javax.swing.JFrame
 * @version 0.0.1
 */

public class ArabicToRomanGUI extends JFrame {
    /**
     *A private string to save roman number
     */
    private String romanNumber = "";
    /**
     * A private integer which contains arabic number
     */
    private  int numI;
    /**
     * A JTextField to let user input either roman number or arabic number
     */
    private JTextField roman;
    /**
     * A JTextField to let user input either roman number or arabic number
     */
    private JTextField arabic;
    /**
     * A JPanel
     */
    private JPanel window;

    /**
     *A GUI was created with GridLayout which has two rows and three column and 2 textfield.
     */
    public  ArabicToRomanGUI(){
        super("Arabic<->Roman");
        numI = 0;
        //Set the window
        window = new JPanel(new GridLayout(2,3));
        //Set 2 textfield
        roman = new JTextField( 20);
        arabic = new JTextField(20);
        //Create 2 object for each ArabicToRoman and RomanToArabic
        ArabicToRoman rNum = new ArabicToRoman();
        RomanToArabic aNum = new RomanToArabic();
        //Addkeylistener and detect the user input
        roman.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                if(e.getKeyCode() >= 48 && e.getKeyCode() <=57) {
                    if (e.getKeyCode() != 8) {
                        numI = numI * 10 + inputN(e);
                    }
                    if (numI > 3999 || numI < 1) {
                        arabic.setText("Please enter a valid number");
                    } else {
                        arabic.setText(rNum.a2r(numI));
                    }
                }else if(e.getKeyCode() == 8){
                    if(romanNumber.length() != 0){
                        delet();
                        arabic.setText("" +aNum.r2a(romanNumber));
                    }

                    if(numI != 0){
                        numI = numI/10;
                        arabic.setText(rNum.a2r(numI));
                    }
                }else{

                    romanNumber = romanNumber + input(e);

                    int a = aNum.r2a(romanNumber);
                    String checkString = rNum.a2r(a);
                    if(checkString.equals(romanNumber) && a < 3999 && a > 1){
                        arabic.setText("" +a);
                    }else{
                        arabic.setText("Please enter again ");
                    }
                }

            }
        });

        arabic.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                if(e.getKeyCode() >= 48 && e.getKeyCode() <=57) {
                    if (e.getKeyCode() != 8) {
                        numI = numI * 10 + inputN(e);
                    }
                    if (numI > 3999 || numI < 1) {
                        roman.setText("Please enter a valid number");
                    } else {
                        roman.setText(rNum.a2r(numI));
                    }
                }else if(e.getKeyCode() == 8){
                    if(romanNumber.length() != 0){
                        delet();
                        roman.setText("" +aNum.r2a(romanNumber));
                    }

                    if(numI != 0){
                        numI = numI/10;
                        roman.setText(rNum.a2r(numI));
                    }

                }else{
                    romanNumber = romanNumber + input(e);

                    int a = aNum.r2a(romanNumber);
                    String checkString = rNum.a2r(a);
                    if(checkString.equals(romanNumber)&& a < 3999 && a > 1){
                        roman.setText("" +a);
                    }else{
                        roman.setText("Please enter again ");
                    }
                }
            }
        });

        window.add(roman);

        window.add(arabic);

        this.add(window);
        this.setSize(1800,400);
        this.setLayout(new FlowLayout());
        this.setVisible(true);
    }

    /**
     * input  method will get users pressed key when they released and return the string of roman number
     * @param e which is the keyevent get from key listener
     * @return String of roman number
     */
    public String input(KeyEvent e){
        String rom = "";
        int n = e.getKeyCode();
        switch (n){
            case 73:
                rom ="I";
                break;
            case 'X':
                rom ="X";
                break;
            case 'V':
                rom ="V";
                break;
            case 'L':
                rom ="L";
                break;
            case 'C':
                rom ="C";
                break;
            case 'D':
                rom ="D";
                break;
            case 'M':
                rom ="M";
                break;
            case 8 :
                delet();
                break;
        }
        return rom;
    }

    /**
     * inputN method get keyevent through keylistener and convert the string to integer arabic number then return the
     * arabic number
     * @param e which is the keyevent get from key listener
     * @return an integer
     */
    public int inputN(KeyEvent e){
        int num = 0;
        switch (e.getKeyCode()){
            case 48:
                num =  0;
                break;
            case 49:
                num = 1;
                break;
            case 50:
                num = 2;
                break;
            case 51:
                num = 3;
                break;
            case 52:
                num = 4;
                break;
            case 53:
                num = 5;
                break;
            case 54:
                num = 6;
                break;
            case 55:
                num = 7;
                break;
            case 56:
                num = 8;
                break;
            case 57:
                num = 9;
                break;
        }
        return num;
    }

    /**
     * Delet method will check if the string is empty. If not, it will let the romanNumber become one shoter.
     */
    public void delet(){
        if (romanNumber.length() != 0) {
            romanNumber = romanNumber.substring(0, romanNumber.length() - 1);
        }
    }
}
