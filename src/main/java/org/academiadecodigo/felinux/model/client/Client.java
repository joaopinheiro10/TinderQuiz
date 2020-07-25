package org.academiadecodigo.felinux.model.client;

public class Client {
    private String name;
    private int clientNumber;
    private int answerNumber;

    public String getName() {
        return name;
    }

    public int getClientNumber() {
        return clientNumber;
    }

    public int getAnswerNumber() {
        return answerNumber;
    }

    public void setName(String userInput) {
        name = userInput;
        System.out.println(name);
    }
}
