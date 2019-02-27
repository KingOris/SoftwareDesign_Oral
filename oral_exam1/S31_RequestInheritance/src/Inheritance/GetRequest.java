package Inheritance;
import java.util.UUID;

/**
 * This class is inheritance from class Request
 */
public class GetRequest extends Request{
    /**
     * Private variable String url
     */
    private String url;

    /**
     * Private int variable count
     */
    private static int count = 0;

    /**
     * The constructor of GetRequest call super constructor from class Request
     * @param UUID UUID used in super
     * @param URL a string contain URL
     */
    public GetRequest(UUID UUID, String URL){
        super(UUID);
        url = URL;
        count++;
    }

    /**
     * Return string url
     * @return String url
     */
    public String getUrl() {
        return url;
    }

    /**
     * Override the toString method include super class toString
     * @return a string
     */
    @Override
    public String toString(){
       return super.toString() + "\nUniversal Resource Locator (URL) : " + getUrl();
    }

    /**
     * Return integer count
     * @return int count
     */
    public static int count(){
        return count;
    }
}
