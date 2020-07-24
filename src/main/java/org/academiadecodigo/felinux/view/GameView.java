package org.academiadecodigo.felinux.view;

import org.academiadecodigo.felinux.controller.GameController;

public class GameView  extends AbstractView{

    GameController gameController;

    public void setGameController(GameController gameController) {
        this.gameController = gameController;
    }

    @Override
    public void show() {
    }
}
