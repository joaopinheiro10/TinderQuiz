package org.academiadecodigo.felinux.server;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.felinux.controller.Controller;
import org.academiadecodigo.felinux.model.client.Client;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * This class represents the connection established between the server and the client
 */
public class ClientConnection implements Runnable {

    private Socket socket;
    private Server server;
    private Client client;
    private Controller controller;
    private Prompt prompt;
    private PrintStream printStream;


    /**
     * Initializes the properties of the newly created ClientConnection so it represents the connection
     * between server and client
     * @param server represents the server which established the connection
     * @param socket represents the socket created by the ServerSocket.accept();
     */
    public ClientConnection(Server server, Socket socket) {
        this.server = server;
        this.socket = socket;
        client = new Client();
        prompt  = createPrompt();
    }

    /**
     * This class implements Runnable, in order to create another Thread. This is the method that will
     * start the other thread.
     * This thread will be listening to the client and ready to send any message necessary.
     */
    @Override
    public void run() {

        send("Hello. You matter!");

    }


    public void send(String message) {
        printStream.println(message);
    }

    /**
     * Creates a new prompt
     * @return a new Prompt
     */
    private Prompt createPrompt() {
        try {
            printStream = new PrintStream(socket.getOutputStream());
            return new Prompt(socket.getInputStream(), printStream);
        } catch (IOException ioe) {
            System.err.println("Error: " + ioe.getMessage());
        }
        return null;
    }

    /**
     * Method to get the client of this clientConnection
     * @return Client
     */
    public Client getClient() {
        return client;
    }

    /**
     * Method to get the controller of this clientConnection
     * @return Controller
     */
    public Controller getController() {
        return controller;
    }

    /**
     * Sets the property controller of this object
     * @param controller
     */
    public void setController(Controller controller) {
        this.controller = controller;
    }

}
