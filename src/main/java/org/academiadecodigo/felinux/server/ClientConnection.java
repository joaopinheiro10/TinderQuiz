package org.academiadecodigo.felinux.server;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.felinux.Bootstrap;
import org.academiadecodigo.felinux.controller.Controller;
import org.academiadecodigo.felinux.controller.GameController;
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
    private GameController gameController;
    private PrintStream printStream;
    private InputStream inputStream;
    private int id;


    /**
     * Initializes the properties of the newly created ClientConnection so it represents the connection
     * between server and client
     * @param socket represents the socket created by the ServerSocket.accept();
     */
    public ClientConnection(Socket socket, int id) {
        this.socket = socket;
        this.id = id;
    }

    /**
     * This class implements Runnable, in order to create another Thread. This is the method that will
     * start the other thread.
     * This thread will be listening to the client and ready to send any message necessary.
     */
    @Override
    public void run() {

        createStreams();

        Bootstrap bootstrap = new Bootstrap(id, inputStream, printStream, gameController);

        System.out.println(id);
        System.out.println(bootstrap);


        /*
        prompt = createPrompt();

        send("Hello. You matter!");

        controller.execute();
*/

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
     * Sets the property controller of this object
     * @param gameController
     */
    public void setGameController(GameController gameController) {
        this.gameController = gameController;
    }

}
