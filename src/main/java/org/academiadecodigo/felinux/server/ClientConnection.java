package org.academiadecodigo.felinux.server;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.felinux.controller.Controller;
import org.academiadecodigo.felinux.controller.LoginController;
import org.academiadecodigo.felinux.model.client.Client;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.Socket;

/**
 * This class represents the connection established between the server and the client
 */
public class ClientConnection implements Runnable {

    private final Socket socket;
    private final  Server server;
    private final Client client;
    private LoginController  controller;
    private PrintStream printStream;
    private InputStream inputStream;
    private Prompt prompt;


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
    }

    /**
     * This class implements Runnable, in order to create another Thread. This is the method that will
     * start the other thread.
     * This thread will be listening to the client and ready to send any message necessary.
     */
    @Override
    public void run() {

        createStreams();
        prompt = createPrompt();

        send("Hello. You matter!");

        controller.execute();


    }

    /*public void listen() {

        byte[] buffer = new byte[1024];
        StringBuilder message = new StringBuilder();

            try {
                while (((inputStream.read(buffer)) != -1)) {
                    message.append(buffer);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
*/

    /**
     * Sends a message to the client connected
     * @param message
     */
    public void send(String message) {
        printStream.println(message);
    }

    /**
     * Creates a new prompt
     * @return a new Prompt
     */
    private Prompt createPrompt() {
        return new Prompt(inputStream, printStream);
    }

    private void createStreams() {
        try {
            printStream = new PrintStream(socket.getOutputStream());
            inputStream = socket.getInputStream();
        } catch (IOException ioe) {
            System.err.println("Error: " + ioe.getMessage());
        }
    }

    /**
     * Returns ouput stream of this connection
     * @return PrintStream
     */
    public PrintStream getPrintStream() {
        return printStream;
    }

    /**
     * Return input stream of this connection
     * @return InputStream
     */
    public InputStream getInputStream() {
        return inputStream;
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
    public void setController(LoginController controller) {
        this.controller = controller;
    }

    /**
     * Gets the prompt of this object
     * @return a Prompt
     */
    public Prompt getPrompt() {
        return prompt;
    }
}
