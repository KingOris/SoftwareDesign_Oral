package Inheritance;

/**
 * This class is save information of File
 */
public class File {
    /**
     * Private string member variable path
     */
    private String path;
    /**
     * Private string member variable type
     */
    private String type;

    /**
     * The constructor for initialize the private members
     * @param path the path
     * @param type the type
     */
    public File(String path, String type){
        this.path = path;
        this.type = type;
    }

    /**
     * A getter method for path
     * @return string path
     */
    public String getPath() {
        return path;
    }

    /**
     * a getter method for type
     * @return string type
     */
    public String getType() {
        return type;
    }

    /**
     * toString return a string contain all the information in this class object
     * @return string
     */
    public String toString(){
        return "\nFile Path: " + getPath() + "\nFile Type: " + getType();
    }
}
