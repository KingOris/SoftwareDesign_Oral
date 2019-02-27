import java.math.BigDecimal;
import java.util.Scanner;

/**
 * @author Yuhang Chen
 * @version 0.0.1
 */
public class ChangeComputionRun {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Please enter the price");
        //Get user input save as BigDecimal
        BigDecimal moneyQunlity = input.nextBigDecimal();
        //Creat an object of cashExchanger
        CashExchanger cashExchanger = new CashExchanger();
        //Call the getExchange method
        cashExchanger.getExchange(moneyQunlity);


    }
}
