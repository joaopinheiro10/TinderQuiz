package org.academiadecodigo.felinux.model.client;

public class Client {
    private String name;
    private String phoneNumber;
    private int numberOfCorrectAnswers;
    private int id;

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
        System.out.println(name);
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void updateScore(boolean isAnswer) {
        System.out.println("update");
        if (!isAnswer) {
            return;
        }
        this.numberOfCorrectAnswers++;
    }

    public int getId () {
        return id;
    }
}
