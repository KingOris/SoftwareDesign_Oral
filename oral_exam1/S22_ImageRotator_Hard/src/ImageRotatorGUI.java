import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * @author Yuhang Chen
 * @version 0.0.1 10/5/2018
 * This class is for creating a GUI for ImageROtator
 */
public class ImageRotatorGUI extends JFrame {
    /**
     *A JButton start used to start the image rotate processing
     */
    private JButton start;
    /**
     * An integer to keep how long the delay is
     */
    private int delay;
    /**
     * An integer to save user inpt angle
     */
    private int num;
    /**
     *An integer flag to save how many times the delay happened
     */
    private int flag;
    /**
     *A JTextField to get input angel
     */
    private final JTextField angle;
    /**
     *A JTextField to get input delay
     */
    private final JTextField daly;
    /**
     * A JPanel i
     */
    private final JPanel i;

    /**
     * The constructor for ImageRotatorGUI. Created a GUI with name, FlowLayout, two textfield and one start button.
     */

    public ImageRotatorGUI() {
        //Give the GUI name
        super("Image Rotator");
        //Set it to FlowLayout
        setLayout(new FlowLayout());
        i = new JPanel();
        //Set the start button
        start= new JButton("Start");
        Dimension dimension = new Dimension(1000, 400);

        Image_Rotaror image_rotaror = new Image_Rotaror();
        JLabel image = new JLabel();

        //Set 2 textfield
        angle = new JTextField(20);
        daly = new JTextField(20);

        //Get user input in angle textfield
        keyHandle handle = new keyHandle();
        angle.addKeyListener(handle);


        //Get user input in daly textfield
        keyHandle handle2 = new keyHandle();
        daly.addKeyListener(handle2);

        flag = 0;
        //Add timer
        Timer timer = new Timer(delay, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                image.setIcon(new ImageIcon(image_rotaror.Rotate("0.png", num)));
                flag += 1;
                num += num / flag;
            }
        });
        //Add ActionListener to start
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timer.setDelay(delay);
                timer.start();
            }
        });

        add(i);
        this.setSize(dimension);
        this.setVisible(true);
        this.add(start);
        this.add(angle);
        this.add(image);
        this.add(daly);
    }

    /**
     * An inner class for getting userinput
     */
    private class keyHandle implements KeyListener {


        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {

        }

        @Override
        public void keyReleased(KeyEvent e) {
            if(e.getSource() == daly){

             switch (e.getKeyCode()) {
                case 8:
                    delay = delay/ 10;
                    break;
                case 48:
                    delay = delay * 10 + 0;
                    break;
                case 49:
                    delay = delay * 10 + 1;
                    break;
                case 50:
                    delay = delay * 10 + 2;
                    break;
                case 51:
                    delay = delay * 10 + 3;
                    break;
                case 52:
                    delay = delay * 10 + 4;
                    break;
                case 53:
                    delay = delay * 10 + 5;
                    break;
                case 54:
                    delay = delay * 10 + 6;
                    break;
                case 55:
                    delay = delay * 10 + 7;
                    break;
                case 56:
                    delay = delay * 10 + 8;
                    break;
                case 57:
                    delay = delay * 10 + 9;
                    break;
                }

             }else if(e.getSource() == angle){
                switch (e.getKeyCode()) {
                    case 8:
                        num = num/ 10;
                        break;
                    case 48:
                        num = num * 10 + 0;
                        break;
                    case 49:
                        num = num * 10 + 1;
                        break;
                    case 50:
                        num = num * 10 + 2;
                        break;
                    case 51:
                        num = num * 10 + 3;
                        break;
                    case 52:
                        num = num * 10 + 4;
                        break;
                    case 53:
                        num = num * 10 + 5;
                        break;
                    case 54:
                        num = num * 10 + 6;
                        break;
                    case 55:
                        num = num * 10 + 7;
                        break;
                    case 56:
                        num = num * 10 + 8;
                        break;
                    case 57:
                        num = num * 10 + 9;
                        break;
                }
            }
        }
    }
}

