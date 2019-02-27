import javax.swing.*;

/**
 * @author Yuhang Chen
 * @version 1.0.0
 * The main ServerTest class to create the server side and run server
 */
public class ServerTest {
    public static void main(String[] args) {
        FileServer application = new FileServer(); // create server
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.runServer(); // run server application
    }
}