package org.academiadecodigo.felinux;

import org.academiadecodigo.felinux.controller.*;
import org.academiadecodigo.felinux.server.Server;
import java.io.IOException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Server server = null;
        GameController gameController = new GameController();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Port: ");
        int port = Integer.parseInt(scanner.nextLine());

        try {

            server = new Server(port);
            server.setGameController(gameController);
            gameController.setServer(server);
            server.start();

        } catch (IOException exception){

            exception.getStackTrace();

        }
    }
}
