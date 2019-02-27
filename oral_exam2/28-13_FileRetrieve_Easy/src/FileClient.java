import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * The FileClient class to create the the client side and connect to the server side
 */
public class FileClient extends JFrame {
    /**
     * A private JTextField to get user input
     */
    private JTextField enterField; // enters information from user
    /**
     * A private JTextArea to display the informaton
     */
    private JTextArea displayArea; // display information to user
    /**
     * A privat objectOutputStream to output the stream to server
     */
    private ObjectOutputStream output; // output stream to server
    /**
     * A privat objectInputStream to get the stream from server
     */
    private ObjectInputStream input; // input stream from server
    /**
     * A private String to store the message gotten from server
     */
    private String message = ""; // message from server
    /**
     * A private String to store the host
     */
    private String chatServer; // host server for this application
    /**
     * A private socket to communicate with server
     */
    private Socket client; // socket to communicate with server

    /**
     * The constructor to initialize chatServer and set up GUI
     *
     * @param host the local host
     */

    public FileClient(String host) {
        super("Client");

        chatServer = host; // set server to which this client connects

        enterField = new JTextField(); // create enterField
        enterField.setEditable(false);
        enterField.addActionListener(
                new ActionListener() {
                    // send message to server
                    public void actionPerformed(ActionEvent event) {
                        sendData(event.getActionCommand());
                        enterField.setText("");
                    }
                }
        );

        add(enterField, BorderLayout.NORTH);

        displayArea = new JTextArea(); // create displayArea
        add(new JScrollPane(displayArea), BorderLayout.CENTER);

        setSize(300, 150); // set size of window
        setVisible(true); // show window
    }

    /**
     * The runclient method to connect to server and process messages from server
     */

    public void runClient() {
        try // connect to server, get streams, process connection
        {
            connectToServer(); // create a Socket to make connection
            getStreams(); // get the input and output streams
            processConnection(); // process connection
        } catch (EOFException eofException) {
            displayMessage("\nClient terminated connection");
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } finally {
            closeConnection(); // close connection
        }
    }

    /**
     * The connecToServer method is to connect to server
     *
     * @throws IOException error
     */

    private void connectToServer() throws IOException {
        displayMessage("Attempting connection\n");

        // create Socket to make connection to server
        client = new Socket(InetAddress.getByName(chatServer), 12345);

        // display connection information
        displayMessage("Connected to: " +
                client.getInetAddress().getHostName());
    }

    /**
     * A getStreams method is to get streams to send and receive data
     *
     * @throws IOException error
     */

    private void getStreams() throws IOException {
        // set up output stream for objects
        output = new ObjectOutputStream(client.getOutputStream());
        output.flush(); // flush output buffer to send header information

        // set up input stream for objects
        input = new ObjectInputStream(client.getInputStream());

        displayMessage("\nGot I/O streams\n");
    }

    /**
     * A method to process connection with server
     *
     * @throws IOException error
     */

    private void processConnection() throws IOException {
        // enable enterField so client user can send messages
        setTextFieldEditable(true);

        do // process messages sent from server
        {
            try // read message and display it
            {
                message = (String) input.readObject(); // read new message
                displayMessage("\n" + message); // display message
            } catch (ClassNotFoundException classNotFoundException) {
                displayMessage("\nUnknown object type received");
            }

        } while (!message.equals("SERVER>>> TERMINATE"));
    }

    /**
     * A method to close streams and socket
     */
    private void closeConnection() {
        displayMessage("\nClosing connection");
        setTextFieldEditable(false); // disable enterField

        try {
            output.close(); // close output stream
            input.close(); // close input stream
            client.close(); // close socket
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    /**
     * A method to send message to server
     *
     * @param message the message that user input
     */
    private void sendData(String message) {
        try // send object to server
        {
            output.writeObject("" + message);
            output.flush(); // flush data to output
            displayMessage("" + message);
        } catch (IOException ioException) {
            displayArea.append("\nError writing object");
        }
    }

    /**
     * A method to manipulates displayArea in the event-dispatch thread
     * @param messageToDisplay message needed to display
     */

    private void displayMessage(final String messageToDisplay) {
        SwingUtilities.invokeLater(
                new Runnable() {
                    public void run() // updates displayArea
                    {
                        displayArea.append(messageToDisplay);
                    }
                }
        );
    }

    // manipulates enterField in the event-dispatch thread
    private void setTextFieldEditable(final boolean editable) {
        SwingUtilities.invokeLater(
                new Runnable() {
                    public void run() // sets enterField's editability
                    {
                        enterField.setEditable(editable);
                    }
                }
        );
    }
}