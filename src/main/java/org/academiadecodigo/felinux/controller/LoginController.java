package org.academiadecodigo.felinux.controller;

import org.academiadecodigo.felinux.model.client.Client;

public class LoginController extends AbstractController {

    private Controller nextController;
    private Client client;

    public void setNextController ( Controller nextController ) {
        this.nextController = nextController;
    }

    @Override
    public void execute() {
        super.execute();
        nextController.execute();
    }

    public void setName(String userInput) {
        client.setName(userInput);
    }

    public void setPhoneNumber(String phoneNumber) {
        client.setPhoneNumber(phoneNumber);
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
