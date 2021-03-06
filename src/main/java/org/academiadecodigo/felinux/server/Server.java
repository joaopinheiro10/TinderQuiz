package org.academiadecodigo.felinux.server;


import org.academiadecodigo.felinux.controller.GameController;
import org.academiadecodigo.felinux.model.client.Client;
import org.academiadecodigo.felinux.view.Messages;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    private static final int NUMBER_OF_THREADS = 20;
    private final ExecutorService threadPool;

    private final HashMap<Integer, Client> clientMap = new HashMap<>();

    private final ServerSocket serverSocket;

    private GameController gameController;

    private int counter = 0;

    public Server(int portNumber) throws IOException {

        serverSocket = new ServerSocket(portNumber);
        threadPool = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    }

    public void start() {

        while (true) {

            try {

                System.out.println(Messages.WAITINGCONNECTIONS);
                Socket clientSocket = this.serverSocket.accept();
                System.out.println(Messages.CONNECTED + clientSocket.getInetAddress() + Messages.PORT + clientSocket.getPort());
                ClientConnection clientConnection = new ClientConnection(clientSocket, counter);
                clientConnection.setGameController(gameController);
                threadPool.submit(clientConnection);

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

    public LinkedList<Client> getClients() {

        LinkedList<Client> clients = new LinkedList<>();
        clients.addAll(clientMap.values());

        return clients;
    }

    public void resetCounter() {
        counter = 0;
    }
}
