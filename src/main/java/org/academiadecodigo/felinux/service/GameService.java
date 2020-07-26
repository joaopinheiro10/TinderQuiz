package org.academiadecodigo.felinux.service;

import org.academiadecodigo.felinux.controller.GameController;
import org.academiadecodigo.felinux.model.client.Client;
import org.academiadecodigo.felinux.server.Server;
import org.academiadecodigo.felinux.view.Quiz;

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

    public String match() {
        return null;
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
