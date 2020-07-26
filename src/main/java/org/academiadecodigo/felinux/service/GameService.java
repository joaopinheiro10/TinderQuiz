package org.academiadecodigo.felinux.service;

import org.academiadecodigo.felinux.model.client.Client;
import org.academiadecodigo.felinux.server.Server;
import org.academiadecodigo.felinux.view.Quiz;

import java.util.HashSet;
import java.util.LinkedList;

public class GameService {

    public static final int ROUND_NUMBERS = 10;
    public int currentRoundNumber = 0;
    private Server server;
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
        currentQuestion = Quiz.values()[questionNumber].getQuestion();
        return currentQuestion;
    }

    public boolean checkAnswer(String answer) {

        return answer.equalsIgnoreCase(Quiz.values()[questionNumber].getCorrectAnswer());
    }

    public LinkedList<LinkedList<Client>> match() {

        LinkedList<Client> dumb = new LinkedList<>();
        LinkedList<Client> average = new LinkedList<>();
        LinkedList<Client> smart = new LinkedList<>();
        LinkedList<Client> genious = new LinkedList<>();

        LinkedList<LinkedList<Client>> allMatchesList = new LinkedList<>();

        for (Client client : server.getClientMap().values()) {

            if (client.getNumberOfCorrectAnswers() == 10 ) {
                genious.add(client);
                continue;
            }

            if (client.getNumberOfCorrectAnswers() >= 6 ) {
                smart.add(client);
                continue;
            }

            if (client.getNumberOfCorrectAnswers() >= 3 ) {
                average.add(client);
                continue;
            }

            if (client.getNumberOfCorrectAnswers() < 3 ) {
                dumb.add(client);
            }

        }

        allMatchesList.add(dumb);
        allMatchesList.add(average);
        allMatchesList.add(smart);
        allMatchesList.add(genious);

        return allMatchesList;

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
}
