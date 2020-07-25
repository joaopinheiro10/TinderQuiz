package org.academiadecodigo.felinux.controller;
import org.academiadecodigo.felinux.view.View;

public abstract class AbstractController implements Controller {

    protected View view;
    protected GameController gameController;
    protected int id;

    public void setView(View view) {
        this.view = view;
    }

    @Override
    public void execute () {
        view.show();
    }

    public void setGameController(GameController gameController) {
        this.gameController = gameController;
    }

    public void setId(int id) {
        this.id = id;
    }

    public GameController getGameController() {
        return gameController;
    }
}
