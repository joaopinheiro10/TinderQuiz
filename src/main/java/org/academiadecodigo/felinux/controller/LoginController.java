package org.academiadecodigo.felinux.controller;

public class LoginController extends AbstractController {


    @Override
    public void execute() {
        view.show();
        nextController.execute();
    }

    public void setOK(String userInput) {
    }
}
