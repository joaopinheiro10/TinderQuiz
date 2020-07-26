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
            printStream.println(name + " " + Colors.GREEN + Messages.RIGHT + Colors.NOCOLOR);
        } else {
            printStream.println(name + " " + Colors.RED + Messages.WRONG + Colors.NOCOLOR);
        }
    }

    public void showMatch ( String message ) {
        printStream.println(message);
    }
}
