package Inheritance;
import java.util.UUID;

/**
 *  This class is heritance from PostPaymentRequest
 *
 */
public class PostEncryptedPaymentRequest extends PostPaymentRequest {
    /**
     * A private string member encr
     */
    private String encr;
    /**
     * A private integer count
     */
    private static int count;

    /**
     * The constructor of the class which needs 4 parameters
     * @param UUID a UUID class object called UUID
     * @param IP a string called IP
     * @param payment a Payment class object called payment
     * @param encr a string called encr
     */
    public PostEncryptedPaymentRequest(UUID UUID, String IP, Payment payment, String encr){
        super(UUID, IP, payment);
        this.encr = encr;
        count++;
    }

    /**
     *An override toString function from super class and called super class toString method
     * @return a string
     */
    @Override
    public String toString() {
       return super.toString() + "\nThis payment was encrypted using: " + encr;
    }

    /**
     * Return integer count
     * @return int count
     */
    public static int count(){
        return count;
    }
}
