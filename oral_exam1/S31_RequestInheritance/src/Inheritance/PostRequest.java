package Inheritance;

import java.util.UUID;

/**
 * The class is inheritance from Request
 */
public class PostRequest extends Request {
    /**
     * Private string ip
     */
    private String ip;
    /**
     * Private static int count
     */
    private int count;

    /**
     * The constructor of the class need two parameter
     * @param UUID is from UUID class
     * @param IP is a string
     */
    public PostRequest(UUID UUID, String IP){
        super(UUID);
        ip = IP;
        count++;
    }

    public String getIp() {
        return ip;
    }

    /**
     * Override super class toString function
     * @return string
     */
    @Override
    public String toString() {
       return super.toString() + "\nPost request to server with IP address: " + getIp();
    }
    /**
     * Return integer count
     * @return int count
     */
    public  int count(){
        return count;
    }
}
