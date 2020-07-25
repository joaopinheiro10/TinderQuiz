package org.academiadecodigo.felinux.controller;

import org.academiadecodigo.felinux.service.GameService;
import org.academiadecodigo.felinux.view.View;

public abstract class AbstractController implements Controller {

    protected View view;
    protected GameService gameService;

    public void setView(View view) {
        this.view = view;
    }

    @Override
    public void execute () {
        view.show();
    }

    public void setGameService(GameService gameService) {
        this.gameService = gameService;
    }
}
