package org.academiadecodigo.felinux.controller;

import org.academiadecodigo.felinux.Bootstrap;
import org.academiadecodigo.felinux.model.client.Client;
import org.academiadecodigo.felinux.server.Server;
import org.academiadecodigo.felinux.service.GameService;

import java.util.HashMap;
import java.util.LinkedList;

public class GameController implements Controller {

    private Server server;
    private String question;
    private GameService gameService;
    private HashMap<Integer, Bootstrap> bootstrapMap = new HashMap<>();

    private int numPlayersReady = 0;

    private boolean lastAnswer;
    private final int ROUND_NUMBER = 10;
    private int currentRoundNumber=0;


    public void changeName(int id, String name) {
        server.getClient(id).setName(name);
    }

    public void changePhoneNumber (int id, String phoneNumber ) {
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
        for (int key : bootstrapMap.keySet()) {
            if (key != gameService.getCurrentIdPlayer()) {
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

    private void broadcastMatch ( LinkedList<LinkedList<Client>> allMatch ) {

        for (LinkedList<Client> linkedList : allMatch) {

            if (linkedList.size()<=1) {
                bootstrapMap.get(linkedList.get(0).getId()).getBroadcastView().showMatch("You have no matches! Loser.");
                continue;
            }

            for (Client client : linkedList) {

                String message = "YOU HAVE A MATCH WITH THE FOLLOWING PLAYERS: \n\n";
                for (Bootstrap bootstrap : bootstrapMap.values()) {

                    if ( client.getId() == bootstrap.getID() ) {
                        continue;
                    }

                    message += client.getName() + "-" + client.getPhoneNumber() + "\n";
                    bootstrap.getBroadcastView().showMatch(message);

                }


            }

        }


    }

    public boolean checkAnswer(String answer){
        lastAnswer = gameService.checkAnswer(answer);
        return lastAnswer;
    }

    public void upDateResult(boolean answer){
        gameService.getCurrentPlayer().updateScore(answer);
    }

    public String getCurrentPlayerName(){
       return gameService.getCurrentPlayer().getName();
    }


    public void addPlayerReady() {
        numPlayersReady++;
        if (numPlayersReady == 2) { // REPLACE 2 WITH NUMBER OF PLAYERS
            execute();
        }
    }

    public void removePlayer (int id) {

        removePlayerFromBootstrap(id);
        gameService.removePlayer(id);

    }


    private void removePlayerFromBootstrap(int playerID) {

        this.bootstrapMap.remove(playerID);

    }

}


