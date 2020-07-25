package org.academiadecodigo.felinux.controller;

import org.academiadecodigo.felinux.service.GameService;

public class WaitingController extends AbstractController{

    /**
     * This property allows the waiting controller to broadcast messages to everyone
     */
    private GameService gameService;

    @Override
    public void execute() {

        view.show();

    }

    public void setGameService(GameService gameService) {
        this.gameService = gameService;
    }
}
