import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.*;

/**
 * @author Yuhang Chen
 * @version 0.0.1 10/5/1018
 *
 * This class is for rotating the image
 */
public class Image_Rotaror {

    /**
     * A method to load the image and rotate it with user's input angle
     * @param name Name is the image name
     * @param angle Angel is the user's iput for angle rotate
     * @return A BufferedImage after rotated
     */
    public BufferedImage Rotate(String name, int angle) {
        BufferedImage startImage;
        //Try to read image, if can not read, it will stop the program
        try {
            //Read the image
            File location = new File(name);
            startImage = ImageIO.read(location);
            //Creat a rectangle of the image size when it rotates
            Rectangle newRect = calculateW_H(startImage.getWidth(),startImage.getHeight(),angle);
            //Create a BufferImage of the image with wideth height and type color(red,blue,green)
            BufferedImage fImage = new BufferedImage(newRect.width, newRect.height,BufferedImage.TYPE_INT_RGB);
            //Creat graphics2D
            Graphics2D g = fImage.createGraphics();
            //Translate the image to the middle of the reangel
            g.translate((fImage.getWidth()-startImage.getWidth())/2,(fImage.getHeight()-startImage.getHeight())/2);
            //To rotate the graphics
            g.rotate(Math.toRadians(angle),startImage.getWidth()/2,startImage.getHeight()/2);
            g.drawImage(startImage,null,null);

            return fImage;

        } catch (IOException e) {
            throw new IllegalArgumentException("Can not read image");

        }
    }

    /**
     * A method to calculate the size of the image after thier vonlunteer
     * @param width the width of bufferedimage
     * @param height the height of bufferedimage
     * @param angle the angle user' iput
     * @return a rectangle contains the new width and new hight after rotetor
     */
    public Rectangle calculateW_H(int width, int height, int angle){
        //If angle is greater than 90, make it to smaller than 90
        if(angle >= 90){
            int i = angle/90;
            //if angle is equal to  90 and 270, the rectangle just switch the width and height
            if(angle == 90 || angle ==270){
                int switchN = width;
                width = height;
                height = switchN;
                angle = 90;
            }else {
                angle = angle%90;
            }
        }

        //
        double w = width;
        double h = height;
        double d = Math.sqrt(width*width + height*height)/2;
        double l = 2*Math.sin(Math.toRadians(angle/2))*d;
        double angle_A = (Math.PI- Math.toRadians(angle))/2;
        double angle_B_W = Math.atan(h/w);
        double angle_B_H = Math.atan(w/h);

        double extraWidth = l *Math.cos(Math.PI - angle_A -  angle_B_W );
        double extraHeight = l *Math.cos(Math.PI - angle_A -  angle_B_H );

        int newWidth = (int) (width + 2 * extraWidth);
        int newHeight =(int) (height + 2 * extraHeight);

        return new Rectangle(new Dimension(newWidth, newHeight));

    }
}
