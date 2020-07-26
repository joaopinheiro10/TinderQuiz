package org.academiadecodigo.felinux.server;


import org.academiadecodigo.felinux.controller.GameController;
import org.academiadecodigo.felinux.controller.LoginController;
import org.academiadecodigo.felinux.model.client.Client;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    private static final int NUMBER_OF_THREADS = 4;
    private final ExecutorService threadPool;

    private HashMap<Integer, Client> clientMap = new HashMap<>();

    private ServerSocket serverSocket;

    GameController gameController;
    private Scanner scanner = new Scanner(System.in);

    public Server(int portNumber) throws IOException {

        serverSocket = new ServerSocket(portNumber);
        threadPool = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    }

    public void start() {

        int counter = 0;
        while (true) {

            try {

                System.out.println("Waiting to save someone's life.");
                Socket clientSocket = this.serverSocket.accept();
                System.out.println("Connected to IP: " + clientSocket.getInetAddress() + " at Port: " + clientSocket.getPort());
                ClientConnection clientConnection = new ClientConnection(clientSocket, counter);
                clientConnection.setGameController(gameController);
                threadPool.submit(clientConnection);

                clientMap.put(counter, new Client(counter));
                counter++;

            } catch (IOException exception) {

                exception.getStackTrace();

            }

        }

    }


    public HashMap<Integer, Client> getClientMap() {
        return clientMap;
    }

    public Client getClient(int id) {
        return clientMap.get(id);
    }

    public void setGameController(GameController gameController) {
        this.gameController = gameController;
    }

}
