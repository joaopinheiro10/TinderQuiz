package org.academiadecodigo.felinux.controller;

import org.academiadecodigo.felinux.Bootstrap;
import org.academiadecodigo.felinux.server.Server;
import org.academiadecodigo.felinux.service.GameService;

import java.util.HashMap;

public class GameController implements Controller {

    private Server server;
    private String question;
    private GameService gameService;
    private HashMap<Integer, Bootstrap> bootstrapMap = new HashMap<>();
    private boolean lastAnswer;


    public void changeName(int id, String name) {
        server.getClient(id).setName(name);
    }

    public void changePhoneNumber (int id, int phoneNumber ) {
        server.getClient(id).setPhoneNumber(phoneNumber);
    }

    public void setServer(Server server) {
        this.server = server;
        gameService = new GameService(server);
    }

    @Override
    public void execute() {
        question = gameService.generateQuestion();
        System.out.println(question);
        whoAnswer();
        broadcast();
        System.out.println("before loop");
        execute();
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
            System.out.println("Key: " + key + "|" + "current player: " + gameService.getCurrentIdPlayer());
            if (key != gameService.getCurrentIdPlayer()) {
                System.out.println("estou dentro do if");
                bootstrapMap.get(key).getWaitingController().execute();
            }
        }
        bootstrapMap.get(gameService.getCurrentIdPlayer()).getAnsweringController().execute();
    }

    /**
     * Sends a message to all the clients connected
     */
    private void broadcast() {
       for(int key : bootstrapMap.keySet()) {
           bootstrapMap.get(key).getBroadcastView().show(gameService.getCurrentPlayer().getName(), lastAnswer);
       }
       gameService.upDateCurrentPlayer();
    }

    public boolean checkAnswer(String answer){
        lastAnswer = gameService.checkAnswer(gameService.getCurrentIdPlayer(),answer);
        return lastAnswer;
    }

    public void upDateResult(boolean answer){
        gameService.getCurrentPlayer().updateScore(answer);
    }


}


