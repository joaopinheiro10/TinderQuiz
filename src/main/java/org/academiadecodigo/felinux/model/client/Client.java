package org.academiadecodigo.felinux.model.client;

public class Client {
    private String name;
    private String phoneNumber;
    private int numberOfCorrectAnswers;
    private final int id;

    public Client (int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getNumberOfCorrectAnswers() {
        return numberOfCorrectAnswers;
    }

    public void setName(String userInput) {
        name = userInput;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void updateScore(boolean isAnswer) {
        if (!isAnswer) {
            return;
        }
        this.numberOfCorrectAnswers++;
    }

    public int getId () {
        return id;
    }

    public void resetNumberOfCorrectAnswers() {
        numberOfCorrectAnswers = 0;
    }
}
