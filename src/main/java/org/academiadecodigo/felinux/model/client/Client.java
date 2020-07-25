package org.academiadecodigo.felinux.model.client;

public class Client {
    private String name;
    private int phoneNumber;
    private int numberOfCorrectAnswers;

    public String getName() {
        return name;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public int getNumberOfCorrectAnswers() {
        return numberOfCorrectAnswers;
    }

    public void setName(String userInput) {
        name = userInput;
        System.out.println(name);
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void correctAnswer() {
        this.numberOfCorrectAnswers++;
    }
}
