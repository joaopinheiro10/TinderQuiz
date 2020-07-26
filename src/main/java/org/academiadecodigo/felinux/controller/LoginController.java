package org.academiadecodigo.felinux.controller;

public class LoginController extends AbstractController {

    private Controller nextController;

    public void setNextController ( Controller nextController ) {
        this.nextController = nextController;
    }

    @Override
    public void execute() {
        view.show();
        nextController.execute();
    }

    public void setName(String userInput) {
        gameController.changeName(id, userInput);
    }

    public void setPhoneNumber(String phoneNumber) {
        gameController.changePhoneNumber(id, phoneNumber);
    }

}
