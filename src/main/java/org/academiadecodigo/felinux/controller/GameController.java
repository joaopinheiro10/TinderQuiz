package org.academiadecodigo.felinux.controller;

import org.academiadecodigo.felinux.Bootstrap;
import org.academiadecodigo.felinux.model.client.Client;
import org.academiadecodigo.felinux.server.Server;
import org.academiadecodigo.felinux.service.GameService;
import static org.academiadecodigo.felinux.service.GameService.ROUND_NUMBERS;
import org.academiadecodigo.felinux.view.Colors;
import org.academiadecodigo.felinux.view.Messages;

import java.util.HashMap;
import java.util.LinkedList;

public class GameController implements Controller {

    private Server server;
    private String question;
    private GameService gameService;
    private HashMap<Integer, Bootstrap> bootstrapMap = new HashMap<>();

    private int numPlayersReady = 0;

    private boolean lastAnswer;


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

        while (gameService.getCurrentRoundNumber() <= ROUND_NUMBERS) {

            question = gameService.generateQuestion();
            whoAnswer();
            broadcast();
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
           bootstrapMap.get(key).getBroadcastView().show(Colors.BLUE + gameService.getCurrentPlayer().getName() + Colors.NOCOLOR, lastAnswer);
       }
       gameService.upDateCurrentPlayer();
    }

    private void broadcastMatch ( LinkedList<LinkedList<Client>> allMatch ) {

        for (LinkedList<Client> linkedList : allMatch) {

            if(linkedList.size() == 0) {
                continue;
            }

            if (linkedList.size() == 1) {
                if(linkedList == allMatch.get(0)) {
                    bootstrapMap.get(linkedList.get(0).getId()).getBroadcastView().showMatch(Messages.NO_MATCH);
                    continue;
                }

                if(linkedList == allMatch.get(1) || linkedList == allMatch.get(2)) {
                    bootstrapMap.get(linkedList.get(0).getId()).getBroadcastView().showMatch(Messages.AVERAGE);
                    continue;
                }

                if(linkedList == allMatch.get(3)) {
                    bootstrapMap.get(linkedList.get(0).getId()).getBroadcastView().showMatch(Messages.GENIUS);
                    continue;
                }
            }

            HashMap<Integer, Bootstrap> test = new HashMap<>();

            for(Client client : linkedList) {

                test.put(client.getId(), bootstrapMap.get(client.getId()));
            }

            for (Client client : linkedList) {

                String message = Messages.MATCH;

                for (Bootstrap bootstrap : test.values()) {

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
        sendAnswertoPlayers(answer);
        lastAnswer = gameService.checkAnswer(answer);
        return lastAnswer;
    }

    public void sendAnswertoPlayers(String answer) {

        for (int key : bootstrapMap.keySet()) {

            if (key != gameService.getCurrentIdPlayer()) {
                bootstrapMap.get(key).getBroadcastView().showMatch(answer);
            }

        }

    }

    public void upDateResult(boolean answer){
        gameService.getCurrentPlayer().updateScore(answer);
    }

    public String getCurrentPlayerName(){
       return gameService.getCurrentPlayer().getName();
    }

    public void addPlayerReady() {
        numPlayersReady++;
        if (numPlayersReady == 3) {
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

    public int getRoundNumber() {
        return gameService.getCurrentRoundNumber();
    }
}


