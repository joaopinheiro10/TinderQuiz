package org.academiadecodigo.felinux.server;

import org.academiadecodigo.felinux.Bootstrap;
import org.academiadecodigo.felinux.controller.GameController;

import java.net.Socket;

/**
 * This class represents the connection established between the server and the client
 */
public class ClientConnection implements Runnable {

    private final Socket socket;
    private GameController gameController;
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


        new Bootstrap(id, socket, gameController);

    }


    /**
     * Sets the property controller of this object
     * @param gameController
     */
    public void setGameController(GameController gameController) {
        this.gameController = gameController;
    }

}
