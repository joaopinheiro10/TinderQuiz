package org.academiadecodigo.felinux;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.felinux.controller.*;
import org.academiadecodigo.felinux.model.client.Client;
import org.academiadecodigo.felinux.view.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class Bootstrap {


    private final GameController gameController;
    private final Socket socket;
    private InputStream inputStream;
    private PrintStream printStream;
    private final Prompt prompt;

    private final int id;
    private final Client client;

    private LoginView loginView;
    private LoginController loginController;

    private MenuView menuView;
    private MenuController menuController;

    private RulesController rulesController;
    private RulesView rulesView;

    private AnsweringController answeringController;
    private AnsweringView answeringView;

    private WaitingController waitingController;
    private WaitingView waitingView;

    private WaitForPlayersController waitForPlayersController;
    private WaitForPlayersView waitForPlayersView;

    private BroadcastView broadcastView;

    private ScoreView scoreView;

    private WelcomeView welcomeView;


    private ExitController exitController;


    public Bootstrap(int id, Socket socket, GameController gameController) {

        this.id = id;
        this.socket = socket;

        createStreams();

        this.prompt = new Prompt(inputStream, printStream);
        this.gameController = gameController;

        this.client = new Client(id);

        wireWelcome();
        wireLogin();
        wireMenu();
        wireRules();
        wireWaitForPlayers();
        setupMenuMap();
        wireScore();
        wireWaiting();
        wireAnswer();
        wireBroadcast();
        wireExit();

        loginController.execute();
    }


    private void createStreams() {
        try {
            printStream = new PrintStream(socket.getOutputStream());
            inputStream = socket.getInputStream();
        } catch (IOException ioe) {
            System.err.println("Error: " + ioe.getMessage());
        }
    }

    public void closeSocket() {

        try {
            this.socket.close();
            System.out.println("socket closed!");
        } catch (IOException exception) {
            exception.getStackTrace();
        }

    }

    private void wireWelcome() {

        welcomeView = new WelcomeView();
        welcomeView.setPrintStream(printStream);
    }

    private void wireLogin() {

        loginView = new LoginView();
        loginController = new LoginController();
        loginController.setView(loginView);
        loginView.setLoginController(loginController);
        loginView.setPrompt(prompt);
        loginView.setPrintStream(printStream);
        loginController.setGameController(gameController);
        loginController.setId(id);
        loginController.setWelcomeView(welcomeView);
        loginController.setClient(client);

    }

    private void wireMenu() {
        menuView = new MenuView();
        menuController = new MenuController();
        loginController.setNextController(menuController);
        menuView.setMenuController(menuController);
        menuController.setView(menuView);
        menuView.setPrompt(prompt);
        menuView.setPrintStream(printStream);
        menuController.setWelcomeView(welcomeView);

    }

    private void wireRules() {

        rulesController = new RulesController();
        rulesView = new RulesView();
        rulesController.setView(rulesView);
        rulesView.setRulesController(rulesController);
        rulesView.setPrintStream(printStream);
        rulesView.setPrompt(prompt);
        rulesController.setNextController(menuController);
        rulesController.setWelcomeView(welcomeView);
    }

    private void wireWaitForPlayers() {

        waitForPlayersController = new WaitForPlayersController();
        waitForPlayersView = new WaitForPlayersView();
        waitForPlayersController.setView(waitForPlayersView);
        waitForPlayersView.setPrintStream(printStream);
        waitForPlayersController.setGameController(gameController);
        waitForPlayersController.setWelcomeView(welcomeView);
        waitForPlayersController.setId(id);
        waitForPlayersController.setBootstrap(this);
        waitForPlayersController.setClient(client);
    }

    private void wireScore() {

        scoreView = new ScoreView();
        scoreView.setPrintStream(printStream);
        scoreView.setGameController(gameController);
    }

    private void wireAnswer() {

        answeringController = new AnsweringController();
        answeringView = new AnsweringView();
        answeringController.setView(answeringView);
        answeringView.setAnsweringController(answeringController);
        answeringView.setPrompt(prompt);
        answeringView.setPrintStream(printStream);
        answeringController.setGameController(gameController);
        answeringController.setWelcomeView(welcomeView);
        answeringController.setScoreView(scoreView);
    }

    private void wireWaiting() {

        waitingController = new WaitingController();
        waitingView = new WaitingView();
        waitingController.setView(waitingView);
        waitingView.setWaitingController(waitingController);
        waitingView.setPrompt(prompt);
        waitingView.setPrintStream(printStream);
        waitingController.setGameController(gameController);
        waitingController.setWelcomeView(welcomeView);
        waitingController.setScoreView(scoreView);
    }

    private void wireBroadcast() {
        broadcastView = new BroadcastView();
        broadcastView.setGameController(gameController);
        broadcastView.setPrompt(prompt);
        broadcastView.setPrintStream(printStream);
    }

    private void wireExit() {

        exitController = new ExitController();
        exitController.setGameController(gameController);
        menuController.setExitController(exitController);
        exitController.setId(id);
        exitController.setBootstrap(this);

    }

    private void setupMenuMap() {
        Map<Integer, Controller> menuMap = new HashMap<>();
        menuMap.put(UserOptions.START_GAME.getOption(), waitForPlayersController);
        menuMap.put(UserOptions.INSTRUCTIONS.getOption(), rulesController);
        menuMap.put(UserOptions.EXIT.getOption(), exitController);

        menuController.setControllerMap(menuMap);
    }

    public WaitingController getWaitingController() {
        return waitingController;
    }

    public AnsweringController getAnsweringController() {
        return answeringController;
    }

    public BroadcastView getBroadcastView() {
        return broadcastView;
    }
}