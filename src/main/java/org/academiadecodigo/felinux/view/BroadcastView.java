package org.academiadecodigo.felinux.view;

import org.academiadecodigo.felinux.controller.GameController;

public class BroadcastView extends AbstractView{

    private GameController gameController;

    public void setGameController(GameController gameController) {
        this.gameController = gameController;
    }

    @Override
    public void show() {
        printStream.println();
    }

    public void show(String name, boolean lastAnswer) {
        if (lastAnswer) {
            printStream.println(name + Messages.RIGHT);
        } else {
            printStream.println(name + Messages.WRONG);
        }
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void showMatch (String message ) {
        printStream.println(message);
    }

    public void answerLine(String message) {
        printStream.println(Colors.BLUE + gameController.getCurrentPlayerName() + Colors.NOCOLOR + Messages.ANSWER_WAS);
    }
}
