package org.academiadecodigo.felinux.controller;

import org.academiadecodigo.felinux.Bootstrap;
import org.academiadecodigo.felinux.model.client.Client;
import org.academiadecodigo.felinux.server.Server;
import org.academiadecodigo.felinux.service.GameService;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Set;

public class GameController implements Controller {

    private Server server;
    private String question;
    private GameService gameService;
    private HashMap<Integer, Bootstrap> bootstrapMap = new HashMap<>();

    private int numPlayersReady = 0;

    private boolean lastAnswer;
    private final int ROUND_NUMBER = 1;
    private int currentRoundNumber=0;


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

        while (currentRoundNumber<ROUND_NUMBER) {

            question = gameService.generateQuestion();
            whoAnswer();
            broadcast();
            currentRoundNumber++;
        }

        broadcastMatch(gameService.match());

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

    private void broadcastMatch ( LinkedList<Client> clients ) {
        String message = "YOU HAVE A MATCH WITH THE FOLLOWING PLAYERS: \n\n";

        for (Client client : clients) {
          message  +=  client.getName() + "-" + client.getPhoneNumber() + "\n";
        }

        for (int key : bootstrapMap.keySet()) {
            bootstrapMap.get(key).getBroadcastView().showMatch(message);
        }

    }

    public boolean checkAnswer(String answer){
        lastAnswer = gameService.checkAnswer(gameService.getCurrentIdPlayer(),answer);
        return lastAnswer;
    }

    public void upDateResult(boolean answer){
        gameService.getCurrentPlayer().updateScore(answer);
    }


    public void addPlayerReady() {
        numPlayersReady++;
        if (numPlayersReady == 2) { // REPLACE 2 WITH NUMBER OF PLAYERS
            execute();
        }
    }
}


