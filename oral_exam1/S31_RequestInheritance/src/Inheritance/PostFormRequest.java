package Inheritance;
import java.util.UUID;

/**
 * This class is inheritance from PostRequest
 */
public class PostFormRequest extends PostRequest {
    /**
     * Private Form class object
     */
    private Form form;
    /**
     * Private int count
     */
    private static int count;

    /**
     *A  constructor of class to initialize class member and call super class constructor
     * @param UUID is from class UUID
     * @param IP is a string
     * @param Form is from class Form
     */


    public PostFormRequest(UUID UUID, String IP, Form Form){
        super(UUID, IP);
        form = Form;
        count++;
    }

    /**
     * Override super class toString function
     * @return string
     */
    @Override
    public String toString() {
       return super.toString() + form.toString();
    }

    /**
     *
     * @return int count
     */
    public static int count(){
        return count;
    }
}
