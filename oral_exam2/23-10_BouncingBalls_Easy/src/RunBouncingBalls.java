import javax.swing.*;

/**
 * @author Yuhang Chen
 * @version 1.0.0
 */

public class RunBouncingBalls {
    public static void main(String[] args) {
        //Create the BouncingBallGUI which also create a ball
        BouncingBallGUI gui = new BouncingBallGUI();
        //Set up the GUI
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setSize(200, 200);
        gui.setVisible(true);
    }
}
