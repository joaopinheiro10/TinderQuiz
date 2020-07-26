package org.academiadecodigo.felinux.service;

import org.academiadecodigo.felinux.model.client.Client;
import org.academiadecodigo.felinux.server.Server;
import org.academiadecodigo.felinux.view.Quiz;

import java.util.LinkedList;

public class GameService {

    private Server server;
    private String currentQuestion;
    private int questionNumber;
    private int currentIdPlayer = 0;

    public GameService(Server server) {
        this.server = server;
    }

    public String generateQuestion() {
        questionNumber = (int) (Math.floor(Math.random() * Quiz.values().length));
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
            }

            if (client.getNumberOfCorrectAnswers() >= 6 ) {
                smart.add(client);
            }

            if (client.getNumberOfCorrectAnswers() >= 3 ) {
                average.add(client);
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
            currentIdPlayer = 0;
            return;
        }
        currentIdPlayer++;
    }

}
