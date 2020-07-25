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

    private Client client = new Client();
    private GameController gameController;
    private InputStream inputStream;
    private PrintStream printStream;
    private Prompt prompt;
    private int id;


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


    public Bootstrap(int id, InputStream inputStream, PrintStream printStream, GameController gameController) {
        this.id = id;
        this.inputStream = inputStream;
        this.printStream = printStream;
        this.prompt = new Prompt(inputStream, printStream);
        this.gameController = gameController;
        wireLogin();
        wireMenu();
        wireRules();
        setupMenuMap();

        loginController.execute();
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

    }

    private void wireMenu() {
        menuView = new MenuView();
        menuController = new MenuController();
        loginController.setNextController(menuController);
        menuView.setMenuController(menuController);
        menuController.setView(menuView);
        menuView.setPrompt(prompt);
        menuView.setPrintStream(printStream);

    }

    private void wireRules() {

        rulesController = new RulesController();
        rulesView = new RulesView();
        rulesController.setView(rulesView);
        rulesView.setRulesController(rulesController);
        rulesView.setPrintStream(printStream);
        rulesView.setPrompt(prompt);
    }
    private void wireAnswer() {

        rulesController = new RulesController();
        rulesView = new RulesView();
        rulesController.setView(rulesView);
        rulesView.setRulesController(rulesController);
        rulesView.setPrintStream(printStream);
        rulesView.setPrompt(prompt);
    }
    private void wireWaiting() {

        rulesController = new RulesController();
        rulesView = new RulesView();
        rulesController.setView(rulesView);
        rulesView.setRulesController(rulesController);
        rulesView.setPrintStream(printStream);
        rulesView.setPrompt(prompt);
    }

    private void setupMenuMap() {
        Map<Integer, Controller> menuMap = new HashMap<>();
        menuMap.put(UserOptions.START_GAME.getOption(), gameController);
        menuMap.put(UserOptions.INSTRUCTIONS.getOption(), rulesController);

        menuController.setControllerMap(menuMap);
    }

    public WaitingController getWaitingController() {
        return waitingController;
    }

    public AnsweringController getAnsweringController() {
        return answeringController;
    }
}
