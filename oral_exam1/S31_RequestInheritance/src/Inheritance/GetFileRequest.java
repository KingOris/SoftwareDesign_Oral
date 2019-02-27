package Inheritance;
import java.util.UUID;

/**
 * GetFileRequest class is a inheritance class of Get request class
 */
public class GetFileRequest extends GetRequest {
    /**
     * Private File class variable
     */
    private File file;
    /**
     * Pri
     */
    private static int count;

    public GetFileRequest(UUID UUID, File file){
        super(UUID,"");
        this.file = file;
        count++;
    }

    public File getFile() {
        return file;
    }

    @Override
    public String toString() {
        return super.toString() + " file://" +file.getPath()+"."+file.getType() + file.toString();
    }
    public static int count(){
        return count;
    }
}
