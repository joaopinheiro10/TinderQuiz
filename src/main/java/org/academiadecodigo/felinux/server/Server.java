package org.academiadecodigo.felinux.server;


import org.academiadecodigo.felinux.controller.LoginController;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    private static final int NUMBER_OF_THREADS = 4;
    private final ExecutorService threadPool;

    private List<ClientConnection> clientConnectionList;
    private ServerSocket serverSocket;

    private Scanner scanner = new Scanner(System.in);

    public Server(int portNumber) throws IOException {

        serverSocket = new ServerSocket(portNumber);
        threadPool = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
        clientConnectionList = new LinkedList<>();

    }

    public void start(LoginController loginController) {

        while (true) {

            try {

                System.out.println("Waiting to save someone's life.");
                Socket clientSocket = this.serverSocket.accept();
                System.out.println("Connected to IP: " + clientSocket.getInetAddress() + " at Port: " + clientSocket.getPort());
                ClientConnection clientConnection = new ClientConnection(this, clientSocket);
                clientConnection.setController(loginController);
                clientConnectionList.add(clientConnection);
                threadPool.submit(clientConnection);

            } catch (IOException exception) {

                exception.getStackTrace();

            }

        }

    }

    public List<ClientConnection> getClientConnectionList() {
        return clientConnectionList;
    }
}
