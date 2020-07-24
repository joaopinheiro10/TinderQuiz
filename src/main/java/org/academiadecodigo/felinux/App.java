package org.academiadecodigo.felinux;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.felinux.server.Server;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
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


        Scanner scanner = new Scanner(System.in);
        System.out.print("Port: ");
        int port = Integer.parseInt(scanner.nextLine());

        try {

            new Server(port).start();

        } catch (IOException exception) {

            exception.getStackTrace();

        }

    }


}
