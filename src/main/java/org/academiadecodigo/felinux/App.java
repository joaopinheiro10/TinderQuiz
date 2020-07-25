package org.academiadecodigo.felinux;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.felinux.controller.*;
import org.academiadecodigo.felinux.server.Server;
import org.academiadecodigo.felinux.view.LoginView;
import org.academiadecodigo.felinux.view.MenuView;
import org.academiadecodigo.felinux.view.RulesView;
import org.academiadecodigo.felinux.view.UserOptions;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
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

            Prompt prompt = new Prompt(System.in, System.out);

            server = new Server(port);

            // setup login controller and view
            LoginView loginView = new LoginView();
            LoginController  loginController = new LoginController();
            loginView.setServer(server);
            loginController.setView(loginView);
            loginView.setLoginController(loginController);

            // setup menu controller and view
            MenuController menuController = new MenuController();
            MenuView menuView = new MenuView(); // TODO which prompt?
            menuView.setServer(server);
            //menuView.setPrompt(prompt);
            menuView.setMenuController(menuController);
            menuController.setView(menuView);
            loginController.setNextController(menuController);

            //instantiate game and rules controller to test
            GameController gameController = new GameController();
            RulesController rulesController = new RulesController();
            RulesView rulesView = new RulesView();
            rulesController.setView(rulesView);
            rulesView.setServer(server);
            rulesView.setRulesController(rulesController);

            //setup the menu controller map
            Map<Integer, Controller> menuMap = new HashMap<>();
            menuMap.put(UserOptions.START_GAME.getOption(), gameController);
            menuMap.put(UserOptions.INSTRUCTIONS.getOption(), rulesController);

            menuController.setControllerMap(menuMap);

            //server.getClientConnectionList().get(0).setController(loginController);
            server.start(loginController);

        } catch (IOException exception){

            exception.getStackTrace();

        }
    }
}
