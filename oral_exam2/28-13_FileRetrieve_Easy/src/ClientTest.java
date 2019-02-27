import javax.swing.*;

/**
 * The main class ClientTest to run the client side
 */
public class ClientTest {
    public static void main(String[] args) {
        FileClient application; // declare client application

        // if no command line args
        if (args.length == 0) {
            application = new FileClient("127.0.0.1");
        }// connect to localhost
        else {
            application = new FileClient(args[0]); // use args to connect
        }
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.runClient(); // run client application
    }
}
