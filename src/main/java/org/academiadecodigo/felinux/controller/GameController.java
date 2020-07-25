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

    }

    public String getQuestion() {
        return question;
    }

    public void addBootstrap(int id, Bootstrap bootstrap) {
        this.bootstrapMap.put(id, bootstrap);
    }

    public void whoAnswer() {
        for (int key : bootstrapMap.keySet()) {
            if (key != gameService.getCurrentPlayer()) {
                bootstrapMap.get(key).getWaitingController().execute();
            }
        }
        bootstrapMap.get(gameService.getCurrentPlayer()).getAnsweringController().execute();
    }
}


