package org.academiadecodigo.felinux;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.felinux.controller.*;
import org.academiadecodigo.felinux.model.client.Client;
import org.academiadecodigo.felinux.view.*;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

public class Bootstrap {

    private GameController gameController;
    private InputStream inputStream;
    private PrintStream printStream;
    private Prompt prompt;
    private int id;
    private Client client = new Client(id);

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

    private WelcomeView welcomeView;


    public Bootstrap(int id, InputStream inputStream, PrintStream printStream, GameController gameController) {
        this.id = id;
        this.inputStream = inputStream;
        this.printStream = printStream;
        this.prompt = new Prompt(inputStream, printStream);
        this.gameController = gameController;

        wireWelcome();
        wireLogin();
        wireMenu();
        wireRules();
        wireWaitForPlayers();
        setupMenuMap();
        wireWaiting();
        wireAnswer();
        wireBroadcast();

        gameController.addBootstrap(id,this);

        loginController.execute();
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
    }

    private void wireBroadcast() {
        broadcastView = new BroadcastView();
        broadcastView.setGameController(gameController);
        broadcastView.setPrompt(prompt);
        broadcastView.setPrintStream(printStream);
    }

    private void setupMenuMap() {
        Map<Integer, Controller> menuMap = new HashMap<>();
        menuMap.put(UserOptions.START_GAME.getOption(), waitForPlayersController);
        menuMap.put(UserOptions.INSTRUCTIONS.getOption(), rulesController);

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

    public int getID () {
        return this.id;
    }
}
