package Inheritance;

/**
 * This class include video information
 */
public class Video {
    /**
     * Private string URL
     */
    private String URL;
    /**
     * Private string title
     */
    private String title;
    /**
     * string name
     */
    private String name;

    /**
     * The constructor of the class need 3 parameters
     * @param URL is a String
     * @param title is a String
     * @param name is a nmae
     */
    public Video(String URL, String title, String name){
        this.URL = URL;
        this.title = title;
        this.name = name;
    }

    /**
     * Getter method for name
     * @return string name
     */
    public String getName() {
        return name;
    }

    /**
     * Getter method for URL
     * @return string URL
     */

    public String getURL() {
        return URL;
    }

    /**
     * Getter method for title
     * @return string title
     */
    public String getTitle() {
        return title;
    }
    /**
     * Override super class toString function
     * @return string
     */
    @Override
    public String toString() {

        return getURL() + "\nVideo: " + getTitle() + "\nBy: " + getName();
    }
}

