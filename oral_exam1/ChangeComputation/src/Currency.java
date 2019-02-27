import java.math.BigDecimal;

/**
 * This is the currency class. It contains a bigdecimal for its value and a string for its name
 */
public class Currency {
    /**
     * A final bigdecimal which don't change after created save the value.
     */
    final private BigDecimal unit;
    /**
     * A final string which don't change after created save the name of money
     */
    final private String money;

    /**
     * A constructor to set unit and money
     * @param unit BIgdecimal for saving the value of a currrency
     * @param money Strint for saving the type of a currency
     */
    public Currency(String unit, String money) {
        this.unit = new BigDecimal(unit);
        this.money = money;
    }

    /**
     * A getter method for private member unit
     * @return BigDecimal unit
     */
    public BigDecimal getUnit() {
        return unit;
    }

    /**
     * A getter method for private member money
     * @return String money
     */
    public String getMoney() {
        return money;
    }
}
