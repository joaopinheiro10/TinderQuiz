package org.academiadecodigo.felinux.service;

import org.academiadecodigo.felinux.model.client.Client;
import org.academiadecodigo.felinux.server.Server;
import org.academiadecodigo.felinux.view.Quiz;

import java.util.HashSet;
import java.util.LinkedList;

public class GameService {

    public static final int ROUND_NUMBERS = 5;
    public static final int NUMBER_OF_PLAYERS = 4;
    public int currentRoundNumber = 1;
    private final Server server;
    private String currentQuestion;
    private int questionNumber;
    private int currentIdPlayer = 0;
    private final HashSet<Integer> questionList = new HashSet<>();

    public GameService(Server server) {
        this.server = server;
    }

    public String generateQuestion() {

        questionNumber = (int) (Math.floor(Math.random() * Quiz.values().length));

        if (questionList.contains(questionNumber)) {
                generateQuestion();
        }

        questionList.add(questionNumber);

        if (questionList.size() == Quiz.values().length) {
            questionList.clear();
        }

        currentQuestion = Quiz.values()[questionNumber].getQuestion();
        return currentQuestion;
    }

    public boolean checkAnswer(String answer) {

        return (answer.equalsIgnoreCase(Quiz.values()[questionNumber].getCorrectAnswer()) || answer.equalsIgnoreCase("Jorge Martinez"));
    }

    public LinkedList<LinkedList<Client>> match() {

        LinkedList<Client> dumb = new LinkedList<>();
        LinkedList<Client> average = new LinkedList<>();
        LinkedList<Client> smart = new LinkedList<>();
        LinkedList<Client> genious = new LinkedList<>();

        LinkedList<LinkedList<Client>> allMatchesLists = new LinkedList<>();

        for (Client client : server.getClientMap().values()) {

            if (client.getNumberOfCorrectAnswers() == 5 ) {
                genious.add(client);
                continue;
            }

            if (client.getNumberOfCorrectAnswers() == 4) {
                smart.add(client);
                continue;
            }

            if (client.getNumberOfCorrectAnswers() >= 2 ) {
                average.add(client);
                continue;
            }

            if (client.getNumberOfCorrectAnswers() <= 1 ) {
                dumb.add(client);
            }

        }

        allMatchesLists.add(dumb);
        allMatchesLists.add(average);
        allMatchesLists.add(smart);
        allMatchesLists.add(genious);

        return allMatchesLists;

    }

    public int getCurrentIdPlayer() {
        return currentIdPlayer;
    }

    public Client getCurrentPlayer(){
        return server.getClient(currentIdPlayer);
    }

    public void upDateCurrentPlayer() {
        if((server.getClientMap().size() -1) == currentIdPlayer){
            currentRoundNumber++;
            currentIdPlayer = 0;
            return;
        }
        currentIdPlayer++;
    }

    public void removePlayer (int playerToRemove) {

        this.server.getClientMap().remove(playerToRemove);

    }

    public int getCurrentRoundNumber() {
        return currentRoundNumber;
    }

    public void resetCurrentRoundNumber() {
        currentRoundNumber = 0;
    }
}
