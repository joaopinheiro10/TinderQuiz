package org.academiadecodigo.felinux.controller;

public class LoginController extends AbstractController {

    private Controller nextController;

    public void setNextController ( Controller nextController ) {
        this.nextController = nextController;
    }

    @Override
    public void execute() {
        view.show();
    }

    public void setOK(String userInput) {
    }
}
