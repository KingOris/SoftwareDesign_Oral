import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Tht FileServer class creat the server side and the gui to check the file and the content in the file
 */
public class FileServer extends JFrame {
    private JTextArea displayArea; // display information to user
    private ObjectOutputStream output; // output stream to client
    private ObjectInputStream input; // input stream from client
    private ServerSocket server; // server socket
    private Socket connection; // connection to client
    private int counter = 1; // counter of number of connections

    /**
     * The constructor of FileServer to set up GUI
     */

    public FileServer() {
        super("Server");

        displayArea = new JTextArea(); // create displayArea
        add(new JScrollPane(displayArea), BorderLayout.CENTER);

        setSize(300, 150); // set size of window
        setVisible(true); // show window
    }

    /**
     * The runServer method is to set up and run server
     */

    public void runServer() {
        try // set up server to receive connections; process connections
        {
            server = new ServerSocket(12345, 100); // create ServerSocket

            while (true) {
                try {
                    waitForConnection(); // wait for a connection
                    getStreams(); // get input & output streams
                    processConnection(); // process connection
                } catch (EOFException eofException) {
                    displayMessage("\nServer terminated connection");
                } finally {
                    closeConnection(); //  close connection
                    ++counter;
                }
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    /**
     * The waitForConnection is used to wait for connection to arrive, then display connection info
     *
     * @throws IOException error
     */

    private void waitForConnection() throws IOException {
        displayMessage("Waiting for connection\n");
        connection = server.accept(); // allow server to accept connection
        displayMessage("Connection " + counter + " received from: " +
                connection.getInetAddress().getHostName());
    }

    /**
     * The getStreams method is to  get I/O streams to send and receive data
     *
     * @throws IOException error
     */

    private void getStreams() throws IOException {
        // set up output stream for objects
        output = new ObjectOutputStream(connection.getOutputStream());
        output.flush(); // flush output buffer to send header information

        // set up input stream for objects
        input = new ObjectInputStream(connection.getInputStream());

        displayMessage("\nGot I/O streams\n");
    }

    /**
     * The processConnection method is to process connection with client
     *
     * @throws IOException error
     */

    private void processConnection() throws IOException {
        String message = "Connection successful";
        sendData(message); // send connection successful message

        do // process messages sent from client
        {
            try // read message and display it
            {
                message = (String) input.readObject(); // read new message
                File file = new File(message);
                try {
                    BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                    String readFile = "";
                    while ((readFile = bufferedReader.readLine()) != null) {
                        sendData(readFile);
                    }
                } catch (IOException e) {
                    sendData("File doesn't open successfully");
                }
            } catch (ClassNotFoundException classNotFoundException) {
                displayMessage("\nUnknown object type received");
            }

        } while (!message.equals("CLIENT>>> TERMINATE"));
    }

    /**
     * The closeConnection method is to close streams and socket
     */

    private void closeConnection() {
        displayMessage("\nTerminating connection\n");

        try {
            output.close(); // close output stream
            input.close(); // close input stream
            connection.close(); // close socket
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    /**
     * The sendData method is to send message to client
     *
     * @param message the user input
     */
    private void sendData(String message) {
        try // send object to client
        {
            output.writeObject("SERVER>>> " + message);
            output.flush(); // flush output to client
            displayMessage("\nSERVER>>> " + message);
        } catch (IOException ioException) {
            displayArea.append("\nError writing object");
        }
    }

    /**
     * The displayMessage method is to manipulates displayArea in the event-dispatch thread
     *
     * @param messageToDisplay the message needed to display
     */
    private void displayMessage(final String messageToDisplay) {
        SwingUtilities.invokeLater(
                new Runnable() {
                    public void run() // updates displayArea
                    {
                        displayArea.append(messageToDisplay); // append message
                    }
                }
        );
    }
}
