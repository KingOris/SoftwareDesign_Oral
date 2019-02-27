package Inheritance;
import java.util.UUID;

/**
 * This class is inheritance from PostFormRequest
 */
public class PostEncryptedFormRequest extends PostFormRequest{
   /**
    * A string enc save the encrypted data for this class object
    */
    private String enc;
    /**
     * an integer count
     */
    private static int count;

    /**
     * A constructor which need four parameters and initialize the class member variable
     * @param UUID an UUID class type object
     * @param IP a string type IP
     * @param Form a Form class type object
     * @param enc a string type enc
     */
    public PostEncryptedFormRequest(UUID UUID, String IP, Form Form, String enc){
        super(UUID,IP,Form);
        this.enc = enc;
        count++;
    }

    /**
     * A getter for get the string enc
     * @return string enc
     */
    public String getEnc() {
        return enc;
    }

    /**
     * A override superclass toString function which include superclass toString and its own data
     * @return a string
     */
    @Override
    public String toString() {
       return super.toString() + "\nThis form was encrypted using : " + getEnc();
    }

    /**
     * Return int count
     * @return int count
     */
    public static int count(){
        return count;
    }
}
