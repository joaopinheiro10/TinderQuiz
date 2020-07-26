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

    /*
        public Prompt getUserPrompt(int playerNumber) {
            return server.getClientConnectionList().get(playerNumber).getPrompt();
        }

        public void changeName(int playerNumber, String name) {
            server.getClientConnectionList().get(playerNumber).getClient().setName(name);
        }

        public void phoneNumber(int playerNumber, int phoneNumber) {
            server.getClientConnectionList().get(playerNumber).getClient().setPhoneNumber(phoneNumber);
        }
    */
    public String generateQuestion() {
        questionNumber = (int) (Math.floor(Math.random() * Quiz.values().length));
        currentQuestion = Quiz.values()[questionNumber].getQuestion();
        return currentQuestion;
    }

    //Missing the answer back to the client
    public boolean checkAnswer(int playerNumber, String answer) {

        if(answer.equalsIgnoreCase(Quiz.values()[questionNumber].getCorrectAnswer())){
         //   rightAnswer(playerNumber);
            return true;
        }
        return false;
    }
/*
    private void rightAnswer(int playerNumber) {
        server.getClientConnectionList().get(playerNumber).getClient().correctAnswer();
    }
*/

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

    public void removePlayer (int playerToRemove) {

        this.server.getClientMap().remove(playerToRemove);
        System.out.println("removi o player do client map, player nº " + playerToRemove);

    }
}
