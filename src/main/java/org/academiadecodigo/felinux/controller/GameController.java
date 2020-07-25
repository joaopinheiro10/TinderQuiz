package org.academiadecodigo.felinux.controller;

import org.academiadecodigo.felinux.Bootstrap;
import org.academiadecodigo.felinux.server.Server;
import org.academiadecodigo.felinux.service.GameService;

import java.util.HashMap;

public class GameController implements Controller {

    private Server server;
    private String question;
    private GameService gameService = new GameService();
    private HashMap<Integer, Bootstrap> bootstrapMap = new HashMap<>();


    public void changeName(int id, String name) {
        server.getClient(id).setName(name);
        System.out.println(name);
    }

    public void setServer(Server server) {
        this.server = server;
    }

    @Override
    public void execute() {
        question = gameService.generateQuestion();
        System.out.println(question);
        whoAnswer();

    }

    public String getQuestion() {
        return question;
    }

    public void addBootstrap(int id, Bootstrap bootstrap) {
        this.bootstrapMap.put(id, bootstrap);
    }

    public void whoAnswer() {
        System.out.println(bootstrapMap.size());
        for (int key : bootstrapMap.keySet()) {
            System.out.println("Key: " + key + "|" + "current player: " + gameService.getCurrentPlayer());
            if (key != gameService.getCurrentPlayer()) {
                System.out.println("estou dentro do if");
                bootstrapMap.get(key).getWaitingController().execute();
            }
        }
        System.out.println("estou aqui");
        System.out.println(gameService);
        System.out.println(gameService.getCurrentPlayer());
        System.out.println(bootstrapMap.get(gameService.getCurrentPlayer()).getAnsweringController());
        bootstrapMap.get(gameService.getCurrentPlayer()).getAnsweringController().execute();
    }
}


