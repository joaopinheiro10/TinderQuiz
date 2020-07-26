package org.academiadecodigo.felinux.view;

import org.academiadecodigo.felinux.controller.WaitingController;

public class WaitingView extends AbstractView {

    WaitingController waitingController;

    public void setWaitingController(WaitingController waitingController) {
        this.waitingController = waitingController;
    }

    @Override
    public void show() {

        printStream.println(Messages.CURRENT_ROUND + waitingController.getGameController().getRoundNumber());
        printStream.println(Colors.BLUE + waitingController.getGameController().getCurrentPlayerName() + Colors.NOCOLOR + Messages.WAITING);
        printStream.println(Messages.CURRENT_QUESTION + waitingController.getGameController().getQuestion());


    }

}
