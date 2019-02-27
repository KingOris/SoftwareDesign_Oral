package Inheritance;

import java.util.HashMap;
import java.util.Set;

/**
 * This class  Form contain form information
 */
public class Form {
    /**
     * A private class member variable HasMap called fiels
     */
    private HashMap fiels;

    /**
     * The constructor for class Form. It initializes the fiels to fiels
     * @param fiels is a HashMap object
     */
    public Form(HashMap fiels) {
        this.fiels = fiels;
    }

    /**
     * Return the data store in the form objects and return them in a string
     * @return string
     */
    public String toString(){
        return "\nLabel: Favorite color"+ "\nValue: " + fiels.get("Favorite color") + "\nLabel: Favorite encryption scheme"+ "\nValue: " + fiels.get("Favorite encryption scheme") + "\nLabel: Name"+ "\nValue: " + fiels.get("Name");
    }
}
