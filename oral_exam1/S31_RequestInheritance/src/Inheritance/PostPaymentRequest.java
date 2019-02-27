package Inheritance;
import java.util.UUID;

/**
 * This class is inheritance from PostRequest
 */
public class PostPaymentRequest extends PostRequest {
    /**
     * A private member variable from Payment class called payment
     */
    private Payment payment;
    /**
     * A static private integer
     */
    private static int count;

    /**
     * A constructor of the class which needs 3 parameters
     * @param UUID  is  UUID class object
     * @param IP    is a string
     * @param payment is Payment class object
     */
    public PostPaymentRequest(UUID UUID, String IP, Payment payment){
        super(UUID,IP);
        this.payment = payment;
        count++;
    }

    /**
     * Override super class toString function
     * @return string
     */
    @Override
    public String toString() {
        return super.toString() + payment.toString();
    }

    /**
     * Return integer count
     * @return int count
     */
    public static int count(){
        return count;
    }
}
