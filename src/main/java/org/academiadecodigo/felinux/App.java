package org.academiadecodigo.felinux;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.felinux.controller.LoginController;
import org.academiadecodigo.felinux.server.Server;
import org.academiadecodigo.felinux.view.LoginView;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
       /* ServerSocket socket = null;
        /*ServerSocket socket = null;
        try {
            socket = new ServerSocket(9000);
        } catch (IOException e) {
            e.printStackTrace();
        }
        PrintStream printStream;
        try {
            printStream = new PrintStream(socket.getOutputStream());
            Prompt prompt = new Prompt(socket.getInputStream(),printStream);
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        Server server = null;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Port: ");
        int port = Integer.parseInt(scanner.nextLine());

        try {

            server = new Server(port);
            LoginView loginView = new LoginView();
            LoginController  loginController = new LoginController();
            loginView.setServer(server);
            loginController.setView(loginView);
            loginView.setLoginController(loginController);
            //server.getClientConnectionList().get(0).setController(loginController);
            server.start(loginController);

        } catch (IOException exception){

            exception.getStackTrace();

        }
    }
}
