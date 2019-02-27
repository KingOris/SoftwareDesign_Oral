package Inheritance;
import java.util.UUID;

/**
 * This class is inheritance from class GetRequest
 */
public class GetVideoRequest extends GetRequest {
    /**
     * Private video object video
     */
    private Video video;
    /**
     * Private variable int count
     */
    private static int count;

    /**
     * The constructor for GetVideoRequest which need two parameters and contain a super constructor from GetRequest
     * @param UUID UUID for super constructor
     * @param video a video class object
     */
    public GetVideoRequest(UUID UUID, Video video){
        super(UUID,"");
        this.video = video;
        count++;
    }

    /**
     * Override the toString method include super class toString
     * @return a string
     */
    @Override
    public String toString() {
      return super.toString()+ video.toString();
    }

    /**
     * return integer count
     * @return int count
     */
    public static int count(){
        return count;
    }
}
