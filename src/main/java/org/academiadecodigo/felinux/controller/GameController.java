package org.academiadecodigo.felinux.controller;

import org.academiadecodigo.felinux.Bootstrap;
import org.academiadecodigo.felinux.model.client.Client;
import org.academiadecodigo.felinux.server.Server;
import org.academiadecodigo.felinux.service.GameService;

import static org.academiadecodigo.felinux.service.GameService.NUMBER_OF_PLAYERS;
import static org.academiadecodigo.felinux.service.GameService.ROUND_NUMBERS;

import org.academiadecodigo.felinux.view.Colors;
import org.academiadecodigo.felinux.view.Messages;

import java.util.HashMap;
import java.util.LinkedList;

public class GameController implements Controller {

    private Server server;
    private String question;
    private GameService gameService;
    private final HashMap<Integer, Bootstrap> bootstrapMap = new HashMap<>();

    private int numPlayersReady = 0;

    private boolean lastAnswer;

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

        broadcastSearching();
        broadcastMatch(gameService.match());

        closeEverything();
    }


    private void closeEverything() {

        numPlayersReady = 0;

        gameService.resetCurrentRoundNumber();

        server.resetCounter();
        server.getClientMap().clear();

        for (Bootstrap bootstrap : bootstrapMap.values()) {
            bootstrap.closeSocket();
        }
        bootstrapMap.clear();
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
        for (int key : bootstrapMap.keySet()) {
            bootstrapMap.get(key).getBroadcastView().show(Colors.BLUE + gameService.getCurrentPlayer().getName() + Colors.NOCOLOR, lastAnswer);
        }
        gameService.upDateCurrentPlayer();
    }

    public void broadcastSearching() {
        for(Bootstrap bootstrap : bootstrapMap.values()) {
            bootstrap.getBroadcastView().showMatch(Messages.MATCH);
        }
    }

    private void broadcastMatch ( LinkedList<LinkedList<Client>> scoreLists ) {

        for (LinkedList<Client> scoreList : scoreLists) {

            if(scoreList.size() == 0) {
                continue;
            }
            if (scoreList.size() == 1) {
                if(scoreList == scoreLists.get(0)) {
                    bootstrapMap.get(scoreList.get(0).getId()).getBroadcastView().showMatch(Messages.NO_MATCH);
                    continue;
                }
                if(scoreList == scoreLists.get(1) || scoreList == scoreLists.get(2)) {
                    bootstrapMap.get(scoreList.get(0).getId()).getBroadcastView().showMatch(Messages.AVERAGE);
                    continue;
                }
                if(scoreList == scoreLists.get(3)) {
                    bootstrapMap.get(scoreList.get(0).getId()).getBroadcastView().showMatch(Messages.GENIUS);
                    continue;
                }
            }

            for (Client client : scoreList) {
                for (Client match : scoreList) {
                    if ( client.getId() == match.getId() ) {
                        continue;
                    }

                    String contact = match.getName() + " - " + match.getPhoneNumber() + "\n";
                    bootstrapMap.get(client.getId()).getBroadcastView().showMatch(contact);
                }
            }
        }
    }

    public boolean checkAnswer (String answer){
        sendAnswerToPlayers(answer);
        lastAnswer = gameService.checkAnswer(answer);
        return lastAnswer;
    }

    public void sendAnswerToPlayers(String answer){

        for (int key : bootstrapMap.keySet()) {

            if (key != gameService.getCurrentIdPlayer()) {
                bootstrapMap.get(key).getBroadcastView().answerLine(answer);
            }

        }

    }

    public void upDateResult ( boolean answer){
        gameService.getCurrentPlayer().updateScore(answer);
    }

    public String getCurrentPlayerName () {
        return gameService.getCurrentPlayer().getName();
    }

    public void addPlayerReady () {

        numPlayersReady++;

        if (numPlayersReady == NUMBER_OF_PLAYERS) {

            execute();
        }
    }

    public void removePlayer ( int id){

        removePlayerFromBootstrap(id);
        gameService.removePlayer(id);

    }

    private void removePlayerFromBootstrap ( int playerID){

        this.bootstrapMap.remove(playerID);

    }

    public int getRoundNumber () {
        return gameService.getCurrentRoundNumber();
    }



    public LinkedList<Client> getClients() {

        return server.getClients();
    }

    public void addClient(int id, Client client) {
        server.getClientMap().put(id, client);
    }
}



