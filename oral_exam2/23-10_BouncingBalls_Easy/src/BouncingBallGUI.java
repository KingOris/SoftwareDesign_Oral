import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * A BouncingBall GUI extends with JFrame and implements MonseListener
 */
public class BouncingBallGUI extends JFrame implements MouseListener {
    /**
     * A privater boolean to check if the ball has already started
     */
    private boolean start;
    /**
     * A private object Ball
     */
    private Balls balls;

    /**
     * The constructor of BouncingBallGui
     */
    public BouncingBallGUI() {
        super("Bouncing Ball");
        balls = new Balls();
        start = false;

        addMouseListener(this);
        add(balls);
    }


    @Override
    public void mouseClicked(MouseEvent e) {

    }
    /**
     * The mouselistener to detect the mousePressed and start the run function in ball
     *
     * @param e mouse pressed movement
     */
    @Override
    public void mousePressed(MouseEvent e) {
        if (!start) {
            ExecutorService executorService = Executors.newCachedThreadPool();
            executorService.execute(balls);
            start = true;
        }
    }


    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
