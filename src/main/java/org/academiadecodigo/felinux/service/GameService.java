package org.academiadecodigo.felinux.service;

import org.academiadecodigo.bootcamp.Prompt;
import org.academiadecodigo.felinux.model.client.Client;
import org.academiadecodigo.felinux.server.ClientConnection;
import org.academiadecodigo.felinux.server.Server;
import org.academiadecodigo.felinux.view.Quiz;

import java.util.LinkedList;

public class GameService {

    private Server server;
    private String currentQuestion;
    private int questionNumber;
    private  int currentPlayer = 0;

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

        if(answer.equals(Quiz.values()[questionNumber].getCorrectAnswer())){
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
    /**
     * Sends a message to all the clients connected
     * @param message string to send
     */
    public void broadcast(String message) {
/*
        LinkedList<ClientConnection> temp = server.getClientConnectionList();

        for(ClientConnection client: temp) {
            client.send(message);
        }*/
    }

    public String match() {
        return null;
    }

    public int getCurrentPlayer() {
        return currentPlayer;
    }
}
