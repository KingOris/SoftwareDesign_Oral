import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * A Balls class which contain the information of the ball , the bouncingMovement function and the run function
 * Extends with Jpanel and implements Runnable
 */
public class Balls extends JPanel implements Runnable {
    /**
     * A private integer shows the x direction speed
     */
    private int xspeed;
    /**
     * A private integer shows the y direction speed
     */
    private int yspeed;
    /**
     * A private final integer shows the ball's radius
     */
    private final int radius;
    /**
     * A private integer shows the x position of the ball
     */
    private int x;
    /**
     * A private integer shows the y position of the ball
     */
    private int y;

    /**
     * The constuctor of the Balls class
     * It defined random speed of x and y direction and sets the radius.
     * It also sets the start position which is (0,0);
     */
    public Balls() {
        Random random = new Random();
        xspeed = random.nextInt(5);
        while(xspeed == 0){
            xspeed = random.nextInt(5);
        }
        yspeed = random.nextInt(5);
        while(yspeed == 0){
            yspeed = random.nextInt(5);
        }
        radius = 50;
        x = 0;
        y = 0;
    }

    /**
     * A function to paint the ball on the panel
     * use super function from JPanel
     */
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.BLUE);
        g.fillOval(this.x, this.y, 100, 100);
    }

    /**
     * A function to determine the bouncing movement and repaint every time
     */
    public void bouncingMovement() {
        if (x  < 0 && xspeed < 0) {
            xspeed = -xspeed;
        } else if (x + radius> this.getWidth()) {
            xspeed = -xspeed;
            x = this.getWidth() - radius;
        } else if (y + radius > this.getHeight()) {
            yspeed = -yspeed;
            y = this.getHeight() - radius;
        } else if (y  < 0 && yspeed < 0) {
            yspeed = -yspeed;
        }

        x += xspeed;
        y += yspeed;
        this.repaint();
    }

    /**
     * The run function of the Balls class
     */
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(5);
                bouncingMovement();
            } catch (InterruptedException exception) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
