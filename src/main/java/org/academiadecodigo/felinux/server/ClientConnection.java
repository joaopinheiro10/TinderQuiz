package org.academiadecodigo.felinux.server;

import org.academiadecodigo.felinux.controller.Controller;
import org.academiadecodigo.felinux.model.client.Client;

import java.net.Socket;

public class ClientConnection implements Runnable {

    private Socket socket;
    private Server server;
    private Client client;
    private Controller controller;


    @Override
    public void run() {

    }
}
