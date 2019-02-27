import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *This class recive user's input value for item price and the mount of paid. Also, it will generate the mount of each
 * currency.
 */

public class CashExchanger {
    /**
     *An arraylist which save the number of each currency
     */
    private ArrayList<Integer> currenciesQuantity =  new ArrayList<Integer>();
    /**
     *An arraylist to save the currency and its position
     */
    private ArrayList<Currency> currenciesType = new ArrayList<Currency>();

    /**
     *A bigdecimal which is the mount of user paid
     */
    private BigDecimal paid;

    /**
     * This is the constructor for CashExchanger.
     */
    public CashExchanger() {
        Scanner scan = new Scanner(System.in);

        paid = new BigDecimal("0.0");
        //Add Currency into currenciesType
        currenciesType.add(new Currency("20", "20 Dollor"));
        currenciesType.add(new Currency("10", "10 Dollor"));
        currenciesType.add(new Currency("5", "5 Dollor"));
        currenciesType.add(new Currency("1", "1 Dollor"));
        currenciesType.add(new Currency("0.25", "Quarters"));
        currenciesType.add(new Currency("0.1", "Dimes"));
        currenciesType.add(new Currency("0.05", "Nickels"));
        currenciesType.add(new Currency("0.01", "Pennis"));

        Random random = new Random();
        //Set random number for each change units and add to currenciesQuantity. Also ask what and how many money is given
        for (int i = 0; i < currenciesType.size(); i ++){
            currenciesQuantity.add(random.nextInt(16));
            System.out.println("Please enter the number of " + currenciesType.get(i).getMoney() + "you will pay");
            BigDecimal num = scan.nextBigDecimal();
            paid = paid.add(currenciesType.get(i).getUnit().multiply(num));
            currenciesQuantity.set(i,currenciesQuantity.get(i) + num.intValue());
        }
    }

    /**
     *To calculate hao many changes should be given.
     * How much should give to users will be calculate here.
     * @param moneyQuantity Bigdecimal of the price of items
     */
    public void getExchange(BigDecimal moneyQuantity){
        BigDecimal change = paid.subtract(moneyQuantity);
        int[] needChangeNumber = new int[currenciesQuantity.size()];
        for (int i = 0; i < currenciesQuantity.size(); i ++){
            if(change.divideToIntegralValue(currenciesType.get(i).getUnit()).intValue() > currenciesQuantity.get(i)){
                needChangeNumber[i] = currenciesQuantity.get(i);
                change = remainprice(change,currenciesQuantity.get(i),currenciesType.get(i).getUnit());
            }else {
                needChangeNumber[i] = change.divideToIntegralValue(currenciesType.get(i).getUnit()).intValue();
                change = remainprice(change,needChangeNumber[i],currenciesType.get(i).getUnit());
            }

        }

        if(change.compareTo(BigDecimal.ZERO)==0){
            System.out.println("20 dollor: " + needChangeNumber[0] + "; 10 dollors : "+ needChangeNumber[1] + "; 5 dollor :" + needChangeNumber[2] + "; 1 dollor : " + needChangeNumber[3]);
            System.out.println("Quarters: " + needChangeNumber[4] + "; Dimes : "+ needChangeNumber[5] + "; nickels : " + needChangeNumber[6] + "; Pennies : " + needChangeNumber[7]);
        }else{
            System.out.println("Do not have enough changes !");
        }

    }

    /**
     *To calculate how many changes left need to be given
     *Return a bigdecimal
     * @param a How many chages left
     * @param b how many changes given
     * @param c the value of the changes given
     * @return changes left
     */
    public static BigDecimal remainprice(BigDecimal a, int b, BigDecimal c){
        for(int i = 0; i<b; i++){
            a=a.subtract(c);
        }
        return a;
    }




}
